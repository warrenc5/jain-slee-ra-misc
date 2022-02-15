/* -----------------------------------------------------------------------------
 * Terminal$StringValue.java
 * -----------------------------------------------------------------------------
 *
 * Producer : com.parse2.aparse.Parser 2.2
 * Produced : Tue Aug 14 12:33:41 WAT 2012
 *
 * -----------------------------------------------------------------------------
 */

package mofokom.megaco.resource.impl.codec.abnf;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class Terminal$StringValue extends Rule
{
  private Terminal$StringValue(String spelling, ArrayList<Rule> rules)
  {
    super(spelling, rules);
  }

  static Pattern name = Pattern.compile("[a-wA-Wy-zY-Z]+");
  public static Terminal$StringValue parse(
    ParserContext context, 
    String regex)
  {
    context.push("StringValue", regex);

    boolean parsed = true;

    Terminal$StringValue stringValue = null;
    try
    {
      String value = 
        context.text.substring(
          context.index, 
          context.index + regex.length());
      //System.out.println("" + regex +  " "  + context.text.charAt(context.index + regex.length()) + " " + value);
        if(name.matcher(regex).matches() && name.matcher(String.valueOf(context.text.charAt(context.index + regex.length()))).matches()) {
            return null;
        }
      
      if ((parsed = value.equalsIgnoreCase(regex)))
      {
        context.index += regex.length();
        stringValue = new Terminal$StringValue(value, null);
      }
    }
    catch (IndexOutOfBoundsException e) {parsed = false;}

    context.pop("StringValue", parsed);

    return stringValue;
  }

  public Object accept(Visitor visitor)
  {
    return visitor.visit(this);
  }
}
/* -----------------------------------------------------------------------------
 * eof
 * -----------------------------------------------------------------------------
 */
