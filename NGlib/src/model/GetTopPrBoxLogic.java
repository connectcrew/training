/* TopDAOから値を引き出して返すBean */

package model;

import java.util.List;
import dao.TopDAO;

public class GetTopPrBoxLogic {
	public List<TopBox> execute() {
		System.out.println("*** Enter GetTopPrBoxLogic");
		TopDAO dao = new TopDAO();
		List<TopBox> prBox = dao.prBox();
		return prBox;
	}
}