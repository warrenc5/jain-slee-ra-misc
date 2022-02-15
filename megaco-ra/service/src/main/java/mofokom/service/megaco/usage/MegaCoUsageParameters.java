/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mofokom.service.megaco.usage;

/**
 *
 * @author wozza
 */
public interface MegaCoUsageParameters {

    public void incrementSuccessfulURLCallbacks(long l) ;

    public void incrementUnsuccessfulURLCallbacks(long l);

    public void incrementAbortedURLCallbacks(long l);
}
