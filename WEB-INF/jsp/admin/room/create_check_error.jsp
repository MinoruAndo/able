<%@ page language="java" contentType="text/html; charset=Windows-31J"
    pageEncoding="Windows-31J"%>
<%@ page import="admin_search.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=Windows-31J">
<title>create</title>
</head>
<body>
�摜�t�@�C�����d�����Ă��܂�

<%--�ҏW�{�^���������ꂽ���x�ʐ^������--%>
<%
	RoomCreate roomcreate = new RoomCreate();
RoomCreateForm form = (RoomCreateForm)session.getAttribute("admin_search_RoomCreate");

String str = request.getParameter("pic_del");

if(str != null && !("".equals(str))) {
	roomcreate.delete(form);
}
%>

<br>

<form action="../admin_search/roomcreate.do" method="post"  enctype="multipart/form-data">�󂫕����o�^<br>
�����R�[�h
<input type="text" name="code" value="${admin_search_RoomCreate.code}"><br>
������
<input type="text" name="name" value="${admin_search_RoomCreate.name}"><br>
��������
<input type="text" name="text" value="${admin_search_RoomCreate.text}"><br>

�����\�l��
<select name="people">
	<option value="1" selected>�P</option>
	<option value="2">�Q</option>
	<option value="3">�R</option>
	<option value="4">�S</option>
	<option value="5">�T</option>
</SELECT>�l�ȏ�<br>

�ƒ�<input type="text" name="price" value="${admin_search_RoomCreate.price}">�~<br>

 �y�b�g�@�F<input type="checkbox" name="pet" ${admin_search_RoomCreate.pet ? "checked" : ""}>
${admin_search_RoomCreate.pet ? "checked" : ""}
<br>
�Z��
		<input type="text" name="address" value="${admin_search_RoomCreate.address}"><br>

<%-- �ʐ^ �F<input type="text" name="photo" value="${admin_search_RoomCreate.photo}"><br> --%>

�Ŋ�w
	<input type="text" name="station" value="${admin_search_RoomCreate.station}">�w<br>

<br>
�ʐ^ �F
<!-- <form action="../admin_search/pictureUploadAndShow" method="post" enctype="multipart/form-data"> -->
	<input type="file" name="photo" accept="image/jpeg"><br>
<!-- 	<input type="submit" value="�A�b�v���[�h"> -->
<!-- </form> -->
<br></br>
	<input type="submit" value="�o�^">

</form>
<form action="/able/web/admin/room/room_menu.jsp">
<input type="submit" value="�߂�">
</body>
</html>

<!--
http://localhost:8080/able/web/admin/room/room_create.jsp
 -->
