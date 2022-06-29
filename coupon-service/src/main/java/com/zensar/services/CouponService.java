package com.zensar.services;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import com.zensar.entity.Coupon;

public interface CouponService {

	public Coupon createCoupon(Coupon coupon);

	public Coupon getCoupon(String couponCode);

	public List<Coupon> getAllCoupons();

	public void deleteCoupon(String couponCode);

}
