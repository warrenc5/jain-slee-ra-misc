package sap;

import javax.sdp.SessionDescription;

public interface Announcement
{
   public SessionDescription getSessionDescription();
   public boolean isDeletion();
}
