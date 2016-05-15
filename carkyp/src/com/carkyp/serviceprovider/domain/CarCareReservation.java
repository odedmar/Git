package com.carkyp.serviceprovider.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class CarCareReservation {
	
	private Clientdetail clientDetail;
	private DateTime reservationDate;
	private CarDetail carDetail;
	private List<Additional> additional;
	private PriceDetail priceDetail;
	private String serviceType;
	
	public CarCareReservation(){}
	
	
	
	public CarCareReservation(Clientdetail clientDetail,
			String reservationDate, CarDetail carDetail,
			List<Additional> additional, PriceDetail priceDetail) {
		super();
		DateTimeFormatter formatter = DateTimeFormat.forPattern("dd/MM/yyyy HH");
		this.reservationDate = formatter.parseDateTime(reservationDate);
		
		this.clientDetail = clientDetail;
		
		this.carDetail = carDetail;
		this.additional = additional;
		this.priceDetail = priceDetail;
	}



	public final Clientdetail getClientDetail() {
		return clientDetail;
	}



	public final void setClientDetail(Clientdetail clientDetail) {
		this.clientDetail = clientDetail;
	}



	public final DateTime getReservationDate() {
		return reservationDate;
	}



	public final void setReservationDate(String reservationDate) {
		DateTimeFormatter formatter = DateTimeFormat.forPattern("dd/MM/yyyy HH:mm");
		this.reservationDate = formatter.parseDateTime(reservationDate);
	
	}



	public final CarDetail getCarDetail() {
		return carDetail;
	}



	public final void setCarDetail(CarDetail carDetail) {
		this.carDetail = carDetail;
	}



	public final List<Additional> getAdditional() {
		return additional;
	}



	public final void setAdditional(List<Additional> additional) {
		this.additional = additional;
	}



	public final PriceDetail getPriceDetail() {
		return priceDetail;
	}



	public final void setPriceDetail(PriceDetail priceDetail) {
		this.priceDetail = priceDetail;
	}



	public final String getServiceType() {
		return serviceType;
	}



	public final void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}



	@Override
	public String toString() {
		return "CarCareReservation [clientDetail=" + clientDetail
				+ ", reservationDate=" + reservationDate + ", carDetail="
				+ carDetail + ", additional=" + additional + ", priceDetail="
				+ priceDetail + "]";
	}




}
