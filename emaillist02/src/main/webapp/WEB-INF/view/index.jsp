<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ page import = "vo.GuestbookVO, java.util.ArrayList, dao.guest_dao" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>방명록</title>
</head>
<body>
	<form action="/guestbook01/jsp/add.jsp " method="post">
		<table border=1 width=500>
			<tr>
				<td>이름</td><td><input type="text" name="name"></td>
				<td>비밀번호</td><td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td colspan=4><textarea name="message" cols=60 rows=5></textarea></td>
			</tr>
			<tr>
				<td colspan=4 align=right><input type="submit" VALUE=" 확인 "></td>
			</tr>
		</table>
	</form>
	<br>
	<%
	ArrayList<GuestbookVO> volist = (ArrayList<GuestbookVO>)(new guest_dao().select());
	%>
	<table width=510 border=1>
	<% for(int i=0;i<volist.size();i++){ %>
		<tr>
			<td>[<%=i+1 %>]</td>
			<td><%=volist.get(i).getname() %></td>
			<td><%=volist.get(i).getReg_date() %></td>
			<td>
				<a href="/guestbook01/jsp/deleteform.jsp?no=<%=volist.get(i).getNo()%>">삭제</a>
			</td>
		</tr>
		<tr>
			<td colspan=4><%=volist.get(i).getmessage().replaceAll("\n", "<br>") %></td>
		</tr>
	<%} %>
	</table>
</body>
</html>