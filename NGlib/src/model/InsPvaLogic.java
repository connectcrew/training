package model;

import dao.InsertDAO;
import java.util.List;

public class InsPvaLogic {
	public int execute(List<Creator> cr) {
		System.out.println("*** Enter SetPvaLogic");
		int ErrorCode = 0;
		InsertDAO dao = new InsertDAO();
		switch (dao.partVA(cr)) {
		case 1 :
			ErrorCode = 1;
			break;
		case 2 :
			ErrorCode = 2;
			break;
		case 3 :
			ErrorCode = 3;
			break;
		case 4 :
			ErrorCode = 4;
			break;
		case 5 :
			ErrorCode = 5;
			break;
		}
		return ErrorCode;
	}


}
