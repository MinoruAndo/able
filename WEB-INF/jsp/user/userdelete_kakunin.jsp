<%@ page language="java" contentType="text/html; charset=Windows-31J"
    pageEncoding="Windows-31J"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- <meta http-equiv="Content-Type" content="text/html; charset=Windows-31J"> -->
<title>�މ�m�F</title>
</head>
<body>
<h2>�މ�</h2>
<form action="/able/user/userdeletekanryo.do" method="post">
loginId�F ${userInfo.loginid}<br>
mailaddress�F ${userInfo.mail}<br>
<input type="submit" value="�͂�">
</form>
<form action="/able/web/user/mypage.jsp" method="post">
<input type="submit" value="������">
</form>

</body>
</html>

<!--
WEB-INF��
-->