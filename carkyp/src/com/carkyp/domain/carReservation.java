package com.carkyp.domain;

import com.carkyp.serviceprovider.domain.CarCareReservation;

public class carReservation {
	
	private String providerId;
	private CarCareReservation carReservation;
	private String dateReservation;
	
	public carReservation(){}

	public carReservation(String providerId, CarCareReservation carReservation,String dateReservation) {
		super();
		this.providerId = providerId;
		this.carReservation = carReservation;
		this.dateReservation = dateReservation;
	}

	
	
	public final String getDateReservation() {
		return dateReservation;
	}

	public final void setDateReservation(String dateReservation) {
		this.dateReservation = dateReservation;
	}

	public final String getProviderId() {
		return providerId;
	}

	public final void setProviderId(String providerId) {
		this.providerId = providerId;
	}

	public final CarCareReservation getCarReservation() {
		return carReservation;
	}

	public final void setCarReservation(CarCareReservation carReservation) {
		this.carReservation = carReservation;
	}

	@Override
	public String toString() {
		return "carReservation [providerId=" + providerId + ", carReservation="
				+ carReservation + "]";
	}
	
	

}
