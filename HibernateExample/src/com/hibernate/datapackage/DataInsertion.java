package com.hibernate.datapackage;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DataInsertion {

	
	public void insertInfo(){
		Configuration con = new Configuration();
		con.configure("hibernate.cfg.xml");
		SessionFactory sf = con.buildSessionFactory();
		Session ss = sf.openSession();
		DataProvider provider = new DataProvider();
		provider.setUname("Unnati25");
		provider.setFname("Unnati");
		provider.setLname("Singh");
		provider.setEmail("singhunnati25@gmail.com");
		provider.setPassword("unnati");
		Transaction TR = ss.beginTransaction();
		ss.save(provider);
		System.out.println("Object saved successfully");
		TR.commit();
		ss.close();
		sf.close();
	}
	
	public void getData(){
		Configuration con = new Configuration();
		con.configure("hibernate.cfg.xml");
		SessionFactory sf = con.buildSessionFactory();
		Session ss = sf.openSession();
		Object ob = ss.load(DataProvider.class, new String("singhunnati25@gmail.com"));
		DataProvider provider = (DataProvider)ob;
		
		System.out.println("Username" + provider.getUname() + " " + provider.getFname());
		
		Transaction TR = ss.beginTransaction();
		ss.save(provider);
		System.out.println("Object saved successfully");
		TR.commit();
		ss.close();
		sf.close();
		
	}
	public static void main(String[] args) {
		new DataInsertion().getData();
		
	}

}
