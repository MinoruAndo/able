<%@ page language="java" contentType="text/html; charset=Windows-31J"
    pageEncoding="Windows-31J"%>
<%@ page import="DB.*, java.util.*,admin.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=Windows-31J">
<title>�Ǘ��҃A�J�E���g�ꗗ</title>
</head>
<body>
<h2>�Ǘ��҃A�J�E���g�ꗗ</h2>

<table border="1">
	<tr>
		<th>���O�C��ID</th>
		<th>�Ј��ԍ�</th>
		<th>�o�^��</th>
		<th></th><th></th>	</tr>

<%	List<AdminCreate> list = (List<AdminCreate>)request.getAttribute("list");
if(list.size() > 0) {
for (int i = 0; i < list.size(); i++) {
	AdminCreate admin = list.get(i);
%>

<tr>
	<td><%=admin.getLoginid() %></td>
	<td><%=admin.getStaffNo() %></td>
	<td><%=admin.getAdddate() %></td>

	<td><form action="deletecheck.do">
			<input type="hidden"  name="loginid" value=<%=admin.getLoginid()%>>
			<input type="submit" name="check" value="�폜">
		</form></td>

	<td><form action="update.do">
			<input type="hidden"  name="loginid" value=<%=admin.getLoginid()%>>
			<input type="submit" name="edit" value="�ҏW">
			</form></td>

</tr>


	<%}
}%>
</table>

	<p><a href="/able/web/admin/admin/admin_menu.jsp">�߂�</a>

</body>
</html>

<!--
http://localhost:8080/able/web/admin/admin/search_success.jsp
 -->