<%@ page language="java" contentType="text/html; charset=Windows-31J"
    pageEncoding="Windows-31J"%>
<%@ page import="DB.*, java.util.*;" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- <meta http-equiv="Content-Type" content="text/html; charset=Windows-31J"> -->
<!-- <title>退会確認</title> -->
</head>
<body>
<h2>口コミ削除</h2>
<table border="1">
	<tr>
		<th>口コミコード</th>
		<th>最寄駅</th>
		<th>口コミ</th>
		<th>ログインID</th>
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
			<input type="submit" name="check" value="削除">
		</form></td>
</tr>

	<%}
}else if(list.size() == 0) {
%>
検索結果は0件です。<br>

<%} %>

</table>
<a href="/able/web/admin/kuchikomi/kuchikomi_menu.jsp">口コミ削除へ</a>
</body>
</html>
<!--

 -->