<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.sql.*"%>
<%@ page import="javax.naming.*"%>
<%@ page import="javax.sql.*"%>

<% 
	Context initContext = new InitialContext();
	Context envContext = (Context) initContext.lookup("java:/comp/env");
	DataSource ds = (DataSource) envContext.lookup("jdbc/test");
	Connection conn = ds.getConnection();
	PreparedStatement pstmt = conn.prepareStatement("select * from testdata");
	ResultSet rs = pstmt.executeQuery();
	
	int id = 0;
	String foo = "";
	int bar = 0;
	out.println("data from database");
	
	while(rs.next()) {
		id = rs.getInt(1);
		foo = rs.getString(2);
		bar = rs.getInt(3);
		out.println("id = [" + id + "]");
		out.println("foo = [" + foo + "]");
		out.println("bar = [" + bar + "]");
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

</body>
</html>