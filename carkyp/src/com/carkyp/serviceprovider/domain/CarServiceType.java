package com.carkyp.serviceprovider.domain;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

@Document
public class CarServiceType {
	
	@Id
	private String Id;
	private String serviceName;
	public final String getId() {
		return Id;
	}
	public final void setId(String id) {
		Id = id;
	}
	public final String getServiceName() {
		return serviceName;
	}
	public final void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	@Override
	public String toString() {
		return "CarServiceType [Id=" + Id + ", serviceName=" + serviceName
				+ "]";
	}
	
	

}
