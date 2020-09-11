/* TopDAOから値を引き出して返すBean */

package model;

import java.util.List;
import dao.TopDAO;

public class GetTopGCBoxLogic {
	public List<TopBox> execute() {
		System.out.println("*** Enter GetTopGCBoxLogic");
		TopDAO dao = new TopDAO();
		List<TopBox> gcBox = dao.gcBox();
		return gcBox;
	}
}