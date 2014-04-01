<%@ page language="java" contentType="text/html; charset=Windows-31J"
    pageEncoding="Windows-31J"%>
<%@page import="admin_search.RoomCreateForm,org.apache.struts.upload.FormFile"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=Windows-31J">
<title>create check</title>
</head>
<body>
<table border="1" cellpadding="" cellspacing="" >
<tr>
	<td>

<table border="1" cellpadding="20" cellspacing="1">
		<tr>	<th>	<td>登録確認</td>
		<tr>	<th>物件コード<td>${admin_search_RoomCreate.code}</td>
		<tr>	<th>物件名<td>${admin_search_RoomCreate.name}</td>
		<tr>	<th>物件説明<td>${admin_search_RoomCreate.text}</td>
		<tr>	<th>入居可能人数<td>${admin_search_RoomCreate.people}</td>
		<tr>	<th>価格<td>${admin_search_RoomCreate.price}</td>
		<tr>	<th>ペット可否<td>${admin_search_RoomCreate.pet}</td>
		<tr>	<th>住所<td>${admin_search_RoomCreate.address}</td>
<%-- 	 	<tr>	<th>写真<td>${admin_search_RoomCreate.photo}</td>	 --%>
		<tr>	<th>最寄駅<td>${admin_search_RoomCreate.station}</td>
	</tr>

</table>
</td>
<td>

<table border="0">
登録写真：
<%
	//nullだったらなにも表示させない
RoomCreateForm roomCreateForm = (RoomCreateForm)session.getAttribute("admin_search_RoomCreate");
FormFile formfile = (FormFile)roomCreateForm.getPhoto();
if (formfile == null || "".equals(formfile.getFileName())) {
%>なし <br><br><%
}
else {
	%>
	<%
	out.println(formfile.getFileName());
	%>
	<tr>
<td>
<br>
	<img style="-webkit-user-select: none; cursor: -webkit-zoom-in;" src="/able/${admin_search_RoomCreate.photo}" width="644" height="483">
	<br>
	<%
}
%>
</td>

	</tr>
</table>
　</td>
</tr>
</table><br>
この内容で登録しますがよろしいですか？
<form action="/able/admin_search/roomregist.do" method="post">
<input type="hidden"  name="pet" value="<%=roomCreateForm.isPet()%>">
<input type="submit" value="登録">
</form>
<form action="/able/web/admin/room/room_create.jsp"  method="post">

<input type="submit" name="pic_del" value="編集">
</form>

</body>
</html>

<!--
WEB-INF内
 -->