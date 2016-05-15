package com.carkyp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoDataIntegrityViolationException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.carkyp.UserAccountStatus;
import com.carkyp.controllers.domain.ServiceProvidedType;
import com.carkyp.domain.ClientProfile;
import com.carkyp.domain.Role;
import com.carkyp.domain.UserProfile;
import com.carkyp.exception.ExistingResourceException;
import com.carkyp.serviceprovider.domain.BusinessAccount;
import com.carkyp.serviceprovider.domain.ServiceProviderProfile;
import com.carkyp.serviceprovider.domain.SreviceProviderType;
import com.carkyp.useraccount.repository.ClientProfileRepository;
import com.carkyp.useraccount.repository.RoleRepository;
import com.carkyp.useraccount.repository.ServiceProviderProfileRepository;
import com.carkyp.useraccount.repository.UserProfileRepository;
import com.mongodb.MongoException;
import com.mongodb.MongoException.DuplicateKey;
import com.carkyp.exception.ExistingResourceException;

@Component
public class UserService {
	
	@Autowired 
	private UserProfileRepository userRepository;
	@Autowired 
	private RoleRepository roleRepository;
	@Autowired
	private ServiceProviderProfileRepository serviceProviderProfile;
	@Autowired 
	private ClientProfileRepository clientProfileRepository;
	@Autowired
	private AdminService adminSvc;
	
	
	
	public UserService(){
		System.out.println("UserService!!!!!!!!!!!!!!!!!!!!");
	}
	
	public Role getRole(String role) {
		return roleRepository.findOne(role);
	}
	
	public void activateAccountbyTokeid(String tokenID)
	{
		Assert.notNull(tokenID);
		userRepository.activateAccount(tokenID);
		
	}
	
	public void activateServiceProviderbyTokeid(String tokenID)
	{
		Assert.notNull(tokenID);
		userRepository.activateAccount(tokenID);
		
	}
	
	public boolean create(UserProfile user) {
		Assert.isNull(user.getId());

		// duplicate username
		if (userRepository.findByUsername(user.getUsername()) != null) {
			return false;
		}
		user.setEnabled(false);
		user.setStatus(UserAccountStatus.STATUS_DISABLED.name());
		userRepository.save(user);
		return true;
	}
	
	public String CreateNewClientProfile(ClientProfile clientProfile){
		UserProfile up = userRepository.insert(clientProfile.getUserProfile());
		clientProfile.setId(up.getId());
		ClientProfile userAccount;
		userAccount = clientProfileRepository.insert(clientProfile);
			
		return userAccount.getId();
	}
	
	public String CreatenewServiceProviderRecord(ServiceProviderProfile serviceProviderProvider){
		Assert.notNull(serviceProviderProvider);
		System.out.println(serviceProviderProvider.getUserProfile());
		UserProfile up = userRepository.insert(serviceProviderProvider.getUserProfile());
		serviceProviderProvider.setUserProfile(up);
		
		
		/*
		SreviceProviderType spt= 
				adminSvc.getProvidedTypeById(serviceProviderProvider.getBusinessAccount().getServiceProvidrType().getId());
		Assert.notNull(spt);
		serviceProviderProvider.getBusinessAccount().setServiceProvidrType(spt);
		
		List<com.carkyp.serviceprovider.domain.ServiceProvided> serviceProvided =
				(List)adminSvc.getProvideds(serviceProviderProvider.getBusinessAccount().getServiceProvided());
		serviceProviderProvider.getBusinessAccount().setServiceProvided(serviceProvided);
		
		List<com.carkyp.serviceprovider.domain.BusinessFacilities> facilities =
				(List)adminSvc.getFacilities(serviceProviderProvider.getBusinessAccount().getBusinessFacilities());
		serviceProviderProvider.getBusinessAccount().setBusinessFacilities(facilities);
		
		*/
		ServiceProviderProfile sp1;
		sp1 = serviceProviderProfile.insert(serviceProviderProvider);
		
		return sp1.getId();
	}
	
	public void save(UserProfile user) {
		Assert.notNull(user.getId());
		userRepository.save(user);
	}
	
	public void delete(UserProfile user) {
		Assert.notNull(user.getId());
		userRepository.delete(user);
	}
	
	public UserProfile getByUsername(String username) {
		 
		
		return userRepository.findByUsername(username);
	}
}
