package com.data.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DataInsertion {
	
	public static void addUser(String username, String fname, String lname, String password,
			String email) {
		
		Configuration con = new Configuration();
		con.configure("hibernate.cfg.xml");
		SessionFactory sf = con.buildSessionFactory();
		Session ss = sf.openSession();
		DataProvider provider = new DataProvider();
		provider.setUname(username);
		provider.setFname(fname);
		provider.setLname(lname);
		provider.setEmail(email);
		provider.setPassword(password);
		Transaction TR = ss.beginTransaction();
		ss.save(provider);
		System.out.println("Object saved successfully");
		TR.commit();
		ss.close();
		sf.close();
	}


	
	public static void insertInfo(){
		Configuration con = new Configuration();
		con.configure("hibernate.cfg.xml");
		SessionFactory sf = con.buildSessionFactory();
		Session ss = sf.openSession();
		DataProvider provider = new DataProvider();
		provider.setUname("mohan1212");
		provider.setFname("mo");
		provider.setLname("na");
		provider.setEmail("a@gmail11.com");
		//provider.setId(5);
		provider.setPassword("kikcsddi");
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
	
	public static void insertBIdInfo(){
		Configuration con = new Configuration();
		con.configure("hibernate.cfg.xml");
		SessionFactory sf = con.buildSessionFactory();
		Session ss = sf.openSession();
		Bids provider = new Bids();
		provider.setBid_price(10);
		provider.setP_id(1);
		provider.setU_id(1);
		Transaction TR = ss.beginTransaction();
		ss.save(provider);
		System.out.println("Object saved successfully");
		TR.commit();
		ss.close();
		sf.close();
	}
	
	public static void insertOrderInfo(){
		Configuration con = new Configuration();
		con.configure("hibernate.cfg.xml");
		SessionFactory sf = con.buildSessionFactory();
		Session ss = sf.openSession();
		Orders provider = new Orders();
		provider.setOrder_price(10);
		provider.setP_id(1);
		provider.setU_id(2);
		Transaction TR = ss.beginTransaction();
		ss.save(provider);
		System.out.println("Object saved successfully");
		TR.commit();
		ss.close();
		sf.close();
	}
	public static void main(String[] args) {
		new DataInsertion().insertOrderInfo();
		
	}

}
