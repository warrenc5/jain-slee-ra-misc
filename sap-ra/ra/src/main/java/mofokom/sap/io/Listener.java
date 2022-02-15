package mofokom.sap.io;

import java.net.InetAddress;

public interface Listener
{

    /**
     * Method messageReceived ...
     *
     * @param origAddress of type InetAddress
     * @param message of type Struct
     */
    public void messageReceived(InetAddress origAddress, Struct message);

    /**
     * Method setMessageTimer ...
     *
     * @param time of type long
     * @param message of type Struct
     */
    public void setMessageTimer(long time, Struct message);
    
    public void clearTimer( Struct message);
}
