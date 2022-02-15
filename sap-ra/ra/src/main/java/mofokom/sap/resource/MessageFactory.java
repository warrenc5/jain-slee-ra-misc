package mofokom.sap.resource;

import sap.Announcement;

import javax.sdp.SessionDescription;
import javax.sdp.SdpParseException;

public interface MessageFactory
{
    /**
     * Method createAnnouncement ...
     *
     * @param sdp of type SessionDescription
     * @return Announcement
     * @throws SdpParseException when
     */
    Announcement createAnnouncement(SessionDescription sdp) throws SdpParseException;
    /**
     * Method createDeletion ...
     *
     * @param sdp of type SessionDescription
     * @return Announcement
     * @throws SdpParseException when
     */
    Announcement createDeletion(SessionDescription sdp) throws SdpParseException;
    /**
     * Method createUpdate ...
     *
     * @param sdp of type SessionDescription
     * @return Announcement
     * @throws SdpParseException when
     */
    Announcement createUpdate(SessionDescription sdp) throws SdpParseException;
}
