package com.zensar.demo.dto;

public class CouponDto {

	private int couponId;
	private int couponCode;
	private int percentDiscount;
	private String expiryDate;

	public CouponDto() {
		super();
	}

	public CouponDto(int couponId, int couponCode, int percentDiscount, String expiryDate) {
		super();
		this.couponId = couponId;
		this.couponCode = couponCode;
		this.percentDiscount = percentDiscount;
		this.expiryDate = expiryDate;
	}

	public int getCouponId() {
		return couponId;
	}

	public void setCouponId(int couponId) {
		this.couponId = couponId;
	}

	public int getCouponCode() {
		return couponCode;
	}

	public void setCouponCode(int couponCode) {
		this.couponCode = couponCode;
	}

	public int getPercentDiscount() {
		return percentDiscount;
	}

	public void setPercentDiscount(int percentDiscount) {
		this.percentDiscount = percentDiscount;
	}

	public String getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

}
