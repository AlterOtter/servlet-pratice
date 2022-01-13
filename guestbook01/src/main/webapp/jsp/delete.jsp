<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ page import = "VO.GuestbookVO, java.util.ArrayList, dao.guest_dao" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	request.setCharacterEncoding("utf-8");
	int no = Integer.valueOf(request.getParameter("no"));
	String password = request.getParameter("password");
	new guest_dao().delete(GuestbookVO.Builder().no(no).password(password).build());
	
	
	response.sendRedirect("/guestbook01/jsp/index.jsp");
	
	%>
</body>
</html>