<%@ page language="java" contentType="text/html; charset=Windows-31J"
    pageEncoding="Windows-31J"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=Windows-31J">
<title>o^®¹</title>
</head>
<body>

o^µÜµ½<br>

<a href="/able/web/user/usertop.jsp">TOPÉßé</a><br>

<%
String station = (String)session.getAttribute("station");
if (station != null) {
	%><a href="/able/web/user/kuchikomicreate.jsp">ûR~o^Éßé</a><br><%
}
%>


</body>
</html>

<!--
WEB-INFà
 -->