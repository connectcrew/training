package model;

import dao.SearchDAO;

public class GetPageSeriesLogic {
	public int execute(String searchName) {
		System.out.println("*** Enter GetPageSeriesLogic");
		SearchDAO dao = new SearchDAO();
		int page = dao.pageSeries(searchName);
		return page;
	}
}
