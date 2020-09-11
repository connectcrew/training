package model;

import dao.SearchDAO;

public class GetPageEngineLogic {
	public int execute(String searchName) {
		System.out.println("*** Enter GetPageEngineLogic");
		SearchDAO dao = new SearchDAO();
		int page = dao.pageEngine(searchName);
		return page;
	}
}
