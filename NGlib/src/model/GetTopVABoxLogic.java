/* TopDAOから値を引き出して返すBean */

package model;

import java.util.List;
import dao.TopDAO;

public class GetTopVABoxLogic {
	public List<TopBox> execute() {
		System.out.println("*** Enter GetTopVABoxLogic");
		TopDAO dao = new TopDAO();
		List<TopBox> vaBox = dao.vaBox();
		return vaBox;
	}
}