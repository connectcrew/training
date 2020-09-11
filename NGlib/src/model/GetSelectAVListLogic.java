package model;

import java.util.List;
import dao.AnimationVADAO;

public class GetSelectAVListLogic {
	public List<AnimationVA> execute() {
		System.out.println("*** Enter GetSelectVAListLogic");
		AnimationVADAO dao = new AnimationVADAO();
		List<AnimationVA> avList = dao.avSelectList();
		return avList;
	}
}
