<%@ page language="java" contentType="text/html; charset=Windows-31J" pageEncoding="Windows-31J"%>
<%@page import="javax.servlet.http.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<script type="text/javascript">
function disp(){
	alert("���O�A�E�g���܂����B");
}
</script>
<html>
<head>

</head>
<body>


<%
String loginid = (String)session.getAttribute("adminlogin");

if (loginid != null) {System.out.println(loginid);
	%>
	�悤����${adminlogin}����<br/>

	<a href="/able/admin/adminlogout.do" onclick="disp()">���O�A�E�g</a><br/>
	<a href="/able/web/admin/menu.jsp">TOP�y�[�W��</a><br/><br/>
<% } %>
<hr>
