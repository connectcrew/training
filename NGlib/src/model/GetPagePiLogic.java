package model;

import dao.SearchDAO;

public class GetPagePiLogic {
	public int execute(String searchName, String searchBrand, String searchDate) {
		System.out.println("*** Enter GetPagePiLogic");
		SearchDAO dao = new SearchDAO();
		int page = dao.pagePi(searchName, searchBrand, searchDate);
		return page;
	}
}
