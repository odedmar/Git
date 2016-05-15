package com.carkyp.serviceprovider.domain;

public class Additional {
	
	private String additionalName;
	private Double price;
	
	public Additional(){}
	
	
	
	public Additional(String additionalName, Double price) {
		super();
		this.additionalName = additionalName;
		this.price = price;
	}



	public final String getAdditionalName() {
		return additionalName;
	}
	public final void setAdditionalName(String additionalName) {
		this.additionalName = additionalName;
	}
	public final Double getPrice() {
		return price;
	}
	public final void setPrice(Double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Additional [additionalName=" + additionalName + ", price="
				+ price + "]";
	}
	
	

}
