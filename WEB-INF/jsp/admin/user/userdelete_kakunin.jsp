<%@ page language="java" contentType="text/html; charset=Windows-31J"
    pageEncoding="Windows-31J"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- <meta http-equiv="Content-Type" content="text/html; charset=Windows-31J"> -->
<title>退会確認</title>
</head>
<body>
<h2>ユーザー削除</h2>
<form action="/able/admin_usermanager/usedelete.do" method="post">
loginId： ${admin_usermanager_UserDelForm.loginid}<br>
<input type="submit" value="はい">
</form>
<form action="/able/web/admin/user/user_menu.jsp" method="post">
<input type="submit" value="いいえ">
</form>

</body>
</html>
<!--
http://localhost:8080/able/web/user/userdeletei.jsp
 -->