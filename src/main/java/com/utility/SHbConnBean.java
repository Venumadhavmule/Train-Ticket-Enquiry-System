package com.utility;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.model.StationBean;

public class SHbConnBean {
	static Configuration con = null;
	static {
		con = new Configuration().configure().addAnnotatedClass(StationBean.class);
	}
	
	public static SessionFactory getSessionFactory() {
		return con.buildSessionFactory();
	}
	
	public static Session getSession() {
		return getSessionFactory().openSession();
	}
}
