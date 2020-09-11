package model;

import java.util.List;
import dao.GraphicCreatorDAO;

public class GetSelectGCListLogic {
	public List<Creator> execute() {
		System.out.println("*** Enter GetSelectGCListLogic");
		GraphicCreatorDAO dao = new GraphicCreatorDAO();
		List<Creator> gcList = dao.gcSelectList();
		return gcList;
	}
}
