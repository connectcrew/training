package servlet;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Administer;
import model.LoginLogic;

@WebServlet("/adminTop")
public class AdminTop extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setAttribute("loginfalse", 0);
		HttpSession session = request.getSession();
		String adminName = (String)session.getAttribute("adminName");
		request.setAttribute("adminName", adminName);

		if (adminName != null) {
			RequestDispatcher dispatcher =
					request.getRequestDispatcher("/WEB-INF/administer/top.jsp");
			dispatcher.forward(request, response);
		} else {

		RequestDispatcher dispatcher =
				request.getRequestDispatcher("/WEB-INF/administer/login.jsp");
		dispatcher.forward(request, response);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String adminName;
		String adminId = request.getParameter("id");
		String pass  = request.getParameter("pass");


		Administer admin = new Administer(adminId, pass);

		LoginLogic loginLogic = new LoginLogic();
		adminName = loginLogic.execute(admin);

		if (adminName != null) {
			HttpSession administer = request.getSession();
			administer.setAttribute("adminName", adminName);
			RequestDispatcher dispatcher =
					request.getRequestDispatcher("/WEB-INF/administer/top.jsp");
			dispatcher.forward(request, response);
		} else {

		request.setAttribute("loginfalse", 1);
		RequestDispatcher dispatcher =
				request.getRequestDispatcher("/WEB-INF/administer/login.jsp");
		dispatcher.forward(request, response);
		}

	}

}
