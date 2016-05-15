
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Update.update;
import static org.springframework.data.mongodb.core.query.Query.query;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.group;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.match;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.newAggregation;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.project;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.sort;










import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.catalina.tribes.util.UUIDGenerator;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.MatchOperation;
import org.springframework.data.mongodb.core.index.Index;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.CriteriaDefinition;
import org.springframework.data.mongodb.core.query.Order;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.*;

import com.carkyp.UseRoleStatus;
import com.carkyp.UserAccountStatus;
import com.carkyp.domain.Role;
import com.carkyp.domain.UserDetails;
import com.carkyp.domain.UserProfile;
import com.carkyp.domain.carReservation;
import com.carkyp.service.UserService;
import com.carkyp.serviceprovider.domain.ServiceProviderProfile;
import com.mongodb.Mongo;

public class MongoApp {

 // private static final Log log = LogFactory.getLog(MongoApp.class);

  public static void main(String[] args) throws Exception {
//	  DateTimeFormatter formatter = DateTimeFormat.forPattern("dd/MM/yyyy");
//		DateTime startdate= formatter.parseDateTime("01/01/1996");
//		DateTime endDate = formatter.parseDateTime("01/06/1997");
//	  
	  
    MongoOperations mongoOps = new MongoTemplate(new Mongo(), "sec");
  //  mongoOps.indexOps(UserProfile.class).ensureIndex(new Index().on("username",Order.ASCENDING));
    Aggregation aggregation = newAggregation(
    		unwind("priceDetails"),
    	    match(Criteria.where("priceDetails.serviceType").is("60000")
    	    		.and("priceDetails.carBrand").is("ford")
    	    		.and("priceDetails.carModel").is("Exploerer Tgi")),
    	    group("priceDetails.serviceType","priceDetails.carBrand","priceDetails.carModel").avg("priceDetails.price").as("avarage")
    	    .min("priceDetails.price").as("minPrice")
    	    .max("priceDetails.price").as("maxPrice"));
    	 //   sort(Sort.Direction.ASC, previousOperation(), "brand")    
    	//  );

    AggregationResults<PriceSummary> groupResults = mongoOps.aggregate(
    	    aggregation, ServiceProviderProfile.class, PriceSummary.class);
    	  
     List salesReport = groupResults.getMappedResults();
     System.out.println(salesReport);
    

 //   mongoOps.indexOps(UserProfile.class).ensureIndex(new Index().on("username",Order.ASCENDING));
//    Aggregation agg = newAggregation(
//			
//					  unwind("careReservation"),
//					  match(Criteria.where("careReservation.reservationDate").gte(startdate).lt(endDate).and("_id").is("markovich.oded@gmail.com")
//							   ),
//			project("careReservation.reservationDate","careReservation.clientDetail","careReservation.carDetail","careReservation.serviceType")
//			.and("providerId").previousOperation(),
//			
//			sort(Sort.Direction.DESC, "careReservation.reservationDate")
//				
//		);
//    
//    AggregationResults<CarReservation> groupResults  = mongoOps.aggregate(agg, ServiceProviderProfile.class, CarReservation.class);
//List<CarReservation> result = groupResults.getMappedResults();
//
//for(CarReservation n:result )
//	System.out.println(n);
////    List<Object> aggregationOperations = new ArrayList<>();
////    aggregationOperations.add(MatchOperation.(query(where("careReservation.reservationDate").gte(startdate).lt(endDate)
////			   .and("_id").is("markovich.odedgmail.com")))
////    
//////		   System.out.println(mongoOps.find(query(where("careReservation.reservationDate").gte(startdate).lt(endDate)
//////				   .and("_id").is("markovich.odedgmail.com")), ServiceProviderProfile.class));
////  // mongoOps.findOne(query(where("age").is(33)), ServiceProviderProfile.class);
//////    System.out.println( mongoOps
//////    		.updateFirst( new Query(where("userDetail.emailaddress").is(ua.getUserDetail().getEmailaddress()).and("token").is(ua.getToken())) ,
//////    				Update.update("status", UserAccountStatus.STATUS_APPROVED.name()),UserAccount.class));
//////    		
////    						
//
//   // mongoOps.dropCollection("person");
  }
}