package com.carkyp.utilities;


import com.rits.cloning.Cloner;

public abstract class Clonner {
	
	private final static Cloner cloner = new Cloner();
	
	
	public static <T> T clone(T object ){
		
		return cloner.deepClone(object);
	}
}
