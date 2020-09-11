package model;

import java.util.List;
import dao.AffilicationOfficeDAO;

public class GetSelectAOListLogic {
	public List<AffilicationOffice> execute() {
		System.out.println("*** Enter GetSelectVAListLogic");
		AffilicationOfficeDAO dao = new AffilicationOfficeDAO();
		List<AffilicationOffice> avList = dao.aoSelectList();
		return avList;
	}
}
