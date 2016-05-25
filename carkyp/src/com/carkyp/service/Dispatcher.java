package com.carkyp.service;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import scala.concurrent.duration.Duration;

import com.carkyp.controllers.domain.BusinessFacilities;
import com.carkyp.controllers.domain.CarReservationDetails;
import com.carkyp.controllers.domain.PlateNumberdetails;
import com.carkyp.controllers.domain.PriceDetailSummary;
import com.carkyp.controllers.domain.PriceDetailSummaryQuery;
import com.carkyp.controllers.domain.ServiceProvided;
import com.carkyp.controllers.domain.ServiceProvidedBrand;
import com.carkyp.controllers.domain.ServiceProvidedType;
import com.carkyp.domain.CarReservationObjects;
import com.carkyp.domain.PriceDetail;
import com.carkyp.domain.RetriveCarReservation;
import com.carkyp.domain.carReservation;
import com.carkyp.service.email.EmailServiceActor;



//import com.carkyp.service.email.events.MailRequestEvent;
import com.carkyp.service.provider.events.ProviderAccountRegistrationEvent;
import com.carkyp.service.provider.events.carReservationEvent;
import com.carkyp.service.provider.events.clientProfileRegistrationEvent;





import com.carkyp.service.provideraccount.model.AdditionallDetails;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Inbox;
import akka.actor.Props;
import akka.routing.SmallestMailboxRouter;


@Service
@DependsOn("ActorSystem")

public class Dispatcher  implements AutoCloseable{

	
	
	@Autowired 
	private UserService userService;
	@Autowired
	private AdminService adminservice;
	@Autowired
	private ProviderService providerSrv;
	private ActorSystem actorSystem;
	//private ActorRef myActor ;
	private ActorRef sendMailServiceActor;
	
	private  Inbox inbox ;
	
	@Autowired
	public Dispatcher(ActorSystem actorSystem){
		
		this.actorSystem = actorSystem;
		if(actorSystem!=null){
			inbox =  Inbox.create(actorSystem);
//			myActor = actorSystem.actorOf(Props.create(MailServiceActor.class),
//					  "myactor");
//			sendMailServiceActor =  actorSystem.actorOf(Props.create(SendMailServiceActor.class),
//					  "registerAccountRef");
			sendMailServiceActor = actorSystem.actorOf(Props.create(EmailServiceActor.class).withRouter
	                (new SmallestMailboxRouter(50)), "emailService");
		
		}else{
			System.out.println("Dispatcher is nullllllllllllllll");
		}
		
	}
	
//	public void SendMail(MailRequestEvent mail){
//		System.out.println("send mail in despather!!!");
//	//	inbox.send(myActor, mail);
//	}
	
	public String registerNewClientProfile(clientProfileRegistrationEvent register){
		System.out.println("UserAccountEvent in despather!!!");
		String objectId = userService.CreateNewClientProfile(register.getClientProfile());
		inbox.send(sendMailServiceActor,  register.getMailRequest());
		//String answer  = (String)inbox.receive(Duration.create(2, TimeUnit.SECONDS));
		
		return objectId;

	}
	
	public String registerNewBusinessAccount(ProviderAccountRegistrationEvent register){
		System.out.println("registerNewBusinessAccount in despather!!!");
		String Objectid = userService.CreatenewServiceProviderRecord(register.getServiceproviderProfile());
		inbox.send(sendMailServiceActor,  register.getMailRequest());
		//String answer  = (String)inbox.receive(Duration.create(2, TimeUnit.SECONDS));
		
		return Objectid;

	}
	
	public void activateAccountByTokenId(String tokenId)
	{
		Assert.notNull(tokenId);
		userService.activateAccountbyTokeid(tokenId);
		
	}
	
	public void activateServiceProviderByTokenId(String tokenId)
	{
		Assert.notNull(tokenId);
		userService.activateAccountbyTokeid(tokenId);
		
	}
	public void registerCarReservation(carReservationEvent carReservationEvent)
	{
		Assert.notNull(carReservationEvent);
		providerSrv.addCarReservation(carReservationEvent.getCarReservation());
		
	}
	public Boolean insertSreviceProvided(List<ServiceProvided> serviceProvided)
	{
		Assert.notNull(serviceProvided);
		return adminservice.createServiceProvided(serviceProvided);
		
	}
	
	public List<CarReservationDetails> retriveCarReservationDetails(RetriveCarReservation queryObject)
	{
		List<CarReservationDetails> list =  providerSrv.retriveCarReservationDetails(queryObject);
		return list;
	}
	
	public Boolean insertSreviceProvidedType(List<ServiceProvidedType> serviceProvidedType)
	{
		Assert.notNull(serviceProvidedType);
		return adminservice.createServiceProvidedType(serviceProvidedType);
		
	}
	public Boolean insertSreviceProvidedBrand(List<ServiceProvidedBrand> serviceProvidedBrand)
	{
		Assert.notNull(serviceProvidedBrand);
		return adminservice.createServiceProvidedBrand(serviceProvidedBrand);
		
	}
	public Boolean insertSreviceBusinessFacilities(List<BusinessFacilities> businessFacilities)
	{
		Assert.notNull(businessFacilities);
		return adminservice.createBusinessFacilities(businessFacilities);
		
	}
	
	public Boolean updateCarDetails(PlateNumberdetails carDetail)
	{
		Assert.notNull(carDetail);
		return providerSrv.updateCarDetails(carDetail);
		
	}
	
	public Boolean setProviderPriceDetails(PriceDetail priceDetail)
	{
		Assert.notNull(priceDetail);
		return providerSrv.insertCarProviderPriceDetail(priceDetail);
		
	}
	
	public PriceDetailSummary getProviderPriceDetails(PriceDetailSummaryQuery priceDetailSumQuery)
	{
		Assert.notNull(priceDetailSumQuery);
		return providerSrv.getPriceDetailSummery(priceDetailSumQuery);
		
	}
	
	public void addAdditionalPriceDetails(AdditionallDetails additional)
	{
		Assert.notNull(additional);
		providerSrv.addAditinalPriceDetail(additional);
		
	}
	

	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
		inbox.send(sendMailServiceActor,  "done");
		String answer  = (String)inbox.receive(Duration.create(5, TimeUnit.SECONDS));
		System.out.println("finalize!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		if(actorSystem!=null)
			actorSystem.shutdown();
	}

@Override
public void close() throws Exception {
	System.err.println("close has been called");
	inbox.send(sendMailServiceActor,  "done");
	String answer  = (String)inbox.receive(Duration.create(5, TimeUnit.SECONDS));
	if(actorSystem!=null)
		actorSystem.shutdown();
	
}
	

	
}
