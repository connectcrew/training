package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Club;

public class ClubDAO {
	private final String DB_url  = "jdbc:mysql://localhost/novelgame?serverTimezone=JST&useSSL=false";
	private final String DB_user = "root";
	private final String DB_pass = "connectcrew";
	private final String driver  = "com.mysql.cj.jdbc.Driver";
	Connection con;
	PreparedStatement ps;
	ResultSet rs;

	private final String clListQry = ("SELECT id, cl_name FROM club ORDER BY id LIMIT 20 OFFSET ?;");


	private final String clSelectListQry = ("SELECT id, cl_name FROM club ORDER BY id ;");

	public List<Club> clList(String searchName, int searchPage){
		System.out.println("*** Enter clList");
		List<Club> clList = new ArrayList<>();

		try {
			System.out.println("** Connection to DB");
			Class.forName(driver);
			con = DriverManager.getConnection(DB_url, DB_user, DB_pass);

			System.out.println("** Prepare SQL");
			ps = con.prepareStatement(clListQry);
			ps.setString(1, searchName);
			ps.setInt(2, searchPage);

			System.out.println("** Query SQL");
			rs = ps.executeQuery();

			System.out.println("** Making information list");
			while (rs.next()) {
				String clId = rs.getString("id");
				String clName = rs.getString("cl_name");

				Club club= new Club(clId, clName);
				clList.add(club);
			}
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
			return null;
		}catch(ClassNotFoundException e){
			System.out.println("ドライバーエラーです。");
			e.printStackTrace();
		}
		System.out.println("*** Succeed making information list");
		return clList;
	}

	public List<Club> clSelectList(){
		System.out.println("*** Enter clList");
		List<Club> clList = new ArrayList<>();

		try {
			System.out.println("** Connection to DB");
			Class.forName(driver);
			con = DriverManager.getConnection(DB_url, DB_user, DB_pass);

			System.out.println("** Prepare SQL");
			ps = con.prepareStatement(clSelectListQry);

			System.out.println("** Query SQL");
			rs = ps.executeQuery();

			System.out.println("** Making information list");
			while (rs.next()) {
				String clId = rs.getString("id");
				String clName = rs.getString("cl_name");

				Club club= new Club(clId, clName);
				clList.add(club);
			}
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
			return null;
		}catch(ClassNotFoundException e){
			System.out.println("ドライバーエラーです。");
			e.printStackTrace();
		}
		System.out.println("*** Succeed making information list");
		return clList;
	}


}
