package model;

import java.util.List;
import dao.IllustratorDAO;

public class GetIlListLogic {
	public List<Creator> execute(String searchName, int searchPage) {
		System.out.println("*** Enter GetIlListLogic");
		IllustratorDAO dao = new IllustratorDAO();
		List<Creator> ilList = dao.ilList(searchName, searchPage);
		return ilList;
	}
}
