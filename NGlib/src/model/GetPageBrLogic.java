package model;

import dao.SearchDAO;

public class GetPageBrLogic {
	public int execute(String searchName) {
		System.out.println("*** Enter GetPageBrLogic");
		SearchDAO dao = new SearchDAO();
		int page = dao.pageBr(searchName);
		return page;
	}
}
