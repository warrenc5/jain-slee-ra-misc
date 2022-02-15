

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.*;
import java.util.Stack;
import junit.framework.Assert;
import mofokom.megaco.resource.impl.codec.AbstractDefaultVisitor;
import mofokom.megaco.resource.impl.codec.RecursiveVisitorWrapper;
import mofokom.megaco.resource.impl.codec.abnf.*;
import org.apache.log4j.Logger;
import static org.junit.Assert.*;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author wozza
 */
public class SampleFileParserTest {

    private AbstractDefaultVisitor v;
    Logger logger = Logger.getLogger("ParseTest");

    public SampleFileParserTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Test
    public void testSampleFiles() throws FileNotFoundException, IOException, Exception {
        File dir = new File("/code/ra/megaco-ra/ra/src/test/resources/data/");
        assertTrue(dir.isDirectory());
        v = new AbstractDefaultVisitor();
        v.init();
        for (File f : dir.listFiles()) {
            //read file
            assertTrue(f.length() > 0);
            InputStream r = new FileInputStream(f);
            ByteArrayOutputStream baos = new ByteArrayOutputStream((int) f.length());
            //feed to decoder
            while (r.available() > 0) {
                byte[] b = new byte[r.available()];
                int p = r.read(b);
                baos.write(b, 0, p);
            }

            try {
                System.out.println("==" + new String(baos.toByteArray()));
                ParserContext context = new ParserContext(new String(baos.toByteArray()), false);
                Rule rule = Rule$megacoMessage.parse(context);
                checkError(context);

                Object o = rule.accept(new RecursiveVisitorWrapper(v, logger));
                System.out.println("+++++" + f.getName());

                v.reset();

            } catch (ParserException x) {
                System.out.println("-----" + f.getName() + " " + x.getMessage());
                Assert.fail();
            }


            //break;
        }
    }

    boolean checkError(ParserContext context) throws ParserException {

        if (context.text.length() > context.index) {
            ParserException primaryError =
                    new ParserException(
                    "extra data found",
                    context.text,
                    context.index,
                    new Stack<String>());

            if (context.getErrorIndex() > context.index) {
                ParserException secondaryError =
                        new ParserException(
                        "rule \"" + (String) context.getErrorStack().peek() + "\" failed",
                        context.text,
                        context.getErrorIndex(),
                        context.getErrorStack());

                primaryError.initCause(secondaryError);
            }

            throw primaryError;
        }
        return true;
    }
}
