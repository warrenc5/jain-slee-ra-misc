/* -----------------------------------------------------------------------------
 * Displayer.java
 * -----------------------------------------------------------------------------
 *
 * Producer : com.parse2.aparse.Parser 2.2
 * Produced : Tue Sep 18 09:10:43 WAT 2012
 *
 * -----------------------------------------------------------------------------
 */

package test2;

import java.util.ArrayList;

public class Displayer implements Visitor
{

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

  public Object visit(Rule$DOT rule)
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

  public Object visit(Rule$ALPHA rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$DIGIT rule)
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
