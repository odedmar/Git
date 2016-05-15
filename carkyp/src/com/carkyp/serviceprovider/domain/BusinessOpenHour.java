package com.carkyp.serviceprovider.domain;

import java.util.List;

public class BusinessOpenHour {
	private String startWeekDay;
	private String endWeekDay;
	private String startTime;
	private String endTime;
	
	public BusinessOpenHour(){}

	

	public BusinessOpenHour(String startWeekDay, String endWeekDay,
			String startTime, String endTime) {
		super();
		this.startWeekDay = startWeekDay;
		this.endWeekDay = endWeekDay;
		this.startTime = startTime;
		this.endTime = endTime;
	}



	public final String getStartWeekDay() {
		return startWeekDay;
	}

	public final void setStartWeekDay(String startWeekDay) {
		this.startWeekDay = startWeekDay;
	}

	public final String getEndWeekDay() {
		return endWeekDay;
	}

	public final void setEndWeekDay(String endWeekDay) {
		this.endWeekDay = endWeekDay;
	}



	public final String getStartTime() {
		return startTime;
	}



	public final void setStartTime(String startTime) {
		this.startTime = startTime;
	}



	public final String getEndTime() {
		return endTime;
	}



	public final void setEndTime(String endTime) {
		this.endTime = endTime;
	}



	@Override
	public String toString() {
		return "BusinessOpenHour [startWeekDay=" + startWeekDay
				+ ", endWeekDay=" + endWeekDay + ", startTime=" + startTime
				+ ", endTime=" + endTime + "]";
	}



	

	
	

}
