package model;

import java.util.List;
import dao.ClubDAO;

public class GetClListLogic {
	public List<Club> execute(String searchName, int searchPage) {
		System.out.println("*** Enter GetIlListLogic");
		ClubDAO dao = new ClubDAO();
		List<Club> clList = dao.clList(searchName, searchPage);
		return clList;
	}
}
