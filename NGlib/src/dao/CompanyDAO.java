package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Company;

public class CompanyDAO {
	//===***** Information for connect DB *****===//
		private final String DB_url  = "jdbc:mysql://localhost/novelgame?serverTimezone=JST&useSSL=false";
		private final String DB_user = "root";
		private final String DB_pass = "connectcrew";
		private final String driver  = "com.mysql.cj.jdbc.Driver";
		Connection con;
		PreparedStatement ps;
		ResultSet rs;
		private final String coInfoQry =
				("SELECT company.id AS co_id, co_name, co_year, co_address, brand.id AS br_id, br_name "
				+ "FROM company "
				+ "JOIN brand ON company.id = brand.co_id "
				+ "WHERE company.id = ?;");

		private final String coListQry = ("SELECT company.id AS co_id, co_name, brand.id AS br_id, br_name, COUNT(co_name) "
				+ "FROM company "
				+ "JOIN brand ON company.id=brand.co_id "
				+ "JOIN product_info ON product_info.br_id=brand.id "
				+ "WHERE co_name LIKE ? "
				+ "GROUP BY co_name "
				+ "ORDER BY COUNT(co_name) DESC "
				+ "LIMIT 20 OFFSET ?;");

		private final String coSelectListQry = ("SELECT company.id AS co_id, co_name, brand.id AS br_id, br_name, COUNT(co_name) "
				+ "FROM company "
				+ "JOIN brand ON company.id=brand.co_id "
				+ "JOIN product_info ON product_info.br_id=brand.id "
				+ "GROUP BY co_name "
				+ "ORDER BY COUNT(co_name) DESC;");

		public List<Company> coInfo(String searchId){
			System.out.println("*** Enter List<Company> coInfo");
			List<Company> coInfo = new ArrayList<>();

			try {
				System.out.println("** Connection to DB");
				Class.forName(driver);
				con = DriverManager.getConnection(DB_url, DB_user, DB_pass);

				System.out.println("** Prepare SQL / Received ID = " + searchId);
				ps = con.prepareStatement(coInfoQry);
				ps.setString(1, searchId);

				System.out.println("** Query SQL");
				rs = ps.executeQuery();

				System.out.println("** Making information list");
				while (rs.next()) {
					String coId = rs.getString("co_id");
					String coName = rs.getString("co_name");
					String year = rs.getString("co_year");
					String address = rs.getString("co_address");
					String brId = rs.getString("br_id");
					String brName = rs.getString("br_name");

					Company company = new Company(coId, coName, year, address, brId, brName);
					coInfo.add(company);
				}
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
				return null;
			}catch(ClassNotFoundException e){
				System.out.println("ドライバーエラーです。");
				e.printStackTrace();
			}
			System.out.println("*** Succeed making information list\n" + coInfo);
			return coInfo;
		}

		public List<Company> coList(String searchName, int searchPage) {
			System.out.println("*** Enter List<Company> coList");
			List<Company> coList = new ArrayList<>();

			try {
				// Start connection to DB
				System.out.println("*** Connection to DB");
				Class.forName(driver);
				con = DriverManager.getConnection(DB_url, DB_user, DB_pass);

				// Prepare SQL
				System.out.println("*** Prepare SQL");
				ps = con.prepareStatement(coListQry);
				ps.setString(1, searchName);
				ps.setInt(2, searchPage);

				// Query SQL
				System.out.println("*** Query SQL");
				rs = ps.executeQuery();

				while (rs.next()) {
					String coId = rs.getString("co_id");
					String coName = rs.getString("co_name");
					String brId = rs.getString("br_id");
					String brName = rs.getString("br_name");
					String count = rs.getString("COUNT(co_name)");

					Company co = new Company(coId, coName, brId, brName, count);
					coList.add(co);
				}
				con.close();
			} catch(final SQLException e) {
				e.printStackTrace();
				return null;
			} catch (final ClassNotFoundException e) {
				System.out.println("ドライバーエラーです。");
				e.printStackTrace();
			}
		System.out.println("*** Succeed making information list\n" + coList);
		return coList;
		}


		public List<Company> coSelectList() {
			System.out.println("*** Enter List<Company> coList");
			List<Company> coList = new ArrayList<>();

			try {
				// Start connection to DB
				System.out.println("*** Connection to DB");
				Class.forName(driver);
				con = DriverManager.getConnection(DB_url, DB_user, DB_pass);

				// Prepare SQL
				System.out.println("*** Prepare SQL");
				ps = con.prepareStatement(coSelectListQry);

				// Query SQL
				System.out.println("*** Query SQL");
				rs = ps.executeQuery();

				while (rs.next()) {
					String coId = rs.getString("co_id");
					String coName = rs.getString("co_name");
					String brId = rs.getString("br_id");
					String brName = rs.getString("br_name");
					String count = rs.getString("COUNT(co_name)");

					Company co = new Company(coId, coName, brId, brName, count);
					coList.add(co);
				}
				con.close();
			} catch(final SQLException e) {
				e.printStackTrace();
				return null;
			} catch (final ClassNotFoundException e) {
				System.out.println("ドライバーエラーです。");
				e.printStackTrace();
			}
		System.out.println("*** Succeed making information list\n" + coList);
		return coList;
		}

}
