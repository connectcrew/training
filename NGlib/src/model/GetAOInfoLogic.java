package model;

import java.util.List;
import dao.AffilicationOfficeDAO;

public class GetAOInfoLogic {
	public List<AffilicationOffice> execute(String searchId) {
		System.out.println("*** Enter GetAOInfoLogic");
		AffilicationOfficeDAO dao = new AffilicationOfficeDAO();
		List<AffilicationOffice> aoInfo = dao.aoInfo(searchId);
		return aoInfo;
	}
}
