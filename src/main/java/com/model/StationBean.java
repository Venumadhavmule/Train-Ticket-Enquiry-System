package com.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "station")
public class StationBean {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "station", nullable = false, unique = true)
	private String station;

	public StationBean(String station) {
		this.station = station;
	}

	public String getStation() {
		return station;
	}

	public void setStation(String station) {
		this.station = station;
	}
	
}
