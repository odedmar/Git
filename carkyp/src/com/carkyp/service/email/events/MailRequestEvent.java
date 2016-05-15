//package com.carkyp.service.email.events;
//
//import java.io.Serializable;
//import java.util.TimeZone;
//
//import org.joda.time.DateTime;
//import org.joda.time.DateTimeZone;
//
//import com.carkyp.service.email.model.MailRequest;
//import com.carkyp.utilities.Clonner;
//
//import scala.Immutable;
//
//
//public class MailRequestEvent implements Immutable{
//	
//	final private DateTime eventDate;
//	final private MailRequest mail;
//
//	public MailRequestEvent( MailRequest mail){
//		eventDate = new DateTime(DateTimeZone.forTimeZone(TimeZone.getDefault()));
//		this.mail = Clonner.clone(mail);
//	}
//
//	public final DateTime getEventDate() {
//		return eventDate;
//	}
//
//	public final MailRequest getMail() {
//		return Clonner.clone(mail);
//	}
//	
//	
//}
