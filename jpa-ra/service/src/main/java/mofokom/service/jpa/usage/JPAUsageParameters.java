/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mofokom.service.jpa.usage;

/**
 *
 * @author wozza
 */
public interface JPAUsageParameters {

    public void incrementJPASelects(long l) ;

    public void incrementJPAUpdates(long l);

    public void incrementJPAInserts(long l);

    public void incrementJPARollbacks(long l);
}
