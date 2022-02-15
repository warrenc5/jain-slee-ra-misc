/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mofokom.service.ussd.usage;

/**
 *
 * @author wozza
 */
public interface USSDUsageParameters {

    public void incrementSuccessfulURLCallbacks(long l) ;

    public void incrementUnsuccessfulURLCallbacks(long l);

    public void incrementAbortedURLCallbacks(long l);
}
