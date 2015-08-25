<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	String id = "";
	if(request.getAttribute("id") != null) {
		id = "[" + (String)request.getAttribute("id") + "]";
	} else {
		id = "[Requset에 조회된 id 값이 없습니다.]";
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Requset에 조회된 값</title>
</head>
<body>
Request에 조회된 값은 아래와 같습니다.
<br>
<%=id %>
</body>
</html>