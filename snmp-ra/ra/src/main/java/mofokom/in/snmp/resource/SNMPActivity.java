/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mofokom.in.snmp.resource;

import java.util.concurrent.Future;
import uk.co.westhawk.snmp.stack.Pdu;

/**
 *
 * @author wozza
 */
public interface SNMPActivity<Pdu> {

    public Pdu getPdu();
    public Future<Pdu> getSynchronousResult() ;

}
