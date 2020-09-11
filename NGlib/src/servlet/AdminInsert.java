package servlet;

import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ProductInfo;
import model.Series;
import model.InsBrLogic;
import model.InsCoLogic;
import model.InsAVLogic;
import model.InsCrLogic;
import model.InsPgcLogic;
import model.VoiceActor;
import model.AffilicationOffice;
import model.AnimationVA;
import model.Brand;
import model.Club;
import model.Company;
import model.Creator;
import model.Engine;
import model.GetEngineSelectListLogic;
import model.GetPrefecturesLogic;
import model.GetSelectAOListLogic;
import model.GetSelectAVListLogic;
import model.GetSelectBrListLogic;
import model.GetSelectClListLogic;
import model.GetSelectCoListLogic;
import model.GetSelectPrListLogic;
import model.GetSelectSWListLogic;
import model.GetSelectIlListLogic;
import model.GetSelectGCListLogic;
import model.GetSelectSCListLogic;
import model.GetSelectVAListLogic;
import model.GetSeriesSelectListLogic;
import model.Prefectures;
import model.InsPiInfoLogic;
import model.InsPilLogic;
import model.InsPprLogic;
import model.InsPscLogic;
import model.InsPswLogic;
import model.InsPvaLogic;
import model.InsVALogic;


@WebServlet("/adminInsert")
public class AdminInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		String adminName = (String)session.getAttribute("adminName");

		if (adminName == null) {
			RequestDispatcher dispatcher =
					request.getRequestDispatcher("/WEB-INF/administer/login.jsp");
			dispatcher.forward(request, response);
		} else {

			String category = request.getParameter("category");
			request.setAttribute("getCategory", category);

			switch (category) {
			case "pi" :
				System.out.println("*** Get Product Information");


				System.out.println(">>> Create brandSelectList");
				GetSelectBrListLogic getSelectBrListLogic = new GetSelectBrListLogic();
				List<Brand> brandSelectList = getSelectBrListLogic.execute();
				request.setAttribute("brandSelectList", brandSelectList);

				System.out.println(">>> Create seriesSelectList");
				GetSeriesSelectListLogic getSeriesSelectListLogic = new GetSeriesSelectListLogic();
				List<Series> seriesSelectList = getSeriesSelectListLogic.execute();
				request.setAttribute("seriesSelectList", seriesSelectList);

				System.out.println(">>> Create engineSelectList");
				GetEngineSelectListLogic getEngineSelectListLogic = new GetEngineSelectListLogic();
				List<Engine> engineSelectList = getEngineSelectListLogic.execute();
				request.setAttribute("engineSelectList", engineSelectList);

				System.out.println(">>> Create prSelectList");
				GetSelectPrListLogic getSelectPrListLogic = new GetSelectPrListLogic();
				List<Creator> prSelectList = getSelectPrListLogic.execute();
				request.setAttribute("prSelectList", prSelectList);

				System.out.println(">>> Create swSelectList");
				GetSelectSWListLogic getSelectSWListLogic = new GetSelectSWListLogic();
				List<Creator> swSelectList = getSelectSWListLogic.execute();
				request.setAttribute("swSelectList", swSelectList);

				System.out.println(">>> Create ilSelectList");
				GetSelectIlListLogic getSelectIlListLogic = new GetSelectIlListLogic();
				List<Creator> ilSelectList = getSelectIlListLogic.execute();
				request.setAttribute("ilSelectList", ilSelectList);

				System.out.println(">>> Create gcSelectList");
				GetSelectGCListLogic getSelectGCListLogic = new GetSelectGCListLogic();
				List<Creator> gcSelectList = getSelectGCListLogic.execute();
				request.setAttribute("gcSelectList", gcSelectList);

				System.out.println(">>> Create scSelectList");
				GetSelectSCListLogic getSelectSCListLogic = new GetSelectSCListLogic();
				List<Creator> scSelectList = getSelectSCListLogic.execute();
				request.setAttribute("scSelectList", scSelectList);

				System.out.println(">>> Create vaSelectList");
				GetSelectVAListLogic getSelectVAListLogic = new GetSelectVAListLogic();
				List<VoiceActor> vaSelectList = getSelectVAListLogic.execute();
				request.setAttribute("vaSelectList", vaSelectList);

				break;

			case "co" :


				break;

			case "br" :

				GetSelectCoListLogic getSelectCoListLogic = new GetSelectCoListLogic();
				List<Company> coSelectList = getSelectCoListLogic.execute();
				request.setAttribute("coSelectList", coSelectList);

				break;

			case "va" :

				GetSelectAVListLogic getSelectAVListLogic = new GetSelectAVListLogic();
				List<AnimationVA> avSelectList = getSelectAVListLogic.execute();
				request.setAttribute("avSelectList", avSelectList);

			case "av" :

				GetSelectAOListLogic getSelectAOListLogic = new GetSelectAOListLogic();
				List<AffilicationOffice> aoSelectList = getSelectAOListLogic.execute();
				request.setAttribute("aoSelectList", aoSelectList);

			case "pr" :
			case "sw" :
			case "il" :
			case "gc" :
			case "sc" :

				System.out.println(">>> Create brandSelectList");
				GetSelectBrListLogic getSelectBrListLogic2 = new GetSelectBrListLogic();
				List<Brand> brandSelectList2 = getSelectBrListLogic2.execute();
				request.setAttribute("brandSelectList", brandSelectList2);

				System.out.println(">>> Create SelectPregectureList");
				GetPrefecturesLogic getPrefecturesLogic = new GetPrefecturesLogic();
				List<Prefectures> prefectures = getPrefecturesLogic.execute();
				request.setAttribute("prefectures", prefectures);

				System.out.println(">>> Create SelectClubList");
				GetSelectClListLogic getSelectClListLogic = new GetSelectClListLogic();
				List<Club> club = getSelectClListLogic.execute();
				request.setAttribute("clubSelectList", club);

				break;
			}



		/* フォワード */
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/administer/insert.jsp");
		dispatcher.forward(request, response);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		String adminName = (String)session.getAttribute("adminName");

		if (adminName == null) {
			RequestDispatcher dispatcher =
					request.getRequestDispatcher("/WEB-INF/administer/login.jsp");
			dispatcher.forward(request, response);
		} else {

			String category;

			// to product_info
//			String piId;
			String title;
				// String brId;
			String year;
			String month;
			String day;
			String release;
			String series;
			String engine;
			String comment;
			String text;

			// to product_xx
			String prId;
			String swId;
			String ilId;
			String gcId;
			String scId;
			String vaId;
			int prlength;
			int swlength;
			int illength;
			int gclength;
			int sclength;
			int valength;

			// to company
			String coId;
			String coName;
			// String year;
			String coAddress;

			// to brand
			String brId;
			String brName;
				// int coId

			// to creators
			List<Creator> producer = new ArrayList<>();
			List<Creator> scenariowriter = new ArrayList<>();
			List<Creator> illustrator = new ArrayList<>();
			List<Creator> graphiccreator = new ArrayList<>();
			List<Creator> soundcreator = new ArrayList<>();
			List<Creator> voiceactor = new ArrayList<>();
			String fname;
			String name;
			String fullName;
			String fspell;
			String spell;
			String fullSpell;
			String gender;
			String place;
			String birthday;
			String blood;
			// brId
			String clId;
			String avId;
			String debut;
			String aoId;

			category = request.getParameter("category");
			request.setAttribute("getCategory", category);
			System.out.println(category);

			switch (category) {
			case "pi" :
				System.out.println("*** enter case pi");


				// *** insert into product_info *** //

//				piId = request.getParameter("piId"); // for update. delete later.

				title = request.getParameter("title").strip();
				if (title.equals("")) {
					title = null;
				}


				brId = request.getParameter("brId");
				if (title.equals("null")) {
					title = null;
				}


				year = request.getParameter("year");
				month = request.getParameter("month");
				day = request.getParameter("day");
				release =  (year + "-" + month + "-" + day);
				// substitute null if even one is not selected.
				if (year.equals("____") || month.equals("__") || day.equals("__")) {
					release = null;
				}


				series = request.getParameter("series");
				if (series.equals("null")) {
					series = null;
				} else if (series.equals("new")) { // read text from textbox if selected "make new".
					series = request.getParameter("newSeries").strip();
				}


				engine = request.getParameter("engine");
				if(engine.equals("null")) {
					engine = null;
				}


				comment = request.getParameter("comment");
				if (comment.equals("")) {
					comment = null;
				}


				text = request.getParameter("text");
				if (text.equals("")) {
					text = null;
				}


				ProductInfo productInfo = new ProductInfo(null, brId, title, release, series, engine, comment, text);


				InsPiInfoLogic setPiInfo = new InsPiInfoLogic();
				switch (setPiInfo.execute(productInfo)) {
				case 1 :
					RequestDispatcher sysError = request.getRequestDispatcher("/WEB-INF/error/error01.jsp");
					sysError.forward(request, response);
					return;
				case 2 :
					RequestDispatcher rolError = request.getRequestDispatcher("/WEB-INF/error/error02.jsp");
					rolError.forward(request, response);
					return;
				case 3 :
				case 4 :
				case 5 :
					RequestDispatcher serError = request.getRequestDispatcher("/WEB-INF/error/error03.jsp");
					serError.forward(request, response);
					return;
				}


				// *** insert into product_xx *** //
				prlength = Integer.parseInt(request.getParameter("prlength"));
				for (int i = 0 ; i < prlength ; i++) {
					String param = ("producer" + i);
					prId = request.getParameter(param);
					if (!(prId.equals("null"))) {
						Creator cr = new Creator(null, prId);
						producer.add(cr);
					}
				}
				InsPprLogic setPartPr = new InsPprLogic();
				setPartPr.execute(producer);

				swlength = Integer.parseInt(request.getParameter("swlength"));
				for (int i = 0 ; i < swlength ; i++) {
					String param = ("scenariowriter" + i);
					swId = request.getParameter(param);
					Creator cr = new Creator(null, swId);
					scenariowriter.add(cr);
					System.out.printf("swId(%d) = %s\n",i,swId);
				}
				InsPswLogic setPartSW = new InsPswLogic();
				setPartSW.execute(scenariowriter);

				illength = Integer.parseInt(request.getParameter("illength"));
				for (int i = 0 ; i < illength ; i++) {
					String param = ("illustrator" + i);
					ilId = request.getParameter(param);
					Creator cr = new Creator(null, ilId);
					illustrator.add(cr);
				}
				InsPilLogic setPartIl = new InsPilLogic();
				setPartIl.execute(illustrator);

				gclength = Integer.parseInt(request.getParameter("gclength"));
				for (int i = 0 ; i < gclength ; i++) {
					String param = ("graphiccreator" + i);
					gcId = request.getParameter(param);
					Creator cr = new Creator(null, gcId);
					graphiccreator.add(cr);
				}
				InsPgcLogic setPartGC = new InsPgcLogic();
				setPartGC.execute(graphiccreator);

				sclength = Integer.parseInt(request.getParameter("sclength"));
				for (int i = 0 ; i < sclength ; i++) {
					String param = ("soundcreator" + i);
					scId = request.getParameter(param);
					Creator cr = new Creator(null, scId);
					soundcreator.add(cr);
				}
				InsPscLogic setPartSC = new InsPscLogic();
				setPartSC.execute(soundcreator);

				valength = Integer.parseInt(request.getParameter("valength"));
				for (int i = 0 ; i < valength ; i++) {
					String param = ("voiceactor" + i);
					vaId = request.getParameter(param);
					Creator cr = new Creator(null, vaId);
					voiceactor.add(cr);
				}
				InsPvaLogic setPartVA = new InsPvaLogic();
				setPartVA.execute(voiceactor);

				break;

			case "co" :

				coName = request.getParameter("coName").strip();
				if (coName.equals("")) {
					coName = null;
				}

				year = request.getParameter("year");
				if (year.equals("----")) {
					year = null;
				}

				coAddress = request.getParameter("coAddress").strip();
				if (coAddress.equals("")) {
					coAddress = null;
				}

				Company company = new Company(null, coName, year, coAddress);
				InsCoLogic setCoLogic = new InsCoLogic();
				switch (setCoLogic.execute(company)) {
				case 1 :
					RequestDispatcher sysError = request.getRequestDispatcher("/WEB-INF/error/error01.jsp");
					sysError.forward(request, response);
					return;
				case 2 :
					RequestDispatcher rolError = request.getRequestDispatcher("/WEB-INF/error/error02.jsp");
					rolError.forward(request, response);
					return;
				case 3 :
				case 4 :
				case 5 :
					RequestDispatcher serError = request.getRequestDispatcher("/WEB-INF/error/error03.jsp");
					serError.forward(request, response);
					return;
				}
				break;


			case "br" :

				brName = request.getParameter("brName").strip();
				if (brName.equals("")) {
					brName = null;
				}


				coId = request.getParameter("coId");
				if (brName.equals("null")) {
					brName = null;
				}


				Brand brand = new Brand(null, brName, coId);
				InsBrLogic setBrLogic = new InsBrLogic();
				switch (setBrLogic.execute(brand)) {
				case 1 :
					RequestDispatcher sysError = request.getRequestDispatcher("/WEB-INF/error/error01.jsp");
					sysError.forward(request, response);
					return;
				case 2 :
					RequestDispatcher rolError = request.getRequestDispatcher("/WEB-INF/error/error02.jsp");
					rolError.forward(request, response);
					return;
				case 3 :
				case 4 :
				case 5 :
					RequestDispatcher serError = request.getRequestDispatcher("/WEB-INF/error/error03.jsp");
					serError.forward(request, response);
					return;
				}



				break;

			case "pr" :
			case "sw" :
			case "il" :
			case "gc" :
			case "sc" :
				fname = request.getParameter("fname").strip();
				if (!(fname.equals(""))) {
					fname = fname + " ";
				}
				name = request.getParameter("name").strip();
				if (name.equals("")) {
					name = null;
				}
				fullName = fname + name;

				gender = request.getParameter("gender");

				place = request.getParameter("place");
				if (place.equals("null")) {
					place = null;
				}

				year = request.getParameter("year");
				month = request.getParameter("month");
				day = request.getParameter("day");
				birthday = null;
				if (year.equals("____") && month.equals("__") && day.equals("__")) { // substitute null if not all selected.
					birthday = null;
				} else if (year.equals("____") && !(month.equals("__")) && !(day.equals("__"))) { // substitute 9999 into year if month and day are selected.
					year = "9999";
					birthday = (year + "-" + month + "-" + day);
				} else if (month.equals("__") && !(day.equals("__"))) { // substitute null if only one of the month or day is selected
					birthday = null;
				} else if (!(month.equals("__")) && day.equals("__")) {
					birthday = null;
				}


				blood = request.getParameter("blood");
				if (blood.equals("null")) {
					blood = null;
				}


				brId = request.getParameter("brId");
				if (brId.equals("null")) {
					brId = null;
				}

				clId = request.getParameter("clId");
				if (clId.equals("null")) {
					clId = null;
				}

				Creator creator = new Creator(null, fullName, gender, place, birthday, blood, brId, clId);
				InsCrLogic setCr = new InsCrLogic();
				switch (setCr.execute(creator, category)) {
				}

				break;


			case "va" :

				fname = request.getParameter("fname").strip();
				if (!(fname.equals(""))) {
					fname = fname + " ";
				}
				name = request.getParameter("name").strip();
				fullName = fname + name;

				fspell = request.getParameter("fspell").strip();
				if (!(fspell.equals(""))) {
					fspell = fspell + " ";
				}
				spell = request.getParameter("spell").strip();
				fullSpell = fspell + spell;

				avId = request.getParameter("avId");
				if (avId.equals("null")) {
					avId = null;
				}

				gender = request.getParameter("gender");

				place = request.getParameter("place");
				if (place.equals("null")) {
					place = null;
				}

				year = request.getParameter("year");
				month = request.getParameter("month");
				day = request.getParameter("day");
				birthday = null;
				if (year.equals("____") && month.equals("__") && day.equals("__")) { // substitute null if not all selected.
					birthday = null;
				} else if (year.equals("____") && !(month.equals("__")) && !(day.equals("__"))) { // substitute 9999 into year if month and day are selected.
					year = "9999";
					birthday = (year + "-" + month + "-" + day);
				} else if (month.equals("__") && !(day.equals("__"))) { // substitute null if only one of the month or day is selected
					birthday = null;
				} else if (!(month.equals("__")) && day.equals("__")) {
					birthday = null;
				}


				blood = request.getParameter("blood");
				if (blood.equals("null")) {
					blood = null;
				}

				debut = request.getParameter("debut");
				if (debut.equals("____")) {
					debut = null;
				}

				aoId = request.getParameter("aoId");
				if (aoId.equals("null")) {
					aoId = null;
				}


				VoiceActor va = new VoiceActor(null, fullName, fullSpell, gender, place, birthday, blood, debut, aoId, avId);
				InsVALogic setVALogic = new InsVALogic();
				switch (setVALogic.execute(va)) {
				case 1 :
					RequestDispatcher sysError = request.getRequestDispatcher("/WEB-INF/error/error01.jsp");
					sysError.forward(request, response);
					return;
				case 2 :
					RequestDispatcher rolError = request.getRequestDispatcher("/WEB-INF/error/error02.jsp");
					rolError.forward(request, response);
					return;
				case 3 :
				case 4 :
				case 5 :
					RequestDispatcher serError = request.getRequestDispatcher("/WEB-INF/error/error03.jsp");
					serError.forward(request, response);
					return;
				}

				break;

			case "av" :

				fname = request.getParameter("fname").strip();
				if (!(fname.equals(""))) {
					fname = fname + " ";
				}
				name = request.getParameter("name").strip();
				fullName = fname + name;

				fspell = request.getParameter("fspell").strip();
				if (!(fspell.equals(""))) {
					fspell = fspell + " ";
				}
				spell = request.getParameter("spell").strip();
				fullSpell = fspell + spell;


				gender = request.getParameter("gender");

				place = request.getParameter("place");
				if (place.equals("null")) {
					place = null;
				}

				year = request.getParameter("year");
				month = request.getParameter("month");
				day = request.getParameter("day");
				birthday = null;
				if (year.equals("____") && month.equals("__") && day.equals("__")) { // substitute null if not all selected.
					birthday = null;
				} else if (year.equals("____") && !(month.equals("__")) && !(day.equals("__"))) { // substitute 9999 into year if month and day are selected.
					year = "9999";
					birthday = (year + "-" + month + "-" + day);
				} else if (month.equals("__") && !(day.equals("__"))) { // substitute null if only one of the month or day is selected
					birthday = null;
				} else if (!(month.equals("__")) && day.equals("__")) {
					birthday = null;
				}


				blood = request.getParameter("blood");
				if (blood.equals("null")) {
					blood = null;
				}

				debut = request.getParameter("debut");
				if (debut.equals("____")) {
					debut = null;
				}

				aoId = request.getParameter("aoId");
				if (aoId.equals("null")) {
					aoId = null;
				}

				AnimationVA av = new AnimationVA(null, fullName, fullSpell, gender, place, birthday, blood, debut, aoId);
				InsAVLogic setAVLogic = new InsAVLogic();
				switch (setAVLogic.execute(av)) {
				case 1 :
					RequestDispatcher sysError = request.getRequestDispatcher("/WEB-INF/error/error01.jsp");
					sysError.forward(request, response);
					return;
				case 2 :
					RequestDispatcher rolError = request.getRequestDispatcher("/WEB-INF/error/error02.jsp");
					rolError.forward(request, response);
					return;
				case 3 :
				case 4 :
				case 5 :
					RequestDispatcher serError = request.getRequestDispatcher("/WEB-INF/error/error03.jsp");
					serError.forward(request, response);
					return;
				}


				break;
			}


			/* フォワード */
	//		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/administer/insert.jsp");
	//		dispatcher.forward(request, response);
		}
	}
}
