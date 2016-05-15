package com.carkyp.service.provideraccount.model;

public class CarReservationCounter {
	private String date;
	private int count;
	
	public CarReservationCounter(){}
	
	public CarReservationCounter(String date, int count) {
		super();
		this.date = date;
		this.count = count;
	}
	public final String getDate() {
		return date;
	}
	public final void setDate(String date) {
		this.date = date;
	}
	public final int getCount() {
		return count;
	}
	public final void setCount(int count) {
		this.count = count;
	}
	
	

}
