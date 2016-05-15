package com.carkyp.useraccount.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.carkyp.domain.ClientProfile;
import com.carkyp.domain.Role;

public interface ClientProfileRepository extends MongoRepository<ClientProfile, String> {
}
