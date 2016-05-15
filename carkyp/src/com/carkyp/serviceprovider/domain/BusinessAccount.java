package com.carkyp.serviceprovider.domain;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

public class BusinessAccount {

	private String Id;
	private BusnessDetail businessDetail;
	
	
	private ServiceProviderTypeInternal  serviceProvidrType;
	private List<ServiceProvidedInternal> serviceProvided;
	private BusinessInformation businessInformation;
	private BusinessOpenHour businessopenHour;
	private List<BusinessFacilitiesInternal> businessFacilities;
	private List<ServiceProvidedBrandInternal> serviceProvidedBrands;
	
	public BusinessAccount(){}
	
	
	public final String getId() {
		return Id;
	}

	public final void setId(String id) {
		Id = id;
	}

	public final BusnessDetail getBusinessDetail() {
		return businessDetail;
	}

	public final void setBusinessDetail(BusnessDetail businessDetail) {
		this.businessDetail = businessDetail;
	}

	
	public BusinessAccount(String id, BusnessDetail businessDetail,
			ServiceProviderTypeInternal serviceProvidrType,
			List<ServiceProvidedInternal> serviceProvided,
			BusinessInformation businessInformation,
			BusinessOpenHour businessopenHour,
			List<BusinessFacilitiesInternal> businessFacilities,
			List<ServiceProvidedBrandInternal> serviceProvidedBrands) {
		super();
		Id = id;
		this.businessDetail = businessDetail;
		this.serviceProvidrType = serviceProvidrType;
		this.serviceProvided = serviceProvided;
		this.businessInformation = businessInformation;
		this.businessopenHour = businessopenHour;
		this.businessFacilities = businessFacilities;
		this.serviceProvidedBrands = serviceProvidedBrands;
	}


	

	public final ServiceProviderTypeInternal getServiceProvidrType() {
		return serviceProvidrType;
	}


	public final void setServiceProvidrType(
			ServiceProviderTypeInternal serviceProvidrType) {
		this.serviceProvidrType = serviceProvidrType;
	}


	public final List<ServiceProvidedInternal> getServiceProvided() {
		return serviceProvided;
	}


	public final void setServiceProvided(
			List<ServiceProvidedInternal> serviceProvided) {
		this.serviceProvided = serviceProvided;
	}


	public final BusinessInformation getBusinessInformation() {
		return businessInformation;
	}


	public final void setBusinessInformation(BusinessInformation businessInformation) {
		this.businessInformation = businessInformation;
	}


	public final BusinessOpenHour getBusinessopenHour() {
		return businessopenHour;
	}


	public final void setBusinessopenHour(BusinessOpenHour businessopenHour) {
		this.businessopenHour = businessopenHour;
	}


	public final List<BusinessFacilitiesInternal> getBusinessFacilities() {
		return businessFacilities;
	}


	public final void setBusinessFacilities(
			List<BusinessFacilitiesInternal> businessFacilities) {
		this.businessFacilities = businessFacilities;
	}


	public final List<ServiceProvidedBrandInternal> getServiceProvidedBrands() {
		return serviceProvidedBrands;
	}


	public final void setServiceProvidedBrands(
			List<ServiceProvidedBrandInternal> serviceProvidedBrands) {
		this.serviceProvidedBrands = serviceProvidedBrands;
	}


	@Override
	public String toString() {
		return "businessAccount [Id=" + Id + ", businessDetail="
				+ businessDetail + ", serviceProvidrType=" + serviceProvidrType
				+ ", serviceProvided=" + serviceProvided
				+ ", businessInformation=" + businessInformation
				+ ", businessopenHour=" + businessopenHour
				+ ", businessFacilities=" + businessFacilities
				+ ", serviceProvidedBrands=" + serviceProvidedBrands + "]";
	};
	
	
	
 
}
