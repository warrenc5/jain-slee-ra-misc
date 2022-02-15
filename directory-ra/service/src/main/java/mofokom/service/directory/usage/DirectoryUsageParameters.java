/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mofokom.service.directory.usage;

/**
 *
 * @author wozza
 */
public interface DirectoryUsageParameters {

    public void incrementSuccessfulURLCallbacks(long l) ;

    public void incrementUnsuccessfulURLCallbacks(long l);

    public void incrementAbortedURLCallbacks(long l);
}
