package com.carkyp.useraccount.repository;

import com.carkyp.domain.UserProfile;

interface UserProfileRepositoryCustom {
	  public Boolean activateAccount(String tokenId);
	}
