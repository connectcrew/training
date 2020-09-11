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


public class ScenarioWriterDAO {
	//===***** Information for connect DB *****===//
	private final String DB_url  = "jdbc:mysql://localhost/novelgame?serverTimezone=JST&useSSL=false";
	private final String DB_user = "root";
	private final String DB_pass = "connectcrew";
	private final String driver  = "com.mysql.cj.jdbc.Driver";
	Connection con;
	Statement stmt;
	PreparedStatement ps;
	ResultSet rs;
	private final String swInfoQry = ("SELECT scenario_writer.id AS sw_id, sw_name, sw_gender, sw_place, sw_birthday, sw_blood, brand.id AS br_id, "
									+ "br_name, club.id AS cl_id, cl_name, product_info.id AS pi_id, title "
									+ "FROM scenario_writer "
									+ "LEFT JOIN brand ON scenario_writer.br_id = brand.id "
									+ "LEFT JOIN club ON cl_id = club.id "
									+ "LEFT JOIN product_sw ON scenario_writer.id = product_sw.sw_id "
									+ "LEFT JOIN product_info ON product_sw.pi_id = product_info.id "
									+ "WHERE scenario_writer.id = ? "
									+ "ORDER BY release_date DESC "
									+ "LIMIT 3;");

	private final String swListQry = ("SELECT scenario_writer.id AS sw_id, sw_name, brand.id AS br_id, br_name, club.id AS cl_id, cl_name, COUNT(sw_name) "
									+ "FROM scenario_writer "
									+ "LEFT JOIN brand ON scenario_writer.br_id=brand.id "
									+ "LEFT JOIN club ON scenario_writer.cl_id=club.id "
									+ "JOIN product_sw ON scenario_writer.id=product_sw.sw_id "
									+ "JOIN product_info ON product_sw.pi_id=product_info.id "
									+ "WHERE sw_name LIKE ? "
									+ "GROUP BY sw_name "
									+ "ORDER BY COUNT(sw_name) DESC "
									+ "LIMIT 20 OFFSET ?;");

	private final String swSelectListQry = ("SELECT scenario_writer.id AS sw_id, sw_name, brand.id AS br_id, br_name, club.id AS cl_id, cl_name, COUNT(sw_name) "
									+ "FROM scenario_writer "
									+ "LEFT JOIN brand ON scenario_writer.br_id=brand.id "
									+ "LEFT JOIN club ON scenario_writer.cl_id=club.id "
									+ "JOIN product_sw ON scenario_writer.id=product_sw.sw_id "
									+ "JOIN product_info ON product_sw.pi_id=product_info.id "
									+ "GROUP BY sw_name "
									+ "ORDER BY COUNT(sw_name) DESC;");

	public List<Creator> swInfo(String searchId) {
		System.out.println("*** Enter Class List<Creator> swInfo");
		final List<Creator> swInfo = new ArrayList<>();

		try {
			System.out.println("*** Connection to DB");
			Class.forName(driver);
			con = DriverManager.getConnection(DB_url, DB_user, DB_pass);

			System.out.println("*** Prepare SQL");
			ps = con.prepareStatement(swInfoQry);
			ps.setString(1, searchId);

			System.out.println("*** Query SQL");
			rs = ps.executeQuery();

			while (rs.next()) {
				String swId = rs.getString("sw_id");
				String name = rs.getString("sw_name");
				String gender = rs.getString("sw_gender");
				String place = rs.getString("sw_place");
				String birthday = rs.getString("sw_birthday");
				String blood = rs.getString("sw_blood");
				String brId = rs.getString("br_id");
				String brand = rs.getString("br_name");
				String clId = rs.getString("cl_id");
				String club = rs.getString("cl_name");
				String piId = rs.getString("pi_id");
				String title = rs.getString("title");
				Creator creator = new Creator(swId, name, gender, place, birthday, blood, brId, brand, clId, club, piId, title);
				swInfo.add(creator);
			}
			con.close();
		} catch(final SQLException e) {
			e.printStackTrace();
			return null;
		} catch (final ClassNotFoundException e) {
			System.out.println("ドライバーエラーです。");
			e.printStackTrace();
		}
	System.out.println("*** Succeed making information list\n" + swInfo);
	return swInfo;
	}

	public List<Creator> swList(String searchName, int searchPage) {
		System.out.println("*** Enter List<Creator> swList");
		List<Creator> swList = new ArrayList<>();


		try {
			// Start connection to DB
			System.out.println("*** Connection to DB");
			Class.forName(driver);
			con = DriverManager.getConnection(DB_url, DB_user, DB_pass);


			// Prepare SQL
			System.out.println("*** Prepare SQL");
			ps = con.prepareStatement(swListQry);
			ps.setString(1, searchName);
			ps.setInt(2, searchPage);

			// Query SQL
			System.out.println("*** Query SQL");
			rs = ps.executeQuery();

			while (rs.next()) {
				String swId = rs.getString("sw_id");
				String swName = rs.getString("sw_name");
				String brId = rs.getString("br_id");
				String brName = rs.getString("br_name");
				String clId = rs.getString("cl_id");
				String clName = rs.getString("cl_name");
				String count = rs.getString("count(sw_name)");

				Creator sw = new Creator(swId, swName, brId, brName, clId, clName, count);
				swList.add(sw);
			}
			con.close();
		} catch(final SQLException e) {
			e.printStackTrace();
			return null;
		} catch (final ClassNotFoundException e) {
			System.out.println("ドライバーエラーです。");
			e.printStackTrace();
		}
	System.out.println("*** Succeed making information list\n" + swList);
	return swList;
	}

	public List<Creator> swSelectList() {
		System.out.println("*** Enter List<Creator> swList");
		List<Creator> swList = new ArrayList<>();


		try {
			// Start connection to DB
			System.out.println("*** Connection to DB");
			Class.forName(driver);
			con = DriverManager.getConnection(DB_url, DB_user, DB_pass);


			// Prepare SQL
			System.out.println("*** Prepare SQL");
			ps = con.prepareStatement(swSelectListQry);

			// Query SQL
			System.out.println("*** Query SQL");
			rs = ps.executeQuery();

			while (rs.next()) {
				String swId = rs.getString("sw_id");
				String swName = rs.getString("sw_name");
				String brId = rs.getString("br_id");
				String brName = rs.getString("br_name");
				String clId = rs.getString("cl_id");
				String clName = rs.getString("cl_name");
				String count = rs.getString("count(sw_name)");

				Creator sw = new Creator(swId, swName, brId, brName, clId, clName, count);
				swList.add(sw);
			}
			con.close();
		} catch(final SQLException e) {
			e.printStackTrace();
			return null;
		} catch (final ClassNotFoundException e) {
			System.out.println("ドライバーエラーです。");
			e.printStackTrace();
		}
	System.out.println("*** Succeed making information list\n" + swList);
	return swList;
	}
}
