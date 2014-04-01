<%@ page language="java" contentType="text/html; charset=Windows-31J"
    pageEncoding="Windows-31J"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=Windows-31J">
<title>登録確認画面</title>
</head>
<body>
<h2>登録確認画面</h2>
<form action="/able/user/usercreateconfirm.do" method="post">
loginId： ${user_UserInfoForm.loginid}<br>
password： ${user_UserInfoForm.password}<br>
mailaddress： ${user_UserInfoForm.mail}<br>
<input type="submit" value="登録">
</form>
<form action="/able/web/user/usercreate.jsp" method="post">
<input type="submit" value="戻る">
</form>

</body>
</html>

<!--
WEB-INF内
-->