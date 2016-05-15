package com.carkyp.config;

import static com.carkyp.config.akka.SpringExtension.SpringExtProvider;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSenderImpl;
//import static config.akka.SpringExtension.SpringExtProvider;


import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import akka.actor.ActorSystem;

@EnableWebMvc

@Configuration
@PropertySource(value="classpath:carkyp.properties")
@EnableSpringConfigured
@ComponentScan(basePackages={"com.carkyp.controllers","com.carkyp.service","com.carkyp.useraccount.repository",
							"com.carkyp.admin.repositories"})
//@Import({ SecurityConfig.class })
public class AppConfig {
	
	@Autowired
	  private ApplicationContext applicationContext;
	
public AppConfig(){
		
		System.out.println("AppConfig!!!!!!!!!!!!!!!!!!!!!");
		
		
	}

@Bean
public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
   return new PropertySourcesPlaceholderConfigurer();
}

/**
 * Actor system singleton for this application.
 */
@Bean (name="ActorSystem")
public ActorSystem actorSystem() {
	  System.out.println("system issssssssssssssssssssssssss" );
	  try {
		  ActorSystem system = ActorSystem.create("AkkaJavaSpring");
		  System.out.println("system issssssssssssssssssssssssss2222222222" );
		  
		    // initialize the application context in the Akka Spring Extension
		    SpringExtProvider.get(system).initialize(applicationContext);
		    return system;
	} catch (Exception e) {
		System.err.println("ActorSystem initialized exception: " + e);
	}
  
	  System.err.println("no exception!!!!!!!!!!!!!!!!!!!!" );
  return null;
}
	
	
}