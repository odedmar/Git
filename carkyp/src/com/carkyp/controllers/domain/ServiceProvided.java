package com.carkyp.controllers.domain;

import java.util.List;

import org.hibernate.validator.constraints.NotEmpty;

public class ServiceProvided {
	
	private String id;
	//@NotEmpty
	private String providedName;

	
	
	
	public final String getId() {
		return id;
	}


	public final void setId(String id) {
		this.id = id;
	}


	public final String getProvidedName() {
		return providedName;
	}


	public final void setProvidedName(String providedName) {
		this.providedName = providedName;
	}


	@Override
	public String toString() {
		return "ServiceProvided [id=" + id + ", providedName=" + providedName
				+ "]";
	}


	
	
	

}
