package com.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.model.UserBean;
import com.utility.UHbConnBean;

public class UserDao {

	// Save User
	public static int saveUser(UserBean user) {
		Transaction transaction = null;
		int count = 0;
		Session session = null;
		try {
			session = UHbConnBean.getSession();
			transaction = session.beginTransaction();
			count = (Integer) session.save(user);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		return count;
	}

	// Get All Users
	public static List<UserBean> getAllUsers() {
		Transaction transaction = null;
		List<UserBean> allUsers = new ArrayList<UserBean>();
		Session session = null;
		try {
			session = UHbConnBean.getSession();
			transaction = session.beginTransaction();
			Query<UserBean> hQ  = session.createQuery("from UserBean",UserBean.class);
			allUsers = hQ.list();
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			 e.printStackTrace();
		} finally {
			session.close();
		}
		System.out.println("User list size: " + (allUsers != null ? allUsers.size() : "null"));
		for (UserBean user : allUsers) {
		    System.out.println(user);
		}
		return allUsers;
	}

	// Get User by Username
	public static UserBean getUserByUserName(String username) {
		Transaction transaction = null;
		UserBean user = null;
		Session session = null;
		try {
			session = UHbConnBean.getSession();
			transaction = session.beginTransaction();
			user = (UserBean) session.createQuery("from UserBean where username=:username")
					.setParameter("username", username).uniqueResult();
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
		} finally {
			session.close();
		}
		return user;
	}

	// Update User
	public static void updateUser(UserBean user) {
		Transaction transaction = null;
		Session session = null;
		try {
			session = UHbConnBean.getSession();
			transaction = session.beginTransaction();
			session.saveOrUpdate(user);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
		} finally {
			session.close();
		}
	}

	// Delete User
	public static void deleteUser(String username) {
		Transaction transaction = null;
		UserBean user = null;
		Session session = null;
		try {
			session = UHbConnBean.getSession();
			transaction = session.beginTransaction();
			user = session.get(UserBean.class, username);
			session.delete(user);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
	}

	public static String verifyUser(String username, String password) {
		String usname = null;
		Transaction transaction = null;
		Session session = null;

		try {
			session = UHbConnBean.getSession(); // Assuming this method gets the Hibernate session
			transaction = session.beginTransaction();

			// Use named parameters to avoid potential SQL injection
			UserBean user = (UserBean) session.createQuery("from UserBean where username=:username")
					.setParameter("username", username).uniqueResult();

			transaction.commit();

			if (user != null && user.getPassword().equals(password)) {
				usname = user.getUsername();
			}

		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			// Log the exception (you can integrate logging framework)
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return usname;
	}
}