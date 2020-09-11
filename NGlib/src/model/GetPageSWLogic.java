package model;

import dao.SearchDAO;

public class GetPageSWLogic {
	public int execute(String searchName) {
		System.out.println("*** Enter GetPageSWLogic");
		SearchDAO dao = new SearchDAO();
		int page = dao.pageSW(searchName);
		return page;
	}
}
