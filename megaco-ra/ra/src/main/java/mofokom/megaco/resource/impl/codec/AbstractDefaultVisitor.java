package mofokom.megaco.resource.impl.codec;

import java.util.Collections;
import java.util.List;
import mofokom.megaco.resource.impl.codec.abnf.*;
import java.util.concurrent.Callable;
import javax.megaco.InvalidArgumentException;

/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */ /**
 *
 * @author wozza
 */
public class AbstractDefaultVisitor extends ObjectDecoder implements Visitor {

    public AbstractDefaultVisitor() {
    }

    @Override
    public Object visit(Rule$megacoMessage rule) {
        $megacoMessage = rule.toString();
        return _message;
    }

    @Override
    public Object visit(Rule$authenticationHeader rule) {
        $authenticationHeader = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$SecurityParmIndex rule) {
        $SecurityParmIndex = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$SequenceNum rule) {
        $SequenceNum = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$AuthData rule) {
        $AuthData = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$message rule) {
        $message = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$messageBody rule) {
        $messageBody = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$transactionList rule) {
        $transactionList = rule.toString();
        setLastCommandInTxn();
        return null;
    }

    @Override
    public Object visit(Rule$transactionPending rule) {
        $transactionPending = rule.toString();
        _messageHeader.setPending(true);
        return null;
    }

    @Override
    public Object visit(Rule$transactionResponseAck rule) {
        $transactionResponseAck = rule.toString();
        _messageHeader.setTransactionResponseAck(true);
        return new Callable() {

            public Object call() {
                try {
                    _messageHeader.setTransactionIdList(new java.util.ArrayList<Integer[]>(_transactionList));
                    //Collections.unmodifiableList(_transactionList));
                    _messageHeader.setTransactionId(0);
                    return _transactionList.size();
                } finally {
                    _transactionList.clear();
                }
            }
        };
    }

    @Override
    public Object visit(Rule$transactionAck rule) {
        $transactionAck = rule.toString();
        if ($transactionAck.indexOf('-') > -1) {
            String[] s = $transactionAck.split("-");
            _transactionList.add(new Integer[]{Integer.valueOf(s[0]), Integer.valueOf(s[1])});
            return $transactionAck;
        } else
            return new Callable() {

                public Object call() {
                    try {
                        _transactionList.add(new Integer[]{Integer.valueOf(_transactionId)});
                        return _transactionId;
                    } finally {
                    }
                }
            };
    }

    @Override
    public Object visit(Rule$transactionRequest rule) {
        $transactionRequest = rule.toString();
        _messageHeader.setTransaction(true);
        return null;
    }

    @Override
    public Object visit(Rule$actionRequest rule) {
        $actionRequest = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$contextRequest rule) {
        $contextRequest = rule.toString();
        return contextInfoReqExpanded();

    }

    @Override
    public Object visit(Rule$contextProperties rule) {
        $contextProperties = rule.toString();
        return super.contextParamExpanded();
    }

    @Override
    public Object visit(Rule$contextProperty rule) {
        $contextProperty = rule.toString();

        return null;
    }

    @Override
    public Object visit(Rule$contextAudit rule) {
        $contextAudit = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$contextAuditProperties rule) {
        $contextAuditProperties = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$commandRequestList rule) {
        $commandRequestList = rule.toString();
        contextInfoExpanded();
        return new Callable() {

            public Object call() {
                try {
                    setLastCommandInTxn();
                    return _message;
                } finally {
                }
            }
        };
    }

    @Override
    public Object visit(Rule$commandRequest rule) {
        $commandRequest = rule.toString();
        return super.commandReqExpanded();
    }

    @Override
    public Object visit(Rule$transactionReply rule) {
        $transactionReply = rule.toString();
        setLastCommandInTxn();
        _messageHeader.setReply(true);
        return null;
    }

    @Override
    public Object visit(Rule$actionReplyList rule) {
        $actionReplyList = rule.toString();
        setLastCommandInTxn();
        return null;
    }

    @Override
    public Object visit(Rule$actionReply rule) {
        $actionReply = rule.toString();
        return super.contextInfoExpanded();
    }

    @Override
    public Object visit(Rule$CommandOptionalToken rule) {
        _commandOptional = true;
        return null;
    }

    @Override
    public Object visit(Rule$CommandWildcardToken rule) {
        _commandWildcard = true;

        return null;
    }

    @Override
    public Object visit(Rule$commandReply rule) {
        $commandReply = rule.toString();
        //TODO contextProperties
        return null;
    }

    @Override
    public Object visit(Rule$commandReplyList rule) {
        $commandReplyList = rule.toString();


        return null;
    }

    @Override
    public Object visit(Rule$commandReplys rule) {
        $commandReplys = rule.toString();
        return commandRespExpanded();
    }

    @Override
    public Object visit(Rule$ammRequest rule) {
        $ammRequest = rule.toString();
        return cmdRequestTypeExpanded();
    }

    @Override
    public Object visit(Rule$ammParameter rule) {
        $ammParameter = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$ammsReply rule) {
        $ammsReply = rule.toString();
        return cmdResponseTypeExpanded();
    }

    @Override
    public Object visit(Rule$subtractRequest rule) {
        $subtractRequest = rule.toString();
        return cmdRequestTypeExpanded();
    }

    @Override
    public Object visit(Rule$auditRequest rule) {
        $auditRequest = rule.toString();
        return cmdRequestTypeExpanded();
    }

    @Override
    public Object visit(Rule$auditReply rule) {
        $auditReply = rule.toString();
        return cmdResponseTypeExpanded();
    }

    @Override
    public Object visit(Rule$auditOther rule) {
        $auditOther = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$terminationAudit rule) {
        $terminationAudit = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$contextTerminationAudit rule) {
        $contextTerminationAudit = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$auditReturnParameter rule) {
        $auditReturnParameter = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$auditDescriptor rule) {
        $auditDescriptor = rule.toString();
        return super.auditValDescriptorExpanded();
    }

    @Override
    public Object visit(Rule$notifyRequest rule) {
        $notifyRequest = rule.toString();
        return cmdRequestTypeExpanded();
    }

    @Override
    public Object visit(Rule$notifyReply rule) {
        $notifyReply = rule.toString();
        return cmdResponseTypeExpanded();
    }

    @Override
    public Object visit(Rule$serviceChangeRequest rule) {
        $serviceChangeRequest = rule.toString();
        return cmdRequestTypeExpanded();
    }

    @Override
    public Object visit(Rule$serviceChangeReply rule) {
        $serviceChangeReply = rule.toString();
        return cmdResponseTypeExpanded();
    }

    @Override
    public Object visit(Rule$errorDescriptor rule) {
        $errorDescriptor = rule.toString();
        return super.errorDescriptorExpanded();
    }

    @Override
    public Object visit(Rule$ErrorCode rule) {
        $ErrorCode = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$TransactionID rule) {
        $TransactionID = rule.toString();
        _transactionId = Integer.valueOf($TransactionID);
        _messageHeader.setTransactionId(_transactionId);
        return null;
    }

    @Override
    public Object visit(Rule$mId rule) {
        $mId = rule.toString();
        _messageHeader.setmId($mId);
        return null;
    }

    @Override
    public Object visit(Rule$domainName rule) {
        $domainName = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$deviceName rule) {
        $deviceName = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$ContextID rule) {
        $ContextID = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$domainAddress rule) {
        $domainAddress = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$IPv6address rule) {
        $IPv6address = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$IPv4address rule) {
        $IPv4address = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$V4hex rule) {
        $V4hex = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$hexpart rule) {
        $hexpart = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$hexseq rule) {
        $hexseq = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$hex4 rule) {
        $hex4 = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$portNumber rule) {
        $portNumber = rule.toString();
        _portId = Integer.valueOf($portNumber);
        return _portId;
    }

    @Override
    public Object visit(Rule$mtpAddress rule) {
        $mtpAddress = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$terminationIDList rule) {
        $terminationIDList = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$pathNAME rule) {
        $pathNAME = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$pathDomainName rule) {
        $pathDomainName = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$TerminationID rule) {
        $TerminationID = rule.toString();
        _termName = $TerminationID;
        super.termTypeExpanded();
        _termination = super.terminationExpanded();
        super._terminationList.add(_termination);
        return _termination;
    }

    @Override
    public Object visit(Rule$mediaDescriptor rule) {
        $mediaDescriptor = rule.toString();
        try {
            mediaDescriptorExpanded();
        } catch (InvalidArgumentException x) {
            x.printStackTrace();
        }
        /*
         * _descriptorListStack.push(_descriptorList = new
         * ArrayList<javax.megaco.message.Descriptor>()); return new Callable(){
         * public Object call() { _descriptorList=_descriptorListStack.pop();
         * return null; } };
         */
        return null;
    }

    @Override
    public Object visit(Rule$mediaParm rule) {
        $mediaParm = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$streamParm rule) {
        $streamParm = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$streamDescriptor rule) {
        $streamDescriptor = rule.toString();
        mediaStreamParamExpanded();
        return super.streamDescriptorExpanded();
    }

    @Override
    public Object visit(Rule$localControlDescriptor rule) {
        $localControlDescriptor = rule.toString();
        return super.localCtrlDescriptorExpanded();
    }

    @Override
    public Object visit(Rule$localParm rule) {
        $localParm = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$reservedValueMode rule) {
        $reservedValueMode = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$reservedGroupMode rule) {
        $reservedGroupMode = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$streamMode rule) {
        $streamMode = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$streamModes rule) {
        $streamModes = rule.toString();
        return streamModeExpanded();
    }

    @Override
    public Object visit(Rule$propertyParm rule) {
        $propertyParm = rule.toString();

        return new Callable() {

            public Object call() {
                try {
                    return pkgItemExpanded();
                } finally {
                    _stringValue = null;
                    _parmValue = null;
                }
            }
        };
//pkgItemExpanded();
    }

    @Override
    public Object visit(Rule$parmValue rule) {
        $parmValue = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$alternativeValue rule) {
        $alternativeValue = rule.toString();
        _parmValue = $alternativeValue;
        _stringValue = $alternativeValue;
        $INEQUAL = null;

        return paramRelationExpanded();
    }

    @Override
    public Object visit(Rule$INEQUAL rule) {
        $INEQUAL = rule.toString();
        _stringValue = $INEQUAL;
        _parmValue = $INEQUAL;
        return null;
    }

    @Override
    public Object visit(Rule$LSBRKT rule) {
        $LSBRKT = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$RSBRKT rule) {
        $RSBRKT = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$localDescriptor rule) {
        $localDescriptor = rule.toString();
        return new Callable() {

            public Object call() {
                try {
                    _sessionDescStr = $octetString;
//                    _sessionDescription = SdpUtil.createSessionDescription($octetString);
                    _localDescriptor = sDPInfoExpanded();
                    return _localDescriptor;
                } catch (javax.megaco.ParamNotSupportedException x) {
                    throw new IllegalArgumentException(x);
                    /*
                     * } catch (javax.sdp.SdpException x) { throw new
                     * IllegalArgumentException(x);
                     */
                }
            }
        };
    }

    @Override
    public Object visit(Rule$remoteDescriptor rule) {
        $remoteDescriptor = rule.toString();
        return new Callable() {

            public Object call() {
                try {
                    _sessionDescStr = $octetString;
                    //                    _sessionDescription = SdpUtil.createSessionDescription($octetString);
                    return (_remoteDescriptor = sDPInfoExpanded());
                } catch (javax.megaco.ParamNotSupportedException x) {
                    throw new IllegalArgumentException(x);
                    /*
                     * } catch (javax.sdp.SdpException x) { throw new
                     * IllegalArgumentException(x);
                     */
                }
            }
        };
    }

    @Override
    public Object visit(Rule$eventBufferDescriptor rule) {
        $eventBufferDescriptor = rule.toString();
        return super.eventBufferDescriptorExpanded();
    }

    @Override
    public Object visit(Rule$eventSpec rule) {
        $eventSpec = rule.toString();
        return eventBufParamExpanded();
    }

    @Override
    public Object visit(Rule$eventSpecParameter rule) {
        $eventSpecParameter = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$eventBufferControl rule) {
        $eventBufferControl = rule.toString();
        return eventBufferCtrlExpanded();
    }

    @Override
    public Object visit(Rule$terminationStateDescriptor rule) {
        $terminationStateDescriptor = rule.toString();
        return super.termStateDescriptorExpanded();
    }

    @Override
    public Object visit(Rule$terminationStateParm rule) {
        $terminationStateParm = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$serviceStates rule) {
        $serviceStates = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$muxDescriptor rule) {
        $muxDescriptor = rule.toString();
        return super.muxDescriptorExpanded();
    }

    @Override
    public Object visit(Rule$MuxType rule) {
        $MuxType = rule.toString();

        return null;
    }

    @Override
    public Object visit(Rule$StreamID rule) {
        $StreamID = rule.toString();

        _streamId = Integer.valueOf($StreamID);
        return null;
    }

    @Override
    public Object visit(Rule$pkgdName rule) {
        $pkgdName = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$PackageName rule) {
        $PackageName = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$ItemID rule) {
        $ItemID = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$eventsDescriptor rule) {
        $eventsDescriptor = rule.toString();
        return new Callable() {

            public Object call() {
                eventDescriptorExpanded();
                return _eventDescriptor;
            }
        };
    }

    @Override
    public Object visit(Rule$requestedEvent rule) {
        $requestedEvent = rule.toString();
        return new Callable() {

            public Object call() {
                pkgItemExpanded();
                return requestedEventParamExpanded();
            }
        };
    }

    @Override
    public Object visit(Rule$eventParameter rule) {
        $eventParameter = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$embedWithSig rule) {
        $embedWithSig = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$embedNoSig rule) {
        $embedNoSig = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$embedFirst rule) {
        $embedFirst = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$secondRequestedEvent rule) {
        $secondRequestedEvent = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$secondEventParameter rule) {
        $secondEventParameter = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$embedSig rule) {
        $embedSig = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$eventStream rule) {
        $eventStream = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$eventOther rule) {
        $eventOther = rule.toString();
        return new Callable() {

            public Object call() {
                javax.megaco.pkg.PkgEventItem tmp = _pkgEventItem;
                try {
                    return pkgItemExpanded();
                } finally {
                    _pkgEventItem = tmp;
                }
            }
        };
    }

    @Override
    public Object visit(Rule$eventParameterName rule) {
        $eventParameterName = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$eventDM rule) {
        $eventDM = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$signalsDescriptor rule) {
        $signalsDescriptor = rule.toString();

        return new Callable() {

            public Object call() {
                return signalDescriptorExpanded();
            }
        };
    }

    @Override
    public Object visit(Rule$signalParm rule) {
        $signalParm = rule.toString();

        return new Callable() {

            public Object call() {
                return signalParamExpanded();
            }
        };
    }

    @Override
    public Object visit(Rule$signalRequest rule) {
        $signalRequest = rule.toString();

        _signalRequestList.add(signalRequestExpanded());
        return _signalRequest;
    }

    @Override
    public Object visit(Rule$signalList rule) {
        $signalList = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$signalListId rule) {
        $signalListId = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$signalListParm rule) {
        $signalListParm = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$signalName rule) {
        $signalName = rule.toString();
        return pkgItemExpanded();
    }

    @Override
    public Object visit(Rule$sigParameter rule) {
        $sigParameter = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$sigStream rule) {
        $sigStream = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$sigOther rule) {
        $sigOther = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$sigParameterName rule) {
        $sigParameterName = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$sigSignalType rule) {
        $sigSignalType = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$signalType rule) {
        $signalType = rule.toString();

        return signalTypeExpanded();
    }

    @Override
    public Object visit(Rule$sigDuration rule) {
        $sigDuration = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$notifyCompletion rule) {
        $notifyCompletion = rule.toString();
        //OK
        return null;
    }

    @Override
    public Object visit(Rule$notificationReason rule) {
        $notificationReason = rule.toString();
        return signalNotifyReasonExpanded();
    }

    @Override
    public Object visit(Rule$observedEventsDescriptor rule) {
        $observedEventsDescriptor = rule.toString();

        try {
            return super.obsEventDescriptorExpanded();
        } catch (javax.megaco.InvalidArgumentException x) {
            throw new IllegalArgumentException(x);
        }
    }

    @Override
    public Object visit(Rule$observedEvent rule) {
        $observedEvent = rule.toString();
        pkgItemExpanded();
        return super.observedEventExpanded();
    }

    @Override
    public Object visit(Rule$observedEventParameter rule) {
        $observedEventParameter = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$RequestID rule) {
        $RequestID = rule.toString();
        _requestID = Integer.valueOf($RequestID);
        return null;
    }

    @Override
    public Object visit(Rule$modemDescriptor rule) {
        $modemDescriptor = rule.toString();
        return super.modemDescriptorExpanded();
    }

    @Override
    public Object visit(Rule$modemType rule) {
        $modemType = rule.toString();
        return super.modemTypeExpanded();
    }

    @Override
    public Object visit(Rule$digitMapDescriptor rule) {
        $digitMapDescriptor = rule.toString();
        return super.digitMapDescriptorExpanded();
    }

    @Override
    public Object visit(Rule$digitMapName rule) {
        $digitMapName = rule.toString();
        _digitMapName = $digitMapName;
        return null;
    }

    @Override
    public Object visit(Rule$digitMapValue rule) {
        $digitMapValue = rule.toString();
        //_digitMapValueStr = $digitMapValue;
        return digitMapValueExpanded();
    }

    @Override
    public Object visit(Rule$Timer rule) {
        $Timer = rule.toString();
        if ("T".equals(_stringValue))
            _timerTValue = Integer.valueOf($Timer);
        else if ("L".equals(_stringValue))
            _timerLValue = Integer.valueOf($Timer);
        else if ("S".equals(_stringValue))
            _timerSValue = Integer.valueOf($Timer);
        return null;
    }

    @Override
    public Object visit(Rule$digitMap rule) {
        $digitMap = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$digitStringList rule) {
        $digitStringList = rule.toString();
        return null;//_digitMapStringsList;
    }

    @Override
    public Object visit(Rule$digitString rule) {
        $digitString = rule.toString();
        return new Callable() {

            public Object call() {
                digitMapStringExpanded();
                _digitMapStringsList.add(_digitMapString);
                return _digitMapString;
            }
        };
    }

    @Override
    public Object visit(Rule$digitStringElement rule) {
        $digitStringElement = rule.toString();
        return new Callable() {

            public Object call() {
                return digitStringPositionExpanded($digitStringElement != null && $digitStringElement.endsWith("."));
            }
        };
    }

    @Override
    public Object visit(Rule$digitPosition rule) {
        $digitPosition = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$digitMapRange rule) {
        $digitMapRange = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$digitLetter rule) {
        $digitLetter = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$digitMapLetter rule) {
        $digitMapLetter = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$auditItem rule) {
        $auditItem = rule.toString();
        _auditItemList.add(Constants.DescriptorTypeForValue($auditItem));
        return null;
    }

    @Override
    public Object visit(Rule$serviceChangeDescriptor rule) {
        $serviceChangeDescriptor = rule.toString();

        try {
            return super.srvChngDescriptorExpanded();
        } catch (Exception x) {
            throw new IllegalArgumentException(x);
        }
    }

    @Override
    public Object visit(Rule$serviceChangeParm rule) {
        $serviceChangeParm = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$serviceChangeReplyDescriptor rule) {
        $serviceChangeReplyDescriptor = rule.toString();

        try {
            return super.srvChngRespDescriptorExpanded();
        } catch (Exception x) {
            throw new IllegalArgumentException(x);
        }
    }

    @Override
    public Object visit(Rule$servChgReplyParm rule) {
        $servChgReplyParm = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$serviceChangeMethod rule) {
        $serviceChangeMethod = rule.toString();
        return new Callable() {

            public Object call() {
                return srvChngMethodExpanded();
            }
        };
    }

    @Override
    public Object visit(Rule$serviceChangeReason rule) {
        $serviceChangeReason = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$serviceChangeDelay rule) {
        $serviceChangeDelay = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$serviceChangeAddress rule) {
        $serviceChangeAddress = rule.toString();
        _srvChngAddress = localAddrExpanded();
        return _srvChngAddress;
    }

    @Override
    public Object visit(Rule$serviceChangeMgcId rule) {
        $serviceChangeMgcId = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$serviceChangeProfile rule) {
        $serviceChangeProfile = rule.toString();
        super._srvChngProfile = $NAME;
        return super._srvChngProfile;
    }

    @Override
    public Object visit(Rule$serviceChangeVersion rule) {
        $serviceChangeVersion = rule.toString();
        super._protocolVersion = Integer.valueOf(rule.spelling);
        return super._protocolVersion;
    }

    @Override
    public Object visit(Rule$extension rule) {
        $extension = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$packagesDescriptor rule) {
        $packagesDescriptor = rule.toString();
        return super.packageDescriptorExpanded();
    }

    @Override
    public Object visit(Rule$Version rule) {
        $Version = rule.toString();
        super._protocolVersion = Integer.valueOf(rule.spelling);
        _messageHeader.setProtocolVersion(_protocolVersion);
        return super._protocolVersion;
    }

    @Override
    public Object visit(Rule$packagesItem rule) {
        $packagesItem = rule.toString();
        return new Callable() {

            public Object call() {

                return packagesItemExpanded();
            }
        };
    }

    @Override
    public Object visit(Rule$TimeStamp rule) {
        $TimeStamp = rule.toString();
        return super.timeStampExpanded();
    }

    //*********************** CONSTANTS FROM ABOUT HERE ******************/
    @Override
    public Object visit(Rule$Date rule) {
        $Date = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$Time rule) {
        $Time = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$statisticsDescriptor rule) {
        $statisticsDescriptor = rule.toString();
        return super.statsDescriptorExpanded();
    }

    @Override
    public Object visit(Rule$statisticsParameter rule) {
        $statisticsParameter = rule.toString();
        return new Callable() {

            public Object call() {
                pkgItemExpanded();
                _pkgStatsItemList.add(_pkgStatsItem);
                return _pkgStatsItem;
            }
        };
    }

    @Override
    public Object visit(Rule$topologyDescriptor rule) {
        $topologyDescriptor = rule.toString();

        return super.topologyDescriptorExpanded();
    }

    @Override
    public Object visit(Rule$topologyTriple rule) {
        $topologyTriple = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$terminationA rule) {
        $terminationA = rule.toString();
        return _termination;
    }

    @Override
    public Object visit(Rule$terminationB rule) {
        $terminationB = rule.toString();
        return _termination;
    }

    @Override
    public Object visit(Rule$topologyDirection rule) {
        $topologyDirection = rule.toString();
        return super.topologyDirectionExpanded();
    }

    @Override
    public Object visit(Rule$priority rule) {
        $priority = rule.toString();
        super._priority = Integer.valueOf($UINT16);
        return super._priority;
    }

    @Override
    public Object visit(Rule$extensionParameter rule) {
        $extensionParameter = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$octetString rule) {
        $octetString = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$nonEscapeChar rule) {
        $nonEscapeChar = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$quotedString rule) {
        $quotedString = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$UINT16 rule) {
        $UINT16 = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$UINT32 rule) {
        $UINT32 = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$NAME rule) {
        $NAME = rule.toString();
        String name = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$VALUE rule) {
        $VALUE = rule.toString();
        _stringValue = $VALUE;
        return null;
    }

    @Override
    public Object visit(Rule$SafeChar rule) {
        $SafeChar = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$EQUAL rule) {
        $EQUAL = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$COLON rule) {
        $COLON = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$LBRKT rule) {
        $LBRKT = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$RBRKT rule) {
        $RBRKT = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$COMMA rule) {
        $COMMA = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$DOT rule) {
        $DOT = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$SLASH rule) {
        $SLASH = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$ALPHA rule) {
        $ALPHA = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$DIGIT rule) {
        $DIGIT = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$DQUOTE rule) {
        $DQUOTE = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$HEXDIG rule) {
        $HEXDIG = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$SP rule) {
        $SP = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$HTAB rule) {
        $HTAB = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$CR rule) {
        $CR = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$LF rule) {
        $LF = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$LWSP rule) {
        $LWSP = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$EOL rule) {
        $EOL = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$WSP rule) {
        $WSP = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$SEP rule) {
        $SEP = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$COMMENT rule) {
        $COMMENT = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$RestChar rule) {
        $RestChar = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$AddToken rule) {
        $AddToken = rule.toString();
        _commandTypeToken = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$AuditToken rule) {
        $AuditToken = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$AuditCapToken rule) {
        $AuditCapToken = rule.toString();
        _commandTypeToken = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$AuditValueToken rule) {
        $AuditValueToken = rule.toString();
        _commandTypeToken = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$AuthToken rule) {
        $AuthToken = rule.toString();
        _commandTypeToken = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$BothwayToken rule) {
        $BothwayToken = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$BriefToken rule) {
        $BriefToken = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$BufferToken rule) {
        $BufferToken = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$CtxToken rule) {
        $CtxToken = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$ContextAuditToken rule) {
        $ContextAuditToken = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$DigitMapToken rule) {
        $DigitMapToken = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$DisconnectedToken rule) {
        $DisconnectedToken = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$DelayToken rule) {
        $DelayToken = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$DurationToken rule) {
        $DurationToken = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$EmbedToken rule) {
        $EmbedToken = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$EmergencyToken rule) {
        $EmergencyToken = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$ErrorToken rule) {
        $ErrorToken = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$EventBufferToken rule) {
        $EventBufferToken = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$EventsToken rule) {
        $EventsToken = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$FailoverToken rule) {
        $FailoverToken = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$ForcedToken rule) {
        $ForcedToken = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$GracefulToken rule) {
        $GracefulToken = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$H221Token rule) {
        $H221Token = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$H223Token rule) {
        $H223Token = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$H226Token rule) {
        $H226Token = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$HandOffToken rule) {
        $HandOffToken = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$ImmAckRequiredToken rule) {
        $ImmAckRequiredToken = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$InactiveToken rule) {
        $InactiveToken = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$IsolateToken rule) {
        $IsolateToken = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$InSvcToken rule) {
        $InSvcToken = rule.toString();
        _serviceState = super.serviceStateExpanded();
        return null;
    }

    @Override
    public Object visit(Rule$InterruptByEventToken rule) {
        $InterruptByEventToken = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$InterruptByNewSignalsDescrToken rule) {
        $InterruptByNewSignalsDescrToken = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$KeepActiveToken rule) {
        $KeepActiveToken = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$LocalToken rule) {
        $LocalToken = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$LocalControlToken rule) {
        $LocalControlToken = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$LockStepToken rule) {
        $LockStepToken = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$LoopbackToken rule) {
        $LoopbackToken = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$MediaToken rule) {
        $MediaToken = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$MegacopToken rule) {
        $MegacopToken = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$MethodToken rule) {
        $MethodToken = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$MgcIdToken rule) {
        $MgcIdToken = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$ModeToken rule) {
        $ModeToken = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$ModifyToken rule) {
        $ModifyToken = rule.toString();
        _commandTypeToken = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$ModemToken rule) {
        $ModemToken = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$MoveToken rule) {
        $MoveToken = rule.toString();
        _commandTypeToken = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$MTPToken rule) {
        $MTPToken = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$MuxToken rule) {
        $MuxToken = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$NotifyToken rule) {
        $NotifyToken = rule.toString();
        _commandTypeToken = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$NotifyCompletionToken rule) {
        $NotifyCompletionToken = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$ObservedEventsToken rule) {
        $ObservedEventsToken = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$OnewayToken rule) {
        $OnewayToken = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$OnOffToken rule) {
        $OnOffToken = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$OtherReasonToken rule) {
        $OtherReasonToken = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$OutOfSvcToken rule) {
        $OutOfSvcToken = rule.toString();
        _serviceState = super.serviceStateExpanded();
        return null;
    }

    @Override
    public Object visit(Rule$PackagesToken rule) {
        $PackagesToken = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$PendingToken rule) {
        $PendingToken = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$PriorityToken rule) {
        $PriorityToken = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$ProfileToken rule) {
        $ProfileToken = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$ReasonToken rule) {
        $ReasonToken = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$RecvonlyToken rule) {
        $RecvonlyToken = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$ReplyToken rule) {
        $ReplyToken = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$RestartToken rule) {
        $RestartToken = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$RemoteToken rule) {
        $RemoteToken = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$ReservedGroupToken rule) {
        $ReservedGroupToken = rule.toString();
        _reserveGroupPresent = true;
        return null;
    }

    @Override
    public Object visit(Rule$ReservedValueToken rule) {
        $ReservedValueToken = rule.toString();
        _reserveValuePresent = true;
        return null;
    }

    @Override
    public Object visit(Rule$SendonlyToken rule) {
        $SendonlyToken = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$SendrecvToken rule) {
        $SendrecvToken = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$ServicesToken rule) {
        $ServicesToken = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$ServiceStatesToken rule) {
        $ServiceStatesToken = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$ServiceChangeToken rule) {
        $ServiceChangeToken = rule.toString();
        _commandTypeToken = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$ServiceChangeAddressToken rule) {
        $ServiceChangeAddressToken = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$SignalListToken rule) {
        $SignalListToken = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$SignalsToken rule) {
        $SignalsToken = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$SignalTypeToken rule) {
        $SignalTypeToken = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$StatsToken rule) {
        $StatsToken = rule.toString();
        _pkgStatsItemList.clear();
        return null;
    }

    @Override
    public Object visit(Rule$StreamToken rule) {
        $StreamToken = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$SubtractToken rule) {
        $SubtractToken = rule.toString();
        _commandTypeToken = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$SynchISDNToken rule) {
        $SynchISDNToken = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$TerminationStateToken rule) {
        $TerminationStateToken = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$TestToken rule) {
        $TestToken = rule.toString();
        _serviceState = super.serviceStateExpanded();
        return null;
    }

    @Override
    public Object visit(Rule$TimeOutToken rule) {
        $TimeOutToken = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$TopologyToken rule) {
        $TopologyToken = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$TransToken rule) {
        $TransToken = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$ResponseAckToken rule) {
        $ResponseAckToken = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$V18Token rule) {
        $V18Token = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$V22Token rule) {
        $V22Token = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$V22bisToken rule) {
        $V22bisToken = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$V32Token rule) {
        $V32Token = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$V32bisToken rule) {
        $V32bisToken = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$V34Token rule) {
        $V34Token = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$V76Token rule) {
        $V76Token = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$V90Token rule) {
        $V90Token = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$V91Token rule) {
        $V91Token = rule.toString();
        return null;
    }

    @Override
    public Object visit(Rule$VersionToken rule) {
        $VersionToken = rule.toString();
        return null;
    }

    @Override
    public Object visit(Terminal$StringValue value) {
        $StringValue = value.toString();
        super._stringValue = value.toString();
        return super._stringValue;
    }

    @Override
    public Object visit(Terminal$NumericValue value) {
        $NumericValue = value.toString();

        super._numericValue = value.toString();
        return super._numericValue;
    }

    private static Rule get(List<Rule> rules, Class... match) {
        for (Rule r : rules) {
            for (Class m : match) {
                if (r.getClass().equals(m))
                    return r;
            }
        }
        return null;
    }

    public MessageHeader getMessageHeader() {
        return _messageHeader;
    }
}
