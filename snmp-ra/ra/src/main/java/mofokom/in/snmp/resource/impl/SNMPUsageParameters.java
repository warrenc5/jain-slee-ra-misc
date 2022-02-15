/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mofokom.in.snmp.resource.impl;

import mofokom.resource.common.UsageParameters;

/**
 *
 * @author wozza
 */
public interface SNMPUsageParameters extends UsageParameters {

    public void incrementPduTxOK(long l);
    public void incrementPduRx(long l);
    public void incrementPduTxNOK(long l);

}
