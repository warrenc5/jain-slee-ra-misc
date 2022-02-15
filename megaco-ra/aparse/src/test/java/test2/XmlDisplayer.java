/* -----------------------------------------------------------------------------
 * XmlDisplayer.java
 * -----------------------------------------------------------------------------
 *
 * Producer : com.parse2.aparse.Parser 2.2
 * Produced : Tue Sep 18 09:10:43 WAT 2012
 *
 * -----------------------------------------------------------------------------
 */

package test2;

import java.util.ArrayList;

public class XmlDisplayer implements Visitor
{
  private boolean terminal = true;

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
