package model;

import dao.SearchDAO;

public class GetPagePrLogic {
	public int execute(String searchName) {
		System.out.println("*** Enter GetPagePrLogic");
		SearchDAO dao = new SearchDAO();
		int page = dao.pagePr(searchName);
		return page;
	}
}
