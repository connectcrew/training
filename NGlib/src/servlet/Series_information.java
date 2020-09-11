package servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Series;
import model.GetSeriesInfoLogic;

@WebServlet("/series_information")
public class Series_information extends HttpServlet {
	private static final long serialVersionUID = 1L;




	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


		String searchId = request.getParameter("id");
		GetSeriesInfoLogic getSeriesInfoLogic = new GetSeriesInfoLogic();
		System.out.println("request series_info id = " + searchId);

		List<Series> seriesInfo = getSeriesInfoLogic.execute(searchId);
		request.setAttribute("seriesInfo", seriesInfo);

		/* フォワード */
		RequestDispatcher dispatcher =
				request.getRequestDispatcher("/WEB-INF/pages/series_info.jsp");
		dispatcher.forward(request, response);
	}


//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doGet(request, response);
//	}

}
