<%@ page language="java" contentType="text/html; charset=Windows-31J"
    pageEncoding="Windows-31J"%>
    <%@ page import="DB.*, java.util.*;" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=Windows-31J">
<title>���R�~�o�^</title>
</head>
<body>

<%
String station = (String)session.getAttribute("station");
if (loginid == null) {
	response.sendRedirect("/able/web/user/login.jsp?param=kuchikomi");
}
if (station == null) {
	response.sendRedirect("/able/web/user/usertop.jsp");
}
%>

<h2>���R�~�o�^</h2>

<form action="/able/user/outkuchikomicreate.do" method="post">
 ���R�~���<br>
<textarea rows="10" cols="20" name="kuchikomi" >${user_KuchikomiForm.kuchikomi }</textarea><br>
<input type="hidden" name="loginid" value=${loginid } >
<input type="hidden" name="station" value=${station } >
<input type="submit" value="�o�^"><html:errors/>
<html:messages id="messages" message="true">
<font color="red">${messages }</font>
</html:messages>
</form>

<p>���Q�O�O���ȓ��œ��͂��Ă�������</p>

</body>
</html>
<!--
http://localhost:8080/able/web/user/kuchikomicreate.jsp
 -->