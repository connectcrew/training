package model;

import java.util.List;
import dao.ProducerDAO;

public class GetPrListLogic {
	public List<Creator> execute(String searchName, int searchPage) {
		System.out.println("*** Enter GetPrListLogic");
		ProducerDAO dao = new ProducerDAO();
		List<Creator> prList = dao.prList(searchName, searchPage);
		return prList;
	}
}
