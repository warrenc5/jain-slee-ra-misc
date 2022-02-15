/* -----------------------------------------------------------------------------
 * Displayer.java
 * -----------------------------------------------------------------------------
 *
 * Producer : com.parse2.aparse.Parser 2.2
 * Produced : Sun Sep 23 12:29:38 WAT 2012
 *
 * -----------------------------------------------------------------------------
 */

package mofokom.mgcp.resource.impl.codec.abnf;

import java.util.ArrayList;

public class Displayer implements Visitor
{

  public Object visit(Rule$MGCPMessage rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$MGCPCommand rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$MGCPCommandLine rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$MGCPVerb rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$extensionVerb rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$transaction_id rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$endpointName rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$LocalEndpointName rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$LocalNamePart rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$AnyName rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$AllName rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$NameString rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$range_of_allowed_characters rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$DomainName rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$number rule)
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

  public Object visit(Rule$MGCPversion rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$ProfileName rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$MGCPParameter rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$ParameterValue rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$ResponseAck rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$confirmedTransactionIdRange rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$BearerInformation rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$BearerAttribute rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$BearerExtensionName rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$BearerExtensionValue rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$BearerEncoding rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$CallId rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$ConnectionId rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$SecondConnectionID rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$NotifiedEntity rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$LocalName rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$portNumber rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$RequestIdentifier rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$LocalConnectionOptions rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$LocalOptionValue rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$Capabilities rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$CapabilityValue rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$PackageList rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$pkgNameAndVers rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$packageVersion rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$packetizationPeriod rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$compressionAlgorithm rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$algorithmName rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$bandwidth rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$echoCancellation rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$gainControl rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$silenceSuppression rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$typeOfService rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$resourceReservation rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$encryptiondata rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$encryptionKey rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$encodedEncryptionKey rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$URItoObtainKey rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$typeOfNetwork rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$OtherTypeOfNetwork rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$supportedTypeOfNetwork rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$supportedModes rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$supportedPackages rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$packageName rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$LocalOptionExtensionName rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$VendorLCOExtensionName rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$PackageLCOExtensionName rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$OtherLCOExtensionName rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$LocalOptionExtensionValue rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$ConnectionMode rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$ExtensionConnectionMode rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$PkgExtConnectionMode rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$RequestedEvents rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$requestedEvent rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$eventName rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$eventId rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$eventRange rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$DTMFLetter rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$requestedActions rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$requestedAction rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$ExtensionAction rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$PackageExtAction rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$Action rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$ActionParameters rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$EmbeddedRequest rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$EmbeddedRequestList rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$EmbeddedSignalRequest rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$EmbeddedDigitMap rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$SignalRequests rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$SignalRequest rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$eventParameters rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$eventParameter rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$eventParameterString rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$eventParameterName rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$eventParameterValue rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$DigitMap rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$DigitStringList rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$DigitString rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$DigitStringElement rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$DigitPosition rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$DigitMapLetter rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$ExtensionDigitMapLetter rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$DigitMapRange rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$DigitLetter rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$ObservedEvents rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$EventStates rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$ConnectionParameters rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$ConnectionParameter rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$packetsSent rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$octetsSent rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$packetsReceived rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$octetsReceived rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$packetsLost rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$jitter rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$averageLatency rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$ConnectionParameterExtensionName rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$VendorCPExtensionName rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$PackageCPExtensionName rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$CPName rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$ConnectionParameterExtensionValue rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$MaxMGCPDatagram rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$ReasonCode rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$SpecificEndpointID rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$SecondEndpointID rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$RequestedInfo rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$infoCode rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$QuarantineHandling rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$loopControl rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$processControl rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$DetectEvents rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$RestartMethod rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$extensionRestartMethod rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$PackageExtensionRM rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$RestartDelay rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$extensionParameter rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$VendorExtensionParameter rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$PackageExtensionParameter rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$OtherExtensionParameter rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$parameterString rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$MGCPResponse rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$MGCPResponseLine rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$responseCode rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$responseString rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$SuitablePkgExtLCOCharacter rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$SuitableExtLCOCharacter rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$SuitableLCOCharacter rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$SuitableExtLCOValChar rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$SuitableEventParamCharacter rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$quotedString rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$quoteEscape rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$quoteChar rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$HYPHEN rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$SDPinformation rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$SDPLine rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$VCHAR rule)
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
