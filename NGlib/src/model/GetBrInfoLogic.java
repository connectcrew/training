package model;

import java.util.List;
import dao.BrandDAO;

public class GetBrInfoLogic {
	public List<Brand> execute(String searchId) {
		System.out.println("*** Enter GetBrInfoLogic");
		BrandDAO dao = new BrandDAO();
		List<Brand> brInfo = dao.brInfo(searchId);
		return brInfo;
	}
}
