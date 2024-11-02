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
			Query<UserBean> hQ = session.createQuery("from UserBean", UserBean.class);
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
	public static boolean updateUser(UserBean user) {
	    Transaction transaction = null;
	    Session session = null;
	    boolean result = false;
	    String username = (String) user.getUsername();
	    
	    try {
	        session = UHbConnBean.getSession();
	        transaction = session.beginTransaction();
	        
	        // Fetch the existing user based on username
	        UserBean existingUser = session.createQuery("from UserBean where username = :username", UserBean.class)
	                                       .setParameter("username", user.getUsername())
	                                       .uniqueResult();
	        
	        if (existingUser != null) {
	            // Update existing user
	            existingUser.setFirstName(user.getFirstName());
	            existingUser.setLastName(user.getLastName());
	            existingUser.setEmail(user.getEmail());
	            existingUser.setPhone(user.getPhone());
	            existingUser.setPassword(user.getPassword());
	            //save the updated user
	            session.update(existingUser);
	            result =true;
	        } else {
	            // Save new user
	            session.save(user);
	        }

	        transaction.commit();
	        result = true;
	    } catch (Exception e) {
	        if (transaction != null) {
	            transaction.rollback();
	        }
	        e.printStackTrace(); // Log the exception
	    } finally {
	        if (session != null) {
	            session.close();
	        }
	    }
	    
	    return result;
	}

	// Delete User
	public static boolean deleteUser(String username) {
		Transaction transaction = null;
		UserBean user = null;
		Session session = null;
		boolean result = false;
		try {
			session = UHbConnBean.getSession();
			transaction = session.beginTransaction();

			// Fetch the user based on the 'username' field
			user = session.createQuery("from UserBean where username = :username", UserBean.class)
					.setParameter("username", username).uniqueResult();

			// Only delete if the user was found
			if (user != null) {
				session.delete(user);
				transaction.commit();
				result = true;
			} else {
				System.out.println("User not found with username: " + username);
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
		return result;
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