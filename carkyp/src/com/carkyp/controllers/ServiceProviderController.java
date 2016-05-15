package com.carkyp.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.carkyp.controllers.domain.CarReservationDetails;
import com.carkyp.controllers.domain.PlateNumberdetails;
import com.carkyp.controllers.domain.PriceDetailSummary;
import com.carkyp.controllers.domain.PriceDetailSummaryQuery;
import com.carkyp.domain.CarReservationObjects;
import com.carkyp.domain.PriceDetail;
import com.carkyp.domain.RetriveCarReservation;
import com.carkyp.domain.carReservation;
import com.carkyp.service.Dispatcher;
import com.carkyp.service.provider.events.ProviderAccountRegistrationEvent;
import com.carkyp.service.provider.events.carReservationEvent;
import com.carkyp.service.provideraccount.model.BusinessAccount;
import com.carkyp.serviceprovider.domain.CarCareReservation;


@RestController
public class ServiceProviderController {
	
	@Autowired
	Dispatcher dispatcher;	
	
	
	public ServiceProviderController(){
		System.out.println("ServiceProviderController!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
	}
	
	
	
	@RequestMapping(value = "rest/retrivecarreservation", method = RequestMethod.POST)
	public ResponseEntity<List<CarReservationDetails>> retriveCarReservationDetails(@RequestBody @Valid RetriveCarReservation query  ){
		
		List<CarReservationDetails> list =  dispatcher.retriveCarReservationDetails(query);
		return  new ResponseEntity<List<CarReservationDetails>>(list,HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "rest/updatecardetails", method = RequestMethod.POST)
	public ResponseEntity<Boolean> saveCarDetails(@RequestBody @Valid PlateNumberdetails carDetail  ){
		
		Boolean result= dispatcher.updateCarDetails(carDetail);
		return  new ResponseEntity(result,HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "rest/carreservation", method = RequestMethod.POST)
	public String reservationConfirm(@RequestBody @Valid carReservation reservation){
		
		CarCareReservation carReservation = reservation.getCarReservation();
		if(carReservation==null){
			carReservation = new CarCareReservation();
		}
		carReservation.setReservationDate(reservation.getDateReservation());
		reservation.setCarReservation(carReservation);
		carReservationEvent carResrevation = new carReservationEvent(reservation);
		
		dispatcher.registerCarReservation(carResrevation);
		
		
		return "redirect:/test.html";
		
	
	}
	
	@RequestMapping(value = "rest/insertprovidercarprice", method = RequestMethod.POST)
	public ResponseEntity<Boolean> inserProviderCarprice(@RequestBody @Valid PriceDetail priceDetail  ){
		
		Boolean result= dispatcher.setProviderPriceDetails(priceDetail);
		return  new ResponseEntity(result,HttpStatus.OK);
	}
	
	@RequestMapping(value = "rest/getpricesummery", method = RequestMethod.POST)
	public ResponseEntity<PriceDetailSummary> getPriceSummery(@RequestBody @Valid PriceDetailSummaryQuery priceSummeryQuery  ){
		
		PriceDetailSummary result= dispatcher.getProviderPriceDetails(priceSummeryQuery);
		return  new ResponseEntity<PriceDetailSummary>(result,HttpStatus.OK);
	}
}