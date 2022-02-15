/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.megaco.InvalidArgumentException;
import javax.megaco.association.CreateAssocReq;
import javax.megaco.pkg.AnalogLineSPkg.AnalogLineSFlashEvt;
import org.junit.Test;
import mofokom.megaco.resource.impl.MegaCoResourceAdaptor;
import javax.slee.facilities.Tracer;
import javax.slee.resource.ConfigProperties;
import mofokom.megaco.resource.MegaCoActivityContextInterfaceFactory;
import mofokom.megaco.resource.MegaCoResourceAdaptorInterface;
import mofokom.megaco.resource.impl.MegaCoResourceAdaptorUsageParameters;
import mofokom.megaco.resource.impl.codec.ABNFProtocolDecoder;
import mofokom.megaco.resource.impl.codec.ABNFProtocolEncoder;
import mofokom.slee.testfw.resource.MockResourceAdaptor;
import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.filterchain.IoFilter.NextFilter;
import org.apache.mina.core.future.WriteFuture;
import org.apache.mina.core.service.TransportMetadata;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolDecoderOutput;
import org.apache.mina.filter.codec.ProtocolEncoderOutput;
import static org.junit.Assert.*;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import static org.mockito.Mockito.*;

/**
 *
 * @author wozza
 */
public class CodecTest {

    static Tracer tracer;
    private static Object out;
    static IoBuffer buffer;
    private static ABNFProtocolDecoder decoder;
    private static ABNFProtocolEncoder encoder;
    private static IoSession session;
    private static ProtocolEncoderOutput po;
    private static ProtocolDecoderOutput pod;

    public CodecTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        session = mock(IoSession.class);
        TransportMetadata tmd = mock(TransportMetadata.class);
        doReturn(tmd).when(session).getTransportMetadata();
        doReturn(false).when(tmd).hasFragmentation();

        decoder = new ABNFProtocolDecoder(session);
        encoder = new ABNFProtocolEncoder(session);

        po = new ProtocolEncoderOutput() {

            @Override
            public void write(Object encodedMessage) {
                assertNotNull(encodedMessage);
                setEncodedObject(encodedMessage);
            }

            @Override
            public void mergeAll() {
            }

            @Override
            public WriteFuture flush() {
                return null;
            }
        };

        pod = new ProtocolDecoderOutput() {

            public void write(Object message) {
                out = message;
            }

            @Override
            public void flush(NextFilter nextFilter, IoSession session) {
            }
        };
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    private static void setDecodedObject(Object message) {
        out = message;
    }

    private static void setEncodedObject(Object message) {
        buffer = (IoBuffer) message;
    }

    private static void assertEncodeDecode(Object in) throws Exception {
        assertEquals(in, in);

        encoder.encode(session, in, po);
        decoder.decode(session, buffer, pod);

        assertNotNull(out);
        assertEquals(in.getClass(), out.getClass());
        assertEquals(in, out);
    }

    @Test
    public void test() throws Exception {
        CreateAssocReq in = new CreateAssocReq("hello", 2);
        assertEncodeDecode(in);
    }

    @Test
    public void testBaseRootPkg() throws Exception {
        javax.megaco.pkg.BaseRootPkg.BaseRootPkg o = new javax.megaco.pkg.BaseRootPkg.BaseRootPkg();
        assertEncodeDecode(o);
    }

    @Test
    public void testRootNormMGCExecTimePrpt() throws Exception {
        javax.megaco.pkg.BaseRootPkg.RootNormMGCExecTimePrpt o = new javax.megaco.pkg.BaseRootPkg.RootNormMGCExecTimePrpt();
        assertEncodeDecode(o);
    }

    @Test
    public void testRootMaxTermsPerCtxtPrpt() throws Exception {
        javax.megaco.pkg.BaseRootPkg.RootMaxTermsPerCtxtPrpt o = new javax.megaco.pkg.BaseRootPkg.RootMaxTermsPerCtxtPrpt();
        assertEncodeDecode(o);
    }

    @Test
    public void testRootMaxNrOfCtxtPrpt() throws Exception {
        javax.megaco.pkg.BaseRootPkg.RootMaxNrOfCtxtPrpt o = new javax.megaco.pkg.BaseRootPkg.RootMaxNrOfCtxtPrpt();
        assertEncodeDecode(o);
    }

    @Test
    public void testRootProvRespTimePrpt() throws Exception {
        javax.megaco.pkg.BaseRootPkg.RootProvRespTimePrpt o = new javax.megaco.pkg.BaseRootPkg.RootProvRespTimePrpt();
        assertEncodeDecode(o);
    }

    @Test
    public void testRootNormMGExecTimePrpt() throws Exception {
        javax.megaco.pkg.BaseRootPkg.RootNormMGExecTimePrpt o = new javax.megaco.pkg.BaseRootPkg.RootNormMGExecTimePrpt();
        assertEncodeDecode(o);
    }

    @Test
    public void testCPToneGenSitSignal() throws Exception {
        javax.megaco.pkg.CPToneGenPkg.CPToneGenSitSignal o = new javax.megaco.pkg.CPToneGenPkg.CPToneGenSitSignal();
        assertEncodeDecode(o);
    }

    @Test
    public void testCPToneGenPkg() throws Exception {
        javax.megaco.pkg.CPToneGenPkg.CPToneGenPkg o = new javax.megaco.pkg.CPToneGenPkg.CPToneGenPkg();
        assertEncodeDecode(o);
    }

    @Test
    public void testCPToneGenPtSignal() throws Exception {
        javax.megaco.pkg.CPToneGenPkg.CPToneGenPtSignal o = new javax.megaco.pkg.CPToneGenPkg.CPToneGenPtSignal();
        assertEncodeDecode(o);
    }

    @Test
    public void testCPToneGenCrSignal() throws Exception {
        javax.megaco.pkg.CPToneGenPkg.CPToneGenCrSignal o = new javax.megaco.pkg.CPToneGenPkg.CPToneGenCrSignal();
        assertEncodeDecode(o);
    }

    @Test
    public void testCPToneGenRtSignal() throws Exception {
        javax.megaco.pkg.CPToneGenPkg.CPToneGenRtSignal o = new javax.megaco.pkg.CPToneGenPkg.CPToneGenRtSignal();
        assertEncodeDecode(o);
    }

    @Test
    public void testCPToneGenBtSignal() throws Exception {
        javax.megaco.pkg.CPToneGenPkg.CPToneGenBtSignal o = new javax.megaco.pkg.CPToneGenPkg.CPToneGenBtSignal();
        assertEncodeDecode(o);
    }

    @Test
    public void testCPToneGenCtSignal() throws Exception {
        javax.megaco.pkg.CPToneGenPkg.CPToneGenCtSignal o = new javax.megaco.pkg.CPToneGenPkg.CPToneGenCtSignal();
        assertEncodeDecode(o);
    }

    @Test
    public void testCPToneGenDtSignal() throws Exception {
        javax.megaco.pkg.CPToneGenPkg.CPToneGenDtSignal o = new javax.megaco.pkg.CPToneGenPkg.CPToneGenDtSignal();
        assertEncodeDecode(o);
    }

    @Test
    public void testCPToneGenWtSignal() throws Exception {
        javax.megaco.pkg.CPToneGenPkg.CPToneGenWtSignal o = new javax.megaco.pkg.CPToneGenPkg.CPToneGenWtSignal();
        assertEncodeDecode(o);
    }

    @Test
    public void testCPToneGenCwtSignal() throws Exception {
        javax.megaco.pkg.CPToneGenPkg.CPToneGenCwtSignal o = new javax.megaco.pkg.CPToneGenPkg.CPToneGenCwtSignal();
        assertEncodeDecode(o);
    }

    @Test
    public void testDTMFGenD0Signal() throws Exception {
        javax.megaco.pkg.DTMFGenPkg.DTMFGenD0Signal o = new javax.megaco.pkg.DTMFGenPkg.DTMFGenD0Signal();
        assertEncodeDecode(o);
    }

    @Test
    public void testDTMFGenD1Signal() throws Exception {
        javax.megaco.pkg.DTMFGenPkg.DTMFGenD1Signal o = new javax.megaco.pkg.DTMFGenPkg.DTMFGenD1Signal();
        assertEncodeDecode(o);
    }

    @Test
    public void testDTMFGenD2Signal() throws Exception {
        javax.megaco.pkg.DTMFGenPkg.DTMFGenD2Signal o = new javax.megaco.pkg.DTMFGenPkg.DTMFGenD2Signal();
        assertEncodeDecode(o);
    }

    @Test
    public void testDTMFGenD3Signal() throws Exception {
        javax.megaco.pkg.DTMFGenPkg.DTMFGenD3Signal o = new javax.megaco.pkg.DTMFGenPkg.DTMFGenD3Signal();
        assertEncodeDecode(o);
    }

    @Test
    public void testDTMFGenD4Signal() throws Exception {
        javax.megaco.pkg.DTMFGenPkg.DTMFGenD4Signal o = new javax.megaco.pkg.DTMFGenPkg.DTMFGenD4Signal();
        assertEncodeDecode(o);
    }

    @Test
    public void testDTMFGenD5Signal() throws Exception {
        javax.megaco.pkg.DTMFGenPkg.DTMFGenD5Signal o = new javax.megaco.pkg.DTMFGenPkg.DTMFGenD5Signal();
        assertEncodeDecode(o);
    }

    @Test
    public void testDTMFGenD6Signal() throws Exception {
        javax.megaco.pkg.DTMFGenPkg.DTMFGenD6Signal o = new javax.megaco.pkg.DTMFGenPkg.DTMFGenD6Signal();
        assertEncodeDecode(o);
    }

    @Test
    public void testDTMFGenD7Signal() throws Exception {
        javax.megaco.pkg.DTMFGenPkg.DTMFGenD7Signal o = new javax.megaco.pkg.DTMFGenPkg.DTMFGenD7Signal();
        assertEncodeDecode(o);
    }

    @Test
    public void testDTMFGenD8Signal() throws Exception {
        javax.megaco.pkg.DTMFGenPkg.DTMFGenD8Signal o = new javax.megaco.pkg.DTMFGenPkg.DTMFGenD8Signal();
        assertEncodeDecode(o);
    }

    @Test
    public void testDTMFGenD9Signal() throws Exception {
        javax.megaco.pkg.DTMFGenPkg.DTMFGenD9Signal o = new javax.megaco.pkg.DTMFGenPkg.DTMFGenD9Signal();
        assertEncodeDecode(o);
    }

    @Test
    public void testDTMFGenDStarSignal() throws Exception {
        javax.megaco.pkg.DTMFGenPkg.DTMFGenDStarSignal o = new javax.megaco.pkg.DTMFGenPkg.DTMFGenDStarSignal();
        assertEncodeDecode(o);
    }

    @Test
    public void testDTMFGenPkg() throws Exception {
        javax.megaco.pkg.DTMFGenPkg.DTMFGenPkg o = new javax.megaco.pkg.DTMFGenPkg.DTMFGenPkg();
        assertEncodeDecode(o);
    }

    @Test
    public void testDTMFGenDASignal() throws Exception {
        javax.megaco.pkg.DTMFGenPkg.DTMFGenDASignal o = new javax.megaco.pkg.DTMFGenPkg.DTMFGenDASignal();
        assertEncodeDecode(o);
    }

    @Test
    public void testDTMFGenDBSignal() throws Exception {
        javax.megaco.pkg.DTMFGenPkg.DTMFGenDBSignal o = new javax.megaco.pkg.DTMFGenPkg.DTMFGenDBSignal();
        assertEncodeDecode(o);
    }

    @Test
    public void testDTMFGenDCSignal() throws Exception {
        javax.megaco.pkg.DTMFGenPkg.DTMFGenDCSignal o = new javax.megaco.pkg.DTMFGenPkg.DTMFGenDCSignal();
        assertEncodeDecode(o);
    }

    @Test
    public void testDTMFGenDHashSignal() throws Exception {
        javax.megaco.pkg.DTMFGenPkg.DTMFGenDHashSignal o = new javax.megaco.pkg.DTMFGenPkg.DTMFGenDHashSignal();
        assertEncodeDecode(o);
    }

    @Test
    public void testDTMFGenDDSignal() throws Exception {
        javax.megaco.pkg.DTMFGenPkg.DTMFGenDDSignal o = new javax.megaco.pkg.DTMFGenPkg.DTMFGenDDSignal();
        assertEncodeDecode(o);
    }

    @Test
    public void testCPToneDetWtEvt() throws Exception {
        javax.megaco.pkg.CPToneDetPkg.CPToneDetWtEvt o = new javax.megaco.pkg.CPToneDetPkg.CPToneDetWtEvt();
        assertEncodeDecode(o);
    }

    @Test
    public void testCPToneDetCwtEvt() throws Exception {
        javax.megaco.pkg.CPToneDetPkg.CPToneDetCwtEvt o = new javax.megaco.pkg.CPToneDetPkg.CPToneDetCwtEvt();
        assertEncodeDecode(o);
    }

    @Test
    public void testCPToneDetSitEvt() throws Exception {
        javax.megaco.pkg.CPToneDetPkg.CPToneDetSitEvt o = new javax.megaco.pkg.CPToneDetPkg.CPToneDetSitEvt();
        assertEncodeDecode(o);
    }

    @Test
    public void testCPToneDetPkg() throws Exception {
        javax.megaco.pkg.CPToneDetPkg.CPToneDetPkg o = new javax.megaco.pkg.CPToneDetPkg.CPToneDetPkg();
        assertEncodeDecode(o);
    }

    @Test
    public void testCPToneDetPtEvt() throws Exception {
        javax.megaco.pkg.CPToneDetPkg.CPToneDetPtEvt o = new javax.megaco.pkg.CPToneDetPkg.CPToneDetPtEvt();
        assertEncodeDecode(o);
    }

    @Test
    public void testCPToneDetCrEvt() throws Exception {
        javax.megaco.pkg.CPToneDetPkg.CPToneDetCrEvt o = new javax.megaco.pkg.CPToneDetPkg.CPToneDetCrEvt();
        assertEncodeDecode(o);
    }

    @Test
    public void testCPToneDetBtEvt() throws Exception {
        javax.megaco.pkg.CPToneDetPkg.CPToneDetBtEvt o = new javax.megaco.pkg.CPToneDetPkg.CPToneDetBtEvt();
        assertEncodeDecode(o);
    }

    @Test
    public void testCPToneDetRtEvt() throws Exception {
        javax.megaco.pkg.CPToneDetPkg.CPToneDetRtEvt o = new javax.megaco.pkg.CPToneDetPkg.CPToneDetRtEvt();
        assertEncodeDecode(o);
    }

    @Test
    public void testCPToneDetCtEvt() throws Exception {
        javax.megaco.pkg.CPToneDetPkg.CPToneDetCtEvt o = new javax.megaco.pkg.CPToneDetPkg.CPToneDetCtEvt();
        assertEncodeDecode(o);
    }

    @Test
    public void testCPToneDetDtEvt() throws Exception {
        javax.megaco.pkg.CPToneDetPkg.CPToneDetDtEvt o = new javax.megaco.pkg.CPToneDetPkg.CPToneDetDtEvt();
        assertEncodeDecode(o);
    }

    @Test
    public void testTDMCktEcPrpt() throws Exception {
        javax.megaco.pkg.TDMCktPkg.TDMCktEcPrpt o = new javax.megaco.pkg.TDMCktPkg.TDMCktEcPrpt();
        assertEncodeDecode(o);
    }

    @Test
    public void testTDMCktPkg() throws Exception {
        javax.megaco.pkg.TDMCktPkg.TDMCktPkg o = new javax.megaco.pkg.TDMCktPkg.TDMCktPkg();
        assertEncodeDecode(o);
    }

    @Test
    public void testDTMFDetParamDs() throws Exception {
        javax.megaco.pkg.DTMFDetPkg.DTMFDetParamDs o = new javax.megaco.pkg.DTMFDetPkg.DTMFDetParamDs();
        assertEncodeDecode(o);
    }

    @Test
    public void testDTMFDetParamMeth() throws Exception {
        javax.megaco.pkg.DTMFDetPkg.DTMFDetParamMeth o = new javax.megaco.pkg.DTMFDetPkg.DTMFDetParamMeth();
        assertEncodeDecode(o);
    }

    @Test
    public void testDTMFDetPkg() throws Exception {
        javax.megaco.pkg.DTMFDetPkg.DTMFDetPkg o = new javax.megaco.pkg.DTMFDetPkg.DTMFDetPkg();
        assertEncodeDecode(o);
    }

    @Test
    public void testDTMFDetCeEvt() throws Exception {
        javax.megaco.pkg.DTMFDetPkg.DTMFDetCeEvt o = new javax.megaco.pkg.DTMFDetPkg.DTMFDetCeEvt();
        assertEncodeDecode(o);
    }

    @Test
    public void testNetworkParamCs() throws Exception {
        javax.megaco.pkg.NetworkPkg.NetworkParamCs o = new javax.megaco.pkg.NetworkPkg.NetworkParamCs();
        assertEncodeDecode(o);
    }

    @Test
    public void testNetworkDurStats() throws Exception {
        javax.megaco.pkg.NetworkPkg.NetworkDurStats o = new javax.megaco.pkg.NetworkPkg.NetworkDurStats();
        assertEncodeDecode(o);
    }

    @Test
    public void testNetworkParamTh() throws Exception {
        javax.megaco.pkg.NetworkPkg.NetworkParamTh o = new javax.megaco.pkg.NetworkPkg.NetworkParamTh();
        assertEncodeDecode(o);
    }

    @Test
    public void testNetworkJitPrpt() throws Exception {
        javax.megaco.pkg.NetworkPkg.NetworkJitPrpt o = new javax.megaco.pkg.NetworkPkg.NetworkJitPrpt();
        assertEncodeDecode(o);
    }

    @Test
    public void testNetworkQualertEvt() throws Exception {
        javax.megaco.pkg.NetworkPkg.NetworkQualertEvt o = new javax.megaco.pkg.NetworkPkg.NetworkQualertEvt();
        assertEncodeDecode(o);
    }

    @Test
    public void testNetworkOrStats() throws Exception {
        javax.megaco.pkg.NetworkPkg.NetworkOrStats o = new javax.megaco.pkg.NetworkPkg.NetworkOrStats();
        assertEncodeDecode(o);
    }

    @Test
    public void testNetworkOsStats() throws Exception {
        javax.megaco.pkg.NetworkPkg.NetworkOsStats o = new javax.megaco.pkg.NetworkPkg.NetworkOsStats();
        assertEncodeDecode(o);
    }

    @Test
    public void testNetworkNetfailEvt() throws Exception {
        javax.megaco.pkg.NetworkPkg.NetworkNetfailEvt o = new javax.megaco.pkg.NetworkPkg.NetworkNetfailEvt();
        assertEncodeDecode(o);
    }

    @Test
    public void testNetworkPkg() throws Exception {
        javax.megaco.pkg.NetworkPkg.NetworkPkg o = new javax.megaco.pkg.NetworkPkg.NetworkPkg();
        assertEncodeDecode(o);
    }

    @Test
    public void testAnalogLineSParamInit() throws Exception {
        javax.megaco.pkg.AnalogLineSPkg.AnalogLineSParamInit o = new javax.megaco.pkg.AnalogLineSPkg.AnalogLineSParamInit();
        assertEncodeDecode(o);
    }

    @Test
    public void testAnalogLineSParamCad() throws Exception {
        javax.megaco.pkg.AnalogLineSPkg.AnalogLineSParamCad o = new javax.megaco.pkg.AnalogLineSPkg.AnalogLineSParamCad();
        assertEncodeDecode(o);
    }

    @Test
    public void testAnalogLineSParamStrict() throws Exception {
        javax.megaco.pkg.AnalogLineSPkg.AnalogLineSParamStrict o = new javax.megaco.pkg.AnalogLineSPkg.AnalogLineSParamStrict();
        assertEncodeDecode(o);
    }

    @Test
    public void testAnalogLineSOffEvt() throws Exception {
        javax.megaco.pkg.AnalogLineSPkg.AnalogLineSOffEvt o = new javax.megaco.pkg.AnalogLineSPkg.AnalogLineSOffEvt();
        assertEncodeDecode(o);
    }

    @Test
    public void testAnalogLineSOnEvt() throws Exception {
        javax.megaco.pkg.AnalogLineSPkg.AnalogLineSOnEvt o = new javax.megaco.pkg.AnalogLineSPkg.AnalogLineSOnEvt();
        assertEncodeDecode(o);
    }

    @Test
    public void testAnalogLineSFlashEvt() throws Exception {
        javax.megaco.pkg.AnalogLineSPkg.AnalogLineSFlashEvt o = new javax.megaco.pkg.AnalogLineSPkg.AnalogLineSFlashEvt();
        assertEncodeDecode(o);
    }

    @Test
    public void testAnalogLineSParamFreq() throws Exception {
        javax.megaco.pkg.AnalogLineSPkg.AnalogLineSParamFreq o = new javax.megaco.pkg.AnalogLineSPkg.AnalogLineSParamFreq();
        assertEncodeDecode(o);
    }

    @Test
    public void testAnalogLineSParamMindur() throws Exception {
        javax.megaco.pkg.AnalogLineSPkg.AnalogLineSParamMindur o = new javax.megaco.pkg.AnalogLineSPkg.AnalogLineSParamMindur();
        assertEncodeDecode(o);
    }

    @Test
    public void testAnalogLineSPkg() throws Exception {
        javax.megaco.pkg.AnalogLineSPkg.AnalogLineSPkg o = new javax.megaco.pkg.AnalogLineSPkg.AnalogLineSPkg();
        assertEncodeDecode(o);
    }

    @Test
    public void testAnalogLineSParamMaxdur() throws Exception {
        javax.megaco.pkg.AnalogLineSPkg.AnalogLineSParamMaxdur o = new javax.megaco.pkg.AnalogLineSPkg.AnalogLineSParamMaxdur();
        assertEncodeDecode(o);
    }

    @Test
    public void testToneGenParamTl() throws Exception {
        javax.megaco.pkg.ToneGenPkg.ToneGenParamTl o = new javax.megaco.pkg.ToneGenPkg.ToneGenParamTl();
        assertEncodeDecode(o);
    }

    @Test
    public void testToneGenPkg() throws Exception {
        javax.megaco.pkg.ToneGenPkg.ToneGenPkg o = new javax.megaco.pkg.ToneGenPkg.ToneGenPkg();
        assertEncodeDecode(o);
    }

    @Test
    public void testToneGenPlayToneSignal() throws Exception {
        javax.megaco.pkg.ToneGenPkg.ToneGenPlayToneSignal o = new javax.megaco.pkg.ToneGenPkg.ToneGenPlayToneSignal();
        assertEncodeDecode(o);
    }

    @Test
    public void testToneGenParamInd() throws Exception {
        javax.megaco.pkg.ToneGenPkg.ToneGenParamInd o = new javax.megaco.pkg.ToneGenPkg.ToneGenParamInd();
        assertEncodeDecode(o);
    }

    @Test
    public void testToneParamDur() throws Exception {
        javax.megaco.pkg.ToneDetPkg.ToneParamDur o = new javax.megaco.pkg.ToneDetPkg.ToneParamDur();
        assertEncodeDecode(o);
    }

    @Test
    public void testToneStdEvent() throws Exception {
        javax.megaco.pkg.ToneDetPkg.ToneStdEvent o = new javax.megaco.pkg.ToneDetPkg.ToneStdEvent();
        assertEncodeDecode(o);
    }

    @Test
    public void testToneDetPkg() throws Exception {
        javax.megaco.pkg.ToneDetPkg.ToneDetPkg o = new javax.megaco.pkg.ToneDetPkg.ToneDetPkg();
        assertEncodeDecode(o);
    }

    @Test
    public void testToneEtdEvent() throws Exception {
        javax.megaco.pkg.ToneDetPkg.ToneEtdEvent o = new javax.megaco.pkg.ToneDetPkg.ToneEtdEvent();
        assertEncodeDecode(o);
    }

    @Test
    public void testToneParamTl() throws Exception {
        javax.megaco.pkg.ToneDetPkg.ToneParamTl o = new javax.megaco.pkg.ToneDetPkg.ToneParamTl();
        assertEncodeDecode(o);
    }

    @Test
    public void testToneParamTid() throws Exception {
        javax.megaco.pkg.ToneDetPkg.ToneParamTid o = new javax.megaco.pkg.ToneDetPkg.ToneParamTid();
        assertEncodeDecode(o);
    }

    @Test
    public void testToneLtdEvent() throws Exception {
        javax.megaco.pkg.ToneDetPkg.ToneLtdEvent o = new javax.megaco.pkg.ToneDetPkg.ToneLtdEvent();
        assertEncodeDecode(o);
    }

    @Test
    public void testContRspSignal() throws Exception {
        javax.megaco.pkg.ContinuityPkg.ContRspSignal o = new javax.megaco.pkg.ContinuityPkg.ContRspSignal();
        assertEncodeDecode(o);
    }

    @Test
    public void testContinuityPkg() throws Exception {
        javax.megaco.pkg.ContinuityPkg.ContinuityPkg o = new javax.megaco.pkg.ContinuityPkg.ContinuityPkg();
        assertEncodeDecode(o);
    }

    @Test
    public void testContCtSignal() throws Exception {
        javax.megaco.pkg.ContinuityPkg.ContCtSignal o = new javax.megaco.pkg.ContinuityPkg.ContCtSignal();
        assertEncodeDecode(o);
    }

    @Test
    public void testContComplEvt() throws Exception {
        javax.megaco.pkg.ContinuityPkg.ContComplEvt o = new javax.megaco.pkg.ContinuityPkg.ContComplEvt();
        assertEncodeDecode(o);
    }

    @Test
    public void testContParamRes() throws Exception {
        javax.megaco.pkg.ContinuityPkg.ContParamRes o = new javax.megaco.pkg.ContinuityPkg.ContParamRes();
        assertEncodeDecode(o);
    }

    @Test
    public void testRTPPlStats() throws Exception {
        javax.megaco.pkg.RTPPkg.RTPPlStats o = new javax.megaco.pkg.RTPPkg.RTPPlStats();
        assertEncodeDecode(o);
    }

    @Test
    public void testRTPDelayStats() throws Exception {
        javax.megaco.pkg.RTPPkg.RTPDelayStats o = new javax.megaco.pkg.RTPPkg.RTPDelayStats();
        assertEncodeDecode(o);
    }

    @Test
    public void testRTPPrStats() throws Exception {
        javax.megaco.pkg.RTPPkg.RTPPrStats o = new javax.megaco.pkg.RTPPkg.RTPPrStats();
        assertEncodeDecode(o);
    }

    @Test
    public void testRTPPsStats() throws Exception {
        javax.megaco.pkg.RTPPkg.RTPPsStats o = new javax.megaco.pkg.RTPPkg.RTPPsStats();
        assertEncodeDecode(o);
    }

    @Test
    public void testRTPPkg() throws Exception {
        javax.megaco.pkg.RTPPkg.RTPPkg o = new javax.megaco.pkg.RTPPkg.RTPPkg();
        assertEncodeDecode(o);
    }

    @Test
    public void testRTPPltransEvt() throws Exception {
        javax.megaco.pkg.RTPPkg.RTPPltransEvt o = new javax.megaco.pkg.RTPPkg.RTPPltransEvt();
        assertEncodeDecode(o);
    }

    @Test
    public void testRTPParamRtppltype() throws Exception {
        javax.megaco.pkg.RTPPkg.RTPParamRtppltype o = new javax.megaco.pkg.RTPPkg.RTPParamRtppltype();
        assertEncodeDecode(o);
    }

    @Test
    public void testRTPJitStats() throws Exception {
        javax.megaco.pkg.RTPPkg.RTPJitStats o = new javax.megaco.pkg.RTPPkg.RTPJitStats();
        assertEncodeDecode(o);
    }

    @Test
    public void testGenParamTermMeth() throws Exception {
        javax.megaco.pkg.GenericPkg.GenParamTermMeth o = new javax.megaco.pkg.GenericPkg.GenParamTermMeth();
        assertEncodeDecode(o);
    }

    @Test
    public void testGenParamFailureCause() throws Exception {
        javax.megaco.pkg.GenericPkg.GenParamFailureCause o = new javax.megaco.pkg.GenericPkg.GenParamFailureCause();
        assertEncodeDecode(o);
    }

    @Test
    public void testGenParamGenCause() throws Exception {
        javax.megaco.pkg.GenericPkg.GenParamGenCause o = new javax.megaco.pkg.GenericPkg.GenParamGenCause();
        assertEncodeDecode(o);
    }

    @Test
    public void testGenSigComplEvent() throws Exception {
        javax.megaco.pkg.GenericPkg.GenSigComplEvent o = new javax.megaco.pkg.GenericPkg.GenSigComplEvent();
        assertEncodeDecode(o);
    }

    @Test
    public void testGenParamSigID() throws Exception {
        javax.megaco.pkg.GenericPkg.GenParamSigID o = new javax.megaco.pkg.GenericPkg.GenParamSigID();
        assertEncodeDecode(o);
    }

    @Test
    public void testGenCauseEvent() throws Exception {
        javax.megaco.pkg.GenericPkg.GenCauseEvent o = new javax.megaco.pkg.GenericPkg.GenCauseEvent();
        assertEncodeDecode(o);
    }

    @Test
    public void testGenericPkg() throws Exception {
        javax.megaco.pkg.GenericPkg.GenericPkg o = new javax.megaco.pkg.GenericPkg.GenericPkg();
        assertEncodeDecode(o);
    }

    @Test
    public void testParamValueType() throws Exception {
        javax.megaco.pkg.ParamValueType o = javax.megaco.pkg.ParamValueType.BOOLEAN;
        assertEncodeDecode(o);
    }

    @Test
    public void testPkgItem() throws Exception {
        javax.megaco.pkg.PkgItem o = new javax.megaco.pkg.PkgItem();
        assertEncodeDecode(o);
    }

    @Test
    public void testPkgItemType() throws Exception {
        javax.megaco.pkg.PkgItemType o = javax.megaco.pkg.PkgItemType.ALL;
        assertEncodeDecode(o);
    }

    @Test
    public void testPkgConsts() throws Exception {
        javax.megaco.pkg.PkgConsts o = new javax.megaco.pkg.PkgConsts();
        assertEncodeDecode(o);
    }

    @Test
    public void testPkgItemStr() throws Exception {
        javax.megaco.pkg.PkgItemStr o = new javax.megaco.pkg.PkgItemStr();
        assertEncodeDecode(o);
    }

    @Test
    public void testParamRelation() throws Exception {
        javax.megaco.pkg.ParamRelation o = javax.megaco.pkg.ParamRelation.EQUAL;
        assertEncodeDecode(o);
    }

    @Test
    public void testModemDescriptor() throws Exception {
        javax.megaco.message.descriptor.ModemDescriptor o = new javax.megaco.message.descriptor.ModemDescriptor(new javax.megaco.message.descriptor.ModemParam[]{new javax.megaco.message.descriptor.ModemParam(javax.megaco.message.descriptor.ModemType.EXT)});
        assertEncodeDecode(o);
    }

    @Test
    public void testStreamMode() throws Exception {
        javax.megaco.message.descriptor.StreamMode o = javax.megaco.message.descriptor.StreamMode. INACTIVE;
        assertEncodeDecode(o);
    }

    @Test
    public void testSignalParamType() throws Exception {
        javax.megaco.message.descriptor.SignalParamType o = javax.megaco.message.descriptor.SignalParamType.LIST;
        assertEncodeDecode(o);
    }

    @Test
    public void testServiceState() throws Exception {
        javax.megaco.message.descriptor.ServiceState o = javax.megaco.message.descriptor.ServiceState.INS;
        assertEncodeDecode(o);
    }

    @Test
    public void testSDPInfo() throws Exception {
        javax.megaco.message.descriptor.SDPInfo o = new javax.megaco.message.descriptor.SDPInfo();
        assertEncodeDecode(o);
    }

    @Test
    public void testSrvChngRespDescriptor() throws Exception {
        javax.megaco.message.descriptor.SrvChngRespDescriptor o = new javax.megaco.message.descriptor.SrvChngRespDescriptor();
        assertEncodeDecode(o);
    }

    @Test
    public void testTimeStamp() throws Exception {
        javax.megaco.message.descriptor.TimeStamp o = new javax.megaco.message.descriptor.TimeStamp(1, 1, 1, 1, 1, 1);
        assertEncodeDecode(o);
    }

    @Test
    public void testTermStateDescriptor() throws Exception {
        javax.megaco.message.descriptor.TermStateDescriptor o = new javax.megaco.message.descriptor.TermStateDescriptor();
        assertEncodeDecode(o);
    }

    @Test
    public void testEmbedFirstEventParam() throws Exception {
        javax.megaco.message.descriptor.EmbedFirstEventParam o = new javax.megaco.message.descriptor.EmbedFirstEventParam(1);
        assertEncodeDecode(o);
    }

    @Test
    public void testSrvChngDescriptor() throws Exception {
        javax.megaco.message.descriptor.SrvChngDescriptor o = new javax.megaco.message.descriptor.SrvChngDescriptor();
        assertEncodeDecode(o);
    }

    @Test
    public void testEventBufferDescriptor() throws Exception {
        javax.megaco.message.descriptor.EventBufferDescriptor o = new javax.megaco.message.descriptor.EventBufferDescriptor(new javax.megaco.message.descriptor.EventBufParam[]{new javax.megaco.message.descriptor.EventBufParam(new AnalogLineSFlashEvt())});
        assertEncodeDecode(o);
    }

    @Test
    public void testMuxType() throws Exception {
        javax.megaco.message.descriptor.MuxType o = javax.megaco.message.descriptor.MuxType.EXT;
        assertEncodeDecode(o);
    }

    @Test
    public void testDigitStringPosition() throws Exception {
        javax.megaco.message.descriptor.DigitStringPosition o = new javax.megaco.message.descriptor.DigitStringPosition();
        assertEncodeDecode(o);
    }

    @Test
    public void testSignalDescriptor() throws Exception {
        javax.megaco.message.descriptor.SignalDescriptor o = new javax.megaco.message.descriptor.SignalDescriptor();
        assertEncodeDecode(o);
    }

    @Test
    public void testSignalNotifyReason() throws Exception {
        javax.megaco.message.descriptor.SignalNotifyReason o = javax.megaco.message.descriptor.SignalNotifyReason.INT_EVENT;
        assertEncodeDecode(o);
    }

    @Test
    public void testModemParamValue() throws Exception {
        javax.megaco.message.descriptor.ModemParamValue o = new javax.megaco.message.descriptor.ModemParamValue();
        assertEncodeDecode(o);
    }

    @Test
    public void testEventDescriptor() throws Exception {
        javax.megaco.message.descriptor.EventDescriptor o = new javax.megaco.message.descriptor.EventDescriptor(1);
        assertEncodeDecode(o);
    }

    @Test
    public void testModemParam() throws Exception {
        javax.megaco.message.descriptor.ModemParam o = new javax.megaco.message.descriptor.ModemParam(javax.megaco.message.descriptor.ModemType.EXT);
        assertEncodeDecode(o);
    }

    @Test
    public void testRequestedEventParam() throws Exception {
        javax.megaco.message.descriptor.RequestedEventParam o = new javax.megaco.message.descriptor.RequestedEventParam(new javax.megaco.pkg.DTMFDetPkg.DTMFDetCeEvt());
        assertEncodeDecode(o);
    }

    @Test
    public void testPackageDescriptor() throws Exception {
        javax.megaco.message.descriptor.PackageDescriptor o = new javax.megaco.message.descriptor.PackageDescriptor();
        assertEncodeDecode(o);
    }

    @Test
    public void testPackagesItem() throws Exception {
        javax.megaco.message.descriptor.PackagesItem o = new javax.megaco.message.descriptor.PackagesItem(new javax.megaco.pkg.ToneGenPkg.ToneGenPkg(),(short)0x8);
        assertEncodeDecode(o);
    }

    @Test
    public void testSignalParam() throws Exception {
        javax.megaco.message.descriptor.SignalParam o = new javax.megaco.message.descriptor.SignalParam(new javax.megaco.message.descriptor.SignalRequest(new javax.megaco.pkg.ContinuityPkg.ContCtSignal()));
        assertEncodeDecode(o);
    }

    /*
    @Test
    public void testDescriptorUtils() throws Exception {
        javax.megaco.message.descriptor.DescriptorUtils o = javax.megaco.message.descriptor.DescriptorUtils. 
        assertEncodeDecode(o);
    }
    * 
    */

    @Test
    public void testEventBufParam() throws Exception {
        javax.megaco.message.descriptor.EventBufParam o = new javax.megaco.message.descriptor.EventBufParam(new javax.megaco.pkg.CPToneDetPkg.CPToneDetSitEvt());
        assertEncodeDecode(o);
    }

    @Test
    public void testEventBufferCtrl() throws Exception {
        javax.megaco.message.descriptor.EventBufferCtrl o = javax.megaco.message.descriptor.EventBufferCtrl.LOCK_STEP; 
        assertEncodeDecode(o);
    }

    @Test
    public void testEventParam() throws Exception {
        javax.megaco.message.descriptor.EventParam o = new javax.megaco.message.descriptor.EventParam();
        assertEncodeDecode(o);
    }

    @Test
    public void testAuditValRespDescriptor() throws Exception {
        javax.megaco.message.descriptor.AuditValRespDescriptor o = new javax.megaco.message.descriptor.AuditValRespDescriptor();
        assertEncodeDecode(o);
    }
    
    @Test
    public void testModemType() throws Exception {
        javax.megaco.message.descriptor.ModemType o = javax.megaco.message.descriptor.ModemType.EXT;
        assertEncodeDecode(o);
    }

    @Test
    public void testAuditValDescriptor() throws Exception {
        javax.megaco.message.descriptor.AuditValDescriptor o = new javax.megaco.message.descriptor.AuditValDescriptor();
        assertEncodeDecode(o);
    }

    @Test
    public void testMuxDescriptor() throws Exception {
        javax.megaco.message.descriptor.MuxDescriptor o = new javax.megaco.message.descriptor.MuxDescriptor(javax.megaco.message.descriptor.MuxType.EXT, new javax.megaco.message.Termination[]{new javax.megaco.message.Termination()});
        assertEncodeDecode(o);
    }

    @Test
    public void testObservedEvent() throws Exception {
        javax.megaco.message.descriptor.ObservedEvent o = new javax.megaco.message.descriptor.ObservedEvent(new javax.megaco.pkg.AnalogLineSPkg.AnalogLineSFlashEvt());
        assertEncodeDecode(o);
    }

    @Test
    public void testTopologyDescriptor() throws Exception {
        javax.megaco.message.descriptor.TopologyDescriptor o = new javax.megaco.message.descriptor.TopologyDescriptor(new javax.megaco.message.Termination(), new javax.megaco.message.Termination(), javax.megaco.message.descriptor.TopologyDirection.BOTHWAY);
        assertEncodeDecode(o);
    }

    @Test
    public void testMediaStreamParam() throws Exception {
        javax.megaco.message.descriptor.MediaStreamParam o = new javax.megaco.message.descriptor.MediaStreamParam();
        assertEncodeDecode(o);
    }

    @Test
    public void testTopologyDirection() throws Exception {
        javax.megaco.message.descriptor.TopologyDirection o = javax.megaco.message.descriptor.TopologyDirection.BOTHWAY;
        assertEncodeDecode(o);
    }

    @Test
    public void testLocalCtrlDescriptor() throws Exception {
        javax.megaco.message.descriptor.LocalCtrlDescriptor o = new javax.megaco.message.descriptor.LocalCtrlDescriptor();
        assertEncodeDecode(o);
    }

    @Test
    public void testSignalType() throws Exception {
        javax.megaco.message.descriptor.SignalType o = javax.megaco.message.descriptor.SignalType.BRIEF;
        assertEncodeDecode(o);
    }

    @Test
    public void testCntxtTermAudDescriptor() throws Exception {
        javax.megaco.message.descriptor.CntxtTermAudDescriptor o = new javax.megaco.message.descriptor.CntxtTermAudDescriptor();
        assertEncodeDecode(o);
    }

    @Test
    public void testAuditCapRespDescriptor() throws Exception {
        javax.megaco.message.descriptor.AuditCapRespDescriptor o = new javax.megaco.message.descriptor.AuditCapRespDescriptor();
        assertEncodeDecode(o);
    }

    @Test
    public void testObsEventDescriptor() throws Throwable, InvalidArgumentException {
        javax.megaco.message.descriptor.ObsEventDescriptor o = new javax.megaco.message.descriptor.ObsEventDescriptor(1, new javax.megaco.message.descriptor.ObservedEvent[]{new javax.megaco.message.descriptor.ObservedEvent(new javax.megaco.pkg.CPToneDetPkg.CPToneDetSitEvt())});
        assertEncodeDecode(o);
    }

    @Test
    public void testDigitMapString() throws Exception {
        javax.megaco.message.descriptor.DigitMapString o = new javax.megaco.message.descriptor.DigitMapString();
        assertEncodeDecode(o);
    }

    @Test
    public void testSignalRequest() throws Exception {
        javax.megaco.message.descriptor.SignalRequest o = new javax.megaco.message.descriptor.SignalRequest(new javax.megaco.pkg.DTMFGenPkg.DTMFGenD7Signal());
        assertEncodeDecode(o);
    }

    @Test
    public void testErrorDescriptor() throws Exception {
        javax.megaco.message.descriptor.ErrorDescriptor o = new javax.megaco.message.descriptor.ErrorDescriptor(1);
        assertEncodeDecode(o);
    }

    @Test
    public void testAuditCapDescriptor() throws Exception {
        javax.megaco.message.descriptor.AuditCapDescriptor o = new javax.megaco.message.descriptor.AuditCapDescriptor();
        assertEncodeDecode(o);
    }

    @Test
    public void testStreamDescriptor() throws Exception {
        javax.megaco.message.descriptor.StreamDescriptor o = new javax.megaco.message.descriptor.StreamDescriptor();
        assertEncodeDecode(o);
    }

    @Test
    public void testDigitMapValue() throws Exception {
        javax.megaco.message.descriptor.DigitMapValue o = new javax.megaco.message.descriptor.DigitMapValue();
        assertEncodeDecode(o);
    }

    @Test
    public void testDigitMapDescriptor() throws Exception {
        javax.megaco.message.descriptor.DigitMapDescriptor o = new javax.megaco.message.descriptor.DigitMapDescriptor();
        assertEncodeDecode(o);
    }

    @Test
    public void testStatsDescriptor() throws Exception {
        javax.megaco.message.descriptor.StatsDescriptor o = new javax.megaco.message.descriptor.StatsDescriptor(new javax.megaco.pkg.PkgStatsItem[]{new javax.megaco.pkg.RTPPkg.RTPDelayStats()});
        assertEncodeDecode(o);
    }

    @Test
    public void testDescriptorType() throws Exception {
        javax.megaco.message.DescriptorType o = javax.megaco.message.DescriptorType.AUDIT_CAP_REPLY_DESC; 
        assertEncodeDecode(o);
    }

    @Test
    public void testContextInfo() throws Exception {
        javax.megaco.message.ContextInfo o = new javax.megaco.message.ContextInfo(1);
        assertEncodeDecode(o);
    }

    @Test
    public void testCommandType() throws Exception {
        javax.megaco.message.CommandType o = javax.megaco.message.CommandType.COMMAND_REQ;
        assertEncodeDecode(o);
    }

    @Test
    public void testCmdResponseType() throws Exception {
        javax.megaco.message.CmdResponseType o = javax.megaco.message.CmdResponseType.AUDIT_VAL_RESP;
        assertEncodeDecode(o);
    }

    @Test
    public void testContextParam() throws Exception {
        javax.megaco.message.ContextParam o = new javax.megaco.message.ContextParam();
        assertEncodeDecode(o);
    }

    @Test
    public void testCommandReq() throws Exception {
        javax.megaco.message.CommandReq o = javax.megaco.message.CommandReq.MegacoCmdReqAdd("source1", 1, 2, 3, true, false);
        assertEncodeDecode(o);
    }

    @Test
    public void testContextInfoReq() throws Exception {
        javax.megaco.message.ContextInfoReq o = new javax.megaco.message.ContextInfoReq("object", 1, 1, 1, false);
        assertEncodeDecode(o);
    }

    @Test
    public void testCommandResp() throws Exception {
        javax.megaco.message.CommandResp o = javax.megaco.message.CommandResp.MegacoCmdRespAdd("source2", 3, 4, 5, true, true);
        assertEncodeDecode(o);
    }

    @Test
    public void testTermination() throws Exception {
        javax.megaco.message.Termination o = new javax.megaco.message.Termination();
        assertEncodeDecode(o);
    }

    @Test
    public void testTermType() throws Exception {
        javax.megaco.message.TermType o = javax.megaco.message.TermType.NORMAL;
        assertEncodeDecode(o);
    }

    @Test
    public void testContextInfoResp() throws Exception {
        javax.megaco.message.ContextInfoResp o = new javax.megaco.message.ContextInfoResp("object", 1, 1, 1, false);
        assertEncodeDecode(o);
    }

    @Test
    public void testCmdRequestType() throws Exception {
        javax.megaco.message.CmdRequestType o = javax.megaco.message.CmdRequestType.AUDIT_VAL_REQ;
        assertEncodeDecode(o);
    }

    @Test
    public void testEncodingFormat() throws Exception {
        javax.megaco.association.EncodingFormat o = javax.megaco.association.EncodingFormat.TEXT;
        assertEncodeDecode(o);
    }

    @Test
    public void testDeleteAssocReq() throws Exception {
        javax.megaco.association.DeleteAssocReq o = new javax.megaco.association.DeleteAssocReq("object", 1);
        assertEncodeDecode(o);
    }

    @Test
    public void testCreateAssocReq() throws Exception {
        javax.megaco.association.CreateAssocReq o = new javax.megaco.association.CreateAssocReq("object", 1);
        assertEncodeDecode(o);
    }

    @Test
    public void testDeleteTxnReq() throws Exception {
        javax.megaco.association.DeleteTxnReq o = new javax.megaco.association.DeleteTxnReq("object", 1);
        assertEncodeDecode(o);
    }

    @Test
    public void testCreateTxnReq() throws Exception {
        javax.megaco.association.CreateTxnReq o = new javax.megaco.association.CreateTxnReq("object", 1, 1);
        assertEncodeDecode(o);
    }

    @Test
    public void testAssociationInd() throws Exception {
        javax.megaco.association.AssociationInd o = new javax.megaco.association.AssociationInd("object", 1, javax.megaco.association.AssocIndReason.NW_LINKUP_IND);
        assertEncodeDecode(o);
    }

    @Test
    public void testAssocState() throws Exception {
        javax.megaco.association.AssocState o = javax.megaco.association.AssocState.FORCED_SHUTDOWN_IN_PRGS;
        assertEncodeDecode(o);
    }

    @Test
    public void testModifyAssocResp() throws Exception {
        javax.megaco.association.ModifyAssocResp o = new javax.megaco.association.ModifyAssocResp("object", 1);
        assertEncodeDecode(o);
    }

    @Test
    public void testAssociationConfigReq() throws Exception {
        javax.megaco.association.AssociationConfigReq o = new javax.megaco.association.AssociationConfigReq("object", 1);
        assertEncodeDecode(o);
    }

    @Test
    public void testAssocIndReason() throws Exception {
        javax.megaco.association.AssocIndReason o = javax.megaco.association.AssocIndReason.OPER_COMPL_IND;
        assertEncodeDecode(o);
    }

    @Test
    public void testSrvChngMethod() throws Exception {
        javax.megaco.association.SrvChngMethod o = javax.megaco.association.SrvChngMethod.FAILOVER;
        assertEncodeDecode(o);
    }

    @Test
    public void testAssocEventType() throws Exception {
        javax.megaco.association.AssocEventType o = javax.megaco.association.AssocEventType.CREATE_ASSOC_RESP;
        assertEncodeDecode(o);
    }

    @Test
    public void testSrvChngReason() throws Exception {
        javax.megaco.association.SrvChngReason o = javax.megaco.association.SrvChngReason.R905;
        assertEncodeDecode(o);
    }

    @Test
    public void testLocalAddr() throws Exception {
        javax.megaco.association.LocalAddr o = new javax.megaco.association.LocalAddr();
        assertEncodeDecode(o);
    }

    @Test
    public void testDeleteAssocResp() throws Exception {
        javax.megaco.association.DeleteAssocResp o = new javax.megaco.association.DeleteAssocResp("object", 1);
        assertEncodeDecode(o);
    }

    @Test
    public void testDeleteTxnResp() throws Exception {
        javax.megaco.association.DeleteTxnResp o = new javax.megaco.association.DeleteTxnResp("object", 1);
        assertEncodeDecode(o);
    }

    @Test
    public void testCreateAssocResp() throws Exception {
        javax.megaco.association.CreateAssocResp o = new javax.megaco.association.CreateAssocResp("object", 1);
        assertEncodeDecode(o);
    }

    @Test
    public void testRemoteAddr() throws Exception {
        javax.megaco.association.RemoteAddr o = new javax.megaco.association.RemoteAddr();
        assertEncodeDecode(o);
    }

    @Test
    public void testCreateTxnResp() throws Exception {
        javax.megaco.association.CreateTxnResp o = new javax.megaco.association.CreateTxnResp("object", 1, 1);
        assertEncodeDecode(o);
    }

    @Test
    public void testModifyAssocReq() throws Exception {
        javax.megaco.association.ModifyAssocReq o = new javax.megaco.association.ModifyAssocReq("object", 1);
        assertEncodeDecode(o);
    }

    @Test
    public void testAssociationConfigResp() throws Exception {
        javax.megaco.association.AssociationConfigResp o = new javax.megaco.association.AssociationConfigResp("object", 1);
        assertEncodeDecode(o);
    }

    @Test
    public void testTransportType() throws Exception {
        javax.megaco.association.TransportType o = javax.megaco.association.TransportType.SCTP_TPT;
        assertEncodeDecode(o);
    }

    @Test
    public void testExceptionInfoCode() throws Exception {
        javax.megaco.ExceptionInfoCode o = javax.megaco.ExceptionInfoCode.INV_ASSOCIATED_PKD_ID;
        assertEncodeDecode(o);
    }

    @Test
    public void testReturnStatus() throws Exception {
        javax.megaco.ReturnStatus o = javax.megaco.ReturnStatus.SUCCESS;
        assertEncodeDecode(o);
    }

    @Test
    public void testErrorCode() throws Exception {
        javax.megaco.ErrorCode o = javax.megaco.ErrorCode.INV_HOFF_MGCID;
        assertEncodeDecode(o);
    }

    @Test
    public void testUserId() throws Exception {
        javax.megaco.UserId o = new javax.megaco.UserId("test", new java.lang.String[]{"test"});
        assertEncodeDecode(o);
    }

}
