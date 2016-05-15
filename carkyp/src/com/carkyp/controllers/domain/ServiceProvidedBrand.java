package com.carkyp.controllers.domain;

import org.springframework.data.mongodb.core.index.Indexed;

public class ServiceProvidedBrand {
	
	private String brandGroup;
	private String seviceProvidedName;
	public final String getBrandGroup() {
		return brandGroup;
	}
	public final void setBrandGroup(String brandGroup) {
		this.brandGroup = brandGroup;
	}
	public final String getSeviceProvidedName() {
		return seviceProvidedName;
	}
	public final void setSeviceProvidedName(String seviceProvidedName) {
		this.seviceProvidedName = seviceProvidedName;
	}
	@Override
	public String toString() {
		return "ServiceProvidedBrand [brandGroup=" + brandGroup
				+ ", seviceProvidedName=" + seviceProvidedName + "]";
	}
	
	

}
