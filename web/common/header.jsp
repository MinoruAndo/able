<%@ page language="java" contentType="text/html; charset=Windows-31J" pageEncoding="Windows-31J"%>
<%@page import="javax.servlet.http.*" %>
<%-- <%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %> --%>
<%-- <%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %> --%>
<%-- <%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<script type="text/javascript">
function disp(){
	alert("���O�A�E�g���܂����B");
}
</script>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=Windows-31J">
<link rel="stylesheet" type="text/css" href="/able/web/css/mystyle.css">

<!-- <title>�������T����able</title> -->
</head>
<body>
<%--�摜 --%>
<div id="header">

<!-- <img src="/able/web/image/as_060.jpg" alt="able" width="780px"> -->

<%-- �f�o�b�O --%>
<%-- <p>�Z�b�V������loginid : ${loginid }</p> --%>
<%-- <p>UserInfoForm : ${userInfo.loginid }</p> --%>
<%-- <p>UserInfoForm�̃��[�� : ${userInfo.mail }</p> --%>
<%-- �f�o�b�O --%>


<%
String loginid = (String)session.getAttribute("loginid");
if (loginid != null) {
	%>
	�悤����${loginid }����<br/>
	<p class="right">
	<a href="/able/web/user/mypage.jsp">�}�C�y�[�W</a><br/>
	<p class="right">
	<a href="/able/user/UserLogout.do" onclick="disp()">���O�A�E�g</a><br/>
	<%
} else {
	%> �͂��߂܂��ăQ�X�g���� <br/><br/><br/><br/><br/><%
}	%>


</div>