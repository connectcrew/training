package model;

import java.util.List;
import dao.ScenarioWriterDAO;

public class GetSWListLogic {
	public List<Creator> execute(String searchName, int searchPage) {
		System.out.println("*** Enter GetSWListLogic");
		ScenarioWriterDAO dao = new ScenarioWriterDAO();
		List<Creator> swList = dao.swList(searchName, searchPage);
		return swList;
	}
}
