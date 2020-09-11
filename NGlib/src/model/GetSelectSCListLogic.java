package model;

import java.util.List;
import dao.SoundCreatorDAO;

public class GetSelectSCListLogic {
	public List<Creator> execute() {
		System.out.println("*** Enter GetSelectSCListLogic");
		SoundCreatorDAO dao = new SoundCreatorDAO();
		List<Creator> scList = dao.scSelectList();
		return scList;
	}
}
