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
  //�o�^���e
  List<Room> list = (List<Room>)request.getAttribute("list");
  Room room = list.get(0);
  //�X�V���e
  UpdateForm updateForm = (UpdateForm)request.getAttribute("updateForm");

%>

���̓��e�ōX�V���Ă�낵���ł����H

<form action="/able/admin_search/update2.do">

<table border="1">
		<tr>	<th>	<td>�o�^��</td>
					<td>�X�V��</td>

		<tr>	<th>�����R�[�h<td><%=room.getCode() %></td>
					<td></td>

		<tr>	<th>������<td><%=room.getName() %></td>
					<td><%=updateForm.getName() %></td>

		<tr>	<th>��������<td><%=room.getText() %> </td>
					<td><%=updateForm.getText() %></td>

		<tr>	<th>�����\�l��<td><%=room.getPeople() %></td>
					<td><%=updateForm.getPeople() %></td>

		<tr>	<th>���i<td><%=room.getPrice() %></td>
					<td><%=updateForm.getPrice() %></td>

		<tr>	<th>�y�b�g��<td><%=room.isPet() %></td>
					<td><%=updateForm.isPet() %></td>

		<tr>	<th>�Z��<td><%=room.getAddress() %></td>
					<td><%=updateForm.getAddress() %></td>

		<tr>	<th>�ʐ^<td><img style="-webkit-user-select: none; cursor: -webkit-zoom-in;" src="/able/<%=room.getPhoto() %>" width="644" height="483"></td>
					<td><img style="-webkit-user-select: none; cursor: -webkit-zoom-in;" src="/able/<%=updateForm.getPhoto() %>" width="644" height="483"></td>

		<tr>	<th>�Ŋ�w<td><%=room.getStation() %></td>
					<td><%=updateForm.getStation() %></td>

	</tr>


</table>

<input type="hidden"  name="code" value="<%=room.getCode()%>">
<input type="hidden"  name="pet" value="<%=updateForm.isPet()%>">
<input type="submit" name="update" value="�X�V">
</form>
<form action="update.do">
		<input type="hidden"  name="code" value="<%=room.getCode()%>">
		<input type="submit" name="back" value="�߂�">
		</form>

</body>
</html>

<!--
http://localhost:8080/able/admin_search/show.do
 -->