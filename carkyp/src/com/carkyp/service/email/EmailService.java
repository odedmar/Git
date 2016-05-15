package com.carkyp.service.email;

import akka.actor.*;
import akka.japi.Function;
import akka.routing.SmallestMailboxRouter;
import scala.concurrent.duration.Duration;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.carkyp.service.email.model.MailRequest;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import akka.actor.SupervisorStrategy.Directive;
import static akka.actor.SupervisorStrategy.escalate;
import static akka.actor.SupervisorStrategy.restart;
import static akka.actor.SupervisorStrategy.resume;
import static akka.actor.SupervisorStrategy.stop;


/**
 * @author rajith
 */
public class EmailService {

    private static final String MAIL_SMTP_AUTH_KEY = "mail.smtp.auth";
    private static final String MAIL_SMTP_STARTTLS_KEY = "mail.smtp.starttls.enable";
    private static final String MAIL_SMTP_HOST_KEY = "mail.smtp.host";
    private static final String MAIL_SMTP_PORT_KEY = "mail.smtp.port";
    public ActorSystem system;
    public ActorRef emailActorRef;

    
    public EmailService() throws IOException {
        
        MailConfig.loadConfigurations();
    }


    public void sendEmail(MailRequest mr) throws MessagingException {
        System.out.println("Sending email ...");
        final String username = MailConfig.username;
        final String password = MailConfig.password;

        Properties props = new Properties();
        props.put(MAIL_SMTP_AUTH_KEY, MailConfig.smtpAuth);
        props.put(MAIL_SMTP_STARTTLS_KEY, MailConfig.starttlsEnable);
        props.put(MAIL_SMTP_HOST_KEY, MailConfig.smtpHost);
        props.put(MAIL_SMTP_PORT_KEY, MailConfig.smtpPort);

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message mimeMessage = new MimeMessage(session);
            mimeMessage.setFrom(new InternetAddress(mr.getFrom()));
            mimeMessage.setRecipients(Message.RecipientType.TO, InternetAddress.parse(mr.getTo()));
            mimeMessage.setSubject(mr.getSubject());
            mimeMessage.setText(mr.getText());
            Transport.send(mimeMessage);

            System.out.println("Email Successfully send. Check " + mr.getFrom()	);

        } catch (MessagingException e) {
            throw e;
        }
        	
    }


}



