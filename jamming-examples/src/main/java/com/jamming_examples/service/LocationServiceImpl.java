package com.jamming_examples.service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import domain.Location;

public class LocationServiceImpl {

	static Location location;
    static Session sessionObj;
    static SessionFactory sessionFactoryObj;
	
	public List<Location> getLocationCity(String city)
	{
		try {
            sessionObj = buildSessionFactory().openSession();
            sessionObj.beginTransaction();
            
            List<Location> loginList = sessionObj.createQuery("from Location where city='"+city+"'").list();
            
            return loginList;
        } catch(Exception sqlException) {
            if(null != sessionObj.getTransaction()) {
                System.out.println("\n.......Transaction Is Being Rolled Back.......");
                sessionObj.getTransaction().rollback();
            }
            sqlException.printStackTrace();
        } finally {
            if(sessionObj != null) {
                sessionObj.close();
            }
        }
		return null;
	}
	
	private static SessionFactory buildSessionFactory() {
        Configuration configObj = new Configuration();
        configObj.configure("hibernate.cfg.xml");
 
        ServiceRegistry serviceRegistryObj = new StandardServiceRegistryBuilder().applySettings(configObj.getProperties()).build(); 
 
        sessionFactoryObj = configObj.buildSessionFactory(serviceRegistryObj);
       
        return sessionFactoryObj;
    }
}
