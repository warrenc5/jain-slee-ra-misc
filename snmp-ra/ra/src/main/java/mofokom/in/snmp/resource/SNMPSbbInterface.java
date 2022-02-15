package mofokom.in.snmp.resource;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.math.BigInteger;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.Calendar;
import uk.co.westhawk.snmp.stack.DiscoveryPdu;
import uk.co.westhawk.snmp.stack.AsnInteger;
import uk.co.westhawk.snmp.stack.AsnNull;
import uk.co.westhawk.snmp.stack.AsnObjectId;
import uk.co.westhawk.snmp.stack.AsnOctets;
import uk.co.westhawk.snmp.stack.AsnPrimitive;
import uk.co.westhawk.snmp.stack.AsnUnsInteger;
import uk.co.westhawk.snmp.stack.AsnUnsInteger64;
import uk.co.westhawk.snmp.stack.GetBulkPdu;
import uk.co.westhawk.snmp.stack.GetNextPdu;
import uk.co.westhawk.snmp.stack.GetPdu;
import uk.co.westhawk.snmp.stack.InformPdu;
import uk.co.westhawk.snmp.stack.InterfacePdu;
import uk.co.westhawk.snmp.stack.MultiResponsePdu;
import uk.co.westhawk.snmp.stack.Pdu;
import uk.co.westhawk.snmp.stack.PduException;
import uk.co.westhawk.snmp.stack.ReportPdu;
import uk.co.westhawk.snmp.stack.ResponsePdu;
import uk.co.westhawk.snmp.stack.SetPdu;
import uk.co.westhawk.snmp.stack.SnmpContextBasisFace;
import uk.co.westhawk.snmp.stack.TrapPduv1;
import uk.co.westhawk.snmp.stack.TrapPduv2;
import uk.co.westhawk.snmp.stack.UpSincePdu;

/**
 *
 * The RA is based on the WestHawk SNMP stack.
 * 
 * @see {@link <a href="http://snmp.westhawk.co.uk/faq.html#information">WestHawk SNMP Stack</a>
 * @author wozza
 */

public interface SNMPSbbInterface {

    /**
     * Creates a V1PduTrap on the current V1 Context
     * @see TrapPduv1
     * @param enterprise
     * @param specificTrap
     * @return
     */
    TrapPduv1 createV1PduTrap(String enterprise, int specificTrap);

    /**
     * Creates a V2PduTrap on the current V2 Context
     * @see TrapPduv2
     * @return
     */
    TrapPduv2 createV2Trap();

    /**
     * Creates a V2PduTrap on the current V3 Context
     * @see TrapPduv2
     *
     * @return
     */
    TrapPduv2 createV3Trap();

    /**
     * Creates an Inform Pdu on the current context
     *
     * @see InformPdu
     * @return
     */
    InformPdu createInformPdu();

    /**
     * Creates a Discovery Pdu on the current context
     *
     * @see DiscoveryPdu
     * @return
     */
    DiscoveryPdu createDiscoveryPdu();

    /**
     * Creates a GetBulk Pdu on the current context
     *
     * @see GetBulkPdu
     * @param nonRepeaters
     * @param maxRepititions
     * @return
     */
    GetBulkPdu createGetBulkPdu(int nonRepeaters, int maxRepititions);

    /**
     * Creates a V2PduTrap on the current context
     *
     * @see GetNextPdu
     *
     * @return
     */
    GetNextPdu createGetNextPdu();

    /**
     * Creates a GetNext Pdu on the current context with response variable bindings
     *
     * @see GetNextPdu
     *
     * @param varBindings
     * @return
     */
    GetNextPdu createGetNextPdu(int varBindings);

    /**
     * Creates a V2PduTrap on the current context
     *
     * @see GetPdu
     *
     * @return
     */
    GetPdu createGetPdu();

    /**
     * Creates a Get Pdu on the current context with response variable bindings
     *
     * @see GetPdu
     * @param varBindings
     * @return
     */
    GetPdu createGetPdu(int varBindings);

    /**
     * Creates a Inform Pdu on the current context with response variable bindings
     *
     * @see InformPdu
     * @param varBindings
     * @return
     */
    InformPdu createInformPdu(int varBindings);

    /**
     * Creates a Report Pdu on the current context with response variable bindings
     *
     * @set MultiResponsePdu
     * @return
     */
    MultiResponsePdu createReportPdu();

    /**
     * Creates a Report Pdu on the current context
     *
     * @set ReportPdu
     * @param request
     * @return
     */
    ReportPdu createReportPdu(Pdu request);

    /**
     * Creates a Response on the request context
     *
     * @set ResponsePdu
     * @param request
     * @return
     */
    ResponsePdu createResponsePdu(Pdu request);

    /**
     * Creates a Set Pdu on the current context
     *
     * @set SetPdu
     * @return
     */
    SetPdu createSetPdu();

    /**
     * Creates a Set Pdu on the current context with response variable bindings
     *
     * @set SetPdu
     * @param varBindings
     * @return
     */
    SetPdu createSetPdu(int varBindings);

    /**
     * Creates a UpSince Pdu on the current context 
     *
     * @set UpSincePdu
     * @return
     */
    UpSincePdu createUpSincePdu() throws PduException;


    /**
     * Creates an Interface Pdu on the current context
     *
     * @set InterfacePdu
     * @return
     */
    InterfacePdu createInterfacePdu() throws PduException;


    /**
     *
     * @see Pdu
     *
     * @param pduClass
     * @return
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws IllegalArgumentException
     * @throws InvocationTargetException
     */
    Pdu createPdu(Class<? extends Pdu> pduClass) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;

    /**
     * Registers an observer with the Pdu and enqueues it for sending on the current context
     * @param pdu
     * @return
     */
    SNMPActivity sendPdu(Pdu pdu);

    SNMPActivity sendPdu(Pdu pdu,InetSocketAddress address) throws IOException;

    /**
     *
     * @return the current context
     */
    SnmpContextBasisFace getSnmpContext() ;

    /**
     *
     * @param type SNMP_VAR_NOSUCHOBJECT, SNMP_VAR_NOSUCHINSTANCE, SNMP_VAR_ENDOFMIBVIEW
     * @return
     */
    AsnPrimitive createAsn(AsnType type);

    /**
     *
     * @param value
     * @return
     */
    AsnInteger createAsnInteger(int value);

    /**
     *
     * @return
     */
    AsnNull createAsnNull();

    /**
     *
     * @param oid
     * @return
     */
    AsnObjectId createAsnObjectId(String oid);

    /**
     *
     * @param oid
     * @return
     */
    AsnObjectId createAsnObjectId(long[] oid);

    /**
     *
     * @param calendar
     * @return
     */
    AsnOctets createAsnOctets(Calendar calendar);

    /**
     *
     * @param address
     * @param type ASN_OCTET_STR IP_ADDRESS OPAQUE
     * @return
     */
    AsnOctets createAsnOctets(Inet4Address address, AsnType type);

    /**
     *
     * @param address
     * @return
     */
    AsnOctets createAsnOctets(InetAddress address);

    /**
     * 
     * @param value
     * @return
     */
    AsnOctets createAsnOctets(String value);

    /**
     *
     * @param value
     * @return
     */
    AsnOctets createAsnOctets(byte[] value);

    /**
     *
     * @param value
     * @param type ASN_OCTET_STR, IP_ADDRESS, OPAQUE.
     * @return
     */
    AsnOctets createAsnOctets(byte[] value, AsnType type);

    /**
     *
     * @param value
     * @return
     */
    AsnOctets createAsnOctets(char[] value);

    /**
     *
     * @param value
     * @return
     */
    AsnUnsInteger createAsnUnsInteger(long value);

    /**
     *
     * @param value
     * @param type TIMETICKS, COUNTER, GAUGE.
     * @return
     */
    AsnUnsInteger createAsnUnsInteger(long value, AsnType type);

    /**
     *
     * @param value
     * @return
     */
    AsnUnsInteger64 createAsnUnsInteger64(BigInteger value);
}