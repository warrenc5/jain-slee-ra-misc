/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mofokom.megaco.resource.impl.codec;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import javax.megaco.InvalidArgumentException;
import javax.megaco.ParamNotSupportedException;
import javax.megaco.association.MethodExtensionException;
import javax.megaco.message.DescriptorType;
import javax.megaco.message.descriptor.DigitStringPosition;
import javax.megaco.pkg.PkgItem;
import javax.megaco.pkg.PkgItemParam;
import javax.megaco.pkg.PkgItemStr;
import javax.megaco.pkg.PkgItemType;
import org.apache.log4j.Logger;

/**
 *
 * @author wozza
 */
public class ObjectDecoder {

    Logger logger = Logger.getLogger("megaco.decode.object");
    protected String $megacoMessage = null;
    protected String $authenticationHeader = null;
    protected String $SecurityParmIndex = null;
    protected String $SequenceNum = null;
    protected String $AuthData = null;
    protected String $message = null;
    protected String $messageBody = null;
    protected String $transactionList = null;
    protected String $transactionPending = null;
    protected String $transactionResponseAck = null;
    protected String $transactionAck = null;
    protected String $transactionRequest = null;
    protected String $actionRequest = null;
    protected String $contextRequest = null;
    protected String $contextProperties = null;
    protected String $contextProperty = null;
    protected String $contextAudit = null;
    protected String $contextAuditProperties = null;
    protected String $commandRequestList = null;
    protected String $commandRequest = null;
    protected String $transactionReply = null;
    protected String $actionReplyList = null;
    protected String $actionReply = null;
    protected String $commandReply = null;
    protected String $commandReplyList = null;
    protected String $commandReplys = null;
    protected String $ammRequest = null;
    protected String $ammParameter = null;
    protected String $ammsReply = null;
    protected String $subtractRequest = null;
    protected String $auditRequest = null;
    protected String $auditReply = null;
    protected String $auditOther = null;
    protected String $terminationAudit = null;
    protected String $contextTerminationAudit = null;
    protected String $auditReturnParameter = null;
    protected String $auditDescriptor = null;
    protected String $notifyRequest = null;
    protected String $notifyReply = null;
    protected String $serviceChangeRequest = null;
    protected String $serviceChangeReply = null;
    protected String $errorDescriptor = null;
    protected String $ErrorCode = null;
    protected String $TransactionID = null;
    protected String $mId = null;
    protected String $domainName = null;
    protected String $deviceName = null;
    protected String $ContextID = null;
    protected String $domainAddress = null;
    protected String $IPv6address = null;
    protected String $IPv4address = null;
    protected String $V4hex = null;
    protected String $hexpart = null;
    protected String $hexseq = null;
    protected String $hex4 = null;
    protected String $portNumber = null;
    protected String $mtpAddress = null;
    protected String $terminationIDList = null;
    protected String $pathNAME = null;
    protected String $pathDomainName = null;
    protected String $TerminationID = null;
    protected String $mediaDescriptor = null;
    protected String $mediaParm = null;
    protected String $streamParm = null;
    protected String $streamDescriptor = null;
    protected String $localControlDescriptor = null;
    protected String $localParm = null;
    protected String $reservedValueMode = null;
    protected String $reservedGroupMode = null;
    protected String $streamMode = null;
    protected String $streamModes = null;
    protected String $propertyParm = null;
    protected String $parmValue = null;
    protected String $alternativeValue = null;
    protected String $INEQUAL = null;
    protected String $LSBRKT = null;
    protected String $RSBRKT = null;
    protected String $localDescriptor = null;
    protected String $remoteDescriptor = null;
    protected String $eventBufferDescriptor = null;
    protected String $eventSpec = null;
    protected String $eventSpecParameter = null;
    protected String $eventBufferControl = null;
    protected String $terminationStateDescriptor = null;
    protected String $terminationStateParm = null;
    protected String $serviceStates = null;
    protected String $muxDescriptor = null;
    protected String $MuxType = null;
    protected String $StreamID = null;
    protected String $pkgdName = null;
    protected String $PackageName = null;
    protected String $ItemID = null;
    protected String $eventsDescriptor = null;
    protected String $requestedEvent = null;
    protected String $eventParameter = null;
    protected String $embedWithSig = null;
    protected String $embedNoSig = null;
    protected String $embedFirst = null;
    protected String $secondRequestedEvent = null;
    protected String $secondEventParameter = null;
    protected String $embedSig = null;
    protected String $eventStream = null;
    protected String $eventOther = null;
    protected String $eventParameterName = null;
    protected String $eventDM = null;
    protected String $signalsDescriptor = null;
    protected String $signalParm = null;
    protected String $signalRequest = null;
    protected String $signalList = null;
    protected String $signalListId = null;
    protected String $signalListParm = null;
    protected String $signalName = null;
    protected String $sigParameter = null;
    protected String $sigStream = null;
    protected String $sigOther = null;
    protected String $sigParameterName = null;
    protected String $sigSignalType = null;
    protected String $signalType = null;
    protected String $sigDuration = null;
    protected String $notifyCompletion = null;
    protected String $notificationReason = null;
    protected String $observedEventsDescriptor = null;
    protected String $observedEvent = null;
    protected String $observedEventParameter = null;
    protected String $RequestID = null;
    protected String $modemDescriptor = null;
    protected String $modemType = null;
    protected String $digitMapDescriptor = null;
    protected String $digitMapName = null;
    protected String $digitMapValue = null;
    protected String $Timer = null;
    protected String $digitMap = null;
    protected String $digitStringList = null;
    protected String $digitString = null;
    protected String $digitStringElement = null;
    protected String $digitPosition = null;
    protected String $digitMapRange = null;
    protected String $digitLetter = null;
    protected String $digitMapLetter = null;
    protected String $auditItem = null;
    protected String $serviceChangeDescriptor = null;
    protected String $serviceChangeParm = null;
    protected String $serviceChangeReplyDescriptor = null;
    protected String $servChgReplyParm = null;
    protected String $serviceChangeMethod = null;
    protected String $serviceChangeReason = null;
    protected String $serviceChangeDelay = null;
    protected String $serviceChangeAddress = null;
    protected String $serviceChangeMgcId = null;
    protected String $serviceChangeProfile = null;
    protected String $serviceChangeVersion = null;
    protected String $extension = null;
    protected String $packagesDescriptor = null;
    protected String $Version = null;
    protected String $packagesItem = null;
    protected String $TimeStamp = null;
    protected String $Date = null;
    protected String $Time = null;
    protected String $statisticsDescriptor = null;
    protected String $statisticsParameter = null;
    protected String $topologyDescriptor = null;
    protected String $topologyTriple = null;
    protected String $terminationA = null;
    protected String $terminationB = null;
    protected String $topologyDirection = null;
    protected String $priority = null;
    protected String $extensionParameter = null;
    protected String $octetString = null;
    protected String $nonEscapeChar = null;
    protected String $quotedString = null;
    protected String $UINT16 = null;
    protected String $UINT32 = null;
    protected String $NAME = null;
    protected String $VALUE = null;
    protected String $SafeChar = null;
    protected String $EQUAL = null;
    protected String $COLON = null;
    protected String $LBRKT = null;
    protected String $RBRKT = null;
    protected String $COMMA = null;
    protected String $DOT = null;
    protected String $SLASH = null;
    protected String $ALPHA = null;
    protected String $DIGIT = null;
    protected String $DQUOTE = null;
    protected String $HEXDIG = null;
    protected String $SP = null;
    protected String $HTAB = null;
    protected String $CR = null;
    protected String $LF = null;
    protected String $LWSP = null;
    protected String $EOL = null;
    protected String $WSP = null;
    protected String $SEP = null;
    protected String $COMMENT = null;
    protected String $RestChar = null;
    protected String $AddToken = null;
    protected String $AuditToken = null;
    protected String $AuditCapToken = null;
    protected String $AuditValueToken = null;
    protected String $AuthToken = null;
    protected String $BothwayToken = null;
    protected String $BriefToken = null;
    protected String $BufferToken = null;
    protected String $CtxToken = null;
    protected String $ContextAuditToken = null;
    protected String $DigitMapToken = null;
    protected String $DisconnectedToken = null;
    protected String $DelayToken = null;
    protected String $DurationToken = null;
    protected String $EmbedToken = null;
    protected String $EmergencyToken = null;
    protected String $ErrorToken = null;
    protected String $EventBufferToken = null;
    protected String $EventsToken = null;
    protected String $FailoverToken = null;
    protected String $ForcedToken = null;
    protected String $GracefulToken = null;
    protected String $H221Token = null;
    protected String $H223Token = null;
    protected String $H226Token = null;
    protected String $HandOffToken = null;
    protected String $ImmAckRequiredToken = null;
    protected String $InactiveToken = null;
    protected String $IsolateToken = null;
    protected String $InSvcToken = null;
    protected String $InterruptByEventToken = null;
    protected String $InterruptByNewSignalsDescrToken = null;
    protected String $KeepActiveToken = null;
    protected String $LocalToken = null;
    protected String $LocalControlToken = null;
    protected String $LockStepToken = null;
    protected String $LoopbackToken = null;
    protected String $MediaToken = null;
    protected String $MegacopToken = null;
    protected String $MethodToken = null;
    protected String $MgcIdToken = null;
    protected String $ModeToken = null;
    protected String $ModifyToken = null;
    protected String $ModemToken = null;
    protected String $MoveToken = null;
    protected String $MTPToken = null;
    protected String $MuxToken = null;
    protected String $NotifyToken = null;
    protected String $NotifyCompletionToken = null;
    protected String $ObservedEventsToken = null;
    protected String $OnewayToken = null;
    protected String $OnOffToken = null;
    protected String $OtherReasonToken = null;
    protected String $OutOfSvcToken = null;
    protected String $PackagesToken = null;
    protected String $PendingToken = null;
    protected String $PriorityToken = null;
    protected String $ProfileToken = null;
    protected String $ReasonToken = null;
    protected String $RecvonlyToken = null;
    protected String $ReplyToken = null;
    protected String $RestartToken = null;
    protected String $RemoteToken = null;
    protected String $ReservedGroupToken = null;
    protected String $ReservedValueToken = null;
    protected String $SendonlyToken = null;
    protected String $SendrecvToken = null;
    protected String $ServicesToken = null;
    protected String $ServiceStatesToken = null;
    protected String $ServiceChangeToken = null;
    protected String $ServiceChangeAddressToken = null;
    protected String $SignalListToken = null;
    protected String $SignalsToken = null;
    protected String $SignalTypeToken = null;
    protected String $StatsToken = null;
    protected String $StreamToken = null;
    protected String $SubtractToken = null;
    protected String $SynchISDNToken = null;
    protected String $TerminationStateToken = null;
    protected String $TestToken = null;
    protected String $TimeOutToken = null;
    protected String $TopologyToken = null;
    protected String $TransToken = null;
    protected String $ResponseAckToken = null;
    protected String $V18Token = null;
    protected String $V22Token = null;
    protected String $V22bisToken = null;
    protected String $V32Token = null;
    protected String $V32bisToken = null;
    protected String $V34Token = null;
    protected String $V76Token = null;
    protected String $V90Token = null;
    protected String $V91Token = null;
    protected String $VersionToken = null;
    protected String $StringValue = null;
    protected String $NumericValue = null;

    public javax.megaco.message.descriptor.ModemDescriptor modemDescriptorExpanded() {

        _modemDescriptor = new javax.megaco.message.descriptor.ModemDescriptor(_modemParamList.toArray(new javax.megaco.message.descriptor.ModemParam[_modemParamList.size()]));

        if (_modemParamValueList != null && _modemParamValueList.size() > 0)
            _modemDescriptor.setModemParamValue(_modemParamValueList.toArray(new javax.megaco.message.descriptor.ModemParamValue[_modemParamValueList.size()]));

        _descriptorList.add(_modemDescriptor);
        return _modemDescriptor;
    }

    public javax.megaco.message.descriptor.StreamMode streamModeExpanded() {
        _streamMode = Constants.StreamModeForValue(_stringValue);

        return _streamMode;
    }

    public javax.megaco.message.descriptor.ServiceState serviceStateExpanded() {
        _serviceState = Constants.ServiceStateForValue(_stringValue);

        return _serviceState;
    }

    public javax.megaco.message.descriptor.SDPInfo sDPInfoExpanded() throws IllegalArgumentException, ParamNotSupportedException {
        _sDPInfo = new javax.megaco.message.descriptor.SDPInfo();

        if (_sessionDescription != null)
            _sDPInfo.setSessionDescription(_sessionDescription);
        if (_sessionDescStr != null)
            _sDPInfo.setSessionDescStr(_sessionDescStr);

        _sessionDescStr = null;
        _sessionDescription = null;

        return _sDPInfo;
    }

    public javax.megaco.message.descriptor.SrvChngRespDescriptor srvChngRespDescriptorExpanded() {
        _srvChngRespDescriptor = new javax.megaco.message.descriptor.SrvChngRespDescriptor();

        if (_srvChngAddress != null)
            _srvChngRespDescriptor.setSrvChngAddress(_srvChngAddress);
        if (_handOffMGCId != null)
            _srvChngRespDescriptor.setHandOffMGCId(_handOffMGCId);
        if (_srvChngProfile != null)
            _srvChngRespDescriptor.setSrvChngProfile(_srvChngProfile);
        _srvChngRespDescriptor.setProtocolVersion(_protocolVersion);
        if (_dateValue != null)
            _srvChngRespDescriptor.setDateValue(_dateValue);
        if (_timeValue != null)
            _srvChngRespDescriptor.setTimeValue(_timeValue);
        if (_srvChngMethod != null)
            _srvChngRespDescriptor.setSrvChngMethod(_srvChngMethod);
        _descriptorList.add(_srvChngRespDescriptor);
        return _srvChngRespDescriptor;
    }

    public javax.megaco.message.descriptor.TimeStamp timeStampExpanded() {

        String s = $TimeStamp;

        _timeStamp = Constants.timestampForValue(s);
        return _timeStamp;
    }

    public javax.megaco.message.descriptor.TermStateDescriptor termStateDescriptorExpanded() {
        _termStateDescriptor = new javax.megaco.message.descriptor.TermStateDescriptor();

        if (_serviceState != null)
            _termStateDescriptor.setServiceState(_serviceState);
        if (_evtBufferControl != null)
            _termStateDescriptor.setEvtBufferControl(_evtBufferControl);
        if (_megacoPkgPrptyItemList != null && _megacoPkgPrptyItemList.size() > 0)
            _termStateDescriptor.setMegacoPkgPrptyItem(_megacoPkgPrptyItemList.toArray(new javax.megaco.pkg.PkgPrptyItem[_megacoPkgPrptyItemList.size()]));
        if (_megacoPkgItemStrList != null && _megacoPkgItemStrList.size() > 0)
            _termStateDescriptor.setMegacoPkgItemStr(_megacoPkgItemStrList.toArray(new javax.megaco.pkg.PkgItemStr[_megacoPkgItemStrList.size()]));
        //_descriptorList.add(_termStateDescriptor);

        //TODO clear
        _megacoPkgItemStrList.clear();
        _megacoPkgPrptyItemList.clear();
        return _termStateDescriptor;
    }

    public javax.megaco.message.descriptor.EmbedFirstEventParam embedFirstEventParamExpanded() {
        _embedFirstEventParam = new javax.megaco.message.descriptor.EmbedFirstEventParam(1);
        if (_pkgEventItem == null)
            pkgItemStrExpanded(PkgItemType.EVENT);

        if (_megacoPkgItemStr != null)
            _embedFirstEventParam.setMegacoPkgItemStr(_megacoPkgItemStr);
        if (_eventParam != null)
            _embedFirstEventParam.setEventParam(_eventParam);
        if (_pkgEventItem != null)
            _embedFirstEventParam.setMegacoPkgEventItem(_pkgEventItem);
        return _embedFirstEventParam;
    }

    public javax.megaco.message.descriptor.SrvChngDescriptor srvChngDescriptorExpanded() throws MethodExtensionException {
        _srvChngDescriptor = new javax.megaco.message.descriptor.SrvChngDescriptor();

        if (_srvChngAddress != null)
            _srvChngDescriptor.setSrvChngAddress(_srvChngAddress);
        if (_handOffMGCId != null)
            _srvChngDescriptor.setHandOffMGCId(_handOffMGCId);
        if (_srvChngProfile != null)
            _srvChngDescriptor.setSrvChngProfile(_srvChngProfile);
        _srvChngDescriptor.setProtocolVersion(_protocolVersion);
        if (_dateValue != null)
            _srvChngDescriptor.setDateValue(_dateValue);
        if (_timeValue != null)
            _srvChngDescriptor.setTimeValue(_timeValue);
        if (_srvChngMethod != null)
            _srvChngDescriptor.setSrvChngMethod(_srvChngMethod);
        if (_svcChngMethodExtension != null)
            _srvChngDescriptor.setSvcChngMethodExtension($extensionParameter);
        if (_srvChngReason != null)
            _srvChngDescriptor.setSrvChngReason(_srvChngReason);
        if (_srvChngDelay > 0)
            _srvChngDescriptor.setSrvChngDelay(_srvChngDelay);
        if (_parameterExtention != null)
            _srvChngDescriptor.setParameterExtention(_parameterExtention);
        _descriptorList.add(_srvChngDescriptor);
        return _srvChngDescriptor;
    }

    public javax.megaco.message.descriptor.EventBufferDescriptor eventBufferDescriptorExpanded() {
        _eventBufferDescriptor = new javax.megaco.message.descriptor.EventBufferDescriptor(_eventBufParamList.toArray(new javax.megaco.message.descriptor.EventBufParam[_eventBufParamList.size()]));

        _eventBufParamList.clear();
        _descriptorList.add(_eventBufferDescriptor);
        return _eventBufferDescriptor;
    }

    public javax.megaco.message.descriptor.MuxType muxTypeExpanded() {
        _muxType = Constants.MuxTypeForValue(_stringValue);

        return _muxType;
    }

    public javax.megaco.message.descriptor.DigitStringPosition digitStringPositionExpanded(boolean dot) {
        _digitStringPosition = new javax.megaco.message.descriptor.DigitStringPosition();

        //System.out.println($digitMapRange + " " + $digitMapLetter + " " + $digitLetter + " " + $DOT);

        if ($digitMapRange != null)
            _digitStringPosition.setDigitStringPosition(Constants.digitMapRangeForValue($digitMapRange));
        else if ($digitMapLetter != null)
            _digitStringPosition.setDigitStringPosition(Constants.digitMapLetter($digitMapLetter));
        /*
         * else if ($digitLetter != null)
         * _digitStringPosition.setDigitStringPosition(Constants.digitLetter($digitLetter));
         */

        _digitStringPositionList.add(_digitStringPosition);

        if (dot) {

            javax.megaco.message.descriptor.DigitStringPosition _digitStringPosition2 = new javax.megaco.message.descriptor.DigitStringPosition();
            _digitStringPosition2.setDigitStringPosition(new int[]{DigitStringPosition.DIGIT_DOT});
            _digitStringPositionList.add(_digitStringPosition2);
        }


        $digitMapRange = null;
        $digitLetter = null;
        $digitMapLetter = null;
        $DOT = null;
        return _digitStringPosition;
    }

    public javax.megaco.message.descriptor.SignalDescriptor signalDescriptorExpanded() {
        _signalDescriptor = new javax.megaco.message.descriptor.SignalDescriptor();

        if (_signalParamList != null && _signalParamList.size() > 0) {
            _signalDescriptor.setSignalParam(_signalParamList.toArray(new javax.megaco.message.descriptor.SignalParam[_signalParamList.size()]));

            _signalParamList.clear();
        }
        _descriptorList.add(_signalDescriptor);
        return _signalDescriptor;
    }

    public javax.megaco.message.descriptor.SignalNotifyReason signalNotifyReasonExpanded() {
        _signalNotifyReason = Constants.SignalNotifyReasonForValue(_stringValue);

        return _signalNotifyReason;
    }

    public javax.megaco.message.descriptor.ModemParamValue modemParamValueExpanded() {
        _modemParamValue = new javax.megaco.message.descriptor.ModemParamValue();

        if (_paramName != null)
            _modemParamValue.setParamName(_paramName);
        if (_paramsValueRelation != null)
            _modemParamValue.setParamsValueRelation(_paramsValueRelation);
        if (_paramsValueList != null && _paramsValueList.size() > 0)
            _modemParamValue.setParamsValue(_paramsValueList.toArray(new java.lang.String[_paramsValueList.size()]));
        return _modemParamValue;
    }

    public javax.megaco.message.descriptor.EventDescriptor eventDescriptorExpanded() {
        _eventDescriptor = new javax.megaco.message.descriptor.EventDescriptor(_requestID);

        if (_requestedEventParamList != null && _requestedEventParamList.size() > 0)
            _eventDescriptor.setRequestedEventParam(_requestedEventParamList.toArray(new javax.megaco.message.descriptor.RequestedEventParam[_requestedEventParamList.size()]));

        _descriptorList.add(_eventDescriptor);

        _requestedEventParamList.clear();
        return _eventDescriptor;
    }

    public javax.megaco.message.descriptor.ModemParam modemParamExpanded() {
        _modemParam = new javax.megaco.message.descriptor.ModemParam(_modemType);

        return _modemParam;
    }

    public javax.megaco.message.descriptor.RequestedEventParam requestedEventParamExpanded() {
        if (_pkgEventItem == null)
            pkgItemStrExpanded(PkgItemType.EVENT);

        if (_pkgEventItem != null)
            _requestedEventParam = new javax.megaco.message.descriptor.RequestedEventParam(_pkgEventItem);
        else if (_megacoPkgItemStr != null)
            _requestedEventParam = new javax.megaco.message.descriptor.RequestedEventParam(_megacoPkgItemStr);

        if (_eventParam != null)
            _requestedEventParam.setEventParam(_eventParam);
        if (_embedFirstEventParam != null)
            _requestedEventParam.setEmbedFirstEventParam(_embedFirstEventParam);

        _requestedEventParamList.add(_requestedEventParam);

        _embedFirstEventParam = null;
        _eventParam = null;

        return _requestedEventParam;
    }

    public javax.megaco.message.descriptor.PackageDescriptor packageDescriptorExpanded() {
        _packageDescriptor = new javax.megaco.message.descriptor.PackageDescriptor();

        if (_megacoPkgItemsList != null && _megacoPkgItemsList.size() > 0)
            _packageDescriptor.setMegacoPkgItems(_megacoPkgItemsList.toArray(new javax.megaco.message.descriptor.PackagesItem[_megacoPkgItemsList.size()]));
        if (_megacoPkgItemsStrList != null && _megacoPkgItemsStrList.size() > 0)
            _packageDescriptor.setMegacoPkgItemsStr(_megacoPkgItemsStrList.toArray(new javax.megaco.pkg.PkgItemStr[_megacoPkgItemsStrList.size()]));
        _descriptorList.add(_packageDescriptor);
        return _packageDescriptor;
    }

    public javax.megaco.message.descriptor.PackagesItem packagesItemExpanded() {

        $ItemID = null;
        _parmValue = null;
        $PackageName = $NAME;
        pkgItemExpanded();
        _packagesItem = new javax.megaco.message.descriptor.PackagesItem(_megacoPkg, Short.valueOf($UINT16));

        _megacoPkgItemsList.add(_packagesItem);
        return _packagesItem;
    }

    public javax.megaco.message.descriptor.SignalParam signalParamExpanded() {
        if ($signalListId != null) {
            _signalParam = new javax.megaco.message.descriptor.SignalParam(Short.valueOf($signalListId), _signalRequestList.toArray(new javax.megaco.message.descriptor.SignalRequest[_signalRequestList.size()]));
            _signalRequestList.clear();
            $signalListId = null;
        } else
            _signalParam = new javax.megaco.message.descriptor.SignalParam(_signalRequest);

        _signalParamList.add(_signalParam);

        return _signalParam;
    }

    public javax.megaco.message.descriptor.EventBufParam eventBufParamExpanded() {
        pkgItemExpanded();

        if (_pkgEventItem == null)
            pkgItemStrExpanded(PkgItemType.EVENT);

        if (_pkgEventItem != null)
            _eventBufParam = new javax.megaco.message.descriptor.EventBufParam(_pkgEventItem);
        else if (_megacoPkgItemStr != null)
            _eventBufParam = new javax.megaco.message.descriptor.EventBufParam(_megacoPkgItemStr);

        if (_streamId > 0)
            _eventBufParam.setStreamId(_streamId);

        _eventBufParamList.add(_eventBufParam);

        return _eventBufParam;
    }

    public javax.megaco.message.descriptor.EventBufferCtrl eventBufferCtrlExpanded() {
        _evtBufferControl = Constants.EventBufferCtrlForValue(_stringValue);

        return _evtBufferControl;
    }

    public javax.megaco.message.descriptor.EventParam eventParamExpanded() {
        _eventParam = new javax.megaco.message.descriptor.EventParam();

        if (_signalDescriptor != null)
            _eventParam.setSignalDescriptor(_signalDescriptor);
        if (_digitMapName != null)
            _eventParam.setDigitMapName(_digitMapName);
        if (_digitMapValue != null)
            _eventParam.setDigitMapValue(_digitMapValue);
        if (_digitMapValueStr != null)
            _eventParam.setDigitMapValueStr(_digitMapValueStr);

        _eventParam.setStreamId(_streamId);

        _digitMapName = null;
        _digitMapValue = null;
        _digitMapValueStr = null;
        _signalDescriptor = null;
        _streamId = 0;

        return _eventParam;
    }

    public javax.megaco.message.descriptor.AuditValRespDescriptor auditValRespDescriptorExpanded() {
        _auditValRespDescriptor = new javax.megaco.message.descriptor.AuditValRespDescriptor();

        /*
         * if (_descriptorList != null && _descriptorList.size() > 0)
         * _auditValRespDescriptor.setDescriptor(_descriptorList.toArray(new
         * javax.megaco.message.Descriptor[_descriptorList.size()]));
         */

        if (_auditItemList.contains(DescriptorType.MODEM_DESC))
            _auditValRespDescriptor.setModemToken();
        if (_auditItemList.contains(DescriptorType.MEDIA_DESC))
            _auditValRespDescriptor.setMediaToken();
        if (_auditItemList.contains(DescriptorType.SIGNAL_DESC))
            _auditValRespDescriptor.setSignalToken();
        if (_auditItemList.contains(DescriptorType.EVENT_BUF_DESC))
            _auditValRespDescriptor.setEventBuffToken();
        if (_auditItemList.contains(DescriptorType.STATISTICS_DESC))
            _auditValRespDescriptor.setStatsToken();
        if (_auditItemList.contains(DescriptorType.EVENT_DESC))
            _auditValRespDescriptor.setEventsToken();
        if (_auditItemList.contains(DescriptorType.OBSERVED_EVENT_DESC))
            _auditValRespDescriptor.setObsEventToken();
        if (_auditItemList.contains(DescriptorType.DIGIT_MAP_DESC))
            _auditValRespDescriptor.setDigitMapToken();
        if (_auditItemList.contains(DescriptorType.PACKAGE_DESC))
            _auditValRespDescriptor.setPackagesToken();

        _auditItemList.clear();

        _descriptorList.add(_auditValRespDescriptor);
        return _auditValRespDescriptor;
    }

    public javax.megaco.message.descriptor.ModemType modemTypeExpanded() {
        _modemType = Constants.ModemTypeForValue(_stringValue);

        return _modemType;
    }

    public javax.megaco.message.descriptor.AuditValDescriptor auditValDescriptorExpanded() {
        _auditValDescriptor = new javax.megaco.message.descriptor.AuditValDescriptor();

        if (_auditItemList.contains(DescriptorType.MODEM_DESC))
            _auditValDescriptor.setModemToken();
        if (_auditItemList.contains(DescriptorType.MEDIA_DESC))
            _auditValDescriptor.setMediaToken();
        if (_auditItemList.contains(DescriptorType.SIGNAL_DESC))
            _auditValDescriptor.setSignalToken();
        if (_auditItemList.contains(DescriptorType.EVENT_BUF_DESC))
            _auditValDescriptor.setEventBuffToken();
        if (_auditItemList.contains(DescriptorType.STATISTICS_DESC))
            _auditValDescriptor.setStatsToken();
        if (_auditItemList.contains(DescriptorType.EVENT_DESC))
            _auditValDescriptor.setEventsToken();
        if (_auditItemList.contains(DescriptorType.OBSERVED_EVENT_DESC))
            _auditValDescriptor.setObsEventToken();
        if (_auditItemList.contains(DescriptorType.DIGIT_MAP_DESC))
            _auditValDescriptor.setDigitMapToken();
        if (_auditItemList.contains(DescriptorType.PACKAGE_DESC))
            _auditValDescriptor.setPackagesToken();
        _auditItemList.clear();

        _descriptorList.add(_auditValDescriptor);
        return _auditValDescriptor;
    }

    public javax.megaco.message.descriptor.MuxDescriptor muxDescriptorExpanded() {
        _muxDescriptor = new javax.megaco.message.descriptor.MuxDescriptor(_muxType, _terminationList.toArray(new javax.megaco.message.Termination[_terminationList.size()]));

        if (_extensionString != null)
            _muxDescriptor.setExtensionString(_extensionString);
        _descriptorList.add(_muxDescriptor);
        return _muxDescriptor;
    }

    public javax.megaco.message.descriptor.ObservedEvent observedEventExpanded() {
        if (_pkgEventItem == null)
            pkgItemStrExpanded(PkgItemType.EVENT);
        if (_pkgEventItem != null)
            _observedEvent = new javax.megaco.message.descriptor.ObservedEvent(_pkgEventItem);
        else if (_megacoPkgItemStr != null)
            _observedEvent = new javax.megaco.message.descriptor.ObservedEvent(_megacoPkgItemStr);


        if (_streamId > 0)
            _observedEvent.setStreamId(_streamId);
        if (_timeStamp != null)
            _observedEvent.setTimeStamp(_timeStamp);

        _observedEventList.add(_observedEvent);

        _streamId = 0;
        _timeStamp = null;

        return _observedEvent;
    }

    public javax.megaco.message.descriptor.TopologyDescriptor topologyDescriptorExpanded() {
        _topologyDescriptor = new javax.megaco.message.descriptor.TopologyDescriptor(_termination, _termination, _topologyDirection);

        _descriptorList.add(_topologyDescriptor);
        return _topologyDescriptor;
    }

    public javax.megaco.message.descriptor.MediaStreamParam mediaStreamParamExpanded() {
        _mediaStreamParam = new javax.megaco.message.descriptor.MediaStreamParam();

        if (_localCtrlDescriptor != null)
            _mediaStreamParam.setLclCtrlDescriptor(_localCtrlDescriptor);
        if (_localDescriptor != null)
            _mediaStreamParam.setLocalDescriptor(_localDescriptor);
        if (_remoteDescriptor != null)
            _mediaStreamParam.setRemoteDescriptor(_remoteDescriptor);

        _lclCtrlDescriptor = null;
        _localDescriptor = null;
        _remoteDescriptor = null;

        return _mediaStreamParam;
    }

    public javax.megaco.message.descriptor.TopologyDirection topologyDirectionExpanded() {
        _topologyDirection = Constants.TopologyDirectionForValue(_stringValue);

        return _topologyDirection;
    }

    public javax.megaco.message.descriptor.LocalCtrlDescriptor localCtrlDescriptorExpanded() {
        _localCtrlDescriptor = new javax.megaco.message.descriptor.LocalCtrlDescriptor();

        if (_megacoPkgPrptyItemList != null && _megacoPkgPrptyItemList.size() > 0)
            _localCtrlDescriptor.setMegacoPkgPrptyItem(_megacoPkgPrptyItemList.toArray(new javax.megaco.pkg.PkgPrptyItem[_megacoPkgPrptyItemList.size()]));
        if (_megacoPkgItemStrList != null && _megacoPkgItemStrList.size() > 0)
            _localCtrlDescriptor.setMegacoPkgItemStr(_megacoPkgItemStrList.toArray(new javax.megaco.pkg.PkgItemStr[_megacoPkgItemStrList.size()]));
        if (_streamMode != null)
            _localCtrlDescriptor.setStreamMode(_streamMode);
        if (_reserveValuePresent)
            _localCtrlDescriptor.setReserveValue(_reserveValue);
        if (_reserveGroupPresent)
            _localCtrlDescriptor.setReserveGroup(_reserveGroup);

        //_descriptorList.add(_localCtrlDescriptor);
        _megacoPkgItemStrList.clear();
        _megacoPkgPrptyItemList.clear();
        _reserveGroupPresent = false;
        _reserveValuePresent = false;
        _reserveGroup = false;
        _reserveValue = false;
        _streamMode = null;

        return _localCtrlDescriptor;
    }

    public javax.megaco.message.descriptor.SignalType signalTypeExpanded() {
        _signalType = Constants.SignalTypeForValue(_stringValue);

        return _signalType;
    }

    public javax.megaco.message.descriptor.CntxtTermAudDescriptor cntxtTermAudDescriptorExpanded() {
        _cntxtTermAudDescriptor = new javax.megaco.message.descriptor.CntxtTermAudDescriptor();

        if (_errorDescriptor != null)
            _cntxtTermAudDescriptor.setErrorDescriptor(_errorDescriptor);
        if (_terminationIdList != null && _terminationIdList.size() > 0)
            _cntxtTermAudDescriptor.setTerminationId(_terminationIdList.toArray(new javax.megaco.message.Termination[_terminationIdList.size()]));
        _descriptorList.add(_cntxtTermAudDescriptor);
        return _cntxtTermAudDescriptor;
    }

    public javax.megaco.message.descriptor.AuditCapRespDescriptor auditCapRespDescriptorExpanded() {
        _auditCapRespDescriptor = new javax.megaco.message.descriptor.AuditCapRespDescriptor();

        /*
         * if (_descriptorList != null && _descriptorList.size() > 0)
         * _auditCapRespDescriptor.setDescriptor(_descriptorList.toArray(new
         * javax.megaco.message.Descriptor[_descriptorList.size()]));
         *
         */
        if (_auditItemList.contains(DescriptorType.MODEM_DESC))
            _auditCapRespDescriptor.setModemToken();
        if (_auditItemList.contains(DescriptorType.MEDIA_DESC))
            _auditCapRespDescriptor.setMediaToken();
        if (_auditItemList.contains(DescriptorType.SIGNAL_DESC))
            _auditCapRespDescriptor.setSignalToken();
        if (_auditItemList.contains(DescriptorType.EVENT_BUF_DESC))
            _auditCapRespDescriptor.setEventBuffToken();
        if (_auditItemList.contains(DescriptorType.STATISTICS_DESC))
            _auditCapRespDescriptor.setStatsToken();
        if (_auditItemList.contains(DescriptorType.EVENT_DESC))
            _auditCapRespDescriptor.setEventsToken();
        if (_auditItemList.contains(DescriptorType.OBSERVED_EVENT_DESC))
            _auditCapRespDescriptor.setObsEventToken();

        _auditItemList.clear();

        _descriptorList.add(_auditCapRespDescriptor);
        return _auditCapRespDescriptor;
    }

    public javax.megaco.message.descriptor.ObsEventDescriptor obsEventDescriptorExpanded() throws InvalidArgumentException {
        _obsEventDescriptor = new javax.megaco.message.descriptor.ObsEventDescriptor(_requestID, _observedEventList.toArray(new javax.megaco.message.descriptor.ObservedEvent[_observedEventList.size()]));

        _descriptorList.add(_obsEventDescriptor);
        return _obsEventDescriptor;
    }

    public javax.megaco.message.descriptor.DigitMapString digitMapStringExpanded() {
        _digitMapString = new javax.megaco.message.descriptor.DigitMapString();

        if (_digitStringPositionList != null && _digitStringPositionList.size() > 0)
            _digitMapString.setDigitStringPosition(_digitStringPositionList.toArray(new javax.megaco.message.descriptor.DigitStringPosition[_digitStringPositionList.size()]));

        _digitStringPositionList.clear();
        return _digitMapString;
    }

    public javax.megaco.message.descriptor.SignalRequest signalRequestExpanded() {

        if (_pkgSignalItem == null)
            pkgItemStrExpanded(PkgItemType.SIGNAL);
        if (_pkgSignalItem != null)
            _signalRequest = new javax.megaco.message.descriptor.SignalRequest(_pkgSignalItem);
        else if (_megacoPkgItemStr != null)
            _signalRequest = new javax.megaco.message.descriptor.SignalRequest(_megacoPkgItemStr);

        if (_streamId > 0)
            _signalRequest.setStreamId(_streamId);

        if (_signalType != null)
            _signalRequest.setSignalType(_signalType);
        if (_signalNotifyReason != null)
            _signalRequest.setSignalNotifyReason(_signalNotifyReason);

        if (_signalDuration > 0)
            _signalRequest.setSignalDuration(_signalDuration);

        _signalRequestList.add(_signalRequest);
        return _signalRequest;
    }

    public javax.megaco.message.descriptor.ErrorDescriptor errorDescriptorExpanded() {
        _errorDescriptor = new javax.megaco.message.descriptor.ErrorDescriptor(1);

        if (_errorString != null)
            _errorDescriptor.setErrorString(_errorString);
        _descriptorList.add(_errorDescriptor);
        return _errorDescriptor;
    }

    public javax.megaco.message.descriptor.AuditCapDescriptor auditCapDescriptorExpanded() {
        _auditCapDescriptor = new javax.megaco.message.descriptor.AuditCapDescriptor();

        if (_auditItemList.contains(DescriptorType.MUX_DESC))
            _auditCapDescriptor.setMuxToken();
        if (_auditItemList.contains(DescriptorType.MODEM_DESC))
            _auditCapDescriptor.setModemToken();
        if (_auditItemList.contains(DescriptorType.MEDIA_DESC))
            _auditCapDescriptor.setMediaToken();
        if (_auditItemList.contains(DescriptorType.SIGNAL_DESC))
            _auditCapDescriptor.setSignalToken();
        if (_auditItemList.contains(DescriptorType.EVENT_BUF_DESC))
            _auditCapDescriptor.setEventBuffToken();
        if (_auditItemList.contains(DescriptorType.STATISTICS_DESC))
            _auditCapDescriptor.setStatsToken();
        if (_auditItemList.contains(DescriptorType.EVENT_DESC))
            _auditCapDescriptor.setEventsToken();
        if (_auditItemList.contains(DescriptorType.OBSERVED_EVENT_DESC))
            _auditCapDescriptor.setObsEventToken();

        _auditItemList.clear();

        _descriptorList.add(_auditCapDescriptor);
        return _auditCapDescriptor;
    }

    public javax.megaco.message.descriptor.MediaDescriptor mediaDescriptorExpanded() throws InvalidArgumentException {
        _mediaDescriptor = new javax.megaco.message.descriptor.MediaDescriptor();

        if (_mediaStreamParam != null)
            _mediaDescriptor.setMediaStreamParam(_mediaStreamParam);

        if (_streamDescriptorList != null && _streamDescriptorList.size() > 0)
            _mediaDescriptor.setStreamDescriptor(_streamDescriptorList.toArray(new javax.megaco.message.descriptor.StreamDescriptor[_streamDescriptorList.size()]));

        if (_termStateDescriptor != null)
            _mediaDescriptor.setTermStateDescriptor(_termStateDescriptor);


        _mediaStreamParam = null;
        _streamDescriptorList.clear();
        _termStateDescriptor = null;


        _descriptorList.add(_mediaDescriptor);
        return _mediaDescriptor;
    }

    public javax.megaco.message.descriptor.StreamDescriptor streamDescriptorExpanded() {
        _streamDescriptor = new javax.megaco.message.descriptor.StreamDescriptor();

        _streamDescriptor.setStreamId(_streamId);
        if (_mediaStreamParam != null)
            _streamDescriptor.setMediaStreamParam(_mediaStreamParam);

        _mediaStreamParam = null;
        _streamId = 0;

        _streamDescriptorList.add(_streamDescriptor);

        _streamDescriptor = null;
        return null;
    }

    public javax.megaco.message.descriptor.DigitMapValue digitMapValueExpanded() {
        _digitMapValue = new javax.megaco.message.descriptor.DigitMapValue();

        if (_timerTValue != null)
            _digitMapValue.setTimerTValue(_timerTValue);
        if (_timerSValue != null)
            _digitMapValue.setTimerSValue(_timerSValue);
        if (_timerLValue != null)
            _digitMapValue.setTimerLValue(_timerLValue);

        if (_digitMapStringsList != null && _digitMapStringsList.size() > 0)
            _digitMapValue.setDigitMapStrings(_digitMapStringsList.toArray(new javax.megaco.message.descriptor.DigitMapString[_digitMapStringsList.size()]));

        _digitMapStringsList.clear();
        _timerLValue = 0;
        _timerSValue = 0;
        _timerTValue = 0;


        return _digitMapValue;
    }

    public javax.megaco.message.descriptor.DigitMapDescriptor digitMapDescriptorExpanded() {
        _digitMapDescriptor = new javax.megaco.message.descriptor.DigitMapDescriptor();

        if (_digitMapName != null)
            _digitMapDescriptor.setDigitMapName(_digitMapName);
        if (_digitMapValue != null)
            _digitMapDescriptor.setDigitMapValue(_digitMapValue);
        if (_digitMapValueStr != null)
            _digitMapDescriptor.setDigitMapValueStr(_digitMapValueStr);
        _descriptorList.add(_digitMapDescriptor);
        return _digitMapDescriptor;
    }

    public javax.megaco.message.descriptor.StatsDescriptor statsDescriptorExpanded() {
        _statsDescriptor = new javax.megaco.message.descriptor.StatsDescriptor(_pkgStatsItemList.toArray(new javax.megaco.pkg.PkgStatsItem[_pkgStatsItemList.size()]));

        _descriptorList.add(_statsDescriptor);
        return _statsDescriptor;
    }

    /*
     * public javax.megaco.message.DescriptorType descriptorTypeExpanded() {
     * _descriptorType = Constants.DescriptorTypeForValue(_stringValue);
     *
     * return _descriptorType; }
     *
     */
    public javax.megaco.message.ContextInfo contextInfoExpanded() {
        int contextId = Constants.ContextInfoIdForValue($ContextID);

        _contextInfo = new javax.megaco.message.ContextInfo(contextId);


        if (_contextParam != null)
            _contextInfo.setContextParam(_contextParam);


        for (javax.megaco.CommandEvent e : _message) {
            e.setCntxtInfo(_contextInfo);
        }

        _firstCommandInAction = true;

        return _contextInfo;
    }

    public javax.megaco.message.CommandType commandTypeExpanded() {
        _commandType = Constants.CommandTypeForValue(_commandTypeToken);

        return _commandType;
    }

    public javax.megaco.message.CmdResponseType cmdResponseTypeExpanded() {
        _cmdResponseType = Constants.CmdResponseTypeForValue(_commandTypeToken);

        return _cmdResponseType;
    }

    public javax.megaco.message.ContextParam contextParamExpanded() {
        _contextParam = new javax.megaco.message.ContextParam();

        _contextParam.setPriority(_priority);
        _contextParam.setEM(_eM);
        if (_topologyDescriptorList != null && _topologyDescriptorList.size() > 0)
            _contextParam.setTopologyDescriptor(_topologyDescriptorList.toArray(new javax.megaco.message.descriptor.TopologyDescriptor[_topologyDescriptorList.size()]));
        return _contextParam;
    }

    public javax.megaco.CommandEvent commandEventExpanded(javax.megaco.CommandEvent _commandEvent) {

        if (_descriptorList != null && _descriptorList.size() > 0)
            _commandEvent.setDescriptor(_descriptorList.toArray(new javax.megaco.message.Descriptor[_descriptorList.size()]));
        if (_termination != null)
            _commandEvent.setTermination(_termination);

        if (_contextInfo != null)
            _commandEvent.setCntxtInfo(_contextInfo);

        _commandEvent.setExchangeId(_exchangeId);

        if (_firstCommandInAction)
            _commandEvent.setFirstCommandInAction();

        _firstCommandInAction = false;

        _message.add(_commandEvent);

        _descriptorList.clear();

        return _commandEvent;
    }

    public javax.megaco.message.CommandReq commandReqExpanded() {
        _commandReq = Constants.CommandReqForValue(_cmdRequestType, "source", _exchangeId, _transactionId, 0,false,false);

        if (_commandOptional)
            _commandReq.setCommandOptional();
        if (_commandWildcard)
            _commandReq.setReqWithWildcardResp();

        commandEventExpanded(_commandReq);

        return _commandReq;
    }

    public javax.megaco.message.ContextInfoReq contextInfoReqExpanded() {
        _contextInfoReq = new javax.megaco.message.ContextInfoReq("object", 1, 1, 1, false);
        commandEventExpanded(_contextInfoReq);
        return _contextInfoReq;
    }

    public javax.megaco.message.CommandResp commandRespExpanded() {
        _commandResp = Constants.CommandRespForValue(_cmdResponseType, "source", _exchangeId, _exchangeId, 0,false,false);
        commandEventExpanded(_commandResp);

        return _commandResp;
    }

    public javax.megaco.message.Termination terminationExpanded() {
        _termination = new javax.megaco.message.Termination();

        if (_termName != null)
            _termination.setTermName(_termName);
        //FIXME: BINARY
        //_termination.setTermName(Constants.byteArray(_termNameList));
        if (_termType != null)
            _termination.setTermType(_termType);
        //FIXME: BINARY 
        //_termination.setTermWildCard(Constants.byteArray(_termWildCardList));
        return _termination;
    }

    public javax.megaco.message.TermType termTypeExpanded() {
        _termType = Constants.TermTypeForValue($TerminationID);

        return _termType;
    }

    public javax.megaco.message.ContextInfoResp contextInfoRespExpanded() {
        _contextInfoResp = new javax.megaco.message.ContextInfoResp("object", 1, 1, 1, false);

        commandEventExpanded(_contextInfoResp);
        return _contextInfoResp;
    }

    public javax.megaco.message.CmdRequestType cmdRequestTypeExpanded() {
        _cmdRequestType = Constants.CmdRequestTypeForValue(_commandTypeToken);

        return _cmdRequestType;
    }

    public javax.megaco.association.SrvChngMethod srvChngMethodExpanded() {
        _srvChngMethod = Constants.SrvChngMethodForValue(Constants.coalesce($FailoverToken, $ForcedToken, $GracefulToken, $RestartToken, $DisconnectedToken, $HandOffToken, $extensionParameter));
        return _srvChngMethod;
    }

    public javax.megaco.association.LocalAddr localAddrExpanded() {
        _localAddr = new javax.megaco.association.LocalAddr();

        _localAddr.setPortId(_portId);
        if (_mtp3Addr != null)
            _localAddr.setMtp3Addr(_mtp3Addr);
        if (_aAL5Addr != null)
            _localAddr.setAAL5Addr(_aAL5Addr);
        return _localAddr;
    }

    public javax.megaco.association.RemoteAddr remoteAddrExpanded() {
        _remoteAddr = new javax.megaco.association.RemoteAddr();

        _remoteAddr.setPortId(_portId);
        if (_mtp3Addr != null)
            _remoteAddr.setMtp3Addr(_mtp3Addr);
        if (_aAL5Addr != null)
            _remoteAddr.setAAL5Addr(_aAL5Addr);
        return _remoteAddr;
    }

    /*
     * public javax.megaco.pkg.ParamValueType paramValueTypeExpanded() {
     * _paramValueType = Constants.ParamValueTypeForValue(_stringValue);
     *
     * return _paramValueType; }
     *
     */
    public javax.megaco.pkg.PkgItemStr pkgItemStrExpanded(PkgItemType pkgItemType) {
        _pkgItemStr = new javax.megaco.pkg.PkgItemStr();
        _megacoPkgItemStr = new PkgItemStr();
        _megacoPkgItemStr.setPkgName($PackageName);
        _megacoPkgItemStr.setItemType(pkgItemType);
        _megacoPkgItemStr.setItemName($ItemID);

        if (_parmValue != null)
            _megacoPkgItemStr.setParameter(_parmValue);

        _megacoPkgItemStrList.add(_pkgItemStr);
        //TODO clear
        return _pkgItemStr;
    }

    public javax.megaco.pkg.ParamRelation paramRelationExpanded() {
        if ($INEQUAL == null) {
            _paramRelation = Constants.ParamRelationForValue($EQUAL);
            _stringValue = $alternativeValue;
        } else {
            _paramRelation = Constants.ParamRelationForValue($INEQUAL);
            _stringValue = $VALUE;
            $INEQUAL = null;
        }

        return _paramRelation;
    }
    javax.megaco.pkg.MegacoPkg _associatedPkgId;
    java.lang.String _itemName;
    javax.megaco.pkg.PkgItemType _itemType;
    boolean _itemValue;
    List<Double> _itemValueList;
    javax.megaco.pkg.ParamRelation _itemsValueRelation;
    javax.megaco.pkg.MegacoPkg _megacoPkg;
    List<javax.megaco.pkg.PkgItemParam> _megacoPkgItemParamList;
    javax.megaco.pkg.ParamRelation _paramRelation;
    javax.megaco.pkg.ParamValueType _paramValueType;
    java.lang.String _parameter;
    java.lang.String _parmValue;
    javax.megaco.pkg.ParamRelation _paramsValueRelation;
    javax.megaco.pkg.PkgConsts _pkgConsts;
    javax.megaco.pkg.PkgEventItem _pkgEventItem;
    javax.megaco.pkg.PkgItem _pkgItem;
    javax.megaco.pkg.PkgItemParam _pkgItemParam;
    javax.megaco.pkg.PkgItemStr _pkgItemStr;
    javax.megaco.pkg.PkgItemType _pkgItemType;
    java.lang.String _pkgName;
    javax.megaco.pkg.PkgPrptyItem _pkgPrptyItem;
    javax.megaco.pkg.PkgSignalItem _pkgSignalItem;
    javax.megaco.pkg.PkgStatsItem _pkgStatsItem;
    //javax.megaco.pkg.PkgValueItem _pkgValueItem;
    java.lang.String _aAL5Addr;
    javax.megaco.message.descriptor.AuditCapDescriptor _auditCapDescriptor;
    javax.megaco.message.descriptor.AuditCapRespDescriptor _auditCapRespDescriptor;
    javax.megaco.message.descriptor.AuditValDescriptor _auditValDescriptor;
    javax.megaco.message.descriptor.AuditValRespDescriptor _auditValRespDescriptor;
    javax.megaco.message.CmdRequestType _cmdRequestType;
    javax.megaco.message.CmdResponseType _cmdResponseType;
    javax.megaco.message.descriptor.CntxtTermAudDescriptor _cntxtTermAudDescriptor;
    javax.megaco.message.CommandReq _commandReq;
    javax.megaco.message.CommandResp _commandResp;
    javax.megaco.message.CommandType _commandType;
    javax.megaco.message.ContextInfo _contextInfo;
    javax.megaco.message.ContextInfoReq _contextInfoReq;
    javax.megaco.message.ContextInfoResp _contextInfoResp;
    javax.megaco.message.ContextParam _contextParam;
    java.lang.String _dateValue;
    List<javax.megaco.message.Descriptor> _descriptorList;
    Stack<List<javax.megaco.message.Descriptor>> _descriptorListStack;
    javax.megaco.message.DescriptorType _descriptorType;
    javax.megaco.message.descriptor.DigitMapDescriptor _digitMapDescriptor;
    java.lang.String _digitMapName;
    javax.megaco.message.descriptor.DigitMapString _digitMapString;
    List<javax.megaco.message.descriptor.DigitMapString> _digitMapStringsList;
    javax.megaco.message.descriptor.DigitMapValue _digitMapValue;
    java.lang.String _digitMapValueStr;
    javax.megaco.message.descriptor.DigitStringPosition _digitStringPosition;
    List<javax.megaco.message.descriptor.DigitStringPosition> _digitStringPositionList;
    boolean _eM;
    javax.megaco.message.descriptor.EmbedFirstEventParam _embedFirstEventParam;
    javax.megaco.message.descriptor.ErrorDescriptor _errorDescriptor;
    java.lang.String _errorString;
    javax.megaco.message.descriptor.EventBufParam _eventBufParam;
    List<javax.megaco.message.descriptor.EventBufParam> _eventBufParamList;
    javax.megaco.message.descriptor.EventBufferCtrl _eventBufferCtrl;
    javax.megaco.message.descriptor.EventBufferDescriptor _eventBufferDescriptor;
    javax.megaco.message.descriptor.EventDescriptor _eventDescriptor;
    javax.megaco.message.descriptor.EventParam _eventParam;
    javax.megaco.message.descriptor.EventBufferCtrl _evtBufferControl;
    int _exchangeId;
    java.lang.String _extensionString;
    javax.megaco.association.LocalAddr _handOffMGCId;
    javax.megaco.message.descriptor.LocalCtrlDescriptor _lclCtrlDescriptor;
    javax.megaco.association.LocalAddr _localAddr;
    javax.megaco.message.descriptor.LocalCtrlDescriptor _localCtrlDescriptor;
    javax.megaco.message.descriptor.SDPInfo _localDescriptor;
    javax.megaco.message.descriptor.MediaStreamParam _mediaStreamParam;
    javax.megaco.pkg.PkgItemStr _megacoPkgItemStr;
    List<javax.megaco.pkg.PkgItemStr> _megacoPkgItemStrList;
    List<javax.megaco.message.descriptor.PackagesItem> _megacoPkgItemsList;
    List<javax.megaco.pkg.PkgItemStr> _megacoPkgItemsStrList;
    List<javax.megaco.pkg.PkgPrptyItem> _megacoPkgPrptyItemList;
    javax.megaco.message.descriptor.MediaDescriptor _mediaDescriptor;
    javax.megaco.message.descriptor.ModemDescriptor _modemDescriptor;
    javax.megaco.message.descriptor.ModemParam _modemParam;
    List<javax.megaco.message.descriptor.ModemParam> _modemParamList;
    javax.megaco.message.descriptor.ModemParamValue _modemParamValue;
    List<javax.megaco.message.descriptor.ModemParamValue> _modemParamValueList;
    javax.megaco.message.descriptor.ModemType _modemType;
    java.lang.String _mtp3Addr;
    javax.megaco.message.descriptor.MuxDescriptor _muxDescriptor;
    javax.megaco.message.descriptor.MuxType _muxType;
    javax.megaco.message.descriptor.ObsEventDescriptor _obsEventDescriptor;
    javax.megaco.message.descriptor.ObservedEvent _observedEvent;
    List<javax.megaco.message.descriptor.ObservedEvent> _observedEventList;
    javax.megaco.message.descriptor.PackageDescriptor _packageDescriptor;
    List<javax.megaco.message.descriptor.PackagesItem> _packagesItems;
    javax.megaco.message.descriptor.PackagesItem _packagesItem;
    java.lang.String _paramName;
    java.lang.String _parameterExtention;
    List<java.lang.String> _paramsValueList;
    List<javax.megaco.pkg.PkgStatsItem> _pkgStatsItemList;
    int _portId;
    int _priority;
    int _protocolVersion;
    javax.megaco.association.RemoteAddr _remoteAddr;
    javax.megaco.message.descriptor.SDPInfo _remoteDescriptor;
    javax.megaco.message.descriptor.RequestedEventParam _requestedEventParam;
    List<javax.megaco.message.descriptor.RequestedEventParam> _requestedEventParamList;
    boolean _reserveGroupPresent;
    boolean _reserveValuePresent;
    boolean _reserveGroup;
    boolean _reserveValue;
    List<javax.megaco.message.descriptor.StreamDescriptor> _streamDescriptorList;
    javax.megaco.message.descriptor.SDPInfo _sDPInfo;
    javax.megaco.message.descriptor.ServiceState _serviceState;
    java.lang.String _sessionDescStr;
    javax.sdp.SessionDescription _sessionDescription;
    javax.megaco.message.descriptor.SignalDescriptor _signalDescriptor;
    int _signalDuration;
    javax.megaco.message.descriptor.SignalNotifyReason _signalNotifyReason;
    javax.megaco.message.descriptor.SignalParam _signalParam;
    List<javax.megaco.message.descriptor.SignalParam> _signalParamList;
    javax.megaco.message.descriptor.SignalParamType _signalParamType;
    List<javax.megaco.message.descriptor.SignalRequest> _signalRequestList;
    javax.megaco.message.descriptor.SignalRequest _signalRequest;
    javax.megaco.message.descriptor.SignalType _signalType;
    javax.megaco.association.LocalAddr _srvChngAddress;
    int _srvChngDelay;
    javax.megaco.message.descriptor.SrvChngDescriptor _srvChngDescriptor;
    javax.megaco.association.SrvChngMethod _srvChngMethod;
    java.lang.String _srvChngProfile;
    javax.megaco.association.SrvChngReason _srvChngReason;
    javax.megaco.message.descriptor.SrvChngRespDescriptor _srvChngRespDescriptor;
    javax.megaco.message.descriptor.StatsDescriptor _statsDescriptor;
    javax.megaco.message.descriptor.StreamDescriptor _streamDescriptor;
    int _streamId;
    javax.megaco.message.descriptor.StreamMode _streamMode;
    java.lang.String _svcChngMethodExtension;
    java.lang.String _termName;
    List<java.lang.Byte> _termNameList;
    javax.megaco.message.descriptor.TermStateDescriptor _termStateDescriptor;
    javax.megaco.message.TermType _termType;
    List<java.lang.Byte> _termWildCardList;
    javax.megaco.message.Termination _termination;
    List<javax.megaco.message.Termination> _terminationIdList;
    List<javax.megaco.message.Termination> _terminationList;
    javax.megaco.message.descriptor.TimeStamp _timeStamp;
    java.lang.String _timeValue;
    Integer _timerLValue;
    Integer _timerSValue;
    Integer _timerTValue;
    javax.megaco.message.descriptor.TopologyDescriptor _topologyDescriptor;
    List<javax.megaco.message.descriptor.TopologyDescriptor> _topologyDescriptorList;
    javax.megaco.message.descriptor.TopologyDirection _topologyDirection;
    String _stringValue;
    String _numericValue;
    List<javax.megaco.CommandEvent> _message;
    boolean _commandOptional = false;
    boolean _commandWildcard = false;
    boolean _firstCommandInAction = true;
    String _commandTypeToken = null;
    protected String _transactionType = null;
    MessageHeader _messageHeader = null;
    int _requestID;
    List<DescriptorType> _auditItemList;
    protected int _transactionId;
    List<Integer[]> _transactionList;

    public void init() {
        _message = new ArrayList<javax.megaco.CommandEvent>();
        _aAL5Addr = null;
        _auditCapDescriptor = null;
        _auditCapRespDescriptor = null;
        _auditValDescriptor = null;
        _auditValRespDescriptor = null;
        _cmdRequestType = null;
        _cmdResponseType = null;
        _cntxtTermAudDescriptor = null;
        _commandReq = null;
        _commandResp = null;
        _commandType = null;
        _contextInfo = null;
        _contextInfoReq = null;
        _contextInfoResp = null;
        _contextParam = null;
        _dateValue = null;
        _descriptorList = new ArrayList<javax.megaco.message.Descriptor>();
        _descriptorListStack = new Stack<List<javax.megaco.message.Descriptor>>();
        _descriptorType = null;
        _digitMapDescriptor = null;
        _digitMapName = null;
        _digitMapString = null;
        _digitMapStringsList = new ArrayList<javax.megaco.message.descriptor.DigitMapString>();
        _digitMapValue = null;
        _digitMapValueStr = null;
        _digitStringPosition = null;
        _digitStringPositionList = new ArrayList<javax.megaco.message.descriptor.DigitStringPosition>();
        _eM = false;
        _embedFirstEventParam = null;
        _errorDescriptor = null;
        _errorString = null;
        _eventBufParam = null;
        _eventBufParamList = new ArrayList<javax.megaco.message.descriptor.EventBufParam>();
        _eventBufferCtrl = null;
        _eventBufferDescriptor = null;
        _eventDescriptor = null;
        _eventParam = null;
        _evtBufferControl = null;
        _exchangeId = 0;
        _extensionString = null;
        _handOffMGCId = null;
        _itemValueList = new ArrayList<Double>();
        _lclCtrlDescriptor = null;
        _localAddr = null;
        _localCtrlDescriptor = null;
        _localDescriptor = null;
        _mediaStreamParam = null;
        _megacoPkgItemParamList = new ArrayList<javax.megaco.pkg.PkgItemParam>();
        _megacoPkgItemStr = null;
        _megacoPkgItemStrList = new ArrayList<javax.megaco.pkg.PkgItemStr>();
        _megacoPkgItemsList = new ArrayList<javax.megaco.message.descriptor.PackagesItem>();
        _megacoPkgItemsStrList = new ArrayList<javax.megaco.pkg.PkgItemStr>();
        _megacoPkgPrptyItemList = new ArrayList<javax.megaco.pkg.PkgPrptyItem>();
        _mediaDescriptor = null;
        _modemDescriptor = null;
        _modemParam = null;
        _modemParamList = new ArrayList<javax.megaco.message.descriptor.ModemParam>();
        _modemParamValue = null;
        _modemParamValueList = new ArrayList<javax.megaco.message.descriptor.ModemParamValue>();
        _modemType = null;
        _mtp3Addr = null;
        _muxDescriptor = null;
        _muxType = null;
        _obsEventDescriptor = null;
        _observedEvent = null;
        _observedEventList = new ArrayList<javax.megaco.message.descriptor.ObservedEvent>();
        _packageDescriptor = null;
        _packagesItem = null;
        _paramName = null;
        _parameterExtention = null;
        _paramsValueList = new ArrayList<java.lang.String>();
        _paramsValueRelation = null;
        _pkgStatsItemList = new ArrayList<javax.megaco.pkg.PkgStatsItem>();
        _portId = 0;
        _priority = 0;
        _protocolVersion = 0;
        _remoteAddr = null;
        _remoteDescriptor = null;
        _requestedEventParam = null;
        _requestedEventParamList = new ArrayList<javax.megaco.message.descriptor.RequestedEventParam>();
        _reserveGroup = false;
        _reserveValue = false;
        _sDPInfo = null;
        _serviceState = null;
        _sessionDescStr = null;
        _sessionDescription = null;
        _signalDescriptor = null;
        _signalDuration = 0;
        _signalNotifyReason = null;
        _signalParam = null;
        _signalParamList = new ArrayList<javax.megaco.message.descriptor.SignalParam>();
        _signalParamType = null;
        _signalRequestList = new ArrayList<javax.megaco.message.descriptor.SignalRequest>();
        _signalRequest = null;
        _signalType = null;
        _srvChngAddress = null;
        _srvChngDelay = 0;
        _srvChngDescriptor = null;
        _srvChngMethod = null;
        _srvChngProfile = null;
        _srvChngReason = null;
        _srvChngRespDescriptor = null;
        _statsDescriptor = null;
        _streamDescriptorList = new ArrayList<javax.megaco.message.descriptor.StreamDescriptor>();
        _streamDescriptor = null;
        _streamId = 0;
        _streamMode = null;
        _svcChngMethodExtension = null;
        _termName = null;
        _termNameList = new ArrayList<java.lang.Byte>();
        _termStateDescriptor = null;
        _termType = null;
        _termWildCardList = new ArrayList<java.lang.Byte>();
        _termination = null;
        _terminationIdList = new ArrayList<javax.megaco.message.Termination>();
        _terminationList = new ArrayList<javax.megaco.message.Termination>();
        _timeStamp = null;
        _timeValue = null;
        _timerLValue = null;
        _timerSValue = null;
        _timerTValue = null;
        _topologyDescriptor = null;
        _topologyDescriptorList = new ArrayList<javax.megaco.message.descriptor.TopologyDescriptor>();
        _topologyDirection = null;

        _stringValue = null;
        _numericValue = null;
        _firstCommandInAction = true;
        _commandTypeToken = null;
        _transactionType = null;

        _messageHeader = new MessageHeader();
        _requestID = 0;
        _auditItemList = new ArrayList<DescriptorType>();
        _transactionList = new ArrayList<Integer[]>();
    }

    public void reset() {
        _message.clear();
        _aAL5Addr = null;
        _auditCapDescriptor = null;
        _auditCapRespDescriptor = null;
        _auditValDescriptor = null;
        _auditValRespDescriptor = null;
        _cmdRequestType = null;
        _cmdResponseType = null;
        _cntxtTermAudDescriptor = null;
        _commandReq = null;
        _commandResp = null;
        _commandType = null;
        _contextInfo = null;
        _contextInfoReq = null;
        _contextInfoResp = null;
        _contextParam = null;
        _dateValue = null;
        _descriptorList.clear();
        _descriptorListStack.clear();
        _descriptorType = null;
        _digitMapDescriptor = null;
        _digitMapName = null;
        _digitMapString = null;
        _digitMapStringsList.clear();
        _digitMapValue = null;
        _digitMapValueStr = null;
        _digitStringPosition = null;
        _digitStringPositionList.clear();
        _eM = false;
        _embedFirstEventParam = null;
        _errorDescriptor = null;
        _errorString = null;
        _eventBufParam = null;
        _eventBufParamList.clear();
        _eventBufferCtrl = null;
        _eventBufferDescriptor = null;
        _eventDescriptor = null;
        _eventParam = null;
        _evtBufferControl = null;
        _exchangeId = 0;
        _extensionString = null;
        _handOffMGCId = null;
        _lclCtrlDescriptor = null;
        _localAddr = null;
        _localCtrlDescriptor = null;
        _localDescriptor = null;
        _mediaDescriptor = null;
        _mediaStreamParam = null;
        _megacoPkgItemStr = null;
        _megacoPkgItemStrList.clear();
        _megacoPkgItemsList.clear();
        _megacoPkgItemsStrList.clear();
        _megacoPkgPrptyItemList.clear();
        _modemDescriptor = null;
        _modemParam = null;
        _modemParamList.clear();
        _modemParamValue = null;
        _modemParamValueList.clear();
        _modemType = null;
        _mtp3Addr = null;
        _muxDescriptor = null;
        _muxType = null;
        _obsEventDescriptor = null;
        _observedEvent = null;
        _observedEventList.clear();
        _packageDescriptor = null;
        _packagesItem = null;
        _paramName = null;
        _parmValue = null;
        _parameterExtention = null;
        _paramsValueList.clear();
        _paramsValueRelation = null;
        _pkgStatsItemList.clear();
        _portId = 0;
        _priority = 0;
        _protocolVersion = 0;
        _remoteAddr = null;
        _remoteDescriptor = null;
        _requestedEventParam = null;
        _requestedEventParamList.clear();
        _reserveGroup = false;
        _reserveValue = false;
        _reserveGroupPresent = false;
        _reserveValuePresent = false;
        _sDPInfo = null;
        _serviceState = null;
        _sessionDescStr = null;
        _sessionDescription = null;
        _signalDescriptor = null;
        _signalDuration = 0;
        _signalNotifyReason = null;
        _signalParam = null;
        _signalParamList.clear();
        _signalParamType = null;
        _signalRequestList.clear();
        _signalRequest = null;
        _signalType = null;
        _srvChngAddress = null;
        _srvChngDelay = 0;
        _srvChngDescriptor = null;
        _srvChngMethod = null;
        _srvChngProfile = null;
        _srvChngReason = null;
        _srvChngRespDescriptor = null;
        _statsDescriptor = null;
        _streamDescriptorList.clear();
        _streamDescriptor = null;
        _streamId = 0;
        _streamMode = null;
        _svcChngMethodExtension = null;
        _termName = null;
        _termNameList.clear();
        _termStateDescriptor = null;
        _termType = null;
        _termWildCardList.clear();
        _termination = null;
        _terminationIdList.clear();
        _terminationList.clear();
        _timeStamp = null;
        _timeValue = null;
        _timerLValue = null;
        _timerSValue = null;
        _timerTValue = null;
        _topologyDescriptor = null;
        _topologyDescriptorList.clear();
        _topologyDirection = null;

        _stringValue = null;
        _numericValue = null;

        _commandOptional = false;
        _commandWildcard = false;
        _transactionId = 0;
        _firstCommandInAction = true;
        _commandTypeToken = null;


        _associatedPkgId = null;
        _itemName = null;
        _itemType = null;
        _itemValue = false;
        _itemValueList.clear();
        _itemsValueRelation = null;
        _megacoPkg = null;
        _megacoPkgItemParamList.clear();
        _paramRelation = null;
        _paramValueType = null;
        _parameter = null;
        _paramsValueRelation = null;
        _pkgConsts = null;
        _pkgEventItem = null;
        _pkgItem = null;
        _pkgItemParam = null;
        _pkgItemStr = null;
        _pkgItemType = null;
        _pkgName = null;
        _pkgPrptyItem = null;
        _pkgSignalItem = null;
        _pkgStatsItem = null;
//        _pkgValueItem = null;

        _transactionType = null;
        _messageHeader = new MessageHeader();
        _transactionList.clear();

        _requestID = 0;
        _auditItemList.clear();
    }

    protected void setLastCommandInTxn() {
        if (_message.size() > 0)
            _message.get(_message.size() - 1).setLastCommandInTxn();
    }

    PkgItem pkgItemExpanded() {
        try {
// 2
            if ("root".equals($PackageName)) {
                _megacoPkg = new javax.megaco.pkg.BaseRootPkg.BaseRootPkg();
                if ("normalMGCExecutionTime".equals($ItemID)) {// prpt 4
                    _pkgPrptyItem = new javax.megaco.pkg.BaseRootPkg.RootNormMGCExecTimePrpt();
                    _pkgPrptyItem.setItemValue(Constants.valueForInteger(_parmValue));
                    _pkgPrptyItem.setItemsValueRelation(paramRelationExpanded());
                    _megacoPkgPrptyItemList.add(_pkgPrptyItem);
                    return _pkgPrptyItem;
                }
                if ("maxTerminationsPerContext".equals($ItemID)) {// prpt 2
                    _pkgPrptyItem = new javax.megaco.pkg.BaseRootPkg.RootMaxTermsPerCtxtPrpt();
                    _pkgPrptyItem.setItemValue(Constants.valueForInteger(_parmValue));
                    _pkgPrptyItem.setItemsValueRelation(paramRelationExpanded());
                    _megacoPkgPrptyItemList.add(_pkgPrptyItem);
                    return _pkgPrptyItem;
                }
                if ("maxNumberOfContexts".equals($ItemID)) {// prpt 1
                    _pkgPrptyItem = new javax.megaco.pkg.BaseRootPkg.RootMaxNrOfCtxtPrpt();
                    _pkgPrptyItem.setItemValue(Constants.valueForDouble(_parmValue));
                    _pkgPrptyItem.setItemsValueRelation(paramRelationExpanded());
                    _megacoPkgPrptyItemList.add(_pkgPrptyItem);
                    return _pkgPrptyItem;
                }
                if ("MGProvisionalResponseTimerValue".equals($ItemID)) {// prpt 5
                    _pkgPrptyItem = new javax.megaco.pkg.BaseRootPkg.RootProvRespTimePrpt();
                    _pkgPrptyItem.setItemValue(Constants.valueForInteger(_parmValue));
                    _pkgPrptyItem.setItemsValueRelation(paramRelationExpanded());
                    _megacoPkgPrptyItemList.add(_pkgPrptyItem);
                    return _pkgPrptyItem;
                }
                if ("normalMGExecutionTime".equals($ItemID)) {// prpt 3
                    _pkgPrptyItem = new javax.megaco.pkg.BaseRootPkg.RootNormMGExecTimePrpt();
                    _pkgPrptyItem.setItemValue(Constants.valueForInteger(_parmValue));
                    _pkgPrptyItem.setItemsValueRelation(paramRelationExpanded());
                    _megacoPkgPrptyItemList.add(_pkgPrptyItem);
                    return _pkgPrptyItem;
                }
            }
// 7
            if ("cg".equals($PackageName)) {
                _megacoPkg = new javax.megaco.pkg.CPToneGenPkg.CPToneGenPkg();
                if ("sit".equals($ItemID)) { // signal 52
                    _pkgSignalItem = new javax.megaco.pkg.CPToneGenPkg.CPToneGenSitSignal();
                    if (_megacoPkgItemParamList.size() > 0)
                        _pkgSignalItem.setMegacoPkgItemParam(_megacoPkgItemParamList.toArray(new PkgItemParam[_megacoPkgItemParamList.size()]));
                    _megacoPkgItemParamList.clear();
                    return _pkgSignalItem;
                }
                if ("prt".equals($ItemID)) { // signal 54
                    _pkgSignalItem = new javax.megaco.pkg.CPToneGenPkg.CPToneGenPtSignal();
                    if (_megacoPkgItemParamList.size() > 0)
                        _pkgSignalItem.setMegacoPkgItemParam(_megacoPkgItemParamList.toArray(new PkgItemParam[_megacoPkgItemParamList.size()]));
                    _megacoPkgItemParamList.clear();
                    return _pkgSignalItem;
                }
                if ("cr".equals($ItemID)) { // signal 56
                    _pkgSignalItem = new javax.megaco.pkg.CPToneGenPkg.CPToneGenCrSignal();
                    if (_megacoPkgItemParamList.size() > 0)
                        _pkgSignalItem.setMegacoPkgItemParam(_megacoPkgItemParamList.toArray(new PkgItemParam[_megacoPkgItemParamList.size()]));
                    _megacoPkgItemParamList.clear();
                    return _pkgSignalItem;
                }
                if ("rt".equals($ItemID)) { // signal 49
                    _pkgSignalItem = new javax.megaco.pkg.CPToneGenPkg.CPToneGenRtSignal();
                    if (_megacoPkgItemParamList.size() > 0)
                        _pkgSignalItem.setMegacoPkgItemParam(_megacoPkgItemParamList.toArray(new PkgItemParam[_megacoPkgItemParamList.size()]));
                    _megacoPkgItemParamList.clear();
                    return _pkgSignalItem;
                }
                if ("bt".equals($ItemID)) { // signal 50
                    _pkgSignalItem = new javax.megaco.pkg.CPToneGenPkg.CPToneGenBtSignal();
                    if (_megacoPkgItemParamList.size() > 0)
                        _pkgSignalItem.setMegacoPkgItemParam(_megacoPkgItemParamList.toArray(new PkgItemParam[_megacoPkgItemParamList.size()]));
                    _megacoPkgItemParamList.clear();
                    return _pkgSignalItem;
                }
                if ("ct".equals($ItemID)) { // signal 51
                    _pkgSignalItem = new javax.megaco.pkg.CPToneGenPkg.CPToneGenCtSignal();
                    if (_megacoPkgItemParamList.size() > 0)
                        _pkgSignalItem.setMegacoPkgItemParam(_megacoPkgItemParamList.toArray(new PkgItemParam[_megacoPkgItemParamList.size()]));
                    _megacoPkgItemParamList.clear();
                    return _pkgSignalItem;
                }
                if ("dt".equals($ItemID)) { // signal 48
                    _pkgSignalItem = new javax.megaco.pkg.CPToneGenPkg.CPToneGenDtSignal();
                    if (_megacoPkgItemParamList.size() > 0)
                        _pkgSignalItem.setMegacoPkgItemParam(_megacoPkgItemParamList.toArray(new PkgItemParam[_megacoPkgItemParamList.size()]));
                    _megacoPkgItemParamList.clear();
                    return _pkgSignalItem;
                }
                if ("wt".equals($ItemID)) { // signal 53
                    _pkgSignalItem = new javax.megaco.pkg.CPToneGenPkg.CPToneGenWtSignal();
                    if (_megacoPkgItemParamList.size() > 0)
                        _pkgSignalItem.setMegacoPkgItemParam(_megacoPkgItemParamList.toArray(new PkgItemParam[_megacoPkgItemParamList.size()]));
                    _megacoPkgItemParamList.clear();
                    return _pkgSignalItem;
                }
                if ("cw".equals($ItemID)) { // signal 55
                    _pkgSignalItem = new javax.megaco.pkg.CPToneGenPkg.CPToneGenCwtSignal();
                    if (_megacoPkgItemParamList.size() > 0)
                        _pkgSignalItem.setMegacoPkgItemParam(_megacoPkgItemParamList.toArray(new PkgItemParam[_megacoPkgItemParamList.size()]));
                    _megacoPkgItemParamList.clear();
                    return _pkgSignalItem;
                }
            }
// 5
            if ("dg".equals($PackageName)) {
                _megacoPkg = new javax.megaco.pkg.DTMFGenPkg.DTMFGenPkg();
                if ("d0".equals($ItemID)) { // signal 16
                    _pkgSignalItem = new javax.megaco.pkg.DTMFGenPkg.DTMFGenD0Signal();
                    if (_megacoPkgItemParamList.size() > 0)
                        _pkgSignalItem.setMegacoPkgItemParam(_megacoPkgItemParamList.toArray(new PkgItemParam[_megacoPkgItemParamList.size()]));
                    _megacoPkgItemParamList.clear();
                    return _pkgSignalItem;
                }
                if ("d1".equals($ItemID)) { // signal 17
                    _pkgSignalItem = new javax.megaco.pkg.DTMFGenPkg.DTMFGenD1Signal();
                    if (_megacoPkgItemParamList.size() > 0)
                        _pkgSignalItem.setMegacoPkgItemParam(_megacoPkgItemParamList.toArray(new PkgItemParam[_megacoPkgItemParamList.size()]));
                    _megacoPkgItemParamList.clear();
                    return _pkgSignalItem;
                }
                if ("d2".equals($ItemID)) { // signal 18
                    _pkgSignalItem = new javax.megaco.pkg.DTMFGenPkg.DTMFGenD2Signal();
                    if (_megacoPkgItemParamList.size() > 0)
                        _pkgSignalItem.setMegacoPkgItemParam(_megacoPkgItemParamList.toArray(new PkgItemParam[_megacoPkgItemParamList.size()]));
                    _megacoPkgItemParamList.clear();
                    return _pkgSignalItem;
                }
                if ("d3".equals($ItemID)) { // signal 19
                    _pkgSignalItem = new javax.megaco.pkg.DTMFGenPkg.DTMFGenD3Signal();
                    if (_megacoPkgItemParamList.size() > 0)
                        _pkgSignalItem.setMegacoPkgItemParam(_megacoPkgItemParamList.toArray(new PkgItemParam[_megacoPkgItemParamList.size()]));
                    _megacoPkgItemParamList.clear();
                    return _pkgSignalItem;
                }
                if ("d4".equals($ItemID)) { // signal 20
                    _pkgSignalItem = new javax.megaco.pkg.DTMFGenPkg.DTMFGenD4Signal();
                    if (_megacoPkgItemParamList.size() > 0)
                        _pkgSignalItem.setMegacoPkgItemParam(_megacoPkgItemParamList.toArray(new PkgItemParam[_megacoPkgItemParamList.size()]));
                    _megacoPkgItemParamList.clear();
                    return _pkgSignalItem;
                }
                if ("d5".equals($ItemID)) { // signal 21
                    _pkgSignalItem = new javax.megaco.pkg.DTMFGenPkg.DTMFGenD5Signal();
                    if (_megacoPkgItemParamList.size() > 0)
                        _pkgSignalItem.setMegacoPkgItemParam(_megacoPkgItemParamList.toArray(new PkgItemParam[_megacoPkgItemParamList.size()]));
                    _megacoPkgItemParamList.clear();
                    return _pkgSignalItem;
                }
                if ("d6".equals($ItemID)) { // signal 22
                    _pkgSignalItem = new javax.megaco.pkg.DTMFGenPkg.DTMFGenD6Signal();
                    if (_megacoPkgItemParamList.size() > 0)
                        _pkgSignalItem.setMegacoPkgItemParam(_megacoPkgItemParamList.toArray(new PkgItemParam[_megacoPkgItemParamList.size()]));
                    _megacoPkgItemParamList.clear();
                    return _pkgSignalItem;
                }
                if ("d7".equals($ItemID)) { // signal 23
                    _pkgSignalItem = new javax.megaco.pkg.DTMFGenPkg.DTMFGenD7Signal();
                    if (_megacoPkgItemParamList.size() > 0)
                        _pkgSignalItem.setMegacoPkgItemParam(_megacoPkgItemParamList.toArray(new PkgItemParam[_megacoPkgItemParamList.size()]));
                    _megacoPkgItemParamList.clear();
                    return _pkgSignalItem;
                }
                if ("d8".equals($ItemID)) { // signal 24
                    _pkgSignalItem = new javax.megaco.pkg.DTMFGenPkg.DTMFGenD8Signal();
                    if (_megacoPkgItemParamList.size() > 0)
                        _pkgSignalItem.setMegacoPkgItemParam(_megacoPkgItemParamList.toArray(new PkgItemParam[_megacoPkgItemParamList.size()]));
                    _megacoPkgItemParamList.clear();
                    return _pkgSignalItem;
                }
                if ("d9".equals($ItemID)) { // signal 25
                    _pkgSignalItem = new javax.megaco.pkg.DTMFGenPkg.DTMFGenD9Signal();
                    if (_megacoPkgItemParamList.size() > 0)
                        _pkgSignalItem.setMegacoPkgItemParam(_megacoPkgItemParamList.toArray(new PkgItemParam[_megacoPkgItemParamList.size()]));
                    _megacoPkgItemParamList.clear();
                    return _pkgSignalItem;
                }
                if ("ds".equals($ItemID)) { // signal 32
                    _pkgSignalItem = new javax.megaco.pkg.DTMFGenPkg.DTMFGenDStarSignal();
                    if (_megacoPkgItemParamList.size() > 0)
                        _pkgSignalItem.setMegacoPkgItemParam(_megacoPkgItemParamList.toArray(new PkgItemParam[_megacoPkgItemParamList.size()]));
                    _megacoPkgItemParamList.clear();
                    return _pkgSignalItem;
                }
                if ("da".equals($ItemID)) { // signal 26
                    _pkgSignalItem = new javax.megaco.pkg.DTMFGenPkg.DTMFGenDASignal();
                    if (_megacoPkgItemParamList.size() > 0)
                        _pkgSignalItem.setMegacoPkgItemParam(_megacoPkgItemParamList.toArray(new PkgItemParam[_megacoPkgItemParamList.size()]));
                    _megacoPkgItemParamList.clear();
                    return _pkgSignalItem;
                }
                if ("db".equals($ItemID)) { // signal 27
                    _pkgSignalItem = new javax.megaco.pkg.DTMFGenPkg.DTMFGenDBSignal();
                    if (_megacoPkgItemParamList.size() > 0)
                        _pkgSignalItem.setMegacoPkgItemParam(_megacoPkgItemParamList.toArray(new PkgItemParam[_megacoPkgItemParamList.size()]));
                    _megacoPkgItemParamList.clear();
                    return _pkgSignalItem;
                }
                if ("dc".equals($ItemID)) { // signal 28
                    _pkgSignalItem = new javax.megaco.pkg.DTMFGenPkg.DTMFGenDCSignal();
                    if (_megacoPkgItemParamList.size() > 0)
                        _pkgSignalItem.setMegacoPkgItemParam(_megacoPkgItemParamList.toArray(new PkgItemParam[_megacoPkgItemParamList.size()]));
                    _megacoPkgItemParamList.clear();
                    return _pkgSignalItem;
                }
                if ("do".equals($ItemID)) { // signal 33
                    _pkgSignalItem = new javax.megaco.pkg.DTMFGenPkg.DTMFGenDHashSignal();
                    if (_megacoPkgItemParamList.size() > 0)
                        _pkgSignalItem.setMegacoPkgItemParam(_megacoPkgItemParamList.toArray(new PkgItemParam[_megacoPkgItemParamList.size()]));
                    _megacoPkgItemParamList.clear();
                    return _pkgSignalItem;
                }
                if ("dd".equals($ItemID)) { // signal 29
                    _pkgSignalItem = new javax.megaco.pkg.DTMFGenPkg.DTMFGenDDSignal();
                    if (_megacoPkgItemParamList.size() > 0)
                        _pkgSignalItem.setMegacoPkgItemParam(_megacoPkgItemParamList.toArray(new PkgItemParam[_megacoPkgItemParamList.size()]));
                    _megacoPkgItemParamList.clear();
                    return _pkgSignalItem;
                }
            }
// 8
            if ("cd".equals($PackageName)) {
                _megacoPkg = new javax.megaco.pkg.CPToneDetPkg.CPToneDetPkg();
                if ("wt".equals($ItemID)) { // event 53
                    _pkgEventItem = new javax.megaco.pkg.CPToneDetPkg.CPToneDetWtEvt();
                    if (_megacoPkgItemParamList.size() > 0)
                        _pkgEventItem.setMegacoPkgItemParam(_megacoPkgItemParamList.toArray(new PkgItemParam[_megacoPkgItemParamList.size()]));
                    _megacoPkgItemParamList.clear();
                    return _pkgEventItem;
                }
                if ("cw".equals($ItemID)) { // event 55
                    _pkgEventItem = new javax.megaco.pkg.CPToneDetPkg.CPToneDetCwtEvt();
                    if (_megacoPkgItemParamList.size() > 0)
                        _pkgEventItem.setMegacoPkgItemParam(_megacoPkgItemParamList.toArray(new PkgItemParam[_megacoPkgItemParamList.size()]));
                    _megacoPkgItemParamList.clear();
                    return _pkgEventItem;
                }
                if ("sit".equals($ItemID)) { // event 52
                    _pkgEventItem = new javax.megaco.pkg.CPToneDetPkg.CPToneDetSitEvt();
                    if (_megacoPkgItemParamList.size() > 0)
                        _pkgEventItem.setMegacoPkgItemParam(_megacoPkgItemParamList.toArray(new PkgItemParam[_megacoPkgItemParamList.size()]));
                    _megacoPkgItemParamList.clear();
                    return _pkgEventItem;
                }
                if ("prt".equals($ItemID)) { // event 54
                    _pkgEventItem = new javax.megaco.pkg.CPToneDetPkg.CPToneDetPtEvt();
                    if (_megacoPkgItemParamList.size() > 0)
                        _pkgEventItem.setMegacoPkgItemParam(_megacoPkgItemParamList.toArray(new PkgItemParam[_megacoPkgItemParamList.size()]));
                    _megacoPkgItemParamList.clear();
                    return _pkgEventItem;
                }
                if ("cr".equals($ItemID)) { // event 56
                    _pkgEventItem = new javax.megaco.pkg.CPToneDetPkg.CPToneDetCrEvt();
                    if (_megacoPkgItemParamList.size() > 0)
                        _pkgEventItem.setMegacoPkgItemParam(_megacoPkgItemParamList.toArray(new PkgItemParam[_megacoPkgItemParamList.size()]));
                    _megacoPkgItemParamList.clear();
                    return _pkgEventItem;
                }
                if ("bt".equals($ItemID)) { // event 50
                    _pkgEventItem = new javax.megaco.pkg.CPToneDetPkg.CPToneDetBtEvt();
                    if (_megacoPkgItemParamList.size() > 0)
                        _pkgEventItem.setMegacoPkgItemParam(_megacoPkgItemParamList.toArray(new PkgItemParam[_megacoPkgItemParamList.size()]));
                    _megacoPkgItemParamList.clear();
                    return _pkgEventItem;
                }
                if ("rt".equals($ItemID)) { // event 49
                    _pkgEventItem = new javax.megaco.pkg.CPToneDetPkg.CPToneDetRtEvt();
                    if (_megacoPkgItemParamList.size() > 0)
                        _pkgEventItem.setMegacoPkgItemParam(_megacoPkgItemParamList.toArray(new PkgItemParam[_megacoPkgItemParamList.size()]));
                    _megacoPkgItemParamList.clear();
                    return _pkgEventItem;
                }
                if ("ct".equals($ItemID)) { // event 51
                    _pkgEventItem = new javax.megaco.pkg.CPToneDetPkg.CPToneDetCtEvt();
                    if (_megacoPkgItemParamList.size() > 0)
                        _pkgEventItem.setMegacoPkgItemParam(_megacoPkgItemParamList.toArray(new PkgItemParam[_megacoPkgItemParamList.size()]));
                    _megacoPkgItemParamList.clear();
                    return _pkgEventItem;
                }
                if ("dt".equals($ItemID)) { // event 48
                    _pkgEventItem = new javax.megaco.pkg.CPToneDetPkg.CPToneDetDtEvt();
                    if (_megacoPkgItemParamList.size() > 0)
                        _pkgEventItem.setMegacoPkgItemParam(_megacoPkgItemParamList.toArray(new PkgItemParam[_megacoPkgItemParamList.size()]));
                    _megacoPkgItemParamList.clear();
                    return _pkgEventItem;
                }
            }
// 13
            if ("tdmc".equals($PackageName)) {
                _megacoPkg = new javax.megaco.pkg.TDMCktPkg.TDMCktPkg();
                if ("ec".equals($ItemID)) {// prpt 8
                    _pkgPrptyItem = new javax.megaco.pkg.TDMCktPkg.TDMCktEcPrpt();
                    _pkgPrptyItem.setItemValue(Constants.valueForBoolean(_parmValue));
                    _pkgPrptyItem.setItemsValueRelation(paramRelationExpanded());
                    _megacoPkgPrptyItemList.add(_pkgPrptyItem);
                    return _pkgPrptyItem;
                }
                if ("gain".equals($ItemID)) {// prpt 10
                    _pkgPrptyItem = new javax.megaco.pkg.TDMCktPkg.TDMCktGainPrpt();
                    _pkgPrptyItem.setItemValue(Constants.valueForInteger(_parmValue));
                    _pkgPrptyItem.setItemsValueRelation(paramRelationExpanded());
                    _megacoPkgPrptyItemList.add(_pkgPrptyItem);
                    return _pkgPrptyItem;
                }
            }
// 6
            if ("dd".equals($PackageName))
                _megacoPkg = new javax.megaco.pkg.DTMFDetPkg.DTMFDetPkg();
            if ("dd".equals($PackageName) || "edtmf".equals($PackageName))
                if ("dur".equals($ItemID)) { // event 1
                    _pkgEventItem = new javax.megaco.pkg.DTMFDetPkg.DTMFDetCeEvt();
                    if (_megacoPkgItemParamList.size() > 0)
                        _pkgEventItem.setMegacoPkgItemParam(_megacoPkgItemParamList.toArray(new PkgItemParam[_megacoPkgItemParamList.size()]));
                    _megacoPkgItemParamList.clear();
                    return _pkgEventItem;
                }
// 11
            if ("nt".equals($PackageName))
                _megacoPkg = new javax.megaco.pkg.NetworkPkg.NetworkPkg();
            if ("nt".equals($PackageName) || "tdmc".equals($PackageName) || "rtpFIXME".equals($PackageName)) {
                if ("jit".equals($ItemID)) {// prpt 7
                    _pkgPrptyItem = new javax.megaco.pkg.NetworkPkg.NetworkJitPrpt();
                    _pkgPrptyItem.setItemValue(Constants.valueForInteger(_parmValue));
                    _pkgPrptyItem.setItemsValueRelation(paramRelationExpanded());
                    _megacoPkgPrptyItemList.add(_pkgPrptyItem);
                    return _pkgPrptyItem;
                }
                if ("dur".equals($ItemID)) { // stats 1
                    _pkgStatsItem = new javax.megaco.pkg.NetworkPkg.NetworkDurStats();
                    _pkgStatsItem.setItemValue(Constants.valueForDouble(_stringValue));
                    _pkgStatsItem.setItemsValueRelation(paramRelationExpanded());
                    return _pkgStatsItem;
                }
                if ("or".equals($ItemID)) { // stats 3
                    _pkgStatsItem = new javax.megaco.pkg.NetworkPkg.NetworkOrStats();
                    _pkgStatsItem.setItemValue(Constants.valueForString(_stringValue));
                    _pkgStatsItem.setItemsValueRelation(paramRelationExpanded());
                    return _pkgStatsItem;
                }
                if ("os".equals($ItemID)) { // stats 2
                    _pkgStatsItem = new javax.megaco.pkg.NetworkPkg.NetworkOsStats();
                    _pkgStatsItem.setItemValue(Constants.valueForString(_stringValue));
                    _pkgStatsItem.setItemsValueRelation(paramRelationExpanded());
                    return _pkgStatsItem;
                }
                if ("qualert".equals($ItemID)) { // event 6
// NetworkParamCs
                    if ("qualert".equals($ItemID) && "th".equals($eventParameterName)) {// event param 1
                        _pkgItemParam = new javax.megaco.pkg.NetworkPkg.NetworkParamCs();
                        _pkgItemParam.setItemValue(Constants.valueForString(_parmValue));
                        _pkgItemParam.setParamsValueRelation(paramRelationExpanded());
                        _megacoPkgItemParamList.add(_pkgItemParam);
                        return _pkgItemParam;
                    }
// NetworkParamCs
                    if ("qualert".equals($ItemID) && "th".equals($eventParameterName)) {// event param 1
                        _pkgItemParam = new javax.megaco.pkg.NetworkPkg.NetworkParamCs();
                        _pkgItemParam.setItemValue(Constants.valueForString(_parmValue));
                        _pkgItemParam.setParamsValueRelation(paramRelationExpanded());
                        _megacoPkgItemParamList.add(_pkgItemParam);
                        return _pkgItemParam;
                    }
                    _pkgEventItem = new javax.megaco.pkg.NetworkPkg.NetworkQualertEvt();
                    if (_megacoPkgItemParamList.size() > 0)
                        _pkgEventItem.setMegacoPkgItemParam(_megacoPkgItemParamList.toArray(new PkgItemParam[_megacoPkgItemParamList.size()]));
                    _megacoPkgItemParamList.clear();
                    return _pkgEventItem;
                }
                if ("netfail".equals($ItemID)) { // event 5
// NetworkParamCs
                    if ("netfail".equals($ItemID) && "cs".equals($eventParameterName)) {// event param 1
                        _pkgItemParam = new javax.megaco.pkg.NetworkPkg.NetworkParamCs();
                        _pkgItemParam.setItemValue(Constants.valueForString(_parmValue));
                        _pkgItemParam.setParamsValueRelation(paramRelationExpanded());
                        _megacoPkgItemParamList.add(_pkgItemParam);
                        return _pkgItemParam;
                    }
                    _pkgEventItem = new javax.megaco.pkg.NetworkPkg.NetworkNetfailEvt();
                    if (_megacoPkgItemParamList.size() > 0)
                        _pkgEventItem.setMegacoPkgItemParam(_megacoPkgItemParamList.toArray(new PkgItemParam[_megacoPkgItemParamList.size()]));
                    _megacoPkgItemParamList.clear();
                    return _pkgEventItem;
                }
            }
// 9
            if ("al".equals($PackageName)) {
                _megacoPkg = new javax.megaco.pkg.AnalogLineSPkg.AnalogLineSPkg();
                if ("of".equals($ItemID)) { // event 5
// AnalogLineSParamStrict
                    if ("of".equals($ItemID) && "strict".equals($eventParameterName)) {// event param 1
                        _pkgItemParam = new javax.megaco.pkg.AnalogLineSPkg.AnalogLineSParamStrict();
                        _pkgItemParam.setItemValue(Constants.valueForString(_parmValue));
                        _pkgItemParam.setParamsValueRelation(paramRelationExpanded());
                        _megacoPkgItemParamList.add(_pkgItemParam);
                        return _pkgItemParam;
                    }
// AnalogLineSParamInit
                    if ("of".equals($ItemID) && "init".equals($eventParameterName)) {// event param 2
                        _pkgItemParam = new javax.megaco.pkg.AnalogLineSPkg.AnalogLineSParamInit();
                        _pkgItemParam.setItemValue(Constants.valueForString(_parmValue));
                        _pkgItemParam.setParamsValueRelation(paramRelationExpanded());
                        _megacoPkgItemParamList.add(_pkgItemParam);
                        return _pkgItemParam;
                    }
                    _pkgEventItem = new javax.megaco.pkg.AnalogLineSPkg.AnalogLineSOffEvt();
                    if (_megacoPkgItemParamList.size() > 0)
                        _pkgEventItem.setMegacoPkgItemParam(_megacoPkgItemParamList.toArray(new PkgItemParam[_megacoPkgItemParamList.size()]));
                    _megacoPkgItemParamList.clear();
                    return _pkgEventItem;
                }
                if ("on".equals($ItemID)) { // event 4
// AnalogLineSParamStrict
                    if ("on".equals($ItemID) && "strict".equals($eventParameterName)) {// event param 1
                        _pkgItemParam = new javax.megaco.pkg.AnalogLineSPkg.AnalogLineSParamStrict();
                        _pkgItemParam.setItemValue(Constants.valueForString(_parmValue));
                        _pkgItemParam.setParamsValueRelation(paramRelationExpanded());
                        _megacoPkgItemParamList.add(_pkgItemParam);
                        return _pkgItemParam;
                    }
// AnalogLineSParamInit
                    if ("on".equals($ItemID) && "init".equals($eventParameterName)) {// event param 2
                        _pkgItemParam = new javax.megaco.pkg.AnalogLineSPkg.AnalogLineSParamInit();
                        _pkgItemParam.setItemValue(Constants.valueForString(_parmValue));
                        _pkgItemParam.setParamsValueRelation(paramRelationExpanded());
                        _megacoPkgItemParamList.add(_pkgItemParam);
                        return _pkgItemParam;
                    }
                    _pkgEventItem = new javax.megaco.pkg.AnalogLineSPkg.AnalogLineSOnEvt();
                    if (_megacoPkgItemParamList.size() > 0)
                        _pkgEventItem.setMegacoPkgItemParam(_megacoPkgItemParamList.toArray(new PkgItemParam[_megacoPkgItemParamList.size()]));
                    _megacoPkgItemParamList.clear();
                    return _pkgEventItem;
                }
                if ("fl".equals($ItemID)) { // event 6
// AnalogLineSParamMindur
                    if ("fl".equals($ItemID) && "mindur".equals($eventParameterName)) {// event param 4
                        _pkgItemParam = new javax.megaco.pkg.AnalogLineSPkg.AnalogLineSParamMindur();
                        _pkgItemParam.setItemValue(Constants.valueForInteger(_parmValue));
                        _pkgItemParam.setParamsValueRelation(paramRelationExpanded());
                        _megacoPkgItemParamList.add(_pkgItemParam);
                        return _pkgItemParam;
                    }
// AnalogLineSParamMaxdur
                    if ("fl".equals($ItemID) && "maxdur".equals($eventParameterName)) {// event param 5
                        _pkgItemParam = new javax.megaco.pkg.AnalogLineSPkg.AnalogLineSParamMaxdur();
                        _pkgItemParam.setItemValue(Constants.valueForInteger(_parmValue));
                        _pkgItemParam.setParamsValueRelation(paramRelationExpanded());
                        _megacoPkgItemParamList.add(_pkgItemParam);
                        return _pkgItemParam;
                    }
                    _pkgEventItem = new javax.megaco.pkg.AnalogLineSPkg.AnalogLineSFlashEvt();
                    if (_megacoPkgItemParamList.size() > 0)
                        _pkgEventItem.setMegacoPkgItemParam(_megacoPkgItemParamList.toArray(new PkgItemParam[_megacoPkgItemParamList.size()]));
                    _megacoPkgItemParamList.clear();
                    return _pkgEventItem;
                }
                if ("ri".equals($ItemID)) { // signal 2
// AnalogLineSParamCad
                    if ("ri".equals($ItemID) && "cad".equals($eventParameterName)) {// event param 6
                        _pkgItemParam = new javax.megaco.pkg.AnalogLineSPkg.AnalogLineSParamCad();
                        _pkgItemParam.setItemValue(Constants.valueForInteger(_parmValue));
                        _pkgItemParam.setParamsValueRelation(paramRelationExpanded());
                        _megacoPkgItemParamList.add(_pkgItemParam);
                        return _pkgItemParam;
                    }
// AnalogLineSParamFreq
                    if ("ri".equals($ItemID) && "freq".equals($eventParameterName)) {// event param 7
                        _pkgItemParam = new javax.megaco.pkg.AnalogLineSPkg.AnalogLineSParamFreq();
                        _pkgItemParam.setItemValue(Constants.valueForInteger(_parmValue));
                        _pkgItemParam.setParamsValueRelation(paramRelationExpanded());
                        _megacoPkgItemParamList.add(_pkgItemParam);
                        return _pkgItemParam;
                    }
                    _pkgSignalItem = new javax.megaco.pkg.AnalogLineSPkg.AnalogLineSRingSignal();
                    if (_megacoPkgItemParamList.size() > 0)
                        _pkgSignalItem.setMegacoPkgItemParam(_megacoPkgItemParamList.toArray(new PkgItemParam[_megacoPkgItemParamList.size()]));
                    _megacoPkgItemParamList.clear();
                    return _pkgSignalItem;
                }
            }
// 3
            if ("tonegen".equals($PackageName))
                _megacoPkg = new javax.megaco.pkg.ToneGenPkg.ToneGenPkg();
            if ("tonegen".equals($PackageName) || "cg".equals($PackageName) || "dg".equals($PackageName))
                if ("pt".equals($ItemID)) { // signal 1
// ToneGenParamTl
                    if ("pt".equals($ItemID) && "tl".equals($eventParameterName)) {// event param 1
                        _pkgItemParam = new javax.megaco.pkg.ToneGenPkg.ToneGenParamTl();
                        _pkgItemParam.setItemValue(Constants.valueForString(_parmValue));
                        _pkgItemParam.setParamsValueRelation(paramRelationExpanded());
                        _megacoPkgItemParamList.add(_pkgItemParam);
                        return _pkgItemParam;
                    }
// ToneGenParamInd
                    if ("pt".equals($ItemID) && "ind".equals($eventParameterName)) {// event param 2
                        _pkgItemParam = new javax.megaco.pkg.ToneGenPkg.ToneGenParamInd();
                        _pkgItemParam.setItemValue(Constants.valueForInteger(_parmValue));
                        _pkgItemParam.setParamsValueRelation(paramRelationExpanded());
                        _megacoPkgItemParamList.add(_pkgItemParam);
                        return _pkgItemParam;
                    }
                    _pkgSignalItem = new javax.megaco.pkg.ToneGenPkg.ToneGenPlayToneSignal();
                    if (_megacoPkgItemParamList.size() > 0)
                        _pkgSignalItem.setMegacoPkgItemParam(_megacoPkgItemParamList.toArray(new PkgItemParam[_megacoPkgItemParamList.size()]));
                    _megacoPkgItemParamList.clear();
                    return _pkgSignalItem;
                }
// 4
            if ("tonedet".equals($PackageName))
                _megacoPkg = new javax.megaco.pkg.ToneDetPkg.ToneDetPkg();
            if ("tonedet".equals($PackageName) || "cd".equals($PackageName) || "dd".equals($PackageName)) {
                if ("std".equals($ItemID)) { // event 1
// ToneParamTl
                    if ("std".equals($ItemID) && "tl".equals($eventParameterName)) {// event param 1
                        _pkgItemParam = new javax.megaco.pkg.ToneDetPkg.ToneParamTl();
                        _pkgItemParam.setItemValue(Constants.valueForString(_parmValue));
                        _pkgItemParam.setParamsValueRelation(paramRelationExpanded());
                        _megacoPkgItemParamList.add(_pkgItemParam);
                        return _pkgItemParam;
                    }
// ToneParamTid
                    if ("std".equals($ItemID) && "tid".equals($eventParameterName)) {// event param 3
                        _pkgItemParam = new javax.megaco.pkg.ToneDetPkg.ToneParamTid();
                        _pkgItemParam.setItemValue(Constants.valueForString(_parmValue));
                        _pkgItemParam.setParamsValueRelation(paramRelationExpanded());
                        _megacoPkgItemParamList.add(_pkgItemParam);
                        return _pkgItemParam;
                    }
                    _pkgEventItem = new javax.megaco.pkg.ToneDetPkg.ToneStdEvent();
                    if (_megacoPkgItemParamList.size() > 0)
                        _pkgEventItem.setMegacoPkgItemParam(_megacoPkgItemParamList.toArray(new PkgItemParam[_megacoPkgItemParamList.size()]));
                    _megacoPkgItemParamList.clear();
                    return _pkgEventItem;
                }
                if ("etd".equals($ItemID)) { // event 2
// ToneParamTl
                    if ("etd".equals($ItemID) && "tl".equals($eventParameterName)) {// event param 1
                        _pkgItemParam = new javax.megaco.pkg.ToneDetPkg.ToneParamTl();
                        _pkgItemParam.setItemValue(Constants.valueForString(_parmValue));
                        _pkgItemParam.setParamsValueRelation(paramRelationExpanded());
                        _megacoPkgItemParamList.add(_pkgItemParam);
                        return _pkgItemParam;
                    }
// ToneParamTid
                    if ("etd".equals($ItemID) && "tid".equals($eventParameterName)) {// event param 3
                        _pkgItemParam = new javax.megaco.pkg.ToneDetPkg.ToneParamTid();
                        _pkgItemParam.setItemValue(Constants.valueForString(_parmValue));
                        _pkgItemParam.setParamsValueRelation(paramRelationExpanded());
                        _megacoPkgItemParamList.add(_pkgItemParam);
                        return _pkgItemParam;
                    }
// ToneParamDur
                    if ("etd".equals($ItemID) && "dur".equals($eventParameterName)) {// event param 2
                        _pkgItemParam = new javax.megaco.pkg.ToneDetPkg.ToneParamDur();
                        _pkgItemParam.setItemValue(Constants.valueForInteger(_parmValue));
                        _pkgItemParam.setParamsValueRelation(paramRelationExpanded());
                        _megacoPkgItemParamList.add(_pkgItemParam);
                        return _pkgItemParam;
                    }
                    _pkgEventItem = new javax.megaco.pkg.ToneDetPkg.ToneEtdEvent();
                    if (_megacoPkgItemParamList.size() > 0)
                        _pkgEventItem.setMegacoPkgItemParam(_megacoPkgItemParamList.toArray(new PkgItemParam[_megacoPkgItemParamList.size()]));
                    _megacoPkgItemParamList.clear();
                    return _pkgEventItem;
                }
                if ("ce".equals($ItemID)) { // event 4
// ToneParamTl
                    if ("ce".equals($ItemID) && "ds".equals($eventParameterName)) {// event param 1
                        _pkgItemParam = new javax.megaco.pkg.ToneDetPkg.ToneParamTl();
                        _pkgItemParam.setItemValue(Constants.valueForString(_parmValue));
                        _pkgItemParam.setParamsValueRelation(paramRelationExpanded());
                        _megacoPkgItemParamList.add(_pkgItemParam);
                        return _pkgItemParam;
                    }
// ToneParamTid
                    if ("ce".equals($ItemID) && "Meth".equals($eventParameterName)) {// event param 3
                        _pkgItemParam = new javax.megaco.pkg.ToneDetPkg.ToneParamTid();
                        _pkgItemParam.setItemValue(Constants.valueForString(_parmValue));
                        _pkgItemParam.setParamsValueRelation(paramRelationExpanded());
                        _megacoPkgItemParamList.add(_pkgItemParam);
                        return _pkgItemParam;
                    }
                    _pkgEventItem = new javax.megaco.pkg.ToneDetPkg.ToneLtdEvent();
                    if (_megacoPkgItemParamList.size() > 0)
                        _pkgEventItem.setMegacoPkgItemParam(_megacoPkgItemParamList.toArray(new PkgItemParam[_megacoPkgItemParamList.size()]));
                    _megacoPkgItemParamList.clear();
                    return _pkgEventItem;
                }
            }
// 10
            if ("ct".equals($PackageName)) {
                _megacoPkg = new javax.megaco.pkg.ContinuityPkg.ContinuityPkg();
                if ("cmp".equals($ItemID)) { // event 5
// ContParamRes
                    if ("cmp".equals($ItemID) && "res".equals($eventParameterName)) {// event param 8
                        _pkgItemParam = new javax.megaco.pkg.ContinuityPkg.ContParamRes();
                        _pkgItemParam.setItemValue(Constants.valueForString(_parmValue));
                        _pkgItemParam.setParamsValueRelation(paramRelationExpanded());
                        _megacoPkgItemParamList.add(_pkgItemParam);
                        return _pkgItemParam;
                    }
                    _pkgEventItem = new javax.megaco.pkg.ContinuityPkg.ContComplEvt();
                    if (_megacoPkgItemParamList.size() > 0)
                        _pkgEventItem.setMegacoPkgItemParam(_megacoPkgItemParamList.toArray(new PkgItemParam[_megacoPkgItemParamList.size()]));
                    _megacoPkgItemParamList.clear();
                    return _pkgEventItem;
                }
                if ("rsp".equals($ItemID)) { // signal 4
                    _pkgSignalItem = new javax.megaco.pkg.ContinuityPkg.ContRspSignal();
                    if (_megacoPkgItemParamList.size() > 0)
                        _pkgSignalItem.setMegacoPkgItemParam(_megacoPkgItemParamList.toArray(new PkgItemParam[_megacoPkgItemParamList.size()]));
                    _megacoPkgItemParamList.clear();
                    return _pkgSignalItem;
                }
                if ("ct".equals($ItemID)) { // signal 3
                    _pkgSignalItem = new javax.megaco.pkg.ContinuityPkg.ContCtSignal();
                    if (_megacoPkgItemParamList.size() > 0)
                        _pkgSignalItem.setMegacoPkgItemParam(_megacoPkgItemParamList.toArray(new PkgItemParam[_megacoPkgItemParamList.size()]));
                    _megacoPkgItemParamList.clear();
                    return _pkgSignalItem;
                }
            }
// 12
            if ("rtp".equals($PackageName)) {
                _megacoPkg = new javax.megaco.pkg.RTPPkg.RTPPkg();
                if ("pl".equals($ItemID)) { // stats 6
                    _pkgStatsItem = new javax.megaco.pkg.RTPPkg.RTPPlStats();
                    _pkgStatsItem.setItemValue(Constants.valueForDouble(_stringValue));
                    _pkgStatsItem.setItemsValueRelation(paramRelationExpanded());
                    return _pkgStatsItem;
                }
                if ("delay".equals($ItemID)) { // stats 8
                    _pkgStatsItem = new javax.megaco.pkg.RTPPkg.RTPDelayStats();
                    _pkgStatsItem.setItemValue(Constants.valueForInteger(_stringValue));
                    _pkgStatsItem.setItemsValueRelation(paramRelationExpanded());
                    return _pkgStatsItem;
                }
                if ("pr".equals($ItemID)) { // stats 5
                    _pkgStatsItem = new javax.megaco.pkg.RTPPkg.RTPPrStats();
                    _pkgStatsItem.setItemValue(Constants.valueForDouble(_stringValue));
                    _pkgStatsItem.setItemsValueRelation(paramRelationExpanded());
                    return _pkgStatsItem;
                }
                if ("ps".equals($ItemID)) { // stats 4
                    _pkgStatsItem = new javax.megaco.pkg.RTPPkg.RTPPsStats();
                    _pkgStatsItem.setItemValue(Constants.valueForDouble(_stringValue));
                    _pkgStatsItem.setItemsValueRelation(paramRelationExpanded());
                    return _pkgStatsItem;
                }
                if ("jit".equals($ItemID)) { // stats 7
                    _pkgStatsItem = new javax.megaco.pkg.RTPPkg.RTPJitStats();
                    _pkgStatsItem.setItemValue(Constants.valueForInteger(_stringValue));
                    _pkgStatsItem.setItemsValueRelation(paramRelationExpanded());
                    return _pkgStatsItem;
                }
                if ("pltrans".equals($ItemID)) { // event 1
// RTPParamRtppltype
                    if ("pltrans".equals($ItemID) && "rtppltype".equals($eventParameterName)) {// event param 1
                        _pkgItemParam = new javax.megaco.pkg.RTPPkg.RTPParamRtppltype();
                        _pkgItemParam.setItemValue(Constants.valueForString(_parmValue));
                        _pkgItemParam.setParamsValueRelation(paramRelationExpanded());
                        _megacoPkgItemParamList.add(_pkgItemParam);
                        return _pkgItemParam;
                    }
                    _pkgEventItem = new javax.megaco.pkg.RTPPkg.RTPPltransEvt();
                    if (_megacoPkgItemParamList.size() > 0)
                        _pkgEventItem.setMegacoPkgItemParam(_megacoPkgItemParamList.toArray(new PkgItemParam[_megacoPkgItemParamList.size()]));
                    _megacoPkgItemParamList.clear();
                    return _pkgEventItem;
                }
            }
// 1
            if ("g".equals($PackageName)) {
                _megacoPkg = new javax.megaco.pkg.GenericPkg.GenericPkg();
                if ("sc".equals($ItemID)) { // event 2
// GenParamGenCause
                    if ("sc".equals($ItemID) && "SigID".equals($eventParameterName)) {// event param 1
                        _pkgItemParam = new javax.megaco.pkg.GenericPkg.GenParamGenCause();
                        _pkgItemParam.setItemValue(Constants.valueForString(_parmValue));
                        _pkgItemParam.setParamsValueRelation(paramRelationExpanded());
                        _megacoPkgItemParamList.add(_pkgItemParam);
                        return _pkgItemParam;
                    }
// GenParamTermMeth
                    if ("sc".equals($ItemID) && "Meth".equals($eventParameterName)) {// event param 2
                        _pkgItemParam = new javax.megaco.pkg.GenericPkg.GenParamTermMeth();
                        _pkgItemParam.setItemValue(Constants.valueForString(_parmValue));
                        _pkgItemParam.setParamsValueRelation(paramRelationExpanded());
                        _megacoPkgItemParamList.add(_pkgItemParam);
                        return _pkgItemParam;
                    }
// GenParamSLID
                    if ("sc".equals($ItemID) && "SLID".equals($eventParameterName)) {// event param 3
                        _pkgItemParam = new javax.megaco.pkg.GenericPkg.GenParamSLID();
                        _pkgItemParam.setItemValue(Constants.valueForString(_parmValue));
                        _pkgItemParam.setParamsValueRelation(paramRelationExpanded());
                        _megacoPkgItemParamList.add(_pkgItemParam);
                        return _pkgItemParam;
                    }
                    _pkgEventItem = new javax.megaco.pkg.GenericPkg.GenSigComplEvent();
                    if (_megacoPkgItemParamList.size() > 0)
                        _pkgEventItem.setMegacoPkgItemParam(_megacoPkgItemParamList.toArray(new PkgItemParam[_megacoPkgItemParamList.size()]));
                    _megacoPkgItemParamList.clear();
                    return _pkgEventItem;
                }
                if ("cause".equals($ItemID)) { // event 1
// GenParamGenCause
                    if ("cause".equals($ItemID) && "Generalcause".equals($eventParameterName)) {// event param 1
                        _pkgItemParam = new javax.megaco.pkg.GenericPkg.GenParamGenCause();
                        _pkgItemParam.setItemValue(Constants.valueForString(_parmValue));
                        _pkgItemParam.setParamsValueRelation(paramRelationExpanded());
                        _megacoPkgItemParamList.add(_pkgItemParam);
                        return _pkgItemParam;
                    }
// GenParamTermMeth
                    if ("cause".equals($ItemID) && "Failurecause".equals($eventParameterName)) {// event param 2
                        _pkgItemParam = new javax.megaco.pkg.GenericPkg.GenParamTermMeth();
                        _pkgItemParam.setItemValue(Constants.valueForString(_parmValue));
                        _pkgItemParam.setParamsValueRelation(paramRelationExpanded());
                        _megacoPkgItemParamList.add(_pkgItemParam);
                        return _pkgItemParam;
                    }
                    _pkgEventItem = new javax.megaco.pkg.GenericPkg.GenCauseEvent();
                    if (_megacoPkgItemParamList.size() > 0)
                        _pkgEventItem.setMegacoPkgItemParam(_megacoPkgItemParamList.toArray(new PkgItemParam[_megacoPkgItemParamList.size()]));
                    _megacoPkgItemParamList.clear();
                    return _pkgEventItem;
                }
            }
// 28
            if ("dtd".equals($PackageName)) {
                _megacoPkg = new javax.megaco.pkg.ext.DynamicToneDefinitionPkg.DynamicToneDefinitionPkg();
                if ("tid".equals($ItemID)) {// prpt 1
                    _pkgPrptyItem = new javax.megaco.pkg.ext.DynamicToneDefinitionPkg.ToneIDPrpt();
                    _pkgPrptyItem.setItemValue(Constants.valueForUnknown(_parmValue));
                    _pkgPrptyItem.setItemsValueRelation(paramRelationExpanded());
                    _megacoPkgPrptyItemList.add(_pkgPrptyItem);
                    return _pkgPrptyItem;
                }
                if ("tst".equals($ItemID)) {// prpt 2
                    _pkgPrptyItem = new javax.megaco.pkg.ext.DynamicToneDefinitionPkg.ToneStringPrpt();
                    _pkgPrptyItem.setItemValue(Constants.valueForUnknown(_parmValue));
                    _pkgPrptyItem.setItemsValueRelation(paramRelationExpanded());
                    _megacoPkgPrptyItemList.add(_pkgPrptyItem);
                    return _pkgPrptyItem;
                }
            }
// 29
            if ("an".equals($PackageName)) {
                _megacoPkg = new javax.megaco.pkg.ext.GenericAnnouncementPkg.GenericAnnouncementPkg();
                if ("apf".equals($ItemID)) { // signal 1
// AnnouncementNameParam
                    if ("apf".equals($ItemID) && "an".equals($eventParameterName)) {// event param 1
                        _pkgItemParam = new javax.megaco.pkg.ext.GenericAnnouncementPkg.AnnouncementNameParam();
                        _pkgItemParam.setItemValue(Constants.valueForString(_parmValue));
                        _pkgItemParam.setParamsValueRelation(paramRelationExpanded());
                        _megacoPkgItemParamList.add(_pkgItemParam);
                        return _pkgItemParam;
                    }
// NumberOfCyclesParam
                    if ("apf".equals($ItemID) && "noc".equals($eventParameterName)) {// event param 2
                        _pkgItemParam = new javax.megaco.pkg.ext.GenericAnnouncementPkg.NumberOfCyclesParam();
                        _pkgItemParam.setItemValue(Constants.valueForInteger(_parmValue));
                        _pkgItemParam.setParamsValueRelation(paramRelationExpanded());
                        _megacoPkgItemParamList.add(_pkgItemParam);
                        return _pkgItemParam;
                    }
// AnnouncementVariantParam
                    if ("apf".equals($ItemID) && "av".equals($eventParameterName)) {// event param 3
                        _pkgItemParam = new javax.megaco.pkg.ext.GenericAnnouncementPkg.AnnouncementVariantParam();
                        _pkgItemParam.setItemValue(Constants.valueForString(_parmValue));
                        _pkgItemParam.setParamsValueRelation(paramRelationExpanded());
                        _megacoPkgItemParamList.add(_pkgItemParam);
                        return _pkgItemParam;
                    }
// NumberParam
                    if ("apf".equals($ItemID) && "di".equals($eventParameterName)) {// event param 4
                        _pkgItemParam = new javax.megaco.pkg.ext.GenericAnnouncementPkg.NumberParam();
                        _pkgItemParam.setItemValue(Constants.valueForInteger(_parmValue));
                        _pkgItemParam.setParamsValueRelation(paramRelationExpanded());
                        _megacoPkgItemParamList.add(_pkgItemParam);
                        return _pkgItemParam;
                    }
                    _pkgSignalItem = new javax.megaco.pkg.ext.GenericAnnouncementPkg.FixedAnnouncementPlaySig();
                    if (_megacoPkgItemParamList.size() > 0)
                        _pkgSignalItem.setMegacoPkgItemParam(_megacoPkgItemParamList.toArray(new PkgItemParam[_megacoPkgItemParamList.size()]));
                    _megacoPkgItemParamList.clear();
                    return _pkgSignalItem;
                }
                if ("apv".equals($ItemID)) { // signal 2
// AnnouncementNameParam
                    if ("apv".equals($ItemID) && "an".equals($eventParameterName)) {// event param 1
                        _pkgItemParam = new javax.megaco.pkg.ext.GenericAnnouncementPkg.AnnouncementNameParam();
                        _pkgItemParam.setItemValue(Constants.valueForString(_parmValue));
                        _pkgItemParam.setParamsValueRelation(paramRelationExpanded());
                        _megacoPkgItemParamList.add(_pkgItemParam);
                        return _pkgItemParam;
                    }
// AnnouncementVariantParam
                    if ("apv".equals($ItemID) && "av".equals($eventParameterName)) {// event param 3
                        _pkgItemParam = new javax.megaco.pkg.ext.GenericAnnouncementPkg.AnnouncementVariantParam();
                        _pkgItemParam.setItemValue(Constants.valueForString(_parmValue));
                        _pkgItemParam.setParamsValueRelation(paramRelationExpanded());
                        _megacoPkgItemParamList.add(_pkgItemParam);
                        return _pkgItemParam;
                    }
// AnnouncementDirectionParam
                    if ("apv".equals($ItemID) && "di".equals($eventParameterName)) {// event param 7
                        _pkgItemParam = new javax.megaco.pkg.ext.GenericAnnouncementPkg.AnnouncementDirectionParam();
                        _pkgItemParam.setItemValue(Constants.valueForInteger(_parmValue));
                        _pkgItemParam.setParamsValueRelation(paramRelationExpanded());
                        _megacoPkgItemParamList.add(_pkgItemParam);
                        return _pkgItemParam;
                    }
// NumberOfCyclesParam
                    if ("apv".equals($ItemID) && "noc".equals($eventParameterName)) {// event param 2
                        _pkgItemParam = new javax.megaco.pkg.ext.GenericAnnouncementPkg.NumberOfCyclesParam();
                        _pkgItemParam.setItemValue(Constants.valueForInteger(_parmValue));
                        _pkgItemParam.setParamsValueRelation(paramRelationExpanded());
                        _megacoPkgItemParamList.add(_pkgItemParam);
                        return _pkgItemParam;
                    }
// NumberParam
                    if ("apv".equals($ItemID) && "num".equals($eventParameterName)) {// event param 4
                        _pkgItemParam = new javax.megaco.pkg.ext.GenericAnnouncementPkg.NumberParam();
                        _pkgItemParam.setItemValue(Constants.valueForInteger(_parmValue));
                        _pkgItemParam.setParamsValueRelation(paramRelationExpanded());
                        _megacoPkgItemParamList.add(_pkgItemParam);
                        return _pkgItemParam;
                    }
// SpecificsInterpretationParam
                    if ("apv".equals($ItemID) && "spi".equals($eventParameterName)) {// event param 5
                        _pkgItemParam = new javax.megaco.pkg.ext.GenericAnnouncementPkg.SpecificsInterpretationParam();
                        _pkgItemParam.setItemValue(Constants.valueForString(_parmValue));
                        _pkgItemParam.setParamsValueRelation(paramRelationExpanded());
                        _megacoPkgItemParamList.add(_pkgItemParam);
                        return _pkgItemParam;
                    }
// SpecificsParam
                    if ("apv".equals($ItemID) && "sp".equals($eventParameterName)) {// event param 6
                        _pkgItemParam = new javax.megaco.pkg.ext.GenericAnnouncementPkg.SpecificsParam();
                        _pkgItemParam.setItemValue(Constants.valueForString(_parmValue));
                        _pkgItemParam.setParamsValueRelation(paramRelationExpanded());
                        _megacoPkgItemParamList.add(_pkgItemParam);
                        return _pkgItemParam;
                    }
                    _pkgSignalItem = new javax.megaco.pkg.ext.GenericAnnouncementPkg.VariableAnnouncementPlaySig();
                    if (_megacoPkgItemParamList.size() > 0)
                        _pkgSignalItem.setMegacoPkgItemParam(_megacoPkgItemParamList.toArray(new PkgItemParam[_megacoPkgItemParamList.size()]));
                    _megacoPkgItemParamList.clear();
                    return _pkgSignalItem;
                }
            }
// 71
            if ("bannsyx".equals($PackageName))
                _megacoPkg = new javax.megaco.pkg.ext.BasicAnnouncementSyntaxPkg.BasicAnnouncementSyntaxPkg();
// 72
            if ("vvsyx".equals($PackageName))
                _megacoPkg = new javax.megaco.pkg.ext.VoiceVariableSyntaxPkg.VoiceVariableSyntaxPkg();
// 73
            if ("setsyx".equals($PackageName))
                _megacoPkg = new javax.megaco.pkg.ext.AnnouncementSetSyntaxPkg.AnnouncementSetSyntaxPkg();
// 74
            if ("phrsyx".equals($PackageName))
                _megacoPkg = new javax.megaco.pkg.ext.PhraseVariableSyntaxPkg.PhraseVariableSyntaxPkg();
// 51
            if ("aasb".equals($PackageName))
                _megacoPkg = new javax.megaco.pkg.ext.AdvancedAudioServerBasePkg.AdvancedAudioServerBasePkg();
            if ("aasb".equals($PackageName) || "aasdc".equals($PackageName) || "aasrec".equals($PackageName) || "mpp".equals($PackageName)) {
                if ("audfail".equals($ItemID)) { // event 1
// ReturnCodeParam
                    if ("audfail".equals($ItemID) && "rc".equals($eventParameterName)) {// event param 1
                        _pkgItemParam = new javax.megaco.pkg.ext.AdvancedAudioServerBasePkg.ReturnCodeParam();
                        _pkgItemParam.setItemValue(Constants.valueForInteger(_parmValue));
                        _pkgItemParam.setParamsValueRelation(paramRelationExpanded());
                        _megacoPkgItemParamList.add(_pkgItemParam);
                        return _pkgItemParam;
                    }
                    _pkgEventItem = new javax.megaco.pkg.ext.AdvancedAudioServerBasePkg.AudioOperationFailureEvt();
                    if (_megacoPkgItemParamList.size() > 0)
                        _pkgEventItem.setMegacoPkgItemParam(_megacoPkgItemParamList.toArray(new PkgItemParam[_megacoPkgItemParamList.size()]));
                    _megacoPkgItemParamList.clear();
                    return _pkgEventItem;
                }
                if ("playcom".equals($ItemID)) { // event 18
// ReturnCodeParam
                    if ("playcom".equals($ItemID) && "ap".equals($eventParameterName)) {// event param 1
                        _pkgItemParam = new javax.megaco.pkg.ext.AdvancedAudioServerBasePkg.ReturnCodeParam();
                        _pkgItemParam.setItemValue(Constants.valueForInteger(_parmValue));
                        _pkgItemParam.setParamsValueRelation(paramRelationExpanded());
                        _megacoPkgItemParamList.add(_pkgItemParam);
                        return _pkgItemParam;
                    }
// IterationsParam
                    if ("playcom".equals($ItemID) && "off".equals($eventParameterName)) {// event param 2
                        _pkgItemParam = new javax.megaco.pkg.ext.AdvancedAudioServerBasePkg.IterationsParam();
                        _pkgItemParam.setItemValue(Constants.valueForInteger(_parmValue));
                        _pkgItemParam.setParamsValueRelation(paramRelationExpanded());
                        _megacoPkgItemParamList.add(_pkgItemParam);
                        return _pkgItemParam;
                    }
                    _pkgEventItem = new javax.megaco.pkg.ext.AdvancedAudioServerBasePkg.PlayoutCompletionEvt();
                    if (_megacoPkgItemParamList.size() > 0)
                        _pkgEventItem.setMegacoPkgItemParam(_megacoPkgItemParamList.toArray(new PkgItemParam[_megacoPkgItemParamList.size()]));
                    _megacoPkgItemParamList.clear();
                    return _pkgEventItem;
                }
                if ("play".equals($ItemID)) { // signal 1
// ReturnCodeParam
                    if ("play".equals($ItemID) && "rc".equals($eventParameterName)) {// event param 1
                        _pkgItemParam = new javax.megaco.pkg.ext.AdvancedAudioServerBasePkg.ReturnCodeParam();
                        _pkgItemParam.setItemValue(Constants.valueForInteger(_parmValue));
                        _pkgItemParam.setParamsValueRelation(paramRelationExpanded());
                        _megacoPkgItemParamList.add(_pkgItemParam);
                        return _pkgItemParam;
                    }
                    _pkgSignalItem = new javax.megaco.pkg.ext.AdvancedAudioServerBasePkg.PlaySig();
                    if (_megacoPkgItemParamList.size() > 0)
                        _pkgSignalItem.setMegacoPkgItemParam(_megacoPkgItemParamList.toArray(new PkgItemParam[_megacoPkgItemParamList.size()]));
                    _megacoPkgItemParamList.clear();
                    return _pkgSignalItem;
                }
            }
// 52
            if ("aasdc".equals($PackageName)) {
                _megacoPkg = new javax.megaco.pkg.ext.AASDigitCollectionPkg.AASDigitCollectionPkg();
                if ("audfail".equals($ItemID)) { // event 1
                    _pkgEventItem = new javax.megaco.pkg.ext.AASDigitCollectionPkg.AudioOperationFailureEvt();
                    if (_megacoPkgItemParamList.size() > 0)
                        _pkgEventItem.setMegacoPkgItemParam(_megacoPkgItemParamList.toArray(new PkgItemParam[_megacoPkgItemParamList.size()]));
                    _megacoPkgItemParamList.clear();
                    return _pkgEventItem;
                }
                if ("pcolsucc".equals($ItemID)) { // event 2
// DigitsCollectedParam
                    if ("pcolsucc".equals($ItemID) && "dc".equals($eventParameterName)) {// event param 1
                        _pkgItemParam = new javax.megaco.pkg.ext.AASDigitCollectionPkg.DigitsCollectedParam();
                        _pkgItemParam.setItemValue(Constants.valueForString(_parmValue));
                        _pkgItemParam.setParamsValueRelation(paramRelationExpanded());
                        _megacoPkgItemParamList.add(_pkgItemParam);
                        return _pkgItemParam;
                    }
// NumberOfAttemptsParam
                    if ("pcolsucc".equals($ItemID) && "na".equals($eventParameterName)) {// event param 2
                        _pkgItemParam = new javax.megaco.pkg.ext.AASDigitCollectionPkg.NumberOfAttemptsParam();
                        _pkgItemParam.setItemValue(Constants.valueForInteger(_parmValue));
                        _pkgItemParam.setParamsValueRelation(paramRelationExpanded());
                        _megacoPkgItemParamList.add(_pkgItemParam);
                        return _pkgItemParam;
                    }
// AmountPlayedParam
                    if ("pcolsucc".equals($ItemID) && "ap".equals($eventParameterName)) {// event param 3
                        _pkgItemParam = new javax.megaco.pkg.ext.AASDigitCollectionPkg.AmountPlayedParam();
                        _pkgItemParam.setItemValue(Constants.valueForInteger(_parmValue));
                        _pkgItemParam.setParamsValueRelation(paramRelationExpanded());
                        _megacoPkgItemParamList.add(_pkgItemParam);
                        return _pkgItemParam;
                    }
// ControlDigitsCollectedParam
                    if ("pcolsucc".equals($ItemID) && "contdc".equals($eventParameterName)) {// event param 4
                        _pkgItemParam = new javax.megaco.pkg.ext.AASDigitCollectionPkg.ControlDigitsCollectedParam();
                        _pkgItemParam.setItemValue(Constants.valueForString(_parmValue));
                        _pkgItemParam.setParamsValueRelation(paramRelationExpanded());
                        _megacoPkgItemParamList.add(_pkgItemParam);
                        return _pkgItemParam;
                    }
                    _pkgEventItem = new javax.megaco.pkg.ext.AASDigitCollectionPkg.PlayCollectSuccessEvt();
                    if (_megacoPkgItemParamList.size() > 0)
                        _pkgEventItem.setMegacoPkgItemParam(_megacoPkgItemParamList.toArray(new PkgItemParam[_megacoPkgItemParamList.size()]));
                    _megacoPkgItemParamList.clear();
                    return _pkgEventItem;
                }
                if ("playcol".equals($ItemID)) { // signal 2
// DigitsCollectedParam
                    if ("playcol".equals($ItemID) && "dc".equals($eventParameterName)) {// event param 1
                        _pkgItemParam = new javax.megaco.pkg.ext.AASDigitCollectionPkg.DigitsCollectedParam();
                        _pkgItemParam.setItemValue(Constants.valueForString(_parmValue));
                        _pkgItemParam.setParamsValueRelation(paramRelationExpanded());
                        _megacoPkgItemParamList.add(_pkgItemParam);
                        return _pkgItemParam;
                    }
// NumberOfAttemptsParam
                    if ("playcol".equals($ItemID) && "na".equals($eventParameterName)) {// event param 2
                        _pkgItemParam = new javax.megaco.pkg.ext.AASDigitCollectionPkg.NumberOfAttemptsParam();
                        _pkgItemParam.setItemValue(Constants.valueForInteger(_parmValue));
                        _pkgItemParam.setParamsValueRelation(paramRelationExpanded());
                        _megacoPkgItemParamList.add(_pkgItemParam);
                        return _pkgItemParam;
                    }
// AmountPlayedParam
                    if ("playcol".equals($ItemID) && "ap".equals($eventParameterName)) {// event param 3
                        _pkgItemParam = new javax.megaco.pkg.ext.AASDigitCollectionPkg.AmountPlayedParam();
                        _pkgItemParam.setItemValue(Constants.valueForInteger(_parmValue));
                        _pkgItemParam.setParamsValueRelation(paramRelationExpanded());
                        _megacoPkgItemParamList.add(_pkgItemParam);
                        return _pkgItemParam;
                    }
// ControlDigitsCollectedParam
                    if ("playcol".equals($ItemID) && "contdc".equals($eventParameterName)) {// event param 4
                        _pkgItemParam = new javax.megaco.pkg.ext.AASDigitCollectionPkg.ControlDigitsCollectedParam();
                        _pkgItemParam.setItemValue(Constants.valueForString(_parmValue));
                        _pkgItemParam.setParamsValueRelation(paramRelationExpanded());
                        _megacoPkgItemParamList.add(_pkgItemParam);
                        return _pkgItemParam;
                    }
                    _pkgSignalItem = new javax.megaco.pkg.ext.AASDigitCollectionPkg.PlayCollectSig();
                    if (_megacoPkgItemParamList.size() > 0)
                        _pkgSignalItem.setMegacoPkgItemParam(_megacoPkgItemParamList.toArray(new PkgItemParam[_megacoPkgItemParamList.size()]));
                    _megacoPkgItemParamList.clear();
                    return _pkgSignalItem;
                }
            }
// 53
            if ("aasrec".equals($PackageName))
                _megacoPkg = new javax.megaco.pkg.ext.AASRecordingPkg.AASRecordingPkg();
            if ("aasrec".equals($PackageName) || "mrp".equals($PackageName)) {
                if ("maxtrl".equals($ItemID)) {// prpt 3
                    _pkgPrptyItem = new javax.megaco.pkg.ext.AASRecordingPkg.MaximumTemporaryRecordLifePrpt();
                    _pkgPrptyItem.setItemValue(Constants.valueForUnknown(_parmValue));
                    _pkgPrptyItem.setItemsValueRelation(paramRelationExpanded());
                    _megacoPkgPrptyItemList.add(_pkgPrptyItem);
                    return _pkgPrptyItem;
                }
                if ("audfail".equals($ItemID)) { // event 1
                    _pkgEventItem = new javax.megaco.pkg.ext.AASRecordingPkg.AudioOperationFailureEvt();
                    if (_megacoPkgItemParamList.size() > 0)
                        _pkgEventItem.setMegacoPkgItemParam(_megacoPkgItemParamList.toArray(new PkgItemParam[_megacoPkgItemParamList.size()]));
                    _megacoPkgItemParamList.clear();
                    return _pkgEventItem;
                }
                if ("precsucc".equals($ItemID)) { // event 2
// AmountPlayedParam
                    if ("precsucc".equals($ItemID) && "ap".equals($eventParameterName)) {// event param 1
                        _pkgItemParam = new javax.megaco.pkg.ext.AASRecordingPkg.AmountPlayedParam();
                        _pkgItemParam.setItemValue(Constants.valueForInteger(_parmValue));
                        _pkgItemParam.setParamsValueRelation(paramRelationExpanded());
                        _megacoPkgItemParamList.add(_pkgItemParam);
                        return _pkgItemParam;
                    }
// NumberOfAttemptsParam
                    if ("precsucc".equals($ItemID) && "na".equals($eventParameterName)) {// event param 2
                        _pkgItemParam = new javax.megaco.pkg.ext.AASRecordingPkg.NumberOfAttemptsParam();
                        _pkgItemParam.setItemValue(Constants.valueForInteger(_parmValue));
                        _pkgItemParam.setParamsValueRelation(paramRelationExpanded());
                        _megacoPkgItemParamList.add(_pkgItemParam);
                        return _pkgItemParam;
                    }
// RecordingResultParam
                    if ("precsucc".equals($ItemID) && "res".equals($eventParameterName)) {// event param 3
                        _pkgItemParam = new javax.megaco.pkg.ext.AASRecordingPkg.RecordingResultParam();
                        _pkgItemParam.setItemValue(Constants.valueForString(_parmValue));
                        _pkgItemParam.setParamsValueRelation(paramRelationExpanded());
                        _megacoPkgItemParamList.add(_pkgItemParam);
                        return _pkgItemParam;
                    }
// RecordingIdParam
                    if ("precsucc".equals($ItemID) && "ri".equals($eventParameterName)) {// event param 4
                        _pkgItemParam = new javax.megaco.pkg.ext.AASRecordingPkg.RecordingIdParam();
                        _pkgItemParam.setItemValue(Constants.valueForString(_parmValue));
                        _pkgItemParam.setParamsValueRelation(paramRelationExpanded());
                        _megacoPkgItemParamList.add(_pkgItemParam);
                        return _pkgItemParam;
                    }
// RecordDurationParam
                    if ("precsucc".equals($ItemID) && "rdur".equals($eventParameterName)) {// event param 5
                        _pkgItemParam = new javax.megaco.pkg.ext.AASRecordingPkg.RecordDurationParam();
                        _pkgItemParam.setItemValue(Constants.valueForInteger(_parmValue));
                        _pkgItemParam.setParamsValueRelation(paramRelationExpanded());
                        _megacoPkgItemParamList.add(_pkgItemParam);
                        return _pkgItemParam;
                    }
// EndKeyParam
                    if ("precsucc".equals($ItemID) && "ek".equals($eventParameterName)) {// event param 6
                        _pkgItemParam = new javax.megaco.pkg.ext.AASRecordingPkg.EndKeyParam();
                        _pkgItemParam.setItemValue(Constants.valueForString(_parmValue));
                        _pkgItemParam.setParamsValueRelation(paramRelationExpanded());
                        _megacoPkgItemParamList.add(_pkgItemParam);
                        return _pkgItemParam;
                    }
// RecordingLengthParam
                    if ("precsucc".equals($ItemID) && "reclen".equals($eventParameterName)) {// event param 7
                        _pkgItemParam = new javax.megaco.pkg.ext.AASRecordingPkg.RecordingLengthParam();
                        _pkgItemParam.setItemValue(Constants.valueForInteger(_parmValue));
                        _pkgItemParam.setParamsValueRelation(paramRelationExpanded());
                        _megacoPkgItemParamList.add(_pkgItemParam);
                        return _pkgItemParam;
                    }
// ControlDigitsCollectedParam
                    if ("precsucc".equals($ItemID) && "contdc".equals($eventParameterName)) {// event param 8
                        _pkgItemParam = new javax.megaco.pkg.ext.AASRecordingPkg.ControlDigitsCollectedParam();
                        _pkgItemParam.setItemValue(Constants.valueForString(_parmValue));
                        _pkgItemParam.setParamsValueRelation(paramRelationExpanded());
                        _megacoPkgItemParamList.add(_pkgItemParam);
                        return _pkgItemParam;
                    }
                    _pkgEventItem = new javax.megaco.pkg.ext.AASRecordingPkg.PlayRecordSuccessEvt();
                    if (_megacoPkgItemParamList.size() > 0)
                        _pkgEventItem.setMegacoPkgItemParam(_megacoPkgItemParamList.toArray(new PkgItemParam[_megacoPkgItemParamList.size()]));
                    _megacoPkgItemParamList.clear();
                    return _pkgEventItem;
                }
                if ("playrec".equals($ItemID)) { // signal 2
// AmountPlayedParam
                    if ("playrec".equals($ItemID) && "ap".equals($eventParameterName)) {// event param 1
                        _pkgItemParam = new javax.megaco.pkg.ext.AASRecordingPkg.AmountPlayedParam();
                        _pkgItemParam.setItemValue(Constants.valueForInteger(_parmValue));
                        _pkgItemParam.setParamsValueRelation(paramRelationExpanded());
                        _megacoPkgItemParamList.add(_pkgItemParam);
                        return _pkgItemParam;
                    }
// NumberOfAttemptsParam
                    if ("playrec".equals($ItemID) && "na".equals($eventParameterName)) {// event param 2
                        _pkgItemParam = new javax.megaco.pkg.ext.AASRecordingPkg.NumberOfAttemptsParam();
                        _pkgItemParam.setItemValue(Constants.valueForInteger(_parmValue));
                        _pkgItemParam.setParamsValueRelation(paramRelationExpanded());
                        _megacoPkgItemParamList.add(_pkgItemParam);
                        return _pkgItemParam;
                    }
// RecordingResultParam
                    if ("playrec".equals($ItemID) && "res".equals($eventParameterName)) {// event param 3
                        _pkgItemParam = new javax.megaco.pkg.ext.AASRecordingPkg.RecordingResultParam();
                        _pkgItemParam.setItemValue(Constants.valueForString(_parmValue));
                        _pkgItemParam.setParamsValueRelation(paramRelationExpanded());
                        _megacoPkgItemParamList.add(_pkgItemParam);
                        return _pkgItemParam;
                    }
// RecordingIdParam
                    if ("playrec".equals($ItemID) && "ri".equals($eventParameterName)) {// event param 4
                        _pkgItemParam = new javax.megaco.pkg.ext.AASRecordingPkg.RecordingIdParam();
                        _pkgItemParam.setItemValue(Constants.valueForString(_parmValue));
                        _pkgItemParam.setParamsValueRelation(paramRelationExpanded());
                        _megacoPkgItemParamList.add(_pkgItemParam);
                        return _pkgItemParam;
                    }
// RecordDurationParam
                    if ("playrec".equals($ItemID) && "rdur".equals($eventParameterName)) {// event param 5
                        _pkgItemParam = new javax.megaco.pkg.ext.AASRecordingPkg.RecordDurationParam();
                        _pkgItemParam.setItemValue(Constants.valueForInteger(_parmValue));
                        _pkgItemParam.setParamsValueRelation(paramRelationExpanded());
                        _megacoPkgItemParamList.add(_pkgItemParam);
                        return _pkgItemParam;
                    }
// EndKeyParam
                    if ("playrec".equals($ItemID) && "ek".equals($eventParameterName)) {// event param 6
                        _pkgItemParam = new javax.megaco.pkg.ext.AASRecordingPkg.EndKeyParam();
                        _pkgItemParam.setItemValue(Constants.valueForString(_parmValue));
                        _pkgItemParam.setParamsValueRelation(paramRelationExpanded());
                        _megacoPkgItemParamList.add(_pkgItemParam);
                        return _pkgItemParam;
                    }
// RecordingLengthParam
                    if ("playrec".equals($ItemID) && "reclen".equals($eventParameterName)) {// event param 7
                        _pkgItemParam = new javax.megaco.pkg.ext.AASRecordingPkg.RecordingLengthParam();
                        _pkgItemParam.setItemValue(Constants.valueForInteger(_parmValue));
                        _pkgItemParam.setParamsValueRelation(paramRelationExpanded());
                        _megacoPkgItemParamList.add(_pkgItemParam);
                        return _pkgItemParam;
                    }
// ControlDigitsCollectedParam
                    if ("playrec".equals($ItemID) && "contdc".equals($eventParameterName)) {// event param 8
                        _pkgItemParam = new javax.megaco.pkg.ext.AASRecordingPkg.ControlDigitsCollectedParam();
                        _pkgItemParam.setItemValue(Constants.valueForString(_parmValue));
                        _pkgItemParam.setParamsValueRelation(paramRelationExpanded());
                        _megacoPkgItemParamList.add(_pkgItemParam);
                        return _pkgItemParam;
                    }
                    _pkgSignalItem = new javax.megaco.pkg.ext.AASRecordingPkg.PlayRecordSig();
                    if (_megacoPkgItemParamList.size() > 0)
                        _pkgSignalItem.setMegacoPkgItemParam(_megacoPkgItemParamList.toArray(new PkgItemParam[_megacoPkgItemParamList.size()]));
                    _megacoPkgItemParamList.clear();
                    return _pkgSignalItem;
                }
                if ("makepers".equals($ItemID)) { // signal 3
                    _pkgSignalItem = new javax.megaco.pkg.ext.AASRecordingPkg.MakePersistentSig();
                    if (_megacoPkgItemParamList.size() > 0)
                        _pkgSignalItem.setMegacoPkgItemParam(_megacoPkgItemParamList.toArray(new PkgItemParam[_megacoPkgItemParamList.size()]));
                    _megacoPkgItemParamList.clear();
                    return _pkgSignalItem;
                }
            }
// 54
            if ("aassm".equals($PackageName)) {
                _megacoPkg = new javax.megaco.pkg.ext.AdvancedAudioServerSegmentManagementPkg.AdvancedAudioServerSegmentManagementPkg();
                if ("ctlnam".equals($ItemID)) {// prpt 1
                    _pkgPrptyItem = new javax.megaco.pkg.ext.AdvancedAudioServerSegmentManagementPkg.AASSegmentControlTerminationNamePrpt();
                    _pkgPrptyItem.setItemValue(Constants.valueForUnknown(_parmValue));
                    _pkgPrptyItem.setItemsValueRelation(paramRelationExpanded());
                    _megacoPkgPrptyItemList.add(_pkgPrptyItem);
                    return _pkgPrptyItem;
                }
                if ("delpers".equals($ItemID)) { // signal 1
                    _pkgSignalItem = new javax.megaco.pkg.ext.AdvancedAudioServerSegmentManagementPkg.DeletePersistentSig();
                    if (_megacoPkgItemParamList.size() > 0)
                        _pkgSignalItem.setMegacoPkgItemParam(_megacoPkgItemParamList.toArray(new PkgItemParam[_megacoPkgItemParamList.size()]));
                    _megacoPkgItemParamList.clear();
                    return _pkgSignalItem;
                }
                if ("override".equals($ItemID)) { // signal 2
// SegmentIdentifierParam
                    if ("override".equals($ItemID) && "tgtsid".equals($eventParameterName)) {// event param 1
                        _pkgItemParam = new javax.megaco.pkg.ext.AdvancedAudioServerSegmentManagementPkg.SegmentIdentifierParam();
                        _pkgItemParam.setItemValue(Constants.valueForString(_parmValue));
                        _pkgItemParam.setParamsValueRelation(paramRelationExpanded());
                        _megacoPkgItemParamList.add(_pkgItemParam);
                        return _pkgItemParam;
                    }
// OverridingSegmentParam
                    if ("override".equals($ItemID) && "oversid".equals($eventParameterName)) {// event param 2
                        _pkgItemParam = new javax.megaco.pkg.ext.AdvancedAudioServerSegmentManagementPkg.OverridingSegmentParam();
                        _pkgItemParam.setItemValue(Constants.valueForString(_parmValue));
                        _pkgItemParam.setParamsValueRelation(paramRelationExpanded());
                        _megacoPkgItemParamList.add(_pkgItemParam);
                        return _pkgItemParam;
                    }
                    _pkgSignalItem = new javax.megaco.pkg.ext.AdvancedAudioServerSegmentManagementPkg.OverrideAudioSig();
                    if (_megacoPkgItemParamList.size() > 0)
                        _pkgSignalItem.setMegacoPkgItemParam(_megacoPkgItemParamList.toArray(new PkgItemParam[_megacoPkgItemParamList.size()]));
                    _megacoPkgItemParamList.clear();
                    return _pkgSignalItem;
                }
                if ("restore".equals($ItemID)) { // signal 3
// SegmentIdentifierParam
                    if ("restore".equals($ItemID) && "tgtsid".equals($eventParameterName)) {// event param 1
                        _pkgItemParam = new javax.megaco.pkg.ext.AdvancedAudioServerSegmentManagementPkg.SegmentIdentifierParam();
                        _pkgItemParam.setItemValue(Constants.valueForString(_parmValue));
                        _pkgItemParam.setParamsValueRelation(paramRelationExpanded());
                        _megacoPkgItemParamList.add(_pkgItemParam);
                        return _pkgItemParam;
                    }
                    _pkgSignalItem = new javax.megaco.pkg.ext.AdvancedAudioServerSegmentManagementPkg.RestoreAudioSig();
                    if (_megacoPkgItemParamList.size() > 0)
                        _pkgSignalItem.setMegacoPkgItemParam(_megacoPkgItemParamList.toArray(new PkgItemParam[_megacoPkgItemParamList.size()]));
                    _megacoPkgItemParamList.clear();
                    return _pkgSignalItem;
                }
            }
// 166
            if ("asr".equals($PackageName)) {
                _megacoPkg = new javax.megaco.pkg.ext.ASRPkg.ASRPkg();
                if ("asrfail".equals($ItemID)) { // event 1
                    _pkgEventItem = new javax.megaco.pkg.ext.ASRPkg.ASRFailureEvt();
                    if (_megacoPkgItemParamList.size() > 0)
                        _pkgEventItem.setMegacoPkgItemParam(_megacoPkgItemParamList.toArray(new PkgItemParam[_megacoPkgItemParamList.size()]));
                    _megacoPkgItemParamList.clear();
                    return _pkgEventItem;
                }
                if ("asrsucc".equals($ItemID)) { // event 2
// ASRResultParam
                    if ("asrsucc".equals($ItemID) && "asrr".equals($eventParameterName)) {// event param 1
                        _pkgItemParam = new javax.megaco.pkg.ext.ASRPkg.ASRResultParam();
                        _pkgItemParam.setItemValue(Constants.valueForString(_parmValue));
                        _pkgItemParam.setParamsValueRelation(paramRelationExpanded());
                        _megacoPkgItemParamList.add(_pkgItemParam);
                        return _pkgItemParam;
                    }
// ASRResultFormatTypeParam
                    if ("asrsucc".equals($ItemID) && "asrrft".equals($eventParameterName)) {// event param 2
                        _pkgItemParam = new javax.megaco.pkg.ext.ASRPkg.ASRResultFormatTypeParam();
                        _pkgItemParam.setItemValue(Constants.valueForString(_parmValue));
                        _pkgItemParam.setParamsValueRelation(paramRelationExpanded());
                        _megacoPkgItemParamList.add(_pkgItemParam);
                        return _pkgItemParam;
                    }
                    _pkgEventItem = new javax.megaco.pkg.ext.ASRPkg.ASRSuccessEvt();
                    if (_megacoPkgItemParamList.size() > 0)
                        _pkgEventItem.setMegacoPkgItemParam(_megacoPkgItemParamList.toArray(new PkgItemParam[_megacoPkgItemParamList.size()]));
                    _megacoPkgItemParamList.clear();
                    return _pkgEventItem;
                }
                if ("asrwgs".equals($ItemID)) { // signal 1
                    _pkgSignalItem = new javax.megaco.pkg.ext.ASRPkg.ASRRecognitionWithGrammarScriptSig();
                    if (_megacoPkgItemParamList.size() > 0)
                        _pkgSignalItem.setMegacoPkgItemParam(_megacoPkgItemParamList.toArray(new PkgItemParam[_megacoPkgItemParamList.size()]));
                    _megacoPkgItemParamList.clear();
                    return _pkgSignalItem;
                }
                if ("asrid".equals($ItemID)) { // signal 2
// ASRResultParam
                    if ("asrid".equals($ItemID) && "asrr".equals($eventParameterName)) {// event param 1
                        _pkgItemParam = new javax.megaco.pkg.ext.ASRPkg.ASRResultParam();
                        _pkgItemParam.setItemValue(Constants.valueForString(_parmValue));
                        _pkgItemParam.setParamsValueRelation(paramRelationExpanded());
                        _megacoPkgItemParamList.add(_pkgItemParam);
                        return _pkgItemParam;
                    }
// ASRResultFormatTypeParam
                    if ("asrid".equals($ItemID) && "asrrft".equals($eventParameterName)) {// event param 2
                        _pkgItemParam = new javax.megaco.pkg.ext.ASRPkg.ASRResultFormatTypeParam();
                        _pkgItemParam.setItemValue(Constants.valueForString(_parmValue));
                        _pkgItemParam.setParamsValueRelation(paramRelationExpanded());
                        _megacoPkgItemParamList.add(_pkgItemParam);
                        return _pkgItemParam;
                    }
                    _pkgSignalItem = new javax.megaco.pkg.ext.ASRPkg.ASRRecognitionWithGrammarIdentifierSig();
                    if (_megacoPkgItemParamList.size() > 0)
                        _pkgSignalItem.setMegacoPkgItemParam(_megacoPkgItemParamList.toArray(new PkgItemParam[_megacoPkgItemParamList.size()]));
                    _megacoPkgItemParamList.clear();
                    return _pkgSignalItem;
                }
            }
// 168
            if ("aastts".equals($PackageName)) {
                _megacoPkg = new javax.megaco.pkg.ext.AdvancedAudioServerBaseEnhancementPkg.AdvancedAudioServerBaseEnhancementPkg();
                if ("ttsfail".equals($ItemID)) { // event 1
// ReturnCodeParam
                    if ("ttsfail".equals($ItemID) && "rc".equals($eventParameterName)) {// event param 1
                        _pkgItemParam = new javax.megaco.pkg.ext.AdvancedAudioServerBaseEnhancementPkg.ReturnCodeParam();
                        _pkgItemParam.setItemValue(Constants.valueForInteger(_parmValue));
                        _pkgItemParam.setParamsValueRelation(paramRelationExpanded());
                        _megacoPkgItemParamList.add(_pkgItemParam);
                        return _pkgItemParam;
                    }
                    _pkgEventItem = new javax.megaco.pkg.ext.AdvancedAudioServerBaseEnhancementPkg.TTSOperationFailureEvt();
                    if (_megacoPkgItemParamList.size() > 0)
                        _pkgEventItem.setMegacoPkgItemParam(_megacoPkgItemParamList.toArray(new PkgItemParam[_megacoPkgItemParamList.size()]));
                    _megacoPkgItemParamList.clear();
                    return _pkgEventItem;
                }
                if ("md".equals($ItemID)) { // event 2
// ReturnCodeParam
                    if ("md".equals($ItemID) && "mv".equals($eventParameterName)) {// event param 1
                        _pkgItemParam = new javax.megaco.pkg.ext.AdvancedAudioServerBaseEnhancementPkg.ReturnCodeParam();
                        _pkgItemParam.setItemValue(Constants.valueForInteger(_parmValue));
                        _pkgItemParam.setParamsValueRelation(paramRelationExpanded());
                        _megacoPkgItemParamList.add(_pkgItemParam);
                        return _pkgItemParam;
                    }
// TimeValueParam
                    if ("md".equals($ItemID) && "tv".equals($eventParameterName)) {// event param 2
                        _pkgItemParam = new javax.megaco.pkg.ext.AdvancedAudioServerBaseEnhancementPkg.TimeValueParam();
                        _pkgItemParam.setItemValue(Constants.valueForString(_parmValue));
                        _pkgItemParam.setParamsValueRelation(paramRelationExpanded());
                        _megacoPkgItemParamList.add(_pkgItemParam);
                        return _pkgItemParam;
                    }
                    _pkgEventItem = new javax.megaco.pkg.ext.AdvancedAudioServerBaseEnhancementPkg.MarkDetectionEvt();
                    if (_megacoPkgItemParamList.size() > 0)
                        _pkgEventItem.setMegacoPkgItemParam(_megacoPkgItemParamList.toArray(new PkgItemParam[_megacoPkgItemParamList.size()]));
                    _megacoPkgItemParamList.clear();
                    return _pkgEventItem;
                }
                if ("playsid".equals($ItemID)) { // signal 1
// ReturnCodeParam
                    if ("playsid".equals($ItemID) && "rc".equals($eventParameterName)) {// event param 1
                        _pkgItemParam = new javax.megaco.pkg.ext.AdvancedAudioServerBaseEnhancementPkg.ReturnCodeParam();
                        _pkgItemParam.setItemValue(Constants.valueForInteger(_parmValue));
                        _pkgItemParam.setParamsValueRelation(paramRelationExpanded());
                        _megacoPkgItemParamList.add(_pkgItemParam);
                        return _pkgItemParam;
                    }
                    _pkgSignalItem = new javax.megaco.pkg.ext.AdvancedAudioServerBaseEnhancementPkg.PlaySegmentIdentifierSig();
                    if (_megacoPkgItemParamList.size() > 0)
                        _pkgSignalItem.setMegacoPkgItemParam(_megacoPkgItemParamList.toArray(new PkgItemParam[_megacoPkgItemParamList.size()]));
                    _megacoPkgItemParamList.clear();
                    return _pkgSignalItem;
                }
                if ("playscript".equals($ItemID)) { // signal 2
// ReturnCodeParam
                    if ("playscript".equals($ItemID) && "mv".equals($eventParameterName)) {// event param 1
                        _pkgItemParam = new javax.megaco.pkg.ext.AdvancedAudioServerBaseEnhancementPkg.ReturnCodeParam();
                        _pkgItemParam.setItemValue(Constants.valueForInteger(_parmValue));
                        _pkgItemParam.setParamsValueRelation(paramRelationExpanded());
                        _megacoPkgItemParamList.add(_pkgItemParam);
                        return _pkgItemParam;
                    }
// TimeValueParam
                    if ("playscript".equals($ItemID) && "tv".equals($eventParameterName)) {// event param 2
                        _pkgItemParam = new javax.megaco.pkg.ext.AdvancedAudioServerBaseEnhancementPkg.TimeValueParam();
                        _pkgItemParam.setItemValue(Constants.valueForString(_parmValue));
                        _pkgItemParam.setParamsValueRelation(paramRelationExpanded());
                        _megacoPkgItemParamList.add(_pkgItemParam);
                        return _pkgItemParam;
                    }
                    _pkgSignalItem = new javax.megaco.pkg.ext.AdvancedAudioServerBaseEnhancementPkg.PlayScriptSig();
                    if (_megacoPkgItemParamList.size() > 0)
                        _pkgSignalItem.setMegacoPkgItemParam(_megacoPkgItemParamList.toArray(new PkgItemParam[_megacoPkgItemParamList.size()]));
                    _megacoPkgItemParamList.clear();
                    return _pkgSignalItem;
                }
            }
// 169
            if ("mpp".equals($PackageName)) {
                _megacoPkg = new javax.megaco.pkg.ext.MultimediaPlayPkg.MultimediaPlayPkg();
                if ("play".equals($ItemID)) { // signal 1
// AnnouncementParam
                    if ("play".equals($ItemID) && "an".equals($eventParameterName)) {// event param 1
                        _pkgItemParam = new javax.megaco.pkg.ext.MultimediaPlayPkg.AnnouncementParam();
                        _pkgItemParam.setItemValue(Constants.valueForString(_parmValue));
                        _pkgItemParam.setParamsValueRelation(paramRelationExpanded());
                        _megacoPkgItemParamList.add(_pkgItemParam);
                        return _pkgItemParam;
                    }
// IterationsParam
                    if ("play".equals($ItemID) && "it".equals($eventParameterName)) {// event param 2
                        _pkgItemParam = new javax.megaco.pkg.ext.MultimediaPlayPkg.IterationsParam();
                        _pkgItemParam.setItemValue(Constants.valueForInteger(_parmValue));
                        _pkgItemParam.setParamsValueRelation(paramRelationExpanded());
                        _megacoPkgItemParamList.add(_pkgItemParam);
                        return _pkgItemParam;
                    }
// IntervalParam
                    if ("play".equals($ItemID) && "iv".equals($eventParameterName)) {// event param 3
                        _pkgItemParam = new javax.megaco.pkg.ext.MultimediaPlayPkg.IntervalParam();
                        _pkgItemParam.setItemValue(Constants.valueForInteger(_parmValue));
                        _pkgItemParam.setParamsValueRelation(paramRelationExpanded());
                        _megacoPkgItemParamList.add(_pkgItemParam);
                        return _pkgItemParam;
                    }
// SpeedParam
                    if ("play".equals($ItemID) && "sp".equals($eventParameterName)) {// event param 4
                        _pkgItemParam = new javax.megaco.pkg.ext.MultimediaPlayPkg.SpeedParam();
                        _pkgItemParam.setItemValue(Constants.valueForInteger(_parmValue));
                        _pkgItemParam.setParamsValueRelation(paramRelationExpanded());
                        _megacoPkgItemParamList.add(_pkgItemParam);
                        return _pkgItemParam;
                    }
// VolumeParam
                    if ("play".equals($ItemID) && "vl".equals($eventParameterName)) {// event param 5
                        _pkgItemParam = new javax.megaco.pkg.ext.MultimediaPlayPkg.VolumeParam();
                        _pkgItemParam.setItemValue(Constants.valueForInteger(_parmValue));
                        _pkgItemParam.setParamsValueRelation(paramRelationExpanded());
                        _megacoPkgItemParamList.add(_pkgItemParam);
                        return _pkgItemParam;
                    }
// AnnouncementDirectionParam
                    if ("play".equals($ItemID) && "di".equals($eventParameterName)) {// event param 6
                        _pkgItemParam = new javax.megaco.pkg.ext.MultimediaPlayPkg.AnnouncementDirectionParam();
                        _pkgItemParam.setItemValue(Constants.valueForString(_parmValue));
                        _pkgItemParam.setParamsValueRelation(paramRelationExpanded());
                        _megacoPkgItemParamList.add(_pkgItemParam);
                        return _pkgItemParam;
                    }
// BrightnessParam
                    if ("play".equals($ItemID) && "btn".equals($eventParameterName)) {// event param 7
                        _pkgItemParam = new javax.megaco.pkg.ext.MultimediaPlayPkg.BrightnessParam();
                        _pkgItemParam.setItemValue(Constants.valueForInteger(_parmValue));
                        _pkgItemParam.setParamsValueRelation(paramRelationExpanded());
                        _megacoPkgItemParamList.add(_pkgItemParam);
                        return _pkgItemParam;
                    }
// ContrastParam
                    if ("play".equals($ItemID) && "ctn".equals($eventParameterName)) {// event param 8
                        _pkgItemParam = new javax.megaco.pkg.ext.MultimediaPlayPkg.ContrastParam();
                        _pkgItemParam.setItemValue(Constants.valueForInteger(_parmValue));
                        _pkgItemParam.setParamsValueRelation(paramRelationExpanded());
                        _megacoPkgItemParamList.add(_pkgItemParam);
                        return _pkgItemParam;
                    }
// OffsetParam
                    if ("play".equals($ItemID) && "off".equals($eventParameterName)) {// event param 9
                        _pkgItemParam = new javax.megaco.pkg.ext.MultimediaPlayPkg.OffsetParam();
                        _pkgItemParam.setItemValue(Constants.valueForInteger(_parmValue));
                        _pkgItemParam.setParamsValueRelation(paramRelationExpanded());
                        _megacoPkgItemParamList.add(_pkgItemParam);
                        return _pkgItemParam;
                    }
// AbsoluteVolumeParam
                    if ("play".equals($ItemID) && "absvl".equals($eventParameterName)) {// event param 10
                        _pkgItemParam = new javax.megaco.pkg.ext.MultimediaPlayPkg.AbsoluteVolumeParam();
                        _pkgItemParam.setItemValue(Constants.valueForInteger(_parmValue));
                        _pkgItemParam.setParamsValueRelation(paramRelationExpanded());
                        _megacoPkgItemParamList.add(_pkgItemParam);
                        return _pkgItemParam;
                    }
                    _pkgSignalItem = new javax.megaco.pkg.ext.MultimediaPlayPkg.PlaySig();
                    if (_megacoPkgItemParamList.size() > 0)
                        _pkgSignalItem.setMegacoPkgItemParam(_megacoPkgItemParamList.toArray(new PkgItemParam[_megacoPkgItemParamList.size()]));
                    _megacoPkgItemParamList.clear();
                    return _pkgSignalItem;
                }
            }
// 179
            if ("mrp".equals($PackageName)) {
                _megacoPkg = new javax.megaco.pkg.ext.MultimediaRecordingPkg.MultimediaRecordingPkg();
                if ("playrec".equals($ItemID)) { // signal 2
// InitialPromptParam
                    if ("playrec".equals($ItemID) && "ip".equals($eventParameterName)) {// event param 1
                        _pkgItemParam = new javax.megaco.pkg.ext.MultimediaRecordingPkg.InitialPromptParam();
                        _pkgItemParam.setItemValue(Constants.valueForString(_parmValue));
                        _pkgItemParam.setParamsValueRelation(paramRelationExpanded());
                        _megacoPkgItemParamList.add(_pkgItemParam);
                        return _pkgItemParam;
                    }
// NoSpeechPromptParam
                    if ("playrec".equals($ItemID) && "ns".equals($eventParameterName)) {// event param 2
                        _pkgItemParam = new javax.megaco.pkg.ext.MultimediaRecordingPkg.NoSpeechPromptParam();
                        _pkgItemParam.setItemValue(Constants.valueForString(_parmValue));
                        _pkgItemParam.setParamsValueRelation(paramRelationExpanded());
                        _megacoPkgItemParamList.add(_pkgItemParam);
                        return _pkgItemParam;
                    }
// SuccessAnnouncementParam
                    if ("playrec".equals($ItemID) && "sa".equals($eventParameterName)) {// event param 3
                        _pkgItemParam = new javax.megaco.pkg.ext.MultimediaRecordingPkg.SuccessAnnouncementParam();
                        _pkgItemParam.setItemValue(Constants.valueForString(_parmValue));
                        _pkgItemParam.setParamsValueRelation(paramRelationExpanded());
                        _megacoPkgItemParamList.add(_pkgItemParam);
                        return _pkgItemParam;
                    }
// FailureAnnouncementParam
                    if ("playrec".equals($ItemID) && "fa".equals($eventParameterName)) {// event param 4
                        _pkgItemParam = new javax.megaco.pkg.ext.MultimediaRecordingPkg.FailureAnnouncementParam();
                        _pkgItemParam.setItemValue(Constants.valueForString(_parmValue));
                        _pkgItemParam.setParamsValueRelation(paramRelationExpanded());
                        _megacoPkgItemParamList.add(_pkgItemParam);
                        return _pkgItemParam;
                    }
// MaxAttemptsParam
                    if ("playrec".equals($ItemID) && "mxatt".equals($eventParameterName)) {// event param 5
                        _pkgItemParam = new javax.megaco.pkg.ext.MultimediaRecordingPkg.MaxAttemptsParam();
                        _pkgItemParam.setItemValue(Constants.valueForInteger(_parmValue));
                        _pkgItemParam.setParamsValueRelation(paramRelationExpanded());
                        _megacoPkgItemParamList.add(_pkgItemParam);
                        return _pkgItemParam;
                    }
// PreSpeechTimerParam
                    if ("playrec".equals($ItemID) && "prt".equals($eventParameterName)) {// event param 6
                        _pkgItemParam = new javax.megaco.pkg.ext.MultimediaRecordingPkg.PreSpeechTimerParam();
                        _pkgItemParam.setItemValue(Constants.valueForInteger(_parmValue));
                        _pkgItemParam.setParamsValueRelation(paramRelationExpanded());
                        _megacoPkgItemParamList.add(_pkgItemParam);
                        return _pkgItemParam;
                    }
// PostSpeechTimerParam
                    if ("playrec".equals($ItemID) && "pst".equals($eventParameterName)) {// event param 7
                        _pkgItemParam = new javax.megaco.pkg.ext.MultimediaRecordingPkg.PostSpeechTimerParam();
                        _pkgItemParam.setItemValue(Constants.valueForInteger(_parmValue));
                        _pkgItemParam.setParamsValueRelation(paramRelationExpanded());
                        _megacoPkgItemParamList.add(_pkgItemParam);
                        return _pkgItemParam;
                    }
// RecordLengthTimerParam
                    if ("playrec".equals($ItemID) && "rlt".equals($eventParameterName)) {// event param 8
                        _pkgItemParam = new javax.megaco.pkg.ext.MultimediaRecordingPkg.RecordLengthTimerParam();
                        _pkgItemParam.setItemValue(Constants.valueForInteger(_parmValue));
                        _pkgItemParam.setParamsValueRelation(paramRelationExpanded());
                        _megacoPkgItemParamList.add(_pkgItemParam);
                        return _pkgItemParam;
                    }
// RecordingIdentifierParam
                    if ("playrec".equals($ItemID) && "rid".equals($eventParameterName)) {// event param 9
                        _pkgItemParam = new javax.megaco.pkg.ext.MultimediaRecordingPkg.RecordingIdentifierParam();
                        _pkgItemParam.setItemValue(Constants.valueForString(_parmValue));
                        _pkgItemParam.setParamsValueRelation(paramRelationExpanded());
                        _megacoPkgItemParamList.add(_pkgItemParam);
                        return _pkgItemParam;
                    }
// SpeedParam
                    if ("playrec".equals($ItemID) && "sp".equals($eventParameterName)) {// event param 10
                        _pkgItemParam = new javax.megaco.pkg.ext.MultimediaRecordingPkg.SpeedParam();
                        _pkgItemParam.setItemValue(Constants.valueForInteger(_parmValue));
                        _pkgItemParam.setParamsValueRelation(paramRelationExpanded());
                        _megacoPkgItemParamList.add(_pkgItemParam);
                        return _pkgItemParam;
                    }
// VolumeParam
                    if ("playrec".equals($ItemID) && "vl".equals($eventParameterName)) {// event param 11
                        _pkgItemParam = new javax.megaco.pkg.ext.MultimediaRecordingPkg.VolumeParam();
                        _pkgItemParam.setItemValue(Constants.valueForInteger(_parmValue));
                        _pkgItemParam.setParamsValueRelation(paramRelationExpanded());
                        _megacoPkgItemParamList.add(_pkgItemParam);
                        return _pkgItemParam;
                    }
// OffsetParam
                    if ("playrec".equals($ItemID) && "off".equals($eventParameterName)) {// event param 12
                        _pkgItemParam = new javax.megaco.pkg.ext.MultimediaRecordingPkg.OffsetParam();
                        _pkgItemParam.setItemValue(Constants.valueForInteger(_parmValue));
                        _pkgItemParam.setParamsValueRelation(paramRelationExpanded());
                        _megacoPkgItemParamList.add(_pkgItemParam);
                        return _pkgItemParam;
                    }
// RestartKeyParam
                    if ("playrec".equals($ItemID) && "rsk".equals($eventParameterName)) {// event param 13
                        _pkgItemParam = new javax.megaco.pkg.ext.MultimediaRecordingPkg.RestartKeyParam();
                        _pkgItemParam.setItemValue(Constants.valueForInteger(_parmValue));
                        _pkgItemParam.setParamsValueRelation(paramRelationExpanded());
                        _megacoPkgItemParamList.add(_pkgItemParam);
                        return _pkgItemParam;
                    }
// ReinputKeyParam
                    if ("playrec".equals($ItemID) && "rik".equals($eventParameterName)) {// event param 14
                        _pkgItemParam = new javax.megaco.pkg.ext.MultimediaRecordingPkg.ReinputKeyParam();
                        _pkgItemParam.setItemValue(Constants.valueForInteger(_parmValue));
                        _pkgItemParam.setParamsValueRelation(paramRelationExpanded());
                        _megacoPkgItemParamList.add(_pkgItemParam);
                        return _pkgItemParam;
                    }
// ReturnKeyParam
                    if ("playrec".equals($ItemID) && "rtk".equals($eventParameterName)) {// event param 15
                        _pkgItemParam = new javax.megaco.pkg.ext.MultimediaRecordingPkg.ReturnKeyParam();
                        _pkgItemParam.setItemValue(Constants.valueForInteger(_parmValue));
                        _pkgItemParam.setParamsValueRelation(paramRelationExpanded());
                        _megacoPkgItemParamList.add(_pkgItemParam);
                        return _pkgItemParam;
                    }
// EndInputKeyParam
                    if ("playrec".equals($ItemID) && "eik".equals($eventParameterName)) {// event param 16
                        _pkgItemParam = new javax.megaco.pkg.ext.MultimediaRecordingPkg.EndInputKeyParam();
                        _pkgItemParam.setItemValue(Constants.valueForInteger(_parmValue));
                        _pkgItemParam.setParamsValueRelation(paramRelationExpanded());
                        _megacoPkgItemParamList.add(_pkgItemParam);
                        return _pkgItemParam;
                    }
// RecordDirectionParam
                    if ("playrec".equals($ItemID) && "rd".equals($eventParameterName)) {// event param 17
                        _pkgItemParam = new javax.megaco.pkg.ext.MultimediaRecordingPkg.RecordDirectionParam();
                        _pkgItemParam.setItemValue(Constants.valueForString(_parmValue));
                        _pkgItemParam.setParamsValueRelation(paramRelationExpanded());
                        _megacoPkgItemParamList.add(_pkgItemParam);
                        return _pkgItemParam;
                    }
// AbsoluteVolumeParam
                    if ("playrec".equals($ItemID) && "absvl".equals($eventParameterName)) {// event param 18
                        _pkgItemParam = new javax.megaco.pkg.ext.MultimediaRecordingPkg.AbsoluteVolumeParam();
                        _pkgItemParam.setItemValue(Constants.valueForInteger(_parmValue));
                        _pkgItemParam.setParamsValueRelation(paramRelationExpanded());
                        _megacoPkgItemParamList.add(_pkgItemParam);
                        return _pkgItemParam;
                    }
// StorageModeParam
                    if ("playrec".equals($ItemID) && "sm".equals($eventParameterName)) {// event param 19
                        _pkgItemParam = new javax.megaco.pkg.ext.MultimediaRecordingPkg.StorageModeParam();
                        _pkgItemParam.setItemValue(Constants.valueForString(_parmValue));
                        _pkgItemParam.setParamsValueRelation(paramRelationExpanded());
                        _megacoPkgItemParamList.add(_pkgItemParam);
                        return _pkgItemParam;
                    }
// SkipIntervalParam
                    if ("playrec".equals($ItemID) && "skint".equals($eventParameterName)) {// event param 20
                        _pkgItemParam = new javax.megaco.pkg.ext.MultimediaRecordingPkg.SkipIntervalParam();
                        _pkgItemParam.setItemValue(Constants.valueForInteger(_parmValue));
                        _pkgItemParam.setParamsValueRelation(paramRelationExpanded());
                        _megacoPkgItemParamList.add(_pkgItemParam);
                        return _pkgItemParam;
                    }
// FastFowardKeyParam
                    if ("playrec".equals($ItemID) && "ffk".equals($eventParameterName)) {// event param 21
                        _pkgItemParam = new javax.megaco.pkg.ext.MultimediaRecordingPkg.FastFowardKeyParam();
                        _pkgItemParam.setItemValue(Constants.valueForString(_parmValue));
                        _pkgItemParam.setParamsValueRelation(paramRelationExpanded());
                        _megacoPkgItemParamList.add(_pkgItemParam);
                        return _pkgItemParam;
                    }
// RewindKeyParam
                    if ("playrec".equals($ItemID) && "rwk".equals($eventParameterName)) {// event param 22
                        _pkgItemParam = new javax.megaco.pkg.ext.MultimediaRecordingPkg.RewindKeyParam();
                        _pkgItemParam.setItemValue(Constants.valueForString(_parmValue));
                        _pkgItemParam.setParamsValueRelation(paramRelationExpanded());
                        _megacoPkgItemParamList.add(_pkgItemParam);
                        return _pkgItemParam;
                    }
// VolumeIntervalParam
                    if ("playrec".equals($ItemID) && "volint".equals($eventParameterName)) {// event param 23
                        _pkgItemParam = new javax.megaco.pkg.ext.MultimediaRecordingPkg.VolumeIntervalParam();
                        _pkgItemParam.setItemValue(Constants.valueForInteger(_parmValue));
                        _pkgItemParam.setParamsValueRelation(paramRelationExpanded());
                        _megacoPkgItemParamList.add(_pkgItemParam);
                        return _pkgItemParam;
                    }
// VolumeUpKeyParam
                    if ("playrec".equals($ItemID) && "volup".equals($eventParameterName)) {// event param 24
                        _pkgItemParam = new javax.megaco.pkg.ext.MultimediaRecordingPkg.VolumeUpKeyParam();
                        _pkgItemParam.setItemValue(Constants.valueForString(_parmValue));
                        _pkgItemParam.setParamsValueRelation(paramRelationExpanded());
                        _megacoPkgItemParamList.add(_pkgItemParam);
                        return _pkgItemParam;
                    }
// VolumeDownKeyParam
                    if ("playrec".equals($ItemID) && "voldwn".equals($eventParameterName)) {// event param 25
                        _pkgItemParam = new javax.megaco.pkg.ext.MultimediaRecordingPkg.VolumeDownKeyParam();
                        _pkgItemParam.setItemValue(Constants.valueForString(_parmValue));
                        _pkgItemParam.setParamsValueRelation(paramRelationExpanded());
                        _megacoPkgItemParamList.add(_pkgItemParam);
                        return _pkgItemParam;
                    }
// SpeedIntervalParam
                    if ("playrec".equals($ItemID) && "spdint".equals($eventParameterName)) {// event param 26
                        _pkgItemParam = new javax.megaco.pkg.ext.MultimediaRecordingPkg.SpeedIntervalParam();
                        _pkgItemParam.setItemValue(Constants.valueForInteger(_parmValue));
                        _pkgItemParam.setParamsValueRelation(paramRelationExpanded());
                        _megacoPkgItemParamList.add(_pkgItemParam);
                        return _pkgItemParam;
                    }
// SpeedUpKeyParam
                    if ("playrec".equals($ItemID) && "spdup".equals($eventParameterName)) {// event param 27
                        _pkgItemParam = new javax.megaco.pkg.ext.MultimediaRecordingPkg.SpeedUpKeyParam();
                        _pkgItemParam.setItemValue(Constants.valueForString(_parmValue));
                        _pkgItemParam.setParamsValueRelation(paramRelationExpanded());
                        _megacoPkgItemParamList.add(_pkgItemParam);
                        return _pkgItemParam;
                    }
// SpeedDownKeyParam
                    if ("playrec".equals($ItemID) && "spddwn".equals($eventParameterName)) {// event param 28
                        _pkgItemParam = new javax.megaco.pkg.ext.MultimediaRecordingPkg.SpeedDownKeyParam();
                        _pkgItemParam.setItemValue(Constants.valueForString(_parmValue));
                        _pkgItemParam.setParamsValueRelation(paramRelationExpanded());
                        _megacoPkgItemParamList.add(_pkgItemParam);
                        return _pkgItemParam;
                    }
// PauseIntervalParam
                    if ("playrec".equals($ItemID) && "pse".equals($eventParameterName)) {// event param 29
                        _pkgItemParam = new javax.megaco.pkg.ext.MultimediaRecordingPkg.PauseIntervalParam();
                        _pkgItemParam.setItemValue(Constants.valueForInteger(_parmValue));
                        _pkgItemParam.setParamsValueRelation(paramRelationExpanded());
                        _megacoPkgItemParamList.add(_pkgItemParam);
                        return _pkgItemParam;
                    }
// PauseKeyParam
                    if ("playrec".equals($ItemID) && "pse".equals($eventParameterName)) {// event param 30
                        _pkgItemParam = new javax.megaco.pkg.ext.MultimediaRecordingPkg.PauseKeyParam();
                        _pkgItemParam.setItemValue(Constants.valueForString(_parmValue));
                        _pkgItemParam.setParamsValueRelation(paramRelationExpanded());
                        _megacoPkgItemParamList.add(_pkgItemParam);
                        return _pkgItemParam;
                    }
// ResumeKeyParam
                    if ("playrec".equals($ItemID) && "rsm".equals($eventParameterName)) {// event param 31
                        _pkgItemParam = new javax.megaco.pkg.ext.MultimediaRecordingPkg.ResumeKeyParam();
                        _pkgItemParam.setItemValue(Constants.valueForString(_parmValue));
                        _pkgItemParam.setParamsValueRelation(paramRelationExpanded());
                        _megacoPkgItemParamList.add(_pkgItemParam);
                        return _pkgItemParam;
                    }
// PromptEndKeyParam
                    if ("playrec".equals($ItemID) && "pend".equals($eventParameterName)) {// event param 32
                        _pkgItemParam = new javax.megaco.pkg.ext.MultimediaRecordingPkg.PromptEndKeyParam();
                        _pkgItemParam.setItemValue(Constants.valueForString(_parmValue));
                        _pkgItemParam.setParamsValueRelation(paramRelationExpanded());
                        _megacoPkgItemParamList.add(_pkgItemParam);
                        return _pkgItemParam;
                    }
// ExternalControlKeyParam
                    if ("playrec".equals($ItemID) && "extkey".equals($eventParameterName)) {// event param 33
                        _pkgItemParam = new javax.megaco.pkg.ext.MultimediaRecordingPkg.ExternalControlKeyParam();
                        _pkgItemParam.setItemValue(Constants.valueForString(_parmValue));
                        _pkgItemParam.setParamsValueRelation(paramRelationExpanded());
                        _megacoPkgItemParamList.add(_pkgItemParam);
                        return _pkgItemParam;
                    }
                    _pkgSignalItem = new javax.megaco.pkg.ext.MultimediaRecordingPkg.PlayRecordSig();
                    if (_megacoPkgItemParamList.size() > 0)
                        _pkgSignalItem.setMegacoPkgItemParam(_megacoPkgItemParamList.toArray(new PkgItemParam[_megacoPkgItemParamList.size()]));
                    _megacoPkgItemParamList.clear();
                    return _pkgSignalItem;
                }
            }
// 256
            if ("edtmf".equals($PackageName)) {
                _megacoPkg = new javax.megaco.pkg.ext.EnhancedDTMFDetectionPkg.EnhancedDTMFDetectionPkg();
                if ("extkey".equals($ItemID)) { // event 2
                    _pkgEventItem = new javax.megaco.pkg.ext.EnhancedDTMFDetectionPkg.DTMFDigitsEvt();
                    if (_megacoPkgItemParamList.size() > 0)
                        _pkgEventItem.setMegacoPkgItemParam(_megacoPkgItemParamList.toArray(new PkgItemParam[_megacoPkgItemParamList.size()]));
                    _megacoPkgItemParamList.clear();
                    return _pkgEventItem;
                }
                if ("ce".equals($ItemID)) { // event 4
// UnsuccessfulMatchReportingParam
                    if ("ce".equals($ItemID) && "umr".equals($eventParameterName)) {// event param 1
                        _pkgItemParam = new javax.megaco.pkg.ext.EnhancedDTMFDetectionPkg.UnsuccessfulMatchReportingParam();
                        _pkgItemParam.setItemValue(Constants.valueForBoolean(_parmValue));
                        _pkgItemParam.setParamsValueRelation(paramRelationExpanded());
                        _megacoPkgItemParamList.add(_pkgItemParam);
                        return _pkgItemParam;
                    }
// TerminationMethodParam
                    if ("ce".equals($ItemID) && "type".equals($eventParameterName)) {// event param 2
                        _pkgItemParam = new javax.megaco.pkg.ext.EnhancedDTMFDetectionPkg.TerminationMethodParam();
                        _pkgItemParam.setItemValue(Constants.valueForString(_parmValue));
                        _pkgItemParam.setParamsValueRelation(paramRelationExpanded());
                        _megacoPkgItemParamList.add(_pkgItemParam);
                        return _pkgItemParam;
                    }
// UnsuccessfulMatchReportingParam
                    if ("ce".equals($ItemID) && "ds".equals($eventParameterName)) {// event param 1
                        _pkgItemParam = new javax.megaco.pkg.ext.EnhancedDTMFDetectionPkg.UnsuccessfulMatchReportingParam();
                        _pkgItemParam.setItemValue(Constants.valueForBoolean(_parmValue));
                        _pkgItemParam.setParamsValueRelation(paramRelationExpanded());
                        _megacoPkgItemParamList.add(_pkgItemParam);
                        return _pkgItemParam;
                    }
// TerminationMethodParam
                    if ("ce".equals($ItemID) && "Meth".equals($eventParameterName)) {// event param 2
                        _pkgItemParam = new javax.megaco.pkg.ext.EnhancedDTMFDetectionPkg.TerminationMethodParam();
                        _pkgItemParam.setItemValue(Constants.valueForString(_parmValue));
                        _pkgItemParam.setParamsValueRelation(paramRelationExpanded());
                        _megacoPkgItemParamList.add(_pkgItemParam);
                        return _pkgItemParam;
                    }
// TypeParam
                    if ("ce".equals($ItemID) && "type".equals($eventParameterName)) {// event param 3
                        _pkgItemParam = new javax.megaco.pkg.ext.EnhancedDTMFDetectionPkg.TypeParam();
                        _pkgItemParam.setItemValue(Constants.valueForString(_parmValue));
                        _pkgItemParam.setParamsValueRelation(paramRelationExpanded());
                        _megacoPkgItemParamList.add(_pkgItemParam);
                        return _pkgItemParam;
                    }
                    _pkgEventItem = new javax.megaco.pkg.ext.EnhancedDTMFDetectionPkg.DigitMapCompletionEvt();
                    if (_megacoPkgItemParamList.size() > 0)
                        _pkgEventItem.setMegacoPkgItemParam(_megacoPkgItemParamList.toArray(new PkgItemParam[_megacoPkgItemParamList.size()]));
                    _megacoPkgItemParamList.clear();
                    return _pkgEventItem;
                }
            }
            logger.warn("No object found : " + $PackageName + "/" + $ItemID);
            return null;
        } finally {
//            _parmValue = null;
            $eventParameterName = null;
        }
    }
}