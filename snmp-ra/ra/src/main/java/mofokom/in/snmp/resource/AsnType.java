/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mofokom.in.snmp.resource;

import uk.co.westhawk.snmp.stack.SnmpConstants;

/**
 *
 * @author wozza
 */
public enum AsnType {

    ASN_OCTET_STR(SnmpConstants.ASN_OCTET_STR),
    ASN_IP_ADDRESS(SnmpConstants.IPADDRESS),
    ASN_OPAQUE(SnmpConstants.OPAQUE),
    SNMP_VAR_NOSUCHOBJECT(SnmpConstants.SNMP_VAR_NOSUCHOBJECT),
    SNMP_VAR_NOSUCHINSTANCE(SnmpConstants.SNMP_VAR_NOSUCHINSTANCE),
    SNMP_VAR_ENDOFMIBVIEW(SnmpConstants.SNMP_VAR_ENDOFMIBVIEW),
    TIMETICKS(SnmpConstants.TIMETICKS),
    COUNTER(SnmpConstants.COUNTER),
    GUAGE(SnmpConstants.GAUGE),;
    private byte b;

    AsnType(byte b) {
        this.b = b;
    }

    public byte byteValue() {
        return b;
    }
}
