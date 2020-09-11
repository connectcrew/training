package model;

import dao.SearchDAO;

public class GetPageAVLogic {
	public int execute(String searchName) {
		System.out.println("*** Enter GetPageAVLogic");
		SearchDAO dao = new SearchDAO();
		int page = dao.pageAV(searchName);
		return page;
	}
}
