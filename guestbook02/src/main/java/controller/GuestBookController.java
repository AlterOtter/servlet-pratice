package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.guest_dao;
import vo.GuestbookVO;

/**
 * Servlet implementation class GuestBookController
 */
public class GuestBookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private guest_dao dao = new guest_dao();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.setCharacterEncoding("utf-8");
			String action =request.getParameter("action");
			
			if("delete".equals(action)) {
				int no =Integer.parseInt(request.getParameter("no"));
				request.setAttribute("no",no);
				request.getRequestDispatcher("/WEB-INF/views/deleteform.jsp").forward(request, response);
			}else {
				request.setAttribute("list", dao.select());
				request.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(request, response);
			}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String action =request.getParameter("action");
		
		if("join".equals(action)) {
			String name = (String)request.getParameter("name");
			String password = (String)request.getParameter("password");
			String message = (String)request.getParameter("message");
			if(dao.insert(GuestbookVO.Builder().name(name).password(password).message(message).build())) {
				response.sendRedirect("/guestbook02/book");
			}else {
				response.sendRedirect("/guestbook02/book");
			}
		}else if("delete".equals(action)) {
			int no = Integer.parseInt(request.getParameter("no"));
			String password =(String)request.getParameter("password");
			dao.delete(GuestbookVO.Builder().no(no).password(password).build());
			response.sendRedirect("/guestbook02/book");
		}else {
			request.setAttribute("list", dao.select());
			request.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(request, response);
		}
	}

}
