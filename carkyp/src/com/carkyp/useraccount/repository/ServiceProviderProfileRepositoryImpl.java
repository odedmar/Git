package com.carkyp.useraccount.repository;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.group;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.match;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.newAggregation;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.project;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.sort;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.unwind;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import com.carkyp.controllers.domain.CarReservationDetails;
import com.carkyp.controllers.domain.PlateNumberdetails;
import com.carkyp.controllers.domain.PriceDetailSummary;
import com.carkyp.controllers.domain.PriceDetailSummaryQuery;
import com.carkyp.domain.CarReservationObjects;
import com.carkyp.domain.PriceDetail;
import com.carkyp.domain.RetriveCarReservation;
import com.carkyp.domain.carReservation;
import com.carkyp.serviceprovider.domain.ServiceProviderProfile;
import com.mongodb.WriteResult;

class ServiceProviderProfileRepositoryImpl implements ServiceProviderProfileRepositoryCustom {

	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public Boolean addCarReservation(carReservation carReservation) {
		
		WriteResult wr =mongoTemplate.updateFirst(
	        Query.query(Criteria.where("id").is(carReservation.getProviderId())), 
	        new Update().push("careReservation", carReservation.getCarReservation()), ServiceProviderProfile.class);
	  
		if(wr.isUpdateOfExisting())
			return Boolean.TRUE;
		
		 return Boolean.FALSE;
	}

	@Override
	public List<CarReservationDetails> retriveReservationDetails(
			RetriveCarReservation query) 
{
		 DateTimeFormatter formatter = DateTimeFormat.forPattern("dd/MM/yyyy");
		 DateTime startdate= formatter.parseDateTime(query.getStarDate());
		 DateTime endDate = formatter.parseDateTime(query.getEndDate());
		 
		  Aggregation agg = newAggregation(
				  unwind("careReservation"),
				  match(Criteria.where("careReservation.reservationDate").gte(startdate).lt(endDate).and("_id").is(query.getMailId())
						   ),
                  project("careReservation.reservationDate","careReservation.clientDetail","careReservation.carDetail","careReservation.serviceType"),
		          sort(Sort.Direction.DESC, "careReservation.reservationDate")
			
	);

	  AggregationResults<CarReservationObjects> groupResults  = mongoTemplate.aggregate(agg, ServiceProviderProfile.class, CarReservationObjects.class);
      List<CarReservationObjects> result = groupResults.getMappedResults();
      List<CarReservationDetails> result1 = new ArrayList<>();
      
      for(CarReservationObjects n : result)
      {
    	  CarReservationDetails detail = new CarReservationDetails();
    	  detail.setCarDetail(n.getCarDetail());
    	  detail.setClientDetail(n.getClientDetail());
    	  detail.setReservationDate(n.getReservationDate());
    	  detail.setServiceType(n.getServiceType());
    	  result1.add(detail);
      }
      Collections.sort(result1);
		return result1;
	}

	@Override
	public Boolean updateCarDetails(PlateNumberdetails carDetail) {
		
		DateTimeFormatter formatter = DateTimeFormat.forPattern("dd/MM/yyyy");
		DateTime registrationdate= formatter.parseDateTime(carDetail.getRegistrationDate());
		
		
		WriteResult wr = mongoTemplate.upsert(Query.query(Criteria.where("id").is(carDetail.getSpid())),
				new Update().set("carDetail.platenumber", carDetail.getPlateNo()).
				set("carDetail.treatmentDate",registrationdate ).
				set("carDetail.vinNumber", carDetail.getVinNumber()), ServiceProviderProfile.class);
		if(wr.isUpdateOfExisting())
			return Boolean.TRUE;
		
		 return Boolean.FALSE;
		
		
	}

	@Override
	public Boolean SetCarecarePriceDetail(PriceDetail priceDetail) {
		
		com.carkyp.serviceprovider.domain.PriceDetail priceDetailDB= 
				new com.carkyp.serviceprovider.domain.PriceDetail(priceDetail.getServiceType(),
						priceDetail.getCarBrand(),priceDetail.getCarModel(),
						priceDetail.getPrice());
		
		WriteResult wr =mongoTemplate.updateFirst(
		        Query.query(Criteria.where("id").is(priceDetail.getProviderId())), 
		        new Update().push("priceDetails", priceDetailDB), ServiceProviderProfile.class);
		  
			if(wr.isUpdateOfExisting())
				return Boolean.TRUE;
			
			 return Boolean.FALSE;
		
	}

	@Override
	public PriceDetailSummary getPriceDetailsSummery(
			PriceDetailSummaryQuery qury) {
		
		 Aggregation aggregation = newAggregation(
		    		unwind("priceDetails"),
		    	    match(Criteria.where("priceDetails.serviceType").is(qury.getServiceType())
		    	    		.and("priceDetails.carBrand").is(qury.getCarBrand())
		    	    		.and("priceDetails.carModel").is(qury.getCarModel())),
		    	    group("priceDetails.serviceType","priceDetails.carBrand","priceDetails.carModel").avg("priceDetails.price").as("avarage")
		    	    .min("priceDetails.price").as("minPrice")
		    	    .max("priceDetails.price").as("maxPrice"));
		    	 //   sort(Sort.Direction.ASC, previousOperation(), "brand")    
		    	//  );

		    AggregationResults<PriceDetailSummary> groupResults = mongoTemplate.aggregate(
		    	    aggregation, ServiceProviderProfile.class, PriceDetailSummary.class);
		    	  
		     List salesReport = groupResults.getMappedResults();
		     PriceDetailSummary priceSummery = (PriceDetailSummary)salesReport.get(0);
		return priceSummery;
	}
	
	
}
