package com.carkyp.useraccount.repository;

import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.carkyp.domain.Role;
import com.carkyp.serviceprovider.domain.ServiceProviderProfile;

public interface ServiceProviderProfileRepository extends MongoRepository<ServiceProviderProfile, String> 
, ServiceProviderProfileRepositoryCustom {

	
}
