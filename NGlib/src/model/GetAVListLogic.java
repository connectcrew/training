package model;

import java.util.List;
import dao.AnimationVADAO;

public class GetAVListLogic {
	public List<AnimationVA> execute(String searchName, int searchPage) {
		System.out.println("*** Enter GetAVListLogic");
		AnimationVADAO dao = new AnimationVADAO();
		List<AnimationVA> avList = dao.avList(searchName, searchPage);
		return avList;
	}
}
