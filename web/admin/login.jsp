<%@ page language="java" contentType="text/html; charset=Windows-31J"
    pageEncoding="Windows-31J"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=Windows-31J">
<title>ログイン</title>
</head>
<body>

<html:errors/>
<html:messages id="messages" message="true">
<font color="red">${messages }</font>
</html:messages>

<form action="/able/admin/outuserlogin.do" method="post">
ID： <input type="text" name="id"><br>
password： <input type="password" name="password"><br>
<input type="submit" value="ログイン">
</form>

</body>
</html>

<!--
http://localhost:8080/able/web/admin/login.jsp
 -->