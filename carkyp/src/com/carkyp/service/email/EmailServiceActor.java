package com.carkyp.service.email;

import static akka.actor.SupervisorStrategy.escalate;
import static akka.actor.SupervisorStrategy.resume;
import static akka.actor.SupervisorStrategy.stop;

import javax.mail.MessagingException;

import scala.concurrent.duration.Duration;
import akka.actor.OneForOneStrategy;
import akka.actor.Props;
import akka.actor.SupervisorStrategy;
import akka.actor.UntypedActor;
import akka.actor.SupervisorStrategy.Directive;
import akka.japi.Function;

public class EmailServiceActor extends UntypedActor {

    private static SupervisorStrategy strategy =
            new OneForOneStrategy(10, Duration.create("1 minute"),
                    new Function<Throwable, Directive>() {
                        public Directive apply(Throwable t) {
                            if (t instanceof MessagingException) {
                                return resume();
                            } else if (t instanceof Exception) {
                                return stop();
                            } else {
                                return escalate();
                            }
                        }
                    });

    @Override
    public void onReceive(Object message) {
        getContext().actorOf(Props.create(EmailServiceWorker.class)).tell(message, self());
    }

    @Override
    public SupervisorStrategy supervisorStrategy() {
        return strategy;
    }

}
