package com.example.demo;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import core.CouponSystem;
import facade.AdminFacade;
import facade.CompanyFacade;
import facade.UserFacade;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@RequestMapping(method = RequestMethod.GET)
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("/loginPage/Login.html");
	}

	@RequestMapping(method = RequestMethod.POST)
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("Login activated " + request);

		String name = request.getParameter("nameBox");
		String password = request.getParameter("passwordBox");
		String clientType = request.getParameter("clientBox");

		switch (clientType) {
		case "admin":
			AdminFacade adminFacade = CouponSystem.getInstance().AdminLoginToCouponSystem(name, password, clientType);
			request.getSession().setAttribute("adminFacade", adminFacade);
			if (request.getSession().getAttribute("adminFacade") == null) {
				this.doGet(request, response);
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/session");
				dispatcher.forward(request, response);
			}
			break;

		case "company":
			System.out.println("company");
			CompanyFacade companyFacade = CouponSystem.getInstance().CompanyLoginToCouponSystem(name, password,
					clientType);
			request.getSession().setAttribute("companyFacade", companyFacade);
			if (request.getSession().getAttribute("companyFacade") == null) {
				this.doGet(request, response);
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/company/session");
				dispatcher.forward(request, response);
			}
			break;

		case "user":
			System.out.println("user");
			UserFacade userFacade = CouponSystem.getInstance().UserLoginToCouponSystem(name, password, clientType);
			request.getSession().setAttribute("userFacade", userFacade);
			if (request.getSession().getAttribute("userFacade") == null) {
				this.doGet(request, response);
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/user/session");
				dispatcher.forward(request, response);
			}
			break;
		default:
			this.doGet(request, response);
		}
		System.out.println("login ended");
	}
}
