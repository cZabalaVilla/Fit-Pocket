package edu.fpdual.webapplication.utilities.emailsender;

import lombok.Getter;
import lombok.Setter;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.*;
import java.util.Properties;

public class Sender {

    @Setter
    @Getter
    Properties mailProp = new Properties();
    @Setter
    @Getter
    Properties credentialProp = new Properties();

    /**
     * Build the sender class loading the properties from mail and credentials files.
     */
    public Sender() {
        try {
            mailProp.load(getClass().getClassLoader().getResourceAsStream("mail.properties"));
            credentialProp.load(getClass().getClassLoader().getResourceAsStream("credentials.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Send a simple email with from and recipient address, subject and a simple HTML format content.
     *
     * @param to      recipient email address
     * @param subject email subject
     * @param content email content in html format
     * @return a {@link boolean} indicating if the email was sent or not.
     */
    public boolean send(String to, String subject, String content) {
        boolean result;
        Session session = createSession();

        try {
            MimeMessage message = new MimeMessage(session);

            message.setFrom(new InternetAddress(credentialProp.getProperty(CredentialsConstants.USER)));

            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            message.setSubject(subject);

            message.setContent(content, "text/html");

            System.out.println("sending...");
            Transport.send(message);
            System.out.println("Sent message successfully....");
            result = true;
        } catch (MessagingException mex) {
            mex.printStackTrace();
            result = false;
        }

        return result;
    }

    private Session createSession() {
        Session session = Session.getInstance(mailProp, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(credentialProp.getProperty(CredentialsConstants.USER),
                        credentialProp.getProperty(CredentialsConstants.PASSWD));
            }
        });
        session.setDebug(true);
        return session;
    }
}
