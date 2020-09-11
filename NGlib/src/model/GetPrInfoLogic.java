package model;

import java.util.List;
import dao.ProducerDAO;

public class GetPrInfoLogic {
	public List<Creator> execute(String searchId) {
		System.out.println("*** Enter GetPrInfoLogic");
		ProducerDAO dao = new ProducerDAO();
		List<Creator> prInfo = dao.prInfo(searchId);
		return prInfo;
	}
}
