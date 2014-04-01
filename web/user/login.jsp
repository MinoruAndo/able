<%@ page language="java" contentType="text/html; charset=Windows-31J"
    pageEncoding="Windows-31J"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=Windows-31J">
<title>ユーザーログイン</title>
</head>
<body>
<html:errors/>
<html:messages id="messages" message="true">
<font color="red">${messages }</font>
</html:messages>
<form action="/able/user/outuserlogin.do" method="post">
ログインID： <input type="text" name="id"><br>
パスワード： <input type="password" name="password"><br>
<input type="submit" value="ログイン">
<input type="hidden" value="${param.param }" name="gamen">
</form>
<form action="/able/web/user/usercreate.jsp" method="post">
<input type="submit" value="アカウント新規登録">
</form>
<%-- <html:form action="/user/outuserlogin.do" method="post"> --%>
<%-- ログインID<html:text property="id"/><br> --%>
<%-- パスワード<html:password property="password"/><br> --%>
<%-- <input type="hidden" value="${param.param }" name="gamen"> --%>
<%-- <html:submit>ログイン</html:submit> --%>
<%-- </html:form> --%>
</body>
</html>

<!--
http://localhost:8080/able/web/user/login.jsp
 -->