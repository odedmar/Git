package com.carkyp.useraccount.repository;

import java.util.List;

import com.carkyp.controllers.domain.CarReservationDetails;
import com.carkyp.controllers.domain.PlateNumberdetails;
import com.carkyp.controllers.domain.PriceDetailSummary;
import com.carkyp.controllers.domain.PriceDetailSummaryQuery;
import com.carkyp.domain.CarReservationObjects;
import com.carkyp.domain.PriceDetail;
import com.carkyp.domain.RetriveCarReservation;
import com.carkyp.domain.UserProfile;
import com.carkyp.domain.carReservation;
import com.carkyp.serviceprovider.domain.CarCareReservation;

interface ServiceProviderProfileRepositoryCustom {
	  public Boolean addCarReservation(carReservation carReservation);
	  List<CarReservationDetails> retriveReservationDetails(RetriveCarReservation query);
	  public Boolean updateCarDetails(PlateNumberdetails carDetail);
	  public Boolean SetCarecarePriceDetail(PriceDetail priceDetail);
	  public PriceDetailSummary getPriceDetailsSummery(PriceDetailSummaryQuery qury);
	  
	  
	}
