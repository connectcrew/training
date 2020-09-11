package model;

import java.util.List;
import dao.ProductDAO;
import dao.SearchDateDAO;

public class GetSearchDateLogic {
	public List<ProductInfo> execute(String searchDate) {
		System.out.println("*** Enter GetPiListLogic");
		SearchDateDAO dao = new SearchDateDAO();
		List<ProductInfo> piList = dao.piList(searchDate);
		return piList;
	}
}
