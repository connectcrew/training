package servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Brand;
import model.GetBrInfoLogic;

@WebServlet("/brand_information")
public class Brand_information extends HttpServlet {
	private static final long serialVersionUID = 1L;




	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


		String searchId = request.getParameter("id");
		GetBrInfoLogic getBrInfoLogic = new GetBrInfoLogic();
		System.out.println("request brand_info id = " + searchId);

		List<Brand> brInfo = getBrInfoLogic.execute(searchId);
		request.setAttribute("brInfo", brInfo);

		/* フォワード */
		RequestDispatcher dispatcher =
				request.getRequestDispatcher("/WEB-INF/pages/brand_info.jsp");
		dispatcher.forward(request, response);
	}


//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doGet(request, response);
//	}

}
