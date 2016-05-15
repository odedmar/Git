package com.carkyp.controllers.domain;

public class PriceDetailSummaryQuery {
	
	private String serviceType;
	private String carBrand;
	private String carModel;
	
	
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
	@Override
	public String toString() {
		return "PriceDetailSummaryQuery [serviceType=" + serviceType
				+ ", carBrand=" + carBrand + ", carModel=" + carModel + "]";
	}
	
	

}
