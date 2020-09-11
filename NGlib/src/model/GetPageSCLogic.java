package model;

import dao.SearchDAO;

public class GetPageSCLogic {
	public int execute(String searchName) {
		System.out.println("*** Enter GetPageSCLogic");
		SearchDAO dao = new SearchDAO();
		int page = dao.pageSC(searchName);
		return page;
	}
}
