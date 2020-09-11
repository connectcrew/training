/* TopDAOから値を引き出して返すBean */

package model;

import java.util.List;
import dao.TopDAO;

public class GetTopSCBoxLogic {
	public List<TopBox> execute() {
		System.out.println("*** Enter GetTopSCBoxLogic");
		TopDAO dao = new TopDAO();
		List<TopBox> scBox = dao.scBox();
		return scBox;
	}
}