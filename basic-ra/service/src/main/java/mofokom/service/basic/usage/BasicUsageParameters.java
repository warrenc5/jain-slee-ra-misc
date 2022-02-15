/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mofokom.service.basic.usage;

/**
 *
 * @author wozza
 */
public interface BasicUsageParameters {

    public void incrementSuccessfulURLCallbacks(long l) ;

    public void incrementUnsuccessfulURLCallbacks(long l);

    public void incrementAbortedURLCallbacks(long l);
}
