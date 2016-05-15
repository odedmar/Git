package com.carkyp.admin.repositories;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.carkyp.domain.UserProfile;
import com.carkyp.serviceprovider.domain.ServiceProvided;
import com.carkyp.serviceprovider.domain.SreviceProviderType;

public interface SreviceProviderTypeRepository extends MongoRepository<SreviceProviderType, String>{
	
	
}
