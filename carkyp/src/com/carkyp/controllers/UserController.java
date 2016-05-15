package com.carkyp.controllers;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.carkyp.UserAccountStatus;
import com.carkyp.controllers.domain.BusinessFacilities;
import com.carkyp.domain.ClientProfile;
import com.carkyp.domain.UserProfile;
import com.carkyp.domain.UserDetails;
import com.carkyp.exception.ErrorResponse;
import com.carkyp.service.Dispatcher;
//import com.carkyp.service.email.events.MailRequestEvent;
import com.carkyp.service.email.model.MailRequest;
import com.carkyp.service.provider.events.ProviderAccountRegistrationEvent;
import com.carkyp.service.provider.events.clientProfileRegistrationEvent;
import com.carkyp.service.provideraccount.model.BusinessAccount;
import com.carkyp.serviceprovider.domain.BusinessInformation;
import com.carkyp.serviceprovider.domain.BusinessOpenHour;
import com.carkyp.serviceprovider.domain.BusnessDetail;
import com.carkyp.serviceprovider.domain.ServiceProvided;
import com.carkyp.serviceprovider.domain.ServiceProvidedBrand;
import com.carkyp.serviceprovider.domain.ServiceProvidedBrandInternal;
import com.carkyp.serviceprovider.domain.ServiceProvidedInternal;
import com.carkyp.serviceprovider.domain.ServiceProviderProfile;
import com.carkyp.serviceprovider.domain.ServiceProviderTypeInternal;
import com.carkyp.serviceprovider.domain.SreviceProviderType;
import com.mongodb.MongoException;



@RestController
public class UserController {
	
	@Autowired
	Dispatcher dispatcher;	
	@Value( "${mail.confirmationUrl}" )
	private  String confirmationUrl;
	@Value( "${mail.subject}" )
	private String SUBJECT;
	@Value( "${mail.sender}" )
	private String FROM;
	
	public UserController(){
		System.out.println("UserController!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
	}
	
	
	@RequestMapping(value = "rest/register", method = RequestMethod.POST,produces = "application/json" )
	public ResponseEntity<String> registration(@RequestBody @Valid UserDetails userDetails){
		System.out.println("print in conroller" + userDetails);
		
		String token = UUID.randomUUID().toString();
	
		MailRequest mailrequest = new MailRequest();
		UserProfile UserProfile = new UserProfile();
		ClientProfile clientProfile = new ClientProfile();
		
		
		UserProfile.setEnabled(Boolean.TRUE);
		UserProfile.setPassword(userDetails.getPassword());
		UserProfile.setStatus(UserAccountStatus.STATUS_PENDING.name());
		UserProfile.setToken(token);
		clientProfile.setUserDetail(userDetails);
		UserProfile.setUsername(userDetails.getEmailaddress());
		clientProfile.setUserProfile(UserProfile);
		
		
		mailrequest.setLastName(userDetails.getLastname());
		mailrequest.setName(userDetails.getFirstname());
		mailrequest.setSourceMail(userDetails.getEmailaddress());
		mailrequest.setTo((userDetails.getEmailaddress()));
		mailrequest.setSubject(SUBJECT);
		mailrequest.setFrom(FROM);
		
		mailrequest.setText(confirmationUrl+ token);
		
		clientProfileRegistrationEvent registretionevent = new clientProfileRegistrationEvent(clientProfile, mailrequest);
		
        
        
       // String message = messages.getMessage("message.regSucc", null, event.getLocale());
        
		
		String objectid = dispatcher.registerNewClientProfile(registretionevent);
		return new ResponseEntity<String>(objectid,HttpStatus.OK);
		
	
	}
	
	@RequestMapping(value = "rest/register/serviceprovider", method = RequestMethod.POST,produces = "application/json" )
	public ResponseEntity<String> registration(@RequestBody @Valid BusinessAccount businessDetailsAccount){
		
		System.out.println("print in conroller" + businessDetailsAccount.toString());
		
		String token = UUID.randomUUID().toString();
	
		MailRequest mailrequest = new MailRequest();
		com.carkyp.serviceprovider.domain.BusinessAccount businessaccount = new com.carkyp.serviceprovider.domain.BusinessAccount();
		UserProfile userprofile = new UserProfile();
		BusnessDetail businessDetail = new  BusnessDetail();
		ServiceProviderProfile providerProfile = new ServiceProviderProfile();
		
		
		businessDetail.setAddress(businessDetailsAccount.getBusinessDetail().getAddress());
		businessDetail.setBusinessName(businessDetailsAccount.getBusinessDetail().getBusinessName());
		businessDetail.setContactFirstName(businessDetailsAccount.getBusinessDetail().getContactFirstName());
		businessDetail.setContactLastName(businessDetailsAccount.getBusinessDetail().getContactLastName());
		
		
		
		userprofile.setEnabled(Boolean.TRUE);
		userprofile.setPassword((businessDetailsAccount.getBusinessDetail().getPassword()));
		userprofile.setStatus(UserAccountStatus.STATUS_PENDING.name());
		userprofile.setToken(token);
		userprofile.setUsername(businessDetailsAccount.getBusinessDetail().getEmail());
		
		businessDetail.setEmail(businessDetailsAccount.getBusinessDetail().getEmail());
		businessDetail.setPhoneNumber(businessDetailsAccount.getBusinessDetail().getPhoneNumber());
		businessaccount.setBusinessDetail(businessDetail);
		
	
		List<com.carkyp.serviceprovider.domain.BusinessFacilitiesInternal> facilities = new ArrayList<com.carkyp.serviceprovider.domain.BusinessFacilitiesInternal>();
		for(String Id :businessDetailsAccount.getBusinessFacilitiesname()){
			com.carkyp.serviceprovider.domain.BusinessFacilitiesInternal bf = new com.carkyp.serviceprovider.domain.BusinessFacilitiesInternal();
			bf.setId(Id);
			facilities.add(bf);
		}
		businessaccount.setBusinessFacilities(facilities);
		
		BusinessInformation businessInformation = new BusinessInformation();
		businessInformation.setLifts(businessDetailsAccount.getBusinessInformation().getLifts());
		businessInformation.setNumberOfEmploies(businessDetailsAccount.getBusinessInformation().getNumberOfEmploies());
		businessInformation.setSize(businessDetailsAccount.getBusinessInformation().getSize());
		businessaccount.setBusinessInformation(businessInformation);
		
		BusinessOpenHour openHoure = new BusinessOpenHour();
		openHoure.setEndWeekDay(businessDetailsAccount.getBusinessopenHour().getEndWeekDay());
		openHoure.setStartTime(businessDetailsAccount.getBusinessopenHour().getStartTime() );
		openHoure.setEndTime(businessDetailsAccount.getBusinessopenHour().getEndTime());
		openHoure.setStartWeekDay(businessDetailsAccount.getBusinessopenHour().getStartWeekDay());
		businessaccount.setBusinessopenHour(openHoure);
		
		List<ServiceProvidedInternal> providedService = new ArrayList<ServiceProvidedInternal>();
		for(String provided:businessDetailsAccount.getServiceProvidedId()){
			ServiceProvidedInternal pr = new ServiceProvidedInternal();
			pr.setId(provided);
			providedService.add(pr);
		}
		businessaccount.setServiceProvided(providedService);
		
		List<ServiceProvidedBrandInternal> providedBrand = new ArrayList<ServiceProvidedBrandInternal>();
		for(String Id : businessDetailsAccount.getServiceProvidedId()){
			ServiceProvidedBrandInternal spbr = new ServiceProvidedBrandInternal();
			spbr.setId(Id);
			providedBrand.add(spbr);
		}
		businessaccount.setServiceProvidedBrands(providedBrand);
		
		ServiceProviderTypeInternal sprt = new ServiceProviderTypeInternal();
		sprt.setId(businessDetailsAccount.getServiceProvidrTypeId());
		businessaccount.setServiceProvidrType(sprt);
		
		
		providerProfile.setUserProfile(userprofile);
		providerProfile.setBusinessAccount(businessaccount);
		
			
		mailrequest.setLastName(businessDetail.getBusinessName());
		mailrequest.setName(businessDetail.getContactFirstName());
		mailrequest.setSourceMail(businessDetail.getEmail());
		mailrequest.setTo((businessDetail.getEmail()));
		mailrequest.setSubject(SUBJECT);
		mailrequest.setText(confirmationUrl + token);
		mailrequest.setFrom(FROM);
		
		providerProfile.setEmail(businessDetail.getEmail());
		ProviderAccountRegistrationEvent providerRegistration = new ProviderAccountRegistrationEvent(providerProfile, mailrequest);
		
		String objectid = dispatcher.registerNewBusinessAccount(providerRegistration);
        
       // String message = messages.getMessage("message.regSucc", null, event.getLocale());
        
		
		return new ResponseEntity<String>(objectid,HttpStatus.OK);
		
	
	}
	
	@RequestMapping(value = "rest/regitrationConfirm{token}", method = RequestMethod.GET)
	public String regitrationConfirm(@PathVariable String token){
		System.out.println("print in regitrationConfirm conroller" + token);
		
		dispatcher.activateAccountByTokenId(token);
		
		return "redirect:/test.html";
		
	
	}
	
	@RequestMapping(value = "rest/serviceProfileConfirm{token}", method = RequestMethod.GET)
	public String serviceProfileConfirm(@PathVariable String token){
		System.out.println("print in regitrationConfirm conroller" + token);
		
		dispatcher.activateAccountByTokenId(token);
		
		return "redirect:/test.html";
		
	
	}
	
	@RequestMapping(value = "rest/register", method = RequestMethod.GET)
	public ResponseEntity<HttpStatus> signIn(){
		System.out.println("print in conroller");
		
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}
	
	
	@RequestMapping(value="/upload", method=RequestMethod.POST)
    public @ResponseBody String handleFileUpload( 
            @RequestParam("file") MultipartFile file){
            String name = "test11";
        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
                BufferedOutputStream stream = 
                        new BufferedOutputStream(new FileOutputStream(new File(name + "-uploaded")));
                stream.write(bytes);
                stream.close();
                return "You successfully uploaded " + name + " into " + name + "-uploaded !";
            } catch (Exception e) {
                return "You failed to upload " + name + " => " + e.getMessage();
            }
        } else {
            return "You failed to upload " + name + " because the file was empty.";
        }
    }
	
	

}
