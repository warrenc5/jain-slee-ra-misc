/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mofokom.xmlrpc.test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import xmlrpc.MethodCall;

/**
 *
 * @author wozza
 */
public class XMLRPCValidatingServlet extends HttpServlet {

    Logger log = Logger.getLogger(this.getClass().getSimpleName());
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void service(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        log.info("Field request from " + request.getRemoteAddr() + " " + request.getContentType() + " " + request.getHeader("Content-Length"));
        try {
            InputStream in = request.getInputStream();

            int i = in.read();

            if (in.available() <= 0) {
                throw new Exception("no content posted");
            }

            ByteArrayOutputStream baos = new ByteArrayOutputStream(2048);

            baos.write(i);
            
            int p=0;
            byte buf[] = new byte[256];


            while(in.available() > 0) {
                log.info("available " + in.available());
                p=in.read(buf);
                if (p>0)
                    baos.write(buf, 0, p);
            }

            log.info("content:" + new String(baos.toByteArray()) + ":" + baos.toByteArray().length);

            in.close();
            in = new ByteArrayInputStream(baos.toByteArray());

            JAXBContext context = JAXBContext.newInstance(MethodCall.class.getPackage().getName(),this.getClass().getClassLoader());
            Unmarshaller m = context.createUnmarshaller();
            MethodCall mc = (MethodCall) m.unmarshal(in);
            
            log.info("unmarshalled to " + mc.toString());

            String s = "<?xml version=\"1.0\" encoding=\"utf-8\"?> <methodResponse> <params> <param> <value> <struct> <member> <name>accumulatorInformation</name> <value> <array> <data> <value> <struct> <member> <name>accumulatorEndDate</name> <value><dateTime.iso8601>20101101T12:00:00+0000</dateTime.iso8601></value> </member> <member> <name>accumulatorID</name> <value><i4>1</i4></value> </member> <member> <name>accumulatorStartDate</name> <value><dateTime.iso8601>20101001T12:00:00+0000</dateTime.iso8601></value> </member> <member> <name>accumulatorValue</name> <value><i4>0</i4></value> </member> </struct> </value> <value> <struct> <member> <name>accumulatorEndDate</name> <value><dateTime.iso8601>20101101T12:00:00+0000</dateTime.iso8601></value> </member> <member> <name>accumulatorID</name> <value><i4>2</i4></value> </member> <member> <name>accumulatorStartDate</name> <value><dateTime.iso8601>20101001T12:00:00+0000</dateTime.iso8601></value> </member> <member> <name>accumulatorValue</name> <value><i4>0</i4></value> </member> </struct> </value> <value> <struct> <member> <name>accumulatorEndDate</name> <value><dateTime.iso8601>20150816T12:00:00+0000</dateTime.iso8601></value> </member> <member> <name>accumulatorID</name> <value><i4>3</i4></value> </member> <member> <name>accumulatorStartDate</name> <value><dateTime.iso8601>20100816T12:00:00+0000</dateTime.iso8601></value> </member> <member> <name>accumulatorValue</name> <value><i4>0</i4></value> </member> </struct> </value> </data> </array> </value> </member> <member> <name>languageIDCurrent</name> <value><i4>2</i4></value> </member> <member> <name>originTransactionID</name> <value><string>1234</string></value> </member> <member> <name>responseCode</name> <value><i4>0</i4></value> </member> <member> <name>serviceClassCurrent</name> <value><i4>61</i4></value> </member> <member> <name>temporaryBlockedFlag</name> <value><boolean>1</boolean></value> </member> </struct> </value> </param> </params> </methodResponse>";

            log.info("result " + s);
            response.getOutputStream().write(s.getBytes());
            response.getOutputStream().close();

        } catch (Exception ex) {
            Logger.getLogger(XMLRPCValidatingServlet.class.getName()).log(Level.SEVERE, null, ex);
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    } 

    @Override
    public String getServletInfo() {
        return "Validating XmlRpc Servlet";
    }
}