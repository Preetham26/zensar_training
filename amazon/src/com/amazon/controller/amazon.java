package com.amazon.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.amazon.entity.AmazonEmployee;
import com.amazon.service.AmazonService;
import com.amazon.service.AmazonServiceInterface;

/**
 * Servlet implementation class amazon
 */
@WebServlet("/amazon")
public class amazon extends HttpServlet 
{
protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		
		String option = request.getParameter("ac");
		if(option.equals("login"))
		{
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		AmazonEmployee aa = new AmazonEmployee();
		
		aa.setEmail(email);
		aa.setPassword(password);
		
		AmazonServiceInterface as = AmazonService.createServiceObject();
		int i =as.createProfile(aa);
		if(i>0)
		{
			out.print("login succesful");
		}
		else
		{
			out.println("login fail");
		}
	}
		out.println("</body></html>");
}
}