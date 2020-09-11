/* Product_informationDAOから値を引き出して返すBean */

package model;

import java.util.List;
import java.util.ArrayList;
import dao.ProductDAO;

public class GetPiPartSCLogic {
	public List<ProductStaff> execute(String searchId) {
		System.out.println("*** Enter GetPiPartPrLogic");
		List<ProductStaff> partSC = new ArrayList<>();
		ProductDAO dao = new ProductDAO();
		partSC = dao.partSC(searchId);
		return partSC;
	}
}