package com.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.model.AdminBean;
import com.utility.AHbConnBean;

public class AdminDao {

	public static void saveAdmin(AdminBean admin) {
		Transaction transaction = null;
		Session session = null;
		try {
			session = AHbConnBean.getSession();
			transaction = session.beginTransaction();
			session.save(admin);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
                session.close();
            }
		}
	}

	public static String verifyAdmin(String username, String password) {
		Transaction transaction = null;
		Session session = null;
		String uname = null;
		try {
			session = AHbConnBean.getSession();
			transaction = session.beginTransaction();

			Query<AdminBean> query = session.createQuery("from AdminBean where adUsername = :username", AdminBean.class);
			query.setParameter("username", username);
			
			AdminBean admin = query.uniqueResult(); // Fetch unique result
			transaction.commit();
			if (admin != null && admin.getAdPasssword().equals(password)) {
				uname = admin.getAdUsername();
			}
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();

		} finally {
			if (session != null) {
                session.close();
            }
		}

		return uname;

	}

}
