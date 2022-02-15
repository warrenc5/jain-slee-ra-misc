/* -----------------------------------------------------------------------------
 * Displayer.java
 * -----------------------------------------------------------------------------
 *
 * Producer : com.parse2.aparse.Parser 2.2
 * Produced : Sun Aug 12 20:56:08 WAT 2012
 *
 * -----------------------------------------------------------------------------
 */
package mofokom.in.mgcp.resource.impl.codec;

import java.util.concurrent.Callable;
import java.util.List;
import java.util.ArrayList;
import mofokom.mgcp.resource.impl.codec.abnf.*;
import org.apache.log4j.Logger;

public class RecursiveLeafFirstVisitor implements Visitor {

    @Override
    public Object visit(Rule$MGCPMessage rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$MGCPCommand rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$MGCPCommandLine rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$MGCPVerb rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$extensionVerb rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$transaction_id rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$endpointName rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$LocalEndpointName rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$LocalNamePart rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$AnyName rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$AllName rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$NameString rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$range_of_allowed_characters rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$DomainName rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$number rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$IPv6address rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$IPv4address rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$hexpart rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$hexseq rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$hex4 rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$MGCPversion rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$ProfileName rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$MGCPParameter rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$ParameterValue rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$ResponseAck rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$confirmedTransactionIdRange rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$BearerInformation rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$BearerAttribute rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$BearerExtensionName rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$BearerExtensionValue rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$BearerEncoding rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$CallId rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$ConnectionId rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$SecondConnectionID rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$NotifiedEntity rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$LocalName rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$portNumber rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$RequestIdentifier rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$LocalConnectionOptions rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$LocalOptionValue rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$Capabilities rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$CapabilityValue rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$PackageList rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$pkgNameAndVers rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$packageVersion rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$packetizationPeriod rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$compressionAlgorithm rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$algorithmName rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$bandwidth rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$echoCancellation rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$gainControl rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$silenceSuppression rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$typeOfService rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$resourceReservation rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$encryptiondata rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$encryptionKey rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$encodedEncryptionKey rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$URItoObtainKey rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$typeOfNetwork rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$OtherTypeOfNetwork rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$supportedTypeOfNetwork rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$supportedModes rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$supportedPackages rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$packageName rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$LocalOptionExtensionName rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$VendorLCOExtensionName rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$PackageLCOExtensionName rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$OtherLCOExtensionName rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$LocalOptionExtensionValue rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$ConnectionMode rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$ExtensionConnectionMode rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$PkgExtConnectionMode rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$RequestedEvents rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$requestedEvent rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$eventName rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$eventId rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$eventRange rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$DTMFLetter rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$requestedActions rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$requestedAction rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$ExtensionAction rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$PackageExtAction rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$Action rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$ActionParameters rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$EmbeddedRequest rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$EmbeddedRequestList rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$EmbeddedSignalRequest rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$EmbeddedDigitMap rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$SignalRequests rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$SignalRequest rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$eventParameters rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$eventParameter rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$eventParameterString rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$eventParameterName rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$eventParameterValue rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$DigitMap rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$DigitStringList rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$DigitString rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$DigitStringElement rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$DigitPosition rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$DigitMapLetter rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$ExtensionDigitMapLetter rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$DigitMapRange rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$DigitLetter rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$ObservedEvents rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$EventStates rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$ConnectionParameters rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$ConnectionParameter rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$packetsSent rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$octetsSent rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$packetsReceived rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$octetsReceived rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$packetsLost rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$jitter rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$averageLatency rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$ConnectionParameterExtensionName rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$VendorCPExtensionName rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$PackageCPExtensionName rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$CPName rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$ConnectionParameterExtensionValue rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$MaxMGCPDatagram rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$ReasonCode rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$SpecificEndpointID rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$SecondEndpointID rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$RequestedInfo rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$infoCode rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$QuarantineHandling rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$loopControl rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$processControl rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$DetectEvents rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$RestartMethod rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$extensionRestartMethod rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$PackageExtensionRM rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$RestartDelay rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$extensionParameter rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$VendorExtensionParameter rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$PackageExtensionParameter rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$OtherExtensionParameter rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$parameterString rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$MGCPResponse rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$MGCPResponseLine rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$responseCode rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$responseString rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$SuitablePkgExtLCOCharacter rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$SuitableExtLCOCharacter rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$SuitableLCOCharacter rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$SuitableExtLCOValChar rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$SuitableEventParamCharacter rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$quotedString rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$quoteEscape rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$quoteChar rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$HYPHEN rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$SDPinformation rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$SDPLine rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$VCHAR rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$UINT16 rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$UINT32 rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$NAME rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$VALUE rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$SafeChar rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$EQUAL rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$COLON rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$LBRKT rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$RBRKT rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$COMMA rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$DOT rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$SLASH rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$ALPHA rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$DIGIT rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$DQUOTE rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$HEXDIG rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$SP rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$HTAB rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$CR rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$LF rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$LWSP rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$EOL rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$WSP rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$SEP rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$COMMENT rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Rule$RestChar rule) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Terminal$StringValue value) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visit(Terminal$NumericValue value) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    
    private Visitor guest;
    private Logger logger;

    public RecursiveLeafFirstVisitor(Visitor guest, Logger logger) {
        this.logger = logger;
        this.guest = guest;
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

    public abstract boolean isSimpleRule(Rule rule);

    private static String spaces(int j) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < j; i++) {
            builder.append(" ");
        }
        return builder.toString();
    }
}