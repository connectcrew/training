package model;

import java.util.List;
import dao.SeriesDAO;

public class GetSeriesInfoLogic {
	public List<Series> execute(String searchId) {
		System.out.println("*** Enter GetSeriesInfoLogic");
		SeriesDAO dao = new SeriesDAO();
		List<Series> seriesInfo = dao.seriesInfo(searchId);
		return seriesInfo;
	}
}
