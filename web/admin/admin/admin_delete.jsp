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
	AdminCreate admin = list.get(0);
%>

<h2>�{���ɍ폜���Ă�낵���ł����H</h2>

	<table border="1">
		<tr>
			<th>���O�C��ID</th>
			<th>�Ј��ԍ�</th>
			<th>�o�^����</th>
			<th></th>	</tr>
		<tr>
			<td><%=admin.getLoginid() %></td>
			<td><%=admin.getStaffNo() %></td>
			<td><%=admin.getAdddate() %></td>
			<td><form action="delete.do">
					<input type="hidden"  name="loginid" value=<%=admin.getLoginid()%>>
					<input type="submit" name="delete" value="�폜">
				</form></td>
		</tr>
	</table>

	<a href="/able/admin_adminmanager/AdminCreate.do?flg=findAll">�߂�</a><br>


</body>
</html>