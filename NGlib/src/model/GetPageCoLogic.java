package model;

import dao.SearchDAO;

public class GetPageCoLogic {
	public int execute(String searchName) {
		System.out.println("*** Enter GetPageCoLogic");
		SearchDAO dao = new SearchDAO();
		int page = dao.pageCo(searchName);
		return page;
	}
}
