package servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.AffilicationOffice;
import model.GetAOInfoLogic;

@WebServlet("/AffilicationOffice_information")
public class AffilicationOffice_information extends HttpServlet {
	private static final long serialVersionUID = 1L;




	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


		String searchId = request.getParameter("id");
		GetAOInfoLogic getAOInfoLogic = new GetAOInfoLogic();
		System.out.println("request AffilicationOffice_info id = " + searchId);

		List<AffilicationOffice> aoInfo = getAOInfoLogic.execute(searchId);
		request.setAttribute("aoInfo", aoInfo);

		/* フォワード */
		RequestDispatcher dispatcher =
				request.getRequestDispatcher("/WEB-INF/pages/affilication_office_info.jsp");
		dispatcher.forward(request, response);
	}


//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doGet(request, response);
//	}

}
