/* TopDAOから値を引き出して返すBean */

package model;

import java.util.List;
import dao.TopDAO;

public class GetTopNewerBoxLogic {
	public List<TopBox> execute() {
		System.out.println("*** Enter GetTopBrBoxLogic");
		TopDAO dao = new TopDAO();
		List<TopBox> newerBox = dao.newerBox();
		return newerBox;
	}
}