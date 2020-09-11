package model;

import java.util.List;
import dao.VoiceActorDAO;

public class GetVAInfoLogic {
	public List<VoiceActor> execute(String searchId) {
		System.out.println("*** Enter Clas GetVAInfoLogic");
		VoiceActorDAO dao = new VoiceActorDAO();
		List<VoiceActor> vaInfo = dao.vaInfo(searchId);
		return vaInfo;
	}
}
