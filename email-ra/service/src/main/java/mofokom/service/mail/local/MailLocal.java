/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mofokom.service.mail.local;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import javax.mail.MessagingException;
import javax.mail.Part;
import javax.mail.internet.MimeMessage;
import javax.slee.SbbLocalObject;

/**
 *
 * @author wozza
 */
public interface MailLocal extends SbbLocalObject{

    public MimeMessage sendEmail(String to, String from,String subject, String text) throws MessagingException, IOException;

    public MimeMessage sendMultipartEmail(String to, String from, String subject, List<Part> parts) throws MessagingException, IOException ,URISyntaxException ;

}