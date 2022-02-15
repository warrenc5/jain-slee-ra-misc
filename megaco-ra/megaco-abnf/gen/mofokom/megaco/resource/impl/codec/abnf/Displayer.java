/* -----------------------------------------------------------------------------
 * Displayer.java
 * -----------------------------------------------------------------------------
 *
 * Producer : com.parse2.aparse.Parser 2.2
 * Produced : Tue Aug 14 12:33:41 WAT 2012
 *
 * -----------------------------------------------------------------------------
 */

package mofokom.megaco.resource.impl.codec.abnf;

import java.util.ArrayList;

public class Displayer implements Visitor
{

  public Object visit(Rule$megacoMessage rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$authenticationHeader rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$SecurityParmIndex rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$SequenceNum rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$AuthData rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$message rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$messageBody rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$transactionList rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$transactionPending rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$transactionResponseAck rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$transactionAck rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$transactionRequest rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$actionRequest rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$contextRequest rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$contextProperties rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$contextProperty rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$contextAudit rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$contextAuditProperties rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$commandRequestList rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$commandRequest rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$transactionReply rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$actionReplyList rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$actionReply rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$commandReply rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$commandReplyList rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$commandReplys rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$ammRequest rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$ammParameter rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$ammsReply rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$subtractRequest rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$auditRequest rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$auditReply rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$auditOther rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$terminationAudit rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$contextTerminationAudit rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$auditReturnParameter rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$auditDescriptor rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$notifyRequest rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$notifyReply rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$serviceChangeRequest rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$serviceChangeReply rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$errorDescriptor rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$ErrorCode rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$TransactionID rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$mId rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$domainName rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$deviceName rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$ContextID rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$domainAddress rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$IPv6address rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$IPv4address rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$V4hex rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$hexpart rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$hexseq rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$hex4 rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$portNumber rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$mtpAddress rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$terminationIDList rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$pathNAME rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$pathDomainName rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$TerminationID rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$mediaDescriptor rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$mediaParm rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$streamParm rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$streamDescriptor rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$localControlDescriptor rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$localParm rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$reservedValueMode rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$reservedGroupMode rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$streamMode rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$streamModes rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$propertyParm rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$parmValue rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$alternativeValue rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$INEQUAL rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$LSBRKT rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$RSBRKT rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$localDescriptor rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$remoteDescriptor rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$eventBufferDescriptor rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$eventSpec rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$eventSpecParameter rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$eventBufferControl rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$terminationStateDescriptor rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$terminationStateParm rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$serviceStates rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$muxDescriptor rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$MuxType rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$StreamID rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$pkgdName rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$PackageName rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$ItemID rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$eventsDescriptor rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$requestedEvent rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$eventParameter rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$embedWithSig rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$embedNoSig rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$embedFirst rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$secondRequestedEvent rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$secondEventParameter rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$embedSig rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$eventStream rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$eventOther rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$eventParameterName rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$eventDM rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$signalsDescriptor rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$signalParm rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$signalRequest rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$signalList rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$signalListId rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$signalListParm rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$signalName rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$sigParameter rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$sigStream rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$sigOther rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$sigParameterName rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$sigSignalType rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$signalType rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$sigDuration rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$notifyCompletion rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$notificationReason rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$observedEventsDescriptor rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$observedEvent rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$observedEventParameter rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$RequestID rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$modemDescriptor rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$modemType rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$digitMapDescriptor rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$digitMapName rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$digitMapValue rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$Timer rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$digitMap rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$digitStringList rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$digitString rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$digitStringElement rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$digitPosition rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$digitMapRange rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$digitLetter rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$digitMapLetter rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$auditItem rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$serviceChangeDescriptor rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$serviceChangeParm rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$serviceChangeReplyDescriptor rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$servChgReplyParm rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$serviceChangeMethod rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$serviceChangeReason rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$serviceChangeDelay rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$serviceChangeAddress rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$serviceChangeMgcId rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$serviceChangeProfile rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$serviceChangeVersion rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$extension rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$packagesDescriptor rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$Version rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$packagesItem rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$TimeStamp rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$Date rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$Time rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$statisticsDescriptor rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$statisticsParameter rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$topologyDescriptor rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$topologyTriple rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$terminationA rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$terminationB rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$topologyDirection rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$priority rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$extensionParameter rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$octetString rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$nonEscapeChar rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$quotedString rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$UINT16 rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$UINT32 rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$NAME rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$VALUE rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$SafeChar rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$EQUAL rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$COLON rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$LBRKT rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$RBRKT rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$COMMA rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$DOT rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$SLASH rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$ALPHA rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$DIGIT rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$DQUOTE rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$HEXDIG rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$SP rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$HTAB rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$CR rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$LF rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$LWSP rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$EOL rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$WSP rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$SEP rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$COMMENT rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$RestChar rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$AddToken rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$AuditToken rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$AuditCapToken rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$AuditValueToken rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$AuthToken rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$BothwayToken rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$BriefToken rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$BufferToken rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$CtxToken rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$ContextAuditToken rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$DigitMapToken rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$DisconnectedToken rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$DelayToken rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$DurationToken rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$EmbedToken rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$EmergencyToken rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$ErrorToken rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$EventBufferToken rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$EventsToken rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$FailoverToken rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$ForcedToken rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$GracefulToken rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$H221Token rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$H223Token rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$H226Token rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$HandOffToken rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$ImmAckRequiredToken rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$InactiveToken rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$IsolateToken rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$InSvcToken rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$InterruptByEventToken rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$InterruptByNewSignalsDescrToken rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$KeepActiveToken rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$LocalToken rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$LocalControlToken rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$LockStepToken rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$LoopbackToken rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$MediaToken rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$MegacopToken rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$MethodToken rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$MgcIdToken rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$ModeToken rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$ModifyToken rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$ModemToken rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$MoveToken rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$MTPToken rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$MuxToken rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$NotifyToken rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$NotifyCompletionToken rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$ObservedEventsToken rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$OnewayToken rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$OnOffToken rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$OtherReasonToken rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$OutOfSvcToken rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$PackagesToken rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$PendingToken rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$PriorityToken rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$ProfileToken rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$ReasonToken rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$RecvonlyToken rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$ReplyToken rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$RestartToken rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$RemoteToken rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$ReservedGroupToken rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$ReservedValueToken rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$SendonlyToken rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$SendrecvToken rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$ServicesToken rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$ServiceStatesToken rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$ServiceChangeToken rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$ServiceChangeAddressToken rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$SignalListToken rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$SignalsToken rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$SignalTypeToken rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$StatsToken rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$StreamToken rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$SubtractToken rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$SynchISDNToken rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$TerminationStateToken rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$TestToken rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$TimeOutToken rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$TopologyToken rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$TransToken rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$ResponseAckToken rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$V18Token rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$V22Token rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$V22bisToken rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$V32Token rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$V32bisToken rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$V34Token rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$V76Token rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$V90Token rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$V91Token rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$VersionToken rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$CommandOptionalToken rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$CommandWildcardToken rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Terminal$StringValue value)
  {
    System.out.print(value.spelling);
    return null;
  }

  public Object visit(Terminal$NumericValue value)
  {
    System.out.print(value.spelling);
    return null;
  }

  private Object visitRules(ArrayList<Rule> rules)
  {
    for (Rule rule : rules)
      rule.accept(this);
    return null;
  }
}

/* -----------------------------------------------------------------------------
 * eof
 * -----------------------------------------------------------------------------
 */
