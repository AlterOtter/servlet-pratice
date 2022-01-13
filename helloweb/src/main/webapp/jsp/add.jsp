<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import = "VO.EmaillistVO, java.util.ArrayList, dao.emaillist_dao" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
		String first_name = (String)request.getParameter("first_name");
		String last_name = (String)request.getParameter("last_name");
		String email = (String)request.getParameter("email");
		EmaillistVO vo = EmaillistVO.Builder().first_name(first_name).last_name(last_name).email(email).build();
		
		new emaillist_dao().insert(vo);
		
		response.sendRedirect("/emaillist01/emaillist");
	%>
	<h1>잘 들어갔습니다.</h1>
</body>
</html>