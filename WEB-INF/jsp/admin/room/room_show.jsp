<%@ page language="java" contentType="text/html; charset=Windows-31J"
    pageEncoding="Windows-31J"%>
<%@page import="admin_search.SearchForm,org.apache.struts.upload.FormFile"%>
<%@ page import="DB.*, java.util.*;" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=Windows-31J">
<title>show</title>
</head>
<body>
<%
//�X�V�����������ゾ������
if(request.getParameter("update") != null) {
	 List<Room> list = (List<Room>)request.getAttribute("show");
	  Room room = list.get(0);
%>
�ȉ��̓��e�ɍX�V���܂���

	  <table border="1">
		<tr>	<th>	<td>�o�^��</td>
		<tr>	<th>�����R�[�h<td><%=room.getCode() %></td>
		<tr>	<th>������<td><%=room.getName() %></td>
		<tr>	<th>��������<td><%=room.getText() %> </td>
		<tr>	<th>�����\�l��<td><%=room.getPeople() %></td>
		<tr>	<th>���i<td><%=room.getPrice() %></td>
		<tr>	<th>�y�b�g��<td><%=room.isPet() %></td>
		<tr>	<th>�Z��<td><%=room.getAddress() %></td>
		<tr>	<th>�ʐ^<td><img style="-webkit-user-select: none; cursor: -webkit-zoom-in;" src="/able/<%=room.getPhoto() %>" width="644" height="483">
</td>
		<tr>	<th>�Ŋ�w<td><%=room.getStation() %></td>
	</tr>
<!-- <img  src="/able/Hydrangeas.jpg" width="644" height="483"> -->


</table>
<%
//�������ʂ��炾������
}else {

  List<Room> list = (List<Room>)request.getAttribute("list");
  Room room = list.get(0);
%>
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
		<tr>	<th>�y�b�g��<td><%=room.isPet() %></td>
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


<%}}%>
</td>

�@�@</tr>
�@�@</table>



�@</td>
</tr>
</table>

<br>
<a href="/able/web/admin/room/room_menu.jsp">�󂫕����Ǘ����j���[</a>

</body>
</html>

<!--
http://localhost:8080/able/admin_search/show.do
 -->