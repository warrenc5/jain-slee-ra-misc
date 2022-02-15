/* -----------------------------------------------------------------------------
 * Displayer.java
 * -----------------------------------------------------------------------------
 *
 * Producer : com.parse2.aparse.Parser 2.2
 * Produced : Sun Sep 02 12:31:43 WAT 2012
 *
 * -----------------------------------------------------------------------------
 */

package test;

import java.util.ArrayList;

public class Displayer implements Visitor
{

  public Object visit(Rule$transactionResponseAck rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$transactionAck rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$TransactionID rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$UINT32 rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$DIGIT rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$COMMA rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule$ResponseAckToken rule)
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
