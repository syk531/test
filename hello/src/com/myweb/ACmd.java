package com.myweb;

import javax.servlet.http.HttpServletRequest;

public class ACmd {
	private String displayname;
	
	public ACmd(String displayname) {
		this.displayname = displayname;
	}
	
	public String connect(HttpServletRequest req) throws Exception {
		String id = null;
		String retval = "";
		
		try {
			id = req.getParameter("id");
			retval = "Welcome " + id;
			req.setAttribute("id", retval);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		return displayname;
	}
}
