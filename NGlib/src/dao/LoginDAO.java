package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Administer;

public class LoginDAO {
	private final String DB_url  = "jdbc:mysql://localhost/novelgame?serverTimezone=JST&useSSL=false";
	private final String DB_user = "root";
	private final String DB_pass = "connectcrew";
	private final String driver  = "com.mysql.cj.jdbc.Driver";
	Connection con;
	Statement stmt;
	PreparedStatement ps;
	ResultSet rs;
	private final String login =
			("SELECT ad_name FROM administer "
					+ "WHERE ad_loginid = ? "
					+ "AND ad_pass = ?;");

	private final String adminInfoQry =
			("SELECT * FROM administer "
					+ "WHERE ad_loginid = ? "
					+ "AND ad_pass = ?;");

	public String adminName(Administer admin) {
		System.out.println("*** Enter adminName");
		String adminName = null;

		try {
			System.out.println("** Connection to DB");
			Class.forName(driver);
			con = DriverManager.getConnection(DB_url, DB_user, DB_pass);

			System.out.println("** Prepare SQL / Received ID = ");
			ps = con.prepareStatement(login);
			ps.setString(1, admin.getLoginId());
			ps.setString(2, admin.getPass());



			System.out.println("** Query SQL");
			rs = ps.executeQuery();

			System.out.println("** Making information list");
			rs.next();
			adminName = rs.getString("ad_name");

			con.close();


		}catch(SQLException e){
			e.printStackTrace();
			return null;
		}catch(ClassNotFoundException e){
			System.out.println("ドライバーエラーです。");
			e.printStackTrace();
		}
		System.out.println("*** Succeed making information list\n" + adminName);

		if (adminName == null || adminName == "") {
			return null;
		} else {
			return adminName;
		}
	}

	public List<Administer> adminInfo(Administer admin){
		System.out.println("*** Enter List<adminInfo> adminInfo");
		List<Administer> adminInfo = new ArrayList<>();

		try {
			System.out.println("** Connection to DB");
			Class.forName(driver);
			con = DriverManager.getConnection(DB_url, DB_user, DB_pass);

			System.out.println("** Prepare SQL / Received ID = ");
			ps = con.prepareStatement(adminInfoQry);
			ps.setString(1, admin.getLoginId());
			ps.setString(2, admin.getPass());

			System.out.println("** Query SQL");
			rs = ps.executeQuery();

			System.out.println("** Making information list");

			String id = rs.getString("id");
			String adminName = rs.getString("ad_name");
			String adminPass = rs.getString("ad_pass");
			String adminId = rs.getString("ad_loginid");

			Administer ad = new Administer(id, adminName, adminPass, adminId);

			adminInfo.add(ad);

			con.close();
		}catch(SQLException e){
			e.printStackTrace();
			return null;
		}catch(ClassNotFoundException e){
			System.out.println("ドライバーエラーです。");
			e.printStackTrace();
		}
		System.out.println("*** Succeed making information list\n" + adminInfo);
		return adminInfo;
	}
}
