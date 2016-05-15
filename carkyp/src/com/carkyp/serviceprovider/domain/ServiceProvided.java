package com.carkyp.serviceprovider.domain;

import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

@Document
public class ServiceProvided {
	
	@Id
	private String id;
	@Indexed(unique=true)
	private String name;
	
	public ServiceProvided(){
		
	}
	
	
	
	public ServiceProvided(String id, String name) {
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
