package com.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name = "train")
public class TrainBean {
	@Id
	private int trainNo;
	private String trainName;
	private String trainFrom;
	private String trainTo;

	public TrainBean() {

	}

	public TrainBean(int trainNo, String trainName, String trainFrom, String trainTo) {
		this.trainNo = trainNo;
		this.trainName = trainName;
		this.trainFrom = trainFrom;
		this.trainTo = trainTo;
	}

	public int getTrainNo() {
		return trainNo;
	}

	public void setTrainNo(int trainNo) {
		this.trainNo = trainNo;
	}

	public String getTrainName() {
		return trainName;
	}

	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}

	public String getTrainFrom() {
		return trainFrom;
	}

	public void setTrainFrom(String trainFrom) {
		this.trainFrom = trainFrom;
	}

	public String getTrainTo() {
		return trainTo;
	}

	public void setTrainTo(String trainTo) {
		this.trainTo = trainTo;
	}

}
