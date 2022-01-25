package com.muthu.sampleProject.Sony_Live.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "USERS")
public class Users {
	
	@Id
	@Column(name = "ID")
	private int id;
	
	@Column(name = "USERNAME")
	private String name;
	
	@Column(name = "MOBILE")
	private String mobileNumber;
	
	@Column(name = "EMAIL")
	private String emailId;
	
	@Column(name = "password")
	private String password;
	
	
	
	//getters and setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	

	//constructor
	public Users(int id, String name, String mobileNumber, String emailId, String password) {
	
		this.id = id;
		this.name = name;
		this.mobileNumber = mobileNumber;
		this.emailId = emailId;
		this.password = password;
		
	}

	public Users() {
		
	}

	
	
	
	
	
	
}
