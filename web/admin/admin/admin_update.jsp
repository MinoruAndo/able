<%@ page language="java" contentType="text/html; charset=Windows-31J"
    pageEncoding="Windows-31J"%>
<%@ page import="DB.*,admin_adminmanager.*,java.util.*" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=Windows-31J">
<title>�Ǘ��ҍ폜</title>
</head>

<body>
<%	List<AdminCreate> list = (List<AdminCreate>)request.getAttribute("list");
	AdminCreate admin = list.get(0);
%>

	<h2>�X�V���e����͂��Ă�������</h2>
	�o�^���F<%=admin.getAdddate() %><br>
	�Ј��ԍ��F<%=admin.getStaffNo() %><br>
<html:errors/>
<html:messages id="messages" message="true">
<font color="red">${messages }</font>
</html:messages>

<form action="updatecheck.do">
	<table border="1">

		<tr>
			<th></th><th>�o�^��</th><th>�X�V���e</th>
		<tr>
			<th>���O�C��ID</th><td><%=admin.getLoginid() %></td>
				<td><input type="text" name="loginid"></td></tr>
		<tr>
			<th>�p�X���[�h</th><td><%=admin.getPassword() %></td>
				<td><input type="password" name="password"></td></tr></tr>

	</table>


		<input type="hidden"  name="id" value=<%=admin.getLoginid()%>>
		<input type="submit" name="check" value="�ҏW">
	</form></td>

	<a href="/able/admin_adminmanager/AdminCreate.do?flg=findAll">�߂�</a><br>

</body>
</html>