package model;

import java.util.List;
import dao.ClubDAO;

public class GetSelectClListLogic {
	public List<Club> execute() {
		System.out.println("*** Enter GetSelectClListLogic");
		ClubDAO dao = new ClubDAO();
		List<Club> clList = dao.clSelectList();
		return clList;
	}
}
