package com.zensar.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.demo.dto.CouponDto;
import com.zensar.demo.service.CouponServices;

@RestController
@RequestMapping(value = "/coupon-api", consumes = { MediaType.APPLICATION_JSON_VALUE,
		MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
				MediaType.APPLICATION_XML_VALUE })
public class CouponController {

	@Autowired
	private CouponServices couponServices;

	@GetMapping("/coupon/{couponId}")
	public ResponseEntity<CouponDto> getCoupon(@PathVariable("couponId") int couponId) {
		return new ResponseEntity<CouponDto>(couponServices.getCoupon(couponId), HttpStatus.OK);
	}

	@GetMapping("/coupon")
	public ResponseEntity<List<CouponDto>> getAllCoupon(
			@RequestParam(value = "pageNumber", required = false, defaultValue = "0") int pageNumber,
			@RequestParam(value = "pageSize", required = false, defaultValue = "5") int pageSize,
			@RequestParam(value = "sortBy", required = false, defaultValue = "percentDiscount") String sortBy,
			@RequestParam(value = "dir", required = false, defaultValue = "ASC") Direction dir) {
		return new ResponseEntity<List<CouponDto>>(couponServices.getAllCoupon(pageNumber, pageSize, sortBy, dir), HttpStatus.OK);

	}

	@PostMapping("/coupon")
	public ResponseEntity<CouponDto> insertCoupon(@RequestBody CouponDto couponDto) {
		return new ResponseEntity<CouponDto>(couponServices.insertCoupon(couponDto), HttpStatus.CREATED);
	}

	@PutMapping("/coupon/{couponId}")
	public ResponseEntity<CouponDto> updateCoupon(@PathVariable("couponId") int couponId,
			@RequestBody CouponDto couponDto) {
		return new ResponseEntity<CouponDto>(couponServices.updateCoupon(couponId, couponDto), HttpStatus.OK);

	}

	@DeleteMapping("/coupon/{couponId}")
	public ResponseEntity<String> deleteCoupon(@PathVariable("couponId") int couponId) {
		couponServices.deleteCoupon(couponId);
		return new ResponseEntity<String>("Coupon Deleted Successfully", HttpStatus.OK);

	}

	@GetMapping("/coupon/percentDiscount/{percentDiscount}")
	public ResponseEntity<List<CouponDto>> findByPercentDiscount(@PathVariable("percentDiscount") int percentDiscount) {
		return new ResponseEntity<List<CouponDto>>(couponServices.findByPercentDiscount(percentDiscount),
				HttpStatus.OK);

	}

	@GetMapping("/coupon/CodeAndDiscount/{couponCode}/{percentDiscount}")
	public ResponseEntity<List<CouponDto>> findByCouponCodeOrPercentDiscount(@PathVariable("couponCode") int couponCode,
			@PathVariable("percentDiscount") int percentDiscount) {
		return new ResponseEntity<List<CouponDto>>(
				couponServices.findByCouponCodeOrPercentDiscount(couponCode, percentDiscount), HttpStatus.OK);
	}

	@GetMapping("/coupon/percentDiscount1/{percentDiscount}")
	public ResponseEntity<List<CouponDto>> test(@PathVariable("percentDiscount") int percentDiscount) {
		return new ResponseEntity<List<CouponDto>>(couponServices.test(percentDiscount), HttpStatus.OK);
	}

	@GetMapping("/coupon/CodeAndDiscount1/{couponCode}/{percentDiscount}")
	public ResponseEntity<List<CouponDto>> test2(@PathVariable("couponCode") int couponCode,
			@PathVariable("percentDiscount") int percentDiscount) {
		return new ResponseEntity<List<CouponDto>>(couponServices.test2(couponCode, percentDiscount), HttpStatus.OK);
	}
	
	@GetMapping("/coupon/percentDiscount2/{percentDiscount}")
	public ResponseEntity<List<CouponDto>> getByPercentDiscountGreaterThan(@PathVariable("percentDiscount") int percentDiscount){
		return new ResponseEntity<List<CouponDto>>(couponServices.getByPercentDiscountGreaterThan(percentDiscount), HttpStatus.OK);
		
	}

}
