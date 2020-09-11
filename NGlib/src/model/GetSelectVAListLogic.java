package model;

import java.util.List;
import dao.VoiceActorDAO;

public class GetSelectVAListLogic {
	public List<VoiceActor> execute() {
		System.out.println("*** Enter GetSelectVAListLogic");
		VoiceActorDAO dao = new VoiceActorDAO();
		List<VoiceActor> vaList = dao.vaSelectList();
		return vaList;
	}
}
