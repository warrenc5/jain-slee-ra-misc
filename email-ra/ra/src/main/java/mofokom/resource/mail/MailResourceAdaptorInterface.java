/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mofokom.resource.mail;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import javax.mail.Address;
import javax.mail.Folder;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.Transport;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 *
 * @author wozza
 */
public interface MailResourceAdaptorInterface {

    /**
     * Initializes a Store from the entity configuration and registers it with the SLEE.
     * @param protocol - one of pop3 pop3s imap imaps
     * @return The registered Store.
     * @throws NoSuchProviderException
     */
    public Store getStore(String protocol) throws NoSuchProviderException;
    /**
     *
     * Initializes a store from the entity configuration and registers it with the slee.
     * @return The registered Store.
     * @throws NoSuchProviderException
     */
    public Store getStore() throws NoSuchProviderException;

    /**
     * Gets a non default session.
     * @return
     */

    public Session getSession();
    /**
     *
     * Initializes a Transport from the entity configuration and registers it with the SLEE.
     *
     *
     * @return
     * @throws NoSuchProviderException
     */
    public Transport getTransport() throws NoSuchProviderException;
    /**
     *
     * Initializes a Transport from the entity configuration and registers it with the SLEE.
     *
     * @param protocol either smtp or smtps
     * @return
     * @throws NoSuchProviderException
     */
    public Transport getTransport(String protocol) throws NoSuchProviderException;
    /**
     *
     * Opens a folder on the default store and registers it with the SLEE.
     *
     * @param name
     * @return
     * @throws NoSuchProviderException
     * @throws MessagingException
     */
    public Folder getFolder(String name) throws NoSuchProviderException, MessagingException ;
    /**
     *
     * Opens the defalut folder on the default store and registers it with the SLEE.
     *
     * @return
     * @throws NoSuchProviderException
     * @throws MessagingException
     */
    public Folder getDefaultFolder() throws NoSuchProviderException, MessagingException ;
    /**
     *
     * Sends a message on the default Transport with calling save changes.
     *
     * @param message
     * @return
     * @throws IOException
     */
    public MailActivity send(MimeMessage message) throws MessagingException,IOException;
    /**
     *
     * Sends a message on the given Transport without calling save changes.
     *
     * @param transport
     * @param message
     * @param addresses
     * @return
     * @throws IOException
     */
    public MailActivity sendMessage(Transport transport, MimeMessage message,Address ... addresses) throws MessagingException,IOException;

    /**
     * Adds a mime body part of the given content type to the message.
     * @param message
     * @param contentType
     * @return the part which was added
     */
    MimeBodyPart addBodyPart(MimeMultipart message, String contentType);

    /**
     * Adds a mime body part of the given content type and a url datasource to the message.
     * @param message
     * @param contentType
     * @param fileName
     * @param url
     * @return the part which was added
     */
    MimeBodyPart addBodyPart(MimeMultipart message, String contentType, URL url) throws MessagingException, URISyntaxException;

    /**
     * Adds a mime body part of the given content type and a byte[] datasource to the message.
     * @param message
     * @param contentType
     * @param fileName
     * @param data
     * @return the part which was added
     */
    MimeBodyPart addBodyPart(MimeMultipart message, String contentType,String fileName, byte[] data) throws MessagingException;

    /**
     * Creates a message on this entities' session
     * @return the message
     * @throws MessagingException
     */
    MimeMessage createMessage() throws MessagingException;
    /**
     *
     * Creates a message on this entities' session
     *
     * @param session
     * @return the message
     * @throws MessagingException
     */
    MimeMessage createMessage(Session session) throws MessagingException;

    /**
     *
     * Creates a multipart message
     *
     * @param message
     * @return the multipart.
     *
     * @throws MessagingException
     */
    MimeMultipart createMultipart(MimeMessage message) throws MessagingException;




}
