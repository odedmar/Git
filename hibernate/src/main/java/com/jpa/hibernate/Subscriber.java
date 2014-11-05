package com.jpa.hibernate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;


@Entity
@Table(name="SUBSCRIBER")
public class Subscriber {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO )
	@Column(name="ID")
	private int id;
	
	
//	@Embedded
//	@AttributeOverrides({
//	@AttributeOverride (name="street", column=@Column(name="ofiice_street_name")),
//	@AttributeOverride (name="City",  column=@Column(name="ofiihgfce_city_name"))})
//	private Address addr;
	
	@ElementCollection
	@JoinTable(name="SUBSCRIBER_ADDRESS",joinColumns=@JoinColumn(name="ID"))
//	private Set<Address> addr_office = new HashSet<Address>();
	//for creating an index of address table
	
	
	@GenericGenerator(name = "hilo-gen", strategy = "hilo")
	@CollectionId(columns = { @Column(name="ADDRESS_ID") }, generator = "hilo-gen", type = @Type(type="long"))
	private Collection<Address> addresses = new ArrayList<Address>();
	
//	public Address getAddr_office() {
//		return addr_office;
//	}
//	public void setAddr_office(Address addr_office) {
//		this.addr_office = addr_office;
//	}
//	public Address getAddr() {
//		return addr;
//	}
//	public void setAddr(Address addr) {
//		this.addr = addr;
//	}
	@Column(name="SUBSCRIBER_NAME")
	private String name;
	
	@Column(name="CREATE_TIME")
	@Temporal(TemporalType.DATE)
	private Date createTime; 
	
	
	@Transient
	private String string_hib;
	
	
	
//	public Set<Address> getAddr_office() {
//		return addr_office;
//	}
//	public void setAddr_office(Set<Address> addr_office) {
//		this.addr_office = addr_office;
//	}
	
	
	
	public Date getCreateTime() {
		return createTime;
	}
	public Collection<Address> getAddresses() {
		return addresses;
	}
	public void setAddresses(Collection<Address> addresses) {
		this.addresses = addresses;
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
