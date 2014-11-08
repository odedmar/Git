package com.jpa.hibernate;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Bus extends Car {
	
	
	
	@Override
	public void setWeells(long weells) {
		this.weells = 8;
	}

}
