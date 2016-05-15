package com.carkyp.useraccount.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.carkyp.domain.UserProfile;

public interface UserProfileRepository extends MongoRepository<UserProfile, String>,UserProfileRepositoryCustom {
	
	@Query("{ 'username' : ?0}")
	UserProfile findByUsername( String username);
	List<UserProfile> findByUsernameAndPassword(final String username, final String password);
	List<UserProfile> findByPasswordAndUsername(final String password, final String username);
	List<UserProfile> findByUsernameLike(final String username);
	@Query("{ 'username' : ?0, 'password' : ?1 }")
	List<UserProfile> findByUsernameAndPasswordQuery(final String username, final String password);
//	public Boolean activateAccount(UserAccount user);
}
