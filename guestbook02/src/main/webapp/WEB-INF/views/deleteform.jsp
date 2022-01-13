<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="/guestbook02/book">
		<input type="hidden" name="action" value="delete">
		<input type='hidden' name='no' value='<%=request.getAttribute("no") %>'>
		<table>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="password"></td>
				<td><input type="submit" value="확인"></td>
			</tr>
		</table>
		<br>
		<a href="<%=request.getContextPath() %>/book">메인으로 돌아가기</a>
	</form>
</body>
</html>