<%@ page language="java" contentType="text/html; charset=Windows-31J"
    pageEncoding="Windows-31J"%>
<%@page import="admin_search.SearchForm,org.apache.struts.upload.FormFile"%>

<%@ page import="DB.*, java.util.*;" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=Windows-31J">
<title>物件詳細</title>
</head>
<body>
<% List<Room> list = (List<Room>)request.getAttribute("list");
Room room = list.get(0);
%>

<!-- // 物件詳細 -->
<!-- <table border="1"> -->
<!-- 		<tr>	<th>	<td>物件詳細</td> -->
<%-- 		<tr>	<th>物件コード<td><%=room.getCode() %></td> --%>
<%-- 		<tr>	<th>物件名<td><%=room.getName() %></td> --%>
<%-- 		<tr>	<th>物件説明<td><%=room.getText() %> </td> --%>
<%-- 		<tr>	<th>入居可能人数<td><%=room.getPeople() %></td> --%>
<%-- 		<tr>	<th>価格<td><%=room.getPrice() %></td> --%>
<%-- 		<tr>	<th>ペット可否<td><%=room.isPet() %></td> --%>
<%-- 		<tr>	<th>住所<td><%=room.getAddress() %></td> --%>
<%-- 		<tr>	<th>写真<td><img src="<%=room.getPhoto() %>" alt="画像なし"><%=room.getPhoto() %></td> --%>
<%-- 		<tr>	<th>最寄駅<td><%=room.getStation() %></td> --%>
<!-- 	</tr> -->
<!-- </table> -->
<h2>物件詳細</h2>
<table border="1" cellpadding="" cellspacing="" >
<tr>
	<td>

<table border="1" cellpadding="20" cellspacing="1">
		<tr>	<th>	<td>登録状況</td>
		<tr>	<th>物件コード<td><%=room.getCode() %></td>
		<tr>	<th>物件名<td><%=room.getName() %></td>
		<tr>	<th>物件説明<td><%=room.getText() %> </td>
		<tr>	<th>入居可能人数<td><%=room.getPeople() %></td>
		<tr>	<th>価格<td><%=room.getPrice() %></td>
		<tr>	<th>ペット可否<td><%=room.isPet() ? "可" : "不可"%></td>
		<tr>	<th>住所<td><%=room.getAddress() %></td>
	<!--  	<tr>	<th>写真<td><img src="<%=room.getPhoto() %>" alt="↓画像なし"><%=room.getPhoto() %></td>	-->
		<tr>	<th>最寄駅<td><%=room.getStation() %></td>
	</tr>
</table>

</td>
<td>

<table border="0">
登録写真：


<%
	//nullだったらなにも表示させない
SearchForm searchform = (SearchForm)session.getAttribute("admin_search_SearchAction");
// String formfile = (String)searchform.getPhoto();
if (room.getPhoto() == null || "".equals(room.getPhoto())) {
%>ありません<br>
<%}else{%>
<tr>
<td>
<br>
	<img style="-webkit-user-select: none; cursor: -webkit-zoom-in;" src="/able/<%=room.getPhoto() %>" width="644" height="483">


<%}%>
</td>

　　</tr>
　　</table>



　</td>
</tr>
</table>

<!-- 口コミ一覧 -->
<h2>口コミ一覧</h2>

<%	List<Kuchikomi> kuchikomilist = (List<Kuchikomi>)request.getAttribute("kuchikomilist");
if(kuchikomilist.size() > 0) {

	%>
	<table border="1" >
		<tr>
			<th>最寄駅</th>
			<th>口コミ</th>
			<th>ログインID</th>
			<th>addNo</th>
		</tr>

	<%for (int i = 0; i < kuchikomilist.size(); i++) {
		Kuchikomi kuchikomi = kuchikomilist.get(i);
%>

		<tr>
			<td><%=kuchikomi.getStation() %></td>
			<td><%=kuchikomi.getKuchikomi() %></td>
			<td><%=kuchikomi.getLoginid() %></td>
			<td><%=kuchikomi.getAddNo() %></td>
		</tr>

	<% } %>
	</table>
<%
} else {%><p>検索結果は0件です。</p><%} %>

<br>
<a href="/able/web/user/kuchikomicreate.jsp">口コミ登録</a><br/>
<a href="/able/user/search.do">検索一覧へ戻る</a>
</body>
</html>

<!--
WEB-INF内
-->