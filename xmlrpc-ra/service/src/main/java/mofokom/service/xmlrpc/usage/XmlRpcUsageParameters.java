/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mofokom.service.xmlrpc.usage;

/**
 *
 * @author wozza
 */
public interface XmlRpcUsageParameters {

    public void incrementSuccessfulURLCallbacks(long l) ;

    public void incrementUnsuccessfulURLCallbacks(long l);

    public void incrementAbortedURLCallbacks(long l);
}
