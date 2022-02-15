package mofokom.megaco.resource.impl.codec;

import java.util.List;
import javax.megaco.association.TransportType;
import javax.megaco.message.*;
import static javax.megaco.message.descriptor.DigitStringPosition.*;
import javax.megaco.pkg.*;

/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
/**
 *
 * @author wozza
 */
public class Constants {

    public static String valueForMuxType(int value) {
        switch (value) {
            case javax.megaco.message.descriptor.MuxType.M_H221:
                return ProtocolToken.H221.getFirstToken();
            case javax.megaco.message.descriptor.MuxType.M_H223:
                return ProtocolToken.H223.getFirstToken();
            case javax.megaco.message.descriptor.MuxType.M_H226:
                return ProtocolToken.H226.getFirstToken();
            case javax.megaco.message.descriptor.MuxType.M_V76:
                return ProtocolToken.V76.getFirstToken();
            case javax.megaco.message.descriptor.MuxType.M_EXT:
                return "";
            default:
                throw new IllegalArgumentException("token " + value + " not known for value javax.megaco.message.descriptor.MuxType");
        }
    }

    public static String valueForSrvChngMethod(int value) {
        switch (value) {
            case javax.megaco.association.SrvChngMethod.M_GRACEFUL:
                return ProtocolToken.GRACEFUL.getFirstToken();
            case javax.megaco.association.SrvChngMethod.M_FORCED:
                return ProtocolToken.FORCED.getFirstToken();
            case javax.megaco.association.SrvChngMethod.M_RESTART:
                return ProtocolToken.RESTART.getFirstToken();
            case javax.megaco.association.SrvChngMethod.M_DISCONNECTED:
                return ProtocolToken.DISCONNECTED.getFirstToken();
            case javax.megaco.association.SrvChngMethod.M_HANDOFF:
                return ProtocolToken.HANDOFF.getFirstToken();
            case javax.megaco.association.SrvChngMethod.M_FAILOVER:
                return ProtocolToken.FAILOVER.getFirstToken();
            case javax.megaco.association.SrvChngMethod.M_EXTENSION:
                return "";
            default:
                throw new IllegalArgumentException("token " + value + " not known for value javax.megaco.association.SrvChngMethod");
        }
    }

    public static String valueForServiceState(int value) {
        switch (value) {
            case javax.megaco.message.descriptor.ServiceState.M_OOS:
                return ProtocolToken.OUTOFSVC.getFirstToken();
            case javax.megaco.message.descriptor.ServiceState.M_INS:
                return ProtocolToken.INSVC.getFirstToken();
            case javax.megaco.message.descriptor.ServiceState.M_TEST:
                return ProtocolToken.TEST.getFirstToken();
            default:
                throw new IllegalArgumentException("token " + value + " not known for value javax.megaco.message.descriptor.ServiceState");
        }
    }

    public static String valueForEventBufferCtrl(int value) {
        switch (value) {
            case javax.megaco.message.descriptor.EventBufferCtrl.M_OFF:
                return ProtocolToken.OFF.getFirstToken();
            case javax.megaco.message.descriptor.EventBufferCtrl.M_LOCK_STEP:
                return ProtocolToken.LOCKSTEP.getFirstToken();
            default:
                throw new IllegalArgumentException("token " + value + " not known for value javax.megaco.message.descriptor.EventBufferCtrl");
        }
    }

    public static String[] valueForUnknown(String _stringValue) {
        return new String[]{_stringValue};
    }

    public static String valueForTransportType(int value) {
        switch (value) {
            case TransportType.M_SCTP_TPT:
                return "sctp";
            case TransportType.M_TCP_TPT:
                return "tcp";
            case TransportType.M_UDP_TPT:
                return "udp";
            case TransportType.M_ATM_TPT:
                return "atm";
            case TransportType.M_MTP3B_TPT:
                return "mtp";
            default:
                return "";
        }
    }

    public static String valueForStreamMode(int value) {
        switch (value) {
            case javax.megaco.message.descriptor.StreamMode.M_SEND_ONLY:
                return ProtocolToken.SENDONLY.getFirstToken();
            case javax.megaco.message.descriptor.StreamMode.M_SEND_RECV:
                return ProtocolToken.SENDRECV.getFirstToken();
            case javax.megaco.message.descriptor.StreamMode.M_RECV_ONLY:
                return ProtocolToken.RECVONLY.getFirstToken();
            case javax.megaco.message.descriptor.StreamMode.M_INACTIVE:
                return ProtocolToken.INACTIVE.getFirstToken();
            case javax.megaco.message.descriptor.StreamMode.M_LOOPBACK:
                return ProtocolToken.LOOPBACK.getFirstToken();
            default:
                return "unknown";
        }
    }

    public static javax.megaco.message.descriptor.StreamMode StreamModeForValue(String value) {
        if (ProtocolToken.SENDONLY.equalsIgnoreCase(value))
            return javax.megaco.message.descriptor.StreamMode.SEND_ONLY;
        if (ProtocolToken.SENDRECV.equalsIgnoreCase(value))
            return javax.megaco.message.descriptor.StreamMode.SEND_RECV;
        if (ProtocolToken.RECVONLY.equalsIgnoreCase(value))
            return javax.megaco.message.descriptor.StreamMode.RECV_ONLY;
        if (ProtocolToken.INACTIVE.equalsIgnoreCase(value))
            return javax.megaco.message.descriptor.StreamMode.INACTIVE;
        if (ProtocolToken.LOOPBACK.equalsIgnoreCase(value))
            return javax.megaco.message.descriptor.StreamMode.LOOPBACK;
        throw new IllegalArgumentException("token " + value + " not known for type javax.megaco.message.descriptor.StreamMode");
    }

    public static javax.megaco.message.descriptor.ServiceState ServiceStateForValue(String value) {
        if (ProtocolToken.OUTOFSVC.equalsIgnoreCase(value))
            return javax.megaco.message.descriptor.ServiceState.OOS;
        if (ProtocolToken.INSVC.equalsIgnoreCase(value))
            return javax.megaco.message.descriptor.ServiceState.INS;
        if (ProtocolToken.TEST.equalsIgnoreCase(value))
            return javax.megaco.message.descriptor.ServiceState.TEST;

        throw new IllegalArgumentException("token " + value + " not known for type javax.megaco.message.descriptor.ServiceState");
    }

    public static javax.megaco.message.descriptor.MuxType MuxTypeForValue(String value) {
        if (ProtocolToken.H221.equalsIgnoreCase(value))
            return javax.megaco.message.descriptor.MuxType.H221;
        if (ProtocolToken.H223.equalsIgnoreCase(value))
            return javax.megaco.message.descriptor.MuxType.H223;
        if (ProtocolToken.H226.equalsIgnoreCase(value))
            return javax.megaco.message.descriptor.MuxType.H226;
        if (ProtocolToken.V76.equalsIgnoreCase(value))
            return javax.megaco.message.descriptor.MuxType.V76;
        /*
         * if (ProtocolToken.EXT.equalsIgnoreCase(value)) return
         * javax.megaco.message.descriptor.MuxType.EXT;
         *
         */
        throw new IllegalArgumentException("token " + value + " not known for type javax.megaco.message.descriptor.MuxType");
    }

    public static javax.megaco.message.descriptor.SignalNotifyReason SignalNotifyReasonForValue(String value) {

        if (ProtocolToken.TIMEOUT.equalsIgnoreCase(value))
            return javax.megaco.message.descriptor.SignalNotifyReason.TIMEOUT;
        if (ProtocolToken.INTERRUPTBYEVENT.equalsIgnoreCase(value))
            return javax.megaco.message.descriptor.SignalNotifyReason.INT_EVENT;
        if (ProtocolToken.INTERRUPTBYNEWSIGNALSDESCR.equalsIgnoreCase(value))
            return javax.megaco.message.descriptor.SignalNotifyReason.INT_SIGNAL;
        if (ProtocolToken.OTHERREASON.equalsIgnoreCase(value))
            return javax.megaco.message.descriptor.SignalNotifyReason.OTHER;

        throw new IllegalArgumentException("token " + value + " not known for type javax.megaco.message.descriptor.SignalNotifyReason");
    }

    public static javax.megaco.message.descriptor.EventBufferCtrl EventBufferCtrlForValue(String value) {
        if (ObjectToken.OFF.equalsIgnoreCase(value))
            return javax.megaco.message.descriptor.EventBufferCtrl.OFF;
        if (ProtocolToken.LOCKSTEP.equalsIgnoreCase(value))
            return javax.megaco.message.descriptor.EventBufferCtrl.LOCK_STEP;


        throw new IllegalArgumentException("token " + value + " not known for type javax.megaco.message.descriptor.EventBufferCtrl");
    }

    public static javax.megaco.message.descriptor.ModemType ModemTypeForValue(String value) {
        if (ProtocolToken.V32BIS.equalsIgnoreCase(value))
            return javax.megaco.message.descriptor.ModemType.V32BIS;
        if (ProtocolToken.V22BIS.equalsIgnoreCase(value))
            return javax.megaco.message.descriptor.ModemType.V22BIS;
        if (ProtocolToken.V18.equalsIgnoreCase(value))
            return javax.megaco.message.descriptor.ModemType.V18;
        if (ProtocolToken.V22.equalsIgnoreCase(value))
            return javax.megaco.message.descriptor.ModemType.V22;
        if (ProtocolToken.V32.equalsIgnoreCase(value))
            return javax.megaco.message.descriptor.ModemType.V32;
        if (ProtocolToken.V34.equalsIgnoreCase(value))
            return javax.megaco.message.descriptor.ModemType.V34;
        if (ProtocolToken.V90.equalsIgnoreCase(value))
            return javax.megaco.message.descriptor.ModemType.V90;
        if (ProtocolToken.V91.equalsIgnoreCase(value))
            return javax.megaco.message.descriptor.ModemType.V91;
        if (ProtocolToken.SYNCHISDN.equalsIgnoreCase(value))
            return javax.megaco.message.descriptor.ModemType.SYNCH_ISDN;
        /*
         * if (ProtocolToken.EXT.equalsIgnoreCase(value)) return
         * javax.megaco.message.descriptor.ModemType.EXT;
         *
         */
        throw new IllegalArgumentException("token " + value + " not known for type javax.megaco.message.descriptor.ModemType");
    }

    public static javax.megaco.message.descriptor.TopologyDirection TopologyDirectionForValue(String value) {
        if (ProtocolToken.BOTHWAY.equalsIgnoreCase(value))
            return javax.megaco.message.descriptor.TopologyDirection.BOTHWAY;
        if (ProtocolToken.ISOLATE.equalsIgnoreCase(value))
            return javax.megaco.message.descriptor.TopologyDirection.ISOLATE;
        if (ProtocolToken.ONEWAY.equalsIgnoreCase(value))
            return javax.megaco.message.descriptor.TopologyDirection.ONEWAY;
        throw new IllegalArgumentException("token " + value + " not known for type javax.megaco.message.descriptor.TopologyDirection");
    }

    public static String forSignalType(javax.megaco.message.descriptor.SignalType value) {
        switch (value.getSignalType()) {
            case javax.megaco.message.descriptor.SignalType.M_BRIEF:
                return ProtocolToken.BRIEF.getFirstToken();
            case javax.megaco.message.descriptor.SignalType.M_ON_OFF:
                return ProtocolToken.ONOFF.getFirstToken();
            case javax.megaco.message.descriptor.SignalType.M_TIMEOUT:
                return ProtocolToken.TIMEOUT.getFirstToken();
            default:
                throw new IllegalArgumentException("token " + value + " not known for type javax.megaco.message.descriptor.SignalType");
        }
    }

    public static javax.megaco.message.descriptor.SignalType SignalTypeForValue(String value) {
        if (ProtocolToken.BRIEF.equalsIgnoreCase(value))
            return javax.megaco.message.descriptor.SignalType.BRIEF;
        if (ProtocolToken.ONOFF.equalsIgnoreCase(value))
            return javax.megaco.message.descriptor.SignalType.ON_OFF;
        if (ProtocolToken.TIMEOUT.equalsIgnoreCase(value))
            return javax.megaco.message.descriptor.SignalType.TIMEOUT;
        throw new IllegalArgumentException("token " + value + " not known for type javax.megaco.message.descriptor.SignalType");
    }

    public static javax.megaco.message.DescriptorType DescriptorTypeForValue(String value) {
        if (ProtocolToken.EVENTS.equalsIgnoreCase(value))
            return javax.megaco.message.DescriptorType.EVENT_DESC;
        if (ProtocolToken.DIGITMAP.equalsIgnoreCase(value))
            return javax.megaco.message.DescriptorType.DIGIT_MAP_DESC;
        if (ProtocolToken.SIGNALS.equalsIgnoreCase(value))
            return javax.megaco.message.DescriptorType.SIGNAL_DESC;
        if (ProtocolToken.MEDIA.equalsIgnoreCase(value))
            return javax.megaco.message.DescriptorType.MEDIA_DESC;
        if (ProtocolToken.STREAM.equalsIgnoreCase(value))
            return javax.megaco.message.DescriptorType.STREAM_DESC;
        if (ProtocolToken.LOCALCONTROL.equalsIgnoreCase(value))
            return javax.megaco.message.DescriptorType.LOCAL_CONTROL_DESC;
        if (ProtocolToken.TERMINATIONSTATE.equalsIgnoreCase(value))
            return javax.megaco.message.DescriptorType.TERMINATION_STATE_DESC;
        if (ProtocolToken.SERVICECHANGE.equalsIgnoreCase(value))
            return javax.megaco.message.DescriptorType.SERVICE_CHANGE_DESC;
        if (ProtocolToken.SERVICECHANGE.equalsIgnoreCase(value))
            return javax.megaco.message.DescriptorType.SERVICE_CHANGE_RESP_DESC;
        if (ProtocolToken.AUDITCAP.equalsIgnoreCase(value))
            return javax.megaco.message.DescriptorType.AUDIT_CAP_DESC;
        if (ProtocolToken.AUDITVALUE.equalsIgnoreCase(value))
            return javax.megaco.message.DescriptorType.AUDIT_VAL_DESC;
        if (ProtocolToken.AUDITCAP.equalsIgnoreCase(value))
            return javax.megaco.message.DescriptorType.AUDIT_CAP_REPLY_DESC;
        if (ProtocolToken.AUDITVALUE.equalsIgnoreCase(value))
            return javax.megaco.message.DescriptorType.AUDIT_VAL_REPLY_DESC;
        if (ProtocolToken.EVENTBUFFER.equalsIgnoreCase(value))
            return javax.megaco.message.DescriptorType.EVENT_BUF_DESC;
        if (ProtocolToken.STATS.equalsIgnoreCase(value))
            return javax.megaco.message.DescriptorType.STATISTICS_DESC;
        if (ProtocolToken.PACKAGES.equalsIgnoreCase(value))
            return javax.megaco.message.DescriptorType.PACKAGE_DESC;
        if (ProtocolToken.ERROR.equalsIgnoreCase(value))
            return javax.megaco.message.DescriptorType.ERROR_DESC;
        if (ProtocolToken.MODEM.equalsIgnoreCase(value))
            return javax.megaco.message.DescriptorType.MODEM_DESC;
        if (ProtocolToken.MUX.equalsIgnoreCase(value))
            return javax.megaco.message.DescriptorType.MUX_DESC;
        if (ProtocolToken.TOPOLOGY.equalsIgnoreCase(value))
            return javax.megaco.message.DescriptorType.TOPOLOGY_DESC;
        if (ProtocolToken.CTX.equalsIgnoreCase(value))
            return javax.megaco.message.DescriptorType.CTX_TERM_AUDIT_DESC;
        if (ProtocolToken.OBSERVEDEVENTS.equalsIgnoreCase(value))
            return javax.megaco.message.DescriptorType.OBSERVED_EVENT_DESC;
        throw new IllegalArgumentException("token " + value + " not known for type javax.megaco.message.DescriptorType ");
    }

    public static javax.megaco.message.CommandType CommandTypeForValue(String value) {
        /*
         * if (ProtocolToken.COMMAND_REQ.equalsIgnoreCase(value)) return
         * javax.megaco.message.CommandType.COMMAND_REQ; if
         * (ProtocolToken.COMMAND_RESP.equalsIgnoreCase(value)) return
         * javax.megaco.message.CommandType.COMMAND_RESP; if
         * (ProtocolToken.ACTION_REQ.equalsIgnoreCase(value)) return
         * javax.megaco.message.CommandType.ACTION_REQ; if
         * (ProtocolToken.ACTION_RESP.equalsIgnoreCase(value)) return
         * javax.megaco.message.CommandType.ACTION_RESP;
         *
         */
        throw new IllegalArgumentException("token " + value + " not known for type javax.megaco.message.CommandType");
    }

    public static javax.megaco.message.CmdResponseType CmdResponseTypeForValue(String value) {
        if (ProtocolToken.ADD.equalsIgnoreCase(value))
            return javax.megaco.message.CmdResponseType.ADD_RESP;
        if (ProtocolToken.MODIFY.equalsIgnoreCase(value))
            return javax.megaco.message.CmdResponseType.MODIFY_RESP;
        if (ProtocolToken.MOVE.equalsIgnoreCase(value))
            return javax.megaco.message.CmdResponseType.MOVE_RESP;
        if (ProtocolToken.SERVICECHANGE.equalsIgnoreCase(value))
            return javax.megaco.message.CmdResponseType.SERVICE_CHANGE_RESP;
        if (ProtocolToken.NOTIFY.equalsIgnoreCase(value))
            return javax.megaco.message.CmdResponseType.NOTIFY_RESP;
        if (ProtocolToken.AUDITVALUE.equalsIgnoreCase(value))
            return javax.megaco.message.CmdResponseType.AUDIT_VAL_RESP;
        if (ProtocolToken.AUDITCAP.equalsIgnoreCase(value))
            return javax.megaco.message.CmdResponseType.AUDIT_CAP_RESP;
        if (ProtocolToken.SUBTRACT.equalsIgnoreCase(value))
            return javax.megaco.message.CmdResponseType.SUBTRACT_RESP;
        throw new IllegalArgumentException("token " + value + " not known for type javax.megaco.message.CmdResponseType");
    }

    public static javax.megaco.message.TermType TermTypeForValue(String value) {
        if (ProtocolToken.TERMTYPECHOOSE.equalsIgnoreCase(value))
            return javax.megaco.message.TermType.CHOOSE;
        if (ProtocolToken.TERMTYPEROOT.equalsIgnoreCase(value))
            return javax.megaco.message.TermType.ROOT;
        if (ProtocolToken.TERMTYPEWILDCARD.equalsIgnoreCase(value))
            return javax.megaco.message.TermType.WILDCARD;

        return javax.megaco.message.TermType.NORMAL;
    }

    public static javax.megaco.message.CmdRequestType CmdRequestTypeForValue(String value) {
        if (ProtocolToken.ADD.equalsIgnoreCase(value))
            return javax.megaco.message.CmdRequestType.ADD_REQ;
        if (ProtocolToken.MODIFY.equalsIgnoreCase(value))
            return javax.megaco.message.CmdRequestType.MODIFY_REQ;
        if (ProtocolToken.MOVE.equalsIgnoreCase(value))
            return javax.megaco.message.CmdRequestType.MOVE_REQ;
        if (ProtocolToken.SERVICECHANGE.equalsIgnoreCase(value))
            return javax.megaco.message.CmdRequestType.SERVICE_CHANGE_REQ;
        if (ProtocolToken.NOTIFY.equalsIgnoreCase(value))
            return javax.megaco.message.CmdRequestType.NOTIFY_REQ;
        if (ProtocolToken.AUDITVALUE.equalsIgnoreCase(value))
            return javax.megaco.message.CmdRequestType.AUDIT_VAL_REQ;
        if (ProtocolToken.AUDITCAP.equalsIgnoreCase(value))
            return javax.megaco.message.CmdRequestType.AUDIT_CAP_REQ;
        if (ProtocolToken.SUBTRACT.equalsIgnoreCase(value))
            return javax.megaco.message.CmdRequestType.SUBTRACT_REQ;
        throw new IllegalArgumentException("token " + value + " not known for type javax.megaco.message.CmdRequestType");
    }

    static CommandReq CommandReqForValue(javax.megaco.message.CmdRequestType _cmdRequestType, String source, int assocHandle, int txnHandle, int actionHandle, boolean lastCommandInTxn, boolean firstCommandInAction) {
        CommandReq request = null;

        switch (_cmdRequestType.getCmdRequestType()) {
            case CmdRequestType.M_ADD_REQ:
                request = CommandReq.MegacoCmdReqAdd(source, assocHandle, txnHandle, actionHandle, lastCommandInTxn, firstCommandInAction);
                break;
            case CmdRequestType.M_AUDIT_CAP_REQ:
                request = CommandReq.MegacoCmdReqAuditCap(source, assocHandle, txnHandle, actionHandle, lastCommandInTxn, firstCommandInAction);
                break;
            case CmdRequestType.M_AUDIT_VAL_REQ:
                request = CommandReq.MegacoCmdReqAuditVal(source, assocHandle, txnHandle, actionHandle, lastCommandInTxn, firstCommandInAction);
                break;
            case CmdRequestType.M_MODIFY_REQ:
                request = CommandReq.MegacoCmdReqModify(source, assocHandle, txnHandle, actionHandle, lastCommandInTxn, firstCommandInAction);
                break;
            case CmdRequestType.M_MOVE_REQ:
                request = CommandReq.MegacoCmdReqMove(source, assocHandle, txnHandle, actionHandle, lastCommandInTxn, firstCommandInAction);
                break;
            case CmdRequestType.M_NOTIFY_REQ:
                request = CommandReq.MegacoCmdReqNotify(source, assocHandle, txnHandle, actionHandle, lastCommandInTxn, firstCommandInAction);
                break;
            case CmdRequestType.M_SERVICE_CHANGE_REQ:
                request = CommandReq.MegacoCmdReqSrvChng(source, assocHandle, txnHandle, actionHandle, lastCommandInTxn, firstCommandInAction);
                break;
            case CmdRequestType.M_SUBTRACT_REQ:
                request = CommandReq.MegacoCmdReqSubtract(source, assocHandle, txnHandle, actionHandle, lastCommandInTxn, firstCommandInAction);
                break;
            default:
                break;
        }
        return request;
    }

    static CommandResp CommandRespForValue(javax.megaco.message.CmdResponseType _cmdResponseType, String source, int assocHandle, int txnHandle, int actionHandle, boolean lastCommandInTxn, boolean firstCommandInAction) {
        CommandResp response = null;

        switch (_cmdResponseType.getResponseType()) {
            case CmdResponseType.M_ADD_RESP:
                response = CommandResp.MegacoCmdRespAdd(source, assocHandle, txnHandle, actionHandle, lastCommandInTxn, firstCommandInAction);
                break;
            case CmdResponseType.M_AUDIT_CAP_RESP:
                response = CommandResp.MegacoCmdRespAuditCap(source, assocHandle, txnHandle, actionHandle, lastCommandInTxn, firstCommandInAction);
                break;
            case CmdResponseType.M_AUDIT_VAL_RESP:
                response = CommandResp.MegacoCmdRespAuditVal(source, assocHandle, txnHandle, actionHandle, lastCommandInTxn, firstCommandInAction);
                break;
            case CmdResponseType.M_MODIFY_RESP:
                response = CommandResp.MegacoCmdRespModify(source, assocHandle, txnHandle, actionHandle, lastCommandInTxn, firstCommandInAction);
                break;
            case CmdResponseType.M_MOVE_RESP:
                response = CommandResp.MegacoCmdRespMove(source, assocHandle, txnHandle, actionHandle, lastCommandInTxn, firstCommandInAction);
                break;
            case CmdResponseType.M_NOTIFY_RESP:
                response = CommandResp.MegacoCmdRespNotify(source, assocHandle, txnHandle, actionHandle, lastCommandInTxn, firstCommandInAction);
                break;
            case CmdResponseType.M_SERVICE_CHANGE_RESP:
                response = CommandResp.MegacoCmdRespSrvChng(source, assocHandle, txnHandle, actionHandle, lastCommandInTxn, firstCommandInAction);
                break;
            case CmdResponseType.M_SUBTRACT_RESP:
                response = CommandResp.MegacoCmdRespSubtract(source, assocHandle, txnHandle, actionHandle, lastCommandInTxn, firstCommandInAction);
                break;
            default:
                break;
        }
        return response;
    }

    public static javax.megaco.association.SrvChngMethod SrvChngMethodForValue(String value) {
        if (ProtocolToken.GRACEFUL.equalsIgnoreCase(value))
            return javax.megaco.association.SrvChngMethod.GRACEFUL;
        if (ProtocolToken.FORCED.equalsIgnoreCase(value))
            return javax.megaco.association.SrvChngMethod.FORCED;
        if (ProtocolToken.RESTART.equalsIgnoreCase(value))
            return javax.megaco.association.SrvChngMethod.RESTART;
        if (ProtocolToken.DISCONNECTED.equalsIgnoreCase(value))
            return javax.megaco.association.SrvChngMethod.DISCONNECTED;
        if (ProtocolToken.HANDOFF.equalsIgnoreCase(value))
            return javax.megaco.association.SrvChngMethod.HANDOFF;
        if (ProtocolToken.FAILOVER.equalsIgnoreCase(value))
            return javax.megaco.association.SrvChngMethod.FAILOVER;
        if (value != null && (value.startsWith("X+") || value.startsWith("X-")))
            return javax.megaco.association.SrvChngMethod.EXTENSION;

        throw new IllegalArgumentException("token " + value + " not known for type javax.megaco.association.SrvChngMethod");
    }

    static int[] intArray(List<Integer> ba) {
        int[] b = new int[ba.size()];
        for (int i = 0; i < ba.size(); i++) {
            b[i] = (int) ba.get(i);
        }
        return b;
    }

    static double[] doubleArray(List<Double> ba) {
        double[] b = new double[ba.size()];
        for (int i = 0; i < ba.size(); i++) {
            b[i] = (double) ba.get(i);
        }
        return b;
    }

    static int ContextInfoIdForValue(String contextId) {
        if ("-".equals(contextId))
            return ContextInfo.M_CTX_NULL;
        else if ("*".equals(contextId))
            return ContextInfo.M_CTX_ALL;
        else if ("$".equals(contextId))
            return ContextInfo.M_CTX_CHOOSE;
        else
            return Integer.valueOf(contextId);
    }

    /*
     * public static javax.megaco.pkg.ParamValueType
     * ParamValueTypeForValue(String value) { if
     * (ObjectToken.STRING.equalsIgnoreCase(value)) return
     * javax.megaco.pkg.ParamValueType.STRING; if
     * (ObjectToken.INTEGER.equalsIgnoreCase(value)) return
     * javax.megaco.pkg.ParamValueType.INTEGER; if
     * (ObjectToken.BOOLEAN.equalsIgnoreCase(value)) return
     * javax.megaco.pkg.ParamValueType.BOOLEAN; if
     * (ObjectToken.DOUBLE.equalsIgnoreCase(value)) return
     * javax.megaco.pkg.ParamValueType.DOUBLE; throw new
     * IllegalArgumentException("token " + value + " not known for type
     * javax.megaco.pkg.ParamValueType"); }
     *
     */
    /*
     * public static javax.megaco.pkg.PkgItemType PkgItemTypeForValue() { if
     * (ObjectToken.ALL.equalsIgnoreCase(value)) return
     * javax.megaco.pkg.PkgItemType.ALL; if
     * (ProtocolToken.EVENT.equalsIgnoreCase(value)) return
     * javax.megaco.pkg.PkgItemType.EVENT; if
     * (ProtocolToken.SIGNALS.equalsIgnoreCase(value)) return
     * javax.megaco.pkg.PkgItemType.SIGNAL; if
     * (ProtocolToken.STATISTICS.equalsIgnoreCase(value)) return
     * javax.megaco.pkg.PkgItemType.STATISTICS; if
     * (ProtocolToken.PROPERTY.equalsIgnoreCase(value)) return
     * javax.megaco.pkg.PkgItemType.PROPERTY; throw new
     * IllegalArgumentException("token " + value + " not known for type
     * javax.megaco.pkg.PkgItemType"); }
     */
    public static javax.megaco.pkg.ParamRelation ParamRelationForValue(String value) {
        value = value.trim();
        if (ObjectToken.SET.equalsIgnoreCase(value))
            return javax.megaco.pkg.ParamRelation.SET;
        if (ObjectToken.SUBLIST.equalsIgnoreCase(value))
            return javax.megaco.pkg.ParamRelation.SUBLIST;
        if (ObjectToken.RANGE.equalsIgnoreCase(value))
            return javax.megaco.pkg.ParamRelation.RANGE;
        if (ObjectToken.EQUAL.equalsIgnoreCase(value))
            return javax.megaco.pkg.ParamRelation.EQUAL;
        if (ObjectToken.NOTEQUAL.equalsIgnoreCase(value))
            return javax.megaco.pkg.ParamRelation.NOT_EQUAL;
        if (ObjectToken.GREATER.equalsIgnoreCase(value))
            return javax.megaco.pkg.ParamRelation.GREATER;
        if (ObjectToken.LESS.equalsIgnoreCase(value))
            return javax.megaco.pkg.ParamRelation.LESS;
        throw new IllegalArgumentException("token " + value + " not known for type javax.megaco.pkg.ParamRelation");
    }

    public static Class<? extends javax.megaco.pkg.MegacoPkg> packagevalueOfValue(int i) {
        Class<? extends javax.megaco.pkg.MegacoPkg> clazz = null;
        switch (i) {
            case 1: // GENERIC_PACKAGE 
                clazz = javax.megaco.pkg.GenericPkg.GenericPkg.class;
                break;
            case 2: // BASE_ROOT_PACKAGE 
                clazz = javax.megaco.pkg.BaseRootPkg.BaseRootPkg.class;
                break;
            case 3: // TONE_GEN_PACKAGE 
                clazz = javax.megaco.pkg.CPToneGenPkg.CPToneGenPkg.class;
                break;
            case 4: // TONE_DET_PACKAGE 
                clazz = javax.megaco.pkg.CPToneDetPkg.CPToneDetPkg.class;
                break;
            case 5: // BASIC_DTMF_GEN_PACKAGE 
                clazz = javax.megaco.pkg.DTMFGenPkg.DTMFGenPkg.class;
                break;
            case 6: // DTMF_DET_PACKAGE 
                clazz = javax.megaco.pkg.DTMFDetPkg.DTMFDetPkg.class;
                break;
            case 7: // CALL_PROG_TONE_GEN_PACKAGE 
                clazz = javax.megaco.pkg.ToneGenPkg.ToneGenPkg.class;
                break;
            case 8: // CALL_PROG_TONE_DET_PACKAGE 
                clazz = javax.megaco.pkg.ToneDetPkg.ToneDetPkg.class;
                break;
            case 9: // ANALOG_LINE_PACKAGE 
                clazz = javax.megaco.pkg.AnalogLineSPkg.AnalogLineSPkg.class;
                break;
            case 10: // CONTINUITY_PACKAGE 
                clazz = javax.megaco.pkg.ContinuityPkg.ContinuityPkg.class;
                break;
            case 11: // NETWORK_PACKAGE 
                clazz = javax.megaco.pkg.NetworkPkg.NetworkPkg.class;
                break;
            case 12: // RTP_PACKAGE 
                clazz = javax.megaco.pkg.RTPPkg.RTPPkg.class;
                break;
            case 13: // TDM_CKT_PACKAGE 
                clazz = javax.megaco.pkg.TDMCktPkg.TDMCktPkg.class;
                break;
        }
        return clazz;
    }

    static int[] digitStringPositionForValue(String _stringValue) {
        return new int[]{0};
    }
    public static int[] allDigits = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

    static int[] digitMapRangeForValue(String $digitMapRange) {

        if ($digitMapRange.length() == 1)
            return allDigits;

        String[] s = $digitMapRange.substring(1, $digitMapRange.length() - 1).split("-");
        Integer a = Integer.valueOf(s[0]), b = Integer.valueOf(s[1]);

        int p = 0;
        int[] result = new int[b - a + 1];

        for (int i = Integer.valueOf(s[0]); i <= Integer.valueOf(s[1]); i++) {
            result[p++] = i;
        }
        return result;

    }

    static int[] digitMapLetter(String $digitMapLetter) {
        int i = 0;
        char c = $digitMapLetter.charAt(0);
        switch (c) {
            case '0':
            case '1':
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case '8':
            case '9':
                i = c - 0x30;
                break;
            case 'A':
                i = DIGITA;
                break;
            case 'B':
                i = DIGITB;
                break;
            case 'C':
                i = DIGITC;
                break;
            case 'D':
                i = DIGITD;
                break;
            case 'E':
                i = DIGITE;
                break;
            case 'F':
                i = DIGITF;
                break;
            case 'G':
                i = DIGITG;
                break;
            case 'H':
                i = DIGITH;
                break;
            case 'I':
                i = DIGITI;
                break;
            case 'J':
                i = DIGITJ;
                break;
            case 'K':
                i = DIGITK;
                break;
            case 'L':
                i = DIGITL;
                break;
            case 'S':
                i = DIGITS;
                break;
            case 'Z':
                i = DIGITZ;
                break;
            case '*':
                i = DIGIT_STAR;
                break;
            case '#':
                i = DIGIT_HASH;
                break;
            case '.':
                i = DIGIT_DOT;
                break;
            default:
        }
        return new int[]{i};
    }

    static int[] digitLetter(String $digitLetter) {
        return new int[]{Integer.valueOf($digitLetter)};
    }

    public static javax.megaco.message.descriptor.TimeStamp timestampForValue(String s) {
        Integer year = Integer.valueOf(s.substring(0, 4));
        Integer month = Integer.valueOf(s.substring(5, 6));
        Integer day = Integer.valueOf(s.substring(6, 8));
        Integer hour = Integer.valueOf(s.substring(9, 11));
        Integer minute = Integer.valueOf(s.substring(11, 13));
        Integer secs = Integer.valueOf(s.substring(13, 15));
        javax.megaco.message.descriptor.TimeStamp _timeStamp = null;
        /*if (s.length() == 15)
            _timeStamp = new javax.megaco.message.descriptor.TimeStamp(year, month, day, hour, minute, secs);
        else {
        * 
        */
            Integer milli = Integer.valueOf(s.substring(15, s.length()));
         //   System.out.println("milli: "+milli);
            _timeStamp = new javax.megaco.message.descriptor.TimeStamp(year, month, day, hour, minute, secs,milli);
        //}
        return _timeStamp;

    }

    enum ProtocolToken {

        ADD("Add", "A"),
        AUDIT("Audit", "AT"),
        AUDITCAP("AuditCapability", "AC"),
        AUDITVALUE("AuditValue", "AV"),
        AUTH("Authentication", "AU"),
        BOTHWAY("Bothway", "BW"),
        BRIEF("Brief", "BR"),
        BUFFER("Buffer", "BF"),
        CTX("Context", "C"),
        CONTEXTAUDIT("ContextAudit", "CA"),
        DIGITMAP("DigitMap", "DM"),
        DISCONNECTED("Disconnected", "DC"),
        DELAY("Delay", "DL"),
        DURATION("Duration", "DR"),
        EMBED("Embed", "EM"),
        EMERGENCY("Emergency", "EG"),
        ERROR("Error", "ER"),
        EVENTBUFFER("EventBuffer", "EB"),
        EVENTS("Events", "E"),
        FAILOVER("Failover", "FL"),
        FORCED("Forced", "FO"),
        GRACEFUL("Graceful", "GR"),
        H221("H221"),
        H223("H223"),
        H226("H226"),
        HANDOFF("HandOff", "HO"),
        IMMACKREQUIRED("ImmAckRequired", "IA"),
        INACTIVE("Inactive", "IN"),
        ISOLATE("Isolate", "IS"),
        INSVC("InService", "IV"),
        INTERRUPTBYEVENT("IntByEvent", "IBE"),
        INTERRUPTBYNEWSIGNALSDESCR("IntBySigDescr", "IBS"),
        KEEPACTIVE("KeepActive", "KA"),
        LOCAL("Local", "L"),
        LOCALCONTROL("LocalControl", "O"),
        LOCKSTEP("LockStep", "SP"),
        LOOPBACK("Loopback", "LB"),
        MEDIA("Media", "M"),
        MEGACOP("MEGACO", "!"),
        METHOD("Method", "MT"),
        MGCID("MgcIdToTry", "MG"),
        MODE("Mode", "MO"),
        MODIFY("Modify", "MF"),
        MODEM("Modem", "MD"),
        MOVE("Move", "MV"),
        MTP("MTP"),
        MUX("Mux", "MX"),
        NOTIFY("Notify", "N"),
        NOTIFYCOMPLETION("NotifyCompletion", "NC"),
        OBSERVEDEVENTS("ObservedEvents", "OE"),
        ONEWAY("Oneway", "OW"),
        ONOFF("OnOff", "OO"),
        ON("ON"),
        OFF("OFF"),
        OTHERREASON("OtherReason", "OR"),
        OUTOFSVC("OutOfService", "OS"),
        PACKAGES("Packages", "PG"),
        PENDING("Pending", "PN"),
        PRIORITY("Priority", "PR"),
        PROFILE("Profile", "PF"),
        REASON("Reason", "RE"),
        RECVONLY("ReceiveOnly", "RC"),
        REPLY("Reply", "P"),
        RESTART("Restart", "RS"),
        REMOTE("Remote", "R"),
        RESERVEDGROUP("ReservedGroup", "RG"),
        RESERVEDVALUE("ReservedValue", "RV"),
        SENDONLY("SendOnly", "SO"),
        SENDRECV("SendReceive", "SR"),
        SERVICES("Services", "SV"),
        SERVICESTATES("ServiceStates", "SI"),
        SERVICECHANGE("ServiceChange", "SC"),
        SERVICECHANGEADDRESS("ServiceChangeAddress", "AD"),
        SIGNALLIST("SignalList", "SL"),
        SIGNALS("Signals", "SG"),
        SIGNALTYPE("SignalType", "SY"),
        STATS("Statistics", "SA"),
        STREAM("Stream", "ST"),
        SUBTRACT("Subtract", "S"),
        SYNCHISDN("SynchISDN", "SN"),
        TERMINATIONSTATE("TerminationState", "TS"),
        TEST("Test", "TE"),
        TIMEOUT("TimeOut", "TO"),
        TOPOLOGY("Topology", "TP"),
        TRANS("Transaction", "T"),
        RESPONSEACK("TransactionResponseAck", "K"),
        V18("V18"),
        V22("V22"),
        V22BIS("V22b"),
        V32("V32"),
        V32BIS("V32b"),
        V34("V34"),
        V76("V76"),
        V90("V90"),
        V91("V91"),
        VERSION("Version", "V"),
        TERMTYPECHOOSE("$"),
        TERMTYPEROOT("ROOT"),
        TERMTYPEWILDCARD("*"),
        TERMTYPENORMAL("$") //
        ;
        private String[] tokens;

        ProtocolToken(String... tokens) {
            this.tokens = tokens;
        }

        ProtocolToken fromValue(String s) {
            for (ProtocolToken t : this.values()) {
                for (String k : t.tokens) {
                    if (k.equals(s))
                        return t;
                }
            }
            throw new IllegalArgumentException("unknown token : " + s);
        }

        public boolean equalsIgnoreCase(String value) {
            for (String k : this.tokens) {
                if (k.equalsIgnoreCase(value))
                    return true;
            }
            return false;
        }

        public String getFirstToken() {
            return tokens[0];
        }
    }

    enum ObjectToken {

        PACKAGE,
        ALL, SUBLIST, EQUAL("="), GREATER(">"), LESS("<"), INTEGER, BOOLEAN, DOUBLE, STRING, NOTEQUAL, RANGE, SET, REQUEST, OFF("OFF");
        private String[] tokens;

        ObjectToken(String... tokens) {
            this.tokens = tokens;
        }

        ObjectToken fromValue(String s) {
            for (ObjectToken t : this.values()) {
                for (String k : t.tokens) {
                    if (k.equals(s))
                        return t;
                }
            }
            throw new IllegalArgumentException("unknown token : " + s);
        }

        public boolean equalsIgnoreCase(String value) {
            for (String k : this.tokens) {
                if (k.equalsIgnoreCase(value))
                    return true;
            }
            return false;
        }
    }

    enum DTMFEventID {

        d0(0x0010),
        d1(0x0011),
        d2(0x0012),
        d3(0x0013),
        d4(0x0014),
        d5(0x0015),
        d6(0x0016),
        d7(0x0017),
        d8(0x0018),
        d9(0x0019),
        ds(0x0020),
        do_(0x0021),
        da(0x001a),
        db(0x001b),
        dc(0x001c),
        dd(0x001d);
        private int id;

        DTMFEventID(int id) {
            this.id = id;
        }
    }

    enum PackageID {

        g(0x0001),
        root(0x0002),
        tonegen(0x0003),
        tonedet(0x0004),
        dg(0x0005, tonegen),
        dd(0x0006, tonedet),
        cg(0x0007, tonegen),
        cd(0x0008, tonedet),
        al(0x0009),
        ct(0x000a),
        nt(0x000b),
        rtp(0x000c, nt),
        tdmc(0x000d, nt),
        dtd(0x001c),
        an(0x001d),
        bannsyx(0x0047),
        vvsyx(0x0048, bannsyx),
        setsyx(0x0049, bannsyx),
        phrsyx(0x004a, vvsyx),
        aasb(0x0033),
        aasdc(0x0034, aasb),
        aasrec(0x0035, aasb),
        aassm(0x0036),
        asr(0x00a6),
        aastts(0x00a8),
        mpp(0x00a9, aasb),
        mrp(0x00b3, aasrec),
        edtmf(0x0100, dd);
        private PackageID parent;
        private int id;

        PackageID(int id) {
            this.id = id;
        }

        PackageID(int id, PackageID parent) {
            this.id = id;
            this.parent = parent;
        }
    }

    enum PkgEventItemEnum {

        CP_TONE_DET_WT_EVENT(PackageID.cd, 53, javax.megaco.pkg.CPToneDetPkg.CPToneDetWtEvt.class),
        CP_TONE_DET_CW_EVENT(PackageID.cd, 55, javax.megaco.pkg.CPToneDetPkg.CPToneDetCwtEvt.class),
        CP_TONE_DET_SIT_EVENT(PackageID.cd, 52, javax.megaco.pkg.CPToneDetPkg.CPToneDetSitEvt.class),
        CP_TONE_DET_PT_EVENT(PackageID.cd, 54, javax.megaco.pkg.CPToneDetPkg.CPToneDetPtEvt.class),
        CP_TONE_DET_CR_EVENT(PackageID.cd, 56, javax.megaco.pkg.CPToneDetPkg.CPToneDetCrEvt.class),
        CP_TONE_DET_BT_EVENT(PackageID.cd, 50, javax.megaco.pkg.CPToneDetPkg.CPToneDetBtEvt.class),
        CP_TONE_DET_RT_EVENT(PackageID.cd, 49, javax.megaco.pkg.CPToneDetPkg.CPToneDetRtEvt.class),
        CP_TONE_DET_CT_EVENT(PackageID.cd, 51, javax.megaco.pkg.CPToneDetPkg.CPToneDetCtEvt.class),
        CP_TONE_DET_DT_EVENT(PackageID.cd, 48, javax.megaco.pkg.CPToneDetPkg.CPToneDetDtEvt.class),
        DTMF_DET_CE_EVENT(PackageID.dd, 1, javax.megaco.pkg.DTMFDetPkg.DTMFDetCeEvt.class),
        NETWORK_QLTY_ALERT_EVENT(PackageID.nt, 6, javax.megaco.pkg.NetworkPkg.NetworkQualertEvt.class),
        NETWORK_NETFAIL_EVENT(PackageID.nt, 5, javax.megaco.pkg.NetworkPkg.NetworkNetfailEvt.class),
        ANALOG_LINE_OFFHOOK_EVENT(PackageID.al, 5, javax.megaco.pkg.AnalogLineSPkg.AnalogLineSOffEvt.class),
        ANALOG_LINE_ONHOOK_EVENT(PackageID.al, 4, javax.megaco.pkg.AnalogLineSPkg.AnalogLineSOnEvt.class),
        ANALOG_LINE_FLASH_EVENT(PackageID.al, 6, javax.megaco.pkg.AnalogLineSPkg.AnalogLineSFlashEvt.class),
        TONE_DET_STD_EVENT(PackageID.tonedet, 1, javax.megaco.pkg.ToneDetPkg.ToneStdEvent.class),
        TONE_DET_ETD_EVENT(PackageID.tonedet, 2, javax.megaco.pkg.ToneDetPkg.ToneEtdEvent.class),
        TONE_DET_LTD_EVENT(PackageID.tonedet, 4, javax.megaco.pkg.ToneDetPkg.ToneLtdEvent.class),
        CONT_COMPL_EVENT(PackageID.ct, 5, javax.megaco.pkg.ContinuityPkg.ContComplEvt.class),
        RTP_PLTRANS_EVENT(PackageID.rtp, 1, javax.megaco.pkg.RTPPkg.RTPPltransEvt.class),
        GEN_SIG_COMPL_EVENT(PackageID.g, 2, javax.megaco.pkg.GenericPkg.GenSigComplEvent.class),
        GEN_CAUSE_EVENT(PackageID.g, 1, javax.megaco.pkg.GenericPkg.GenCauseEvent.class),;
        private final PackageID p;
        private int id;
        private Class<? extends PkgEventItem> clazz;

        private PkgEventItemEnum(PackageID p, int id, Class<? extends PkgEventItem> clazz) {
            this.p = p;
            this.id = id;
            this.clazz = clazz;
        }

        public Class<? extends PkgEventItem> getClazz() {
            return clazz;
        }

        public int getId() {
            return id;
        }

        static PkgEventItemEnum valueOf(PackageID p, int id) {
            for (PkgEventItemEnum pi : values()) {
                if (pi.p == p && pi.id == id)
                    return pi;
            }
            return null;
        }
    }

    enum PkgPrptyItemEnum {

        ROOT_NORM_MGC_EXEC_TIME_PRPT(PackageID.root, 4, javax.megaco.pkg.BaseRootPkg.RootNormMGCExecTimePrpt.class),
        ROOT_MAX_TERMS_PER_CTXT_PRPT(PackageID.root, 2, javax.megaco.pkg.BaseRootPkg.RootMaxTermsPerCtxtPrpt.class),
        ROOT_MAX_NR_OF_CTXT_PRPT(PackageID.root, 1, javax.megaco.pkg.BaseRootPkg.RootMaxNrOfCtxtPrpt.class),
        ROOT_PROV_RESP_TIME_PRPT(PackageID.root, 5, javax.megaco.pkg.BaseRootPkg.RootProvRespTimePrpt.class),
        ROOT_NORM_MG_EXEC_TIME_PRPT(PackageID.root, 3, javax.megaco.pkg.BaseRootPkg.RootNormMGExecTimePrpt.class),
        TDMC_EC_PRPT(PackageID.tdmc, 8, javax.megaco.pkg.TDMCktPkg.TDMCktEcPrpt.class),
        NETWORK_JIT_PRPT(PackageID.tdmc, 7, javax.megaco.pkg.NetworkPkg.NetworkJitPrpt.class),;
        private final PackageID p;
        private int id;
        private Class<? extends PkgPrptyItem> clazz;

        private PkgPrptyItemEnum(PackageID p, int id, Class<? extends PkgPrptyItem> clazz) {
            this.p = p;
            this.id = id;
            this.clazz = clazz;
        }

        public Class<? extends PkgPrptyItem> getClazz() {
            return clazz;
        }

        public int getId() {
            return id;
        }

        static PkgPrptyItemEnum valueOf(PackageID p, int id) {
            for (PkgPrptyItemEnum pi : values()) {
                if (pi.p == p && pi.id == id)
                    return pi;
            }
            return null;
        }
    }

    enum PkgItemParamEnum {

        DTMF_DET_PARAM_DS(PackageID.dd, 1, javax.megaco.pkg.DTMFDetPkg.DTMFDetParamDs.class),
        DTMF_DET_PARAM_METH(PackageID.dd, 3, javax.megaco.pkg.DTMFDetPkg.DTMFDetParamMeth.class),
        NETWORK_PARAM_CS(PackageID.nt, 1, javax.megaco.pkg.NetworkPkg.NetworkParamCs.class),
        NETWORK_PARAM_TH(PackageID.nt, 2, javax.megaco.pkg.NetworkPkg.NetworkParamTh.class),
        ANALOG_LINE_PARAM_INIT(PackageID.al, 2, javax.megaco.pkg.AnalogLineSPkg.AnalogLineSParamInit.class),
        ANALOG_LINE_PARAM_CAD(PackageID.al, 6, javax.megaco.pkg.AnalogLineSPkg.AnalogLineSParamCad.class),
        ANALOG_LINE_PARAM_STRICT(PackageID.al, 1, javax.megaco.pkg.AnalogLineSPkg.AnalogLineSParamStrict.class),
        ANALOG_LINE_PARAM_FREQ(PackageID.al, 6, javax.megaco.pkg.AnalogLineSPkg.AnalogLineSParamFreq.class),
        ANALOG_LINE_PARAM_MINDUR(PackageID.al, 4, javax.megaco.pkg.AnalogLineSPkg.AnalogLineSParamMindur.class),
        ANALOG_LINE_PARAM_MAXDUR(PackageID.al, 5, javax.megaco.pkg.AnalogLineSPkg.AnalogLineSParamMaxdur.class),
        TONE_GEN_PARAM_TONE_LIST(PackageID.tonegen, 1, javax.megaco.pkg.ToneGenPkg.ToneGenParamTl.class),
        TONE_GEN_PARAM_IND(PackageID.tonegen, 2, javax.megaco.pkg.ToneGenPkg.ToneGenParamInd.class),
        TONE_DET_PARAM_DUR(PackageID.tonedet, 2, javax.megaco.pkg.ToneDetPkg.ToneParamDur.class),
        TONE_DET_PARAM_TL(PackageID.tonedet, 1, javax.megaco.pkg.ToneDetPkg.ToneParamTl.class),
        TONE_DET_PARAM_TID(PackageID.tonedet, 3, javax.megaco.pkg.ToneDetPkg.ToneParamTid.class),
        CONT_PARAM_RES(PackageID.ct, 8, javax.megaco.pkg.ContinuityPkg.ContParamRes.class),
        RTP_PARAM_PL_TYPE(PackageID.rtp, 1, javax.megaco.pkg.RTPPkg.RTPParamRtppltype.class),
        GEN_PARAM_TERM_METH(PackageID.g, 2, javax.megaco.pkg.GenericPkg.GenParamTermMeth.class),
        GEN_PARAM_FAILURE_CAUSE(PackageID.g, 2, javax.megaco.pkg.GenericPkg.GenParamFailureCause.class),
        GEN_PARAM_GENERAL_CAUSE(PackageID.g, 1, javax.megaco.pkg.GenericPkg.GenParamGenCause.class),
        GEN_PARAM_SIGID(PackageID.g, 1, javax.megaco.pkg.GenericPkg.GenParamSigID.class),;
        private final PackageID p;
        private int id;
        private Class<? extends PkgItemParam> clazz;

        private PkgItemParamEnum(PackageID p, int id, Class<? extends PkgItemParam> clazz) {
            this.p = p;
            this.id = id;
            this.clazz = clazz;
        }

        public Class<? extends PkgItemParam> getClazz() {
            return clazz;
        }

        public int getId() {
            return id;
        }

        static PkgItemParamEnum valueOf(PackageID p, int id) {
            for (PkgItemParamEnum pi : values()) {
                if (pi.p == p && pi.id == id)
                    return pi;
            }
            return null;
        }
    }

    enum PkgSignalItemEnum {

        CPTONE_GEN_SIT_SIGNAL(PackageID.cg, 52, javax.megaco.pkg.CPToneGenPkg.CPToneGenSitSignal.class),
        CP_TONE_GEN_PT_SIGNAL(PackageID.cg, 54, javax.megaco.pkg.CPToneGenPkg.CPToneGenPtSignal.class),
        CP_TONE_GEN_CR_SIGNAL(PackageID.cg, 56, javax.megaco.pkg.CPToneGenPkg.CPToneGenCrSignal.class),
        CP_TONE_GEN_BT_SIGNAL(PackageID.cg, 49, javax.megaco.pkg.CPToneGenPkg.CPToneGenRtSignal.class),
        CPTONE_GEN_RT_SIGNAL(PackageID.cg, 50, javax.megaco.pkg.CPToneGenPkg.CPToneGenBtSignal.class),
        CP_TONE_GEN_CT_SIGNAL(PackageID.cg, 51, javax.megaco.pkg.CPToneGenPkg.CPToneGenCtSignal.class),
        CP_TONE_GEN_DT_SIGNAL(PackageID.cg, 48, javax.megaco.pkg.CPToneGenPkg.CPToneGenDtSignal.class),
        CPTONE_GEN_WT_SIGNAL(PackageID.cg, 53, javax.megaco.pkg.CPToneGenPkg.CPToneGenWtSignal.class),
        CP_TONE_GEN_CWT_SIGNAL(PackageID.cg, 55, javax.megaco.pkg.CPToneGenPkg.CPToneGenCwtSignal.class),
        DTMF_GEN_D0_SIGNAL(PackageID.dg, 16, javax.megaco.pkg.DTMFGenPkg.DTMFGenD0Signal.class),
        DTMF_GEN_D1_SIGNAL(PackageID.dg, 17, javax.megaco.pkg.DTMFGenPkg.DTMFGenD1Signal.class),
        DTMF_GEN_D2_SIGNAL(PackageID.dg, 18, javax.megaco.pkg.DTMFGenPkg.DTMFGenD2Signal.class),
        DTMF_GEN_D3_SIGNAL(PackageID.dg, 19, javax.megaco.pkg.DTMFGenPkg.DTMFGenD3Signal.class),
        DTMF_GEN_D4_SIGNAL(PackageID.dg, 20, javax.megaco.pkg.DTMFGenPkg.DTMFGenD4Signal.class),
        DTMF_GEN_D5_SIGNAL(PackageID.dg, 21, javax.megaco.pkg.DTMFGenPkg.DTMFGenD5Signal.class),
        DTMF_GEN_D6_SIGNAL(PackageID.dg, 22, javax.megaco.pkg.DTMFGenPkg.DTMFGenD6Signal.class),
        DTMF_GEN_D7_SIGNAL(PackageID.dg, 23, javax.megaco.pkg.DTMFGenPkg.DTMFGenD7Signal.class),
        DTMF_GEN_D8_SIGNAL(PackageID.dg, 24, javax.megaco.pkg.DTMFGenPkg.DTMFGenD8Signal.class),
        DTMF_GEN_D9_SIGNAL(PackageID.dg, 25, javax.megaco.pkg.DTMFGenPkg.DTMFGenD9Signal.class),
        DTMF_GEN_DSTAR_SIGNAL(PackageID.dg, 32, javax.megaco.pkg.DTMFGenPkg.DTMFGenDStarSignal.class),
        DTMF_GEN_DA_SIGNAL(PackageID.dg, 26, javax.megaco.pkg.DTMFGenPkg.DTMFGenDASignal.class),
        DTMF_GEN_DB_SIGNAL(PackageID.dg, 27, javax.megaco.pkg.DTMFGenPkg.DTMFGenDBSignal.class),
        DTMF_GEN_DC_SIGNAL(PackageID.dg, 28, javax.megaco.pkg.DTMFGenPkg.DTMFGenDCSignal.class),
        DTMF_GEN_DHASH_SIGNAL(PackageID.dg, 33, javax.megaco.pkg.DTMFGenPkg.DTMFGenDHashSignal.class),
        DTMF_GEN_DD_SIGNAL(PackageID.dg, 29, javax.megaco.pkg.DTMFGenPkg.DTMFGenDDSignal.class),
        TONE_GEN_PLAY_TONE_SIGNAL(PackageID.tonegen, 1, javax.megaco.pkg.ToneGenPkg.ToneGenPlayToneSignal.class),
        CONT_RSP_SIGNAL(PackageID.ct, 4, javax.megaco.pkg.ContinuityPkg.ContRspSignal.class),
        CONT_CT_SIGNAL(PackageID.ct, 3, javax.megaco.pkg.ContinuityPkg.ContCtSignal.class),;
        private final PackageID p;
        private int id;
        private Class<? extends PkgSignalItem> clazz;

        private PkgSignalItemEnum(PackageID p, int id, Class<? extends PkgSignalItem> clazz) {
            this.p = p;
            this.id = id;
            this.clazz = clazz;
        }

        public Class<? extends PkgSignalItem> getClazz() {
            return clazz;
        }

        public int getId() {
            return id;
        }

        static PkgSignalItemEnum valueOf(PackageID p, int id) {
            for (PkgSignalItemEnum pi : values()) {
                if (pi.p == p && pi.id == id)
                    return pi;
            }
            return null;
        }
    }

    enum PkgStatsItemEnum {

        NETWORK_DUR_STATS(PackageID.nt, 1, javax.megaco.pkg.NetworkPkg.NetworkDurStats.class),
        NETWORK_OR_STATS(PackageID.nt, 3, javax.megaco.pkg.NetworkPkg.NetworkOrStats.class),
        NETWORK_OS_STATS(PackageID.nt, 2, javax.megaco.pkg.NetworkPkg.NetworkOsStats.class),
        RTP_PL_STATS(PackageID.rtp, 6, javax.megaco.pkg.RTPPkg.RTPPlStats.class),
        RTP_DELAY_STATS(PackageID.rtp, 8, javax.megaco.pkg.RTPPkg.RTPDelayStats.class),
        RTP_PR_STATS(PackageID.rtp, 5, javax.megaco.pkg.RTPPkg.RTPPrStats.class),
        RTP_PS_STATS(PackageID.rtp, 4, javax.megaco.pkg.RTPPkg.RTPPsStats.class),
        RTP_JIT_STATS(PackageID.rtp, 7, javax.megaco.pkg.RTPPkg.RTPJitStats.class);
        private final PackageID p;
        private int id;
        private Class<? extends PkgStatsItem> clazz;

        private PkgStatsItemEnum(PackageID p, int id, Class<? extends PkgStatsItem> clazz) {
            this.p = p;
            this.id = id;
            this.clazz = clazz;
        }

        public Class<? extends PkgStatsItem> getClazz() {
            return clazz;
        }

        public int getId() {
            return id;
        }

        static PkgStatsItemEnum valueOf(PackageID p, int id) {
            for (PkgStatsItemEnum pi : values()) {
                if (pi.p == p && pi.id == id)
                    return pi;
            }
            return null;
        }
    }

    public static StringBuffer concat(StringBuffer buffy, String... value) {
        for (int i = 0; i < value.length; i++) {
            if (value[i] != null)
                ;
        }
        return null;
    }

    public static String coalesce(String... values) {
        for (String e : values) {
            if (e != null)
                return e;
        }

        return null;
    }

    public static boolean valueForBoolean(String value) {
        return Boolean.valueOf(value);
    }

    public static double[] valueForDouble(String value) {
        try {
            return new double[]{Double.valueOf(value)};
        } catch (NumberFormatException x) {
            throw new RuntimeException(value, x);
        }
    }

    public static int[] valueForInteger(String value) {
        return new int[]{Integer.valueOf(value)};
    }

    public static String[] valueForString(String value) {
        return new String[]{value};
    }
    //540 - Unexpected initial hook state
    public static final char LWSP = 0x20;
    public static final char[] EQUAL = new char[]{LWSP, (char) 0x3D, LWSP};
    public static final char COLON = (char) 0x3A;
    public static final char[] LBRKT = new char[]{LWSP, 0x7B, LWSP};
    public static final char[] RBRKT = new char[]{LWSP, 0x7D, LWSP};
    public static final char[] COMMA = new char[]{LWSP, 0x2C, LWSP};
    public static final char DOT = 0x2E;
    public static final char SLASH = 0x2F;
    public static final char DQUOTE = 0x22;
    public static final char SP = 0x20;
    public static final char HTAB = 0x09;
    public static final char CR = 0x0D;
    public static final char LF = 0x0A;
    public static final char EOL = LF;
    public static final char COMMENT = ';';
    public static final char SEP = SP;
    public static final char NOT_EQUAL = '#';
    public static final char LESS = '<';
    public static final char GREATER = '>';
    public static final char RANGE = '?';
    public static final char SET = '?';
    public static final char SUBLIST = '?';
    public static final char CTX_ALL = '*';
    public static final char CTX_CHOOSE = '$';
    public static final char CTX_NULL = '-';
    public static final char HYPHEN = '-';
    public static final char T = 'T';
    public static final char PIPE = '|';
    public static final char LRBRKT = '(';
    public static final char RRBRKT = ')';
    public static final char[] TIMER_L = new char[]{'L', ':'};
    public static final char[] TIMER_S = new char[]{'S', ':'};
    public static final char[] TIMER_T = new char[]{'T', ':'};
    public static final char DIGITSTRINGPOSITION_X = 'x';
    public static final char DIGITSTRINGPOSITION_HASH = '#';
    public static final char DIGITSTRINGPOSITION_STAR = '*';
    public static final char DIGITSTRINGPOSITION_DOT = '.';
}