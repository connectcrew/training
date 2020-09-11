package model;

import java.util.List;
import dao.SoundCreatorDAO;

public class GetSCInfoLogic {
	public List<Creator> execute(String searchId) {
		System.out.println("*** Enter GetSCInfoLogic");
		SoundCreatorDAO dao = new SoundCreatorDAO();
		List<Creator> scInfo = dao.scInfo(searchId);
		return scInfo;
	}
}