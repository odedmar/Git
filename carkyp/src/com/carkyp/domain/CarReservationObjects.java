package com.carkyp.domain;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.joda.time.DateTime;

import com.carkyp.serviceprovider.domain.CarDetail;
import com.carkyp.serviceprovider.domain.Clientdetail;

public class CarReservationObjects {
	
	Clientdetail clientDetail;
	private DateTime reservationDate;
	private CarDetail carDetail;
	private String serviceType;
	
	public final Clientdetail getClientDetail() {
		return clientDetail;
	}
	public final void setClientDetail(Clientdetail clientDetail) {
		this.clientDetail = clientDetail;
	}
	
	
	
	public final DateTime getReservationDate() {
		return reservationDate;
	}
	public final void setReservationDate(DateTime reservationDate) {
		this.reservationDate = reservationDate;
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
		return "CarReservation [clientDetail=" + clientDetail
				+ ", reservationDate=" + reservationDate + ", carDetail="
				+ carDetail + ", serviceType=" + serviceType + "]";
	}
	

}
