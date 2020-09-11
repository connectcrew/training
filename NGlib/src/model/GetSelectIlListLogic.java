package model;

import java.util.List;
import dao.IllustratorDAO;

public class GetSelectIlListLogic {
	public List<Creator> execute() {
		System.out.println("*** Enter GetSelectIlListLogic");
		IllustratorDAO dao = new IllustratorDAO();
		List<Creator> ilList = dao.ilSelectList();
		return ilList;
	}
}
