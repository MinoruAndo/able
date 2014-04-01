<%@ page language="java" contentType="text/html; charset=Windows-31J"
    pageEncoding="Windows-31J"%>
<%@ page import="DB.*, java.util.*;" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=Windows-31J">
<title>削除確認</title>
</head>
<body>
<%List<Room> list = (List<Room>)request.getAttribute("list");
  Room room = list.get(0);
%>

本当に削除してよろしいですか？

<table border="1">

	<tr>
		<th>物件コード</th>
		<th>物件名</th>
		<th>物件説明</th>
		<th>入居可能人数</th>
		<th>価格</th>
		<th>ペット可否</th>
		<th>住所</th>
		<th>最寄駅</th>
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
		<input type="submit" name="delete" value="削除">
</form>

<form action="delete.do">
		<input type="hidden"  name="code" value="<%=room.getCode()%>">
		<input type="submit" name="back" value="戻る">
</form>
</body>
</html>

<!--
WEB-INF内
 -->