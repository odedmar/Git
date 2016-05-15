package com.carkyp.serviceprovider.domain;

public class OpenHour {
	
	private String openhourday;
	private String endHourday;
	
	
	public final String getOpenhourday() {
		return openhourday;
	}
	public final void setOpenhourday(String openhourday) {
		this.openhourday = openhourday;
	}
	public final String getEndHourday() {
		return endHourday;
	}
	public final void setEndHourday(String endHourday) {
		this.endHourday = endHourday;
	}
	public OpenHour(String openhourday, String endHourday) {
		super();
		this.openhourday = openhourday;
		this.endHourday = endHourday;
	}
	public OpenHour(){}
	
	

}
