package com.carkyp.controllers.domain;

import java.util.Date;

import org.joda.time.DateTime;

import com.carkyp.serviceprovider.domain.CarDetail;
import com.carkyp.serviceprovider.domain.Clientdetail;

public class CarReservationDetails implements Comparable<CarReservationDetails>{
	
	Clientdetail clientDetail;
	private String reservationDate;
	private CarDetail carDetail;
	private String serviceType;
	
	
	public final Clientdetail getClientDetail() {
		return clientDetail;
	}
	public final void setClientDetail(Clientdetail clientDetail) {
		this.clientDetail = clientDetail;
	}
	public final String getReservationDate() {
		return reservationDate;
	}
	public final void setReservationDate(DateTime reservationDate) {
		
		this.reservationDate = reservationDate.toString("dd/MM/yyyy");
	}
	public final CarDetail getCarDetail() {
		return carDetail;
	}
	public final void setCarDetail(CarDetail carDetail) {
		this.carDetail = carDetail;
	}
	public final String getServiceType() {
		return serviceType;
	}
	public final void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}
	@Override
	public String toString() {
		return "CarReservationDetails [clientDetail=" + clientDetail
				+ ", reservationDate=" + reservationDate + ", carDetail="
				+ carDetail + ", serviceType=" + serviceType + "]";
	}
	@Override
	public int compareTo(CarReservationDetails o) {
		return getReservationDate().compareTo(o.getReservationDate());
		
	}
	
	
	

}
