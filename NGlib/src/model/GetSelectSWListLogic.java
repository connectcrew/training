package model;

import java.util.List;
import dao.ScenarioWriterDAO;

public class GetSelectSWListLogic {
	public List<Creator> execute() {
		System.out.println("*** Enter GetSelectSWListLogic");
		ScenarioWriterDAO dao = new ScenarioWriterDAO();
		List<Creator> swList = dao.swSelectList();
		return swList;
	}
}
