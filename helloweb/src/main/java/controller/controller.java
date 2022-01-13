package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import VO.EmaillistVO;
import dao.emaillist_dao;

public class controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private emaillist_dao dao = new emaillist_dao(); 
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<EmaillistVO> volist=dao.select();
		volist.forEach(x->{
			System.out.println(x.getEmail());
		});
		request.setAttribute("list", volist);
		request.getRequestDispatcher("/jsp/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String action=request.getParameter("action");
		switch(action) {
			case "join":
				String first_name = request.getParameter("first_name");
				String last_name = request.getParameter("last_name");
				String email = request.getParameter("email");
				EmaillistVO vo = EmaillistVO.Builder()
						.first_name(first_name)
						.last_name(last_name)
						.email(email)
						.build();
				if(dao.insert(vo)) {
					response.sendRedirect("/emaillist01/emaillist");
				}else {
					response.sendRedirect("/emaillist01/emaillist");
				}
				break;
			default: 
				break;
		}
	}

}
