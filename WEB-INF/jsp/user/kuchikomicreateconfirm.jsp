<%@ page language="java" contentType="text/html; charset=Windows-31J"
    pageEncoding="Windows-31J"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=Windows-31J">
<title>���R�~�o�^�m�F</title>
</head>
<body>

<%
if (loginid == null) {
	response.sendRedirect("/able/web/user/login.jsp");
}
%>
<h2>���R�~�o�^�m�F</h2>
�Ŋ��w�F${user_KuchikomiForm.station }<br>
���O�C��ID�F${user_KuchikomiForm.loginid }<br>
���R�~���F${user_KuchikomiForm.kuchikomi }<br>

<br>
<p>���̓��e�œo�^���܂�����낵���ł����H</p>
<form action="/able/user/kuchikomicreateconfirm.do" method="post">
<input type="submit" value="�o�^">
</form>
<form action="/able/web/user/kuchikomicreate.jsp" method="post">
<input type="submit" value="�ҏW">
</form>

</body>
</html>

<!--
WEB-INF��
-->