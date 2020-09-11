/* Product_informationDAOから値を引き出して返すBean */

package model;

import java.util.List;
import dao.ProductDAO;

public class GetPiPartIlLogic {
	public List<ProductStaff> execute(String searchId) {
		System.out.println("*** Enter GetPiPartIlLogic");
		ProductDAO dao = new ProductDAO();
		List<ProductStaff> partIl = dao.partIl(searchId);
		return partIl;
	}
}