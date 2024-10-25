package com.utility;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.model.UserBean;

public class UHbConnBean{
	static Configuration con = null;
	static {
		con = new Configuration().configure().addAnnotatedClass(UserBean.class);
	}
	
	public static SessionFactory getSessionFactory() {
		SessionFactory sf = con.buildSessionFactory();
		return sf;
	}
	
	public static Session getSession() {
		return getSessionFactory().openSession();
	}
}

