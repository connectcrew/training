/* Product_informationDAOから値を引き出して返すBean */

package model;

import java.util.List;
import dao.ProductDAO;

public class GetPiPartGCLogic {
	public List<ProductStaff> execute(String searchId) {
		System.out.println("*** Enter GetPiPartPrLogic");
		ProductDAO dao = new ProductDAO();
		List<ProductStaff> partGC = dao.partGC(searchId);
		return partGC;
	}
}