<%@ page language="java" contentType="text/html; charset=Windows-31J"
    pageEncoding="Windows-31J"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=Windows-31J">
<title>�Ǘ��ҊǗ����j���[</title>
</head>
<body>
<%=request.getAttribute("msg") %>

	<h2>�Ǘ��ғo�^���</h2>

	<form action="/able/admin_adminmanager/AdminCreate.do" method="post">

		���O�C���h�c:
		<input type="text" name="loginid"><br>

		�Ј��ԍ�:
		<input type="text" name="staffNo"><br>

		�p�X���[�h:
		<input type="password" name="password"><br>

		<input type="submit" name="create" value="�o�^">

	</form>



	<form action="/able/web/admin/admin/admin_menu.jsp">
<input type="submit" value="�߂�">

</form>



</body>
</html>

<!--
  http://localhost:8080/able/web/admin/admin/admin_create.jsp
  -->