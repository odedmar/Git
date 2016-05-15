package com.carkyp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.carkyp.admin.repositories.BusinessFacilitiesRepository;
import com.carkyp.admin.repositories.ServiceProvidedBrandRepository;
import com.carkyp.admin.repositories.ServiceProvidedRepository;
import com.carkyp.admin.repositories.SreviceProviderTypeRepository;
import com.carkyp.controllers.domain.BusinessFacilities;
import com.carkyp.controllers.domain.ServiceProvided;
import com.carkyp.controllers.domain.ServiceProvidedBrand;
import com.carkyp.controllers.domain.ServiceProvidedType;

@Service
public class AdminService {
	
	@Autowired
	private ServiceProvidedRepository serviceprovidedrepository;
	@Autowired
	private SreviceProviderTypeRepository serviceprovidedRepositoryType;
	@Autowired
	ServiceProvidedBrandRepository serviceProvidedBrandRepository;
	@Autowired
	BusinessFacilitiesRepository businessFacilitiesRepository;
	
	
	public Boolean createServiceProvided(List<ServiceProvided> serviceprovided){
		Assert.notEmpty(serviceprovided);
		
		List<com.carkyp.serviceprovider.domain.ServiceProvided> listProvided = new ArrayList<com.carkyp.serviceprovider.domain.ServiceProvided>();
		for(ServiceProvided srvp:serviceprovided){
			
			com.carkyp.serviceprovider.domain.ServiceProvided provided = new com.carkyp.serviceprovider.domain.ServiceProvided(); 
			provided.setName(srvp.getProvidedName());
			listProvided.add(provided);
		}	
		
		serviceprovidedrepository.insert(listProvided);
		return Boolean.TRUE;
	}
	
	public Iterable<com.carkyp.serviceprovider.domain.ServiceProvided> getProvideds(List<com.carkyp.serviceprovider.domain.ServiceProvided> ids){
		
		List<String> idsList = new ArrayList<String>();
		for(com.carkyp.serviceprovider.domain.ServiceProvided sp : ids){
			idsList.add(sp.getId());
		}
		
		return serviceprovidedrepository.findAll(idsList);
		
	}
	
	public Iterable<com.carkyp.serviceprovider.domain.BusinessFacilities> getFacilities(List<com.carkyp.serviceprovider.domain.BusinessFacilities> ids){
		
		List<String> idsList = new ArrayList<String>();
		for(com.carkyp.serviceprovider.domain.BusinessFacilities sp : ids){
			idsList.add(sp.getId());
		}
		
		return businessFacilitiesRepository.findAll(idsList);
		
	}
	
	public Boolean createServiceProvidedType(List<ServiceProvidedType> serviceprovidedtype){
		Assert.notEmpty(serviceprovidedtype);
		
		List<com.carkyp.serviceprovider.domain.SreviceProviderType> listProvided = new ArrayList<com.carkyp.serviceprovider.domain.SreviceProviderType>();
		for(ServiceProvidedType srvp:serviceprovidedtype){
			
			com.carkyp.serviceprovider.domain.SreviceProviderType provided = new com.carkyp.serviceprovider.domain.SreviceProviderType(); 
			provided.setName(srvp.getName());
			listProvided.add(provided);
		}	
		
		serviceprovidedRepositoryType.insert(listProvided);
		return Boolean.TRUE;
	}
	
	
	
	
	public com.carkyp.serviceprovider.domain.SreviceProviderType getProvidedTypeById(String id){
		return serviceprovidedRepositoryType.findOne(id);
	}
	
	public Boolean createServiceProvidedBrand(List<ServiceProvidedBrand> serviceprovidedBrand){
		Assert.notEmpty(serviceprovidedBrand);
		
		List<com.carkyp.serviceprovider.domain.ServiceProvidedBrand> listProvidedBrand = new ArrayList<com.carkyp.serviceprovider.domain.ServiceProvidedBrand>();
		for(ServiceProvidedBrand srvp:serviceprovidedBrand){
			
			com.carkyp.serviceprovider.domain.ServiceProvidedBrand provided = new com.carkyp.serviceprovider.domain.ServiceProvidedBrand(); 
			provided.setBrandGroup(srvp.getBrandGroup());
			listProvidedBrand.add(provided);
		}	
		
		serviceProvidedBrandRepository.insert(listProvidedBrand);
		return Boolean.TRUE;
	}
	
	public Boolean createBusinessFacilities(List<BusinessFacilities> businessFacilities){
		Assert.notEmpty(businessFacilities);
		
		List<com.carkyp.serviceprovider.domain.BusinessFacilities> listbusinessFacilities = new ArrayList<com.carkyp.serviceprovider.domain.BusinessFacilities>();
		for(BusinessFacilities srvp:businessFacilities){
			
			com.carkyp.serviceprovider.domain.BusinessFacilities provided = new com.carkyp.serviceprovider.domain.BusinessFacilities(); 
			provided.setFacilitiesName(srvp.getFacilitiesName());;
			listbusinessFacilities.add(provided);
		}	
		
		businessFacilitiesRepository.insert(listbusinessFacilities);
		return Boolean.TRUE;
	}

}
