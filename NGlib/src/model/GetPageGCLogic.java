package model;

import dao.SearchDAO;

public class GetPageGCLogic {
	public int execute(String searchName) {
		System.out.println("*** Enter GetPageBrLogic");
		SearchDAO dao = new SearchDAO();
		int page = dao.pageGC(searchName);
		return page;
	}
}
