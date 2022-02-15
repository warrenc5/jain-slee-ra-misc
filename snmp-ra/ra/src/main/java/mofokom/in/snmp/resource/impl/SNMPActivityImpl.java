/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mofokom.in.snmp.resource.impl;

import java.io.Serializable;
import mofokom.in.snmp.resource.SNMPActivity;
import mofokom.resource.common.AbstractSynchronousTransaction;
import uk.co.westhawk.snmp.stack.Pdu;

/**
 *
 * @author wozza
 */
public class SNMPActivityImpl extends AbstractSynchronousTransaction<Pdu, Serializable,Pdu> implements SNMPActivity<Pdu> {

    public SNMPActivityImpl(Pdu attachment, int ra, int seq) {
        super(attachment, ra, seq);
    }

    @Override
    public Pdu getPdu() {
        return this.getAttachment();
    }

}