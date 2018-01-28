package com.example.demo;

import java.util.Collection;

public class User {
	
	private long userID; // the id of the user
	private String userName; // the name of the user
	private String password; // the password of the user
	private Collection<Coupon> coupons; // the coupons of the user
	private boolean adminStatus; // the admin status of the user
	
	public User() {
		super();
	}

	public long getUserID() {
		return userID;
	}

	public void setUserID(long userID) {
		this.userID = userID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Collection<Coupon> getCoupons() {
		return coupons;
	}

	public void setCoupons(Collection<Coupon> coupons) {
		this.coupons = coupons;
	}

	public boolean isAdminStatus() {
		return adminStatus;
	}

	public void setAdminStatus(boolean adminStatus) {
		this.adminStatus = adminStatus;
	}
	
}
