<%@ page language="java" contentType="text/html; charset=Windows-31J"
    pageEncoding="Windows-31J"%>
<%@page import="admin_search.SearchForm,org.apache.struts.upload.FormFile"%>

<%@ page import="DB.*, java.util.*;" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=Windows-31J">
<title>�����ڍ�</title>
</head>
<body>
<% List<Room> list = (List<Room>)request.getAttribute("list");
Room room = list.get(0);
%>

<!-- // �����ڍ� -->
<!-- <table border="1"> -->
<!-- 		<tr>	<th>	<td>�����ڍ�</td> -->
<%-- 		<tr>	<th>�����R�[�h<td><%=room.getCode() %></td> --%>
<%-- 		<tr>	<th>������<td><%=room.getName() %></td> --%>
<%-- 		<tr>	<th>��������<td><%=room.getText() %> </td> --%>
<%-- 		<tr>	<th>�����\�l��<td><%=room.getPeople() %></td> --%>
<%-- 		<tr>	<th>���i<td><%=room.getPrice() %></td> --%>
<%-- 		<tr>	<th>�y�b�g��<td><%=room.isPet() %></td> --%>
<%-- 		<tr>	<th>�Z��<td><%=room.getAddress() %></td> --%>
<%-- 		<tr>	<th>�ʐ^<td><img src="<%=room.getPhoto() %>" alt="�摜�Ȃ�"><%=room.getPhoto() %></td> --%>
<%-- 		<tr>	<th>�Ŋ�w<td><%=room.getStation() %></td> --%>
<!-- 	</tr> -->
<!-- </table> -->
<h2>�����ڍ�</h2>
<table border="1" cellpadding="" cellspacing="" >
<tr>
	<td>

<table border="1" cellpadding="20" cellspacing="1">
		<tr>	<th>	<td>�o�^��</td>
		<tr>	<th>�����R�[�h<td><%=room.getCode() %></td>
		<tr>	<th>������<td><%=room.getName() %></td>
		<tr>	<th>��������<td><%=room.getText() %> </td>
		<tr>	<th>�����\�l��<td><%=room.getPeople() %></td>
		<tr>	<th>���i<td><%=room.getPrice() %></td>
		<tr>	<th>�y�b�g��<td><%=room.isPet() ? "��" : "�s��"%></td>
		<tr>	<th>�Z��<td><%=room.getAddress() %></td>
	<!--  	<tr>	<th>�ʐ^<td><img src="<%=room.getPhoto() %>" alt="���摜�Ȃ�"><%=room.getPhoto() %></td>	-->
		<tr>	<th>�Ŋ�w<td><%=room.getStation() %></td>
	</tr>
</table>

</td>
<td>

<table border="0">
�o�^�ʐ^�F


<%
	//null��������Ȃɂ��\�������Ȃ�
SearchForm searchform = (SearchForm)session.getAttribute("admin_search_SearchAction");
// String formfile = (String)searchform.getPhoto();
if (room.getPhoto() == null || "".equals(room.getPhoto())) {
%>����܂���<br>
<%}else{%>
<tr>
<td>
<br>
	<img style="-webkit-user-select: none; cursor: -webkit-zoom-in;" src="/able/<%=room.getPhoto() %>" width="644" height="483">


<%}%>
</td>

�@�@</tr>
�@�@</table>



�@</td>
</tr>
</table>

<!-- ���R�~�ꗗ -->
<h2>���R�~�ꗗ</h2>

<%	List<Kuchikomi> kuchikomilist = (List<Kuchikomi>)request.getAttribute("kuchikomilist");
if(kuchikomilist.size() > 0) {

	%>
	<table border="1" >
		<tr>
			<th>�Ŋ�w</th>
			<th>���R�~</th>
			<th>���O�C��ID</th>
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
} else {%><p>�������ʂ�0���ł��B</p><%} %>

<br>
<a href="/able/web/user/kuchikomicreate.jsp">���R�~�o�^</a><br/>
<a href="/able/user/search.do">�����ꗗ�֖߂�</a>
</body>
</html>

<!--
WEB-INF��
-->