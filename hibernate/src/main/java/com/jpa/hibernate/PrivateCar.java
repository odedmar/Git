package com.jpa.hibernate;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class PrivateCar extends Car {
	
	
	
	
	@Override
	public void setWeells(long weells) {
		this.weells = 4;
	}
	
	

}
