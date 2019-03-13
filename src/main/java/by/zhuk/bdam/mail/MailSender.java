package by.zhuk.bdam.mail;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * Class send mail to email
 *
 */
public class MailSender {
    private static final Logger LOGGER = LoggerFactory.getLogger(MailSender.class);

    private static final String TYPE = "text/html; charset=utf-8";
    private static final String UTF_8 = "utf-8";

    private MimeMessage message;
    private String sendToEmail;
    private String mailSubject;
    private String mailText;
    private Properties properties;

    public MailSender(String sendToEmail, String mailSubject, String mailText, Properties properties) {
        this.sendToEmail = sendToEmail;
        this.mailSubject = mailSubject;
        this.mailText = mailText;
        this.properties = properties;
    }

    public void send() {
        init();
        try {
            Transport.send(message);
        } catch (MessagingException e) {
            LOGGER.error("Error to send message ", e);
        }
    }

    private void init() {
        SessionCreator sessionCreator = new SessionCreator(properties);
        Session mailSession = sessionCreator.createSession();
        message = new MimeMessage(mailSession);
        try {
            message.setSubject(mailSubject, UTF_8);
            message.setContent(mailText, TYPE);
            String[] recipientList = sendToEmail.split(",");
            InternetAddress[] recipientAddress = new InternetAddress[recipientList.length];
            int counter = 0;
            for (String recipient : recipientList) {
                recipientAddress[counter] = new InternetAddress(recipient.trim());
                counter++;
            }
            message.setRecipients(Message.RecipientType.TO, recipientAddress);
        } catch (MessagingException e) {
            LOGGER.error("Error init mail send ", e);
        }
    }
}
