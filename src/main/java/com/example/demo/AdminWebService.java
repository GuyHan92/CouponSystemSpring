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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import company.CompanyBean;
import coupon.CouponBean;
import facade.AdminFacade;
import user.UserBean;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "*")
public class AdminWebService {

	@RequestMapping(value = "/session", method = RequestMethod.POST)
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getSession().getAttribute("adminFacade") == null) {
			return;
		} else {
			response.sendRedirect("/adminPage/index.html");
		}
	}

	@RequestMapping(value = "/adminDetails", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody UserBean adminDetails(HttpServletRequest request) {
		return ((AdminFacade) request.getSession().getAttribute("adminFacade")).adminDetails();
		//return facade.adminDetails();
	}

	@RequestMapping(value = "/adminGetAllCoupons", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Collection<CouponBean> getAllCoupons(HttpServletRequest request) {
		return ((AdminFacade) request.getSession().getAttribute("adminFacade")).getAllCoupons();
		// return facade.getAllCoupons();
	}

	@RequestMapping(value = "/createCompany", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public void createCompany(@RequestBody CompanyBean Company, HttpServletRequest request) {
		CompanyBean c = ((AdminFacade) request.getSession().getAttribute("adminFacade"))
				.createCompanyBean(Company.getCompanyName(), Company.getPassword(), Company.getEmail());
		((AdminFacade) request.getSession().getAttribute("adminFacade")).createCompany(c);
	}

	@RequestMapping(value = "/getCompany", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody CompanyBean getCompany(Long id, HttpServletRequest request) {
		return ((AdminFacade) request.getSession().getAttribute("adminFacade")).getCompany(id);
		// return facade.getCompany(id);
	}

	@RequestMapping(value = "/getAllCompanies", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Collection<CompanyBean> getAllCompanies(HttpServletRequest request) {
		return ((AdminFacade) request.getSession().getAttribute("adminFacade")).getAllCompanies();
		// return facade.getAllCompanies();
	}

	@RequestMapping(value = "/updateCompanyPassword", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody void updateCompanyPassword(@RequestBody CompanyBean company, HttpServletRequest request) {
		((AdminFacade) request.getSession().getAttribute("adminFacade")).updateCompany(
				((AdminFacade) request.getSession().getAttribute("adminFacade")).getCompany(company.getCompanyID()),
				"password", company.getPassword());
		// facade.updateCompany(facade.getCompany(company.getCompanyID()), "password",
		// company.getPassword());
	}

	@RequestMapping(value = "/updateCompanyEmail", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody void updateCompanyEmail(@RequestBody CompanyBean company, HttpServletRequest request) {
		((AdminFacade) request.getSession().getAttribute("adminFacade")).updateCompany(
				((AdminFacade) request.getSession().getAttribute("adminFacade")).getCompany(company.getCompanyID()),
				"Email", company.getEmail());
		// facade.updateCompany(facade.getCompany(company.getCompanyID()), "Email",
		// company.getEmail());
	}

	@RequestMapping(value = "/updateCompanyStatus", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody void updateCompanyStatus(@RequestBody CompanyBean company, HttpServletRequest request) {
		((AdminFacade) request.getSession().getAttribute("adminFacade")).updateCompany(
				((AdminFacade) request.getSession().getAttribute("adminFacade")).getCompany(company.getCompanyID()),
				"pendingAdminReview", Boolean.toString(company.isPendingAdminReview()));
		// facade.updateCompany(facade.getCompany(company.getCompanyID()),
		// "pendingAdminReview", Boolean.toString(company.isPendingAdminReview()));
	}

	@RequestMapping(value = "/removeCompany", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody void removeCompany(@RequestParam Long id, HttpServletRequest request) {
		((AdminFacade) request.getSession().getAttribute("adminFacade"))
				.removeCompany(((AdminFacade) request.getSession().getAttribute("adminFacade")).getCompany(id));
		// facade.removeCompany(facade.getCompany(id));
	}

	@RequestMapping(value = "/createUser", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public void createUser(@RequestBody UserBean user, HttpServletRequest request) {
		UserBean c = ((AdminFacade) request.getSession().getAttribute("adminFacade")).createUserBean(user.getUserName(),
				user.getPassword());
		((AdminFacade) request.getSession().getAttribute("adminFacade")).createUser(c);
	}

	@RequestMapping(value = "/getUser", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody UserBean getUser(Long id, HttpServletRequest request) {
		return ((AdminFacade) request.getSession().getAttribute("adminFacade")).getUser(id);
		// return facade.getUser(id);
	}

	@RequestMapping(value = "/getAllUsers", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Collection<UserBean> getAllUsers(HttpServletRequest request) {
		return ((AdminFacade) request.getSession().getAttribute("adminFacade")).getAllUsers();
		// return facade.getAllUsers();
	}

	@RequestMapping(value = "/updateUserPassword", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody void updateUserPassword(@RequestBody UserBean user, HttpServletRequest request) {
		((AdminFacade) request.getSession().getAttribute("adminFacade")).updateUser(
				((AdminFacade) request.getSession().getAttribute("adminFacade")).getUser(user.getUserID()), "password",
				user.getPassword());
		// facade.updateUser(user, "password", user.getPassword());
	}

	@RequestMapping(value = "/updateUserStatus", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody void updateUserStatus(@RequestBody UserBean user, HttpServletRequest request) {
		((AdminFacade) request.getSession().getAttribute("adminFacade")).updateUser(
				((AdminFacade) request.getSession().getAttribute("adminFacade")).getUser(user.getUserID()), "",
				Boolean.toString(user.isAdminStatus()));
		// facade.updateUser(user, "adminStatus",
		// Boolean.toString(user.isAdminStatus()));
	}

	@RequestMapping(value = "/removeUser", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody void removeUser(@RequestParam Long id, HttpServletRequest request) {
		((AdminFacade) request.getSession().getAttribute("adminFacade"))
				.removeUser(((AdminFacade) request.getSession().getAttribute("adminFacade")).getUser(id));
		// facade.removeUser(facade.getUser(id));
	}

}
