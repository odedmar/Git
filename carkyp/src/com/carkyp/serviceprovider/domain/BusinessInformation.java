package com.carkyp.serviceprovider.domain;

import org.hibernate.validator.constraints.NotEmpty;

public class BusinessInformation {
	
	//@NotEmpty
	private int lifts;
	//@NotEmpty
	private long numberOfEmploies;
	//@NotEmpty
	private long size;
	
	public BusinessInformation(){}
	
	public BusinessInformation(int lifts, long numberOfEmploies, long size) {
		super();
		this.lifts = lifts;
		this.numberOfEmploies = numberOfEmploies;
		this.size = size;
	}
	
	public final int getLifts() {
		return lifts;
	}
	public final void setLifts(int lifts) {
		this.lifts = lifts;
	}
	public final long getNumberOfEmploies() {
		return numberOfEmploies;
	}
	public final void setNumberOfEmploies(long numberOfEmploies) {
		this.numberOfEmploies = numberOfEmploies;
	}
	public final long getSize() {
		return size;
	}
	public final void setSize(long size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return "BusinessInformation [lifts=" + lifts + ", numberOfEmploies="
				+ numberOfEmploies + ", size=" + size + "]";
	}
	
	

}
