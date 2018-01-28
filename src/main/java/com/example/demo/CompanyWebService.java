package com.example.demo;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import company.CompanyBean;
import coupon.CouponBean;
import coupon.CouponTypes;
import facade.CompanyFacade;

@RestController
@RequestMapping("/company")
@CrossOrigin(origins = "*")
public class CompanyWebService {
	
	@RequestMapping(value = "/session", method = RequestMethod.POST)
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getSession().getAttribute("companyFacade") == null)
		{
			return;
		}
		else
		{
			response.sendRedirect("/companyPage/index.html");
		}		
	}
	
	//CompanyFacade facade = CouponSystem.getInstance().CompanyLoginToCouponSystem("company", "company","company");
	
	@RequestMapping(value = "/companyDetails", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody CompanyBean companyDetails(HttpServletRequest request) {
		return ((CompanyFacade) request.getSession().getAttribute("companyFacade")).companyDetails();
		//return facade.companyDetails();
	}

	@RequestMapping(value = "/createCoupon", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody void createCoupon(@RequestBody CouponBean coupon,HttpServletRequest request) {
		SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
		String formatedStartDate = DATE_FORMAT.format(coupon.getStartDate());
		String formatedEndDate = DATE_FORMAT.format(coupon.getEndDate());
			CouponBean c = ((CompanyFacade) request.getSession().getAttribute("companyFacade")).createCouponBean(coupon.getTitle(), formatedStartDate, formatedEndDate, coupon.getAmount(), coupon.getType(), coupon.getMessage(),
			coupon.getPrice(), coupon.getImage());
			((CompanyFacade) request.getSession().getAttribute("companyFacade")).createCoupon(c);
		//CouponBean c = facade.createCouponBean(coupon.getTitle(), formatedStartDate, formatedEndDate, coupon.getAmount(), coupon.getType(), coupon.getMessage(),
		//coupon.getPrice(), coupon.getImage());
		//facade.createCoupon(c);
	}

	@RequestMapping(value = "/getCouponByNameCompany", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody CouponBean getCouponByName(String title,HttpServletRequest request) {
		return ((CompanyFacade) request.getSession().getAttribute("companyFacade")).getCouponByName(title);
		//return facade.getCouponByName(title);
	}

	@RequestMapping(value = "/getCouponById", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody CouponBean getCouponById(long id,HttpServletRequest request) {
		return ((CompanyFacade) request.getSession().getAttribute("companyFacade")).getCouponById(id);
		//return facade.getCouponById(id);
	}

	@RequestMapping(value = "/getCouponsByType", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Collection<CouponBean> getCouponsByType(String type,HttpServletRequest request) {
		return ((CompanyFacade) request.getSession().getAttribute("companyFacade")).getCouponByType(CouponTypes.valueOf(type));
		//return facade.getCouponByType(CouponTypes.valueOf(type));
	}

	@RequestMapping(value = "/getCouponsByPriceUnder", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Collection<CouponBean> getCouponsByPriceUnder(Double price,HttpServletRequest request) {
		return ((CompanyFacade) request.getSession().getAttribute("companyFacade")).getCouponsByPriceUnder(price);
		//return facade.getCouponsByPriceUnder(price);
	}

	@RequestMapping(value = "/getCouponsByPriceOver", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Collection<CouponBean> getCouponsByPriceOver(Double price,HttpServletRequest request) {
		return ((CompanyFacade) request.getSession().getAttribute("companyFacade")).getCouponsByPriceOver(price);
		//return facade.getCouponsByPriceOver(price);
	}

	@RequestMapping(value = "/companyGetAllCoupons", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Collection<CouponBean> getAllCoupons(HttpServletRequest request) {
		return ((CompanyFacade) request.getSession().getAttribute("companyFacade")).getAllCoupons(((CompanyFacade) request.getSession().getAttribute("companyFacade")).getCompany().getCompanyID());
		//return facade.getAllCoupons(facade.getCompany().getCompanyID());
	}

	@RequestMapping(value = "/getCouponsByEndDate", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Collection<CouponBean> getCouponByEndDate(String endDate,HttpServletRequest request) {
		String sqlDatePattern = "yyyy-MM-dd";
		SimpleDateFormat sdf = new SimpleDateFormat(sqlDatePattern);
		java.util.Date javaDate;
		javaDate = new java.util.Date();
		try {
			javaDate = sdf.parse(endDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return ((CompanyFacade) request.getSession().getAttribute("companyFacade")).getCouponByEndDate(javaDate);
		//return facade.getCouponByEndDate(javaDate);
	}

	@RequestMapping(value = "/updateCouponPrice", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody void updateCouponPrice(@RequestBody CouponBean coupon,HttpServletRequest request) {
		((CompanyFacade) request.getSession().getAttribute("companyFacade")).updateCouponPrice(((CompanyFacade) request.getSession().getAttribute("companyFacade")).getCouponById(coupon.getId()), coupon.getPrice());
		//facade.updateCouponPrice(facade.getCouponById(coupon.getId()), coupon.getPrice());
	}

	@RequestMapping(value = "/removeCoupon", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody void removeCoupon(@RequestParam Long id,HttpServletRequest request) {
		CouponBean c = ((CompanyFacade) request.getSession().getAttribute("companyFacade")).getCouponById(id);
		((CompanyFacade) request.getSession().getAttribute("companyFacade")).removeCoupon(c);
		//CouponBean c = facade.getCouponById(id);
		//facade.removeCoupon(c);
	
	}

}
