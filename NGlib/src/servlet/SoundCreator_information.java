package servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Creator;
import model.GetSCInfoLogic;

@WebServlet("/SoundCreator_information")
public class SoundCreator_information extends HttpServlet {
	private static final long serialVersionUID = 1L;




	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


		String searchId = request.getParameter("id");
		GetSCInfoLogic getSCInfoLogic = new GetSCInfoLogic();
		System.out.println("request sound_creator_info id = " + searchId);

		List<Creator> scInfo = getSCInfoLogic.execute(searchId);
		request.setAttribute("scInfo", scInfo);

		/* フォワード */
		RequestDispatcher dispatcher =
				request.getRequestDispatcher("/WEB-INF/pages/sound_creator_info.jsp");
		dispatcher.forward(request, response);
	}


//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doGet(request, response);
//	}

}
