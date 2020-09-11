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


public class GraphicCreatorDAO {
	//===***** Information for connect DB *****===//
	private final String DB_url  = "jdbc:mysql://localhost/novelgame?serverTimezone=JST&useSSL=false";
	private final String DB_user = "root";
	private final String DB_pass = "connectcrew";
	private final String driver  = "com.mysql.cj.jdbc.Driver";
	Connection con;
	Statement stmt;
	PreparedStatement ps;
	ResultSet rs;
	private final String gcInfoQry = ("SELECT graphic_creator.id AS gc_id, gc_name, gc_gender, gc_place, gc_birthday, gc_blood, brand.id AS br_id, br_name, "
									+ "club.id AS cl_id, cl_name, product_info.id AS pi_id, title "
									+ "FROM graphic_creator "
									+ "LEFT OUTER JOIN brand ON graphic_creator.br_id = brand.id "
									+ "LEFT OUTER JOIN club ON cl_id = club.id "
									+ "LEFT OUTER JOIN product_gc ON graphic_creator.id = product_gc.gc_id "
									+ "LEFT OUTER JOIN product_info ON product_gc.pi_id = product_info.id "
									+ "WHERE graphic_creator.id = ? "
									+ "ORDER BY release_date DESC "
									+ "LIMIT 3;");

	private final String gcListQry = ("SELECT graphic_creator.id AS gc_id, gc_name, brand.id AS br_id, br_name, club.id AS cl_id, cl_name, COUNT(gc_name) "
									+ "FROM graphic_creator "
									+ "LEFT JOIN brand ON graphic_creator.br_id=brand.id "
									+ "LEFT JOIN club ON graphic_creator.cl_id=club.id "
									+ "JOIN product_gc ON graphic_creator.id=product_gc.gc_id "
									+ "JOIN product_info ON product_gc.pi_id=product_info.id "
									+ "WHERE gc_name LIKE ? "
									+ "GROUP BY gc_name "
									+ "ORDER BY COUNT(gc_name) DESC "
									+ "LIMIT 20 OFFSET ?;");

	private final String gcSelectListQry = ("SELECT graphic_creator.id AS gc_id, gc_name, brand.id AS br_id, br_name, club.id AS cl_id, cl_name, COUNT(gc_name) "
									+ "FROM graphic_creator "
									+ "LEFT JOIN brand ON graphic_creator.br_id=brand.id "
									+ "LEFT JOIN club ON graphic_creator.cl_id=club.id "
									+ "JOIN product_gc ON graphic_creator.id=product_gc.gc_id "
									+ "JOIN product_info ON product_gc.pi_id=product_info.id "
									+ "GROUP BY gc_name "
									+ "ORDER BY COUNT(gc_name) DESC;");

	public List<Creator> gcInfo(String searchId) {
		System.out.println("*** Enter Class List<Creator> gcInfo");
		final List<Creator> gcInfo = new ArrayList<>();

		try {
			System.out.println("*** Connection to DB");
			Class.forName(driver);
			con = DriverManager.getConnection(DB_url, DB_user, DB_pass);

			System.out.println("*** Prepare SQL");
			ps = con.prepareStatement(gcInfoQry);
			ps.setString(1, searchId);

			System.out.println("*** Query SQL");
			rs = ps.executeQuery();

			while (rs.next()) {
				String gcId = rs.getString("gc_id");
				String name = rs.getString("gc_name");
				String gender = rs.getString("gc_gender");
				String place = rs.getString("gc_place");
				String birthday = rs.getString("gc_birthday");
				String blood = rs.getString("gc_blood");
				String brId = rs.getString("br_id");
				String brand = rs.getString("br_name");
				String clId = rs.getString("cl_id");
				String club = rs.getString("cl_name");
				String piId = rs.getString("pi_id");
				String title = rs.getString("title");
				Creator creator = new Creator(gcId, name, gender, place, birthday, blood, brId, brand, clId, club, piId, title);
				gcInfo.add(creator);
			}
			con.close();
		} catch(final SQLException e) {
			e.printStackTrace();
			return null;
		} catch (final ClassNotFoundException e) {
			System.out.println("ドライバーエラーです。");
			e.printStackTrace();
		}
	System.out.println("*** Succeed making information list\n" + gcInfo);
	return gcInfo;
	}

	public List<Creator> gcList(String searchName, int searchPage) {
		System.out.println("*** Enter List<Creator> gcList");
		List<Creator> gcList = new ArrayList<>();


		try {
			// Start connection to DB
			System.out.println("*** Connection to DB");
			Class.forName(driver);
			con = DriverManager.getConnection(DB_url, DB_user, DB_pass);


			// Prepare SQL
			System.out.println("*** Prepare SQL");
			ps = con.prepareStatement(gcListQry);
			ps.setString(1, searchName);
			ps.setInt(2, searchPage);

			// Query SQL
			System.out.println("*** Query SQL");
			rs = ps.executeQuery();

			while (rs.next()) {
				String gcId = rs.getString("gc_id");
				String gcName = rs.getString("gc_name");
				String brId = rs.getString("br_id");
				String brName = rs.getString("br_name");
				String clId = rs.getString("cl_id");
				String clName = rs.getString("cl_name");
				String count = rs.getString("count(gc_name)");

				Creator gc = new Creator(gcId, gcName, brId, brName, clId, clName, count);
				gcList.add(gc);
			}
			con.close();
		} catch(final SQLException e) {
			e.printStackTrace();
			return null;
		} catch (final ClassNotFoundException e) {
			System.out.println("ドライバーエラーです。");
			e.printStackTrace();
		}
	System.out.println("*** Succeed making information list\n" + gcList);
	return gcList;
	}

	public List<Creator> gcSelectList() {
		System.out.println("*** Enter List<Creator> gcList");
		List<Creator> gcList = new ArrayList<>();


		try {
			// Start connection to DB
			System.out.println("*** Connection to DB");
			Class.forName(driver);
			con = DriverManager.getConnection(DB_url, DB_user, DB_pass);


			// Prepare SQL
			System.out.println("*** Prepare SQL");
			ps = con.prepareStatement(gcSelectListQry);

			// Query SQL
			System.out.println("*** Query SQL");
			rs = ps.executeQuery();

			while (rs.next()) {
				String gcId = rs.getString("gc_id");
				String gcName = rs.getString("gc_name");
				String brId = rs.getString("br_id");
				String brName = rs.getString("br_name");
				String clId = rs.getString("cl_id");
				String clName = rs.getString("cl_name");
				String count = rs.getString("count(gc_name)");

				Creator gc = new Creator(gcId, gcName, brId, brName, clId, clName, count);
				gcList.add(gc);
			}
			con.close();
		} catch(final SQLException e) {
			e.printStackTrace();
			return null;
		} catch (final ClassNotFoundException e) {
			System.out.println("ドライバーエラーです。");
			e.printStackTrace();
		}
	System.out.println("*** Succeed making information list\n" + gcList);
	return gcList;
	}
}
