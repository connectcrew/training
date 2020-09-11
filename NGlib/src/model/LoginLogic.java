package model;

import dao.LoginDAO;

public class LoginLogic {
	public String execute(Administer admin) {
		System.out.println("*** Enter LoginLogic");
		LoginDAO dao = new LoginDAO();
		String adminName = dao.adminName(admin);
		return adminName;
	}
}
