/* -----------------------------------------------------------------------------
 * Rule$digitMapRange.java
 * -----------------------------------------------------------------------------
 *
 * Producer : com.parse2.aparse.Parser 2.2
 * Produced : Tue Aug 14 12:33:41 WAT 2012
 *
 * -----------------------------------------------------------------------------
 */

package mofokom.megaco.resource.impl.codec.abnf;

import java.util.ArrayList;

final public class Rule$digitMapRange extends Rule
{
  private Rule$digitMapRange(String spelling, ArrayList<Rule> rules)
  {
    super(spelling, rules);
  }

  public Object accept(Visitor visitor)
  {
    return visitor.visit(this);
  }

  public static Rule$digitMapRange parse(ParserContext context)
  {
    context.push("digitMapRange");

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
            int g1 = context.index;
            parsed = false;
            if (!parsed)
            {
              {
                ArrayList<Rule> e2 = new ArrayList<Rule>();
                int s2 = context.index;
                parsed = true;
                if (parsed)
                {
                  boolean f2 = true;
                  int c2 = 0;
                  for (int i2 = 0; i2 < 1 && f2; i2++)
                  {
                    rule = Terminal$StringValue.parse(context, "x");
                    if ((f2 = rule != null))
                    {
                      e2.add(rule);
                      c2++;
                    }
                  }
                  parsed = c2 == 1;
                }
                if (parsed)
                  e1.addAll(e2);
                else
                  context.index = s2;
              }
            }
            if (!parsed)
            {
              {
                ArrayList<Rule> e2 = new ArrayList<Rule>();
                int s2 = context.index;
                parsed = true;
                if (parsed)
                {
                  boolean f2 = true;
                  int c2 = 0;
                  for (int i2 = 0; i2 < 1 && f2; i2++)
                  {
                    int g2 = context.index;
                    parsed = false;
                    if (!parsed)
                    {
                      {
                        ArrayList<Rule> e3 = new ArrayList<Rule>();
                        int s3 = context.index;
                        parsed = true;
                        if (parsed)
                        {
                          boolean f3 = true;
                          int c3 = 0;
                          for (int i3 = 0; i3 < 1 && f3; i3++)
                          {
                            rule = Rule$LWSP.parse(context);
                            if ((f3 = rule != null))
                            {
                              e3.add(rule);
                              c3++;
                            }
                          }
                          parsed = c3 == 1;
                        }
                        if (parsed)
                        {
                          boolean f3 = true;
                          int c3 = 0;
                          for (int i3 = 0; i3 < 1 && f3; i3++)
                          {
                            rule = Terminal$StringValue.parse(context, "[");
                            if ((f3 = rule != null))
                            {
                              e3.add(rule);
                              c3++;
                            }
                          }
                          parsed = c3 == 1;
                        }
                        if (parsed)
                        {
                          boolean f3 = true;
                          int c3 = 0;
                          for (int i3 = 0; i3 < 1 && f3; i3++)
                          {
                            rule = Rule$LWSP.parse(context);
                            if ((f3 = rule != null))
                            {
                              e3.add(rule);
                              c3++;
                            }
                          }
                          parsed = c3 == 1;
                        }
                        if (parsed)
                        {
                          boolean f3 = true;
                          int c3 = 0;
                          for (int i3 = 0; i3 < 1 && f3; i3++)
                          {
                            rule = Rule$digitLetter.parse(context);
                            if ((f3 = rule != null))
                            {
                              e3.add(rule);
                              c3++;
                            }
                          }
                          parsed = c3 == 1;
                        }
                        if (parsed)
                        {
                          boolean f3 = true;
                          int c3 = 0;
                          for (int i3 = 0; i3 < 1 && f3; i3++)
                          {
                            rule = Rule$LWSP.parse(context);
                            if ((f3 = rule != null))
                            {
                              e3.add(rule);
                              c3++;
                            }
                          }
                          parsed = c3 == 1;
                        }
                        if (parsed)
                        {
                          boolean f3 = true;
                          int c3 = 0;
                          for (int i3 = 0; i3 < 1 && f3; i3++)
                          {
                            rule = Terminal$StringValue.parse(context, "]");
                            if ((f3 = rule != null))
                            {
                              e3.add(rule);
                              c3++;
                            }
                          }
                          parsed = c3 == 1;
                        }
                        if (parsed)
                        {
                          boolean f3 = true;
                          int c3 = 0;
                          for (int i3 = 0; i3 < 1 && f3; i3++)
                          {
                            rule = Rule$LWSP.parse(context);
                            if ((f3 = rule != null))
                            {
                              e3.add(rule);
                              c3++;
                            }
                          }
                          parsed = c3 == 1;
                        }
                        if (parsed)
                          e2.addAll(e3);
                        else
                          context.index = s3;
                      }
                    }
                    if (context.index > g2) c2++;
                    f2 = c2 > i2;
                  }
                  parsed = c2 == 1;
                }
                if (parsed)
                  e1.addAll(e2);
                else
                  context.index = s2;
              }
            }
            if (context.index > g1) c1++;
            f1 = c1 > i1;
          }
          parsed = c1 == 1;
        }
        if (parsed)
          e0.addAll(e1);
        else
          context.index = s1;
      }
    }

    rule = null;
    if (parsed)
      rule = new Rule$digitMapRange(context.text.substring(s0, context.index), e0);
    else
      context.index = s0;

    context.pop("digitMapRange", parsed);

    return (Rule$digitMapRange)rule;
  }
}

/* -----------------------------------------------------------------------------
 * eof
 * -----------------------------------------------------------------------------
 */
