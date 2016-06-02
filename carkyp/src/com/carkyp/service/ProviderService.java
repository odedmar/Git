package com.carkyp.service;

import java.awt.font.TextLayout.CaretPolicy;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.carkyp.controllers.domain.CarReservationDetails;
import com.carkyp.controllers.domain.PlateNumberdetails;
import com.carkyp.controllers.domain.PriceDetailSummary;
import com.carkyp.controllers.domain.PriceDetailSummaryQuery;
import com.carkyp.domain.CarReservationObjects;
import com.carkyp.domain.PriceDetail;
import com.carkyp.domain.RetriveCarReservation;
import com.carkyp.domain.carReservation;
import com.carkyp.service.provideraccount.model.AdditionallDetails;
import com.carkyp.service.provideraccount.model.ServiceProviderDetails;
import com.carkyp.serviceprovider.domain.ServiceProviderProfile;
import com.carkyp.useraccount.repository.ServiceProviderProfileRepository;

@Service
public class ProviderService {
	@Autowired
	private ServiceProviderProfileRepository serviceProviderProfile;
	
	public void addCarReservation(carReservation reservation){
		Assert.notNull(reservation);
		serviceProviderProfile.addCarReservation(reservation);
		
	}
	public List<CarReservationDetails> retriveCarReservationDetails(RetriveCarReservation reservation){
		Assert.notNull(reservation);
		List<CarReservationDetails> reservationDetails=  serviceProviderProfile.retriveReservationDetails(reservation);
		return reservationDetails;
	}
	
	public Boolean updateCarDetails(PlateNumberdetails carDetail)
	{
		Assert.notNull(carDetail);
		return serviceProviderProfile.updateCarDetails(carDetail);
	}
	
	public Boolean insertCarProviderPriceDetail(PriceDetail pricaDetaill){
		Assert.notNull(pricaDetaill);
		return serviceProviderProfile.SetCarecarePriceDetail(pricaDetaill);
	}
	
	public PriceDetailSummary getPriceDetailSummery(PriceDetailSummaryQuery pricaDetaillSumQuey){
		Assert.notNull(pricaDetaillSumQuey);
		return serviceProviderProfile.getPriceDetailsSummery(pricaDetaillSumQuey);
	}
	public void addAditinalPriceDetail(AdditionallDetails additionals){
		Assert.notNull(additionals);
		serviceProviderProfile.setAdditionals(additionals);
	}
	public void updateAditinalPriceDetail(AdditionallDetails additionals){
		Assert.notNull(additionals);
		serviceProviderProfile.updateAdditionals(additionals);
	}
	public ServiceProviderDetails retriveProviderInformation(String providerid){
		ServiceProviderProfile providerProfile = serviceProviderProfile.findOne(providerid);
		ServiceProviderDetails providerDeatils = new ServiceProviderDetails();
		providerDeatils.setEmail(providerProfile.getEmail());
		providerDeatils.setAdditionalPrice(providerProfile.getAdditionalPrice());
		providerDeatils.setBusinessAccount(providerProfile.getBusinessAccount());
		providerDeatils.setCareReservation(providerProfile.getCareReservation());
		providerDeatils.setPriceDetails(providerProfile.getPriceDetails());
		return providerDeatils;
	}

}
