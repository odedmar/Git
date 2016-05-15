package com.carkyp.admin.repositories;



import org.springframework.data.mongodb.repository.MongoRepository;

import com.carkyp.domain.UserProfile;
import com.carkyp.serviceprovider.domain.ServiceProvided;

public interface ServiceProvidedRepository extends MongoRepository<ServiceProvided, String>{
	
	
}
