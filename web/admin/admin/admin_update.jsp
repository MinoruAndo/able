<%@ page language="java" contentType="text/html; charset=Windows-31J"
    pageEncoding="Windows-31J"%>
<%@ page import="DB.*,admin_adminmanager.*,java.util.*" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=Windows-31J">
<title>管理者削除</title>
</head>

<body>
<%	List<AdminCreate> list = (List<AdminCreate>)request.getAttribute("list");
	AdminCreate admin = list.get(0);
%>

	<h2>更新内容を入力してください</h2>
	登録日：<%=admin.getAdddate() %><br>
	社員番号：<%=admin.getStaffNo() %><br>
<html:errors/>
<html:messages id="messages" message="true">
<font color="red">${messages }</font>
</html:messages>

<form action="updatecheck.do">
	<table border="1">

		<tr>
			<th></th><th>登録状況</th><th>更新内容</th>
		<tr>
			<th>ログインID</th><td><%=admin.getLoginid() %></td>
				<td><input type="text" name="loginid"></td></tr>
		<tr>
			<th>パスワード</th><td><%=admin.getPassword() %></td>
				<td><input type="password" name="password"></td></tr></tr>

	</table>


		<input type="hidden"  name="id" value=<%=admin.getLoginid()%>>
		<input type="submit" name="check" value="編集">
	</form></td>

	<a href="/able/admin_adminmanager/AdminCreate.do?flg=findAll">戻る</a><br>

</body>
</html>