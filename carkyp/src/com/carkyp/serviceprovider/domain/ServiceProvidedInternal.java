package com.carkyp.serviceprovider.domain;

import org.springframework.data.annotation.Id;

public class ServiceProvidedInternal {
	
	
	private String id;
	private String name;
	
	public ServiceProvidedInternal(){
		
	}
	
	
	public ServiceProvidedInternal(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}



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
	
	
	

}
