/* -----------------------------------------------------------------------------
 * Visitor.java
 * -----------------------------------------------------------------------------
 *
 * Producer : com.parse2.aparse.Parser 2.2
 * Produced : Tue Sep 18 09:10:43 WAT 2012
 *
 * -----------------------------------------------------------------------------
 */

package test2;

public interface Visitor
{
  public Object visit(Rule$digitMap rule);
  public Object visit(Rule$digitStringList rule);
  public Object visit(Rule$digitString rule);
  public Object visit(Rule$digitStringElement rule);
  public Object visit(Rule$digitPosition rule);
  public Object visit(Rule$digitMapRange rule);
  public Object visit(Rule$digitLetter rule);
  public Object visit(Rule$digitMapLetter rule);
  public Object visit(Rule$DOT rule);
  public Object visit(Rule$LWSP rule);
  public Object visit(Rule$EOL rule);
  public Object visit(Rule$WSP rule);
  public Object visit(Rule$SEP rule);
  public Object visit(Rule$COMMENT rule);
  public Object visit(Rule$SP rule);
  public Object visit(Rule$HTAB rule);
  public Object visit(Rule$CR rule);
  public Object visit(Rule$LF rule);
  public Object visit(Rule$ALPHA rule);
  public Object visit(Rule$DIGIT rule);

  public Object visit(Terminal$StringValue value);
  public Object visit(Terminal$NumericValue value);
}

/* -----------------------------------------------------------------------------
 * eof
 * -----------------------------------------------------------------------------
 */
