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
	AdminCreate admin = list.get(0);
%>

<h2>本当に削除してよろしいですか？</h2>

	<table border="1">
		<tr>
			<th>ログインID</th>
			<th>社員番号</th>
			<th>登録日時</th>
			<th></th>	</tr>
		<tr>
			<td><%=admin.getLoginid() %></td>
			<td><%=admin.getStaffNo() %></td>
			<td><%=admin.getAdddate() %></td>
			<td><form action="delete.do">
					<input type="hidden"  name="loginid" value=<%=admin.getLoginid()%>>
					<input type="submit" name="delete" value="削除">
				</form></td>
		</tr>
	</table>

	<a href="/able/admin_adminmanager/AdminCreate.do?flg=findAll">戻る</a><br>


</body>
</html>