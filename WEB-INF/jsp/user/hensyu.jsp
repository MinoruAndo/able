<%@ page language="java" contentType="text/html; charset=Windows-31J"
    pageEncoding="Windows-31J"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<!-- <meta http-equiv="Content-Type" content="text/html; charset=Windows-31J"> -->
<title>USER���̕ҏW</title>
</head>
<body>
<h2>�}�C�y�[�W�ҏW</h2>
<html:errors/>
<html:messages id="messages" message="true">
<font color="red">${messages }</font>
</html:messages>
<form action="/able/user/hensyu.do" method="post">
���O�C��ID�F <input value="${user_UserInfoForm.loginid}" type="text" name="loginid"><br>
E���[���F <input value="${user_UserInfoForm.mail}" type="text" name="mail"><br>
�p�X���[�h�F <input value="${user_UserInfoForm.password}" type="password" name="password"><br>

<input type="submit" value="����">
</form>


</body>
</html>

<!--
WEB-INF��
-->