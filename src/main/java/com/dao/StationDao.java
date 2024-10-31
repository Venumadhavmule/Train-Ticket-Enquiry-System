package com.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.model.StationBean;
import com.utility.SHbConnBean;

public class StationDao {
	public static void addStation(StationBean station) {
		Transaction transaction = null;
		Session session = null;
		try {
			session = SHbConnBean.getSession();
			transaction = session.beginTransaction();
			session.save(station);
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
	
	public static List<StationBean> getAllStations(){
		Transaction transaction = null;
		Session session = null;
		List<StationBean> allStations = new ArrayList<StationBean>();
		try {
			session = SHbConnBean.getSession();
			transaction = session.beginTransaction();
			allStations = session.createQuery("from station",StationBean.class).list();
			transaction.commit();
		}catch (Exception e) {
			if(transaction!=null) {
				transaction.rollback();
			}
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		
		return allStations;
	}
}
