/* -----------------------------------------------------------------------------
 * XmlDisplayer.java
 * -----------------------------------------------------------------------------
 *
 * Producer : com.parse2.aparse.Parser 2.2
 * Produced : Sun Sep 02 12:31:43 WAT 2012
 *
 * -----------------------------------------------------------------------------
 */

package test;

import java.util.ArrayList;

public class XmlDisplayer implements Visitor
{
  private boolean terminal = true;

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
