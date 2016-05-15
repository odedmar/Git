package com.carkyp.domain;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;


public class UserDetails {

	@NotEmpty
	private String phoneNumber;
	@NotEmpty
	private String firstname;
	private String lastname;
	
	@Email	
	private String emailaddress;
	private String city;
	@NotEmpty
	private String password;
	
	public UserDetails(){
		
	}
	
	

	public UserDetails(String phoneNumber, String firstname, String lastname,
			String emailaddress, String city, String password) {
		super();
		this.phoneNumber = phoneNumber;
		this.firstname = firstname;
		this.lastname = lastname;
		this.emailaddress = emailaddress;
		this.city = city;
		this.password = password;
	}



	public final String getPhoneNumber() {
		return phoneNumber;
	}

	public final void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public final String getFirstname() {
		return firstname;
	}

	public final void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public final String getLastname() {
		return lastname;
	}

	public final void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public final String getEmailaddress() {
		return emailaddress;
	}

	public final void setEmailaddress(String emailaddress) {
		this.emailaddress = emailaddress;
	}
	
	

	public final String getCity() {
		return city;
	}



	public final void setCity(String city) {
		this.city = city;
	}



	public final String getPassword() {
		return password;
	}



	public final void setPassword(String password) {
		this.password = password;
	}



	@Override
	public String toString() {
		return "UserDetails [phoneNumber=" + phoneNumber + ", firstname="
				+ firstname + ", lastname=" + lastname + ", emailaddress="
				+ emailaddress + ", city=" + city + ", password=" + password
				+ "]";
	}



	
	
	

}
