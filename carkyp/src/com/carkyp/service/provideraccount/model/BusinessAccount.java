package com.carkyp.service.provideraccount.model;



import java.util.List;

import org.hibernate.validator.constraints.NotEmpty;

import com.carkyp.controllers.domain.ServiceProvidedBrand;
import com.carkyp.serviceprovider.domain.BusinessInformation;
import com.carkyp.serviceprovider.domain.BusinessOpenHour;



public class BusinessAccount {

	private String Id;
	private BusnessDetail businessDetail;
	@NotEmpty
	private String  serviceProvidrTypeId;
	@NotEmpty
	private List<String> serviceProvidedId;
	//@NotEmpty
	private BusinessInformation businessInformation;
	//@NotEmpty
	private BusinessOpenHour businessopenHour;
	@NotEmpty
	private List<String> businessFacilitiesname;
	@NotEmpty
	private List<ServiceProvidedBrand> serviceProvidedBrands;
	
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

	public final List<String> getBusinessFacilitiesname() {
		return businessFacilitiesname;
	}

	public final void setBusinessFacilitiesname(List<String> businessFacilitiesname) {
		this.businessFacilitiesname = businessFacilitiesname;
	}

	public final List<ServiceProvidedBrand> getServiceProvidedBrands() {
		return serviceProvidedBrands;
	}

	public final void setServiceProvidedBrands(
			List<ServiceProvidedBrand> serviceProvidedBrands) {
		this.serviceProvidedBrands = serviceProvidedBrands;
	}

	public final String getServiceProvidrTypeId() {
		return serviceProvidrTypeId;
	}

	public final void setServiceProvidrTypeId(String serviceProvidrTypeId) {
		this.serviceProvidrTypeId = serviceProvidrTypeId;
	}

	public final List<String> getServiceProvidedId() {
		return serviceProvidedId;
	}

	public final void setServiceProvidedId(List<String> serviceProvidedId) {
		this.serviceProvidedId = serviceProvidedId;
	}

	@Override
	public String toString() {
		return "BusinessAccount [Id=" + Id + ", businessDetail="
				+ businessDetail + ", serviceProvidrTypeId="
				+ serviceProvidrTypeId + ", serviceProvidedId="
				+ serviceProvidedId + ", businessInformation="
				+ businessInformation + ", businessopenHour="
				+ businessopenHour + ", businessFacilitiesname="
				+ businessFacilitiesname + ", serviceProvidedBrands="
				+ serviceProvidedBrands + "]";
	}

	
	
	
 
}
