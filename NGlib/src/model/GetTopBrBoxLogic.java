/* TopDAOから値を引き出して返すBean */

package model;

import java.util.List;
import dao.TopDAO;

public class GetTopBrBoxLogic {
	public List<TopBox> execute() {
		System.out.println("*** Enter GetTopBrBoxLogic");
		TopDAO dao = new TopDAO();
		List<TopBox> brBox = dao.brBox();
		return brBox;
	}
}