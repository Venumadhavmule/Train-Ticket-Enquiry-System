package com.utility;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.model.TrainBean;

public class THbConnectionBean {
	static Configuration con = null;
	static {
		con = new Configuration().configure().addAnnotatedClass(TrainBean.class);
		
	}
	
	public static SessionFactory getSessionFactory() {
		return con.buildSessionFactory();
	}
	
	public static Session getSession() {
		return getSessionFactory().openSession();
	}
}
