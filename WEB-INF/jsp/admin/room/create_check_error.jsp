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
画像ファイルが重複しています

<%--編集ボタンが押されたら一度写真を消す--%>
<%
	RoomCreate roomcreate = new RoomCreate();
RoomCreateForm form = (RoomCreateForm)session.getAttribute("admin_search_RoomCreate");

String str = request.getParameter("pic_del");

if(str != null && !("".equals(str))) {
	roomcreate.delete(form);
}
%>

<br>

<form action="../admin_search/roomcreate.do" method="post"  enctype="multipart/form-data">空き部屋登録<br>
物件コード
<input type="text" name="code" value="${admin_search_RoomCreate.code}"><br>
物件名
<input type="text" name="name" value="${admin_search_RoomCreate.name}"><br>
物件説明
<input type="text" name="text" value="${admin_search_RoomCreate.text}"><br>

入居可能人数
<select name="people">
	<option value="1" selected>１</option>
	<option value="2">２</option>
	<option value="3">３</option>
	<option value="4">４</option>
	<option value="5">５</option>
</SELECT>人以上<br>

家賃<input type="text" name="price" value="${admin_search_RoomCreate.price}">円<br>

 ペット　可：<input type="checkbox" name="pet" ${admin_search_RoomCreate.pet ? "checked" : ""}>
${admin_search_RoomCreate.pet ? "checked" : ""}
<br>
住所
		<input type="text" name="address" value="${admin_search_RoomCreate.address}"><br>

<%-- 写真 ：<input type="text" name="photo" value="${admin_search_RoomCreate.photo}"><br> --%>

最寄駅
	<input type="text" name="station" value="${admin_search_RoomCreate.station}">駅<br>

<br>
写真 ：
<!-- <form action="../admin_search/pictureUploadAndShow" method="post" enctype="multipart/form-data"> -->
	<input type="file" name="photo" accept="image/jpeg"><br>
<!-- 	<input type="submit" value="アップロード"> -->
<!-- </form> -->
<br></br>
	<input type="submit" value="登録">

</form>
<form action="/able/web/admin/room/room_menu.jsp">
<input type="submit" value="戻る">
</body>
</html>

<!--
http://localhost:8080/able/web/admin/room/room_create.jsp
 -->
