package model;

import java.util.List;
import dao.EngineDAO;

public class GetEngineInfoLogic {
	public List<Engine> execute(String searchId) {
		System.out.println("*** Enter GetEngineInfoLogic");
		EngineDAO dao = new EngineDAO();
		List<Engine> engineInfo = dao.engineInfo(searchId);
		return engineInfo;
	}
}
