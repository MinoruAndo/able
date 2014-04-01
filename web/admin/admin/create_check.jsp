<%@ page language="java" contentType="text/html; charset=Windows-31J"
    pageEncoding="Windows-31J"%>
<%@ page import="DB.*,admin_adminmanager.*,java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=Windows-31J">
<title>登録確認画面</title>
</head>
<body>
<h2>登録確認画面</h2>
<%AdminCreateForm adminCreateForm = (AdminCreateForm)request.getAttribute("list"); %>

	<form action="/able/admin_adminmanager/AdminCreateConfirm.do" method="post">
		loginId： <%=adminCreateForm.getLoginid() %><br>
		社員番号： <%=adminCreateForm.getStaffNo() %><br>
		password： <%=adminCreateForm.getPassword() %><br>
		<input type="submit" value="登録">
	</form>

	<a href="/able/web/admin/admin/admin_create.jsp">戻る</a>

</body>
</html>

<!--
http://localhost:8080/able/web/user/login.jsp
 -->