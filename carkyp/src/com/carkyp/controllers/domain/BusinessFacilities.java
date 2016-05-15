package com.carkyp.controllers.domain;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;
@Document
public class BusinessFacilities {
	
	@Id
	private String Id;
	
	@Indexed(unique=true)
	private String facilitiesName;

	
	
	public final String getId() {
		return Id;
	}

	public final void setId(String id) {
		Id = id;
	}

	public final String getFacilitiesName() {
		return facilitiesName;
	}

	public final void setFacilitiesName(String facilitiesName) {
		this.facilitiesName = facilitiesName;
	}

	@Override
	public String toString() {
		return "BusinessFacilities [Id=" + Id + ", facilitiesName="
				+ facilitiesName + "]";
	}

	
}
