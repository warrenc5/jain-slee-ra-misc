/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mofokom.service.mlp.usage;

/**
 *
 * @author wozza
 */
public interface MLPUsageParameters {

    public void incrementMLPSelects(long l) ;

    public void incrementMLPUpdates(long l);

    public void incrementMLPInserts(long l);

    public void incrementMLPRollbacks(long l);
}
