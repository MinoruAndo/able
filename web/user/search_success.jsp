<%@ page language="java" contentType="text/html; charset=Windows-31J"
    pageEncoding="Windows-31J"%>
<%@ page import="DB.*, java.util.*;" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=Windows-31J">
<title>¨õÊ</title>
</head>
<body>
<h2>¨õÊ</h2>
<table border="1">
	<tr>
		<th>¨R[h</th>
		<th>¨¼</th>
		<th>¨à¾</th>
		<th>üÂ\l</th>
		<th>¿i</th>
		<th>ybgÂÛ</th>
		<th>Z</th>
		<th>Åñw</th>
	</tr>

<%	List<Room> list = (List<Room>)request.getAttribute("list");
if(list.size() > 0) {
for (int i = 0; i < list.size(); i++) {
	Room room = list.get(i);
%>

<tr>
	<td><%=room.getCode() %></td>
<%-- 	<td><a href="/able/admin_search/show.do?code=<%=room.getCode()%>" ><%=room.getName() %></a></td> --%>
	<td><a href="/able/user/show.do?code=<%=room.getCode()%>" ><%=room.getName() %></a></td>
	<td><%=room.getText() %></td>
	<td><%=room.getPeople() %></td>
	<td><%=room.getPrice() %></td>
	<td><%=room.isPet() ? "Â" : "sÂ"%></td>
	<td><%=room.getAddress() %></td>
	<td><%=room.getStation() %></td>

<%-- 	<td><form action="check.do">
			<input type="hidden"  name="code" value="<%=room.getCode()%>">
			<input type="submit" name="check" value="í">
		</form></td> --%>

<%-- 	<td><form action="update.do">
			<input type="hidden"  name="code" value="<%=room.getCode()%>">
			<input type="submit" name=confirm value="ÒW">
		</form></td> --%>
</tr>

	<%}
}else if(list.size() == 0) {
%>
õÊÍ0Å·B
<%} %>

</table>
<a href="/able/web/user/usertop.jsp">õæÊÖßé</a>
</body>
</html>

<!--User¤Ìõy[W -->