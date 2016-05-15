package com.carkyp.domain;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class ClientProfile {
	
	private String id;
	@DBRef
	private UserProfile userProfile;
	private UserDetails userDetail;
	
	public final String getId() {
		return id;
	}
	public final void setId(String id) {
		this.id = id;
	}
	public final UserProfile getUserProfile() {
		return userProfile;
	}
	public final void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}
	public final UserDetails getUserDetail() {
		return userDetail;
	}
	public final void setUserDetail(UserDetails userDetail) {
		this.userDetail = userDetail;
	}
	@Override
	public String toString() {
		return "ClientProfile [id=" + id + ", userProfile=" + userProfile
				+ ", userDetail=" + userDetail + "]";
	}
	
	

}
