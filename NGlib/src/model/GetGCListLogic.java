package model;

import java.util.List;
import dao.GraphicCreatorDAO;

public class GetGCListLogic {
	public List<Creator> execute(String searchName, int searchPage) {
		System.out.println("*** Enter GetGCListLogic");
		GraphicCreatorDAO dao = new GraphicCreatorDAO();
		List<Creator> gcList = dao.gcList(searchName, searchPage);
		return gcList;
	}
}
