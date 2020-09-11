package model;

import java.util.List;
import dao.VoiceActorDAO;

public class GetVAListLogic {
	public List<VoiceActor> execute(String searchName, int searchPage) {
		System.out.println("*** Enter GetVAListLogic");
		VoiceActorDAO dao = new VoiceActorDAO();
		List<VoiceActor> vaList = dao.vaList(searchName, searchPage);
		return vaList;
	}
}
