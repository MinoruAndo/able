<%@ page language="java" contentType="text/html; charset=Windows-31J"
    pageEncoding="Windows-31J"%>
<%@ page import="DB.*, java.util.*;" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=Windows-31J">
<title>�폜�m�F</title>
</head>
<body>
<%List<Room> list = (List<Room>)request.getAttribute("list");
  Room room = list.get(0);
%>

�{���ɍ폜���Ă�낵���ł����H

<table border="1">

	<tr>
		<th>�����R�[�h</th>
		<th>������</th>
		<th>��������</th>
		<th>�����\�l��</th>
		<th>���i</th>
		<th>�y�b�g��</th>
		<th>�Z��</th>
		<th>�Ŋ�w</th>
	</tr>

	<tr>
		<th><%=room.getCode() %></th>
		<th><%=room.getName() %></th>
		<th><%=room.getText() %></th>
		<th><%=room.getPeople() %></th>
		<th><%=room.getPrice() %></th>
		<th><%=room.isPet() %></th>
		<th><%=room.getAddress() %></th>
		<th><%=room.getStation() %></th>
	</tr>

</table>

<form action="delete.do">
		<input type="hidden"  name="code" value="<%=room.getCode()%>">
		<input type="submit" name="delete" value="�폜">
</form>

<form action="delete.do">
		<input type="hidden"  name="code" value="<%=room.getCode()%>">
		<input type="submit" name="back" value="�߂�">
</form>
</body>
</html>

<!--
WEB-INF��
 -->