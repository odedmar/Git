package com.carkyp.service.provideraccount.model;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import com.carkyp.domain.Address;


public class BusnessDetail {
	
		//@Email
		private String email;
	//	@NotEmpty
		private String password;
	//	@NotEmpty
		private String businessName;
//		@NotEmpty
		private String  contactFirstName;
//		@NotEmpty
		private String contactLastName;
//		@NotEmpty
		private String phoneNumber;
//		@NotEmpty
		private Address address;
		
		public final String getEmail() {
			return email;
		}
		public final void setEmail(String email) {
			this.email = email;
		}
		public final String getPassword() {
			return password;
		}
		public final void setPassword(String password) {
			this.password = password;
		}
		public final String getBusinessName() {
			return businessName;
		}
		public final void setBusinessName(String businessName) {
			this.businessName = businessName;
		}
		public final String getContactFirstName() {
			return contactFirstName;
		}
		public final void setContactFirstName(String contactFirstName) {
			this.contactFirstName = contactFirstName;
		}
		public final String getContactLastName() {
			return contactLastName;
		}
		public final void setContactLastName(String contactLastName) {
			this.contactLastName = contactLastName;
		}
		public final String getPhoneNumber() {
			return phoneNumber;
		}
		public final void setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
		}
		public final Address getAddress() {
			return address;
		}
		public final void setAddress(Address address) {
			this.address = address;
		}
		@Override
		public String toString() {
			return "BusnessDetail [email=" + email + ", password=" + password
					+ ", businessName=" + businessName + ", contactFirstName="
					+ contactFirstName + ", contactLastName=" + contactLastName
					+ ", phoneNumber=" + phoneNumber + ", address=" + address
					+ "]";
		}
		
		

}
