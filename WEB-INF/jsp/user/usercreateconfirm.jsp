<%@ page language="java" contentType="text/html; charset=Windows-31J"
    pageEncoding="Windows-31J"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=Windows-31J">
<title>�o�^�m�F���</title>
</head>
<body>
<h2>�o�^�m�F���</h2>
<form action="/able/user/usercreateconfirm.do" method="post">
loginId�F ${user_UserInfoForm.loginid}<br>
password�F ${user_UserInfoForm.password}<br>
mailaddress�F ${user_UserInfoForm.mail}<br>
<input type="submit" value="�o�^">
</form>
<form action="/able/web/user/usercreate.jsp" method="post">
<input type="submit" value="�߂�">
</form>

</body>
</html>

<!--
WEB-INF��
-->