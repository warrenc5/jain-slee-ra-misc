package mofokom.megaco.resource.impl.codec;

import java.security.SignatureException;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import javax.megaco.message.*;
import javax.megaco.message.descriptor.*;
import javax.megaco.pkg.*;
import org.apache.log4j.Logger;
import static mofokom.megaco.resource.impl.codec.Constants.ProtocolToken.*;
import static mofokom.megaco.resource.impl.codec.Constants.*;
import static javax.megaco.message.descriptor.DigitStringPosition.*;

/**
 *
 * @author wozza
 */
public class ObjectEncoder {

    private Logger logger = slogger;
    private static Logger slogger = Logger.getLogger("megaco.encoder.object");
    DecimalFormat nf, tsnf;

    public ObjectEncoder() {
        nf = new DecimalFormat("###########.##");
        tsnf = new DecimalFormat("##");
    }

    public StringBuffer encode(StringBuffer buffy, String o) throws Exception {
        return buffy.append(o);
    }

    public StringBuffer encode(StringBuffer buffy, Object o) throws Exception {
        return buffy.append(o);
    }

    public StringBuffer encode(java.lang.StringBuffer buffy, javax.sdp.SessionDescription sdp) {
        return null;
    }

    public StringBuffer encodeAuthenticationHeader(java.lang.StringBuffer buffy, String authData, int spi, int sequenceNumber) throws SignatureException {
        buffy.append(AUTH).append(EQUAL).append(spi).append(COLON).append(sequenceNumber).append(COLON).append(authData).append(SEP);
        return buffy;
    }

    public StringBuffer encode(java.lang.StringBuffer buffy, MessageHeader o) {

        if (o.getAuthData() != null)
            try {
                encodeAuthenticationHeader(buffy, o.getAuthData(), o.getSpIndex(), o.getSequenceNumber());
            } catch (SignatureException x) {
                logger.error(x.getMessage(), x);
            }

        buffy.append(MEGACOP.getFirstToken()).append(SLASH).append(o.getProtocolVersion()).append(SEP).append(o.getmId()).append(SEP);
        if (o.isPending())
            buffy.append(PENDING.getFirstToken());
        else if (o.isReply())
            buffy.append(REPLY.getFirstToken());
        else if (o.isTransaction())
            buffy.append(TRANS.getFirstToken());
        else if (o.isTransactionResponseAck())
            buffy.append(RESPONSEACK.getFirstToken());

        if (o.isTransactionResponseAck())
            if (o.getTransactionIdList() != null && !o.getTransactionIdList().isEmpty()) {
                buffy.append(LBRKT);
                for (Integer[] ii : o.getTransactionIdList()) {
                    if (ii.length == 1)
                        buffy.append(ii[0]).append(COMMA);
                    else if (ii.length == 2)
                        buffy.append(ii[0]).append('-').append(ii[1]).append(COMMA);
                }
                fixLastComma(buffy);
                buffy.append(RBRKT);
                return buffy;
            }

        buffy.append(EQUAL).append(o.getTransactionId());

        return buffy;
    }

    public StringBuffer encode(StringBuffer buffy, javax.megaco.pkg.PkgPrptyItem o) throws Exception {
        this.encode(buffy, (javax.megaco.pkg.PkgValueItem) o);
        buffy.append(SLASH).append(this.pkgItemToken(o.getItemsPkgId().getPkgId(), o.getPropertyId(), -1));

        if (o.getItemsValueRelation() != null)
            this.encode(buffy, o.getItemsValueRelation());

        this.encode(buffy, o.getItemValueType(), (javax.megaco.pkg.PkgValueItem) o);

        return buffy;
    }

    public StringBuffer encode(StringBuffer buffy, javax.megaco.pkg.ParamValueType o) throws Exception {
        buffy.append(o.getParamValueType());

        return buffy;
    }

    public StringBuffer encode(StringBuffer buffy, javax.megaco.pkg.PkgItem o) throws Exception {
        buffy.append(this.pkgItemToken(o.getItemsPkgId().getPkgId(), -1, -1));
        return buffy;
    }

    public StringBuffer encode(StringBuffer buffy, javax.megaco.pkg.PkgEventItem o) throws Exception {
        this.encode(buffy, (javax.megaco.pkg.PkgItem) o);
        buffy.append(SLASH);

        buffy.append(this.pkgItemToken(o.getItemsPkgId().getPkgId(), o.getEventId(), -1));

        if (o.getMegacoPkgItemParam() != null && o.getMegacoPkgItemParam().length > 0) {
            buffy.append(LBRKT);
            for (int i = 0; i < o.getMegacoPkgItemParam().length; i++) {
                if (o.getMegacoPkgItemParam()[i] != null) {
                    this.encode(buffy, o, o.getMegacoPkgItemParam()[i]);
                    buffy.append(COMMA);
                }

            }
            fixLastComma(buffy);
            buffy.append(RBRKT);
        }

        return buffy;
    }

    public StringBuffer encode(StringBuffer buffy, javax.megaco.pkg.PkgItemType o) throws Exception {
        buffy.append(o.getPkgItemType());

        return buffy;
    }

    public StringBuffer encode(StringBuffer buffy, javax.megaco.pkg.PkgConsts o) throws Exception {

        return buffy;
    }

    public StringBuffer encode(StringBuffer buffy, javax.megaco.pkg.PkgStatsItem o) throws Exception {
        this.encode(buffy, (javax.megaco.pkg.PkgItem) o);

        buffy.append(SLASH).append(this.pkgItemToken(o.getItemsPkgId().getPkgId(), o.getStatisticsId(), -1));


        if (o.getItemsValueRelation() != null)
            this.encode(buffy, o.getItemsValueRelation());

        this.encode(buffy, o, o.getItemValueType());

        if (o.getItemsDescriptorIds() != null && o.getItemsDescriptorIds().length > 0)
            for (int i = 0; i < o.getItemsDescriptorIds().length; i++) {
                buffy.append(o.getItemsDescriptorIds()[i]);
            }

        return buffy;
    }

    public StringBuffer encode(StringBuffer buffy, javax.megaco.pkg.PkgEventItem e, javax.megaco.pkg.PkgItemParam o) throws Exception {
        //this.encode(buffy, (javax.megaco.pkg.PkgItem) o);
        this.encode(buffy, this.pkgItemToken(o.getItemsPkgId().getPkgId(), e.getEventId(), o.getParamId()));

        if (o.getParamsValueRelation() != null)
            this.encode(buffy, o.getParamsValueRelation());

        this.encode(buffy, o.getParamValueType(), (javax.megaco.pkg.PkgValueItem) o);

        return buffy;
    }

    public StringBuffer encode(StringBuffer buffy, javax.megaco.pkg.PkgItemStr o) throws Exception {
        buffy.append(o.getPkgName()).append(SLASH).append(o.getItemName());
        if (o.getParameter() != null)
            buffy.append(LBRKT).append(o.getParameter()).append(RBRKT);

        return buffy;
    }

    public StringBuffer encode(StringBuffer buffy, javax.megaco.pkg.MegacoPkg o) throws Exception {
        if (o.getPackageName() != null)
            this.encode(buffy, o.getPackageName());

        return buffy;
    }

    public StringBuffer encode(StringBuffer buffy, int type, javax.megaco.pkg.PkgValueItem o) throws Exception {
        switch (type) {
            case ParamValueType.M_BOOLEAN:
                buffy.append(o.getItemBooleanValue());
                break;
            case ParamValueType.M_DOUBLE:
                buffy.append(o.getItemDoubleValue()[0]);
                break;
            case ParamValueType.M_INTEGER:
                buffy.append(o.getItemIntValue()[0]);
                break;
            case ParamValueType.M_STRING:
                buffy.append(o.getItemStringValue()[0]);
                break;
            default:
                break;
        }
        return buffy;
    }

    public StringBuffer encode(StringBuffer buffy, javax.megaco.pkg.PkgSignalItem o) throws Exception {
        this.encode(buffy, (javax.megaco.pkg.PkgItem) o);
        buffy.append(SLASH).append(this.pkgItemToken(o.getItemsPkgId().getPkgId(), o.getItemId(), -1));

        if (o.getMegacoPkgItemParam() != null && o.getMegacoPkgItemParam().length > 0)
            for (int i = 0; i < o.getMegacoPkgItemParam().length; i++) {
                if (o.getMegacoPkgItemParam()[i] != null) {
                    this.encode(buffy, o.getMegacoPkgItemParam()[i]);
                    buffy.append(COMMA);
                }

            }

        fixLastComma(buffy);
        return buffy;
    }

    public StringBuffer encode(StringBuffer buffy, javax.megaco.pkg.ParamRelation o) throws Exception {
        switch (o.getParamRelation()) {
            case ParamRelation.M_EQUAL:
                buffy.append(EQUAL);
                break;
            case ParamRelation.M_GREATER:
                buffy.append(GREATER);
                break;
            case ParamRelation.M_LESS:
                buffy.append(LESS);
                break;
            case ParamRelation.M_NOT_EQUAL:
                buffy.append(NOT_EQUAL);
                break;
            case ParamRelation.M_RANGE:
                buffy.append(RANGE);
                break;
            case ParamRelation.M_SET:
                buffy.append(SET);
                break;
            case ParamRelation.M_SUBLIST:
                buffy.append(SUBLIST);
                break;
            default:
        }

        return buffy;
    }

    public StringBuffer encode(StringBuffer buffy, javax.megaco.message.descriptor.ModemDescriptor o) throws Exception {

        if (o.getModemParam() != null && o.getModemParam().length == 1) {
            buffy.append(EQUAL);
            this.encode(buffy, o.getModemParam()[0]);
        }


        if (o.getModemParam() != null && o.getModemParam().length > 0) {
            buffy.append(LBRKT).append(EOL);
            for (int i = 0; i < o.getModemParam().length; i++) {
                if (o.getModemParam()[i] != null)
                    this.encode(buffy, o.getModemParam()[i]);
                buffy.append(COMMA);
            }
            fixLastComma(buffy);
            buffy.append(RBRKT);
        }

        if (o.getModemParamValue() != null && o.getModemParamValue().length > 0) {
            buffy.append(LBRKT).append(EOL);
            for (int i = 0; i < o.getModemParamValue().length; i++) {
                if (o.getModemParamValue()[i] != null) {
                    this.encode(buffy, o.getModemParamValue()[i]);
                    buffy.append(COMMA);
                }
            }
            fixLastComma(buffy);
            buffy.append(RBRKT);
        }

        buffy.append(EOL).append(RBRKT).append(EOL);

        return buffy;
    }

    public StringBuffer encode(StringBuffer buffy, javax.megaco.message.descriptor.StreamMode o) throws Exception {
        buffy.append(MODE.getFirstToken()).append(EQUAL).append(Constants.valueForStreamMode(o.getStreamMode()));
        return buffy;
    }

    public StringBuffer encode(StringBuffer buffy, javax.megaco.message.descriptor.ServiceState o) throws Exception {
        buffy.append(o.getServiceState());

        return buffy;
    }

    public StringBuffer encode(StringBuffer buffy, javax.megaco.message.descriptor.SDPInfo o) throws Exception {
        if (o.getSessionDescStr() != null)
            buffy.append(o.getSessionDescStr());
        if (o.getSessionDescription() != null)
            this.encode(buffy, o.getSessionDescription());

        return buffy;
    }

    public StringBuffer encode(StringBuffer buffy, javax.megaco.message.descriptor.SrvChngRespDescriptor o) throws Exception {
        buffy.append(LBRKT).append(EOL);
        if (o.getSrvChngMethod() != null) {
            buffy.append(METHOD.getFirstToken()).append(EQUAL);
            buffy.append(Constants.valueForSrvChngMethod(o.getSrvChngMethod().getSrvChngMethodId()));
            buffy.append(COMMA);
        }
        if (o.getDateValue() != null || o.getTimeValue() != null) {
            if (o.getDateValue() != null)
                this.encode(buffy, o.getDateValue());
            if (o.getTimeValue() != null) {
                buffy.append(T);
                this.encode(buffy, o.getTimeValue());
            }
        }

        if (o.getHandOffMGCId() != null)
            this.encode(buffy, o.getHandOffMGCId());
        if (o.getSrvChngAddress() != null) {
            buffy.append(SERVICECHANGEADDRESS.getFirstToken()).append(EQUAL);
            this.encode(buffy, o.getSrvChngAddress());
            buffy.append(COMMA);
        }
        if (o.getSrvChngProfile() != null) {
            buffy.append(PROFILE.getFirstToken()).append(EQUAL);
            this.encode(buffy, o.getSrvChngProfile());
            if (o.isProtocolVersionPresent())
                buffy.append(SLASH).append(o.getProtocolVersion());
        }
        fixLastComma(buffy);

        buffy.append(EOL).append(RBRKT).append(EOL);
        return buffy;
    }

    public StringBuffer encode(StringBuffer buffy, javax.megaco.message.descriptor.TimeStamp o) throws Exception {
        /*
         * buffy.append(tsnf.format(o.getYear()));
         * buffy.append(tsnf.format(o.getMonth()));
         * buffy.append(tsnf.format(o.getDay())); buffy.append(T);
         * buffy.append(tsnf.format(o.getHour()));
         * buffy.append(tsnf.format(o.getMinutes()));
         * buffy.append(tsnf.format(o.getSecs()));
         *
         */

        buffy.append(o.toStringEncode());

        return buffy;
    }

    public StringBuffer encode(StringBuffer buffy, javax.megaco.message.descriptor.TermStateDescriptor o) throws Exception {
        buffy.append(TERMINATIONSTATE.getFirstToken());
        buffy.append(LBRKT).append(EOL);

        if (o.getServiceState() != null)
            buffy.append(ProtocolToken.SERVICESTATES.getFirstToken()).append(EQUAL).append(Constants.valueForServiceState(o.getServiceState().getServiceState())).append(COMMA);

        if (o.getEvtBufferControl() != null)
            buffy.append(BUFFER.getFirstToken()).append(EQUAL).append(Constants.valueForEventBufferCtrl(o.getEvtBufferControl().getEvtBufferControl()));

        if (o.getMegacoPkgItemStr() != null && o.getMegacoPkgItemStr().length > 0) {
            for (int i = 0; i < o.getMegacoPkgItemStr().length; i++) {
                if (o.getMegacoPkgItemStr()[i] != null) {
                    this.encode(buffy, o.getMegacoPkgItemStr()[i]);
                    buffy.append(COMMA);
                }
            }
            fixLastComma(buffy);
        }
        if (o.getMegacoPkgPrptyItem() != null && o.getMegacoPkgPrptyItem().length > 0) {
            for (int i = 0; i < o.getMegacoPkgPrptyItem().length; i++) {
                if (o.getMegacoPkgPrptyItem()[i] != null) {
                    this.encode(buffy, o.getMegacoPkgPrptyItem()[i]);
                    buffy.append(COMMA);
                }
            }
            fixLastComma(buffy);
        }

        buffy.append(RBRKT);

        return buffy;
    }

    public StringBuffer encode(StringBuffer buffy, javax.megaco.message.descriptor.EmbedFirstEventParam o) throws Exception {
        if (o.getEventParam() != null)
            this.encode(buffy, o.getEventParam());
        buffy.append(o.getRequestIdentifier());
        if (o.getMegacoPkgEventItem() != null)
            this.encode(buffy, o.getMegacoPkgEventItem());
        if (o.getMegacoPkgItemStr() != null)
            this.encode(buffy, o.getMegacoPkgItemStr());

        return buffy;
    }

    public StringBuffer encode(StringBuffer buffy, javax.megaco.message.descriptor.SrvChngDescriptor o) throws Exception {
        buffy.append(LBRKT).append(EOL);

        if (o.getSrvChngProfile() != null) {
            buffy.append(PROFILE.getFirstToken()).append(EQUAL);
            this.encode(buffy, o.getSrvChngProfile());
            if (o.isProtocolVersionPresent())
                buffy.append(SLASH).append(o.getProtocolVersion());
            buffy.append(COMMA);
        }

        if (o.getSrvChngAddress() != null) {
            buffy.append(SERVICECHANGEADDRESS.getFirstToken()).append(EQUAL);
            this.encode(buffy, o.getSrvChngAddress());
            buffy.append(COMMA);
        }
        if (o.getParameterExtension() != null) {
            buffy.append(PROFILE.getFirstToken()).append(EQUAL);
            this.encode(buffy, o.getParameterExtension());
            buffy.append(COMMA);
        }
        if (o.isSrvChngDelayPresent()) {
            buffy.append(DELAY.getFirstToken()).append(EQUAL);
            buffy.append(o.getSrvChngDelay());
            buffy.append(COMMA);
        }
        if (o.getSrvChngReason() != null) {
            buffy.append(REASON.getFirstToken()).append(EQUAL);
            this.encode(buffy, o.getSrvChngReason());
            buffy.append(COMMA);
        }
        if (o.getHandOffMGCId() != null) {
            buffy.append(MGCID.getFirstToken()).append(EQUAL);
            this.encode(buffy, o.getHandOffMGCId());
            buffy.append(COMMA);
        }
        if (o.getDateValue() != null)
            this.encode(buffy, o.getDateValue());
        if (o.getTimeValue() != null) {
            buffy.append(T);
            this.encode(buffy, o.getTimeValue());
            buffy.append(COMMA);
        }
        if (o.getSrvChngMethod() != null) {
            buffy.append(METHOD.getFirstToken()).append(EQUAL);
            if (o.getSrvChngMethod().getSrvChngMethodId() == javax.megaco.association.SrvChngMethod.M_EXTENSION)
                this.encode(buffy, o.getSvcChngMethodExtension());
            else
                buffy.append(Constants.valueForSrvChngMethod(o.getSrvChngMethod().getSrvChngMethodId()));
            buffy.append(COMMA);
        }

        fixLastComma(buffy);

        buffy.append(RBRKT);

        return buffy;
    }

    public StringBuffer encode(StringBuffer buffy, javax.megaco.message.descriptor.EventBufferDescriptor o) throws Exception {
        buffy.append(LBRKT).append(EOL);

        if (o.getEventBufParam() != null && o.getEventBufParam().length > 0) {
            for (int i = 0; i < o.getEventBufParam().length; i++) {
                if (o.getEventBufParam()[i] != null) {
                    this.encode(buffy, o.getEventBufParam()[i]);
                    buffy.append(COMMA);
                }
            }
            fixLastComma(buffy);
        }

        buffy.append(RBRKT);

        return buffy;
    }

    public StringBuffer encode(StringBuffer buffy, javax.megaco.message.descriptor.MuxType o) throws Exception {
        buffy.append(o.getMuxType());

        return buffy;
    }

    public StringBuffer encode(StringBuffer buffy, javax.megaco.message.descriptor.DigitStringPosition o) throws Exception {
        if (o.getDigitStringPosition() != null && o.getDigitStringPosition().length > 0)
            if (Arrays.equals(o.getDigitStringPosition(), allDigits)) //FIXME do array equals
                buffy.append(DIGITSTRINGPOSITION_X);
            else if (o.getDigitStringPosition().length > 1) {
                buffy.append('[');
                buffy.append(o.getDigitStringPosition()[0]);
                buffy.append('-');
                buffy.append(o.getDigitStringPosition()[o.getDigitStringPosition().length - 1]);
                buffy.append(']');
            } else {
                char c = 0;
                switch (o.getDigitStringPosition()[0]) {
                    case DIGIT0:
                    case DIGIT1:
                    case DIGIT2:
                    case DIGIT3:
                    case DIGIT4:
                    case DIGIT5:
                    case DIGIT6:
                    case DIGIT7:
                    case DIGIT8:
                    case DIGIT9:
                        buffy.append(o.getDigitStringPosition()[0]);
                        break;
                    case DIGITA:
                        buffy.append('A');
                        break;
                    case DIGITB:
                        buffy.append('B');
                        break;
                    case DIGITC:
                        buffy.append('C');
                        break;
                    case DIGITD:
                        buffy.append('D');
                        break;
                    case DIGITE:
                        buffy.append('E');
                        break;
                    case DIGITF:
                        buffy.append('F');
                        break;
                    case DIGITG:
                        buffy.append('G');
                        break;
                    case DIGITH:
                        buffy.append('H');
                        break;
                    case DIGITI:
                        buffy.append('I');
                        break;
                    case DIGITJ:
                        buffy.append('J');
                        break;
                    case DIGITK:
                        buffy.append('K');
                        break;
                    case DIGITL:
                        buffy.append('L');
                        break;
                    case DIGITS:
                        buffy.append('S');
                        break;
                    case DIGITZ:
                        buffy.append('Z');
                        break;
                    case DIGIT_DOT:
                        buffy.append('.');
                        break;
                    case DIGIT_STAR:
                        buffy.append('*');
                        break;
                    case DIGIT_HASH:
                        buffy.append('#');
                        break;
                    default:
                }
            }

        return buffy;
    }

    public StringBuffer encode(StringBuffer buffy, javax.megaco.message.descriptor.SignalDescriptor o) throws Exception {
        buffy.append(LBRKT).append(EOL);
        if (o.getSignalParam() != null && o.getSignalParam().length > 0)
            for (int i = 0; i < o.getSignalParam().length; i++) {
                if (o.getSignalParam()[i] != null)
                    this.encode(buffy, o.getSignalParam()[i]);
            }
        buffy.append(RBRKT);
        return buffy;
    }

    public StringBuffer encode(StringBuffer buffy, javax.megaco.message.descriptor.SignalNotifyReason o) throws Exception {
        buffy.append(o.getNotifyReason());

        return buffy;
    }

    public StringBuffer encode(StringBuffer buffy, javax.megaco.message.descriptor.ModemParamValue o) throws Exception {
        if (o.getParamsValueRelation() != null)
            this.encode(buffy, o.getParamsValueRelation());
        if (o.getParamsValue() != null && o.getParamsValue().length > 0)
            for (int i = 0; i < o.getParamsValue().length; i++) {
                if (o.getParamsValue()[i] != null) {
                    this.encode(buffy, o.getParamsValue()[i]);
                    buffy.append(COMMA);
                }
            }
        fixLastComma(buffy);
        if (o.getParamName() != null)
            this.encode(buffy, o.getParamName());

        return buffy;
    }

    public StringBuffer encode(StringBuffer buffy, javax.megaco.message.descriptor.EventDescriptor o) throws Exception {
        if (o.getRequestId() > 0)
            buffy.append(EQUAL).append(o.getRequestId());

        if (o.getRequestedEventParam() != null && o.getRequestedEventParam().length > 0) {
            buffy.append(LBRKT).append(EOL);
            for (int i = 0; i < o.getRequestedEventParam().length; i++) {
                if (o.getRequestedEventParam()[i] != null) {
                    this.encode(buffy, o.getRequestedEventParam()[i]);
                    buffy.append(COMMA);
                }
            }
            fixLastComma(buffy);
            buffy.append(RBRKT);
        }
        return buffy;
    }

    public StringBuffer encode(StringBuffer buffy, javax.megaco.message.descriptor.ModemParam o) throws Exception {
        if (o.getModemType() != null)
            this.encode(buffy, o.getModemType());
        if (o.getExtensionString() != null)
            this.encode(buffy, o.getExtensionString());

        return buffy;
    }

    public StringBuffer encode(StringBuffer buffy, javax.megaco.message.descriptor.RequestedEventParam o) throws Exception {
        if (o.getMegacoPkgItemStr() != null)
            this.encode(buffy, o.getMegacoPkgItemStr()).append(SLASH);
        if (o.getMegacoPkgEventItem() != null)
            this.encode(buffy, o.getMegacoPkgEventItem());

        if (o.getEventParam() != null)
            this.encode(buffy, o.getEventParam());
        if (o.getEmbedFirstEventParam() != null)
            this.encode(buffy, o.getEmbedFirstEventParam());

        return buffy;
    }

    public StringBuffer encode(StringBuffer buffy, javax.megaco.message.descriptor.PackageDescriptor o) throws Exception {
        buffy.append(LBRKT).append(EOL);

        if (o.getMegacoPkgItemsStr() != null && o.getMegacoPkgItemsStr().length > 0)
            for (int i = 0; i < o.getMegacoPkgItemsStr().length; i++) {
                if (o.getMegacoPkgItemsStr()[i] != null) {
                    this.encode(buffy, o.getMegacoPkgItemsStr()[i]);
                    buffy.append(COMMA);
                }
            }
        if (o.getMegacoPkgItems() != null && o.getMegacoPkgItems().length > 0)
            for (int i = 0; i < o.getMegacoPkgItems().length; i++) {
                if (o.getMegacoPkgItems()[i] != null) {
                    this.encode(buffy, o.getMegacoPkgItems()[i]);
                    buffy.append(COMMA);
                }
            }
        fixLastComma(buffy);


        buffy.append(RBRKT);
        return buffy;
    }

    public StringBuffer encode(StringBuffer buffy, javax.megaco.message.descriptor.PackagesItem o) throws Exception {
        this.encode(buffy, o.getMegacoPkg());
        buffy.append(HYPHEN).append(o.getPkgVersion());

        return buffy;
    }

    public StringBuffer encode(StringBuffer buffy, javax.megaco.message.descriptor.SignalParam o) throws Exception {

        if (o.getSignalParamType() == javax.megaco.message.descriptor.SignalParamType.M_LIST)
            buffy.append(SIGNALLIST.getFirstToken()).append(EQUAL).append(o.getSignalParamListId()).append(LBRKT);
        if (o.getSignalRequest() != null && o.getSignalRequest().length > 0)
            for (int i = 0; i < o.getSignalRequest().length; i++) {
                if (o.getSignalRequest()[i] != null)
                    this.encode(buffy, o.getSignalRequest()[i]);
            }

        if (o.getSignalParamType() == javax.megaco.message.descriptor.SignalParamType.M_LIST)
            buffy.append(RBRKT);

        return buffy;
    }

    public StringBuffer encode(StringBuffer buffy, javax.megaco.message.descriptor.EventBufParam o) throws Exception {
        if (o.getMegacoPkgEvtItem() != null)
            this.encode(buffy, o.getMegacoPkgEvtItem());
        if (o.getMegacoPkgItemStr() != null)
            this.encode(buffy, o.getMegacoPkgItemStr());
        if (o.isStreamIdPresent())
            buffy.append(o.getStreamId());

        return buffy;
    }

    public StringBuffer encode(StringBuffer buffy, javax.megaco.message.descriptor.EventBufferCtrl o) throws Exception {
        buffy.append(o.getEvtBufferControl());

        return buffy;
    }

    public StringBuffer encode(StringBuffer buffy, javax.megaco.message.descriptor.EventParam o) throws Exception {
        if (o.getDigitMapName() != null)
            this.encode(buffy, o.getDigitMapName());
        if (o.getDigitMapValue() != null)
            this.encode(buffy, o.getDigitMapValue());
        if (o.isStreamIdPresent())
            buffy.append(o.getStreamId());
        if (o.getDigitMapValueStr() != null)
            this.encode(buffy, o.getDigitMapValueStr());
        if (o.getSignalDescriptor() != null)
            this.encode(buffy, o.getSignalDescriptor());
        if (o.isKeepActivePresent())
            buffy.append("");

        return buffy;
    }

    public StringBuffer encode(StringBuffer buffy, javax.megaco.message.descriptor.AuditValRespDescriptor o) throws Exception {
        buffy.append(LBRKT).append(EOL);
        /*
         * if (o.getDescriptor() != null && o.getDescriptor().length > 0) for
         * (int i = 0; i < o.getDescriptor().length; i++) { if
         * (o.getDescriptor()[i] != null) this.encode(buffy,
         * o.getDescriptor()[i]); if (i < o.getDescriptor().length - 1)
         * buffy.append(COMMA); buffy.append(EOL);
         *
         * }
         *
         */
        if (o.isObsEventTokenPresent())
            buffy.append(OBSERVEDEVENTS.getFirstToken()).append(COMMA);
        if (o.isEventBuffTokenPresent())
            buffy.append(EVENTBUFFER.getFirstToken()).append(COMMA);
        if (o.isPackagesTokenPresent())
            buffy.append(PACKAGES.getFirstToken()).append(COMMA);
        if (o.isStatsTokenPresent())
            buffy.append(STATS.getFirstToken()).append(COMMA);
        if (o.isEventsTokenPresent())
            buffy.append(EVENTS.getFirstToken()).append(COMMA);
        if (o.isDigitMapTokenPresent())
            buffy.append(DIGITMAP.getFirstToken()).append(COMMA);
        if (o.isMuxTokenPresent())
            buffy.append(MUX.getFirstToken()).append(COMMA);
        if (o.isSignalTokenPresent())
            buffy.append(SIGNALS.getFirstToken()).append(COMMA);
        if (o.isMediaTokenPresent())
            buffy.append(MEDIA.getFirstToken()).append(COMMA);
        if (o.isModemTokenPresent())
            buffy.append(MODEM.getFirstToken()).append(COMMA);

        buffy.setLength(buffy.length() - 2);

        buffy.append(RBRKT).append(EOL);
        return buffy;
    }

    public StringBuffer encode(StringBuffer buffy, javax.megaco.message.descriptor.ModemType o) throws Exception {
        buffy.append(o.getModemType());

        return buffy;
    }

    public StringBuffer encode(StringBuffer buffy, javax.megaco.message.descriptor.AuditValDescriptor o) throws Exception {
        buffy.append(LBRKT).append(EOL);

        if (o.isModemTokenPresent())
            buffy.append(MODEM.getFirstToken()).append(COMMA);
        if (o.isSignalTokenPresent())
            buffy.append(SIGNALS.getFirstToken()).append(COMMA);
        if (o.isMediaTokenPresent())
            buffy.append(MEDIA.getFirstToken()).append(COMMA);
        if (o.isMuxTokenPresent())
            buffy.append(MUX.getFirstToken()).append(COMMA);
        if (o.isStatsTokenPresent())
            buffy.append(STATS.getFirstToken()).append(COMMA);
        if (o.isEventsTokenPresent())
            buffy.append(EVENTS.getFirstToken()).append(COMMA);
        if (o.isDigitMapTokenPresent())
            buffy.append(DIGITMAP.getFirstToken()).append(COMMA);
        if (o.isEventBuffTokenPresent())
            buffy.append(EVENTBUFFER.getFirstToken()).append(COMMA);
        if (o.isPackagesTokenPresent())
            buffy.append(PACKAGES.getFirstToken()).append(COMMA);
        if (o.isObsEventTokenPresent())
            buffy.append(OBSERVEDEVENTS.getFirstToken()).append(COMMA);

        fixLastComma(buffy);

        buffy.append(RBRKT).append(EOL);
        return buffy;
    }

    public StringBuffer encode(StringBuffer buffy, javax.megaco.message.descriptor.MuxDescriptor o) throws Exception {

        buffy.append(LBRKT).append(EOL);

        buffy.append(MUX).append(EQUAL);
        if (o.getMuxType() != null)
            buffy.append(Constants.valueForMuxType(o.getMuxType().getMuxType()));
        if (o.getExtensionString() != null)
            buffy.append(o.getExtensionString());

        if (o.getTerminationIdList() != null && o.getTerminationIdList().length > 0)
            for (int i = 0; i < o.getTerminationIdList().length; i++) {
                if (o.getTerminationIdList()[i] != null) {
                    this.encode(buffy, o.getTerminationIdList()[i]);
                    buffy.append(COMMA);
                }
            }

        fixLastComma(buffy);

        buffy.append(RBRKT);
        return buffy;
    }

    public StringBuffer encode(StringBuffer buffy, javax.megaco.message.descriptor.ObservedEvent o) throws Exception {
        if (o.getTimeStamp() != null) {
            this.encode(buffy, o.getTimeStamp());
            buffy.append(COLON);
        }
        if (o.getMegacoPkgEvtItem() != null)
            this.encode(buffy, o.getMegacoPkgEvtItem());
        else if (o.getMegacoPkgItemStr() != null)
            this.encode(buffy, o.getMegacoPkgItemStr());

        if (o.isStreamIdPresent()) {
            buffy.append(STREAM.getFirstToken()).append(EQUAL);
            buffy.append(o.getStreamId());
        }

        return buffy;
    }

    public StringBuffer encode(StringBuffer buffy, javax.megaco.message.descriptor.TopologyDescriptor o) throws Exception {
        buffy.append(LBRKT).append(EOL);
        buffy.append(o.getDescriptorId());
        if (o.getTermA() != null)
            this.encode(buffy, o.getTermA());
        buffy.append(o.getTopologyDirection());
        if (o.getTermB() != null)
            this.encode(buffy, o.getTermB());

        buffy.append(RBRKT);
        return buffy;
    }

    public StringBuffer encode(StringBuffer buffy, javax.megaco.message.descriptor.MediaStreamParam o) throws Exception {
        if (o.getLclCtrlDescriptor() != null) {
            this.encode(buffy, o.getLclCtrlDescriptor());
            buffy.append(COMMA);
        }
        if (o.getLocalDescriptor() != null) {
            buffy.append(LOCAL.getFirstToken()).append(LBRKT);
            this.encode(buffy, o.getLocalDescriptor());
            buffy.append(RBRKT).append(COMMA);
        }
        if (o.getRemoteDescriptor() != null) {
            buffy.append(REMOTE.getFirstToken()).append(LBRKT);
            this.encode(buffy, o.getRemoteDescriptor());
            buffy.append(RBRKT);
        } else
            fixLastComma(buffy);

        return buffy;
    }

    public StringBuffer encode(StringBuffer buffy, javax.megaco.message.descriptor.TopologyDirection o) throws Exception {
        buffy.append(o.getTopologyDirection());

        return buffy;
    }

    public StringBuffer encode(StringBuffer buffy, javax.megaco.message.descriptor.LocalCtrlDescriptor o) throws Exception {
        buffy.append(LOCALCONTROL.getFirstToken());
        buffy.append(LBRKT).append(EOL);

        if (o.isReserveValuePresent()) {
            buffy.append(RESERVEDVALUE.getFirstToken()).append(EQUAL);
            if (o.getReserveValue())
                buffy.append(ON.getFirstToken());
            else
                buffy.append(OFF.getFirstToken());

            buffy.append(COMMA);
        }

        if (o.isReserveGroupPresent()) {
            buffy.append(RESERVEDGROUP.getFirstToken()).append(EQUAL);
            if (o.getReserveGroup())
                buffy.append(ON.getFirstToken());
            else
                buffy.append(OFF.getFirstToken());
            buffy.append(COMMA);
        }

        if (o.getStreamMode() != null) {
            this.encode(buffy, o.getStreamMode());
            buffy.append(COMMA);
        }

        if (o.getMegacoPkgItemStr() != null && o.getMegacoPkgItemStr().length > 0)
            for (int i = 0; i < o.getMegacoPkgItemStr().length; i++) {
                if (o.getMegacoPkgItemStr()[i] != null) {
                    this.encode(buffy, o.getMegacoPkgItemStr()[i]);
                    buffy.append(COMMA);
                }
            }
        if (o.getMegacoPkgPrptyItem() != null && o.getMegacoPkgPrptyItem().length > 0)
            for (int i = 0; i < o.getMegacoPkgPrptyItem().length; i++) {
                if (o.getMegacoPkgPrptyItem()[i] != null) {
                    this.encode(buffy, o.getMegacoPkgPrptyItem()[i]);
                    buffy.append(COMMA);
                }
            }

        fixLastComma(buffy);

        buffy.append(RBRKT);
        return buffy;
    }

    public StringBuffer encode(StringBuffer buffy, javax.megaco.message.descriptor.SignalType o) throws Exception {
        buffy.append(o.getSignalType());

        return buffy;
    }

    public StringBuffer encode(StringBuffer buffy, javax.megaco.message.descriptor.CntxtTermAudDescriptor o) throws Exception {
        buffy.append(LBRKT).append(EOL);
        if (o.getErrorDescriptor() != null)
            this.encode(buffy, o.getErrorDescriptor());
        if (o.getTerminationIdList() != null && o.getTerminationIdList().length > 0)
            for (int i = 0; i < o.getTerminationIdList().length; i++) {
                if (o.getTerminationIdList()[i] != null) {
                    this.encode(buffy, o.getTerminationIdList()[i]);
                    buffy.append(COMMA);
                }

            }
        fixLastComma(buffy);

        buffy.append(RBRKT);
        return buffy;
    }

    public StringBuffer encode(StringBuffer buffy, javax.megaco.message.descriptor.AuditCapRespDescriptor o) throws Exception {
        buffy.append(LBRKT).append(EOL);
        /*
         * if (o.getDescriptor() != null && o.getDescriptor().length > 0) for
         * (int i = 0; i < o.getDescriptor().length; i++) { if
         * (o.getDescriptor()[i] != null) this.encode(buffy,
         * o.getDescriptor()[i]); if (i < o.getDescriptor().length - 1)
         * buffy.append(COMMA); buffy.append(EOL);
         *
         * }
         *
         */
        if (o.isEventBuffTokenPresent())
            buffy.append(EVENTBUFFER.getFirstToken()).append(COMMA);
        if (o.isObsEventTokenPresent())
            buffy.append(OBSERVEDEVENTS.getFirstToken()).append(COMMA);
        if (o.isSignalTokenPresent())
            buffy.append(SIGNALS.getFirstToken()).append(COMMA);
        if (o.isMediaTokenPresent())
            buffy.append(MEDIA.getFirstToken()).append(COMMA);
        if (o.isModemTokenPresent())
            buffy.append(MODEM.getFirstToken()).append(COMMA);
        if (o.isStatsTokenPresent())
            buffy.append(STATS.getFirstToken()).append(COMMA);
        if (o.isEventsTokenPresent())
            buffy.append(EVENTS.getFirstToken()).append(COMMA);
        if (o.isMuxTokenPresent())
            buffy.append(MUX.getFirstToken()).append(COMMA);

        fixLastComma(buffy);

        buffy.append(EOL).append(RBRKT).append(EOL);
        return buffy;
    }

    public StringBuffer encode(StringBuffer buffy, javax.megaco.message.descriptor.ObsEventDescriptor o) throws Exception {
        if (o.getRequestId() > 0)
            buffy.append(EQUAL).append(o.getRequestId());

        if (o.getObservedEvent() != null && o.getObservedEvent().length > 0) {
            buffy.append(LBRKT).append(EOL);
            for (int i = 0; i < o.getObservedEvent().length; i++) {
                if (o.getObservedEvent()[i] != null) {
                    this.encode(buffy, o.getObservedEvent()[i]);
                    buffy.append(COMMA);
                }
            }
            fixLastComma(buffy);
            buffy.append(EOL).append(RBRKT).append(EOL);
        }

        return buffy;
    }

    public StringBuffer encode(StringBuffer buffy, javax.megaco.message.descriptor.DigitMapString o) throws Exception {
        if (o.getDigitStringPosition() != null && o.getDigitStringPosition().length > 0)
            for (int i = 0; i < o.getDigitStringPosition().length; i++) {
                if (o.getDigitStringPosition()[i] != null)
                    this.encode(buffy, o.getDigitStringPosition()[i]);
            }

        return buffy;
    }

    public StringBuffer encode(StringBuffer buffy, javax.megaco.message.descriptor.SignalRequest o) throws Exception {
        if (o.isSignalNotifyReasonPresent())
            buffy.append(NOTIFYCOMPLETION.getFirstToken()).append(EQUAL).append(o.getSignalNotifyReason()).append(COMMA); //FIXME MULTIPLE
        if (o.isSignalTypePresent())
            buffy.append(SIGNALTYPE.getFirstToken()).append(EQUAL).append(Constants.forSignalType(o.getSignalType())).append(COMMA);
        if (o.isDurationPresent())
            buffy.append(DURATION.getFirstToken()).append(EQUAL).append(o.getSignalDuration()).append(COMMA);
        if (o.isKeepAliveSet())
            buffy.append(KEEPACTIVE.getFirstToken()).append(COMMA);
        if (o.getMegacoPkgSignalItem() != null)
            this.encode(buffy, o.getMegacoPkgSignalItem()).append(COMMA);
        if (o.getMegacoPkgItemStr() != null)
            this.encode(buffy, o.getMegacoPkgItemStr()).append(COMMA);
        if (o.isStreamIdPresent())
            buffy.append(STREAM.getFirstToken()).append(EQUAL).append(o.getStreamId()).append(COMMA);

        fixLastComma(buffy);
        return buffy;
    }

    public StringBuffer encode(StringBuffer buffy, javax.megaco.message.descriptor.ErrorDescriptor o) throws Exception {
        buffy.append(LBRKT).append(EOL);
        if (o.getErrorString() != null)
            this.encode(buffy, o.getErrorString());
        buffy.append(o.getDescriptorId());
        buffy.append(o.getProtErrorCode());

        buffy.append(EOL).append(RBRKT).append(EOL);
        return buffy;
    }

    public StringBuffer encode(StringBuffer buffy, javax.megaco.message.descriptor.AuditCapDescriptor o) throws Exception {
        buffy.append(LBRKT).append(EOL);

        if (o.isMuxTokenPresent())
            buffy.append(MUX.getFirstToken()).append(COMMA);
        if (o.isStatsTokenPresent())
            buffy.append(STATS.getFirstToken()).append(COMMA);
        if (o.isEventsTokenPresent())
            buffy.append(EVENTS.getFirstToken()).append(COMMA);
        if (o.isModemTokenPresent())
            buffy.append(MODEM.getFirstToken()).append(COMMA);
        if (o.isMediaTokenPresent())
            buffy.append(MEDIA.getFirstToken()).append(COMMA);
        if (o.isSignalTokenPresent())
            buffy.append(SIGNALS.getFirstToken()).append(COMMA);
        if (o.isObsEventTokenPresent())
            buffy.append(OBSERVEDEVENTS.getFirstToken()).append(COMMA);
        if (o.isEventBuffTokenPresent())
            buffy.append(EVENTS.getFirstToken()).append(COMMA);

        buffy.setLength(buffy.length() - 2);

        buffy.append(EOL).append(RBRKT).append(EOL);
        return buffy;
    }

    public StringBuffer encode(StringBuffer buffy, javax.megaco.message.descriptor.StreamDescriptor o) throws Exception {
        if (o.isStreamIdPresent())
            buffy.append(EQUAL).append(o.getStreamId());
        buffy.append(LBRKT).append(EOL);
        if (o.getMediaStreamParam() != null)
            this.encode(buffy, o.getMediaStreamParam());
        buffy.append(RBRKT);
        return buffy;
    }

    public StringBuffer encode(StringBuffer buffy, javax.megaco.message.descriptor.DigitMapValue o) throws Exception {
        if (o.isTimerTPresent())
            buffy.append(TIMER_T).append(o.getTimerTValue()).append(COMMA);
        if (o.isTimerSPresent())
            buffy.append(TIMER_S).append(o.getTimerSValue()).append(COMMA);
        if (o.isTimerLPresent())
            buffy.append(TIMER_L).append(o.getTimerLValue()).append(COMMA);

        if (o.getDigitMapStrings() != null && o.getDigitMapStrings().length > 0) {
            buffy.append(LRBRKT);
            for (int i = 0; i < o.getDigitMapStrings().length; i++) {
                if (o.getDigitMapStrings()[i] != null) {
                    this.encode(buffy, o.getDigitMapStrings()[i]);
                    if (i < o.getDigitMapStrings().length - 1)
                        buffy.append(PIPE);
                }
            }
            buffy.append(RRBRKT);
        }
        return buffy;
    }

    public StringBuffer encode(StringBuffer buffy, javax.megaco.message.descriptor.DigitMapDescriptor o) throws Exception {
        buffy.append(EQUAL);
        if (o.getDigitMapName() != null)
            this.encode(buffy, o.getDigitMapName());
        buffy.append(LBRKT).append(EOL);
        if (o.getDigitMapValue() != null) {
            this.encode(buffy, o.getDigitMapValue());
            if (o.getDigitMapValueStr() != null)
                this.encode(buffy, o.getDigitMapValueStr());
            buffy.append(EOL).append(RBRKT).append(EOL);
        }

        return buffy;
    }

    public StringBuffer encode(StringBuffer buffy, javax.megaco.message.descriptor.StatsDescriptor o) throws Exception {
        buffy.append(LBRKT).append(EOL);
        if (o.getMegacoPkgStatsItem() != null && o.getMegacoPkgStatsItem().length > 0)
            for (int i = 0; i < o.getMegacoPkgStatsItem().length; i++) {
                if (o.getMegacoPkgStatsItem()[i] != null)
                    this.encode(buffy, o.getMegacoPkgStatsItem()[i]);
                if (i < o.getMegacoPkgStatsItem().length - 1)
                    buffy.append(COMMA);
                buffy.append(EOL);
            }
        if (o.getMegacoPkgItemStr() != null && o.getMegacoPkgItemStr().length > 0)
            for (int i = 0; i < o.getMegacoPkgItemStr().length; i++) {
                if (o.getMegacoPkgItemStr()[i] != null)
                    this.encode(buffy, o.getMegacoPkgItemStr()[i]);
            }
        buffy.append(EOL).append(RBRKT).append(EOL);

        return buffy;
    }

    public StringBuffer encode(StringBuffer buffy, javax.megaco.message.descriptor.MediaDescriptor o) throws Exception {
        buffy.append(LBRKT).append(EOL);

        if (o.getTermStateDescriptor() != null) {
            this.encode(buffy, (TermStateDescriptor) o.getTermStateDescriptor());
            buffy.append(COMMA);
        }

        if (o.getStreamDescriptor() != null && o.getStreamDescriptor().length > 0) {
            for (int i = 0; i < o.getStreamDescriptor().length; i++) {
                if (o.getStreamDescriptor()[i] != null) {
                    buffy.append(STREAM.getFirstToken());
                    this.encode(buffy, (StreamDescriptor) o.getStreamDescriptor()[i]);
                }
            }
            buffy.append(COMMA);
        }

        if (o.getMediaStreamParam() != null) {
            this.encode(buffy, o.getMediaStreamParam());
            buffy.append(COMMA);
        }

        fixLastComma(buffy);

        buffy.append(EOL).append(RBRKT).append(EOL);

        return buffy;
    }

    public StringBuffer encode(StringBuffer buffy, javax.megaco.message.DescriptorType o) throws Exception {
        buffy.append(o.getDescType());

        return buffy;
    }

    public StringBuffer encode(StringBuffer buffy, javax.megaco.message.CommandType o) throws Exception {


        return buffy;
    }

    public StringBuffer encode(StringBuffer buffy, javax.megaco.message.CommandReq o) throws Exception {
        if (o.isReqWithWildcardResp())
            buffy.append("W");
        if (o.isCommandOptional())
            buffy.append("O");

        if (o.isReqWithWildcardResp() || o.isReqWithWildcardResp())
            buffy.append("-");

        switch (o.getRequestIdentifier()) {
            case CmdRequestType.M_ADD_REQ:
                buffy.append(ADD.getFirstToken());
                break;
            case CmdRequestType.M_MODIFY_REQ:
                buffy.append(MODIFY.getFirstToken());
                break;
            case CmdRequestType.M_MOVE_REQ:
                buffy.append(MOVE.getFirstToken());
                break;
            case CmdRequestType.M_SERVICE_CHANGE_REQ:
                buffy.append(SERVICECHANGE.getFirstToken());
                break;
            case CmdRequestType.M_NOTIFY_REQ:
                buffy.append(NOTIFY.getFirstToken());
                break;
            case CmdRequestType.M_AUDIT_VAL_REQ:
                buffy.append(AUDITVALUE.getFirstToken());
                break;
            case CmdRequestType.M_AUDIT_CAP_REQ:
                buffy.append(AUDITCAP.getFirstToken());
                break;
            case CmdRequestType.M_SUBTRACT_REQ:
                buffy.append(SUBTRACT.getFirstToken());
                break;
        }
        return buffy;
    }

    public StringBuffer encode(StringBuffer buffy, javax.megaco.message.CommandResp o) throws Exception {
        if (o.isLastCommandResp())
            buffy.append("");

        switch (o.getResponseIdentifier()) {
            case CmdResponseType.M_ADD_RESP:
                buffy.append(ADD.getFirstToken());
                break;
            case CmdResponseType.M_MODIFY_RESP:
                buffy.append(MODIFY.getFirstToken());
                break;
            case CmdResponseType.M_MOVE_RESP:
                buffy.append(MOVE.getFirstToken());
                break;
            case CmdResponseType.M_SERVICE_CHANGE_RESP:
                buffy.append(SERVICECHANGE.getFirstToken());
                break;
            case CmdResponseType.M_NOTIFY_RESP:
                buffy.append(NOTIFY.getFirstToken());
                break;
            case CmdResponseType.M_AUDIT_VAL_RESP:
                buffy.append(AUDITVALUE.getFirstToken());
                break;
            case CmdResponseType.M_AUDIT_CAP_RESP:
                buffy.append(AUDITCAP.getFirstToken());
                break;
            case CmdResponseType.M_SUBTRACT_RESP:
                buffy.append(SUBTRACT.getFirstToken());
                break;
        }

        return buffy;
    }

    public StringBuffer encode(StringBuffer buffy, javax.megaco.message.Termination o) throws Exception {
        switch (o.getTermType()) {
            case TermType.M_CHOOSE:
                buffy.append(TERMTYPECHOOSE.getFirstToken());
                break;
            case TermType.M_NORMAL:
                if (o.getTextTermName() != null)
                    this.encode(buffy, o.getTextTermName());
                else if (o.getBinTermName() != null && o.getBinTermName().length > 0)
                    for (int i = 0; i < o.getBinTermName().length; i++) {
                        buffy.append(o.getBinTermName()[i]);
                    }
                break;
            case TermType.M_ROOT:
                buffy.append(TERMTYPEROOT.getFirstToken());
                break;
            case TermType.M_WILDCARD:
                buffy.append(TERMTYPEWILDCARD.getFirstToken());
                //if (o.getTermWildCard() != null && o.getTermWildCard().length > 0)
                //   for (int i = 0; i < o.getTermWildCard().length; i++) {
                //      buffy.append(o.getTermWildCard()[i]);
                // }
                break;
            default:
        }

        return buffy;
    }

    public StringBuffer encode(StringBuffer buffy, javax.megaco.message.TermType o) throws Exception {
        buffy.append(o.getTermType());

        return buffy;
    }

    public StringBuffer encode(StringBuffer buffy, javax.megaco.message.Descriptor o) throws Exception {
        switch (o.getDescriptorId()) {
            case DescriptorType.M_AUDIT_CAP_DESC:
                buffy.append(AUDIT.getFirstToken());
                encode(buffy, (AuditCapDescriptor) o);
                break;
            case DescriptorType.M_AUDIT_CAP_REPLY_DESC:
                buffy.append(AUDIT.getFirstToken());
                encode(buffy, (AuditCapRespDescriptor) o);
                break;
            case DescriptorType.M_AUDIT_VAL_DESC:
                buffy.append(AUDIT.getFirstToken());
                encode(buffy, (AuditValDescriptor) o);
                break;
            case DescriptorType.M_AUDIT_VAL_REPLY_DESC:
                buffy.append(AUDIT.getFirstToken());
                encode(buffy, (AuditValRespDescriptor) o);
                break;
            case DescriptorType.M_CTX_TERM_AUDIT_DESC:
                buffy.append(CONTEXTAUDIT.getFirstToken());
                encode(buffy, (CntxtTermAudDescriptor) o);
                break;
            case DescriptorType.M_DIGIT_MAP_DESC:
                buffy.append(DIGITMAP.getFirstToken());
                encode(buffy, (DigitMapDescriptor) o);
                break;
            case DescriptorType.M_ERROR_DESC:
                buffy.append(ERROR.getFirstToken());
                encode(buffy, (ErrorDescriptor) o);
                break;
            case DescriptorType.M_EVENT_BUF_DESC:
                buffy.append(EVENTBUFFER.getFirstToken());
                encode(buffy, (EventBufferDescriptor) o);
                break;
            case DescriptorType.M_EVENT_DESC:
                buffy.append(EVENTS.getFirstToken());
                encode(buffy, (EventDescriptor) o);
                break;
            case DescriptorType.M_LOCAL_CONTROL_DESC:
                buffy.append(LOCALCONTROL.getFirstToken());
                encode(buffy, (LocalCtrlDescriptor) o);
                break;
            case DescriptorType.M_MEDIA_DESC:
                buffy.append(MEDIA.getFirstToken());
                encode(buffy, (MediaDescriptor) o);
                break;
            case DescriptorType.M_MODEM_DESC:
                buffy.append(MODEM.getFirstToken());
                encode(buffy, (ModemDescriptor) o);
                break;
            case DescriptorType.M_MUX_DESC:
                buffy.append(MUX.getFirstToken());
                encode(buffy, (MuxDescriptor) o);
                break;
            case DescriptorType.M_OBSERVED_EVENT_DESC:
                buffy.append(OBSERVEDEVENTS.getFirstToken());
                encode(buffy, (ObsEventDescriptor) o);
                break;
            case DescriptorType.M_PACKAGE_DESC:
                buffy.append(PACKAGES.getFirstToken());
                encode(buffy, (PackageDescriptor) o);
                break;
            case DescriptorType.M_SERVICE_CHANGE_DESC:
                buffy.append(SERVICES.getFirstToken());
                encode(buffy, (SrvChngDescriptor) o);
                break;
            case DescriptorType.M_SERVICE_CHANGE_RESP_DESC:
                buffy.append(SERVICES.getFirstToken());
                encode(buffy, (SrvChngRespDescriptor) o);
                break;
            case DescriptorType.M_SIGNAL_DESC:
                buffy.append(SIGNALS.getFirstToken());
                encode(buffy, (SignalDescriptor) o);
                break;
            case DescriptorType.M_STATISTICS_DESC:
                buffy.append(STATS.getFirstToken());
                encode(buffy, (StatsDescriptor) o);
                break;
            case DescriptorType.M_STREAM_DESC:
                buffy.append(STREAM.getFirstToken());
                encode(buffy, (StreamDescriptor) o);
                break;
            case DescriptorType.M_TERMINATION_STATE_DESC:
                buffy.append(TERMINATIONSTATE.getFirstToken());
                //encode(buffy, (TermStateDescriptor) o);
                break;
            case DescriptorType.M_TOPOLOGY_DESC:
                buffy.append(TOPOLOGY.getFirstToken());
                encode(buffy, (TopologyDescriptor) o);
                break;
            default:
                throw new IllegalArgumentException("descriptor id " + o.getDescriptorId() + " not known " + o.getClass().getSimpleName());
        }
        return buffy;
    }

    public StringBuffer encode(StringBuffer buffy, javax.megaco.message.CmdRequestType o) throws Exception {
        buffy.append(o.getCmdRequestType());

        return buffy;
    }

    public StringBuffer encode(StringBuffer buffy, javax.megaco.message.ContextInfo o) throws Exception {

        buffy.append(CTX.getFirstToken()).append(EQUAL);

        switch (o.getContextId()) {
            case javax.megaco.message.ContextInfo.M_CTX_ALL:
                buffy.append(CTX_ALL);
                break;
            case javax.megaco.message.ContextInfo.M_CTX_CHOOSE:
                buffy.append(CTX_CHOOSE);
                break;
            case javax.megaco.message.ContextInfo.M_CTX_NULL:
                buffy.append(CTX_NULL);
                break;
            default:
                buffy.append(o.getContextId());
        }

        if (o.getContextParam() != null) {
            buffy.append(LBRKT).append(EOL);
            this.encode(buffy, o.getContextParam());
            buffy.append(RBRKT).append(EOL);
        }

        return buffy;
    }

    public StringBuffer encode(StringBuffer buffy, javax.megaco.message.ContextParam o) throws Exception {
        if (o.getTopologyDescriptor() != null && o.getTopologyDescriptor().length > 0)
            for (int i = 0; i < o.getTopologyDescriptor().length; i++) {
                if (o.getTopologyDescriptor()[i] != null)
                    this.encode(buffy, o.getTopologyDescriptor()[i]);
            }
        if (o.isEMPresent())
            buffy.append(EMERGENCY).append(COMMA);
        if (o.isPriorityPresent())
            buffy.append(PRIORITY.getFirstToken()).append(EQUAL).append(o.getPriority());

        return buffy;
    }

    public StringBuffer encode(StringBuffer buffy, List<javax.megaco.CommandEvent> o) throws Exception {
        for (int i = 0; i < o.size(); i++) {
            if (!(o.get(i) instanceof ContextInfoReq || o.get(i) instanceof ContextInfoResp)) {
                this.encode(buffy, o.get(i));
                if (i < o.size() - 1)
                    buffy.append(COMMA);
            }
        }
        return buffy;
    }

    public StringBuffer encode(StringBuffer buffy, javax.megaco.CommandEvent o) throws Exception {
        //this.encode(buffy, (java.util.EventObject) o);
        //buffy.append(EQUAL).append(o.getActionHandle());

        switch (o.getCommandIdentifier()) {
            case CommandType.M_ACTION_REQ:
                this.encode(buffy, (ContextInfoReq) o);
                break;
            case CommandType.M_ACTION_RESP:
                this.encode(buffy, (ContextInfoResp) o);
                break;
            case CommandType.M_COMMAND_REQ:
                this.encode(buffy, (CommandReq) o);
                break;
            case CommandType.M_COMMAND_RESP:
                this.encode(buffy, (CommandResp) o);
                break;
        }

        if (o.getTermination() != null) {
            buffy.append(EQUAL);
            this.encode(buffy, o.getTermination());
        }


        //TODO do context manipulation

//        if (o.isLastCommandInTxn())
        //           buffy.append("");

        //buffy.append(o.getExchangeId());
        if (o.getDescriptor() != null && o.getDescriptor().length > 0) {
            buffy.append(LBRKT).append(EOL);
            for (int i = 0; i < o.getDescriptor().length; i++) {
                if (o.getDescriptor()[i] != null)
                    this.encode(buffy, o.getDescriptor()[i]);
                if (i < o.getDescriptor().length - 1)
                    buffy.append(COMMA);
                buffy.append(EOL);
            }
            buffy.append(RBRKT).append(EOL);
        }
        //if (o.getCntxtInfo() != null)
        //   this.encode(buffy, o.getCntxtInfo());

//        buffy.append(o.getTxnHandle());
        //buffy.append(o.getAssocHandle());

        //       if (o.isFirstCommandInAction())
        //          buffy.append("");

        return buffy;
    }

    public StringBuffer encode(StringBuffer buffy, javax.megaco.message.ContextInfoReq o) throws Exception {
        return buffy;
    }

    public StringBuffer encode(StringBuffer buffy, javax.megaco.message.ContextInfoResp o) throws Exception {
        return buffy;
    }

    public StringBuffer encode(StringBuffer buffy, javax.megaco.association.LocalAddr o) throws Exception {
        if (o.getMtp3Addr() != null)
            this.encode(buffy, o.getMtp3Addr());
        if (o.getIpAddr() != null && o.getIpAddr().length > 0)
            for (int i = 0; i < o.getIpAddr().length; i++) {
                if (o.getIpAddr()[i] != null)
                    this.encode(buffy, o.getIpAddr()[i]);
            }
        if (o.isTransportTypePresent())
            buffy.append(o.getTransportType());
        if (o.getAAL5Addr() != null)
            this.encode(buffy, o.getAAL5Addr());
        if (o.getDomainName() != null)
            this.encode(buffy, o.getDomainName());
        if (o.isPortIdPresent())
            buffy.append(o.getPortId());

        return buffy;
    }

    public StringBuffer encode(StringBuffer buffy, javax.megaco.association.RemoteAddr o) throws Exception {
        if (o.isPortIdPresent())
            buffy.append(o.getPortId());
        if (o.getDomainName() != null)
            this.encode(buffy, o.getDomainName());
        buffy.append(o.getTransportType());
        if (o.getAAL5Addr() != null)
            this.encode(buffy, o.getAAL5Addr());
        if (o.getAddrString() != null)
            this.encode(buffy, o.getAddrString());
        if (o.getMtp3Addr() != null)
            this.encode(buffy, o.getMtp3Addr());
        if (o.getIpAddr() != null && o.getIpAddr().length > 0)
            for (int i = 0; i < o.getIpAddr().length; i++) {
                if (o.getIpAddr()[i] != null)
                    this.encode(buffy, o.getIpAddr()[i]);
            }

        return buffy;
    }

    public StringBuffer encode(StringBuffer buffy, javax.megaco.association.SrvChngMethod o) throws Exception {
        buffy.append(o.getSrvChngMethodId());

        return buffy;
    }

    public StringBuffer encode(StringBuffer buffy, javax.megaco.association.SrvChngReason o) throws Exception {
        buffy.append(o.getSrvChngReasonId());

        return buffy;
    }

    /*
     * public StringBuffer encode(StringBuffer buffy, java.util.EventObject o)
     * throws Exception { if (o.getSource() != null) this.encode(buffy,
     * o.getSource());
     *
     * return buffy; }
     *
     */
    protected StringBuffer encode(StringBuffer buffy, PkgValueItem o, int type) throws Exception {
        switch (type) {
            case ParamValueType.M_DOUBLE:
                if (o.getItemDoubleValue() != null && o.getItemDoubleValue().length > 0)
                    for (int i = 0; i < o.getItemDoubleValue().length; i++) {
                        buffy.append(nf.format(o.getItemDoubleValue()[i]));
                    }
                break;
            case ParamValueType.M_INTEGER:
                if (o.getItemIntValue() != null && o.getItemIntValue().length > 0)
                    for (int i = 0; i < o.getItemIntValue().length; i++) {
                        buffy.append(o.getItemIntValue()[i]);
                    }
                break;
            case ParamValueType.M_BOOLEAN:
                buffy.append(o.getItemBooleanValue());
                break;
            case ParamValueType.M_STRING:

                if (o.getItemStringValue() != null && o.getItemStringValue().length > 0)
                    for (int i = 0; i < o.getItemStringValue().length; i++) {
                        if (o.getItemStringValue()[i] != null)
                            this.encode(buffy, o.getItemStringValue()[i]);
                    }
                break;
            default:
        }
        return buffy;
    }

    static String pkgItemToken(int packageId, int itemId, int paramId) {
// 2
        if (itemId == -1 && 2 == packageId)
            return "root";
        if (itemId != 0 && (2 == packageId)) {
            if (paramId != 0 && itemId == 4)
                return "normalMGCExecutionTime";
            if (paramId != 0 && itemId == 2)
                return "maxTerminationsPerContext";
            if (paramId != 0 && itemId == 1)
                return "maxNumberOfContexts";
            if (paramId != 0 && itemId == 5)
                return "MGProvisionalResponseTimerValue";
            if (paramId != 0 && itemId == 3)
                return "normalMGExecutionTime";
        }
// 7
        if (itemId == -1 && 7 == packageId)
            return "cg";
        if (itemId != 0 && (7 == packageId)) {
            if (itemId == 52)
                return "sit";
            if (itemId == 54)
                return "prt";
            if (itemId == 56)
                return "cr";
            if (itemId == 49)
                return "rt";
            if (itemId == 50)
                return "bt";
            if (itemId == 51)
                return "ct";
            if (itemId == 48)
                return "dt";
            if (itemId == 53)
                return "wt";
            if (itemId == 55)
                return "cw";
        }
// 5
        if (itemId == -1 && 5 == packageId)
            return "dg";
        if (itemId != 0 && (5 == packageId)) {
            if (itemId == 16)
                return "d0";
            if (itemId == 17)
                return "d1";
            if (itemId == 18)
                return "d2";
            if (itemId == 19)
                return "d3";
            if (itemId == 20)
                return "d4";
            if (itemId == 21)
                return "d5";
            if (itemId == 22)
                return "d6";
            if (itemId == 23)
                return "d7";
            if (itemId == 24)
                return "d8";
            if (itemId == 25)
                return "d9";
            if (itemId == 32)
                return "ds";
            if (itemId == 26)
                return "da";
            if (itemId == 27)
                return "db";
            if (itemId == 28)
                return "dc";
            if (itemId == 33)
                return "do";
            if (itemId == 29)
                return "dd";
        }
// 8
        if (itemId == -1 && 8 == packageId)
            return "cd";
        if (itemId != 0 && (8 == packageId)) {
            if (itemId == 53)
                return "wt";
            if (itemId == 55)
                return "cw";
            if (itemId == 52)
                return "sit";
            if (itemId == 54)
                return "prt";
            if (itemId == 56)
                return "cr";
            if (itemId == 50)
                return "bt";
            if (itemId == 49)
                return "rt";
            if (itemId == 51)
                return "ct";
            if (itemId == 48)
                return "dt";
        }
// 13
        if (itemId == -1 && 13 == packageId)
            return "tdmc";
        if (itemId != 0 && (13 == packageId)) {
            if (paramId != 0 && itemId == 8)
                return "ec";
            if (paramId != 0 && itemId == 10)
                return "gain";
        }
// 6
        if (itemId == -1 && 6 == packageId)
            return "dd";
        if (itemId != 0 && (6 == packageId || 256 == packageId))
            if (itemId == 1)
                return "dur";
// 11
        if (itemId == -1 && 11 == packageId)
            return "nt";

        if (itemId != 0 && (11 == packageId || 13 == packageId)) {//FIXME || 12 == packageId)) {
            if (paramId != 0 && itemId == 7)
                return "jit";
            if (itemId == 1)
                return "dur";
            if (itemId == 3)
                return "or";
            if (itemId == 2)
                return "os";
            if (itemId == 6 && paramId == 1)
                return "th";
            if (itemId == 6 && paramId == 1)
                return "th";
            if (itemId == 6)
                return "qualert";
            if (itemId == 5 && paramId == 1)
                return "cs";
            if (itemId == 5)
                return "netfail";
        }
// 9
        if (itemId == -1 && 9 == packageId)
            return "al";
        if (itemId != 0 && (9 == packageId)) {
            if (itemId == 5 && paramId == 1)
                return "strict";
            if (itemId == 5 && paramId == 2)
                return "init";
            if (itemId == 5)
                return "of";
            if (itemId == 4 && paramId == 1)
                return "strict";
            if (itemId == 4 && paramId == 2)
                return "init";
            if (itemId == 4)
                return "on";
            if (itemId == 6 && paramId == 4)
                return "mindur";
            if (itemId == 6 && paramId == 5)
                return "maxdur";
            if (itemId == 6)
                return "fl";
            if (itemId == 2 && paramId == 6)
                return "cad";
            if (itemId == 2 && paramId == 7)
                return "freq";
            if (itemId == 2)
                return "ri";
        }
// 3
        if (itemId == -1 && 3 == packageId)
            return "tonegen";
        if (itemId != 0 && (3 == packageId || 7 == packageId || 5 == packageId)) {
            if (itemId == 1 && paramId == 1)
                return "tl";
            if (itemId == 1 && paramId == 2)
                return "ind";
            if (itemId == 1)
                return "pt";
        }
// 4
        if (itemId == -1 && 4 == packageId)
            return "tonedet";
        if (itemId != 0 && (4 == packageId || 8 == packageId || 6 == packageId)) {
            if (itemId == 1 && paramId == 1)
                return "tl";
            if (itemId == 1 && paramId == 3)
                return "tid";
            if (itemId == 1)
                return "std";
            if (itemId == 2 && paramId == 1)
                return "tl";
            if (itemId == 2 && paramId == 3)
                return "tid";
            if (itemId == 2 && paramId == 2)
                return "dur";
            if (itemId == 2)
                return "etd";
            if (itemId == 4 && paramId == 1)
                return "ds";
            if (itemId == 4 && paramId == 3)
                return "Meth";
            if (itemId == 4)
                return "ce";
        }
// 10
        if (itemId == -1 && 10 == packageId)
            return "ct";
        if (itemId != 0 && (10 == packageId)) {
            if (itemId == 5 && paramId == 8)
                return "res";
            if (itemId == 5)
                return "cmp";
            if (itemId == 4)
                return "rsp";
            if (itemId == 3)
                return "ct";
        }
// 12
        if (itemId == -1 && 12 == packageId)
            return "rtp";
        if (itemId != 0 && (12 == packageId)) {
            if (itemId == 6)
                return "pl";
            if (itemId == 8)
                return "delay";
            if (itemId == 5)
                return "pr";
            if (itemId == 4)
                return "ps";
            if (itemId == 7)
                return "jit";
            if (itemId == 1 && paramId == 1)
                return "rtppltype";
            if (itemId == 1)
                return "pltrans";
        }
// 1
        if (itemId == -1 && 1 == packageId)
            return "g";
        if (itemId != 0 && (1 == packageId)) {
            if (itemId == 2 && paramId == 1)
                return "SigID";
            if (itemId == 2 && paramId == 2)
                return "Meth";
            if (itemId == 2 && paramId == 3)
                return "SLID";
            if (itemId == 2)
                return "sc";
            if (itemId == 1 && paramId == 1)
                return "Generalcause";
            if (itemId == 1 && paramId == 2)
                return "Failurecause";
            if (itemId == 1)
                return "cause";
        }
// 28
        if (itemId == -1 && 28 == packageId)
            return "dtd";
        if (itemId != 0 && (28 == packageId)) {
            if (paramId != 0 && itemId == 1)
                return "tid";
            if (paramId != 0 && itemId == 2)
                return "tst";
        }
// 29
        if (itemId == -1 && 29 == packageId)
            return "an";
        if (itemId != 0 && (29 == packageId)) {
            if (itemId == 1 && paramId == 1)
                return "an";
            if (itemId == 1 && paramId == 2)
                return "noc";
            if (itemId == 1 && paramId == 3)
                return "av";
            if (itemId == 1 && paramId == 4)
                return "di";
            if (itemId == 1)
                return "apf";
            if (itemId == 2 && paramId == 1)
                return "an";
            if (itemId == 2 && paramId == 3)
                return "av";
            if (itemId == 2 && paramId == 7)
                return "di";
            if (itemId == 2 && paramId == 2)
                return "noc";
            if (itemId == 2 && paramId == 4)
                return "num";
            if (itemId == 2 && paramId == 5)
                return "spi";
            if (itemId == 2 && paramId == 6)
                return "sp";
            if (itemId == 2)
                return "apv";
        }
// 71
        if (itemId == -1 && 71 == packageId)
            return "bannsyx";
// 72
        if (itemId == -1 && 72 == packageId)
            return "vvsyx";
// 73
        if (itemId == -1 && 73 == packageId)
            return "setsyx";
// 74
        if (itemId == -1 && 74 == packageId)
            return "phrsyx";
// 51
        if (itemId == -1 && 51 == packageId)
            return "aasb";
        if (itemId != 0 && (51 == packageId || 52 == packageId || 53 == packageId || 169 == packageId)) {
            if (itemId == 1 && paramId == 1)
                return "rc";
            if (itemId == 1)
                return "audfail";
            if (itemId == 18 && paramId == 1)
                return "ap";
            if (itemId == 18 && paramId == 2)
                return "off";
            if (itemId == 18)
                return "playcom";
            if (itemId == 1 && paramId == 1)
                return "rc";
            if (itemId == 1)
                return "play";
        }
// 52
        if (itemId == -1 && 52 == packageId)
            return "aasdc";
        if (itemId != 0 && (52 == packageId)) {
            if (itemId == 1)
                return "audfail";
            if (itemId == 2 && paramId == 1)
                return "dc";
            if (itemId == 2 && paramId == 2)
                return "na";
            if (itemId == 2 && paramId == 3)
                return "ap";
            if (itemId == 2 && paramId == 4)
                return "contdc";
            if (itemId == 2)
                return "pcolsucc";
            if (itemId == 2 && paramId == 1)
                return "dc";
            if (itemId == 2 && paramId == 2)
                return "na";
            if (itemId == 2 && paramId == 3)
                return "ap";
            if (itemId == 2 && paramId == 4)
                return "contdc";
            if (itemId == 2)
                return "playcol";
        }
// 53
        if (itemId == -1 && 53 == packageId)
            return "aasrec";
        if (itemId != 0 && (53 == packageId || 179 == packageId)) {
            if (paramId != 0 && itemId == 3)
                return "maxtrl";
            if (itemId == 1)
                return "audfail";
            if (itemId == 2 && paramId == 1)
                return "ap";
            if (itemId == 2 && paramId == 2)
                return "na";
            if (itemId == 2 && paramId == 3)
                return "res";
            if (itemId == 2 && paramId == 4)
                return "ri";
            if (itemId == 2 && paramId == 5)
                return "rdur";
            if (itemId == 2 && paramId == 6)
                return "ek";
            if (itemId == 2 && paramId == 7)
                return "reclen";
            if (itemId == 2 && paramId == 8)
                return "contdc";
            if (itemId == 2)
                return "precsucc";
            if (itemId == 2 && paramId == 1)
                return "ap";
            if (itemId == 2 && paramId == 2)
                return "na";
            if (itemId == 2 && paramId == 3)
                return "res";
            if (itemId == 2 && paramId == 4)
                return "ri";
            if (itemId == 2 && paramId == 5)
                return "rdur";
            if (itemId == 2 && paramId == 6)
                return "ek";
            if (itemId == 2 && paramId == 7)
                return "reclen";
            if (itemId == 2 && paramId == 8)
                return "contdc";
            if (itemId == 2)
                return "playrec";
            if (itemId == 3)
                return "makepers";
        }
// 54
        if (itemId == -1 && 54 == packageId)
            return "aassm";
        if (itemId != 0 && (54 == packageId)) {
            if (paramId != 0 && itemId == 1)
                return "ctlnam";
            if (itemId == 1)
                return "delpers";
            if (itemId == 2 && paramId == 1)
                return "tgtsid";
            if (itemId == 2 && paramId == 2)
                return "oversid";
            if (itemId == 2)
                return "override";
            if (itemId == 3 && paramId == 1)
                return "tgtsid";
            if (itemId == 3)
                return "restore";
        }
// 166
        if (itemId == -1 && 166 == packageId)
            return "asr";
        if (itemId != 0 && (166 == packageId)) {
            if (itemId == 1)
                return "asrfail";
            if (itemId == 2 && paramId == 1)
                return "asrr";
            if (itemId == 2 && paramId == 2)
                return "asrrft";
            if (itemId == 2)
                return "asrsucc";
            if (itemId == 1)
                return "asrwgs";
            if (itemId == 2 && paramId == 1)
                return "asrr";
            if (itemId == 2 && paramId == 2)
                return "asrrft";
            if (itemId == 2)
                return "asrid";
        }
// 168
        if (itemId == -1 && 168 == packageId)
            return "aastts";
        if (itemId != 0 && (168 == packageId)) {
            if (itemId == 1 && paramId == 1)
                return "rc";
            if (itemId == 1)
                return "ttsfail";
            if (itemId == 2 && paramId == 1)
                return "mv";
            if (itemId == 2 && paramId == 2)
                return "tv";
            if (itemId == 2)
                return "md";
            if (itemId == 1 && paramId == 1)
                return "rc";
            if (itemId == 1)
                return "playsid";
            if (itemId == 2 && paramId == 1)
                return "mv";
            if (itemId == 2 && paramId == 2)
                return "tv";
            if (itemId == 2)
                return "playscript";
        }
// 169
        if (itemId == -1 && 169 == packageId)
            return "mpp";
        if (itemId != 0 && (169 == packageId)) {
            if (itemId == 1 && paramId == 1)
                return "an";
            if (itemId == 1 && paramId == 2)
                return "it";
            if (itemId == 1 && paramId == 3)
                return "iv";
            if (itemId == 1 && paramId == 4)
                return "sp";
            if (itemId == 1 && paramId == 5)
                return "vl";
            if (itemId == 1 && paramId == 6)
                return "di";
            if (itemId == 1 && paramId == 7)
                return "btn";
            if (itemId == 1 && paramId == 8)
                return "ctn";
            if (itemId == 1 && paramId == 9)
                return "off";
            if (itemId == 1 && paramId == 10)
                return "absvl";
            if (itemId == 1)
                return "play";
        }
// 179
        if (itemId == -1 && 179 == packageId)
            return "mrp";
        if (itemId != 0 && (179 == packageId)) {
            if (itemId == 2 && paramId == 1)
                return "ip";
            if (itemId == 2 && paramId == 2)
                return "ns";
            if (itemId == 2 && paramId == 3)
                return "sa";
            if (itemId == 2 && paramId == 4)
                return "fa";
            if (itemId == 2 && paramId == 5)
                return "mxatt";
            if (itemId == 2 && paramId == 6)
                return "prt";
            if (itemId == 2 && paramId == 7)
                return "pst";
            if (itemId == 2 && paramId == 8)
                return "rlt";
            if (itemId == 2 && paramId == 9)
                return "rid";
            if (itemId == 2 && paramId == 10)
                return "sp";
            if (itemId == 2 && paramId == 11)
                return "vl";
            if (itemId == 2 && paramId == 12)
                return "off";
            if (itemId == 2 && paramId == 13)
                return "rsk";
            if (itemId == 2 && paramId == 14)
                return "rik";
            if (itemId == 2 && paramId == 15)
                return "rtk";
            if (itemId == 2 && paramId == 16)
                return "eik";
            if (itemId == 2 && paramId == 17)
                return "rd";
            if (itemId == 2 && paramId == 18)
                return "absvl";
            if (itemId == 2 && paramId == 19)
                return "sm";
            if (itemId == 2 && paramId == 20)
                return "skint";
            if (itemId == 2 && paramId == 21)
                return "ffk";
            if (itemId == 2 && paramId == 22)
                return "rwk";
            if (itemId == 2 && paramId == 23)
                return "volint";
            if (itemId == 2 && paramId == 24)
                return "volup";
            if (itemId == 2 && paramId == 25)
                return "voldwn";
            if (itemId == 2 && paramId == 26)
                return "spdint";
            if (itemId == 2 && paramId == 27)
                return "spdup";
            if (itemId == 2 && paramId == 28)
                return "spddwn";
            if (itemId == 2 && paramId == 29)
                return "pse";
            if (itemId == 2 && paramId == 30)
                return "pse";
            if (itemId == 2 && paramId == 31)
                return "rsm";
            if (itemId == 2 && paramId == 32)
                return "pend";
            if (itemId == 2 && paramId == 33)
                return "extkey";
            if (itemId == 2)
                return "playrec";
        }
// 256
        if (itemId == -1 && 256 == packageId)
            return "edtmf";
        if (itemId != 0 && (256 == packageId)) {
            if (itemId == 2)
                return "extkey";
            if (itemId == 4 && paramId == 1)
                return "umr";
            if (itemId == 4 && paramId == 2)
                return "type";
            if (itemId == 4 && paramId == 1)
                return "ds";
            if (itemId == 4 && paramId == 2)
                return "Meth";
            if (itemId == 4 && paramId == 3)
                return "type";
            if (itemId == 4)
                return "ce";
        }
        slogger.warn("No token found : " + packageId + " " + itemId + " " + paramId);
        return null;
    }

    private static void fixLastComma(StringBuffer buffy) {
        char[] chars = new char[COMMA.length];
        buffy.getChars(buffy.length() - COMMA.length, buffy.length(), chars, 0);
        if (Arrays.equals(chars, COMMA))
            buffy.setLength(buffy.length() - COMMA.length);
    }
}
