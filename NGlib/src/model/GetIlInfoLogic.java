package model;

import java.util.List;
import dao.IllustratorDAO;

public class GetIlInfoLogic {
	public List<Creator> execute(String searchId) {
		System.out.println("*** Enter GetIlInfoLogic");
		IllustratorDAO dao = new IllustratorDAO();
		List<Creator> ilInfo = dao.ilInfo(searchId);
		return ilInfo;
	}
}
