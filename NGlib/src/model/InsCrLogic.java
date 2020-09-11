package model;

import dao.InsertDAO;

public class InsCrLogic {
	public int execute(Creator cr, String category) {
		System.out.println("*** Enter SetPrLogic");
		int ErrorCode = 0;
		InsertDAO dao = new InsertDAO();
		switch (category) {
		case "pr" :
			switch (dao.insertPr(cr)) {
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
			break;

		case "sw" :
			switch (dao.insertSW(cr)) {
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
			break;

		case "il" :
			switch (dao.insertIl(cr)) {
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
			break;

		case "gc" :
			switch (dao.insertGC(cr)) {
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
			break;

		case "sc" :
			switch (dao.insertSC(cr)) {
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
			break;
		}
	return ErrorCode;
	}

}
