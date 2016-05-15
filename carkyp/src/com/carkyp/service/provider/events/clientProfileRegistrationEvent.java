package com.carkyp.service.provider.events;

import java.util.TimeZone;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

import scala.Immutable;

import com.carkyp.domain.ClientProfile;
import com.carkyp.domain.UserProfile;
import com.carkyp.service.email.model.MailRequest;
import com.carkyp.utilities.Clonner;

public class clientProfileRegistrationEvent implements Immutable{
	
	final private DateTime eventDate;
	final private ClientProfile clientProfile;
	final private MailRequest mailRequest;

	public clientProfileRegistrationEvent( ClientProfile clientProfile,MailRequest mailRequest){
		eventDate = new DateTime(DateTimeZone.forTimeZone(TimeZone.getDefault()));
		this.clientProfile = Clonner.clone(clientProfile);
		this.mailRequest = Clonner.clone(mailRequest);
	}

	public final DateTime getEventDate() {
		return eventDate;
	}

	public final ClientProfile getClientProfile() {
		return Clonner.clone(clientProfile);
	}

	public final MailRequest getMailRequest() {
		return Clonner.clone(mailRequest);
	}
	
	
	
}