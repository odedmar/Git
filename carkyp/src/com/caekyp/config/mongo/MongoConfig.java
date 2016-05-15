package com.caekyp.config.mongo;



import java.net.UnknownHostException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.authentication.UserCredentials;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.config.ServerAddressPropertyEditor;
import org.springframework.data.mongodb.core.MongoFactoryBean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.core.WriteResultChecking;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.data.repository.query.QueryLookupStrategy;

import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.ServerAddress;
import com.mongodb.WriteConcern;

@Configuration
@ComponentScan(basePackages={"com.carkyp.controllers","com.carkyp.service","com.carkyp.exception"})

@EnableMongoRepositories(basePackages={"com.carkyp.useraccount.repository","com.carkyp.admin.repositories"})
public class MongoConfig extends AbstractMongoConfiguration{

	private String mongoDbAddress = "localhost";
	private int port=27017;
	
	 public MongoConfig(){
		 System.out.println("print AppConfig!!!!!!!!!!!!!!!!!!!!!");
	 }
	 
	 
	 
	 
	 @Bean
	    public MongoClient getMongo() throws UnknownHostException
	    {
	        MongoClientOptions options = MongoClientOptions.builder()
	                .connectionsPerHost( 150 )
	                .writeConcern( WriteConcern.ERRORS_IGNORED ).build();
	 
	        ServerAddress severAddress = new ServerAddress( mongoDbAddress );
	 
	        return new MongoClient( severAddress, options );
	    }
	 
    /*
     * Factory bean that creates the com.mongodb.Mongo instance
     */
     public @Bean Mongo mongo() throws Exception {
    	 System.out.println("print AppConfig!!!!!!!!!!!!!!!!!!!!!11111");
          return new Mongo(mongoDbAddress, port);
        
     }
     
     
     public @Bean MongoDbFactory mongoDbFactory() throws Exception {
    	 System.out.println("print AppConfig!!!!!!!!!!!!!!!!!!!!!111");
    	   // UserCredentials userCredentials = new UserCredentials("joe", "secret");
    	    return new SimpleMongoDbFactory( mongo(), "carkyp");
    	  }

    	  public @Bean MongoTemplate mongoTemplate() throws Exception {
    		  
    		  MongoTemplate mtemplate = new  MongoTemplate(mongoDbFactory());
    		  mtemplate.setWriteResultChecking(WriteResultChecking.EXCEPTION);
    		  
    	    return mtemplate;
    	  }
        
//    	  public @Bean CascadingMongoEventListener cascadingMongoEventListener() throws Exception {
//    		  
//    		     		  
//    	    return new CascadingMongoEventListener();
//    	  }
    	  
    	  
		@Override
		protected String getDatabaseName() {
			// TODO Auto-generated method stub
			return "sec";
		}
		
		
//public class MongoConfig extends AbstractMongoConfiguration {
//
//    @Override
//    protected String getDatabaseName() {
//        return "dataBaseName";
//    }
//
//    @Override
//    public Mongo mongo() throws Exception {
//        return new MongoClient("127.0.0.1", 27017);
//    }
//
//    @Override
//    protected String getMappingBasePackage() {
//        return "foo.bar.domain";
//    }
}



