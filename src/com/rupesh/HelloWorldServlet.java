package com.rupesh;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloWorldServlet
 */
//@WebServlet(description = "Hello World Servlet", urlPatterns = { "/HelloWorldServlet" })
public class HelloWorldServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private String message;

	public void init() throws ServletException {
		// Do required initialization
		System.out.println("Inside Init");
		message = "Hello World";
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Inside DoGET");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<h1> GET: " + message + "</h1>");
		
		//response.sendRedirect("http://localhost:8080/MyFirstJSPServletProject/HelloForm");
		
		RequestDispatcher rd = request.getRequestDispatcher("HelloForm");
		rd.include(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Inside DoPOST");

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<h1> POST: " + message + "</h1>");
		
		response.sendRedirect("http://localhost:8080/MyFirstJSPServletProject/HelloForm");
	}
	
	public void destroy() {
		System.out.println("Inside Destroy");
	}
}
