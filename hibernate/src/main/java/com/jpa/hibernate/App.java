package com.jpa.hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        Subscriber sub = new Subscriber();
        sub.setName("oded");
        
        
        Configuration configuration = new Configuration().configure();
       	StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().
       	applySettings(configuration.getProperties());
       	SessionFactory factory = configuration.buildSessionFactory(builder.build());
       	
       	Address addr = new Address();
       	addr.setCity("Rishn");
       	addr.setStreet("Rupin 12");
       	
       	Address addr1 = new Address();
       	addr1.setCity("Tel aviv");
       	addr1.setStreet("ganani");
       	
    	sub.getAdresses().add(addr);
      	sub.getAdresses().add(addr1);
       	
       	addr.setUser(sub);
       	addr1.setUser(sub);
       	
       	Session session = factory.openSession();
       	
       	session.beginTransaction();
       	session.save(sub);
       	session.save(addr);
       	session.save(addr1);
       	
       	session.getTransaction().commit();
       	session.close();
       	
       	// Retrive record from subscriber by primay key
       	
       	sub = null;
       	session = factory.openSession();
       	session.beginTransaction();
       	sub = (Subscriber)session.get(Subscriber.class, 1);
       	System.out.println("User name is: " + sub.getName());
       	
       	
       	session.getTransaction().commit();
       	session.close();
       	
       
    }

	
}
