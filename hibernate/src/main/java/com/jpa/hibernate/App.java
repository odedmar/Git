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
        
        Subscriber sub1 = new Subscriber();
        sub.setName("dana");
        
        
        Configuration configuration = new Configuration().configure();
       	StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().
       	applySettings(configuration.getProperties());
       	SessionFactory factory = configuration.buildSessionFactory(builder.build());
       	
       	Car mersedes = new PrivateCar();
       	mersedes.setWeells(5);
       	
       	
       	Car dan = new Bus();
       	dan.setLisense(3);
       	dan.setWeells(8);
       	
       	sub.getCarList().add(dan);
       	sub.getCarList().add(mersedes);
       	
       	
       	Session session = factory.openSession();
       	
       	session.beginTransaction();
       	session.persist(sub);
     
       	
       	session.getTransaction().commit();
       	session.close();
       	
       	// Retrive record from subscriber by primay key
       	
       	sub = null;
       	session = factory.openSession();
       	session.beginTransaction();
       	sub = (Subscriber)session.get(Subscriber.class, 1);
       	System.out.println("User name is: " + sub.getName());
       	
       	System.out.println("The address for the user are:");
       	
       	for(Car car: sub.getCarList()){
       		System.out.println("The weel number is: " + car.getWeells());
       	}
       	
       	
       	session.getTransaction().commit();
       	session.close();
       	
       
    }

	
}
