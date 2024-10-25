package com.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.model.TrainBean;
import com.utility.THbConnectionBean;

public class TrainDao {
	
	public static int addTrain(TrainBean train) {
		Session session = null;
		Transaction transaction = null;
		int count = 0;
		try {
			session = THbConnectionBean.getSession();
			transaction = session.beginTransaction();
			count = (int) session.save(train);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
		} finally {
			session.close();
		}
		return count;
	}
}
