/* -----------------------------------------------------------------------------
 * Displayer.java
 * -----------------------------------------------------------------------------
 *
 * Producer : com.parse2.aparse.Parser 2.2
 * Produced : Sun Aug 12 20:56:08 WAT 2012
 *
 * -----------------------------------------------------------------------------
 */
package mofokom.megaco.resource.impl.codec;

import java.util.concurrent.Callable;
import java.util.List;
import java.util.ArrayList;
import mofokom.megaco.resource.impl.codec.abnf.*;
import org.apache.log4j.Logger;

public class RecursiveVisitorWrapper implements Visitor {

    private Visitor guest;
    private Logger logger;

    public RecursiveVisitorWrapper(Visitor guest, Logger logger) {
        this.logger = logger;
        this.guest = guest;
    }

    public Object visit(Rule$megacoMessage rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$authenticationHeader rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$SecurityParmIndex rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$SequenceNum rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$AuthData rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$message rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$messageBody rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$transactionList rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$transactionPending rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$transactionResponseAck rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$transactionAck rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$transactionRequest rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$actionRequest rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$contextRequest rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$contextProperties rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$contextProperty rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$contextAudit rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$contextAuditProperties rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    @Override
    public Object visit(Rule$CommandOptionalToken rule) {
        visitRules(rule.rules);
        return guest.visit(rule);
    }

    @Override
    public Object visit(Rule$CommandWildcardToken rule) {
        visitRules(rule.rules);
        return guest.visit(rule);
    }

    public Object visit(Rule$commandRequestList rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$commandRequest rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$transactionReply rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$actionReplyList rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$actionReply rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$commandReply rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$commandReplyList rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$commandReplys rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$ammRequest rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$ammParameter rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$ammsReply rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$subtractRequest rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$auditRequest rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$auditReply rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$auditOther rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$terminationAudit rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$contextTerminationAudit rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$auditReturnParameter rule) {
        visitRules(rule.rules);
        return guest.visit(rule);
    }

    public Object visit(Rule$auditDescriptor rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$notifyRequest rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$notifyReply rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$serviceChangeRequest rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$serviceChangeReply rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$errorDescriptor rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$ErrorCode rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$TransactionID rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$mId rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$domainName rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$deviceName rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$ContextID rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$domainAddress rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$IPv6address rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$IPv4address rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$V4hex rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$hexpart rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$hexseq rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$hex4 rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$portNumber rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$mtpAddress rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$terminationIDList rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$pathNAME rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$pathDomainName rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$TerminationID rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$mediaDescriptor rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$mediaParm rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$streamParm rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$streamDescriptor rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$localControlDescriptor rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$localParm rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$reservedValueMode rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$reservedGroupMode rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$streamMode rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$streamModes rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$propertyParm rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$parmValue rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$alternativeValue rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$INEQUAL rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$LSBRKT rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$RSBRKT rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$localDescriptor rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$remoteDescriptor rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$eventBufferDescriptor rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$eventSpec rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$eventSpecParameter rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$eventBufferControl rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$terminationStateDescriptor rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$terminationStateParm rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$serviceStates rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$muxDescriptor rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$MuxType rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$StreamID rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$pkgdName rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$PackageName rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$ItemID rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$eventsDescriptor rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$requestedEvent rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$eventParameter rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$embedWithSig rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$embedNoSig rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$embedFirst rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$secondRequestedEvent rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$secondEventParameter rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$embedSig rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$eventStream rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$eventOther rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$eventParameterName rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$eventDM rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$signalsDescriptor rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$signalParm rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$signalRequest rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$signalList rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$signalListId rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$signalListParm rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$signalName rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$sigParameter rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$sigStream rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$sigOther rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$sigParameterName rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$sigSignalType rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$signalType rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$sigDuration rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$notifyCompletion rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$notificationReason rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$observedEventsDescriptor rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$observedEvent rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$observedEventParameter rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$RequestID rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$modemDescriptor rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$modemType rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$digitMapDescriptor rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$digitMapName rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$digitMapValue rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$Timer rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$digitMap rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$digitStringList rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$digitString rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$digitStringElement rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$digitPosition rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$digitMapRange rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$digitLetter rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$digitMapLetter rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$auditItem rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$serviceChangeDescriptor rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$serviceChangeParm rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$serviceChangeReplyDescriptor rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$servChgReplyParm rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$serviceChangeMethod rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$serviceChangeReason rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$serviceChangeDelay rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$serviceChangeAddress rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$serviceChangeMgcId rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$serviceChangeProfile rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$serviceChangeVersion rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$extension rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$packagesDescriptor rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$Version rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$packagesItem rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$TimeStamp rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$Date rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$Time rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$statisticsDescriptor rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$statisticsParameter rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$topologyDescriptor rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$topologyTriple rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$terminationA rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$terminationB rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$topologyDirection rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$priority rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$extensionParameter rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$octetString rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$nonEscapeChar rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$quotedString rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$UINT16 rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$UINT32 rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$NAME rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$VALUE rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$SafeChar rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$EQUAL rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$COLON rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$LBRKT rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$RBRKT rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$COMMA rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$DOT rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$SLASH rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$ALPHA rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$DIGIT rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$DQUOTE rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$HEXDIG rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$SP rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$HTAB rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$CR rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$LF rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$LWSP rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$EOL rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$WSP rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$SEP rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$COMMENT rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$RestChar rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$AddToken rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$AuditToken rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$AuditCapToken rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$AuditValueToken rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$AuthToken rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$BothwayToken rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$BriefToken rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$BufferToken rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$CtxToken rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$ContextAuditToken rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$DigitMapToken rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$DisconnectedToken rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$DelayToken rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$DurationToken rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$EmbedToken rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$EmergencyToken rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$ErrorToken rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$EventBufferToken rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$EventsToken rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$FailoverToken rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$ForcedToken rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$GracefulToken rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$H221Token rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$H223Token rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$H226Token rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$HandOffToken rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$ImmAckRequiredToken rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$InactiveToken rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$IsolateToken rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$InSvcToken rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$InterruptByEventToken rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$InterruptByNewSignalsDescrToken rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$KeepActiveToken rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$LocalToken rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$LocalControlToken rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$LockStepToken rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$LoopbackToken rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$MediaToken rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$MegacopToken rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$MethodToken rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$MgcIdToken rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$ModeToken rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$ModifyToken rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$ModemToken rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$MoveToken rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$MTPToken rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$MuxToken rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$NotifyToken rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$NotifyCompletionToken rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$ObservedEventsToken rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$OnewayToken rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$OnOffToken rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$OtherReasonToken rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$OutOfSvcToken rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$PackagesToken rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$PendingToken rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$PriorityToken rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$ProfileToken rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$ReasonToken rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$RecvonlyToken rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$ReplyToken rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$RestartToken rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$RemoteToken rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$ReservedGroupToken rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$ReservedValueToken rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$SendonlyToken rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$SendrecvToken rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$ServicesToken rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$ServiceStatesToken rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$ServiceChangeToken rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$ServiceChangeAddressToken rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$SignalListToken rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$SignalsToken rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$SignalTypeToken rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$StatsToken rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$StreamToken rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$SubtractToken rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$SynchISDNToken rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$TerminationStateToken rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$TestToken rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$TimeOutToken rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$TopologyToken rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$TransToken rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$ResponseAckToken rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$V18Token rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$V22Token rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$V22bisToken rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$V32Token rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$V32bisToken rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$V34Token rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$V76Token rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$V90Token rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$V91Token rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Rule$VersionToken rule) {
        visitRules(rule.rules);
        return guest.visit(rule);

    }

    public Object visit(Terminal$StringValue value) {
        return guest.visit(value);

    }

    public Object visit(Terminal$NumericValue value) {
        return guest.visit(value);
    }
    private int depth;
    List<Callable> runs = new ArrayList<Callable>();

    private Object visitRules(ArrayList<Rule> rules) {

        Object o = null;

        depth++;
        for (Rule rule : rules) {
            if (!isSimpleRule(rule)) {
                StringBuilder bob = new StringBuilder();
                String r = rule.getClass().getSimpleName();
                r = r.substring(5, r.length());

                bob.append('[').append(Integer.toString(depth)).append("]  ").append(r).append(spaces((Math.max(20 - r.length(), 5)) - Integer.toString(depth).length())).append(rule.toString());

                //logger.debug(bob.toString());
            }
            o = rule.accept(this);

            if (o != null && o instanceof Callable)
                runs.add((Callable) o);
            else if (!isSimpleRule(rule) && o != null)
                ;//logger.debug(o.toString());
        }
        for (Callable r : runs) {
            try {
                o = r.call();
                if (o != null)
                    ;//logger.debug(o.toString());
            } catch (Exception x) {
                throw new RuntimeException(x);
            }
        }
        runs.clear();
        depth--;
        return o;
    }

    private boolean isSimpleRule(Rule rule) {
        if (rule.getClass().equals(Terminal$NumericValue.class))
            return true;
        if (rule.getClass().equals(Terminal$StringValue.class))
            return true;
        if (rule.getClass().equals(Rule$SafeChar.class))
            return true;
        if (rule.getClass().equals(Rule$nonEscapeChar.class))
            return true;
        if (rule.getClass().equals(Rule$digitStringElement.class))
            return true;
        if (rule.getClass().equals(Rule$digitLetter.class))
            return true;
        if (rule.getClass().equals(Rule$digitPosition.class))
            return true;
        if (rule.getClass().equals(Rule$digitMapRange.class))
            return true;
        if (rule.getClass().equals(Rule$V4hex.class))
            return true;
        if (rule.getClass().equals(Rule$Date.class))
            return true;
        if (rule.getClass().equals(Rule$Time.class))
            return true;
        if (rule.getClass().getName().matches("Token$"))
            return true;

        String s = rule.getClass().getName();
        s = s.substring(s.indexOf('$'), s.length());
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLowerCase(s.charAt(i)))
                return false;
        }

        return true;
    }

    private String spaces(int j) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < j; i++) {
            builder.append(" ");
        }
        return builder.toString();
    }
}

/*
 * -----------------------------------------------------------------------------
 * eof
 * -----------------------------------------------------------------------------
 */
