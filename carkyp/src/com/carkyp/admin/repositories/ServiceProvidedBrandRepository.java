package com.carkyp.admin.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.carkyp.serviceprovider.domain.ServiceProvided;
import com.carkyp.serviceprovider.domain.ServiceProvidedBrand;

public interface ServiceProvidedBrandRepository extends MongoRepository<ServiceProvidedBrand, String>{
	
	
}
