package mofokom.sap.io;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.MulticastSocket;
import java.net.SocketException;
import org.apache.log4j.Level;

public class Handler extends AbstractHandler
{

    /** Field socket  */
    private MulticastSocket socket;

    /**
     * @see AbstractSAPHandler#AbstractSAPHandler(Stack)
     */
    Handler(Stack stack)
    {
        super(stack);
    }

    /**
     * I continually block until a message arrives, then I process it.
     * I probably should process the datagram in the main Stack thread using a concurrent queue.
     * However it will do until performance requirement mitigate this.
     */
    public void run()
    {

        byte[] buf = new byte[stack.getDatagramBufferLength()];

        DatagramPacket datagram = new DatagramPacket(buf, buf.length);
        try{
            initialize();
        }catch(Exception x){
            log.error("error" , x);
        }
        while (stack.getState() == Stack.State.RUNNING)
        {
            if (log.isEnabledFor(Level.DEBUG))
            {
                log.debug("in receive loop");
            }
            /**
             *
             * blocking operation
             *
             * **/
            try
            {

                if (log.isEnabledFor(Level.DEBUG))
                {
                    log.debug("datagram packet received");
                }

                socket.receive(datagram);
                Struct struct=decodeBuffer(datagram.getData(),0,datagram.getLength());

                stack.notifyListenersMessageReceived(datagram.getAddress(), struct);

            } catch (SocketException xS)
            {
                //perhaps socket was closed by stack.stop?
                xS.printStackTrace();

            } catch (IOException xIO)
            {

                xIO.printStackTrace();

            }

            Thread.yield();
        }

        if (log.isEnabledFor(Level.DEBUG))
        {
            log.debug("out receive loop");
        }
        datagram = null;

    }

    /**
     * @see AbstractSAPHandler#initialize()
     */
    void initialize() throws IOException
    {
        log.info("connecting to address : " + stack.getAddress() + " from " + stack.getLocalAddress() + " port: " + stack.getMulticastPort() + " loopback enabled:" + stack.isLoopbackEnabled());

        socket = new MulticastSocket(stack.getMulticastPort());
        socket.setLoopbackMode(stack.isLoopbackEnabled());

        socket.setReuseAddress(true);
        
        socket.setInterface(stack.getLocalAddress());
        socket.setNetworkInterface(java.net.NetworkInterface.getByInetAddress(stack.getLocalAddress()));

        socket.joinGroup(new java.net.InetSocketAddress(stack.getAddress(),stack.getMulticastPort()) ,java.net.NetworkInterface.getByInetAddress(stack.getLocalAddress()));
        socket.setTimeToLive(stack.getTTL());

        stack.transition(Stack.State.RUNNING);
        if (log.isEnabledFor(Level.INFO))
        {
            log.info("channel connected to address : " + socket.getRemoteSocketAddress());
        }

        if (log.isEnabledFor(Level.INFO))
        {
            //log.info("isMulticastSocket " + socket.getInetAddress().isMulticastAddress());
        }
    }

    /**
     * @see AbstractSAPHandler#teardown()
     */
    void teardown() throws IOException
    {
        socket.leaveGroup(stack.getAddress());
        socket.close();
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
        //TODO: disassemble packet fragments here

        if (buf.length > stack.getDatagramBufferLength())
        {
            throw new UnsupportedOperationException("Packet fragmentation not supported buf:" + buf.length + ", MTU:" + stack.getDatagramBufferLength());
        }

        DatagramPacket packet = new DatagramPacket(buf, buf.length, stack.getAddress(), stack.getMulticastPort());
        log.info("send "+buf.length + " " + stack.getTTL());
        socket.send(packet,(byte)1);

        return buf.length;
    }


}
