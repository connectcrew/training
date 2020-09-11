package model;

import java.util.List;
import dao.SeriesDAO;

public class GetSeriesListLogic {
	public List<Series> execute(String searchName, int searchPage) {
		System.out.println("*** Enter GetSeriesListLogic");
		SeriesDAO dao = new SeriesDAO();
		List<Series> seriesList = dao.seriesList(searchName, searchPage);
		return seriesList;
	}
}
