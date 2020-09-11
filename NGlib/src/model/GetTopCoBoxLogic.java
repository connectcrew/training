/* TopDAOから値を引き出して返すBean */

package model;

import java.util.List;
import dao.TopDAO;

public class GetTopCoBoxLogic {
	public List<TopBox> execute() {
		System.out.println("*** Enter GetTopCoBoxLogic");
		TopDAO dao = new TopDAO();
		List<TopBox> coBox = dao.coBox();
		return coBox;
	}
}