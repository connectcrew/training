package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Engine;

public class EngineDAO {
	//===***** Information for connect DB *****===//
		private final String DB_url  = "jdbc:mysql://localhost/novelgame?serverTimezone=JST&useSSL=false";
		private final String DB_user = "root";
		private final String DB_pass = "connectcrew";
		private final String driver  = "com.mysql.cj.jdbc.Driver";
		Connection con;
		Statement stmt;
		PreparedStatement ps;
		ResultSet rs;
		private final String engineInfoQry = ("SELECT product_info.id as pi_id, title, brand.id as br_id, br_name, release_date, engine "
											+ "FROM product_info "
											+ "JOIN brand ON br_id=brand.id "
											+ "WHERE engine = ? "
											+ "ORDER BY release_date DESC;");

		private final String engineListQry = ("SELECT ENGINE, COUNT(engine) "
											+ "FROM product_info "
											+ "WHERE engine IS NOT NULL "
											+ "AND engine LIKE ? "
											+ "GROUP BY ENGINE "
											+ "ORDER BY engine "
											+ "LIMIT 20 OFFSET ?;");

		private final String engineSelectListQry = ("SELECT ENGINE, COUNT(engine) "
											+ "FROM product_info "
											+ "WHERE engine IS NOT NULL "
											+ "GROUP BY ENGINE "
											+ "ORDER BY engine;");

		public List<Engine> engineInfo(String searchId){
			System.out.println("*** Enter List<Engine> engineInfo");
			List<Engine> engineInfo = new ArrayList<>();

			try {
				System.out.println("** Connection to DB");
				Class.forName(driver);
				con = DriverManager.getConnection(DB_url, DB_user, DB_pass);

				System.out.println("** Prepare SQL / Received ID = " + searchId);
				ps = con.prepareStatement(engineInfoQry);
				ps.setString(1, searchId);

				System.out.println("** Query SQL");
				rs = ps.executeQuery();

				System.out.println("** Making information list");
				while (rs.next()) {
					String piId = rs.getString("pi_id");
					String title = rs.getString("title");
					String brId = rs.getString("br_id");
					String brName = rs.getString("br_name");
					String release = rs.getString("release_date");
					String engine = rs.getString("engine");

					Engine en = new Engine(piId, title, brId, brName, release, engine);
					engineInfo.add(en);
				}
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
				return null;
			}catch(ClassNotFoundException e){
				System.out.println("ドライバーエラーです。");
				e.printStackTrace();
			}
			System.out.println("*** Succeed making information list\n" + engineInfo);
			return engineInfo;
		}

		public List<Engine> engineList(String searchName, int searchPage) {
			System.out.println("*** Enter List<Engine> engineList");
			List<Engine> engineList = new ArrayList<>();


			try {
				// Start connection to DB
				System.out.println("*** Connection to DB");
				Class.forName(driver);
				con = DriverManager.getConnection(DB_url, DB_user, DB_pass);


				// Prepare SQL
				System.out.println("*** Prepare SQL");
				ps = con.prepareStatement(engineListQry);
				ps.setString(1, searchName);
				ps.setInt(2, searchPage);

				// Query SQL
				System.out.println("*** Query SQL");
				rs = ps.executeQuery();

				while (rs.next()) {
					String engine = rs.getString("engine");
					String count = rs.getString("count(engine)");

					Engine en = new Engine(engine, count);
					engineList.add(en);
				}
				con.close();
			} catch(final SQLException e) {
				e.printStackTrace();
				return null;
			} catch (final ClassNotFoundException e) {
				System.out.println("ドライバーエラーです。");
				e.printStackTrace();
			}
		System.out.println("*** Succeed making information list\n" + engineList);
		return engineList;
		}

		public List<Engine> engineSelectList() {
			System.out.println("*** Enter List<Engine> engineSelectList");
			List<Engine> engineList = new ArrayList<>();


			try {
				// Start connection to DB
				System.out.println("*** Connection to DB");
				Class.forName(driver);
				con = DriverManager.getConnection(DB_url, DB_user, DB_pass);


				// Prepare SQL
				System.out.println("*** Prepare SQL");
				ps = con.prepareStatement(engineSelectListQry);

				// Query SQL
				System.out.println("*** Query SQL");
				rs = ps.executeQuery();

				while (rs.next()) {
					String engine = rs.getString("engine");
					String count = rs.getString("count(engine)");

					Engine en = new Engine(engine, count);
					engineList.add(en);
				}
				con.close();
			} catch(final SQLException e) {
				e.printStackTrace();
				return null;
			} catch (final ClassNotFoundException e) {
				System.out.println("ドライバーエラーです。");
				e.printStackTrace();
			}
		System.out.println("*** Succeed making information list\n" + engineList);
		return engineList;
		}
}
