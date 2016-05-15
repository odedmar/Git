package com.carkyp.service.provider.events;

import java.util.TimeZone;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

import scala.Immutable;

import com.carkyp.domain.carReservation;
import com.carkyp.service.email.model.MailRequest;
import com.carkyp.serviceprovider.domain.ServiceProviderProfile;
import com.carkyp.utilities.Clonner;


public class carReservationEvent implements Immutable{
	
	final private DateTime eventDate;
	final private carReservation carReservation;
	
	
	
	public carReservationEvent(	carReservation carReservation 
								) {
		super();
		eventDate = new DateTime(DateTimeZone.forTimeZone(TimeZone.getDefault()));
		this.carReservation = carReservation;
		
	}


	public final DateTime getEventDate() {
		return Clonner.clone(eventDate);
	}


	public final carReservation getCarReservation() {
		return Clonner.clone(carReservation);
	}


	
	
	
	
}