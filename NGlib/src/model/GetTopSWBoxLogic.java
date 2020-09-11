/* TopDAOから値を引き出して返すBean */

package model;

import java.util.List;
import dao.TopDAO;

public class GetTopSWBoxLogic {
	public List<TopBox> execute() {
		System.out.println("*** Enter GetTopSWBoxLogic");
		TopDAO dao = new TopDAO();
		List<TopBox> swBox = dao.swBox();
		return swBox;
	}
}