<%@ page language="java" contentType="text/html; charset=Windows-31J"
    pageEncoding="Windows-31J"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=Windows-31J">
<title>menu</title>
</head>
<body>

<form action="/able/admin_search/search.do" method="post">
�󂫕�������<br>

	�����R�[�h
	<input type="text" name="code"><br>

	������
	<input type="text" name="name"><br>
	��������
	<input type="text" name="text"><br>

	�����\�l��
	<select name="people">
		<option value="1" selected>�P</option>
		<option value="2">�Q</option>
		<option value="3">�R</option>
		<option value="4">�S</option>
		<option value="5">�T</option>
	</SELECT>�l�ȏ�<br>

	�ƒ�<input type="text" name="pricemin">�~�`
		<input type="text" name="pricemax">�~<br>

	�y�b�g�@�F<input type="checkbox" name="pet" ${admin_search_RoomCreate.pet ? "checked" : ""}>
${admin_search_RoomCreate.pet ? "checked" : ""}<br>

	�Z��
		<input type="text" name="address"><br>

	�Ŋ�w
		<input type="text" name="station">�w<br>

	<br>
		<input type="submit" name="search" value="����">

	<br><br>
<a href="room_create.jsp">�󂫕����̐V�K�o�^�͂������</a><br>
</form>


</body>
</html>

<!--
http://localhost:8080/able/web/admin/room/room_menu.jsp
 -->
