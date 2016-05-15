package com.carkyp.domain;

public class Address {
	
	private String street;
	private String number;
	private String city;
	
	
	public Address(){}
	
	
	
	public Address(String street, String number, String city) {
		super();
		this.street = street;
		this.number = number;
		this.city = city;
	}



	public final String getStreet() {
		return street;
	}
	public final void setStreet(String street) {
		this.street = street;
	}
	public final String getCity() {
		return city;
	}
	public final void setCity(String city) {
		this.city = city;
	}



	public final String getNumber() {
		return number;
	}



	public final void setNumber(String number) {
		this.number = number;
	}



	@Override
	public String toString() {
		return "Address [street=" + street + ", number=" + number + ", city="
				+ city + "]";
	}
	
	
	
	
	
	
	
	
	
	
	

}
