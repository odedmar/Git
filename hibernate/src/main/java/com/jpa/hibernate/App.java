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
        
        sub.setCreateTime(new Date());
        sub.setString_hib("Transiant example");
        
        
        Configuration configuration = new Configuration().configure();
       	StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().
       	applySettings(configuration.getProperties());
       	SessionFactory factory = configuration.buildSessionFactory(builder.build());
       	
       	Address addr = new Address();
       	
       	addr.setCity("sssss");
       	sub.getAddresses().add(addr);
       	
       	Address addr2 = new Address();
       	
       	addr2.setCity("rishon");
       	sub.getAddresses().add(addr2);
       	
       	Session session = factory.openSession();
       	
       	session.beginTransaction();
       	session.save(sub);
       	
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
