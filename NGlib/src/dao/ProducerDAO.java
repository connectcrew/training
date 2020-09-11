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


public class ProducerDAO {
	//===***** Information for connect DB *****===//
	private final String DB_url  = "jdbc:mysql://localhost/novelgame?serverTimezone=JST&useSSL=false";
	private final String DB_user = "root";
	private final String DB_pass = "connectcrew";
	private final String driver  = "com.mysql.cj.jdbc.Driver";
	Connection con;
	Statement stmt;
	PreparedStatement ps;
	ResultSet rs;
	private final String prInfoQry = ("SELECT producer.id AS pr_id, pr_name, pr_gender, pr_place, pr_birthday, pr_blood, brand.id AS br_id, "
									+ "br_name, club.id AS cl_id, cl_name, product_info.id AS pi_id, title "
									+ "FROM producer "
									+ "LEFT JOIN brand ON producer.br_id = brand.id "
									+ "LEFT JOIN club ON cl_id = club.id "
									+ "LEFT JOIN product_pr ON producer.id = product_pr.pr_id "
									+ "JOIN product_info ON product_pr.pi_id = product_info.id "
									+ "WHERE producer.id = ? "
									+ "ORDER BY release_date DESC "
									+ "LIMIT 3;");

	private final String prListQry = ("SELECT producer.id AS pr_id, pr_name, brand.id AS br_id, br_name, club.id AS cl_id, cl_name, COUNT(pr_name) "
									+ "FROM producer "
									+ "LEFT JOIN brand ON producer.br_id=brand.id "
									+ "LEFT JOIN club ON producer.cl_id=club.id "
									+ "JOIN product_pr ON producer.id=product_pr.pr_id "
									+ "JOIN product_info ON product_pr.pi_id=product_info.id "
									+ "WHERE pr_name LIKE ? "
									+ "GROUP BY pr_name "
									+ "ORDER BY COUNT(pr_name) DESC "
									+ "LIMIT 20 OFFSET ?;");

	private final String prSelectListQry = ("SELECT producer.id AS pr_id, pr_name, brand.id AS br_id, br_name, club.id AS cl_id, cl_name, COUNT(pr_name) "
									+ "FROM producer "
									+ "LEFT JOIN brand ON producer.br_id=brand.id "
									+ "LEFT JOIN club ON producer.cl_id=club.id "
									+ "JOIN product_pr ON producer.id=product_pr.pr_id "
									+ "JOIN product_info ON product_pr.pi_id=product_info.id "
									+ "GROUP BY pr_name "
									+ "ORDER BY COUNT(pr_name) DESC;");

	public List<Creator> prInfo(String searchId) {
		System.out.println("*** Enter Class List<Creator> prInfo");
		final List<Creator> prInfo = new ArrayList<>();

		try {
			System.out.println("*** Connection to DB");
			Class.forName(driver);
			con = DriverManager.getConnection(DB_url, DB_user, DB_pass);

			System.out.println("*** Prepare SQL");
			ps = con.prepareStatement(prInfoQry);
			ps.setString(1, searchId);

			System.out.println("*** Query SQL");
			rs = ps.executeQuery();

			while (rs.next()) {
				String prId = rs.getString("pr_id");
				String name = rs.getString("pr_name");
				String gender = rs.getString("pr_gender");
				String place = rs.getString("pr_place");
				String birthday = rs.getString("pr_birthday");
				String blood = rs.getString("pr_blood");
				String brId = rs.getString("br_id");
				String brand = rs.getString("br_name");
				String clId = rs.getString("cl_id");
				String club = rs.getString("cl_name");
				String piId = rs.getString("pi_id");
				String title = rs.getString("title");
				Creator creator = new Creator(prId, name, gender, place, birthday, blood, brId, brand, clId, club, piId, title);
				prInfo.add(creator);
			}
		} catch(final SQLException e) {
			e.printStackTrace();
			return null;
		} catch (final ClassNotFoundException e) {
			System.out.println("ドライバーエラーです。");
			e.printStackTrace();
		}
	System.out.println("*** Succeed making information list\n" + prInfo);
	return prInfo;
	}

	public List<Creator> prList(String searchName, int searchPage) {
		System.out.println("*** Enter List<Creator> prList");
		List<Creator> prList = new ArrayList<>();


		try {
			// Start connection to DB
			System.out.println("*** Connection to DB");
			Class.forName(driver);
			con = DriverManager.getConnection(DB_url, DB_user, DB_pass);


			// Prepare SQL
			System.out.println("*** Prepare SQL");
			ps = con.prepareStatement(prListQry);
			ps.setString(1, searchName);
			ps.setInt(2, searchPage);

			// Query SQL
			System.out.println("*** Query SQL");
			rs = ps.executeQuery();

			while (rs.next()) {
				String prId = rs.getString("pr_id");
				String prName = rs.getString("pr_name");
				String brId = rs.getString("br_id");
				String brName = rs.getString("br_name");
				String clId = rs.getString("cl_id");
				String clName = rs.getString("cl_name");
				String count = rs.getString("count(pr_name)");

				Creator pr = new Creator(prId, prName, brId, brName, clId, clName, count);
				prList.add(pr);
			}
			con.close();
		} catch(final SQLException e) {
			e.printStackTrace();
			return null;
		} catch (final ClassNotFoundException e) {
			System.out.println("ドライバーエラーです。");
			e.printStackTrace();
		}
	System.out.println("*** Succeed making information list\n" + prList);
	return prList;
	}

	public List<Creator> prSelectList() {
		System.out.println("*** Enter List<Creator> prList");
		List<Creator> prList = new ArrayList<>();


		try {
			// Start connection to DB
			System.out.println("*** Connection to DB");
			Class.forName(driver);
			con = DriverManager.getConnection(DB_url, DB_user, DB_pass);


			// Prepare SQL
			System.out.println("*** Prepare SQL");
			ps = con.prepareStatement(prSelectListQry);

			// Query SQL
			System.out.println("*** Query SQL");
			rs = ps.executeQuery();

			while (rs.next()) {
				String prId = rs.getString("pr_id");
				String prName = rs.getString("pr_name");
				String brId = rs.getString("br_id");
				String brName = rs.getString("br_name");
				String clId = rs.getString("cl_id");
				String clName = rs.getString("cl_name");
				String count = rs.getString("count(pr_name)");

				Creator pr = new Creator(prId, prName, brId, brName, clId, clName, count);
				prList.add(pr);
			}
			con.close();
		} catch(final SQLException e) {
			e.printStackTrace();
			return null;
		} catch (final ClassNotFoundException e) {
			System.out.println("ドライバーエラーです。");
			e.printStackTrace();
		}
	System.out.println("*** Succeed making information list\n" + prList);
	return prList;
	}
}
