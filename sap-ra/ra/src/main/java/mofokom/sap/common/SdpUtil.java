package mofokom.sap.common;

import org.apache.log4j.Logger;

import java.util.Vector;
import java.util.Date;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import javax.sdp.MediaDescription;
import javax.sdp.SessionDescription;
import javax.sdp.BandWidth;
import javax.sdp.Connection;
import javax.sdp.Media;
import javax.sdp.Origin;
import javax.sdp.SessionName;
import javax.sdp.TimeDescription;
import javax.sdp.Time;
import javax.sdp.SdpException;
import javax.sdp.SdpFactory;
import javax.sdp.Info;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class SdpUtil {

    static {
        factory = SdpFactory.getInstance();
    }
    private static SdpFactory factory;
   
    //
    // origin = o = SIT Tx
    public static SessionDescription createSessionDescription() throws SdpException{
        return factory.createSessionDescription();
    }

    public static void addInfo(SessionDescription session,String info) throws SdpException{
        Info i = factory.createInfo(info);
        session.setInfo(i);
    }
    public static void addOrigin(SessionDescription session, String username,InetAddress externalAddress) throws SdpException{
        long sessionId = generate2ByteSessionId(externalAddress);
        Origin o = factory.createOrigin(username, sessionId,1, "UDP", "IP4", externalAddress.getHostAddress());
        session.setOrigin(o);

        SessionName s = factory.createSessionName(Long.toString(sessionId));//getSessionNameString(id,usecase));
        session.setSessionName(s);
    }
    
    
    public static SessionName getSessionName(String id){
        return factory.createSessionName(id );
    }

    public static String toSessionNameString(SessionName name) throws SdpException{
        return name.getValue().toString().trim();
    }

    public static String getOriginAddress(SessionDescription session) throws SdpException{
        return session.getOrigin().getAddress().toString();
    }
    public static String getConnectionAddress(SessionDescription session) throws SdpException{
        return session.getConnection().getAddress().toString();
    }

    public static Integer getMediaPort(SessionDescription session) throws SdpException{
        Media m = getFirstMedia(session);
        return m.getMediaPort();
    }

    public static long generate2ByteSessionId(InetAddress address){

        long value=new Date().getTime();
        try{
            //TODO: only in java 6
            //NetworkInterface nif=NetworkInterface.getByInetAddress(address);
            //byte[] mac=nif.getHardwareAddress();
            byte[] mac=address.getAddress();
            
            long lmac = 
                Math.abs(mac[3]) << 8 +  
                Math.abs(mac[2]) << 8 +
                Math.abs(mac[1]) << 8 +
                Math.abs(mac[0]);

            //System.out.println(">"+value + " " + lmac + "=" + (value ^ lmac));
            return value ^ lmac ;

        }catch(Exception x){
        }

        return value;
    }

    public static void addBandwidth(SessionDescription session,int bandwidth) throws SdpException{  
        BandWidth bw=factory.createBandwidth("AS",bandwidth);
        Vector v=new Vector();
        v.addElement(bw);
        session.setBandwidths(v);
        //session.setBandwidth("AS",bandwidth);
    }

    //BUG : only 1 time description supported by buggy code
    public static void addTimeDescription(SessionDescription session,Date start,Date end) throws SdpException { 
        if(start==null && end==null)
            return;

        Vector<TimeDescription> td = new Vector();
        TimeDescription tf = factory.createTimeDescription(start,end);
        td.add(tf);
        session.setTimeDescriptions(td);
    }
    
    public static void addTime(SessionDescription session,Time time) throws SdpException { 
        
        Vector<TimeDescription> td = new Vector();
        TimeDescription tf = factory.createTimeDescription(time);
        td.add(tf);
        session.setTimeDescriptions(td);
    }
    
    private static final String UNDEFINED_ADDRESS="0.0.0.0";
    private static final String UDP="UDP";

    public static MediaDescription addMediaDescription(SessionDescription session,String mediaType,InetSocketAddress address) throws SdpException { 
        MediaDescription md = factory.createMediaDescription(mediaType,address==null?0:address.getPort(),0,UDP,new int[]{});

        Vector<MediaDescription> medias = session.getMediaDescriptions(true);
        medias.add(md);
        //new Vector<MediaDescription>();
        //session.setMediaDescriptions(medias);
        return md;
    }

    public static InetSocketAddress getSocketAddress(SessionDescription session,MediaDescription md) throws SdpException {
        Media media=md.getMedia();

        String host=getOriginAddress(session);

        Integer port=media.getMediaPort();

        return new InetSocketAddress(host,port);
    }

    public static InetSocketAddress[] getSocketAddresses(SessionDescription session) throws SdpException {
        Vector<MediaDescription> medias = session.getMediaDescriptions(true);
        List list=new ArrayList();

        for(Iterator i =medias.iterator();i.hasNext();){
            MediaDescription md = (MediaDescription)i.next(); 
            Media media=md.getMedia();


            String host=getOriginAddress(session);

            Integer port=media.getMediaPort();
            
            list.add(new InetSocketAddress(host,port));
        }
        return (InetSocketAddress[])list.toArray(new InetSocketAddress[list.size()]); 
    }
    public static void addConnection(SessionDescription session,InetAddress address) throws SdpException{
        Connection c = factory.createConnection("UDP",Connection.IP4,address==null?UNDEFINED_ADDRESS:address.getHostAddress());
        session.setConnection(c);
    }

    public static Time getFirstTime(SessionDescription session) throws SdpException {
        Vector<TimeDescription> times = session.getTimeDescriptions(false);            

        if(times.size()==0)
            return null;

        return times.get(0).getTime();                        
    }

    public static String getSessionName(SessionDescription session) throws SdpException {
        return toSessionNameString(session.getSessionName());
    }

    public static MediaDescription getFirstMediaDescription(SessionDescription session) throws SdpException{
        Vector medias = session.getMediaDescriptions(false);
        return (MediaDescription) medias.get(0);
    }

    public static Media getFirstMedia(SessionDescription session) throws SdpException{
        return (Media)getFirstMediaDescription(session).getMedia();
    }
    public static Integer getFirstBandwidth(SessionDescription session) throws SdpException{
        Vector b = session.getBandwidths(false);
        return ((BandWidth)(b.get(0))).getValue();
    }
}
