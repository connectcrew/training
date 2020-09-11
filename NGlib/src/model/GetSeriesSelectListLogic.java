package model;

import java.util.List;
import dao.SeriesDAO;

public class GetSeriesSelectListLogic {
	public List<Series> execute() {
		System.out.println("*** Enter GetSeriesListLogic");
		SeriesDAO dao = new SeriesDAO();
		List<Series> seriesList = dao.seriesSelectList();
		return seriesList;
	}
}
