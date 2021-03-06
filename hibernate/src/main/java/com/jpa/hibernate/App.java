package com.jpa.hibernate;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
    	 System.out.println( "Hello World!" );
    	
    	// Preparing the data phase - Detached Entity.
       
        
        Subscriber sub = new Subscriber();
        sub.setName("oded");
        
        Subscriber sub1 = new Subscriber();
        sub1.setName("dana");
        
        Car mersedes = new PrivateCar();
       	mersedes.setWeells(5);
       	mersedes.setManufacturerName("mersades");
       	

        Car porshe = new PrivateCar();
       	mersedes.setWeells(5);
       	mersedes.setManufacturerName("porshe");
       	
       	
       	Car dan = new Bus();
       	dan.setLisense(3);
       	dan.setWeells(8);
       	dan.setManufacturerName("Dan");
       	
       	Car bus = new Bus();
       	dan.setLisense(3);
       	dan.setWeells(8);
       	dan.setManufacturerName("Porshe");
       	
       	
       	
       	sub.getCarList().add(dan);
       	sub.getCarList().add(porshe);
       	sub.getCarList().add(mersedes);
      	sub1.getCarList().add(mersedes);
       	
        
        
        Configuration configuration = new Configuration().configure();
       	StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().
       	applySettings(configuration.getProperties());
       	SessionFactory factory = configuration.buildSessionFactory(builder.build());
       	
       	
       	
       	
       	Session session = factory.openSession();
       	session.beginTransaction();
       	
       	try{
       	session.persist(sub);
        
       	
                	
       	session.getTransaction().commit();
       	session.close();
       	
       	// Retrive  from subscriber  all the usere that have car name porshe.
       	
       	sub = null;
       	session = factory.openSession();
       	session.beginTransaction();
       	
       	
       	
       
       	Criteria c = session.createCriteria(Subscriber.class, "sub");
       	c.createAlias("sub.carList", "car");
       	c.add(Restrictions.eq("car.manufacturerName", "porshe")).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
       	
       	List<Subscriber> subList = ((List<Subscriber>)c.list());
       	
       	for(Subscriber subscriber : subList)
       		System.out.println("The carName is " + subscriber.getName()) ;
       	
       	
       		
       	
       	session.getTransaction().commit();
       	session.close();
       	
       	}catch(Exception e ){
       		session.beginTransaction().rollback();
       	}
    }

	
}
