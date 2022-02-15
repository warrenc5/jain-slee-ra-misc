/* -----------------------------------------------------------------------------
 * XmlDisplayer.java
 * -----------------------------------------------------------------------------
 *
 * Producer : com.parse2.aparse.Parser 2.2
 * Produced : Sun Sep 23 12:29:38 WAT 2012
 *
 * -----------------------------------------------------------------------------
 */

package mofokom.mgcp.resource.impl.codec.abnf;

import java.util.ArrayList;

public class XmlDisplayer implements Visitor
{
  private boolean terminal = true;

  public Object visit(Rule$MGCPMessage rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<MGCPMessage>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</MGCPMessage>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$MGCPCommand rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<MGCPCommand>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</MGCPCommand>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$MGCPCommandLine rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<MGCPCommandLine>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</MGCPCommandLine>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$MGCPVerb rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<MGCPVerb>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</MGCPVerb>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$extensionVerb rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<extensionVerb>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</extensionVerb>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$transaction_id rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<transaction-id>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</transaction-id>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$endpointName rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<endpointName>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</endpointName>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$LocalEndpointName rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<LocalEndpointName>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</LocalEndpointName>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$LocalNamePart rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<LocalNamePart>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</LocalNamePart>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$AnyName rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<AnyName>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</AnyName>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$AllName rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<AllName>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</AllName>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$NameString rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<NameString>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</NameString>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$range_of_allowed_characters rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<range-of-allowed-characters>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</range-of-allowed-characters>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$DomainName rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<DomainName>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</DomainName>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$number rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<number>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</number>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$IPv6address rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<IPv6address>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</IPv6address>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$IPv4address rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<IPv4address>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</IPv4address>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$hexpart rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<hexpart>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</hexpart>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$hexseq rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<hexseq>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</hexseq>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$hex4 rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<hex4>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</hex4>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$MGCPversion rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<MGCPversion>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</MGCPversion>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$ProfileName rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<ProfileName>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</ProfileName>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$MGCPParameter rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<MGCPParameter>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</MGCPParameter>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$ParameterValue rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<ParameterValue>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</ParameterValue>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$ResponseAck rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<ResponseAck>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</ResponseAck>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$confirmedTransactionIdRange rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<confirmedTransactionIdRange>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</confirmedTransactionIdRange>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$BearerInformation rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<BearerInformation>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</BearerInformation>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$BearerAttribute rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<BearerAttribute>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</BearerAttribute>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$BearerExtensionName rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<BearerExtensionName>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</BearerExtensionName>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$BearerExtensionValue rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<BearerExtensionValue>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</BearerExtensionValue>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$BearerEncoding rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<BearerEncoding>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</BearerEncoding>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$CallId rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<CallId>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</CallId>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$ConnectionId rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<ConnectionId>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</ConnectionId>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$SecondConnectionID rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<SecondConnectionID>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</SecondConnectionID>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$NotifiedEntity rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<NotifiedEntity>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</NotifiedEntity>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$LocalName rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<LocalName>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</LocalName>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$portNumber rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<portNumber>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</portNumber>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$RequestIdentifier rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<RequestIdentifier>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</RequestIdentifier>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$LocalConnectionOptions rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<LocalConnectionOptions>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</LocalConnectionOptions>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$LocalOptionValue rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<LocalOptionValue>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</LocalOptionValue>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$Capabilities rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<Capabilities>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</Capabilities>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$CapabilityValue rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<CapabilityValue>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</CapabilityValue>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$PackageList rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<PackageList>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</PackageList>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$pkgNameAndVers rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<pkgNameAndVers>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</pkgNameAndVers>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$packageVersion rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<packageVersion>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</packageVersion>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$packetizationPeriod rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<packetizationPeriod>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</packetizationPeriod>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$compressionAlgorithm rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<compressionAlgorithm>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</compressionAlgorithm>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$algorithmName rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<algorithmName>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</algorithmName>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$bandwidth rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<bandwidth>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</bandwidth>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$echoCancellation rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<echoCancellation>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</echoCancellation>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$gainControl rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<gainControl>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</gainControl>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$silenceSuppression rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<silenceSuppression>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</silenceSuppression>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$typeOfService rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<typeOfService>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</typeOfService>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$resourceReservation rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<resourceReservation>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</resourceReservation>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$encryptiondata rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<encryptiondata>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</encryptiondata>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$encryptionKey rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<encryptionKey>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</encryptionKey>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$encodedEncryptionKey rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<encodedEncryptionKey>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</encodedEncryptionKey>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$URItoObtainKey rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<URItoObtainKey>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</URItoObtainKey>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$typeOfNetwork rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<typeOfNetwork>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</typeOfNetwork>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$OtherTypeOfNetwork rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<OtherTypeOfNetwork>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</OtherTypeOfNetwork>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$supportedTypeOfNetwork rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<supportedTypeOfNetwork>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</supportedTypeOfNetwork>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$supportedModes rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<supportedModes>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</supportedModes>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$supportedPackages rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<supportedPackages>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</supportedPackages>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$packageName rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<packageName>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</packageName>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$LocalOptionExtensionName rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<LocalOptionExtensionName>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</LocalOptionExtensionName>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$VendorLCOExtensionName rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<VendorLCOExtensionName>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</VendorLCOExtensionName>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$PackageLCOExtensionName rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<PackageLCOExtensionName>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</PackageLCOExtensionName>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$OtherLCOExtensionName rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<OtherLCOExtensionName>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</OtherLCOExtensionName>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$LocalOptionExtensionValue rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<LocalOptionExtensionValue>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</LocalOptionExtensionValue>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$ConnectionMode rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<ConnectionMode>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</ConnectionMode>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$ExtensionConnectionMode rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<ExtensionConnectionMode>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</ExtensionConnectionMode>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$PkgExtConnectionMode rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<PkgExtConnectionMode>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</PkgExtConnectionMode>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$RequestedEvents rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<RequestedEvents>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</RequestedEvents>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$requestedEvent rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<requestedEvent>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</requestedEvent>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$eventName rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<eventName>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</eventName>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$eventId rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<eventId>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</eventId>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$eventRange rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<eventRange>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</eventRange>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$DTMFLetter rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<DTMFLetter>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</DTMFLetter>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$requestedActions rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<requestedActions>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</requestedActions>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$requestedAction rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<requestedAction>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</requestedAction>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$ExtensionAction rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<ExtensionAction>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</ExtensionAction>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$PackageExtAction rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<PackageExtAction>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</PackageExtAction>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$Action rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<Action>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</Action>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$ActionParameters rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<ActionParameters>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</ActionParameters>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$EmbeddedRequest rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<EmbeddedRequest>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</EmbeddedRequest>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$EmbeddedRequestList rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<EmbeddedRequestList>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</EmbeddedRequestList>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$EmbeddedSignalRequest rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<EmbeddedSignalRequest>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</EmbeddedSignalRequest>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$EmbeddedDigitMap rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<EmbeddedDigitMap>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</EmbeddedDigitMap>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$SignalRequests rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<SignalRequests>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</SignalRequests>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$SignalRequest rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<SignalRequest>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</SignalRequest>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$eventParameters rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<eventParameters>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</eventParameters>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$eventParameter rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<eventParameter>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</eventParameter>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$eventParameterString rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<eventParameterString>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</eventParameterString>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$eventParameterName rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<eventParameterName>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</eventParameterName>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$eventParameterValue rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<eventParameterValue>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</eventParameterValue>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$DigitMap rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<DigitMap>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</DigitMap>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$DigitStringList rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<DigitStringList>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</DigitStringList>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$DigitString rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<DigitString>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</DigitString>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$DigitStringElement rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<DigitStringElement>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</DigitStringElement>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$DigitPosition rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<DigitPosition>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</DigitPosition>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$DigitMapLetter rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<DigitMapLetter>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</DigitMapLetter>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$ExtensionDigitMapLetter rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<ExtensionDigitMapLetter>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</ExtensionDigitMapLetter>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$DigitMapRange rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<DigitMapRange>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</DigitMapRange>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$DigitLetter rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<DigitLetter>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</DigitLetter>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$ObservedEvents rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<ObservedEvents>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</ObservedEvents>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$EventStates rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<EventStates>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</EventStates>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$ConnectionParameters rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<ConnectionParameters>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</ConnectionParameters>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$ConnectionParameter rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<ConnectionParameter>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</ConnectionParameter>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$packetsSent rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<packetsSent>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</packetsSent>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$octetsSent rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<octetsSent>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</octetsSent>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$packetsReceived rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<packetsReceived>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</packetsReceived>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$octetsReceived rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<octetsReceived>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</octetsReceived>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$packetsLost rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<packetsLost>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</packetsLost>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$jitter rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<jitter>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</jitter>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$averageLatency rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<averageLatency>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</averageLatency>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$ConnectionParameterExtensionName rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<ConnectionParameterExtensionName>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</ConnectionParameterExtensionName>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$VendorCPExtensionName rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<VendorCPExtensionName>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</VendorCPExtensionName>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$PackageCPExtensionName rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<PackageCPExtensionName>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</PackageCPExtensionName>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$CPName rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<CPName>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</CPName>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$ConnectionParameterExtensionValue rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<ConnectionParameterExtensionValue>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</ConnectionParameterExtensionValue>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$MaxMGCPDatagram rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<MaxMGCPDatagram>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</MaxMGCPDatagram>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$ReasonCode rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<ReasonCode>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</ReasonCode>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$SpecificEndpointID rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<SpecificEndpointID>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</SpecificEndpointID>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$SecondEndpointID rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<SecondEndpointID>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</SecondEndpointID>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$RequestedInfo rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<RequestedInfo>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</RequestedInfo>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$infoCode rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<infoCode>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</infoCode>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$QuarantineHandling rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<QuarantineHandling>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</QuarantineHandling>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$loopControl rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<loopControl>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</loopControl>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$processControl rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<processControl>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</processControl>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$DetectEvents rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<DetectEvents>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</DetectEvents>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$RestartMethod rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<RestartMethod>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</RestartMethod>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$extensionRestartMethod rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<extensionRestartMethod>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</extensionRestartMethod>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$PackageExtensionRM rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<PackageExtensionRM>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</PackageExtensionRM>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$RestartDelay rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<RestartDelay>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</RestartDelay>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$extensionParameter rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<extensionParameter>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</extensionParameter>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$VendorExtensionParameter rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<VendorExtensionParameter>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</VendorExtensionParameter>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$PackageExtensionParameter rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<PackageExtensionParameter>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</PackageExtensionParameter>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$OtherExtensionParameter rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<OtherExtensionParameter>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</OtherExtensionParameter>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$parameterString rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<parameterString>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</parameterString>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$MGCPResponse rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<MGCPResponse>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</MGCPResponse>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$MGCPResponseLine rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<MGCPResponseLine>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</MGCPResponseLine>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$responseCode rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<responseCode>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</responseCode>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$responseString rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<responseString>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</responseString>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$SuitablePkgExtLCOCharacter rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<SuitablePkgExtLCOCharacter>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</SuitablePkgExtLCOCharacter>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$SuitableExtLCOCharacter rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<SuitableExtLCOCharacter>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</SuitableExtLCOCharacter>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$SuitableLCOCharacter rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<SuitableLCOCharacter>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</SuitableLCOCharacter>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$SuitableExtLCOValChar rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<SuitableExtLCOValChar>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</SuitableExtLCOValChar>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$SuitableEventParamCharacter rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<SuitableEventParamCharacter>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</SuitableEventParamCharacter>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$quotedString rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<quotedString>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</quotedString>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$quoteEscape rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<quoteEscape>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</quoteEscape>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$quoteChar rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<quoteChar>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</quoteChar>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$HYPHEN rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<HYPHEN>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</HYPHEN>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$SDPinformation rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<SDPinformation>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</SDPinformation>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$SDPLine rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<SDPLine>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</SDPLine>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$VCHAR rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<VCHAR>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</VCHAR>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$UINT16 rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<UINT16>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</UINT16>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$UINT32 rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<UINT32>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</UINT32>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$NAME rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<NAME>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</NAME>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$VALUE rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<VALUE>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</VALUE>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$SafeChar rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<SafeChar>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</SafeChar>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$EQUAL rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<EQUAL>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</EQUAL>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$COLON rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<COLON>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</COLON>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$LBRKT rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<LBRKT>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</LBRKT>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$RBRKT rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<RBRKT>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</RBRKT>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$COMMA rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<COMMA>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</COMMA>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$DOT rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<DOT>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</DOT>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$SLASH rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<SLASH>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</SLASH>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$ALPHA rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<ALPHA>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</ALPHA>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$DIGIT rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<DIGIT>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</DIGIT>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$DQUOTE rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<DQUOTE>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</DQUOTE>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$HEXDIG rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<HEXDIG>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</HEXDIG>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$SP rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<SP>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</SP>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$HTAB rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<HTAB>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</HTAB>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$CR rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<CR>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</CR>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$LF rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<LF>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</LF>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$LWSP rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<LWSP>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</LWSP>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$EOL rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<EOL>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</EOL>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$WSP rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<WSP>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</WSP>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$SEP rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<SEP>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</SEP>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$COMMENT rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<COMMENT>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</COMMENT>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$RestChar rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<RestChar>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</RestChar>");
    terminal = false;
    return null;
  }

  public Object visit(Terminal$StringValue value)
  {
    System.out.print(value.spelling);
    terminal = true;
    return null;
  }

  public Object visit(Terminal$NumericValue value)
  {
    System.out.print(value.spelling);
    terminal = true;
    return null;
  }

  private Boolean visitRules(ArrayList<Rule> rules)
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
