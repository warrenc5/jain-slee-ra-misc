/* -----------------------------------------------------------------------------
 * Visitor.java
 * -----------------------------------------------------------------------------
 *
 * Producer : com.parse2.aparse.Parser 2.2
 * Produced : Sun Sep 23 12:29:38 WAT 2012
 *
 * -----------------------------------------------------------------------------
 */

package mofokom.mgcp.resource.impl.codec.abnf;

public interface Visitor
{
  public Object visit(Rule$MGCPMessage rule);
  public Object visit(Rule$MGCPCommand rule);
  public Object visit(Rule$MGCPCommandLine rule);
  public Object visit(Rule$MGCPVerb rule);
  public Object visit(Rule$extensionVerb rule);
  public Object visit(Rule$transaction_id rule);
  public Object visit(Rule$endpointName rule);
  public Object visit(Rule$LocalEndpointName rule);
  public Object visit(Rule$LocalNamePart rule);
  public Object visit(Rule$AnyName rule);
  public Object visit(Rule$AllName rule);
  public Object visit(Rule$NameString rule);
  public Object visit(Rule$range_of_allowed_characters rule);
  public Object visit(Rule$DomainName rule);
  public Object visit(Rule$number rule);
  public Object visit(Rule$IPv6address rule);
  public Object visit(Rule$IPv4address rule);
  public Object visit(Rule$hexpart rule);
  public Object visit(Rule$hexseq rule);
  public Object visit(Rule$hex4 rule);
  public Object visit(Rule$MGCPversion rule);
  public Object visit(Rule$ProfileName rule);
  public Object visit(Rule$MGCPParameter rule);
  public Object visit(Rule$ParameterValue rule);
  public Object visit(Rule$ResponseAck rule);
  public Object visit(Rule$confirmedTransactionIdRange rule);
  public Object visit(Rule$BearerInformation rule);
  public Object visit(Rule$BearerAttribute rule);
  public Object visit(Rule$BearerExtensionName rule);
  public Object visit(Rule$BearerExtensionValue rule);
  public Object visit(Rule$BearerEncoding rule);
  public Object visit(Rule$CallId rule);
  public Object visit(Rule$ConnectionId rule);
  public Object visit(Rule$SecondConnectionID rule);
  public Object visit(Rule$NotifiedEntity rule);
  public Object visit(Rule$LocalName rule);
  public Object visit(Rule$portNumber rule);
  public Object visit(Rule$RequestIdentifier rule);
  public Object visit(Rule$LocalConnectionOptions rule);
  public Object visit(Rule$LocalOptionValue rule);
  public Object visit(Rule$Capabilities rule);
  public Object visit(Rule$CapabilityValue rule);
  public Object visit(Rule$PackageList rule);
  public Object visit(Rule$pkgNameAndVers rule);
  public Object visit(Rule$packageVersion rule);
  public Object visit(Rule$packetizationPeriod rule);
  public Object visit(Rule$compressionAlgorithm rule);
  public Object visit(Rule$algorithmName rule);
  public Object visit(Rule$bandwidth rule);
  public Object visit(Rule$echoCancellation rule);
  public Object visit(Rule$gainControl rule);
  public Object visit(Rule$silenceSuppression rule);
  public Object visit(Rule$typeOfService rule);
  public Object visit(Rule$resourceReservation rule);
  public Object visit(Rule$encryptiondata rule);
  public Object visit(Rule$encryptionKey rule);
  public Object visit(Rule$encodedEncryptionKey rule);
  public Object visit(Rule$URItoObtainKey rule);
  public Object visit(Rule$typeOfNetwork rule);
  public Object visit(Rule$OtherTypeOfNetwork rule);
  public Object visit(Rule$supportedTypeOfNetwork rule);
  public Object visit(Rule$supportedModes rule);
  public Object visit(Rule$supportedPackages rule);
  public Object visit(Rule$packageName rule);
  public Object visit(Rule$LocalOptionExtensionName rule);
  public Object visit(Rule$VendorLCOExtensionName rule);
  public Object visit(Rule$PackageLCOExtensionName rule);
  public Object visit(Rule$OtherLCOExtensionName rule);
  public Object visit(Rule$LocalOptionExtensionValue rule);
  public Object visit(Rule$ConnectionMode rule);
  public Object visit(Rule$ExtensionConnectionMode rule);
  public Object visit(Rule$PkgExtConnectionMode rule);
  public Object visit(Rule$RequestedEvents rule);
  public Object visit(Rule$requestedEvent rule);
  public Object visit(Rule$eventName rule);
  public Object visit(Rule$eventId rule);
  public Object visit(Rule$eventRange rule);
  public Object visit(Rule$DTMFLetter rule);
  public Object visit(Rule$requestedActions rule);
  public Object visit(Rule$requestedAction rule);
  public Object visit(Rule$ExtensionAction rule);
  public Object visit(Rule$PackageExtAction rule);
  public Object visit(Rule$Action rule);
  public Object visit(Rule$ActionParameters rule);
  public Object visit(Rule$EmbeddedRequest rule);
  public Object visit(Rule$EmbeddedRequestList rule);
  public Object visit(Rule$EmbeddedSignalRequest rule);
  public Object visit(Rule$EmbeddedDigitMap rule);
  public Object visit(Rule$SignalRequests rule);
  public Object visit(Rule$SignalRequest rule);
  public Object visit(Rule$eventParameters rule);
  public Object visit(Rule$eventParameter rule);
  public Object visit(Rule$eventParameterString rule);
  public Object visit(Rule$eventParameterName rule);
  public Object visit(Rule$eventParameterValue rule);
  public Object visit(Rule$DigitMap rule);
  public Object visit(Rule$DigitStringList rule);
  public Object visit(Rule$DigitString rule);
  public Object visit(Rule$DigitStringElement rule);
  public Object visit(Rule$DigitPosition rule);
  public Object visit(Rule$DigitMapLetter rule);
  public Object visit(Rule$ExtensionDigitMapLetter rule);
  public Object visit(Rule$DigitMapRange rule);
  public Object visit(Rule$DigitLetter rule);
  public Object visit(Rule$ObservedEvents rule);
  public Object visit(Rule$EventStates rule);
  public Object visit(Rule$ConnectionParameters rule);
  public Object visit(Rule$ConnectionParameter rule);
  public Object visit(Rule$packetsSent rule);
  public Object visit(Rule$octetsSent rule);
  public Object visit(Rule$packetsReceived rule);
  public Object visit(Rule$octetsReceived rule);
  public Object visit(Rule$packetsLost rule);
  public Object visit(Rule$jitter rule);
  public Object visit(Rule$averageLatency rule);
  public Object visit(Rule$ConnectionParameterExtensionName rule);
  public Object visit(Rule$VendorCPExtensionName rule);
  public Object visit(Rule$PackageCPExtensionName rule);
  public Object visit(Rule$CPName rule);
  public Object visit(Rule$ConnectionParameterExtensionValue rule);
  public Object visit(Rule$MaxMGCPDatagram rule);
  public Object visit(Rule$ReasonCode rule);
  public Object visit(Rule$SpecificEndpointID rule);
  public Object visit(Rule$SecondEndpointID rule);
  public Object visit(Rule$RequestedInfo rule);
  public Object visit(Rule$infoCode rule);
  public Object visit(Rule$QuarantineHandling rule);
  public Object visit(Rule$loopControl rule);
  public Object visit(Rule$processControl rule);
  public Object visit(Rule$DetectEvents rule);
  public Object visit(Rule$RestartMethod rule);
  public Object visit(Rule$extensionRestartMethod rule);
  public Object visit(Rule$PackageExtensionRM rule);
  public Object visit(Rule$RestartDelay rule);
  public Object visit(Rule$extensionParameter rule);
  public Object visit(Rule$VendorExtensionParameter rule);
  public Object visit(Rule$PackageExtensionParameter rule);
  public Object visit(Rule$OtherExtensionParameter rule);
  public Object visit(Rule$parameterString rule);
  public Object visit(Rule$MGCPResponse rule);
  public Object visit(Rule$MGCPResponseLine rule);
  public Object visit(Rule$responseCode rule);
  public Object visit(Rule$responseString rule);
  public Object visit(Rule$SuitablePkgExtLCOCharacter rule);
  public Object visit(Rule$SuitableExtLCOCharacter rule);
  public Object visit(Rule$SuitableLCOCharacter rule);
  public Object visit(Rule$SuitableExtLCOValChar rule);
  public Object visit(Rule$SuitableEventParamCharacter rule);
  public Object visit(Rule$quotedString rule);
  public Object visit(Rule$quoteEscape rule);
  public Object visit(Rule$quoteChar rule);
  public Object visit(Rule$HYPHEN rule);
  public Object visit(Rule$SDPinformation rule);
  public Object visit(Rule$SDPLine rule);
  public Object visit(Rule$VCHAR rule);
  public Object visit(Rule$UINT16 rule);
  public Object visit(Rule$UINT32 rule);
  public Object visit(Rule$NAME rule);
  public Object visit(Rule$VALUE rule);
  public Object visit(Rule$SafeChar rule);
  public Object visit(Rule$EQUAL rule);
  public Object visit(Rule$COLON rule);
  public Object visit(Rule$LBRKT rule);
  public Object visit(Rule$RBRKT rule);
  public Object visit(Rule$COMMA rule);
  public Object visit(Rule$DOT rule);
  public Object visit(Rule$SLASH rule);
  public Object visit(Rule$ALPHA rule);
  public Object visit(Rule$DIGIT rule);
  public Object visit(Rule$DQUOTE rule);
  public Object visit(Rule$HEXDIG rule);
  public Object visit(Rule$SP rule);
  public Object visit(Rule$HTAB rule);
  public Object visit(Rule$CR rule);
  public Object visit(Rule$LF rule);
  public Object visit(Rule$LWSP rule);
  public Object visit(Rule$EOL rule);
  public Object visit(Rule$WSP rule);
  public Object visit(Rule$SEP rule);
  public Object visit(Rule$COMMENT rule);
  public Object visit(Rule$RestChar rule);

  public Object visit(Terminal$StringValue value);
  public Object visit(Terminal$NumericValue value);
}

/* -----------------------------------------------------------------------------
 * eof
 * -----------------------------------------------------------------------------
 */
