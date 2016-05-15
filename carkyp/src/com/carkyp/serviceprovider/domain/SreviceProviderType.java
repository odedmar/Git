package com.carkyp.serviceprovider.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
public class SreviceProviderType {
	
	@Id
	private String id;
	@Indexed(unique=true, direction=IndexDirection.DESCENDING, dropDups=true)
    private String name;
    
	public SreviceProviderType(){}
    
    
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
	public SreviceProviderType(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	
	

}
