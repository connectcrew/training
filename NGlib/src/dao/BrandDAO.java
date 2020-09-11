package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Brand;

public class BrandDAO {
	//===***** Information for connect DB *****===//
		private final String DB_url  = "jdbc:mysql://localhost/novelgame?serverTimezone=JST&useSSL=false";
		private final String DB_user = "root";
		private final String DB_pass = "connectcrew";
		private final String driver  = "com.mysql.cj.jdbc.Driver";
		Connection con;
		Statement stmt;
		PreparedStatement ps;
		ResultSet rs;
		private final String brInfoQry =
				("SELECT brand.id AS br_id, br_name, company.id AS co_id, co_name, product_info.id AS pi_id, title "
				+ "FROM brand "
				+ "JOIN product_info ON brand.id = product_info.br_id "
				+ "JOIN company ON brand.co_id = company.id "
				+ "WHERE br_id = ? "
				+ "ORDER BY release_date DESC "
				+ "LIMIT 3;");

		private final String brListQry = ("SELECT brand.id AS br_id, br_name, company.id AS co_id, co_name, COUNT(br_name) FROM brand "
				+ "JOIN company ON brand.co_id=company.id "
				+ "JOIN product_info ON brand.id = product_info.br_id "
				+ "WHERE br_name LIKE ? "
				+ "GROUP BY br_name "
				+ "ORDER BY COUNT(br_name) DESC "
				+ "LIMIT 20 OFFSET ?;");

		private final String selectBrListQry = ("SELECT brand.id AS br_id, br_name, company.id AS co_id, co_name, COUNT(br_name) FROM brand "
				+ "JOIN company ON brand.co_id=company.id "
				+ "JOIN product_info ON brand.id = product_info.br_id "
				+ "GROUP BY br_name "
				+ "ORDER BY COUNT(br_name) DESC;");


		public List<Brand> brInfo(String searchId){
			System.out.println("*** Enter List<Brand> brInfo");
			List<Brand> brInfo = new ArrayList<>();

			try {
				System.out.println("** Connection to DB");
				Class.forName(driver);
				con = DriverManager.getConnection(DB_url, DB_user, DB_pass);

				System.out.println("** Prepare SQL / Received ID = " + searchId);
				ps = con.prepareStatement(brInfoQry);
				ps.setString(1, searchId);

				System.out.println("** Query SQL");
				rs = ps.executeQuery();

				System.out.println("** Making information list");
				while (rs.next()) {
					String brId = rs.getString("br_id");
					String brName = rs.getString("br_name");
					String coId = rs.getString("co_id");
					String coName = rs.getString("co_name");
					String piId = rs.getString("pi_id");
					String title = rs.getString("title");

					Brand brand = new Brand(brId, brName, coId, coName, piId, title);
					brInfo.add(brand);
				}
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
				return null;
			}catch(ClassNotFoundException e){
				System.out.println("ドライバーエラーです。");
				e.printStackTrace();
			}
			System.out.println("*** Succeed making information list\n" + brInfo);
			return brInfo;
		}

		public List<Brand> brList(String searchName, int searchPage) {
			System.out.println("*** Enter List<Brand> brList");
			List<Brand> brList = new ArrayList<>();


			try {
				// Start connection to DB
				System.out.println("*** Connection to DB");
				Class.forName(driver);
				con = DriverManager.getConnection(DB_url, DB_user, DB_pass);


				// Prepare SQL
				System.out.println("*** Prepare SQL");
				ps = con.prepareStatement(brListQry);
				ps.setString(1, searchName);
				ps.setInt(2, searchPage);

				// Query SQL
				System.out.println("*** Query SQL");
				rs = ps.executeQuery();

				while (rs.next()) {
					String brId = rs.getString("br_id");
					String brName = rs.getString("br_name");
					String coId = rs.getString("co_id");
					String coName = rs.getString("co_name");
					String count = rs.getString("count(br_name)");

					Brand br = new Brand(brId, brName, coId, coName, count);
					brList.add(br);
				}
				con.close();
			} catch(final SQLException e) {
				e.printStackTrace();
				return null;
			} catch (final ClassNotFoundException e) {
				System.out.println("ドライバーエラーです。");
				e.printStackTrace();
			}
		System.out.println("*** Succeed making information list\n" + brList);
		return brList;
		}

		public List<Brand> brSelectList() {
			System.out.println("*** Enter List<Brand> brList");
			List<Brand> brList = new ArrayList<>();


			try {
				// Start connection to DB
				System.out.println("*** Connection to DB");
				Class.forName(driver);
				con = DriverManager.getConnection(DB_url, DB_user, DB_pass);


				// Prepare SQL
				System.out.println("*** Prepare SQL");
				ps = con.prepareStatement(selectBrListQry);

				// Query SQL
				System.out.println("*** Query SQL");
				rs = ps.executeQuery();

				while (rs.next()) {
					String brId = rs.getString("br_id");
					String brName = rs.getString("br_name");
					String coId = rs.getString("co_id");
					String coName = rs.getString("co_name");
					String count = rs.getString("count(br_name)");

					Brand br = new Brand(brId, brName, coId, coName, count);
					brList.add(br);
				}
				con.close();
			} catch(final SQLException e) {
				e.printStackTrace();
				return null;
			} catch (final ClassNotFoundException e) {
				System.out.println("ドライバーエラーです。");
				e.printStackTrace();
			}
		System.out.println("*** Succeed making information list\n" + brList);
		return brList;
		}
}
