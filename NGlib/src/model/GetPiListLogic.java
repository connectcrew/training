package model;

import java.util.List;
import dao.ProductDAO;

public class GetPiListLogic {
	public List<ProductInfo> execute(String searchName, String searchBrand, String searchDate, int searchPage) {
		System.out.println("*** Enter GetPiListLogic");
		ProductDAO dao = new ProductDAO();
		List<ProductInfo> piList = dao.piList(searchName, searchBrand, searchDate, searchPage);
		return piList;
	}
}
