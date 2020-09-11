package model;

import java.util.List;
import dao.GraphicCreatorDAO;

public class GetGCInfoLogic {
	public List<Creator> execute(String searchId) {
		System.out.println("*** Enter GetGCInfoLogic");
		GraphicCreatorDAO dao = new GraphicCreatorDAO();
		List<Creator> gcInfo = dao.gcInfo(searchId);
		return gcInfo;
	}
}
