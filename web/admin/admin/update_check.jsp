<%@ page language="java" contentType="text/html; charset=Windows-31J"
    pageEncoding="Windows-31J"%>
<%@ page import="DB.*,admin_adminmanager.*,java.util.*" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=Windows-31J">
<title>�Ǘ��ҍ폜</title>
</head>

<body>
<%	List<AdminCreate> list = (List<AdminCreate>)request.getAttribute("list");
	AdminUpdateForm adminUpdateForm = (AdminUpdateForm)request.getAttribute("adminUpdateForm");
	AdminCreate admin = list.get(0);
%>

<h2>�ȉ��̓��e�ōX�V���܂��B��낵���ł����H</h2>

	<table border="1">
		<tr>
			<th></th><th>�o�^��</th><th>�X�V���e</th>
		<tr>
			<th>���O�C��ID</th><td><%=admin.getLoginid() %></td>
					<td><%=adminUpdateForm.getLoginid() %></td></tr>
		<tr>
			<th>�p�X���[�h</th><td><%=admin.getPassword() %></td>
					<td><%=adminUpdateForm.getPassword() %></td></tr>
	</table>

	<form action="updatecheck.do">
		<input type="hidden"  name="id" value=<%=admin.getLoginid()%>>
		<input type="submit" name="update" value="�X�V">
	</form></td>

	<a href="/able/admin_adminmanager/update.do?loginid=<%=admin.getLoginid() %>&edit=�ҏW">�߂�</a>

</body>
</html>