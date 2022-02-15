/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import junit.framework.Assert;
import org.junit.Ignore;
import mofokom.deadlock.DeadlockMain;
import uk.co.westhawk.snmp.util.pdu.GetNextPdu_vec;
import mofokom.slee.testfw.resource.MockResourceAdaptor;
import java.util.Observable;
import javax.slee.Address;
import javax.slee.resource.ActivityHandle;
import javax.slee.resource.FireableEventType;
import javax.slee.resource.ReceivableService;
import uk.co.westhawk.snmp.event.RawPduEvent;
import uk.co.westhawk.snmp.event.RequestPduEvent;
import uk.co.westhawk.snmp.event.TrapEvent;
import uk.co.westhawk.snmp.stack.Pdu;
import java.lang.reflect.InvocationTargetException;
import mofokom.in.snmp.resource.SNMPActivity;
import org.junit.Test;
import java.io.IOException;
import java.net.InetSocketAddress;
import javax.slee.resource.ConfigProperties;
import javax.slee.resource.ConfigProperties.Property;
import mofokom.in.snmp.resource.SNMPSbbInterface;
import mofokom.in.snmp.resource.impl.SNMPResourceAdaptor;
import mofokom.in.snmp.resource.impl.SNMPUsageParameters;
import org.junit.BeforeClass;
import uk.co.westhawk.snmp.stack.AsnObjectId;
import uk.co.westhawk.snmp.stack.AsnUnsInteger;
import uk.co.westhawk.snmp.stack.PduException;
import uk.co.westhawk.snmp.stack.TrapPduv2;
import uk.co.westhawk.snmp.stack.varbind;
import static org.mockito.Mockito.*;
/**
 *
 * @author wozza
 */
public class SNMPTest {

    static MockResourceAdaptor<SNMPResourceAdaptor,SNMPSbbInterface,SNMPUsageParameters> raMock;

    public SNMPTest() {
    }

    @BeforeClass
    public static void setupClass() throws Exception {
        DeadlockMain.deactivate();
        raMock = new MockResourceAdaptor<SNMPResourceAdaptor,SNMPSbbInterface,SNMPUsageParameters>(SNMPResourceAdaptor.class,SNMPUsageParameters.class) {
            @Override
            public void onAnyEvent(ActivityHandle handle, FireableEventType eventType, Object activity, Address address, ReceivableService service) {

            }
        };

        doCallRealMethod().when(raMock.getResourceAdaptor()).rawPduReceived(any(RawPduEvent.class));
        doCallRealMethod().when(raMock.getResourceAdaptor()).trapReceived(any(TrapEvent.class));
        doCallRealMethod().when(raMock.getResourceAdaptor()).requestPduReceived(any(RequestPduEvent.class));
        doCallRealMethod().when(raMock.getResourceAdaptor()).getSnmpContext();
        doCallRealMethod().when(raMock.getResourceAdaptor()).createPdu(any(Class.class));
        doCallRealMethod().when(raMock.getResourceAdaptor()).update(any(Observable.class), anyObject());


        ConfigProperties properties = raMock.getConfigProperties();
        properties.addProperty(new Property("WORK_QUEUE", Integer.class.getName(), new Integer(1)));
        properties.addProperty(new Property("POOL_SIZE", Integer.class.getName(), new Integer(3)));
        properties.addProperty(new Property("MAX_POOL_SIZE", Integer.class.getName(), new Integer(6)));
        properties.addProperty(new Property("POOL_TIMEOUT", Long.class.getName(), new Long(1000)));
        properties.addProperty(new Property("ACTIVITY_DIMENSION", Integer.class.getName(), 5));
        properties.addProperty(new Property("SNMP_CONTEXT_VERSION", Integer.class.getName(), 1));
        properties.addProperty(new Property("HOST", String.class.getName(), "localhost"));
        properties.addProperty(new Property("BIND_ADDRESS", String.class.getName(), "0.0.0.0"));
        properties.addProperty(new Property("PORT", Integer.class.getName(), 162));
        properties.addProperty(new Property("SOCKET_TYPE", String.class.getName(), "Standard"));
        properties.addProperty(new Property("OID", String.class.getName(), "1.1"));
        properties.addProperty(new Property("CONTEXT_ENGINE_ID", String.class.getName(), "010000a1d41e4946"));
        properties.addProperty(new Property("CONTEXT_NAME", String.class.getName(), "public"));
        properties.addProperty(new Property("USERNAME", String.class.getName(), "noAuthUser"));
        properties.addProperty(new Property("USER_AUTH_PASSWORD", String.class.getName(), ""));
        properties.addProperty(new Property("AUTH_PROTOCOL", String.class.getName(), "MD5"));
        properties.addProperty(new Property("PRIV_PROTOCOL", String.class.getName(), "DES"));
        properties.addProperty(new Property("USER_PRIV_PASSWORD", String.class.getName(), ""));
        properties.addProperty(new Property("USE_AUTHENTICATION", Boolean.class.getName(), false));
        properties.addProperty(new Property("USE_PRIVACY", Boolean.class.getName(), false));
        
        properties.addProperty(new Property("COMMUNITY", String.class.getName(), "public"));
        properties.addProperty(new Property("MAX_RECV_SIZE", Integer.class.getName(), 10000));
        properties.addProperty(new Property("LISTEN", Boolean.class.getName(), false));
        properties.addProperty(new Property("RETRY_INTERVALS", String.class.getName(), "1000"));

        raMock.start();
    }

    @Test
    @Ignore
    public void testUpSince() throws IOException, PduException {
        doCallRealMethod().when(raMock.getResourceAdaptor()).createUpSincePdu();
        doCallRealMethod().when(raMock.getResourceAdaptor()).sendPdu(any(Pdu.class));

        Pdu pdu = raMock.getSbbInterface().createUpSincePdu();
        Assert.assertNotNull(pdu);
        raMock.getSbbInterface().sendPdu(pdu);

        raMock.pause(2000L);
    }

    @Test
    public void testInterfaces() throws IOException, PduException {
        doCallRealMethod().when(raMock.getResourceAdaptor()).createInterfacePdu();
        doCallRealMethod().when(raMock.getResourceAdaptor()).sendPdu(any(Pdu.class),any(InetSocketAddress.class));

        Pdu pdu = raMock.getSbbInterface().createInterfacePdu();
        Assert.assertNotNull(pdu);
        raMock.getSbbInterface().sendPdu(pdu,new InetSocketAddress("localhost",161));

        raMock.pause(2000L);
    }


    @Test
    @Ignore
    public void testRA() throws IOException, PduException {
        TrapPduv2 pdu = raMock.getSbbInterface().createV3Trap();
        String sysUpTime = "1.3.6.1.2.1.1.3.0";
        String snmpTrapOID = "1.3.6.1.6.3.1.1.4.1.0";

        String warmStart = "1.3.6.1.6.3.1.1.5.2";

        pdu.addOid(sysUpTime, new AsnUnsInteger(5));
        pdu.addOid(snmpTrapOID, new AsnObjectId(warmStart));

        SNMPActivity sendPdu = raMock.getSbbInterface().sendPdu(pdu);
    }


    @Test
    @Ignore
    public void testRA3() throws IOException, PduException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {

        GetNextPdu_vec pdu = new GetNextPdu_vec(raMock.getSbbInterface().getSnmpContext(), 1);

        String oid = "1.1";

        varbind vb = new varbind(oid);
        pdu.addOid(vb);

        SNMPActivity sendPdu = raMock.getSbbInterface().sendPdu(pdu);
        raMock.pause(3000L);
    }

    /*
    @Test
    @Ignore
    public void testRA2() throws IOException, PduException {
        String oid1 = "1.1";
        SnmpContextBasisFace snmpContext = raMock.getSbbInterface().getSnmpContext();
        BlockPdu pdu = new BlockPdu(snmpContext) {
            
        };
        pdu.setPduType(BlockPdu.GETNEXT);
       
        pdu.addOid(oid1);
        boolean running = true;
        try {
            while (running) {
                try {
                    Thread.sleep(2000L);
                } catch (InterruptedException ex) {
                }
                varbind var = pdu.getResponseVariableBinding();
                if (pdu.getErrorStatus() == AsnObject.SNMP_ERR_NOERROR) {
                    AsnObject obj = var.getValue();
                    if (obj != null
                            && obj.getRespType() != AsnObject.SNMP_VAR_ENDOFMIBVIEW) {
                        AsnObjectId oid = var.getOid();
                        System.out.println(var.toString());
                        pdu = new BlockPdu(snmpContext);
                        pdu.setPduType(BlockPdu.GETNEXT);
                        pdu.addOid(oid.toString());
                    } else
                        running = false;
                } else
                    running = false;
            }
        } catch (PduException exc) {
            exc.printStackTrace();
            System.out.println("!!PduException: " + exc.getMessage());
            running = false;
        } catch (java.io.IOException exc) {
            exc.printStackTrace();
            System.out.println("!!IOException: " + exc.getMessage());
            running = false;
        }
    }
     *
     */
}
