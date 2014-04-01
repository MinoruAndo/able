<%@ page language="java" contentType="text/html; charset=Windows-31J"
    pageEncoding="Windows-31J"%>
<%@ page import="DB.*, java.util.*,admin.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=Windows-31J">
<title>管理者アカウント一覧</title>
</head>
<body>
<h2>管理者アカウント一覧</h2>

<table border="1">
	<tr>
		<th>ログインID</th>
		<th>社員番号</th>
		<th>登録日</th>
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
			<input type="submit" name="check" value="削除">
		</form></td>

	<td><form action="update.do">
			<input type="hidden"  name="loginid" value=<%=admin.getLoginid()%>>
			<input type="submit" name="edit" value="編集">
			</form></td>

</tr>


	<%}
}%>
</table>

	<p><a href="/able/web/admin/admin/admin_menu.jsp">戻る</a>

</body>
</html>

<!--
http://localhost:8080/able/web/admin/admin/search_success.jsp
 -->