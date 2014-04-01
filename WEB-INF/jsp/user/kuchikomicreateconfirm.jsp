<%@ page language="java" contentType="text/html; charset=Windows-31J"
    pageEncoding="Windows-31J"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=Windows-31J">
<title>口コミ登録確認</title>
</head>
<body>

<%
if (loginid == null) {
	response.sendRedirect("/able/web/user/login.jsp");
}
%>
<h2>口コミ登録確認</h2>
最寄り駅：${user_KuchikomiForm.station }<br>
ログインID：${user_KuchikomiForm.loginid }<br>
口コミ情報：${user_KuchikomiForm.kuchikomi }<br>

<br>
<p>この内容で登録しますがよろしいですか？</p>
<form action="/able/user/kuchikomicreateconfirm.do" method="post">
<input type="submit" value="登録">
</form>
<form action="/able/web/user/kuchikomicreate.jsp" method="post">
<input type="submit" value="編集">
</form>

</body>
</html>

<!--
WEB-INF内
-->