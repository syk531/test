<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	String id = "";
	if(request.getAttribute("id") != null) {
		id = "[" + (String)request.getAttribute("id") + "]";
	} else {
		id = "[Requset�� ��ȸ�� id ���� �����ϴ�.]";
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Requset�� ��ȸ�� ��</title>
</head>
<body>
Request�� ��ȸ�� ���� �Ʒ��� �����ϴ�.
<br>
<%=id %>
</body>
</html>