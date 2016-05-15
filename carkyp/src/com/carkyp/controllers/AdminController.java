package com.carkyp.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.carkyp.controllers.domain.BusinessFacilities;
import com.carkyp.controllers.domain.ServiceProvided;
import com.carkyp.controllers.domain.ServiceProvidedBrand;
import com.carkyp.controllers.domain.ServiceProvidedType;
import com.carkyp.service.Dispatcher;



@RestController
public class AdminController {
	
	@Autowired
	Dispatcher dispatcher;	
	
	public AdminController(){
		System.out.println("AdminController!!!!!!!!!!!!!!!!!!!!!");
	}
	
	
	
	@RequestMapping(value = "rest/admin/serviceprovided", method = RequestMethod.POST,produces = "application/json" )
	public ResponseEntity<HttpStatus> saveServiceProvided(@RequestBody  List<ServiceProvided> serviceProvided){
		System.out.println("service Provided " + serviceProvided.size());
		dispatcher.insertSreviceProvided(serviceProvided);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
				
	}
	
	
	
	
	@RequestMapping(value = "rest/admin/serviceprovidedtype", method = RequestMethod.POST,produces = "application/json" )
	public ResponseEntity<HttpStatus> saveServiceProvidedType(@RequestBody  List<ServiceProvidedType> serviceProvidedType){
		System.out.println("service Provided " + serviceProvidedType.size());
		dispatcher.insertSreviceProvidedType(serviceProvidedType);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
				
	}
	
	@RequestMapping(value = "rest/admin/serviceprovidedbrand", method = RequestMethod.POST,produces = "application/json" )
	public ResponseEntity<HttpStatus> saveServiceProvidedBrand(@RequestBody  List<ServiceProvidedBrand> serviceProvidedBrand){
		System.out.println("service Provided " + serviceProvidedBrand.size());
		dispatcher.insertSreviceProvidedBrand(serviceProvidedBrand);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
				
	}

	@RequestMapping(value = "rest/admin/businessfacilities", method = RequestMethod.POST,produces = "application/json" )
	public ResponseEntity<HttpStatus> saveServiceBusinessfacilities(@RequestBody  List<BusinessFacilities> businessfacilities){
		System.out.println("service Provided " + businessfacilities.size());
		dispatcher.insertSreviceBusinessFacilities(businessfacilities);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
				
	}
}
