package model;

import java.util.List;
import dao.PrefecturesDAO;

public class GetPrefecturesLogic {
	public List<Prefectures> execute() {
		System.out.println("*** Enter GetPrefecturesLogic");
		PrefecturesDAO dao = new PrefecturesDAO();
		List<Prefectures> prefectures = dao.prefectures();
		return prefectures;
	}
}
