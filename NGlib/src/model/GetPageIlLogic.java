package model;

import dao.SearchDAO;

public class GetPageIlLogic {
	public int execute(String searchName) {
		System.out.println("*** Enter GetPageIlLogic");
		SearchDAO dao = new SearchDAO();
		int page = dao.pageIl(searchName);
		return page;
	}
}
