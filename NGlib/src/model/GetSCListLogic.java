package model;

import java.util.List;
import dao.SoundCreatorDAO;

public class GetSCListLogic {
	public List<Creator> execute(String searchName, int searchPage) {
		System.out.println("*** Enter GetSCListLogic");
		SoundCreatorDAO dao = new SoundCreatorDAO();
		List<Creator> scList = dao.scList(searchName, searchPage);
		return scList;
	}
}
