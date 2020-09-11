/* TopDAOから値を引き出して返すBean */

package model;

import java.util.List;
import dao.TopDAO;

public class GetTopAVBoxLogic {
	public List<TopBox> execute() {
		System.out.println("*** Enter GetTopAVBoxLogic");
		TopDAO dao = new TopDAO();
		List<TopBox> avBox = dao.avBox();
		return avBox;
	}
}