package com.example.demo;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import coupon.CouponBean;
import coupon.CouponTypes;

@XmlRootElement
public class CouponWeb implements Serializable {
	
	private long couponID; // the id of the coupon
	private String title; // the title of the coupon
	private Date startDate; // the start date of the coupon
	private Date endDate; // the end date of the coupon
	private int amount; // the amount of the coupon
	private CouponTypes type; // the type of the coupon from CouponTypes enum
	private String message; // the message of the coupon
	private Double price; // the price of the coupon
	private String image; // the image URL of the coupon
	
	public static CouponWeb convertToCouponWeb(CouponBean c) {
		CouponWeb webCoupon = new CouponWeb();
		webCoupon.setCouponID(c.getId());
		webCoupon.setTitle(c.getTitle());
		webCoupon.setStartDate(c.getStartDate());
		webCoupon.setEndDate(c.getEndDate());
		webCoupon.setAmount(c.getAmount());
		webCoupon.setType(c.getType());
		webCoupon.setMessage(c.getMessage());
		webCoupon.setPrice(c.getPrice());
		webCoupon.setImage(c.getImage());
		return webCoupon;
	}
	
	public static CouponBean convertToCouponBean(CouponWeb WebCoupon) {
		CouponBean Coupon = new CouponBean();
		Coupon.setId(WebCoupon.getCouponID());
		Coupon.setTitle(WebCoupon.getTitle());
		Coupon.setStartDate(WebCoupon.getStartDate());
		Coupon.setEndDate(WebCoupon.getEndDate());
		Coupon.setAmount(WebCoupon.getAmount());
		Coupon.setType(WebCoupon.getType());
		Coupon.setMessage(WebCoupon.getMessage());
		Coupon.setPrice(WebCoupon.getPrice());
		Coupon.setImage(WebCoupon.getImage());
		return Coupon;
	}
	
	public CouponWeb() {
		super();
	}

	public long getCouponID() {
		return couponID;
	}

	public void setCouponID(long couponID) {
		this.couponID = couponID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public CouponTypes getType() {
		return type;
	}

	public void setType(CouponTypes type) {
		this.type = type;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
}
