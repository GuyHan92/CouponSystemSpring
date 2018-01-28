package com.example.demo;

import java.util.Date;

import coupon.CouponTypes;

public class Coupon {
	
	private long couponID; // the id of the coupon
	private String title; // the title of the coupon
	private Date startDate; // the start date of the coupon
	private Date endDate; // the end date of the coupon
	private int amount; // the amount of the coupon
	private CouponTypes type; // the type of the coupon from CouponTypes enum
	private String message; // the message of the coupon
	private Double price; // the price of the coupon
	private String image; // the image URL of the coupon
	
	public Coupon() {
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
