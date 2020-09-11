package model;

import java.util.List;
import dao.SearchDAO;

public class GetYearLogic {
	public List<Year> execute() {
		System.out.println("*** Enter GetAOInfoLogic");
		SearchDAO dao = new SearchDAO();
		List<Year> year = dao.yearList();
		return year;
	}
}
