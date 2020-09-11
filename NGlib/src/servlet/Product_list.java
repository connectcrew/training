package servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.ProductInfo;
import model.Year;
import model.Brand;
import model.GetPiListLogic;
import model.GetYearLogic;
import model.GetPagePiLogic;
import model.GetSelectBrListLogic;

@WebServlet("/product_list")
public class Product_list extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String searchName = "%%";
		String searchBrand = "%%";
		String searchDate = "____-__-__";
		int searchPage = 0;

		// for searchform
		GetYearLogic getYearLogic = new GetYearLogic();
		List<Year> yearList = getYearLogic.execute();
		request.setAttribute("yearList", yearList);

		GetSelectBrListLogic getSelectBrListLogic = new GetSelectBrListLogic();
		List<Brand> brandList = getSelectBrListLogic.execute();
		request.setAttribute("brandList", brandList);

		GetPagePiLogic pageNum = new GetPagePiLogic();
		int page = pageNum.execute(searchName, searchBrand,searchDate);
		request.setAttribute("page", page);


		// list data
		GetPiListLogic getPiListLogic = new GetPiListLogic();
		List<ProductInfo> piList = getPiListLogic.execute(searchName, searchBrand, searchDate, searchPage);
		request.setAttribute("piList", piList);

		/* フォワード */
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/pages/product_list.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 検索フォーム用
		String searchName;
		String searchBrand;
		String searchDate;
		int searchPage;

		// selected挿入ロジック用
		int M;
		int D;

		// select form / year
		GetYearLogic getYearLogic = new GetYearLogic();
		List<Year> yearList = getYearLogic.execute();
		request.setAttribute("yearList", yearList);
		// select form / brand
		GetSelectBrListLogic getSelectBrListLogic = new GetSelectBrListLogic();
		List<Brand> brandList = getSelectBrListLogic.execute();
		request.setAttribute("brandList", brandList);


		// 検索窓に打ち込まれたキーワードから、%キーワード%を生成 且つ フォワード後も打ち込んだ内容が残るように保持
		String name = request.getParameter("name");
		searchName = ("%" + name + "%");
		request.setAttribute("getName", name);

		String brand = request.getParameter("brand");
		searchBrand = ("%" + brand + "%");
		request.setAttribute("brand", brand);

		// 選択窓から選択された発売日から、____-__-__の定型文を生成
		String year = request.getParameter("year");
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		searchDate = (year + "-" + month + "-" + day);
		request.setAttribute("searchDate", searchDate);
		// JSPにてselectedを出力する際のロジックで if(int == (int or String))になるので、Stringの際は強制的に0に。
		if (month.equals("__")) {
			M = 0;
		} else {
			M = Integer.parseInt(month);
		}
		if (day.equals("__")) {
			D = 0;
		} else {
			D = Integer.parseInt(day);
		}
		// フォワード後も選択した内容が残るように保持
		request.setAttribute("year", year);
		request.setAttribute("getMonth", M);
		request.setAttribute("getDay", D);



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


		// ページボタン数
		GetPagePiLogic pageNum = new GetPagePiLogic();
		int page = pageNum.execute(searchName, searchBrand, searchDate);
		request.setAttribute("page", page);

		GetPiListLogic getPiListLogic = new GetPiListLogic();
		List<ProductInfo> piList = getPiListLogic.execute(searchName, searchBrand, searchDate, searchPage);
		request.setAttribute("piList", piList);

		/* フォワード */
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/pages/product_list.jsp");
		dispatcher.forward(request, response);
	}

}
