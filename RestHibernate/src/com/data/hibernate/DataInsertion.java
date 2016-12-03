package com.data.hibernate;

import java.util.LinkedList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


import com.wpl.commons.ParameterConstants;
public class DataInsertion {
	
	public static int addUser(String username, String fname, String lname, String password,
			String email) {
		
		Configuration con = new Configuration();
		con.configure("hibernate.cfg.xml").addAnnotatedClass(DataProvider.class);
		SessionFactory sf = con.buildSessionFactory();
		Session ss = sf.openSession();
		DataProvider provider = new DataProvider();
		System.out.println(username+ "in hibenrate");
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
		return provider.getId();
	}

	
	public static void addBid(Integer userId, Integer bprice, Integer pid) {
		
		Configuration con = new Configuration();
		con.configure("hibernate.cfg.xml").addAnnotatedClass(Bids.class);
		SessionFactory sf = con.buildSessionFactory();
		Session ss = sf.openSession();
		Bids provider = new Bids();
		//System.out.println(username+ "in hibenrate");
		System.out.println("Bid saved successfully");
		provider.setBid_price(bprice);
		provider.setId(userId);
		provider.setP_id(pid);
		Transaction TR = ss.beginTransaction();
		ss.save(provider);
	
		TR.commit();
		ss.close();
		sf.close();
		//return provider.getBid_id();
	}


	
	public static void insertInfo(){
		Configuration con = new Configuration();
		con.configure("hibernate.cfg.xml").addAnnotatedClass(DataProvider.class);
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
	

	
	public static DataProvider getUserByUid(Integer u_id) {
		Configuration con = new Configuration();
		con.configure("hibernate.cfg.xml").addAnnotatedClass(DataProvider.class);
		SessionFactory sf = con.buildSessionFactory();
		Session ss = sf.openSession();
		try {
			return ss.get(DataProvider.class, u_id);
			
		
		} finally {
			ss.close();
			sf.close();
			
		}
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
	
	public static int insertBIdInfo(Integer userId, Integer bprice, Integer pid){
		Configuration con = new Configuration();
		con.configure("hibernate.cfg.xml").addAnnotatedClass(Bids.class);
		SessionFactory sf = con.buildSessionFactory();
		Session ss = sf.openSession();
		Bids provider = new Bids();
		provider.setBid_price(bprice);
		provider.setId(userId);
		provider.setP_id(pid);
		
		Transaction TR = ss.beginTransaction();
		ss.save(provider);
		int bid = provider.getBid_id();
		System.out.println("Object saved successfully");
		TR.commit();
		ss.close();
		sf.close();
		return bid;
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



	public static int addItem(Integer userId, String pname, String pdesc) {
		
		Configuration con = new Configuration();
		con.configure("hibernate.cfg.xml").addAnnotatedClass(Items.class);
		SessionFactory sf = con.buildSessionFactory();
		Session ss = sf.openSession();
		Items provider = new Items();
		provider.setId(userId);
		provider.setP_name(pname);
		provider.setP_desc(pdesc);
		Transaction TR = ss.beginTransaction();
		ss.save(provider);
		System.out.println("Object saved successfully");
		TR.commit();
		ss.close();
		sf.close();
		return provider.getP_id();
		
	}
	
	
	
	public static List<Bids> fetchBids( Integer userId){
		Configuration con = new Configuration();
		con.configure("hibernate.cfg.xml").addAnnotatedClass(Bids.class);
		SessionFactory sf = con.buildSessionFactory();
		Session ss = sf.openSession();
		 
			List<Bids> bids = ss.getNamedQuery(BidsQueries.FIND_BIDS_BY_U_ID).setParameter(ParameterConstants.USER_ID, userId).list();
			/*for(Bids i : bids){
				System.out.println(i.getBid_id());
			}*/
		return bids;
		}
public static List<Items> fetchItems(){
	Configuration con = new Configuration();
	con.configure("hibernate.cfg.xml").addAnnotatedClass(Items.class);
	SessionFactory sf = con.buildSessionFactory();
	Session ss = sf.openSession();
	 
		List<Items> items = ss.getNamedQuery(Itemqueries.FETCH_All_ITEMS).list();
		for(Items i : items){
			System.out.println(i.getP_desc());
		}
	return items;
	}
	


	
	public static DataProvider getUserByEmail(String emailId) {
		Configuration con = new Configuration();
		con.configure("hibernate.cfg.xml").addAnnotatedClass(DataProvider.class);
		SessionFactory sf = con.buildSessionFactory();
		Session ss = sf.openSession();
		try {
			List<DataProvider> users = ss.getNamedQuery(UserQueries.FIND_USER_BY_EMAIL_ID).setString(ParameterConstants.EMAIL, emailId).list();
			if (users.size() != 0) {
				return users.get(0);
			}
		//	logger.error("Unable to find a valid user with the emailId {}. Returning null!", emailId);
			return null;
		} finally {
			ss.close();
			sf.close();
			
		}
	}
	
	public static void main(String args[]){
		new DataInsertion().fetchBids(1);
	}
	

}
