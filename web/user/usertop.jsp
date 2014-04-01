<%@ page language="java" contentType="text/html; charset=Windows-31J"
    pageEncoding="Windows-31J"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- <html> -->
<!-- <head> -->
<!-- <meta http-equiv="Content-Type" content="text/html; charset=Windows-31J"> -->
<title>一般TOP</title>
<!-- </head> -->
<!-- <body> -->

<form action="/able/user/search.do" method="post">
<br>
<hr>
<h2>空き部屋検索</h2><br>

	物件コード
	<input type="text" name="code"><br>

	物件名
	<input type="text" name="name"><br>
	物件説明
	<input type="text" name="text"><br>

	入居可能人数
	<select name="people">
		<option value="1" selected>１</option>
		<option value="2">２</option>
		<option value="3">３</option>
		<option value="4">４</option>
		<option value="5">５</option>
	</SELECT>人以上<br>

	家賃<input type="text" name="pricemin">円～
		<input type="text" name="pricemax">円<br>

	ペット　可：<input type="checkbox" name="pet" ${admin_search_RoomCreate.pet ? "checked" : ""}>
${admin_search_RoomCreate.pet ? "checked" : ""}<br>

	住所
		<input type="text" name="address"><br>


	最寄駅
		<input type="text" name="station">駅<br>

	<br>
		<input type="submit" value="検索">

	<br><br>
</form>
<!-- ログイン状態でボタンの表示・非表示をここにjavaコードで記入？ -->
<%
if (loginid != null) {
	%>
	<%
} else {
	%>
<form action="/able/web/user/login.jsp" method="post">
<input type="submit" value="ログイン">
</form>
<form action="/able/web/user/usercreate.jsp" method="post">
<input type="submit" value="アカウント新規登録">
</form>
	 <%
}	%>
<!-- </body> -->
<!-- </html> -->
<!--
http://localhost:8080/able/web/user/usertop.jsp
 -->