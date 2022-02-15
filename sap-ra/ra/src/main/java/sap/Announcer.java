package sap;

import java.io.IOException;
import javax.sdp.SessionDescription;
import javax.sdp.SdpParseException;

/**

The main provider interface from the RA type 

<pre>
    try{
      Announcer provider = (Announcer)new InitialContext().lookup("java:comp/env/slee/resources/sap/1.0.0/sap");
      provider.sessionDeletion(event.getSessionDescription()); 
    }catch(NamingException xN){
      xN.printStackTrace();
    }catch(IOException xIO){
      xIO.printStackTrace();
    }catch(SdpException xS){
      xS.printStackTrace();
    }
</pre>

*/

public interface Announcer 
{

    /*
    *
    * Continually transmits announcement until it is deleted, event fired on new or exisiting activity
    *
    */
    public void sessionAnnouncement(final SessionDescription session) throws IOException, SdpParseException;

    /*
    *
    * Updates an announcement, event fired on existing activity  
    *
    */
    public void sessionUpdate(final SessionDescription session) throws IOException, SdpParseException;


    /*
    *
    * Deletes an announcement, event fired on existing activity  
    *
    */
    public void sessionDeletion(final SessionDescription session) throws IOException, SdpParseException;

}
