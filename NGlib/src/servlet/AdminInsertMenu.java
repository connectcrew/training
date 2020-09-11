package servlet;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/adminInsertMenu")
public class AdminInsertMenu extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		String adminName = (String)session.getAttribute("adminName");

		if (adminName != null) {
			RequestDispatcher dispatcher =
					request.getRequestDispatcher("/WEB-INF/administer/insert_menu.jsp");
			dispatcher.forward(request, response);
		} else {

		RequestDispatcher dispatcher =
				request.getRequestDispatcher("/WEB-INF/administer/login.jsp");
		dispatcher.forward(request, response);
		}
	}
}
