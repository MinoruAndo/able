<%@ page language="java" contentType="text/html; charset=Windows-31J"
    pageEncoding="Windows-31J"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=Windows-31J">
<title>���[�U�[���O�C��</title>
</head>
<body>
<html:errors/>
<html:messages id="messages" message="true">
<font color="red">${messages }</font>
</html:messages>
<form action="/able/user/outuserlogin.do" method="post">
���O�C��ID�F <input type="text" name="id"><br>
�p�X���[�h�F <input type="password" name="password"><br>
<input type="submit" value="���O�C��">
<input type="hidden" value="${param.param }" name="gamen">
</form>
<form action="/able/web/user/usercreate.jsp" method="post">
<input type="submit" value="�A�J�E���g�V�K�o�^">
</form>
<%-- <html:form action="/user/outuserlogin.do" method="post"> --%>
<%-- ���O�C��ID<html:text property="id"/><br> --%>
<%-- �p�X���[�h<html:password property="password"/><br> --%>
<%-- <input type="hidden" value="${param.param }" name="gamen"> --%>
<%-- <html:submit>���O�C��</html:submit> --%>
<%-- </html:form> --%>
</body>
</html>

<!--
http://localhost:8080/able/web/user/login.jsp
 -->