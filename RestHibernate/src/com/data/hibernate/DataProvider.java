package com.data.hibernate;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;

public class DataProvider {

	private String uname;
	private String fname;
	private String lname;
	private String email;
	private String password;
	private Date lastlogintime;
	private Integer failedLoginCount;
	private Integer id;
	public String getUname() {
		return uname;
	}
	public Date getLastlogintime() {
		return lastlogintime;
	}
	public void setLastlogintime(Date lastlogintime) {
		this.lastlogintime = lastlogintime;
	}
	public Integer getFailedLoginCount() {
		return failedLoginCount;
	}
	public void setFailedLoginCount(Integer failedLoginCount) {
		this.failedLoginCount = failedLoginCount;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
