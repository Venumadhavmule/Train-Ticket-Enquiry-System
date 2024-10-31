package com.dao;

import java.util.ArrayList;
import java.util.List;

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

	
	public static List<TrainBean> getAllTrains(){
		Transaction transaction = null;
		Session session =null;
		List<TrainBean> trains = new ArrayList<TrainBean>();
		try {
			session = THbConnectionBean.getSession();
			transaction = session.beginTransaction();
			trains = session.createQuery("from train",TrainBean.class).list();
			transaction.commit();
		}catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		
		return trains;
	}
	
	public static TrainBean getFromToTrain(String from, String to) {
		Transaction transaction = null;
		Session session = null;
		TrainBean fromToTrains = new TrainBean();
		try {
			session = THbConnectionBean.getSession();
			transaction = session.beginTransaction();
			fromToTrains = session.createQuery("from train where trainFrom=:from and trainTo=:to", TrainBean.class)
					.setParameter("from", from)
		            .setParameter("to", to)
		            .uniqueResult();
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return fromToTrains;
	}

}
