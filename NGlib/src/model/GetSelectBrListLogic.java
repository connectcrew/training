package model;

import java.util.List;
import dao.BrandDAO;

public class GetSelectBrListLogic {
	public List<Brand> execute() {
		System.out.println("*** Enter GetSelectBrListLogic");
		BrandDAO dao = new BrandDAO();
		List<Brand> brList = dao.brSelectList();
		return brList;
	}
}
