package com.carkyp.serviceprovider.domain;

public class Additional {
	
	private String name;
	private Double price;
	
	public Additional(){}
	
	

	public Additional(String name, Double price) {
		super();
		this.name = name;
		this.price = price;
	}



	public final String getName() {
		return name;
	}

	public final void setName(String name) {
		this.name = name;
	}

	public final Double getPrice() {
		return price;
	}

	public final void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Additional [name=" + name + ", price=" + price + "]";
	}
	
	
	
	
	

}
