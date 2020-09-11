/* Product_informationDAOから値を引き出して返すBean */

package model;

import java.util.List;
import dao.ProductDAO;

public class GetPiPartSWLogic {
	public List<ProductStaff> execute(String searchId) {
		System.out.println("*** Enter GetPiPartSWLogic");
		ProductDAO dao = new ProductDAO();
		List<ProductStaff> partSW = dao.partSW(searchId);
		return partSW;
	}
}