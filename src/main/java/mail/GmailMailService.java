package mail;

import config.MailConfig;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class GmailMailService implements MailService {
    private final MailConfig mailConfig;

    public GmailMailService(MailConfig mailConfig) {
        this.mailConfig = mailConfig;
    }

    @Override
    public void sendEmail(Email email) {
        Session session = mailConfig.createSession();

        try {
            MimeMessage message = new MimeMessage(session);
            message.setText(email.getContent());
            message.setSubject(email.getSubject());
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(email.getMailAddress()));
            Transport.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }
}
