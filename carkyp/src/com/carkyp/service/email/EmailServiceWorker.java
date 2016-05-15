package com.carkyp.service.email;

import java.io.IOException;

import javax.mail.MessagingException;

import com.carkyp.service.email.model.MailRequest;

import akka.actor.UntypedActor;

public class EmailServiceWorker extends UntypedActor {

    @Override
    public void onReceive(Object message) {
        try {
            EmailService emailService = new EmailService();
            emailService.sendEmail((MailRequest)message);
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (MessagingException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    @Override
    public void preStart() {
//        getContext().system().scheduler().scheduleOnce(Duration.create(5, TimeUnit.SECONDS), self(), "emailWorker", getContext().system().dispatcher(), null);
    }

    @Override
    public void postStop() {

    }
}