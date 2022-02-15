/* -----------------------------------------------------------------------------
 * Visitor.java
 * -----------------------------------------------------------------------------
 *
 * Producer : com.parse2.aparse.Parser 2.2
 * Produced : Sun Sep 02 12:31:43 WAT 2012
 *
 * -----------------------------------------------------------------------------
 */

package test;

public interface Visitor
{
  public Object visit(Rule$transactionResponseAck rule);
  public Object visit(Rule$transactionAck rule);
  public Object visit(Rule$TransactionID rule);
  public Object visit(Rule$UINT32 rule);
  public Object visit(Rule$DIGIT rule);
  public Object visit(Rule$COMMA rule);
  public Object visit(Rule$ResponseAckToken rule);
  public Object visit(Rule$LBRKT rule);
  public Object visit(Rule$RBRKT rule);

  public Object visit(Terminal$StringValue value);
  public Object visit(Terminal$NumericValue value);
}

/* -----------------------------------------------------------------------------
 * eof
 * -----------------------------------------------------------------------------
 */
