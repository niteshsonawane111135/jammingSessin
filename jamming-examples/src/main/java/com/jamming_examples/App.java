package com.jamming_examples;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.jamming_examples.service.LocationServiceImpl;

import domain.Location;
import domain.Region;

/**
 * Hello world!
 *
 */
public class App 
{
    static LocationServiceImpl locationService;
    public static void main( String[] args )
    {
    	
    	locationService= new LocationServiceImpl();
    	List<Location> locations= locationService.getLocationCity("");
    	if (!locations.isEmpty())
    	for (Location location: locations)
    	{
    		System.out.println("location id: "+location.getId());
    		System.out.println("location city: "+location.getCity());
    	}
    	else
    	{
    		System.out.print("Empty list");
    	}
    	
    }
    
    
 
}
