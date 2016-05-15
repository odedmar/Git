package com.carkyp.serviceprovider.domain;

public class Clientdetail {
	
	private String firstName;
	private String lastName;
	private String phone;
	
	public Clientdetail(){}
	
	
	
	public Clientdetail(String firstName, String lastName, String phone) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
	}



	public final String getFirstName() {
		return firstName;
	}
	public final void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public final String getLastName() {
		return lastName;
	}
	public final void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public final String getPhone() {
		return phone;
	}
	public final void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "Clientdetail [firstName=" + firstName + ", lastName="
				+ lastName + ", phone=" + phone + "]";
	}
	
	

}
