package model;

import java.util.List;
import dao.ScenarioWriterDAO;

public class GetSWInfoLogic {
	public List<Creator> execute(String searchId) {
		System.out.println("*** Enter GetSWInfoLogic");
		ScenarioWriterDAO dao = new ScenarioWriterDAO();
		List<Creator> swInfo = dao.swInfo(searchId);
		return swInfo;
	}
}