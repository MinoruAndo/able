<%@ page language="java" contentType="text/html; charset=Windows-31J"
    pageEncoding="Windows-31J"%>
<%@ page import="DB.*, java.util.*, admin_search.*,org.apache.struts.upload.FormFile" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=Windows-31J">
<title>updatecheck</title>
</head>
<body>
<%
  //登録内容
  List<Room> list = (List<Room>)request.getAttribute("list");
  Room room = list.get(0);
  //更新内容
  UpdateForm updateForm = (UpdateForm)request.getAttribute("updateForm");

%>

この内容で更新してよろしいですか？

<form action="/able/admin_search/update2.do">

<table border="1">
		<tr>	<th>	<td>登録状況</td>
					<td>更新後</td>

		<tr>	<th>物件コード<td><%=room.getCode() %></td>
					<td></td>

		<tr>	<th>物件名<td><%=room.getName() %></td>
					<td><%=updateForm.getName() %></td>

		<tr>	<th>物件説明<td><%=room.getText() %> </td>
					<td><%=updateForm.getText() %></td>

		<tr>	<th>入居可能人数<td><%=room.getPeople() %></td>
					<td><%=updateForm.getPeople() %></td>

		<tr>	<th>価格<td><%=room.getPrice() %></td>
					<td><%=updateForm.getPrice() %></td>

		<tr>	<th>ペット可否<td><%=room.isPet() %></td>
					<td><%=updateForm.isPet() %></td>

		<tr>	<th>住所<td><%=room.getAddress() %></td>
					<td><%=updateForm.getAddress() %></td>

		<tr>	<th>写真<td><img style="-webkit-user-select: none; cursor: -webkit-zoom-in;" src="/able/<%=room.getPhoto() %>" width="644" height="483"></td>
					<td><img style="-webkit-user-select: none; cursor: -webkit-zoom-in;" src="/able/<%=updateForm.getPhoto() %>" width="644" height="483"></td>

		<tr>	<th>最寄駅<td><%=room.getStation() %></td>
					<td><%=updateForm.getStation() %></td>

	</tr>


</table>

<input type="hidden"  name="code" value="<%=room.getCode()%>">
<input type="hidden"  name="pet" value="<%=updateForm.isPet()%>">
<input type="submit" name="update" value="更新">
</form>
<form action="update.do">
		<input type="hidden"  name="code" value="<%=room.getCode()%>">
		<input type="submit" name="back" value="戻る">
		</form>

</body>
</html>

<!--
http://localhost:8080/able/admin_search/show.do
 -->