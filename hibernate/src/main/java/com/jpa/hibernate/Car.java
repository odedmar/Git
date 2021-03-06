package com.jpa.hibernate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;



@Entity

//This style normalized the in heritance
@Inheritance(strategy=InheritanceType.JOINED)

public class Car {
	
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private int id;
	
	protected long lisense;
	protected long weells;
	protected int door;
	
	@Column(name = "MANUFACTURE_NAME")
	protected String manufacturerName;
	
	
	
	public long getLisense() {
		return lisense;
	}
	public void setLisense(long lisense) {
		this.lisense = lisense;
	}
	public long getWeells() {
		return weells;
	}
	public void setWeells(long weells) {
		this.weells = weells;
	}
	public int getDoor() {
		return door;
	}
	public void setDoor(int door) {
		this.door = door;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getManufacturerName() {
		return manufacturerName;
	}
	public void setManufacturerName(String manufacturerName) {
		this.manufacturerName = manufacturerName;
	}
	
	
	
	

}
