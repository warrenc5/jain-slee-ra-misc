/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mofokom.in.mgcp.resource;

import jain.protocol.ip.mgcp.JainMgcpEvent;
import jain.protocol.ip.mgcp.pkg.MgcpEvent;
import jain.protocol.ip.mgcp.pkg.PackageName;
import javax.sdp.SdpParseException;
import javax.sdp.SessionDescription;

/**
 *
 * @author wozza
 */
public interface MGCPResourceAdaptorInterface {

    public void sendMgcpEvents(JainMgcpEvent... jainMgcpEvents) throws java.lang.IllegalArgumentException;

    public java.lang.String getProtocolVersion();

    public PackageName packageNameFactory(java.lang.String packageName);

    public PackageName packageNameFactory(java.lang.String packageName, int packageValue) throws java.lang.IllegalArgumentException;

    public MgcpEvent mgcpEventFactory(java.lang.String eventName);

    public MgcpEvent mgcpEventFactory(java.lang.String eventName, int eventValue) throws java.lang.IllegalArgumentException;

    public int getCurrentLargestPackageValue();

    public int getCurrentLargestEventValue();

    public SessionDescription createSessionDescription(String sessionDescription) throws SdpParseException ;
}
