package servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ProductInfo;
import model.VoiceActor;
import model.AnimationVA;
import model.Brand;
import model.Company;
import model.Creator;
import model.GetAVListLogic;
import model.GetBrListLogic;
import model.GetCoListLogic;
import model.GetGCListLogic;
import model.GetIlListLogic;
import model.GetPageBrLogic;
import model.GetPageCoLogic;
import model.GetPageGCLogic;
import model.GetPageIlLogic;
import model.GetPiListLogic;
import model.GetPrListLogic;
import model.GetSCListLogic;
import model.GetSWListLogic;
import model.GetPagePiLogic;
import model.GetPagePrLogic;
import model.GetPageSCLogic;
import model.GetPageSeriesLogic;
import model.GetPageVALogic;
import model.GetVAListLogic;

@WebServlet("/adminSelect")
public class AdminSelect extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		String adminName = (String)session.getAttribute("adminName");

		if (adminName == null) {
			RequestDispatcher dispatcher =
					request.getRequestDispatcher("/WEB-INF/administer/login.jsp");
			dispatcher.forward(request, response);
		} else {


			String searchName = "%%";
			String searchBrand = "%%";
			String searchDate = "____-__-__";
			int searchPage = 1;

			request.setAttribute("getCategory", "pi");
			GetPagePiLogic pagePi = new GetPagePiLogic();
			int piPage = pagePi.execute(searchName, searchBrand, searchDate);
			request.setAttribute("page", piPage);

			GetPiListLogic getPiListLogic = new GetPiListLogic();
			List<ProductInfo> piList = getPiListLogic.execute(searchName, searchBrand, searchDate, searchPage);
			request.setAttribute("List", piList);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/administer/select.jsp");
			dispatcher.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		String adminName = (String)session.getAttribute("adminName");

		if (adminName == null) {
			RequestDispatcher dispatcher =
					request.getRequestDispatcher("/WEB-INF/administer/login.jsp");
			dispatcher.forward(request, response);
		} else {

			// 検索フォーム用
			String searchName;
			String searchBrand = "%%";
			String searchDate = "____-__-__";
			int searchPage;

			// 検索窓に打ち込まれたキーワードから、%キーワード%を生成 且つ フォワード後も打ち込んだ内容が残るように保持
			String name = request.getParameter("name");
			searchName = ("%" + name + "%");
			request.setAttribute("getName", name);


			// ページボタンの数値からOFFSETに代入する数値を作成。
			String Num = request.getParameter("searchPage");
			// ボタンでPOSTしないとNullになる（新たな条件付をして上の検索ボタンを押したときなど）ので、Nullの際は1ページめに強制的に飛ばします。
			if (Num == null) {
				searchPage = 0;
			} else {
				searchPage = Integer.parseInt(Num);
			}
			// ボタンに工夫するために値を保持
			request.setAttribute("searchPage", searchPage);

			String category = request.getParameter("category");
			request.setAttribute("getCategory", category);
			switch (category) {
			case "pi" :
				GetPagePiLogic pagePi = new GetPagePiLogic();
				int piPage = pagePi.execute(searchName, searchBrand, searchDate);
				request.setAttribute("page", piPage);

				GetPiListLogic getPiListLogic = new GetPiListLogic();
				List<ProductInfo> piList = getPiListLogic.execute(searchName, searchBrand, searchDate, searchPage);
				request.setAttribute("List", piList);

				break;

			case "co" :
				GetPageCoLogic pageCo = new GetPageCoLogic();
				int coPage = pageCo.execute(searchName);
				request.setAttribute("page", coPage);

				GetCoListLogic getCoListLogic = new GetCoListLogic();
				List<Company> coList = getCoListLogic.execute(searchName, searchPage);
				request.setAttribute("List", coList);

				break;

			case "br" :
				GetPageBrLogic pageBr = new GetPageBrLogic();
				int brPage = pageBr.execute(searchName);
				request.setAttribute("page", brPage);

				GetBrListLogic getBrListLogic = new GetBrListLogic();
				List<Brand> brList = getBrListLogic.execute(searchName, searchPage);
				request.setAttribute("List", brList);

				break;

			case "pr" :
				GetPagePrLogic pagePr = new GetPagePrLogic();
				int prPage = pagePr.execute(searchName);
				request.setAttribute("page", prPage);

				GetPrListLogic getPrListLogic = new GetPrListLogic();
				List<Creator> prList = getPrListLogic.execute(searchName, searchPage);
				request.setAttribute("List", prList);

				break;

			case "sw" :
				GetPageSeriesLogic pageSW = new GetPageSeriesLogic();
				int swPage = pageSW.execute(searchName);
				request.setAttribute("page", swPage);

				GetSWListLogic getSWListLogic = new GetSWListLogic();
				List<Creator> swList = getSWListLogic.execute(searchName, searchPage);
				request.setAttribute("List", swList);

				break;

			case "il" :
				GetPageIlLogic pageIl = new GetPageIlLogic();
				int ilPage = pageIl.execute(searchName);
				request.setAttribute("page", ilPage);

				GetIlListLogic getIlListLogic = new GetIlListLogic();
				List<Creator> ilList = getIlListLogic.execute(searchName, searchPage);
				request.setAttribute("List", ilList);

				break;

			case "gc" :
				GetPageGCLogic pageGC = new GetPageGCLogic();
				int gcPage = pageGC.execute(searchName);
				request.setAttribute("page", gcPage);

				GetGCListLogic getGCListLogic = new GetGCListLogic();
				List<Creator> gcList = getGCListLogic.execute(searchName, searchPage);
				request.setAttribute("List", gcList);

				break;

			case "sc" :
				GetPageSCLogic pageSC = new GetPageSCLogic();
				int scPage = pageSC.execute(searchName);
				request.setAttribute("page", scPage);

				GetSCListLogic getSCListLogic = new GetSCListLogic();
				List<Creator> scList = getSCListLogic.execute(searchName, searchPage);
				request.setAttribute("List", scList);

				break;

			case "va" :
				GetPageVALogic pageVA = new GetPageVALogic();
				int vaPage = pageVA.execute(searchName);
				request.setAttribute("page", vaPage);

				GetVAListLogic getVAListLogic = new GetVAListLogic();
				List<VoiceActor> vaList = getVAListLogic.execute(searchName, searchPage);
				request.setAttribute("List", vaList);

				break;

			case "av" :
				GetPageSeriesLogic pageAV = new GetPageSeriesLogic();
				int avPage = pageAV.execute(searchName);
				request.setAttribute("page", avPage);

				GetAVListLogic getAVListLogic = new GetAVListLogic();
				List<AnimationVA> avList = getAVListLogic.execute(searchName, searchPage);
				request.setAttribute("List", avList);

				break;
			}


			/* フォワード */
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/administer/select.jsp");
			dispatcher.forward(request, response);
		}
	}
}
