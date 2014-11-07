package com.jpa.hibernate;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;


@Entity

public class Address {
	
	@Id
	@SequenceGenerator(name = "address_gen",sequenceName="ADDRESS_GEN")
	@GeneratedValue(strategy=GenerationType.TABLE,generator="address_gen")
	private long id;
	
	@Column(name="STREET_NAME")
	private String street;
	
	@Column(name="CITY_NAME")
	private String City;
	
	
	@ManyToMany
	@JoinTable(name = "oded",joinColumns=@JoinColumn(name="oded_addr"),
			inverseJoinColumns=@JoinColumn(name="sub_adr"))
	
					
	private Collection<Subscriber> userList = new ArrayList<Subscriber>();
	
	
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Collection<Subscriber> getUserList() {
		return userList;
	}
	public void setUserList(Collection<Subscriber> userList) {
		this.userList = userList;
	}
	
	
	
	
	
	
	

}
