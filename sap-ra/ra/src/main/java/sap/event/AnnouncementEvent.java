package sap.event;

import javax.sdp.SessionDescription;
import javax.sdp.SessionName;

public class AnnouncementEvent {

  private SessionDescription session; 
  private boolean isDeletion, isNew;

  public AnnouncementEvent(SessionDescription session,boolean isDeletion,boolean isNew){
    this(session);
    this.isDeletion=isDeletion;
    this.isNew=isNew;
  }
  public AnnouncementEvent(SessionDescription session){
    this.session=session;
  }
  
  public SessionName getSessionName(){
    return session.getSessionName();
  }
  public SessionDescription getSessionDescription(){
    return session;
  }
  public boolean isDeletion(){
    return isDeletion;
  }
  /*
  * @returns if the stack already knew this announcement before it dispatched the event, ie. a received retransmission
  */
  public boolean isNew(){
    return isNew;
  }

}
