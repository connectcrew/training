package model;

import dao.SearchDAO;

public class GetPageVALogic {
	public int execute(String searchName) {
		System.out.println("*** Enter GetPageVALogic");
		SearchDAO dao = new SearchDAO();
		int page = dao.pageVA(searchName);
		return page;
	}
}
