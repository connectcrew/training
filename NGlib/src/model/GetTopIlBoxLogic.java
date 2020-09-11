/* TopDAOから値を引き出して返すBean */

package model;

import java.util.List;
import dao.TopDAO;

public class GetTopIlBoxLogic {
	public List<TopBox> execute() {
		System.out.println("*** Enter GetTopIlBoxLogic");
		TopDAO dao = new TopDAO();
		List<TopBox> ilBox = dao.ilBox();
		return ilBox;
	}
}