package model;

import java.util.List;
import dao.BrandDAO;

public class GetBrListLogic {
	public List<Brand> execute(String searchName, int searchPage) {
		System.out.println("*** Enter GetBrListLogic");
		BrandDAO dao = new BrandDAO();
		List<Brand> brList = dao.brList(searchName, searchPage);
		return brList;
	}
}
