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
import model.GetPageSeriesLogic;
import model.GetSWListLogic;

@WebServlet("/ScenarioWriter_list")
public class ScenarioWriter_list extends HttpServlet {
	private static final long serialVersionUID = 1L;




	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


		String searchName = "%%";
		int searchPage = 0;


		GetPageSeriesLogic pageNum = new GetPageSeriesLogic();
		int page = pageNum.execute(searchName);
		request.setAttribute("page", page);

		GetSWListLogic getSWListLogic = new GetSWListLogic();
		List<Creator> swList = getSWListLogic.execute(searchName, searchPage);
		request.setAttribute("swList", swList);

		/* フォワード */
		RequestDispatcher dispatcher =
				request.getRequestDispatcher("/WEB-INF/pages/scenario_writer_list.jsp");
		dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String searchName;
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

		// ページボタン数
		GetPageSeriesLogic pageNum = new GetPageSeriesLogic();
		int page = pageNum.execute(searchName);
		request.setAttribute("page", page);

		GetSWListLogic getSWListLogic = new GetSWListLogic();
		List<Creator> swList = getSWListLogic.execute(searchName, searchPage);
		request.setAttribute("swList", swList);

		/* フォワード */
		RequestDispatcher dispatcher =
				request.getRequestDispatcher("/WEB-INF/pages/scenario_writer_list.jsp");
		dispatcher.forward(request, response);

	}

}
