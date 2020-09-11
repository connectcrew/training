package model;

import java.util.List;
import dao.EngineDAO;

public class GetEngineSelectListLogic {
	public List<Engine> execute() {
		System.out.println("*** Enter GetEngineListLogic");
		EngineDAO dao = new EngineDAO();
		List<Engine> engineSelectList = dao.engineSelectList();
		return engineSelectList;
	}
}
