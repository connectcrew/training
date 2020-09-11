/* Product_informationDAOから値を引き出して返すBean */

package model;

import java.util.List;
import dao.ProductDAO;

public class GetPiPartVALogic {
	public List<ProductStaff> execute(String searchId) {
		System.out.println("*** Enter GetPiPartPrLogic");
		ProductDAO dao = new ProductDAO();
		List<ProductStaff> partVA = dao.partVA(searchId);
		return partVA;
	}
}