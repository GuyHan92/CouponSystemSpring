package com.example.demo;

import java.io.Serializable;
import java.util.Collection;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class CompanyWeb implements Serializable {
	
	// the id of the company
	private long companyID;
	// the name of the company
	private String companyName;
	// the password of the company
	private String password;
	// the email of the company
	private String Email;
	// the coupons of the company
	private Collection<CouponWeb> coupons;
	// the pending admin review status of the company
	private boolean pendingAdminReview;
	
	public CompanyWeb() {
		super();
	}

	public long getCompanyID() {
		return companyID;
	}

	public void setCompanyID(long companyID) {
		this.companyID = companyID;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public Collection<CouponWeb> getCoupons() {
		return coupons;
	}

	public void setCoupons(Collection<CouponWeb> coupons) {
		this.coupons = coupons;
	}

	public boolean isPendingAdminReview() {
		return pendingAdminReview;
	}

	public void setPendingAdminReview(boolean pendingAdminReview) {
		this.pendingAdminReview = pendingAdminReview;
	}

}
