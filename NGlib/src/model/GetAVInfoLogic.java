package model;

import java.util.List;
import dao.AnimationVADAO;

public class GetAVInfoLogic {
	public List<AnimationVA> execute(String searchId) {
		System.out.println("*** Enter GetAVInfoLogic");
		AnimationVADAO dao = new AnimationVADAO();
		List<AnimationVA> avInfo = dao.avInfo(searchId);
		return avInfo;
	}
}
