/* producerのinfoページ・PIの表・一覧リスト用のDAO */
package dao;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Creator;


public class IllustratorDAO {
	//===***** Information for connect DB *****===//
	private final String DB_url  = "jdbc:mysql://localhost/novelgame?serverTimezone=JST&useSSL=false";
	private final String DB_user = "root";
	private final String DB_pass = "connectcrew";
	private final String driver  = "com.mysql.cj.jdbc.Driver";
	Connection con;
	Statement stmt;
	PreparedStatement ps;
	ResultSet rs;
	private final String ilInfoQry = ("SELECT illustrator.id AS il_id, il_name, il_gender, il_place, il_birthday, il_blood, brand.id AS br_id, br_name, "
									+ "club.id AS cl_id, cl_name, product_info.id AS pi_id, title "
									+ "FROM illustrator "
									+ "LEFT OUTER JOIN brand ON illustrator.br_id = brand.id "
									+ "LEFT OUTER JOIN club ON cl_id = club.id "
									+ "LEFT OUTER JOIN product_il ON illustrator.id = product_il.il_id "
									+ "LEFT OUTER JOIN product_info ON product_il.pi_id = product_info.id "
									+ "WHERE illustrator.id = ? "
									+ "ORDER BY release_date DESC "
									+ "LIMIT 3;");

	private final String ilListQry = ("SELECT illustrator.id AS il_id, il_name, brand.id AS br_id, br_name, club.id AS cl_id, cl_name, COUNT(il_name) "
									+ "FROM illustrator "
									+ "LEFT JOIN brand ON illustrator.br_id=brand.id "
									+ "LEFT JOIN club ON illustrator.cl_id=club.id "
									+ "JOIN product_il ON illustrator.id=product_il.il_id "
									+ "JOIN product_info ON product_il.pi_id=product_info.id "
									+ "WHERE il_name LIKE ? "
									+ "GROUP BY il_name "
									+ "ORDER BY COUNT(il_name) DESC "
									+ "LIMIT 20 OFFSET ?;");

	private final String ilSelectListQry = ("SELECT illustrator.id AS il_id, il_name, brand.id AS br_id, br_name, club.id AS cl_id, cl_name, COUNT(il_name) "
									+ "FROM illustrator "
									+ "LEFT JOIN brand ON illustrator.br_id=brand.id "
									+ "LEFT JOIN club ON illustrator.cl_id=club.id "
									+ "JOIN product_il ON illustrator.id=product_il.il_id "
									+ "JOIN product_info ON product_il.pi_id=product_info.id "
									+ "GROUP BY il_name "
									+ "ORDER BY COUNT(il_name) DESC;");

	public List<Creator> ilInfo(String searchId) {
		System.out.println("*** Enter Class List<Creator> ilInfo");
		final List<Creator> ilInfo = new ArrayList<>();

		try {
			System.out.println("*** Connection to DB");
			Class.forName(driver);
			con = DriverManager.getConnection(DB_url, DB_user, DB_pass);

			System.out.println("*** Prepare SQL");
			ps = con.prepareStatement(ilInfoQry);
			ps.setString(1, searchId);

			System.out.println("*** Query SQL");
			rs = ps.executeQuery();

			while (rs.next()) {
				String ilId = rs.getString("il_id");
				String name = rs.getString("il_name");
				String gender = rs.getString("il_gender");
				String place = rs.getString("il_place");
				String birthday = rs.getString("il_birthday");
				String blood = rs.getString("il_blood");
				String brId = rs.getString("br_id");
				String brand = rs.getString("br_name");
				String clId = rs.getString("cl_id");
				String club = rs.getString("cl_name");
				String piId = rs.getString("pi_id");
				String title = rs.getString("title");
				Creator creator = new Creator(ilId, name, gender, place, birthday, blood, brId, brand, clId, club, piId, title);
				ilInfo.add(creator);
			}
			con.close();
		} catch(final SQLException e) {
			e.printStackTrace();
			return null;
		} catch (final ClassNotFoundException e) {
			System.out.println("ドライバーエラーです。");
			e.printStackTrace();
		}
	System.out.println("*** Succeed making information list\n" + ilInfo);
	return ilInfo;
	}

	public List<Creator> ilList(String searchName, int searchPage) {
		System.out.println("*** Enter List<Creator> ilList");
		List<Creator> ilList = new ArrayList<>();


		try {
			// Start connection to DB
			System.out.println("*** Connection to DB");
			Class.forName(driver);
			con = DriverManager.getConnection(DB_url, DB_user, DB_pass);


			// Prepare SQL
			System.out.println("*** Prepare SQL");
			ps = con.prepareStatement(ilListQry);
			ps.setString(1, searchName);
			ps.setInt(2, searchPage);

			// Query SQL
			System.out.println("*** Query SQL");
			rs = ps.executeQuery();

			while (rs.next()) {
				String ilId = rs.getString("il_id");
				String ilName = rs.getString("il_name");
				String brId = rs.getString("br_id");
				String brName = rs.getString("br_name");
				String clId = rs.getString("cl_id");
				String clName = rs.getString("cl_name");
				String count = rs.getString("count(il_name)");

				Creator il = new Creator(ilId, ilName, brId, brName, clId, clName, count);
				ilList.add(il);
			}
			con.close();
		} catch(final SQLException e) {
			e.printStackTrace();
			return null;
		} catch (final ClassNotFoundException e) {
			System.out.println("ドライバーエラーです。");
			e.printStackTrace();
		}
	System.out.println("*** Succeed making information list\n" + ilList);
	return ilList;
	}

	public List<Creator> ilSelectList() {
		System.out.println("*** Enter List<Creator> ilList");
		List<Creator> ilList = new ArrayList<>();


		try {
			// Start connection to DB
			System.out.println("*** Connection to DB");
			Class.forName(driver);
			con = DriverManager.getConnection(DB_url, DB_user, DB_pass);


			// Prepare SQL
			System.out.println("*** Prepare SQL");
			ps = con.prepareStatement(ilSelectListQry);

			// Query SQL
			System.out.println("*** Query SQL");
			rs = ps.executeQuery();

			while (rs.next()) {
				String ilId = rs.getString("il_id");
				String ilName = rs.getString("il_name");
				String brId = rs.getString("br_id");
				String brName = rs.getString("br_name");
				String clId = rs.getString("cl_id");
				String clName = rs.getString("cl_name");
				String count = rs.getString("count(il_name)");

				Creator il = new Creator(ilId, ilName, brId, brName, clId, clName, count);
				ilList.add(il);
			}
			con.close();
		} catch(final SQLException e) {
			e.printStackTrace();
			return null;
		} catch (final ClassNotFoundException e) {
			System.out.println("ドライバーエラーです。");
			e.printStackTrace();
		}
	System.out.println("*** Succeed making information list\n" + ilList);
	return ilList;
	}
}
