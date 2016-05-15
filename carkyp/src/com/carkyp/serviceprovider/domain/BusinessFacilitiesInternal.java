package com.carkyp.serviceprovider.domain;

import org.springframework.data.annotation.Id;

public class BusinessFacilitiesInternal {
	
	private String id;
	private String facilitiesName;
	
	
	public final String getId() {
		return id;
	}
	public final void setId(String id) {
		this.id = id;
	}
	public final String getFacilitiesName() {
		return facilitiesName;
	}
	public final void setFacilitiesName(String facilitiesName) {
		this.facilitiesName = facilitiesName;
	}
	
	

}
