<%@ page language="java" contentType="text/html; charset=Windows-31J"
    pageEncoding="Windows-31J"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=Windows-31J">
<title>�o�^���</title>
</head>
<body>
<h2>�o�^���</h2>
<html:errors/>
<html:messages id="messages" message="true">
<font color="red">${messages }</font>
</html:messages>
<!-- input�pjsp -->
<html:form action="/user/outusercreate.do" method="post">
���O�C���h�c:<html:text property="loginid"/>(10�����ȓ�)<br>
�p�X���[�h:<html:password property="password"/>(10�����ȓ�)<br>
���[���A�h���X:<html:text property="mail"/><br>
<html:submit>�o�^</html:submit>
</html:form>


<%-- <form action="../../user/usercreate.do" method="post"> --%>
<!-- loginId�F <input type="text" name="loginid"><br> -->
<!-- password�F <input type="password" name="password"><br> -->
<!-- mailaddress�F <input type="text" name="mail"><br> -->
<!-- <input type="submit" value="�o�^"> -->
<%-- </form> --%>

</body>
</html>

<!--
http://localhost:8080/able/web/user/usercreate.jsp
 -->