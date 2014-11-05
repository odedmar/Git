package com.jpa.hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable
public class Address {
	
	
	
	@Column(name="STREET_NAME")
	private String street;
	
	@Column(name="CITY_NAME")
	private String City;
	
	
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	
	
	
	

}
