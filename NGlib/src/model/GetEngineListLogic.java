package model;

import java.util.List;
import dao.EngineDAO;

public class GetEngineListLogic {
	public List<Engine> execute(String searchName, int searchPage) {
		System.out.println("*** Enter GetEngineListLogic");
		EngineDAO dao = new EngineDAO();
		List<Engine> engineList = dao.engineList(searchName, searchPage);
		return engineList;
	}
}
