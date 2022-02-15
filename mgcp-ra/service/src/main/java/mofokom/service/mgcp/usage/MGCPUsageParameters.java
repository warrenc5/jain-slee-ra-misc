/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mofokom.service.mgcp.usage;

/**
 *
 * @author wozza
 */
public interface MGCPUsageParameters {

    public void incrementSuccessfulURLCallbacks(long l) ;

    public void incrementUnsuccessfulURLCallbacks(long l);

    public void incrementAbortedURLCallbacks(long l);
}
