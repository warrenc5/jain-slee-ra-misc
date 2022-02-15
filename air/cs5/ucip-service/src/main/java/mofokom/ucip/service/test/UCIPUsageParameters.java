/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mofokom.ucip.service.test;

/**
 *
 * @author wozza
 */
public interface UCIPUsageParameters {

    public void incrementFailedCount(long l);
    public void incrementSuccessCount(long l);
    public void sampleLatency(long l);
    public void sampleFailedLatency(long l);


}
