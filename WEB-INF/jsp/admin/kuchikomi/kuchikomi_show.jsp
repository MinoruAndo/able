<%@ page language="java" contentType="text/html; charset=Windows-31J"
    pageEncoding="Windows-31J"%>
<%@ page import="DB.*, java.util.*;" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- <meta http-equiv="Content-Type" content="text/html; charset=Windows-31J"> -->
<!-- <title>�މ�m�F</title> -->
</head>
<body>
<h2>���R�~�폜</h2>
<table border="1">
	<tr>
		<th>���R�~�R�[�h</th>
		<th>�Ŋ�w</th>
		<th>���R�~</th>
		<th>���O�C��ID</th>
	</tr>

<%	List<Kuchikomi> list = (List<Kuchikomi>)session.getAttribute("result");
if(list.size() > 0) {
	for (int i = 0; i < list.size(); i++) {
		Kuchikomi kuchikomi = list.get(i);
%>

<tr>
	<td><%=kuchikomi.getAddNo() %></td>
	<td><%=kuchikomi.getStation() %></td>
	<td><%=kuchikomi.getKuchikomi() %></td>
	<td><%=kuchikomi.getLoginid() %></td>

	<td><form action="kuchikomiconfirmation.do">
			<input type="hidden"  name="code" value="<%= i %>">
			<input type="submit" name="check" value="�폜">
		</form></td>
</tr>

	<%}
}else if(list.size() == 0) {
%>
�������ʂ�0���ł��B<br>

<%} %>

</table>
<a href="/able/web/admin/kuchikomi/kuchikomi_menu.jsp">���R�~�폜��</a>
</body>
</html>
<!--

 -->