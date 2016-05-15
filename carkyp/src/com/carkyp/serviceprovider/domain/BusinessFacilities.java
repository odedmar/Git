package com.carkyp.serviceprovider.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
public class BusinessFacilities {
	
	@Id
	private String id;
	@Indexed(unique=true)
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((facilitiesName == null) ? 0 : facilitiesName.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BusinessFacilities other = (BusinessFacilities) obj;
		if (facilitiesName == null) {
			if (other.facilitiesName != null)
				return false;
		} else if (!facilitiesName.equals(other.facilitiesName))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}
