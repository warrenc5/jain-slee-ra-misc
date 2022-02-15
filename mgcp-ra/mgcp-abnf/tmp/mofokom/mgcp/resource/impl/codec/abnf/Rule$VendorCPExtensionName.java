/* -----------------------------------------------------------------------------
 * Rule$VendorCPExtensionName.java
 * -----------------------------------------------------------------------------
 *
 * Producer : com.parse2.aparse.Parser 2.2
 * Produced : Sun Sep 23 12:29:38 WAT 2012
 *
 * -----------------------------------------------------------------------------
 */

package mofokom.mgcp.resource.impl.codec.abnf;

import java.util.ArrayList;

final public class Rule$VendorCPExtensionName extends Rule
{
  private Rule$VendorCPExtensionName(String spelling, ArrayList<Rule> rules)
  {
    super(spelling, rules);
  }

  public Object accept(Visitor visitor)
  {
    return visitor.visit(this);
  }

  public static Rule$VendorCPExtensionName parse(ParserContext context)
  {
    context.push("VendorCPExtensionName");

    boolean parsed = true;
    int s0 = context.index;
    ArrayList<Rule> e0 = new ArrayList<Rule>();
    Rule rule;

    parsed = false;
    if (!parsed)
    {
      {
        ArrayList<Rule> e1 = new ArrayList<Rule>();
        int s1 = context.index;
        parsed = true;
        if (parsed)
        {
          boolean f1 = true;
          int c1 = 0;
          for (int i1 = 0; i1 < 1 && f1; i1++)
          {
            rule = Terminal$StringValue.parse(context, "X");
            if ((f1 = rule != null))
            {
              e1.add(rule);
              c1++;
            }
          }
          parsed = c1 == 1;
        }
        if (parsed)
        {
          boolean f1 = true;
          int c1 = 0;
          for (int i1 = 0; i1 < 1 && f1; i1++)
          {
            rule = Terminal$StringValue.parse(context, "-");
            if ((f1 = rule != null))
            {
              e1.add(rule);
              c1++;
            }
          }
          parsed = c1 == 1;
        }
        if (parsed)
        {
          boolean f1 = true;
          int c1 = 0;
          for (int i1 = 0; i1 < 2 && f1; i1++)
          {
            rule = Rule$ALPHA.parse(context);
            if ((f1 = rule != null))
            {
              e1.add(rule);
              c1++;
            }
          }
          for (int i1 = 0; f1; i1++)
          {
            rule = Rule$ALPHA.parse(context);
            if ((f1 = rule != null))
            {
              e1.add(rule);
              c1++;
            }
          }
          parsed = c1 >= 2;
        }
        if (parsed)
          e0.addAll(e1);
        else
          context.index = s1;
      }
    }

    rule = null;
    if (parsed)
      rule = new Rule$VendorCPExtensionName(context.text.substring(s0, context.index), e0);
    else
      context.index = s0;

    context.pop("VendorCPExtensionName", parsed);

    return (Rule$VendorCPExtensionName)rule;
  }
}

/* -----------------------------------------------------------------------------
 * eof
 * -----------------------------------------------------------------------------
 */
