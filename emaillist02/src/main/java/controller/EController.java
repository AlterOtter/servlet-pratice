package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.guest_dao;
import vo.GuestbookVO;

public class EController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		System.out.println(request.getParameter("action"));
		String action = request.getParameter("action");
		if("add".equals(action)){
			request.getRequestDispatcher("/WEB-INF/view/index.jsp").forward(request, response);
		}else if("delete".equals(action)) {
			request.getRequestDispatcher("/WEB-INF/view/index.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("/WEB-INF/view/index.jsp").forward(request, response);
		}
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String action = req.getParameter("action");
		if("add".equals(action)) {
			String name= (String)req.getParameter("name");
			String password= (String)req.getParameter("password");
			String message = (String)req.getParameter("message");
			
			GuestbookVO vo = GuestbookVO.Builder().name(name).password(password).message(message).build();
			new guest_dao().insert(vo);
			resp.sendRedirect("emaillist02/WEB-INF/view/index.jsp");
		}else if("delete".equals(action)) {
			int no = Integer.valueOf(req.getParameter("no"));
			String password = req.getParameter("password");
			new guest_dao().delete(GuestbookVO.Builder().no(no).password(password).build());
			
			
			resp.sendRedirect("/guestbook01/jsp/index.jsp");
		}
		
		
	}


}
