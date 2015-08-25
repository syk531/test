package com.ecampus.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class JDBC_Checker {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//JDBC ¿¬°á
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		String url_name = "jdbc:mysql://localhost:3306/test";
		String drv_name = "com.mysql.jdbc.Driver";
		String id = "syk";
		String pwd = "syk";
		
		try {
			Class.forName(drv_name);
		} catch(ClassNotFoundException e) {
			System.out.println("ClassNotFoundException");
			System.out.println(e.getMessage());
		}
		
		try {
			con = DriverManager.getConnection(url_name, id, pwd);
		} catch(SQLException e) {
			System.out.println("SQLExeption");
			System.out.println(e.getMessage());
		}
		
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery("select * from test.mytable");
			StringBuffer sb = new StringBuffer();
			sb.append("id	|name	|ip	|gender	|date	\n");
			sb.append("---------------------------------\n");
			
			while(rs.next()) {
				sb.append(rs.getString(1) + "\t");
				sb.append(rs.getString(2) + "\t");
				sb.append(rs.getString(3) + "\t");
				sb.append(rs.getString(4) + "\t");
				sb.append(rs.getDate(5) + "\t");
				sb.append("\n");
			}
			System.out.println(sb.toString());
			
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}

}
