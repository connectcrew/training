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


public class SoundCreatorDAO {
	//===***** Information for connect DB *****===//
	private final String DB_url  = "jdbc:mysql://localhost/novelgame?serverTimezone=JST&useSSL=false";
	private final String DB_user = "root";
	private final String DB_pass = "connectcrew";
	private final String driver  = "com.mysql.cj.jdbc.Driver";
	Connection con;
	Statement stmt;
	PreparedStatement ps;
	ResultSet rs;
	private final String scInfoQry = ("SELECT sound_creator.id AS sc_id, sc_name, sc_gender, sc_place, sc_birthday, sc_blood, brand.id AS br_id, "
									+ "br_name, club.id AS cl_id, cl_name, product_info.id AS pi_id, title "
									+ "FROM sound_creator "
									+ "LEFT OUTER JOIN brand ON sound_creator.br_id = brand.id "
									+ "LEFT OUTER JOIN club ON cl_id = club.id "
									+ "LEFT OUTER JOIN product_sc ON sound_creator.id = product_sc.sc_id "
									+ "LEFT OUTER JOIN product_info ON product_sc.pi_id = product_info.id "
									+ "WHERE sound_creator.id = ? "
									+ "ORDER BY release_date DESC "
									+ "LIMIT 3;");

	private final String scListQry = ("SELECT sound_creator.id AS sc_id, sc_name, brand.id AS br_id, br_name, club.id AS cl_id, cl_name, COUNT(sc_name) "
									+ "FROM sound_creator "
									+ "LEFT JOIN brand ON sound_creator.br_id=brand.id "
									+ "LEFT JOIN club ON sound_creator.cl_id=club.id "
									+ "JOIN product_sc ON sound_creator.id=product_sc.sc_id "
									+ "JOIN product_info ON product_sc.pi_id=product_info.id "
									+ "WHERE sc_name LIKE ? "
									+ "GROUP BY sc_name "
									+ "ORDER BY COUNT(sc_name) DESC "
									+ "LIMIT 20 OFFSET ?;");

	private final String scSelectListQry = ("SELECT sound_creator.id AS sc_id, sc_name, brand.id AS br_id, br_name, club.id AS cl_id, cl_name, COUNT(sc_name) "
									+ "FROM sound_creator "
									+ "LEFT JOIN brand ON sound_creator.br_id=brand.id "
									+ "LEFT JOIN club ON sound_creator.cl_id=club.id "
									+ "JOIN product_sc ON sound_creator.id=product_sc.sc_id "
									+ "JOIN product_info ON product_sc.pi_id=product_info.id "
									+ "GROUP BY sc_name "
									+ "ORDER BY COUNT(sc_name) DESC;");

	public List<Creator> scInfo(String searchId) {
		System.out.println("*** Enter Class List<Creator> scInfo");
		final List<Creator> scInfo = new ArrayList<>();

		try {
			System.out.println("*** Connection to DB");
			Class.forName(driver);
			con = DriverManager.getConnection(DB_url, DB_user, DB_pass);

			System.out.println("*** Prepare SQL");
			ps = con.prepareStatement(scInfoQry);
			ps.setString(1, searchId);

			System.out.println("*** Query SQL");
			rs = ps.executeQuery();

			while (rs.next()) {
				String scId = rs.getString("sc_id");
				String name = rs.getString("sc_name");
				String gender = rs.getString("sc_gender");
				String place = rs.getString("sc_place");
				String birthday = rs.getString("sc_birthday");
				String blood = rs.getString("sc_blood");
				String brId = rs.getString("br_id");
				String brand = rs.getString("br_name");
				String clId = rs.getString("cl_id");
				String club = rs.getString("cl_name");
				String piId = rs.getString("pi_id");
				String title = rs.getString("title");
				Creator creator = new Creator(scId, name, gender, place, birthday, blood, brId, brand, clId, club, piId, title);
				scInfo.add(creator);
			}
		} catch(final SQLException e) {
			e.printStackTrace();
			return null;
		} catch (final ClassNotFoundException e) {
			System.out.println("ドライバーエラーです。");
			e.printStackTrace();
		}
	System.out.println("*** Succeed making information list\n" + scInfo);
	return scInfo;
	}

	public List<Creator> scList(String searchName, int searchPage) {
		System.out.println("*** Enter List<Creator> scList");
		List<Creator> scList = new ArrayList<>();


		try {
			// Start connection to DB
			System.out.println("*** Connection to DB");
			Class.forName(driver);
			con = DriverManager.getConnection(DB_url, DB_user, DB_pass);


			// Prepare SQL
			System.out.println("*** Prepare SQL");
			ps = con.prepareStatement(scListQry);
			ps.setString(1, searchName);
			ps.setInt(2, searchPage);

			// Query SQL
			System.out.println("*** Query SQL");
			rs = ps.executeQuery();

			while (rs.next()) {
				String scId = rs.getString("sc_id");
				String scName = rs.getString("sc_name");
				String brId = rs.getString("br_id");
				String brName = rs.getString("br_name");
				String clId = rs.getString("cl_id");
				String clName = rs.getString("cl_name");
				String count = rs.getString("count(sc_name)");

				Creator sc = new Creator(scId, scName, brId, brName, clId, clName, count);
				scList.add(sc);
			}
			con.close();
		} catch(final SQLException e) {
			e.printStackTrace();
			return null;
		} catch (final ClassNotFoundException e) {
			System.out.println("ドライバーエラーです。");
			e.printStackTrace();
		}
	System.out.println("*** Succeed making information list\n" + scList);
	return scList;
	}

	public List<Creator> scSelectList() {
		System.out.println("*** Enter List<Creator> scList");
		List<Creator> scList = new ArrayList<>();


		try {
			// Start connection to DB
			System.out.println("*** Connection to DB");
			Class.forName(driver);
			con = DriverManager.getConnection(DB_url, DB_user, DB_pass);


			// Prepare SQL
			System.out.println("*** Prepare SQL");
			ps = con.prepareStatement(scSelectListQry);

			// Query SQL
			System.out.println("*** Query SQL");
			rs = ps.executeQuery();

			while (rs.next()) {
				String scId = rs.getString("sc_id");
				String scName = rs.getString("sc_name");
				String brId = rs.getString("br_id");
				String brName = rs.getString("br_name");
				String clId = rs.getString("cl_id");
				String clName = rs.getString("cl_name");
				String count = rs.getString("count(sc_name)");

				Creator sc = new Creator(scId, scName, brId, brName, clId, clName, count);
				scList.add(sc);
			}
			con.close();
		} catch(final SQLException e) {
			e.printStackTrace();
			return null;
		} catch (final ClassNotFoundException e) {
			System.out.println("ドライバーエラーです。");
			e.printStackTrace();
		}
	System.out.println("*** Succeed making information list\n" + scList);
	return scList;
	}
}
