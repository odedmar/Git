package com.carkyp.useraccount.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.carkyp.domain.Role;

public interface RoleRepository extends MongoRepository<Role, String> {
}
