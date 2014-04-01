<%@ page language="java" contentType="text/html; charset=Windows-31J"
    pageEncoding="Windows-31J"%>
<%@ page import="DB.*, java.util.*,admin_search.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=Windows-31J">
<title>success</title>
</head>
<body>

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

<%
List<Room> list = (List<Room>)request.getAttribute("list");
if(list.size() > 0) {
for (int i = 0; i < list.size(); i++) {
	Room room = list.get(i);
%>

<tr>
	<td><%=room.getCode() %></td>
	<td><a href="/able/admin_search/show.do?code=<%=room.getCode()%>" ><%=room.getName() %></a></td>
	<td><%=room.getText() %></td>
	<td><%=room.getPeople() %></td>
	<td><%=room.getPrice() %></td>
	<td><%=room.isPet() %></td>
	<td><%=room.getAddress() %></td>
	<td><%=room.getStation() %></td>

	<td><form action="check.do">
			<input type="hidden"  name="code" value="<%=room.getCode()%>">
			<input type="submit" name="check" value="削除">
		</form></td>

	<td><form action="update.do">
			<input type="hidden"  name="code" value="<%=room.getCode()%>">
			<input type="submit" name="confirm" value="編集">
		</form></td>
</tr>

	<%}
}else if(list.size() == 0) {
%>
検索結果は0件です。
<%} %>

</table>
<a href="/able/web/admin/room/room_menu.jsp">検索画面へ戻る</a>
</body>
</html>

<!-- http://localhost:8080/able/admin_search/search.do -->