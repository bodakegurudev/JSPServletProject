package com.rupesh;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class PageHitCounter extends HttpServlet {

	public void init() {
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		int hitCount = session.getAttribute("hitCount") != null ? (int) session.getAttribute("hitCount") : 0;
		hitCount++;
		session.setAttribute("hitCount", hitCount);
		
		// Set response content type
		response.setContentType("text/html");
		response.setIntHeader("Refresh", 5);

		// This method executes whenever the servlet is hit
		// increment hitCount
		PrintWriter out = response.getWriter();
		String title = "Total Number of Hits";
		String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";

		out.println(docType + "<html>\n" + "<head><title>" + title + "</title></head>\n"
				+ "<body bgcolor = \"#f0f0f0\">\n" + "<h1 align = \"center\">" + title + "</h1>\n"
				+ "<h2 align = \"center\">" + hitCount + "</h2>\n" + "</body></html>");
	}

	public void destroy() {
		// This is optional step but if you like you
		// can write hitCount value in your database.
	}
}