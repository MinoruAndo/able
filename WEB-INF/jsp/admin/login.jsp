<%@ page language="java" contentType="text/html; charset=Windows-31J"
    pageEncoding="Windows-31J"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=Windows-31J">
<title>login</title>
</head>
<body>
loginIdかpasswordが違います<br>
<form action="/able/admin/login.do" method="post">
ID： <input type="text" name="id"><br>
password： <input type="password" name="password"><br>
<input type="submit" value="ログイン">
</form>

</body>
</html>