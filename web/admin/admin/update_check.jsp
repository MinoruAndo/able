<%@ page language="java" contentType="text/html; charset=Windows-31J"
    pageEncoding="Windows-31J"%>
<%@ page import="DB.*,admin_adminmanager.*,java.util.*" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=Windows-31J">
<title>管理者削除</title>
</head>

<body>
<%	List<AdminCreate> list = (List<AdminCreate>)request.getAttribute("list");
	AdminUpdateForm adminUpdateForm = (AdminUpdateForm)request.getAttribute("adminUpdateForm");
	AdminCreate admin = list.get(0);
%>

<h2>以下の内容で更新します。よろしいですか？</h2>

	<table border="1">
		<tr>
			<th></th><th>登録状況</th><th>更新内容</th>
		<tr>
			<th>ログインID</th><td><%=admin.getLoginid() %></td>
					<td><%=adminUpdateForm.getLoginid() %></td></tr>
		<tr>
			<th>パスワード</th><td><%=admin.getPassword() %></td>
					<td><%=adminUpdateForm.getPassword() %></td></tr>
	</table>

	<form action="updatecheck.do">
		<input type="hidden"  name="id" value=<%=admin.getLoginid()%>>
		<input type="submit" name="update" value="更新">
	</form></td>

	<a href="/able/admin_adminmanager/update.do?loginid=<%=admin.getLoginid() %>&edit=編集">戻る</a>

</body>
</html>