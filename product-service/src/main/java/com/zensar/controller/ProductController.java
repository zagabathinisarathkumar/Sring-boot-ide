package com.zensar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.zensar.entity.Coupon;
import com.zensar.entity.Product;
import com.zensar.restclient.CouponRestClient;
import com.zensar.services.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	
	//@Autowired
	//private RestTemplate restTemplate;
	
	@Autowired
	private CouponRestClient restClient;
	
	

	@PostMapping("/")
	public Product insertProduct(@RequestBody Product product) {

		//ResponseEntity<Coupon> coupon = restTemplate.getForEntity("http://COUPON-SERVICE/coupons/" + product.getCouponCode(), Coupon.class);
	Coupon coupon=	restClient.getCoupon(product.getCouponCode());
		//Coupon couponObject = coupon.getBody();
		product.setPrice(product.getPrice() - coupon.getDiscount());

		return productService.insertProduct(product);

	}

}
