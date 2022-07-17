package org.profamilia.hc.toolbox.mail;

import java.io.File;

import java.io.IOException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;

import javax.activation.FileDataSource;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;

import javax.mail.internet.MimeMultipart;

import org.profamilia.hc.model.exceptions.MailException;
import org.profamilia.hc.view.util.ModuleConfig;


/**
 * Clase para el env�o de mensajes de correo con soporte de archivos adjuntos.
 * 
 * Ejemplo de empleo:
 * 
 * <code>
 * SendMail sender = new SendMail();
 * sender.setSubject("Prueba");
 * sender.addRecipientTo("aa1@profamilia.org.co");
 * sender.addRecipientTo("aa2@profamilia.org.co");
 * sender.addRecipientCc("aa3@profamilia.org.co");
 * sender.addRecipientBcc("aa4@profamilia.org.co");
 * sender.setFrom("bbb@profamilia.org.co");
 * sender.setContent("Prueba mensaje con anexo generado autom�ticamente por Orca");
 * sender.addAttachment("C:/tmp/archivo.ar");
 * sender.send();
 * </code>
 * 
 * @author mnewball
 * 
 */
public class

//@SuppressWarnings("unchecked")
SendMail {

    /**
     * Propiedades del servidor de correo
     */
    private String smtpHost;
    private String smtpPort;
    private String mail;
    private String subject;
    private String login;
    private String password;

    private Object content;
    private String mimeType;

    private List recipientsBcc = new ArrayList();
    private List recipientsCc = new ArrayList();
    private List recipientsTo = new ArrayList();
    private List attachments = new ArrayList();

    /**
     * Constructor
     */
    public SendMail() throws IOException {
       ModuleConfig config = new ModuleConfig();
       smtpHost = config.getSmtpHost();
       smtpPort = config.getSmtpPort();
       mail = config.getSmtpSource();
        
    }

    /**
     * 
     * @return
     */
    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }

    public void setTextContent(String text) {
        this.content = text;
        this.mimeType = "text/plain";
    }

    public void setHtmlContent(String htmlDocument) {
        this.content = htmlDocument;
        this.mimeType = "text/html";
    }

    public String getFrom() {
        return mail;
    }

    public void setFrom(String from) {
        this.mail = from;
    }

    public String getSmtpHost() {
        return smtpHost;
    }

    public void setSmtpHost(String smtpHost) {
        this.smtpHost = smtpHost;
    }

    public String getSmtpPort() {
        return smtpPort;
    }

    public void setSmtpPort(String smtpPort) {
        this.smtpPort = smtpPort;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
    
    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    public String getMimeType() {
        return mimeType;
    }

    public void addRecipientTo(String to) {
        this.recipientsTo.add(to);
    }

    public void addRecipientCc(String cc) {
        this.recipientsCc.add(cc);
    }

    public void addRecipientBcc(String bcc) {
        this.recipientsBcc.add(bcc);
    }

    public void addAttachment(String fileName) {
        if (fileName != null && fileName.length() > 0)
            this.attachments.add(fileName);
    }

    /**
     * Env�a correo electr�nico
     * 
     * @return
     */
    public void send() throws MailException {
        // Crear sesi�n SMTP
        java.util.Properties props = new java.util.Properties();
        props.put("mail.smtp.host", smtpHost);
        props.put("mail.smtp.port", smtpPort);
        Session session = Session.getDefaultInstance(props, null);

        // Construye el mensaje
        Message message = new MimeMessage(session);

        try {
            message.setFrom(new InternetAddress(mail));

            for (Iterator iterator = recipientsTo.iterator(); 
                 iterator.hasNext(); ) {
                String to = (String)iterator.next();
                message.addRecipient(Message.RecipientType.TO, 
                                     new InternetAddress(to));
            }

            for (Iterator iterator = recipientsCc.iterator(); 
                 iterator.hasNext(); ) {
                String cc = (String)iterator.next();
                message.addRecipient(Message.RecipientType.CC, 
                                     new InternetAddress(cc));
            }

            for (Iterator iterator = recipientsBcc.iterator(); 
                 iterator.hasNext(); ) {
                String bcc = (String)iterator.next();
                message.addRecipient(Message.RecipientType.BCC, 
                                     new InternetAddress(bcc));
            }

            message.setSubject(subject);

            // El texto del mensaje
            MimeBodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setContent(content, mimeType);

            // Todos los adjuntos
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);

            for (Iterator iterator = attachments.iterator(); 
                 iterator.hasNext(); ) {
                String fileName = (String)iterator.next();
                File file = new File(fileName);
                if (file.exists()) {
                    messageBodyPart = new MimeBodyPart();
                    DataSource source = new FileDataSource(fileName);
                    messageBodyPart.setDataHandler(new DataHandler(source));

                    messageBodyPart.setFileName(file.getName());
                    multipart.addBodyPart(messageBodyPart);
                }
            }

            // Establecer el contenido del mensaje
            message.setContent(multipart);

            // Enviar el mensaje
            Transport.send(message);
        } catch (AddressException ae) {
            // Se captura la excepci�n y se reenv�a como opcionalmente capturable
            throw new MailException(ae);
        } catch (MessagingException me) {
            // Se captura la excepci�n y se reenv�a como opcionalmente capturable
            throw new MailException(me);
        }
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getLogin() {
        return login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
}
