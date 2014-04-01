<%@ page language="java" contentType="text/html; charset=Windows-31J"
    pageEncoding="Windows-31J"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=Windows-31J">
<title>USER情報の編集確認</title>
</head>
<body>
<h2>USER情報の編集確認</h2>
<form action="/able/user/hensyu_kakunin.do" method="post">
loginId： ${user_UserInfoForm.loginid}<br>
password： ${user_UserInfoForm.password}<br>
mailaddress： ${user_UserInfoForm.mail}<br>
<input type="submit" value="登録">
</form>
<form action="/able/user/userinput.do" method="post">
<input type="submit" value="戻る">
</form>

</body>
</html>

</body>
</html>

<!--
WEB-INF内
-->