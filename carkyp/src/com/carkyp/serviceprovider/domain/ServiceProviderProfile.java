package com.carkyp.serviceprovider.domain;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.carkyp.domain.UserProfile;

@Document
public class ServiceProviderProfile {
	@Id
	private String id;
	@Indexed(unique=true, direction=IndexDirection.DESCENDING, dropDups=true)
	private String email;
	private BusinessAccount businessAccount;
	@DBRef
	private UserProfile userProfile;
	private List<CarCareReservation> careReservation;
	private List<PriceDetail> priceDetails;
	
	public ServiceProviderProfile(){}
	
	
	
	public ServiceProviderProfile(String id, String email,
			BusinessAccount businessAccount, UserProfile userProfile,
			List<CarCareReservation> careReservation) {
		super();
		this.id = id;
		this.email = email;
		this.businessAccount = businessAccount;
		this.userProfile = userProfile;
		this.careReservation = careReservation;
	}

	

	public final List<PriceDetail> getPriceDetails() {
		return priceDetails;
	}



	public final void setPriceDetails(List<PriceDetail> priceDetails) {
		this.priceDetails = priceDetails;
	}



	public final String getId() {
		return id;
	}
	public final void setId(String id) {
		this.id = id;
	}
	public final String getEmail() {
		return email;
	}
	public final void setEmail(String email) {
		this.email = email;
	}
	public final BusinessAccount getBusinessAccount() {
		return businessAccount;
	}
	public final void setBusinessAccount(BusinessAccount businessAccount) {
		this.businessAccount = businessAccount;
	}
	public final UserProfile getUserProfile() {
		return userProfile;
	}
	public final void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}
	public final List<CarCareReservation> getCareReservation() {
		return careReservation;
	}
	public final void setCareReservation(List<CarCareReservation> careReservation) {
		this.careReservation = careReservation;
	}
	@Override
	public String toString() {
		return "ServiceProviderProfile [id=" + id + ", email=" + email
				+ ", businessAccount=" + businessAccount + ", userProfile="
				+ userProfile + ", careReservation=" + careReservation + "]";
	}
	
	


}
