package model;

import dao.InsertDAO;

public class InsBrLogic {
	public int execute(Brand br) {
		System.out.println("*** Enter SetCoLogic");
		int ErrorCode = 0;
		InsertDAO dao = new InsertDAO();
		switch (dao.insertBr(br)) {
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
