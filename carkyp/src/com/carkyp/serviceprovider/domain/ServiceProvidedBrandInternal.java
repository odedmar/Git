package com.carkyp.serviceprovider.domain;

import org.springframework.data.annotation.Id;

public class ServiceProvidedBrandInternal {
	
	private String id;
	private String brandGroup;
    private String seviceProvidedName;
    
    public ServiceProvidedBrandInternal(){}
    
	public ServiceProvidedBrandInternal(String id, String brandGroup,
			String seviceProvidedName) {
		super();
		this.id = id;
		this.brandGroup = brandGroup;
		this.seviceProvidedName = seviceProvidedName;
	}
	public final String getId() {
		return id;
	}
	public final void setId(String id) {
		this.id = id;
	}
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
    

}
