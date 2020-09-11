package model;

import java.util.List;
import dao.CompanyDAO;

public class GetCoListLogic {
	public List<Company> execute(String searchName, int searchPage) {
		System.out.println("*** Enter GetCoListLogic");
		CompanyDAO dao = new CompanyDAO();
		List<Company> coList = dao.coList(searchName, searchPage);
		return coList;
	}
}
