package com.jpa.hibernate;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;


@Entity
@Table(name="SUBSCRIBER")
public class Subscriber {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO )
	@Column(name="ID")
	private int id;
	
	
	@Embedded
	@AttributeOverrides({
	@AttributeOverride (name="street", column=@Column(name="ofiice_street_name")),
	@AttributeOverride (name="City",  column=@Column(name="ofiihgfce_city_name"))})
	private Address addr;
	
//	@Embedded
//	private Address addr_office;
	
	
//	public Address getAddr_office() {
//		return addr_office;
//	}
//	public void setAddr_office(Address addr_office) {
//		this.addr_office = addr_office;
//	}
	public Address getAddr() {
		return addr;
	}
	public void setAddr(Address addr) {
		this.addr = addr;
	}
	@Column(name="SUBSCRIBER_NAME")
	private String name;
	
	@Column(name="CREATE_TIME")
	@Temporal(TemporalType.DATE)
	private Date createTime; 
	
	
	@Transient
	private String string_hib;
	
	
	
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getString_hib() {
		return string_hib;
	}
	public void setString_hib(String string_hib) {
		this.string_hib = string_hib;
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
