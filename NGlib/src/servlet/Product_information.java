package servlet;

import java.util.List;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.ProductInfo;
import model.ProductStaff;
import model.GetPiInfoLogic;
import model.GetPiPartPrLogic;
import model.GetPiPartSWLogic;
import model.GetPiPartIlLogic;
import model.GetPiPartGCLogic;
import model.GetPiPartSCLogic;
import model.GetPiPartVALogic;

@WebServlet("/product_information")
public class Product_information extends HttpServlet {
	private static final long serialVersionUID = 1L;




	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


		String searchId = request.getParameter("id");
		System.out.println("*** getParameter searchId = " + searchId);


		System.out.println("*** Get Product Information");

		System.out.println(">>> Create piInfo and setAttribute");
		GetPiInfoLogic getPiInfoLogic = new GetPiInfoLogic();
		ProductInfo piInfo = getPiInfoLogic.execute(searchId);
		request.setAttribute("piInfo", piInfo);
		System.out.println(piInfo);

		System.out.println("*** Get Staff Information");

		System.out.println(">>> Create partPr and setAttribute");
		GetPiPartPrLogic getPartPr = new GetPiPartPrLogic();
		List<ProductStaff> partPr = getPartPr.execute(searchId);
		request.setAttribute("partPr", partPr);


		System.out.println(">>> Create partSW and setAttribute");
		GetPiPartSWLogic getPartSW = new GetPiPartSWLogic();
		List<ProductStaff> partSW = getPartSW.execute(searchId);
		request.setAttribute("partSW", partSW);


		System.out.println(">>> Create partIl and setAttribute");
		GetPiPartIlLogic getPartIl = new GetPiPartIlLogic();
		List<ProductStaff> partIl = getPartIl.execute(searchId);
		request.setAttribute("partIl", partIl);


		System.out.println(">>> Create partGC and setAttribute");
		GetPiPartGCLogic getPartGC = new GetPiPartGCLogic();
		List<ProductStaff> partGC = getPartGC.execute(searchId);
		request.setAttribute("partGC", partGC);


		System.out.println(">>> Create partSC and setAttribute");
		GetPiPartSCLogic getPartSC = new GetPiPartSCLogic();
		List<ProductStaff> partSC = getPartSC.execute(searchId);
		request.setAttribute("partSC", partSC);


		System.out.println(">>> Create partVA and setAttribute");
		GetPiPartVALogic getPartVA = new GetPiPartVALogic();
		List<ProductStaff> partVA = getPartVA.execute(searchId);
		request.setAttribute("partVA", partVA);


		/* フォワード */
		RequestDispatcher dispatcher =
				request.getRequestDispatcher("/WEB-INF/pages/product_info.jsp");
		dispatcher.forward(request, response);
	}


//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doGet(request, response);
//	}

}
