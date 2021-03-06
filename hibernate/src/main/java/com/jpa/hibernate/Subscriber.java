package com.jpa.hibernate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.IndexColumn;



@Entity
@Table(name="SUBSCRIBER")
public class Subscriber {
	
	@Id
	@SequenceGenerator(name = "sub_gen",sequenceName="sub_seq")
	@GeneratedValue(strategy=GenerationType.TABLE,generator="sub_gen")
	@Column(name="ID")
	private int id;
	

	@Column(name="SUBSCRIBER_NAME")
	private String name;

	@OneToMany(cascade=CascadeType.PERSIST)
	private Collection<Car> carList = new ArrayList<Car>();
	
		
	
	public Collection<Car> getCarList() {
		return carList;
	}
	public void setCarList(Collection<Car> carList) {
		this.carList = carList;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	

}
