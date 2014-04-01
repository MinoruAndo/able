<%@ page language="java" contentType="text/html; charset=Windows-31J"
    pageEncoding="Windows-31J"%>
<%@page import="admin_search.SearchForm,org.apache.struts.upload.FormFile"%>
<%@ page import="DB.*, java.util.*;" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=Windows-31J">
<title>show</title>
</head>
<body>
<%
//更新処理をした後だったら
if(request.getParameter("update") != null) {
	 List<Room> list = (List<Room>)request.getAttribute("show");
	  Room room = list.get(0);
%>
以下の内容に更新しました

	  <table border="1">
		<tr>	<th>	<td>登録状況</td>
		<tr>	<th>物件コード<td><%=room.getCode() %></td>
		<tr>	<th>物件名<td><%=room.getName() %></td>
		<tr>	<th>物件説明<td><%=room.getText() %> </td>
		<tr>	<th>入居可能人数<td><%=room.getPeople() %></td>
		<tr>	<th>価格<td><%=room.getPrice() %></td>
		<tr>	<th>ペット可否<td><%=room.isPet() %></td>
		<tr>	<th>住所<td><%=room.getAddress() %></td>
		<tr>	<th>写真<td><img style="-webkit-user-select: none; cursor: -webkit-zoom-in;" src="/able/<%=room.getPhoto() %>" width="644" height="483">
</td>
		<tr>	<th>最寄駅<td><%=room.getStation() %></td>
	</tr>
<!-- <img  src="/able/Hydrangeas.jpg" width="644" height="483"> -->


</table>
<%
//検索結果からだったら
}else {

  List<Room> list = (List<Room>)request.getAttribute("list");
  Room room = list.get(0);
%>
<table border="1" cellpadding="" cellspacing="" >
<tr>
	<td>

<table border="1" cellpadding="20" cellspacing="1">
		<tr>	<th>	<td>登録状況</td>
		<tr>	<th>物件コード<td><%=room.getCode() %></td>
		<tr>	<th>物件名<td><%=room.getName() %></td>
		<tr>	<th>物件説明<td><%=room.getText() %> </td>
		<tr>	<th>入居可能人数<td><%=room.getPeople() %></td>
		<tr>	<th>価格<td><%=room.getPrice() %></td>
		<tr>	<th>ペット可否<td><%=room.isPet() %></td>
		<tr>	<th>住所<td><%=room.getAddress() %></td>
	<!--  	<tr>	<th>写真<td><img src="<%=room.getPhoto() %>" alt="↓画像なし"><%=room.getPhoto() %></td>	-->
		<tr>	<th>最寄駅<td><%=room.getStation() %></td>
	</tr>
</table>

</td>
<td>

<table border="0">
登録写真：


<%
	//nullだったらなにも表示させない
SearchForm searchform = (SearchForm)session.getAttribute("admin_search_SearchAction");
// String formfile = (String)searchform.getPhoto();
if (room.getPhoto() == null || "".equals(room.getPhoto())) {
%>ありません<br>
<%}else{%>
<tr>
<td>
<br>
	<img style="-webkit-user-select: none; cursor: -webkit-zoom-in;" src="/able/<%=room.getPhoto() %>" width="644" height="483">


<%}}%>
</td>

　　</tr>
　　</table>



　</td>
</tr>
</table>

<br>
<a href="/able/web/admin/room/room_menu.jsp">空き部屋管理メニュー</a>

</body>
</html>

<!--
http://localhost:8080/able/admin_search/show.do
 -->