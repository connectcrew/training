package model;

import java.util.List;
import dao.CompanyDAO;

public class GetSelectCoListLogic {
	public List<Company> execute() {
		System.out.println("*** Enter GetSelectCoLogic");
		CompanyDAO dao = new CompanyDAO();
		List<Company> coList = dao.coSelectList();
		return coList;
	}
}
