package com.model;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.metamodel.Metadata;
import org.hibernate.metamodel.MetadataSources;

public class HBUtil {
	private static SessionFactory sf;
	private static StandardServiceRegistry sr;
	public static SessionFactory getSf(){
		if(sf==null) {
			try {
				sr=new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
				Metadata md= new MetadataSources(sr).buildMetadata();
				sf=md.buildSessionFactory();
			
			}
			catch(HibernateException h) {
				h.printStackTrace();
			}
		}
		return sf;
	
	}

}
