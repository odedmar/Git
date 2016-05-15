//package com.carkyp.service.email;
//
//import org.springframework.beans.factory.annotation.Autowired;
//
//
//
//
//import com.carkyp.service.email.events.MailRequestEvent;
//
//import akka.actor.ActorRef;
//import akka.actor.Props;
//import akka.actor.Terminated;
//import akka.actor.UntypedActor;
//import akka.actor.UntypedActorContext;
//
//public class MailServiceActor extends UntypedActor{
//	
// @Autowired
//   SendMailInterface sendMailService;
// final ActorRef child =
//	      getContext().actorOf(Props.create(SendMailServiceActor.class), "myChild");
// {
// this.getContext().watch(child);
// }
// 
// ActorRef lastSender = getContext().system().deadLetters();
// 
//  
//	@Override
//	public void onReceive(Object arg0) throws Exception {
//		if(arg0 instanceof MailRequestEvent){
//			System.out.println("send mail in MailServiceActor!!!");
//			child.tell(((MailRequestEvent) arg0).getMail(),getSelf() );
//		}else if (arg0 instanceof Terminated) {
//			System.out.println("Termination recived!!!");
//		      final Terminated t = (Terminated) arg0;
//		      if (t.getActor() == child) {
//		        getContext().stop(child);
//		      }
//		}
//	}
//	
//	@Override
//	public void preStart() throws Exception {
//		System.err.println("MailServiceActor preStart has called!!!!"+ System.currentTimeMillis());
//	}
//	
//	public void preRestart(Throwable reason, scala.Option<Object> message) {
//		System.err.println("MailServiceActor preRestart has called!!!!");
//		  for (ActorRef each : getContext().getChildren()) {
//		    getContext().unwatch(each);
//		    getContext().stop(each);
//		  }
//		  postStop();
//		}
//		 
//		public void postRestart(Throwable reason) throws Exception {
//			System.err.println("MailServiceActor postRestart has called!!!!");
//		  preStart();
//		}
//		 
//		public void postStop() {
//			System.err.println("MailServiceActor postStop has called!!!!");
//		}
//}
