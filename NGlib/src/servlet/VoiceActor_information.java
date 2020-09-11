package servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.VoiceActor;
import model.GetVAInfoLogic;

@WebServlet("/VoiceActor_information")
public class VoiceActor_information extends HttpServlet {
	private static final long serialVersionUID = 1L;




	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


		String searchId = request.getParameter("id");
		GetVAInfoLogic getVAInfoLogic = new GetVAInfoLogic();
		System.out.println("request VoiceActor_info id = " + searchId);

		List<VoiceActor> vaInfo = getVAInfoLogic.execute(searchId);
		request.setAttribute("vaInfo", vaInfo);

		/* フォワード */
		RequestDispatcher dispatcher =
				request.getRequestDispatcher("/WEB-INF/pages/voice_actor_info.jsp");
		dispatcher.forward(request, response);
	}


//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doGet(request, response);
//	}

}
