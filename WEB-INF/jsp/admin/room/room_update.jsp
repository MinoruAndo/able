<%@page import="admin_search.UpdateAction"%>
<%@ page language="java" contentType="text/html; charset=Windows-31J"
    pageEncoding="Windows-31J"%>
<%@ page import="DB.*, java.util.*,org.apache.struts.upload.FormFile,admin_search.*" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=Windows-31J">
<title>room_update</title>
</head>
<body>
<%List<Room> list = (List<Room>)request.getAttribute("list");
  Room room = list.get(0);

  String str = request.getParameter("back");
  if(str != null) {
	UpdateAction updateAction = new UpdateAction();
	UpdateForm form = (UpdateForm)session.getAttribute("admin_search_UpdateForm");
	updateAction.delete(form);
  }

%>

<form action="/able/admin_search/update2.do" enctype="multipart/form-data" method="post">

<table border="1">
		<tr>	<th>	<td>登録状況</td>
					<td>編集</td>

		<tr>	<th>物件コード<td><%=room.getCode() %></td>
					<td></td>

		<tr>	<th>物件名<td><%=room.getName() %></td>
					<td><input type="text" name="name"></td>

		<tr>	<th>物件説明<td><%=room.getText() %> </td>
					<td><input type="text" name="text"></td>

		<tr>	<th>入居可能人数<td><%=room.getPeople() %></td>
					<td><select name="people">
							<option value="1" selected>１</option>
							<option value="2">２</option>
							<option value="3">３</option>
							<option value="4">４</option>
							<option value="5">５</option></SELECT></td>

		<tr>	<th>価格<td><%=room.getPrice() %></td>
					<td><input type="text" name="price"></td>

		<tr>	<th>ペット可否<td><%=room.isPet() %></td>
					<td><input type="checkbox" name="pet"></td>

		<tr>	<th>住所<td><%=room.getAddress() %></td>
					<td><input type="text" name="address"></td>

		<tr>	<th>写真<td><img style="-webkit-user-select: none; cursor: -webkit-zoom-in;" src="/able/<%=room.getPhoto() %>" width="644" height="483"> </td>
					<td><input type="file" name="photo" accept="image/jpeg"></td>

		<tr>	<th>最寄駅<td><%=room.getStation() %></td>
					<td><input type="text" name="station"></td>

	</tr>


</table>


<input type="hidden"  name="code" value="<%=room.getCode()%>">
<input type="submit" name="check" value="更新">
</form>
<form action="delete.do">
		<input type="hidden"  name="code" value="<%=room.getCode()%>">
		<input type="submit" name="back" value="戻る">
</form>
</body>
</html>

<!--
http://localhost:8080/able/admin_search/show.do
 -->