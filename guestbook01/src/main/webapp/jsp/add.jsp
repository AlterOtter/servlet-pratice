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
	String name= (String)request.getParameter("name");
	String password= (String)request.getParameter("password");
	String message = (String)request.getParameter("message");
	
	GuestbookVO vo = GuestbookVO.Builder().name(name).password(password).message(message).build();
	new guest_dao().insert(vo);
	response.sendRedirect("/guestbook01/jsp/index.jsp");
	
	%>
</body>
</html>