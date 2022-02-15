package mofokom.sap.io;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.log4j.Logger;
import org.apache.log4j.Level;

import sap.Announcement;

public class Stack
{

    /** Field bitRateLimit  */
    protected long bitRateLimit;
    private int retransmitMinDelay;

    /** Field address  */
    protected InetAddress address;

    /** Field localAddress  */
    protected InetAddress localAddress;
    /** Field multicastPort  */
    protected int multicastPort;
    /** Field loopbackEnabled  */
    protected boolean loopbackEnabled;

    /** Field datagramBufferLength  */
    protected int datagramBufferLength;
    protected byte TTL=1;
    /** Field state  */
    private State state;
    /** Field handlerThread  */
    private Thread handlerThread;
    /** Field handler  */
    private AbstractHandler handler;
    /** Field listeners  */
    private final List<Listener> listeners = new ArrayList(1);
    private Logger log;

    private int maximumCancellationRetransmits;
    /**
     * Method isLoopbackEnabled returns the loopbackEnabled of this Stack object.
     *
     * @return the loopbackEnabled (type boolean) of this Stack object.
     */
    public boolean isLoopbackEnabled()
    {
        return loopbackEnabled;
    }

    /** Field cumulativeRetransmitSize  */
    long cumulativeRetransmitSize;

    /**
     * Constructor Stack creates a new Stack instance.
     *
     * @param address of type InetAddress
     * @throws IllegalArgumentException when
     * @throws UnknownHostException when
     */
    protected Stack() throws UnknownHostException{
        this.multicastPort = DEFAULT_PORT;
        this.datagramBufferLength = DEFAULT_MTU;
        this.bitRateLimit = DEFAULT_BITRATE; // 4Kb/s
        this.localAddress = InetAddress.getLocalHost();
        this.log=Logger.getLogger(this.getClass().getName());
        state=State.STOPPED;
    }

    public Stack(final InetAddress address) throws IllegalArgumentException, UnknownHostException
    {
        this(address, DEFAULT_PORT, false);
    }

    /**
     * Constructor Stack creates a new Stack instance.
     *
     * @param address of type InetAddress
     * @param loopbackEnabled of type boolean
     * @throws IllegalArgumentException when
     * @throws UnknownHostException when
     */
    public Stack(final InetAddress address,final boolean loopbackEnabled) throws IllegalArgumentException, UnknownHostException
    {
        this(address, DEFAULT_PORT, loopbackEnabled);
    }

    /**
     * Constructor Stack creates a new Stack instance.
     *
     * @param address of type InetAddress
     * @param multicastPort of type int
     * @param loopbackEnabled of type boolean
     * @throws IllegalArgumentException when
     * @throws UnknownHostException when
     */
    public Stack(final InetAddress address,final int multicastPort,final boolean loopbackEnabled) throws IllegalArgumentException, UnknownHostException
    {
        this(address, multicastPort, loopbackEnabled, InetAddress.getLocalHost());
    }

    /**
     * Constructor Stack creates a new Stack instance.
     *
     * @param address of type InetAddress
     * @param multicastPort of type int
     * @param loopbackEnabled of type boolean
     * @param home of type InetAddress
     * @throws IllegalArgumentException when
     * @throws UnknownHostException when
     */
    public Stack(final InetAddress address,final int multicastPort,final boolean loopbackEnabled,final InetAddress home) throws IllegalArgumentException, UnknownHostException
    {
        this();
        this.address = address;
        this.multicastPort = multicastPort;
        this.loopbackEnabled = loopbackEnabled;

        if(home==null)
            throw new NullPointerException("No LocalAddress sepcified");
            //home=InetAddress.getLocalHost()

        this.localAddress = home;
    }

    /**
     * Starts the stack
     *
     * @throws IllegalStateException
     * @throws IOException
     */
    public void start() throws IllegalStateException, IOException
    {
        if (!State.STOPPED.equals(state))
        {
            throw new IllegalStateException("Stack is already running");
        }

        handlerThread = new Thread(handler = new Handler(Stack.this));
        state=transition(State.STARTING);

        handlerThread.setDaemon(true);

        handlerThread.start();

    }

    /**
     * Method stop ...
     * @throws IllegalStateException when
     * @throws IOException when
     */
    public void stop() throws IllegalStateException, IOException
    {

        if (State.STOPPED.equals(state))
        {
            throw new IllegalStateException("Stack is not running");
        }

        state=transition(State.STOPPED);

        if (handler != null)
        {
            handler.teardown();
        }

        handlerThread = null;
        handler = null;


    }

    /**
     * Method addListener ...
     *
     * @param listener of type Listener
     */
    public void addListener(final Listener listener)
    {
        listeners.add(listener);
    }

    /**
     * Method send ...
     *
     * @param struct of type Struct
     * @return int
     * @throws IOException when
     */
    public synchronized int send(final Struct struct) throws IOException
    {

        if (!State.RUNNING.equals(state))
        {
            throw new IllegalStateException("Stack is not running");
        }

        final byte[] data = handler.encodeBuffer(struct);

        final int sent = handler.send(data, 0, data.length);

        if (struct.getMessageType() == 0)
        {
            cumulativeRetransmitSize += data.length;
        } else if( cumulativeRetransmitSize >0)
        {
            cumulativeRetransmitSize -= data.length;
        }
        

        if(struct.getMessageType()==0)
            notifyListenersMessageTimer(calculateTimer(), struct);
        else
            if(struct.transmits()>=maximumCancellationRetransmits)
                notifyListenersClearMessagesTimer(struct);

        return sent;
    }

    /**
     * This method is only used for testing
     *
     * @param data
     * @param offset
     * @param length
     * @throws IllegalArgumentException
     */
    public void receive(final byte[] data,final int offset,final int length) throws IllegalArgumentException
    {
        handler.decodeBuffer(data, offset, length);
    }

    /**
     * This is a message factory hook
     *
     * @param version
     * @param addressType
     * @param reserved
     * @param messageType
     * @param encrypted
     * @param compressed
     * @param authenticationLength
     * @param messageIdHash
     * @param originatingSource
     * @param authenticationData
     * @param payloadType
     * @param payload
     * @return
     * @throws IOException
     */
    public Struct createStruct(final Announcement announcement,final byte version, final byte addressType, final byte reserved, final byte messageType, final boolean encrypted, final boolean compressed, final int authenticationLength, final int messageIdHash, final byte[] originatingSource, final byte[] authenticationData, final String payloadType, final byte[] payload) throws IllegalArgumentException
    {
        return new StructImpl(version,addressType,reserved,messageType,encrypted,compressed,authenticationLength,messageIdHash,originatingSource,authenticationData,payloadType,payload);
    }

    /**
     * Method getState returns the state of this Stack object.
     *
     * @return the state (type int) of this Stack object.
     */
    public State getState()
    {
        return state;
    }

    public State transition(State state) throws IllegalStateException {
    
        if (log.isEnabledFor(Level.INFO))
        {
            log.info("stack transitioned from:" + this.state + " to:"+state); 
        }
        return (this.state=state);
    }

    /**
     * Method getAddress returns the address of this Stack object.
     *
     * @return the address (type InetAddress) of this Stack object.
     */
    public InetAddress getAddress()
    {
        return address;
    }

    /**
     * Method getMulticastPort returns the multicastPort of this Stack object.
     *
     * @return the multicastPort (type int) of this Stack object.
     */
    public int getMulticastPort()
    {
        return multicastPort;
    }

    /**
     * Method getTTL returns the TTL of this Stack object.
     *
     * @return the TTL (type int) of this Stack object.
     */
    public byte getTTL()
    {
        return TTL;
    }

    /**
     * Method setTTL sets the TTL of this Stack object.
     *
     * @param TTL the TTL of this Stack object.
     *
     */
    public void setTTL(final byte TTL)
    {
        this.TTL = TTL;
    }

    /**
     * Method getDatagramBufferLength returns the datagramBufferLength of this Stack object.
     *
     * @return the datagramBufferLength (type int) of this Stack object.
     */
    public int getDatagramBufferLength()
    {
        return datagramBufferLength;
    }

    /**
     * Method setDatagramBufferLength sets the datagramBufferLength of this Stack object.
     *
     * @param datagramBufferLength the datagramBufferLength of this Stack object.
     *
     */
    public void setDatagramBufferLength(final int datagramBufferLength)
    {
        this.datagramBufferLength = datagramBufferLength;
    }

    /**
     * Method getBitRateLimit returns the bitRateLimit of this Stack object.
     *
     * @return the bitRateLimit (type long) of this Stack object.
     */
    public long getBitRateLimit()
    {
        return bitRateLimit;
    }

    /**
     * Method setBitRateLimit sets the bitRateLimit of this Stack object.
     *
     * @param bitRateLimit the bitRateLimit of this Stack object.
     *
     */
    public void setBitRateLimit(final long bitRateLimit)
    {
        this.bitRateLimit = bitRateLimit;
    }

    /**
     * Method getLocalAddress returns the localAddress of this Stack object.
     *
     * @return the localAddress (type InetAddress) of this Stack object.
     */
    public InetAddress getLocalAddress()
    {
        return localAddress;
    }
    
    public void setRetransmitMinDelay(int retransmitMinDelay){
        this.retransmitMinDelay=retransmitMinDelay;
    }

    public int getRetransmitMinDelay(){
        return retransmitMinDelay;
    }

    public void setMaximumCancellationRetransmits(int maximumCancellationRetransmits){
        this.maximumCancellationRetransmits=maximumCancellationRetransmits;
    }

    public int getMaximumCancellationRetransmits(){
        return maximumCancellationRetransmits;
    }

    /**
     * Method notifyListenersMessageReceived ...
     *
     * @param origAddress of type InetAddress
     * @param message of type Struct
     */
    void notifyListenersMessageReceived(final InetAddress origAddress,final Struct message)
    {
        for (final Iterator<Listener> i = listeners.iterator(); i.hasNext();)
        {
            i.next().messageReceived(origAddress, message);
        }
    }

    /**
     * Method notifyListenersMessageTimer ...
     *
     * @param time of type long
     * @param message of type Struct
     */
    void notifyListenersMessageTimer(long time, Struct message)
    {
        for (final Iterator<Listener> i = listeners.iterator(); i.hasNext();)
        {
            i.next().setMessageTimer(time, message);
        }
    }

    private void notifyListenersClearMessagesTimer(final Struct message)
    {
        for (final Iterator<Listener> i = listeners.iterator(); i.hasNext();)
        {
            i.next().clearTimer(message);
        }
    }

    /**
     * Method calculateTimer ...
     * @return long
     */
    private long calculateTimer()
    {
        final long interval = Math.max(retransmitMinDelay, (8 * cumulativeRetransmitSize) / bitRateLimit);
        final long offset = Math.round(Math.random() * (interval * 2 / 3)) - (interval / 3);
        return interval + offset;
    }

    public void resetCumulativeRetransmitSize(){
        cumulativeRetransmitSize=0;
    }
    public long getCumulativeRetransmitSize(){
        return cumulativeRetransmitSize;
    }

    public enum State { STOPPED, STARTING, RUNNING; }

    /** Field DEFAULT_MTU  */
    public static final int DEFAULT_MTU = 1500;
    /** Field DEFAULT_BITRATE  */
    public static final int DEFAULT_BITRATE = 4000;
    /** Field DEFAULT_PORT  */
    public static final int DEFAULT_PORT = 9875;
}
