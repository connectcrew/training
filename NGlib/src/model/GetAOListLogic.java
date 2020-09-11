package model;

import java.util.List;
import dao.AffilicationOfficeDAO;

public class GetAOListLogic {
	public List<AffilicationOffice> execute() {
		System.out.println("*** Enter GetAOListLogic");
		AffilicationOfficeDAO dao = new AffilicationOfficeDAO();
		List<AffilicationOffice> aoList = dao.aoList();
		return aoList;
	}
}
