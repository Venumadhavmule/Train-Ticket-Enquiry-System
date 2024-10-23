package com.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="admin")
public class AdminBean {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int aId;
	@Column(name = "name", nullable = false)
	private String adName;
	@Column(name = "phone", nullable = false)
	private String adPhone;
	@Column(name = "email", nullable = false)
	private String adEmail;

	@Column(name = "username", nullable = false, unique = true)
	private String adUsername;

	@Column(name = "password", nullable = false)
	private String adPasssword;

	public String getAdName() {
		return adName;
	}

	public void setAdName(String adName) {
		this.adName = adName;
	}

	public String getAdPhone() {
		return adPhone;
	}

	public void setAdPhone(String adPhone) {
		this.adPhone = adPhone;
	}

	public String getAdEmail() {
		return adEmail;
	}

	public void setAdEmail(String adEmail) {
		this.adEmail = adEmail;
	}

	public String getAdUsername() {
		return adUsername;
	}

	public void setAdUsername(String adUsername) {
		this.adUsername = adUsername;
	}

	public String getAdPasssword() {
		return adPasssword;
	}

	public void setAdPasssword(String adPassswprd) {
		this.adPasssword = adPassswprd;
	}

}
