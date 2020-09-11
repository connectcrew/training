package model;

import dao.InsertDAO;

public class InsVALogic {
	public int execute(VoiceActor va) {
		System.out.println("*** Enter SetCoLogic");
		int ErrorCode = 0;
		InsertDAO dao = new InsertDAO();
		switch (dao.insertVA(va)) {
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
