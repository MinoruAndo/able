<%@ page language="java" contentType="text/html; charset=Windows-31J"
    pageEncoding="Windows-31J"%>
 <%@ page import="DB.*, java.util.*,admin_kuchikomi.*;" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

</head>
<body>
<h2>口コミ削除</h2>
<form action="/able/admin_kuchikomi/kuchikomidelete.do" method="post">
口コミコード : ${result[num].addNo}
最寄駅 : ${result[num].station}
口コミ : ${result[num].kuchikomi}
ログインID : ${result[num].loginid}<br>
<input type="hidden"  name="code" value="${result[num].addNo}">
<input type="submit" value="はい">
</form>
<form action="/able/web/admin/kuchikomi/kuchikomi_menu.jsp" method="post">
<input type="submit" value="いいえ">
</form>

</body>
</html>
<!--

 -->