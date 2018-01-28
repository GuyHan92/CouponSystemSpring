package com.example.demo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Path;

import org.springframework.stereotype.Controller;


@Path("SessionServlet")
@Controller
public class SessionServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("testing1");
		
		// looking for the autherized in the request [not good idea...]
//		if (request.getAttribute("autherized") == null)
//		{
//			out.append("NON Autherized user!");
//		}
//		else
//		{
//			boolean auth = (boolean)request.getAttribute("autherized");
//			out.append("autherized. value = " + auth);
//		}
		
		// searching for the autherized in the session [better idea :) ]
		// if you go through the login servlet at least ONE tIME, then the autherized 
		// key will be stored on the session until the session ends...
		// which means you can browse directly to THIS servlet and be autherized
		if (request.getSession().getAttribute("auth") != null)
		{
			System.out.println("testing2");
			switch ((String)request.getSession().getAttribute("clientType")) {
			
			case "Admin":
				response.sendRedirect("https://www.google.co.il/");
				break;
			case "Company":
				response.sendRedirect("https://www.google.co.il/");
				break;
			case "User":
				response.sendRedirect("https://www.google.co.il/");
				break;
			}
		}
		else
		{
			response.sendRedirect("http://localhost:4200");
		}		
		
	}
}
