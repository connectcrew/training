package model;

import java.util.List;
import dao.ProducerDAO;

public class GetSelectPrListLogic {
	public List<Creator> execute() {
		System.out.println("*** Enter GetSelectPrListLogic");
		ProducerDAO dao = new ProducerDAO();
		List<Creator> prList = dao.prSelectList();
		return prList;
	}
}
