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
		<tr>	<th>	<td>�o�^��</td>
					<td>�ҏW</td>

		<tr>	<th>�����R�[�h<td><%=room.getCode() %></td>
					<td></td>

		<tr>	<th>������<td><%=room.getName() %></td>
					<td><input type="text" name="name"></td>

		<tr>	<th>��������<td><%=room.getText() %> </td>
					<td><input type="text" name="text"></td>

		<tr>	<th>�����\�l��<td><%=room.getPeople() %></td>
					<td><select name="people">
							<option value="1" selected>�P</option>
							<option value="2">�Q</option>
							<option value="3">�R</option>
							<option value="4">�S</option>
							<option value="5">�T</option></SELECT></td>

		<tr>	<th>���i<td><%=room.getPrice() %></td>
					<td><input type="text" name="price"></td>

		<tr>	<th>�y�b�g��<td><%=room.isPet() %></td>
					<td><input type="checkbox" name="pet"></td>

		<tr>	<th>�Z��<td><%=room.getAddress() %></td>
					<td><input type="text" name="address"></td>

		<tr>	<th>�ʐ^<td><img style="-webkit-user-select: none; cursor: -webkit-zoom-in;" src="/able/<%=room.getPhoto() %>" width="644" height="483"> </td>
					<td><input type="file" name="photo" accept="image/jpeg"></td>

		<tr>	<th>�Ŋ�w<td><%=room.getStation() %></td>
					<td><input type="text" name="station"></td>

	</tr>


</table>


<input type="hidden"  name="code" value="<%=room.getCode()%>">
<input type="submit" name="check" value="�X�V">
</form>
<form action="delete.do">
		<input type="hidden"  name="code" value="<%=room.getCode()%>">
		<input type="submit" name="back" value="�߂�">
</form>
</body>
</html>

<!--
http://localhost:8080/able/admin_search/show.do
 -->