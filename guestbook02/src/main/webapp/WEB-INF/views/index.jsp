<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
  <%@ page import = "vo.GuestbookVO, java.util.ArrayList, dao.guest_dao" %> 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>방명록</title>
</head>
<body>
<% 
	ArrayList<GuestbookVO> volist = (ArrayList<GuestbookVO>)request.getAttribute("list");
%>
	<form action="/guestbook02/book" method="post">
		<input type="hidden" name="action" value="join">
		<table border=1 width=500>
			<tr>
				<td>이름</td><td><input type="text" name="name"></td>
				<td>비밀번호</td><td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td colspan=4><textarea name="message" cols=60 rows=5></textarea></td>
			</tr>
			<tr>
				<td colspan=4 align=right><input type="submit" VALUE="등록"></td>
			</tr>
		</table>
	</form>
	
	<%
		int count = volist.size();
		int index = 0;
		for(GuestbookVO vo : volist){
	%>
		<br>
		<table width=510 border=1>
			<tr>
				<td>[<%=count-index++ %>]</td>
				<td><%=vo.getname() %></td>
				<td><%=vo.getReg_date() %></td>
				<td><a href="/guestbook02/book?action=delete&no=<%=vo.getNo() %>">삭제</a></td>
			</tr>
			<tr>
				<td colspan=4><%=vo.getmessage().replaceAll("\n", "<br/>") %></td>
			</tr>
		</table>
	<%
		}
	%>
</body>
</html>