package servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Company;
import model.GetCoInfoLogic;

@WebServlet("/company_information")
public class Company_information extends HttpServlet {
	private static final long serialVersionUID = 1L;




	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


		String searchId = request.getParameter("id");
		GetCoInfoLogic getCoInfoLogic = new GetCoInfoLogic();
		System.out.println("request company_info id = " + searchId);

		List<Company> coInfo = getCoInfoLogic.execute(searchId);
		request.setAttribute("coInfo", coInfo);

		/* フォワード */
		RequestDispatcher dispatcher =
				request.getRequestDispatcher("/WEB-INF/pages/company_info.jsp");
		dispatcher.forward(request, response);
	}


//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doGet(request, response);
//	}

}
