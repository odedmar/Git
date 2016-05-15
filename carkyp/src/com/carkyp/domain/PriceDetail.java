package com.carkyp.domain;

import javax.validation.constraints.NotNull;

public class PriceDetail {

	@NotNull
	private String providerId;
	@NotNull
	private String serviceType;
	@NotNull
	private String carBrand;
	@NotNull
	private String carModel;
	@NotNull
	private Double price;
	
	public PriceDetail(){}
	
	



	public PriceDetail(String providerId, String serviceType, String carBrand,
			String carModel, Double price) {
		super();
		this.providerId = providerId;
		this.serviceType = serviceType;
		this.carBrand = carBrand;
		this.carModel = carModel;
		this.price = price;
	}





	public final String getProviderId() {
		return providerId;
	}





	public final void setProviderId(String providerId) {
		this.providerId = providerId;
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
		return "PriceDetail [providerId=" + providerId + ", serviceType="
				+ serviceType + ", carBrand=" + carBrand + ", carModel="
				+ carModel + ", Price=" + price + "]";
	}

}

