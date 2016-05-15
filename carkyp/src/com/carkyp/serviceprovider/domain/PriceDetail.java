package com.carkyp.serviceprovider.domain;


public class PriceDetail {

	private String serviceType;
	private String carBrand;
	private String carModel;
	private Double price;
	
	public PriceDetail(){}
	
	

	public PriceDetail(String serviceType, String carBrand, String carModel,
			Double price) {
		super();
		this.serviceType = serviceType;
		this.carBrand = carBrand;
		this.carModel = carModel;
		this.price = price;
	}


	public final String getServiceType() {
		return serviceType;
	}

	public final void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	public final String getCarBrand() {
		return carBrand;
	}

	public final void setCarBrand(String carBrand) {
		this.carBrand = carBrand;
	}

	public final String getCarModel() {
		return carModel;
	}

	public final void setCarModel(String carModel) {
		this.carModel = carModel;
	}

	


	public final Double getPrice() {
		return price;
	}



	public final void setPrice(Double price) {
		this.price = price;
	}



	@Override
	public String toString() {
		return "PriceDetail [serviceType=" + serviceType + ", carBrand="
				+ carBrand + ", carModel=" + carModel + ", Price=" + price
				+ "]";
	}


	
}
