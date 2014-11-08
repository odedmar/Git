package com.jpa.hibernate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Car {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	protected long lisense;
	protected long weells;
	protected int door;
	
	
	
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
	
	
	
	

}
