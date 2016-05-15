package com.carkyp.serviceprovider.domain;

import org.springframework.data.annotation.Id;

public class ServiceProviderTypeInternal {
	
	private String id;
	private String name;
    
	public ServiceProviderTypeInternal(){}
    
    
	public final String getId() {
		return id;
	}
	public final void setId(String id) {
		this.id = id;
	}
	public final String getName() {
		return name;
	}
	public final void setName(String name) {
		this.name = name;
	}
	public ServiceProviderTypeInternal(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	

}
