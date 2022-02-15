/* -----------------------------------------------------------------------------
 * XmlDisplayer.java
 * -----------------------------------------------------------------------------
 *
 * Producer : com.parse2.aparse.Parser 2.2
 * Produced : Tue Aug 14 12:33:41 WAT 2012
 *
 * -----------------------------------------------------------------------------
 */

package mofokom.megaco.resource.impl.codec.abnf;

import java.util.ArrayList;

public class XmlDisplayer implements Visitor
{
  private boolean terminal = true;

  public Object visit(Rule$megacoMessage rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<megacoMessage>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</megacoMessage>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$authenticationHeader rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<authenticationHeader>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</authenticationHeader>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$SecurityParmIndex rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<SecurityParmIndex>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</SecurityParmIndex>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$SequenceNum rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<SequenceNum>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</SequenceNum>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$AuthData rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<AuthData>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</AuthData>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$message rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<message>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</message>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$messageBody rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<messageBody>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</messageBody>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$transactionList rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<transactionList>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</transactionList>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$transactionPending rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<transactionPending>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</transactionPending>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$transactionResponseAck rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<transactionResponseAck>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</transactionResponseAck>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$transactionAck rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<transactionAck>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</transactionAck>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$transactionRequest rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<transactionRequest>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</transactionRequest>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$actionRequest rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<actionRequest>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</actionRequest>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$contextRequest rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<contextRequest>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</contextRequest>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$contextProperties rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<contextProperties>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</contextProperties>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$contextProperty rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<contextProperty>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</contextProperty>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$contextAudit rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<contextAudit>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</contextAudit>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$contextAuditProperties rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<contextAuditProperties>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</contextAuditProperties>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$commandRequestList rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<commandRequestList>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</commandRequestList>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$commandRequest rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<commandRequest>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</commandRequest>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$transactionReply rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<transactionReply>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</transactionReply>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$actionReplyList rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<actionReplyList>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</actionReplyList>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$actionReply rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<actionReply>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</actionReply>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$commandReply rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<commandReply>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</commandReply>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$commandReplyList rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<commandReplyList>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</commandReplyList>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$commandReplys rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<commandReplys>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</commandReplys>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$ammRequest rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<ammRequest>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</ammRequest>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$ammParameter rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<ammParameter>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</ammParameter>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$ammsReply rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<ammsReply>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</ammsReply>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$subtractRequest rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<subtractRequest>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</subtractRequest>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$auditRequest rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<auditRequest>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</auditRequest>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$auditReply rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<auditReply>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</auditReply>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$auditOther rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<auditOther>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</auditOther>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$terminationAudit rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<terminationAudit>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</terminationAudit>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$contextTerminationAudit rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<contextTerminationAudit>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</contextTerminationAudit>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$auditReturnParameter rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<auditReturnParameter>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</auditReturnParameter>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$auditDescriptor rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<auditDescriptor>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</auditDescriptor>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$notifyRequest rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<notifyRequest>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</notifyRequest>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$notifyReply rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<notifyReply>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</notifyReply>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$serviceChangeRequest rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<serviceChangeRequest>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</serviceChangeRequest>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$serviceChangeReply rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<serviceChangeReply>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</serviceChangeReply>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$errorDescriptor rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<errorDescriptor>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</errorDescriptor>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$ErrorCode rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<ErrorCode>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</ErrorCode>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$TransactionID rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<TransactionID>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</TransactionID>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$mId rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<mId>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</mId>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$domainName rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<domainName>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</domainName>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$deviceName rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<deviceName>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</deviceName>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$ContextID rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<ContextID>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</ContextID>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$domainAddress rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<domainAddress>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</domainAddress>");
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

  public Object visit(Rule$V4hex rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<V4hex>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</V4hex>");
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

  public Object visit(Rule$mtpAddress rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<mtpAddress>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</mtpAddress>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$terminationIDList rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<terminationIDList>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</terminationIDList>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$pathNAME rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<pathNAME>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</pathNAME>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$pathDomainName rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<pathDomainName>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</pathDomainName>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$TerminationID rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<TerminationID>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</TerminationID>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$mediaDescriptor rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<mediaDescriptor>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</mediaDescriptor>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$mediaParm rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<mediaParm>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</mediaParm>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$streamParm rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<streamParm>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</streamParm>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$streamDescriptor rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<streamDescriptor>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</streamDescriptor>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$localControlDescriptor rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<localControlDescriptor>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</localControlDescriptor>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$localParm rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<localParm>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</localParm>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$reservedValueMode rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<reservedValueMode>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</reservedValueMode>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$reservedGroupMode rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<reservedGroupMode>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</reservedGroupMode>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$streamMode rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<streamMode>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</streamMode>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$streamModes rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<streamModes>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</streamModes>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$propertyParm rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<propertyParm>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</propertyParm>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$parmValue rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<parmValue>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</parmValue>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$alternativeValue rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<alternativeValue>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</alternativeValue>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$INEQUAL rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<INEQUAL>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</INEQUAL>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$LSBRKT rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<LSBRKT>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</LSBRKT>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$RSBRKT rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<RSBRKT>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</RSBRKT>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$localDescriptor rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<localDescriptor>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</localDescriptor>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$remoteDescriptor rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<remoteDescriptor>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</remoteDescriptor>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$eventBufferDescriptor rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<eventBufferDescriptor>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</eventBufferDescriptor>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$eventSpec rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<eventSpec>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</eventSpec>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$eventSpecParameter rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<eventSpecParameter>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</eventSpecParameter>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$eventBufferControl rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<eventBufferControl>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</eventBufferControl>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$terminationStateDescriptor rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<terminationStateDescriptor>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</terminationStateDescriptor>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$terminationStateParm rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<terminationStateParm>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</terminationStateParm>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$serviceStates rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<serviceStates>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</serviceStates>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$muxDescriptor rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<muxDescriptor>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</muxDescriptor>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$MuxType rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<MuxType>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</MuxType>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$StreamID rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<StreamID>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</StreamID>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$pkgdName rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<pkgdName>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</pkgdName>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$PackageName rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<PackageName>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</PackageName>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$ItemID rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<ItemID>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</ItemID>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$eventsDescriptor rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<eventsDescriptor>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</eventsDescriptor>");
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

  public Object visit(Rule$embedWithSig rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<embedWithSig>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</embedWithSig>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$embedNoSig rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<embedNoSig>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</embedNoSig>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$embedFirst rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<embedFirst>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</embedFirst>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$secondRequestedEvent rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<secondRequestedEvent>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</secondRequestedEvent>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$secondEventParameter rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<secondEventParameter>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</secondEventParameter>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$embedSig rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<embedSig>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</embedSig>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$eventStream rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<eventStream>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</eventStream>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$eventOther rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<eventOther>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</eventOther>");
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

  public Object visit(Rule$eventDM rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<eventDM>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</eventDM>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$signalsDescriptor rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<signalsDescriptor>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</signalsDescriptor>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$signalParm rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<signalParm>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</signalParm>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$signalRequest rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<signalRequest>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</signalRequest>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$signalList rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<signalList>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</signalList>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$signalListId rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<signalListId>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</signalListId>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$signalListParm rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<signalListParm>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</signalListParm>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$signalName rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<signalName>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</signalName>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$sigParameter rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<sigParameter>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</sigParameter>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$sigStream rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<sigStream>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</sigStream>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$sigOther rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<sigOther>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</sigOther>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$sigParameterName rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<sigParameterName>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</sigParameterName>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$sigSignalType rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<sigSignalType>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</sigSignalType>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$signalType rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<signalType>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</signalType>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$sigDuration rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<sigDuration>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</sigDuration>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$notifyCompletion rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<notifyCompletion>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</notifyCompletion>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$notificationReason rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<notificationReason>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</notificationReason>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$observedEventsDescriptor rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<observedEventsDescriptor>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</observedEventsDescriptor>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$observedEvent rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<observedEvent>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</observedEvent>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$observedEventParameter rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<observedEventParameter>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</observedEventParameter>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$RequestID rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<RequestID>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</RequestID>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$modemDescriptor rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<modemDescriptor>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</modemDescriptor>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$modemType rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<modemType>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</modemType>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$digitMapDescriptor rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<digitMapDescriptor>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</digitMapDescriptor>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$digitMapName rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<digitMapName>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</digitMapName>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$digitMapValue rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<digitMapValue>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</digitMapValue>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$Timer rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<Timer>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</Timer>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$digitMap rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<digitMap>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</digitMap>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$digitStringList rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<digitStringList>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</digitStringList>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$digitString rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<digitString>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</digitString>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$digitStringElement rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<digitStringElement>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</digitStringElement>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$digitPosition rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<digitPosition>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</digitPosition>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$digitMapRange rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<digitMapRange>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</digitMapRange>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$digitLetter rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<digitLetter>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</digitLetter>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$digitMapLetter rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<digitMapLetter>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</digitMapLetter>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$auditItem rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<auditItem>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</auditItem>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$serviceChangeDescriptor rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<serviceChangeDescriptor>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</serviceChangeDescriptor>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$serviceChangeParm rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<serviceChangeParm>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</serviceChangeParm>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$serviceChangeReplyDescriptor rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<serviceChangeReplyDescriptor>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</serviceChangeReplyDescriptor>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$servChgReplyParm rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<servChgReplyParm>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</servChgReplyParm>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$serviceChangeMethod rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<serviceChangeMethod>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</serviceChangeMethod>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$serviceChangeReason rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<serviceChangeReason>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</serviceChangeReason>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$serviceChangeDelay rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<serviceChangeDelay>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</serviceChangeDelay>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$serviceChangeAddress rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<serviceChangeAddress>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</serviceChangeAddress>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$serviceChangeMgcId rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<serviceChangeMgcId>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</serviceChangeMgcId>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$serviceChangeProfile rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<serviceChangeProfile>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</serviceChangeProfile>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$serviceChangeVersion rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<serviceChangeVersion>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</serviceChangeVersion>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$extension rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<extension>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</extension>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$packagesDescriptor rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<packagesDescriptor>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</packagesDescriptor>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$Version rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<Version>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</Version>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$packagesItem rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<packagesItem>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</packagesItem>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$TimeStamp rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<TimeStamp>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</TimeStamp>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$Date rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<Date>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</Date>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$Time rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<Time>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</Time>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$statisticsDescriptor rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<statisticsDescriptor>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</statisticsDescriptor>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$statisticsParameter rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<statisticsParameter>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</statisticsParameter>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$topologyDescriptor rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<topologyDescriptor>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</topologyDescriptor>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$topologyTriple rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<topologyTriple>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</topologyTriple>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$terminationA rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<terminationA>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</terminationA>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$terminationB rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<terminationB>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</terminationB>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$topologyDirection rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<topologyDirection>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</topologyDirection>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$priority rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<priority>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</priority>");
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

  public Object visit(Rule$octetString rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<octetString>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</octetString>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$nonEscapeChar rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<nonEscapeChar>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</nonEscapeChar>");
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

  public Object visit(Rule$AddToken rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<AddToken>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</AddToken>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$AuditToken rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<AuditToken>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</AuditToken>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$AuditCapToken rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<AuditCapToken>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</AuditCapToken>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$AuditValueToken rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<AuditValueToken>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</AuditValueToken>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$AuthToken rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<AuthToken>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</AuthToken>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$BothwayToken rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<BothwayToken>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</BothwayToken>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$BriefToken rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<BriefToken>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</BriefToken>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$BufferToken rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<BufferToken>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</BufferToken>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$CtxToken rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<CtxToken>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</CtxToken>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$ContextAuditToken rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<ContextAuditToken>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</ContextAuditToken>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$DigitMapToken rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<DigitMapToken>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</DigitMapToken>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$DisconnectedToken rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<DisconnectedToken>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</DisconnectedToken>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$DelayToken rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<DelayToken>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</DelayToken>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$DurationToken rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<DurationToken>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</DurationToken>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$EmbedToken rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<EmbedToken>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</EmbedToken>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$EmergencyToken rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<EmergencyToken>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</EmergencyToken>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$ErrorToken rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<ErrorToken>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</ErrorToken>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$EventBufferToken rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<EventBufferToken>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</EventBufferToken>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$EventsToken rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<EventsToken>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</EventsToken>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$FailoverToken rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<FailoverToken>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</FailoverToken>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$ForcedToken rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<ForcedToken>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</ForcedToken>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$GracefulToken rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<GracefulToken>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</GracefulToken>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$H221Token rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<H221Token>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</H221Token>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$H223Token rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<H223Token>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</H223Token>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$H226Token rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<H226Token>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</H226Token>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$HandOffToken rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<HandOffToken>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</HandOffToken>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$ImmAckRequiredToken rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<ImmAckRequiredToken>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</ImmAckRequiredToken>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$InactiveToken rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<InactiveToken>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</InactiveToken>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$IsolateToken rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<IsolateToken>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</IsolateToken>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$InSvcToken rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<InSvcToken>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</InSvcToken>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$InterruptByEventToken rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<InterruptByEventToken>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</InterruptByEventToken>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$InterruptByNewSignalsDescrToken rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<InterruptByNewSignalsDescrToken>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</InterruptByNewSignalsDescrToken>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$KeepActiveToken rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<KeepActiveToken>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</KeepActiveToken>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$LocalToken rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<LocalToken>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</LocalToken>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$LocalControlToken rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<LocalControlToken>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</LocalControlToken>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$LockStepToken rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<LockStepToken>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</LockStepToken>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$LoopbackToken rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<LoopbackToken>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</LoopbackToken>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$MediaToken rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<MediaToken>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</MediaToken>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$MegacopToken rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<MegacopToken>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</MegacopToken>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$MethodToken rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<MethodToken>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</MethodToken>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$MgcIdToken rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<MgcIdToken>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</MgcIdToken>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$ModeToken rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<ModeToken>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</ModeToken>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$ModifyToken rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<ModifyToken>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</ModifyToken>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$ModemToken rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<ModemToken>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</ModemToken>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$MoveToken rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<MoveToken>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</MoveToken>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$MTPToken rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<MTPToken>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</MTPToken>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$MuxToken rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<MuxToken>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</MuxToken>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$NotifyToken rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<NotifyToken>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</NotifyToken>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$NotifyCompletionToken rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<NotifyCompletionToken>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</NotifyCompletionToken>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$ObservedEventsToken rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<ObservedEventsToken>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</ObservedEventsToken>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$OnewayToken rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<OnewayToken>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</OnewayToken>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$OnOffToken rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<OnOffToken>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</OnOffToken>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$OtherReasonToken rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<OtherReasonToken>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</OtherReasonToken>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$OutOfSvcToken rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<OutOfSvcToken>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</OutOfSvcToken>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$PackagesToken rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<PackagesToken>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</PackagesToken>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$PendingToken rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<PendingToken>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</PendingToken>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$PriorityToken rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<PriorityToken>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</PriorityToken>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$ProfileToken rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<ProfileToken>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</ProfileToken>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$ReasonToken rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<ReasonToken>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</ReasonToken>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$RecvonlyToken rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<RecvonlyToken>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</RecvonlyToken>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$ReplyToken rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<ReplyToken>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</ReplyToken>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$RestartToken rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<RestartToken>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</RestartToken>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$RemoteToken rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<RemoteToken>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</RemoteToken>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$ReservedGroupToken rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<ReservedGroupToken>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</ReservedGroupToken>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$ReservedValueToken rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<ReservedValueToken>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</ReservedValueToken>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$SendonlyToken rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<SendonlyToken>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</SendonlyToken>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$SendrecvToken rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<SendrecvToken>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</SendrecvToken>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$ServicesToken rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<ServicesToken>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</ServicesToken>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$ServiceStatesToken rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<ServiceStatesToken>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</ServiceStatesToken>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$ServiceChangeToken rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<ServiceChangeToken>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</ServiceChangeToken>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$ServiceChangeAddressToken rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<ServiceChangeAddressToken>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</ServiceChangeAddressToken>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$SignalListToken rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<SignalListToken>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</SignalListToken>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$SignalsToken rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<SignalsToken>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</SignalsToken>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$SignalTypeToken rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<SignalTypeToken>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</SignalTypeToken>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$StatsToken rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<StatsToken>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</StatsToken>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$StreamToken rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<StreamToken>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</StreamToken>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$SubtractToken rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<SubtractToken>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</SubtractToken>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$SynchISDNToken rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<SynchISDNToken>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</SynchISDNToken>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$TerminationStateToken rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<TerminationStateToken>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</TerminationStateToken>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$TestToken rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<TestToken>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</TestToken>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$TimeOutToken rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<TimeOutToken>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</TimeOutToken>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$TopologyToken rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<TopologyToken>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</TopologyToken>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$TransToken rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<TransToken>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</TransToken>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$ResponseAckToken rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<ResponseAckToken>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</ResponseAckToken>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$V18Token rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<V18Token>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</V18Token>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$V22Token rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<V22Token>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</V22Token>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$V22bisToken rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<V22bisToken>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</V22bisToken>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$V32Token rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<V32Token>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</V32Token>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$V32bisToken rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<V32bisToken>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</V32bisToken>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$V34Token rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<V34Token>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</V34Token>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$V76Token rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<V76Token>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</V76Token>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$V90Token rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<V90Token>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</V90Token>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$V91Token rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<V91Token>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</V91Token>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$VersionToken rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<VersionToken>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</VersionToken>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$CommandOptionalToken rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<CommandOptionalToken>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</CommandOptionalToken>");
    terminal = false;
    return null;
  }

  public Object visit(Rule$CommandWildcardToken rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<CommandWildcardToken>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</CommandWildcardToken>");
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
