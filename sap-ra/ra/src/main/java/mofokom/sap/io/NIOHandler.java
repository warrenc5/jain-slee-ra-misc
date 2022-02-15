package mofokom.sap.io;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedSelectorException;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.Arrays;
import java.util.Iterator;
import static mofokom.sap.io.Stack.State;

import org.apache.log4j.Level;

/**
 * Interface NIOHandler ...
 *
 * @author <a href="mailto:wcr@newtec.eu">Warren Crossing</a>
 * Created on Mar 19, 2007
 */
class NIOHandler extends AbstractHandler
{

    /** Field channel  */ /** Field rchannel  */
    private DatagramChannel channel, rchannel;
    /** Field socket  */
    private DatagramSocket socket;

    /** Field selector  */
    private Selector selector;
    private boolean teardown;

    /**
     * @see AbstractSAPHandler#AbstractSAPHandler(Stack)
     */
    NIOHandler(Stack stack)
    {
        super(stack);
    }

    /**
     * I dont block until a message arrives, then I process it.
     * I probably should process the datagram in the main Stack thread using a concurrent queue.
     * However it will do until performace requirement mitigate this.
     */
    public void run()
    {

        while (loopForConnection())
        {

            if (log.isEnabledFor(Level.DEBUG))
            {
                log.debug("selecting");
            }

            try
            {
                selector.select();
            } catch (IOException x)
            {
                x.printStackTrace();
            } catch (ClosedSelectorException xCS)
            {
                xCS.printStackTrace();
                break;
            }


            if (log.isEnabledFor(Level.DEBUG))
            {
                log.debug("selected");
            }

            for (final Iterator i = selector.selectedKeys().iterator(); i.hasNext();)
            {

                final SelectionKey sk = (SelectionKey) i.next();

                if (!(sk.isAcceptable() | sk.isReadable()))
                {
                    continue;
                }

                if (log.isEnabledFor(Level.DEBUG))
                {
                    log.debug("receiving");
                }

                i.remove();

                final Handle h = (Handle) sk.attachment();

                if (h == null)
                {
                    if (log.isEnabledFor(Level.WARN))
                    {
                        log.warn("handler is null");
                    }
                    continue;
                }

                try
                {
                    h.handle(sk);
                } catch (Exception x)
                {
                    if (log.isEnabledFor(Level.WARN))
                    {
                        log.warn("handle failed with " + x.getClass().getName() + " " + x.getMessage());
                    }
                    log.error("",x);
                }
            }
            Thread.yield();
        }
        log.debug("handler loop exited");

    }

    /**
     * @see AbstractSAPHandler#initialize()
     */
    void initialize() throws IOException
    {

        teardown=false;

        if (log.isEnabledFor(Level.INFO))
        {
            log.info("channel initialization started");
        }

        selector = Selector.open();

        channel = DatagramChannel.open();
        channel.configureBlocking(false);

        socket = channel.socket();
        socket.bind(new InetSocketAddress(stack.getLocalAddress(), stack.getMulticastPort()));
        socket.setReuseAddress(true);

        if (log.isEnabledFor(Level.INFO))
        {
            log.info("socket address : " + socket.getLocalSocketAddress());
        }

        // use different selector for selectable writing

        channel.register(selector, SelectionKey.OP_READ, new Handle());

        if (log.isEnabledFor(Level.INFO))
        {
            log.info("channel socket registered");
        }

        channel.connect(new InetSocketAddress(stack.getAddress(), stack.getMulticastPort()));

        if (log.isEnabledFor(Level.INFO))
        {
            log.info("channel connected to address : " + socket.getRemoteSocketAddress());
        }

        if (log.isEnabledFor(Level.INFO))
        {
            log.info("isMulticastSocket " + channel.socket().getInetAddress().isMulticastAddress());
        }
    
    }

    /**
     * @see AbstractSAPHandler#teardown()
     */
    void teardown() throws IOException
    {

        teardown=true;

        if (channel != null && channel.isOpen())
        {
            channel.close();
        }

        if (socket != null && socket.isConnected())
        {
            socket.close();
        }

        if (selector != null && selector.isOpen())
        {
            selector.close();
        }

        if (log.isEnabledFor(Level.INFO))
        {
            log.info("left multicast group and socket closed");
        }
    }


    /**
     * @see AbstractSAPHandler#send(byte[],int,int)
     */
    int send(byte[] buf, int offset, int length) throws UnsupportedOperationException, IOException
    {

        if(!loopForConnection())
            throw new IOException("could not send, invalid stack state");
        //TODO: disassemble packet fragments here

        if (buf.length > stack.getDatagramBufferLength())
        {
            throw new UnsupportedOperationException("Packet fragmentation not supported buf:" + buf.length + ", mtu:" + stack.getDatagramBufferLength());
        }

        ByteBuffer buffy;

        buffy = ByteBuffer.wrap(buf, offset, length);

        if (log.isEnabledFor(Level.DEBUG))
        {
            log.debug("sending : " + Arrays.toString(buf) + " to:" + socket.getRemoteSocketAddress());
        }

        return channel.send(buffy, channel.socket().getRemoteSocketAddress());

    }
    
    private boolean loopForConnection(){
        
        //HACK: check conditional
        while((channel==null || !channel.isConnected()) && !teardown ){
            try{
                initialize();
                stack.transition(State.RUNNING);
                return true;
            }catch(Exception x){
                log.warn("error initializing stack ",x);
                try{
                    Thread.currentThread().sleep(10000L);
                }catch(Exception xN){}
            }
        }

        if(stack.getState().equals(State.STOPPED))
            return false;
        else 
            return true;
    }
    /**
     * Classes used for incomming SAP
     */
    class Handle
    {
        /**
         * Constructor Handle creates a new Handle instance.
         */
        Handle()
        {
        }

        /**
         * Method handle ...
         *
         * @param sk of type SelectionKey
         * @throws IOException when
         */
        public void handle(SelectionKey sk) throws IOException
        {

            final ByteBuffer buffy = ByteBuffer.allocateDirect(stack.getDatagramBufferLength());

            final SocketAddress address = ((DatagramChannel)sk.channel()).receive(buffy);

            if (log.isEnabledFor(Level.DEBUG))
            {
                log.debug("handle received :" + buffy.position());
            }

            final byte[] data = new byte[buffy.position()];

            //HACK: must rewind
            buffy.rewind();

            buffy.get(data, 0, data.length);

            if (log.isEnabledFor(Level.DEBUG))
            {
                log.debug(Arrays.toString(data));
            }

            final Struct struct = decodeBuffer(data, 0, data.length);

            stack.notifyListenersMessageReceived(((InetSocketAddress) address).getAddress(), struct);
        }
    }
}

