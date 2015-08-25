package com.myweb;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Aservlet
 */
@WebServlet("/Aservlet")
public class Aservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String jspdir ="/";

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String displayname = null;
		String chk = "";
		try {
			ACmd cmd = new ACmd("A.jsp");
			displayname = cmd.connect(req);
			RequestDispatcher rd;
			rd = getServletContext().getRequestDispatcher(jspdir + displayname);
			rd.forward(req, res);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
