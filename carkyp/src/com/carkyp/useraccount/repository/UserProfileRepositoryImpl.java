package com.carkyp.useraccount.repository;

import static org.springframework.data.mongodb.core.query.Criteria.where;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.carkyp.UserAccountStatus;
import com.carkyp.domain.UserProfile;
import com.mongodb.WriteResult;

class UserProfileRepositoryImpl implements UserProfileRepositoryCustom {

	@Autowired
	private MongoTemplate mt;
	
	@Override
	public Boolean activateAccount(String tokeniD) {
		MongoOperations mongoOps = mt;
		
		WriteResult wr = mongoOps
		.updateFirst( new Query(where("token").is(tokeniD)) ,
				Update.update("status", UserAccountStatus.STATUS_APPROVED.name()),UserProfile.class);
		if(wr.isUpdateOfExisting())
			return Boolean.TRUE;
		
		 return Boolean.FALSE;
	}

	  
	
}
