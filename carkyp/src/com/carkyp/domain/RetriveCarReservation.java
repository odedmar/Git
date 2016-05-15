package com.carkyp.domain;

import java.util.Date;

import org.joda.time.DateTime;

public class RetriveCarReservation {
	
	private String starDate;
	private String endDate;
	private String mailId;
	
	
	public final String getStarDate() {
		return starDate;
	}
	public final void setStarDate(String starDate) {
		this.starDate = starDate;
	}
	public final String getEndDate() {
		return endDate;
	}
	public final void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public final String getMailId() {
		return mailId;
	}
	public final void setMailId(String mailId) {
		this.mailId = mailId;
	}
	@Override
	public String toString() {
		return "RetriveCarReservation [starDate=" + starDate + ", endDate="
				+ endDate + ", mailId=" + mailId + "]";
	}
	
	
	

}
