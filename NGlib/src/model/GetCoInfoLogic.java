package model;

import java.util.List;
import dao.CompanyDAO;

public class GetCoInfoLogic {
	public List<Company> execute(String searchId) {
		System.out.println("*** Enter GetCoInfoLogic");
		CompanyDAO dao = new CompanyDAO();
		List<Company> coInfo = dao.coInfo(searchId);
		return coInfo;
	}
}
