package com.example.demo;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import facade.UserFacade;
import user.UserBean;
import coupon.CouponBean;
import coupon.CouponTypes;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class UserWebService{
	
	@RequestMapping(value = "/session", method = RequestMethod.POST)
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getSession().getAttribute("userFacade") == null)
		{
			return;
		}
		else
		{
			response.sendRedirect("/userPage/index.html");
		}		
	}
	
	@RequestMapping(value = "/userDetails", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody UserBean userDetails(HttpServletRequest request) {
		return ((UserFacade) request.getSession().getAttribute("userFacade")).userDetails();
	}
	
	@RequestMapping(value = "/purchaseCoupon", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody void purchaseCoupon(@RequestBody String name,HttpServletRequest request) {
		CouponBean c = ((UserFacade) request.getSession().getAttribute("userFacade")).getCouponByName(name);		
		((UserFacade) request.getSession().getAttribute("userFacade")).purchaseCoupon(c);
	}
	
	@RequestMapping(value = "/getCouponByNameUser", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody CouponBean getCouponByName(String name,HttpServletRequest request) {
		return ((UserFacade) request.getSession().getAttribute("userFacade")).getCouponByName(name);
	}

	@RequestMapping(value = "/getAllPurchesedCoupons", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Collection<CouponBean> getAllPurchesedCoupons(HttpServletRequest request) {
		return ((UserFacade) request.getSession().getAttribute("userFacade")).getAllPurchesedCoupons();
	}
	
	@RequestMapping(value = "/getAllPurchesedCouponsByType", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Collection<CouponBean> getAllPurchesedCouponsByType(String type,HttpServletRequest request) {
		return ((UserFacade) request.getSession().getAttribute("userFacade")).getAllPurchesedCouponsByType(CouponTypes.valueOf(type));
	}
	
	@RequestMapping(value = "/getAllPurchesedCouponsByPriceOver", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Collection<CouponBean> getAllPurchesedCouponsByPriceOver(Double price,HttpServletRequest request) {
		return ((UserFacade) request.getSession().getAttribute("userFacade")).getAllPurchesedCouponsByPriceOver(price);
	}
	
	@RequestMapping(value = "/getAllPurchesedCouponsByPriceUnder", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Collection<CouponBean> getAllPurchesedCouponsByPriceUnder(Double price,HttpServletRequest request) {
		return ((UserFacade) request.getSession().getAttribute("userFacade")).getAllPurchesedCouponsByPriceUnder(price);
	}

}
