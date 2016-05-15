package com.carkyp.service.provider.events;



import java.util.TimeZone;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

import scala.Immutable;

import com.carkyp.domain.UserProfile;
import com.carkyp.service.email.model.MailRequest;
import com.carkyp.serviceprovider.domain.BusinessAccount;
import com.carkyp.serviceprovider.domain.ServiceProviderProfile;
import com.carkyp.utilities.Clonner;

public class ProviderAccountRegistrationEvent implements Immutable{
	
	final private DateTime eventDate;
	final private ServiceProviderProfile serviceproviderProfile;
	final private MailRequest mailRequest;

	public ProviderAccountRegistrationEvent( ServiceProviderProfile providerProfile,MailRequest mailRequest){
		eventDate = new DateTime(DateTimeZone.forTimeZone(TimeZone.getDefault()));
		this.serviceproviderProfile = Clonner.clone(providerProfile);
		this.mailRequest = Clonner.clone(mailRequest);
	}

	public final DateTime getEventDate() {
		return eventDate;
	}

	
	public final ServiceProviderProfile getServiceproviderProfile() {
		return serviceproviderProfile;
	}

	public final MailRequest getMailRequest() {
		return mailRequest;
	}

	@Override
	public String toString() {
		return "ProviderAccountRegistrationEvent [eventDate=" + eventDate
				+ ", serviceproviderProfile=" + serviceproviderProfile
				+ ", mailRequest=" + mailRequest + "]";
	}

	

	
	
	
	
}