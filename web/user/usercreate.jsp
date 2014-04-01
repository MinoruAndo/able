<%@ page language="java" contentType="text/html; charset=Windows-31J"
    pageEncoding="Windows-31J"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=Windows-31J">
<title>登録画面</title>
</head>
<body>
<h2>登録画面</h2>
<html:errors/>
<html:messages id="messages" message="true">
<font color="red">${messages }</font>
</html:messages>
<!-- input用jsp -->
<html:form action="/user/outusercreate.do" method="post">
ログインＩＤ:<html:text property="loginid"/>(10文字以内)<br>
パスワード:<html:password property="password"/>(10文字以内)<br>
メールアドレス:<html:text property="mail"/><br>
<html:submit>登録</html:submit>
</html:form>


<%-- <form action="../../user/usercreate.do" method="post"> --%>
<!-- loginId： <input type="text" name="loginid"><br> -->
<!-- password： <input type="password" name="password"><br> -->
<!-- mailaddress： <input type="text" name="mail"><br> -->
<!-- <input type="submit" value="登録"> -->
<%-- </form> --%>

</body>
</html>

<!--
http://localhost:8080/able/web/user/usercreate.jsp
 -->