package com.carkyp.serviceprovider.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class ServiceProvidedBrand {
	@Id
	private String id;
	private String brandGroup;
	@Indexed(unique=true)
    private String seviceProvidedName;
    
    public ServiceProvidedBrand(){}
    
	public ServiceProvidedBrand(String id, String brandGroup,
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
