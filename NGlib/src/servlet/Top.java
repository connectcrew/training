package servlet;

import java.io.IOException;
//import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.TopBox;
import model.GetTopCoBoxLogic;
import model.GetTopBrBoxLogic;
import model.GetTopPrBoxLogic;
import model.GetTopSWBoxLogic;
import model.GetTopIlBoxLogic;
import model.GetTopGCBoxLogic;
import model.GetTopSCBoxLogic;
import model.GetTopVABoxLogic;
import model.GetTopAVBoxLogic;

/**
 * Servlet implementation class Top
 */
@WebServlet("/top")
public class Top extends HttpServlet {
	private static final long serialVersionUID = 1L;


//    public Top() {
//        super();
//
//    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("*** Enter Servlet Top <GET>");
		System.out.println("*** Get Information List for Box from TopBoxLogic");

		System.out.println("<Create coBox>");
		GetTopCoBoxLogic getCoBox = new GetTopCoBoxLogic();
		List<TopBox> coBox = getCoBox.execute();
		request.setAttribute("coBox", coBox);

		System.out.println("<Create brBox>");
		GetTopBrBoxLogic getBrBox = new GetTopBrBoxLogic();
		List<TopBox> brBox = getBrBox.execute();
		request.setAttribute("brBox", brBox);

		System.out.println("<Create prBox>");
		GetTopPrBoxLogic getPrBox = new GetTopPrBoxLogic();
		List<TopBox> prBox = getPrBox.execute();
		request.setAttribute("prBox", prBox);

		System.out.println("<Create swBox>");
		GetTopSWBoxLogic getSWBox = new GetTopSWBoxLogic();
		List<TopBox> swBox = getSWBox.execute();
		request.setAttribute("swBox", swBox);

		System.out.println("<Create ilBox>");
		GetTopIlBoxLogic getIlBox = new GetTopIlBoxLogic();
		List<TopBox> ilBox = getIlBox.execute();
		request.setAttribute("ilBox", ilBox);

		System.out.println("<Create gcBox>");
		GetTopGCBoxLogic getGCBox = new GetTopGCBoxLogic();
		List<TopBox> gcBox = getGCBox.execute();
		request.setAttribute("gcBox", gcBox);

		System.out.println("<Create scBox>");
		GetTopSCBoxLogic getSCBox = new GetTopSCBoxLogic();
		List<TopBox> scBox = getSCBox.execute();
		request.setAttribute("scBox", scBox);

		System.out.println("<Create vaBox>");
		GetTopVABoxLogic getVABox = new GetTopVABoxLogic();
		List<TopBox> vaBox = getVABox.execute();
		request.setAttribute("vaBox", vaBox);

		System.out.println("<Create avBox>");
		GetTopAVBoxLogic getAVBox = new GetTopAVBoxLogic();
		List<TopBox> avBox = getAVBox.execute();
		request.setAttribute("avBox", avBox);

		// フォワード
		RequestDispatcher dispatcher =
				request.getRequestDispatcher("/WEB-INF/pages/top.jsp");
		dispatcher.forward(request, response);
	}


//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doGet(request, response);
//	}

}
