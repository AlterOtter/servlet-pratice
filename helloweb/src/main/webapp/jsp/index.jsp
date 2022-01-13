<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import = "VO.EmaillistVO, java.util.ArrayList, dao.emaillist_dao" %>    
<!DOCTYPE html>
<html>
<head>
<style>
    * {
    	font-family: "Poor Story"   
    }
	td{
		border-bottom : 2px dotted green;
		padding-left : 20px;
	}
	tr:hover{ 
		background-color : pink;	
		font-weight : bold;
	}
	td:nth-child(2){
		width : 300px;
	}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	ArrayList<EmaillistVO> volist = (ArrayList<EmaillistVO>)(new emaillist_dao().select());
%>
	<h1>메일 리스트에 가입되었습니다.</h1>
	<p>입력한 정보 내역입니다.</p>
	<!-- 메일정보 리스트 -->
	<table>
	<th>First Name</th>
	<th>Last Name</th>
	<th>Email</th>
<% for(EmaillistVO vo : volist){%>
			<tr>
				<td><%=vo.getFirst_name()%></td>
				<td><%=vo.getLast_name() %></td>
				<td><%=vo.getEmail() %></td>			
			</tr>
<%	} %>
	</table>
	<br>
	<p>
		<a href="/emaillist01/jsp/form.jsp">추가메일 등록</a>
	</p>
	<br>
</body>
</html>