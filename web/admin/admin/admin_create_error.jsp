<%@ page language="java" contentType="text/html; charset=Windows-31J"
    pageEncoding="Windows-31J"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=Windows-31J">
<title>管理者管理メニュー</title>
</head>
<body>
<%=request.getAttribute("msg") %>

	<h2>管理者登録画面</h2>

	<form action="/able/admin_adminmanager/AdminCreate.do" method="post">

		ログインＩＤ:
		<input type="text" name="loginid"><br>

		社員番号:
		<input type="text" name="staffNo"><br>

		パスワード:
		<input type="password" name="password"><br>

		<input type="submit" name="create" value="登録">

	</form>



	<form action="/able/web/admin/admin/admin_menu.jsp">
<input type="submit" value="戻る">

</form>



</body>
</html>

<!--
  http://localhost:8080/able/web/admin/admin/admin_create.jsp
  -->