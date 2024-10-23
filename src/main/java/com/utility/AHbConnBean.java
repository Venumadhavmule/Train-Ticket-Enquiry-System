package com.utility;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.model.AdminBean;

public class AHbConnBean {
	static Configuration con = null;
	static {
		con = new Configuration().configure().addAnnotatedClass(AdminBean.class);
	}

	public static SessionFactory getSessionFactory() {
		return con.buildSessionFactory();
	}

	public static Session getSession() {
		return getSessionFactory().openSession();
	}
}
