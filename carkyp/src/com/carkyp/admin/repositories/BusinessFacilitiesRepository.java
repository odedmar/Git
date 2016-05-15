package com.carkyp.admin.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.carkyp.serviceprovider.domain.BusinessFacilities;
import com.carkyp.serviceprovider.domain.ServiceProvidedBrand;

public interface BusinessFacilitiesRepository extends MongoRepository<BusinessFacilities, String>{
	
	
}