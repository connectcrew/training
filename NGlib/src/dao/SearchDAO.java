package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Year;

public class SearchDAO {
	//===***** Information for connect DB *****===//
		private final String DB_url  = "jdbc:mysql://localhost/novelgame?serverTimezone=JST&useSSL=false";
		private final String DB_user = "root";
		private final String DB_pass = "connectcrew";
		private final String driver  = "com.mysql.cj.jdbc.Driver";
		Connection con;
		Statement stmt;
		PreparedStatement ps;
		ResultSet rs;
		private final String yearListQry = ("SELECT YEAR(release_date) AS year "
										+ "FROM product_info "
										+ "GROUP BY YEAR;");

		private final String pagePiQry =("SELECT COUNT(*)/20 AS page "
				+ "FROM product_info "
				+ "JOIN brand ON product_info.br_id=brand.id "
				+ "WHERE title LIKE ? "
				+ "AND br_name LIKE ? "
				+ "AND release_date LIKE ? ;");

		private final String pageSeriesQry = ("SELECT COUNT(*)/20 AS page "
				+ "FROM product_info "
				+ "WHERE series IS NOT null "
				+ "AND series LIKE ? ");

		private final String pageCoQry = ("SELECT COUNT(*)/20 AS page "
				+ "FROM company "
				+ "WHERE co_name LIKE ? ;");

		private final String pageBrQry = ("SELECT COUNT(*)/20 AS page "
				+ "FROM brand "
				+ "WHERE br_name LIKE ? ;");

		private final String pagePrQry = ("SELECT COUNT(*)/20 AS page "
				+ "FROM producer "
				+ "WHERE pr_name LIKE ? ;");

		private final String pageSWQry = ("SELECT COUNT(*)/20 AS page "
				+ "FROM scenario_writer "
				+ "WHERE sc_name LIKE ? ;");

		private final String pageIlQry = ("SELECT COUNT(*)/20 AS page "
				+ "FROM illustrator "
				+ "WHERE il_name LIKE ? ;");

		private final String pageGCQry = ("SELECT COUNT(*)/20 AS page "
				+ "FROM graphic_creator "
				+ "WHERE gc_name LIKE ? ;");

		private final String pageSCQry = ("SELECT COUNT(*)/20 AS page "
				+ "FROM sound_creator "
				+ "WHERE sc_name LIKE ? ;");

		private final String pageVAQry = ("SELECT COUNT(*)/20 AS page "
				+ "FROM voice_actor "
				+ "WHERE va_name LIKE ? ;");

		private final String pageAVQry = ("SELECT COUNT(*)/20 AS page "
				+ "FROM animation_VA "
				+ "WHERE av_name LIKE ? ;");

		private final String pageEngineQry = ("SELECT COUNT(*)/20 AS page "
				+ "FROM product_info "
				+ "WHERE engine IS NOT null "
				+ "AND engine LIKE ? ");

		public List<Year> yearList() {
			System.out.println("*** Enter List<Year> yearList");
			List<Year> yearList = new ArrayList<>();


			try {
				// Start connection to DB
				System.out.println("*** Connection to DB");
				Class.forName(driver);
				con = DriverManager.getConnection(DB_url, DB_user, DB_pass);


				// Prepare SQL
				System.out.println("*** Prepare SQL");
				ps = con.prepareStatement(yearListQry);

				// Query SQL
				System.out.println("*** Query SQL");
				rs = ps.executeQuery();

				while (rs.next()) {
					String year = rs.getString("year");

					Year ye = new Year(year);
					yearList.add(ye);
				}
				con.close();
			} catch(final SQLException e) {
				e.printStackTrace();
				return null;
			} catch (final ClassNotFoundException e) {
				System.out.println("ドライバーエラーです。");
				e.printStackTrace();
			}
		System.out.println("*** Succeed making information list\n" + yearList);
		return yearList;
		}

		public int pagePi(String searchName, String searchBrand, String searchDate){
			System.out.println("*** Enter pageNum");
			double number = 0;
			int pageNumber = 0;

			try {
				System.out.println("** Connection to DB");
				Class.forName(driver);
				con = DriverManager.getConnection(DB_url, DB_user, DB_pass);

				ps = con.prepareStatement(pagePiQry);
				ps.setString(1, searchName);
				ps.setString(2, searchBrand);
				ps.setString(3, searchDate);

				System.out.println("** Query SQL");
				rs = ps.executeQuery();

				System.out.println("** Making information list");
				while (rs.next()) {
					number = rs.getDouble("page");
					if(number - (int)number != 0) {
						pageNumber = ((int)number + 1);
					} else {
						pageNumber = (int)number;
					}
				}
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
				return 0;
			}catch(ClassNotFoundException e){
				System.out.println("ドライバーエラーです。");
				e.printStackTrace();
			}
			System.out.println("*** Succeed max page = " + pageNumber);
			return pageNumber;
		}

		public int pageSeries(String searchName){
			System.out.println("*** Enter pageNum(String)");
			double number = 0;
			int pageNumber = 0;

			try {
				System.out.println("** Connection to DB");
				Class.forName(driver);
				con = DriverManager.getConnection(DB_url, DB_user, DB_pass);

				ps = con.prepareStatement(pageSeriesQry);
				ps.setString(1, searchName);

				System.out.println("** Query SQL");
				rs = ps.executeQuery();


				System.out.println("** Making information list");
				while (rs.next()) {
					number = rs.getDouble("page");
					if(number - (int)number != 0) {
						pageNumber = ((int)number + 1);
					} else {
						pageNumber = (int)number;
					}
				}
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
				return 0;
			}catch(ClassNotFoundException e){
				System.out.println("ドライバーエラーです。");
				e.printStackTrace();
			}
			System.out.println("*** Succeed max page = " + pageNumber);
			return pageNumber;
		}

		public int pageCo(String searchName){
			System.out.println("*** Enter pageNum");
			double number = 0;
			int pageNumber = 0;

			try {
				System.out.println("** Connection to DB");
				Class.forName(driver);
				con = DriverManager.getConnection(DB_url, DB_user, DB_pass);

				ps = con.prepareStatement(pageCoQry);
				ps.setString(1, searchName);

				System.out.println("** Query SQL");
				rs = ps.executeQuery();

				System.out.println("** Making information list");
				while (rs.next()) {
					number = rs.getDouble("page");
					if(number - (int)number != 0) {
						pageNumber = ((int)number + 1);
					} else {
						pageNumber = (int)number;
					}
				}
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
				return 0;
			}catch(ClassNotFoundException e){
				System.out.println("ドライバーエラーです。");
				e.printStackTrace();
			}
			System.out.println("*** Succeed max page = " + pageNumber);
			return pageNumber;
		}

		public int pageBr(String searchName){
			System.out.println("*** Enter pageNum(String)");
			double number = 0;
			int pageNumber = 0;

			try {
				System.out.println("** Connection to DB");
				Class.forName(driver);
				con = DriverManager.getConnection(DB_url, DB_user, DB_pass);

				ps = con.prepareStatement(pageBrQry);
				ps.setString(1, searchName);
				System.out.println("** Query SQL");
				rs = ps.executeQuery();


				System.out.println("** Making information list");
				while (rs.next()) {
					number = rs.getDouble("page");
					if(number - (int)number != 0) {
						pageNumber = ((int)number + 1);
					} else {
						pageNumber = (int)number;
					}
				}
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
				return 0;
			}catch(ClassNotFoundException e){
				System.out.println("ドライバーエラーです。");
				e.printStackTrace();
			}
			System.out.println("*** Succeed max page = " + pageNumber);
			return pageNumber;
		}

		public int pagePr(String searchName){
			System.out.println("*** Enter pageNum");
			double number = 0;
			int pageNumber = 0;

			try {
				System.out.println("** Connection to DB");
				Class.forName(driver);
				con = DriverManager.getConnection(DB_url, DB_user, DB_pass);

				ps = con.prepareStatement(pagePrQry);
				ps.setString(1, searchName);

				System.out.println("** Query SQL");
				rs = ps.executeQuery();

				System.out.println("** Making information list");
				while (rs.next()) {
					number = rs.getDouble("page");
					if(number - (int)number != 0) {
						pageNumber = ((int)number + 1);
					} else {
						pageNumber = (int)number;
					}
				}
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
				return 0;
			}catch(ClassNotFoundException e){
				System.out.println("ドライバーエラーです。");
				e.printStackTrace();
			}
			System.out.println("*** Succeed max page = " + pageNumber);
			return pageNumber;
		}

		public int pageSW(String searchName){
			System.out.println("*** Enter pageNum(String)");
			double number = 0;
			int pageNumber = 0;

			try {
				System.out.println("** Connection to DB");
				Class.forName(driver);
				con = DriverManager.getConnection(DB_url, DB_user, DB_pass);

				ps = con.prepareStatement(pageSWQry);
				ps.setString(1, searchName);

				System.out.println("** Query SQL");
				rs = ps.executeQuery();


				System.out.println("** Making information list");
				while (rs.next()) {
					number = rs.getDouble("page");
					if(number - (int)number != 0) {
						pageNumber = ((int)number + 1);
					} else {
						pageNumber = (int)number;
					}
				}
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
				return 0;
			}catch(ClassNotFoundException e){
				System.out.println("ドライバーエラーです。");
				e.printStackTrace();
			}
			System.out.println("*** Succeed max page = " + pageNumber);
			return pageNumber;
		}

		public int pageIl(String searchName){
			System.out.println("*** Enter pageNum");
			double number = 0;
			int pageNumber = 0;

			try {
				System.out.println("** Connection to DB");
				Class.forName(driver);
				con = DriverManager.getConnection(DB_url, DB_user, DB_pass);

				ps = con.prepareStatement(pageIlQry);
				ps.setString(1, searchName);

				System.out.println("** Query SQL");
				rs = ps.executeQuery();

				System.out.println("** Making information list");
				while (rs.next()) {
					number = rs.getDouble("page");
					if(number - (int)number != 0) {
						pageNumber = ((int)number + 1);
					} else {
						pageNumber = (int)number;
					}
				}
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
				return 0;
			}catch(ClassNotFoundException e){
				System.out.println("ドライバーエラーです。");
				e.printStackTrace();
			}
			System.out.println("*** Succeed max page = " + pageNumber);
			return pageNumber;
		}

		public int pageGC(String searchName){
			System.out.println("*** Enter pageNum(String)");
			double number = 0;
			int pageNumber = 0;

			try {
				System.out.println("** Connection to DB");
				Class.forName(driver);
				con = DriverManager.getConnection(DB_url, DB_user, DB_pass);

				ps = con.prepareStatement(pageGCQry);
				ps.setString(1, searchName);

				System.out.println("** Query SQL");
				rs = ps.executeQuery();


				System.out.println("** Making information list");
				while (rs.next()) {
					number = rs.getDouble("page");
					if(number - (int)number != 0) {
						pageNumber = ((int)number + 1);
					} else {
						pageNumber = (int)number;
					}
				}
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
				return 0;
			}catch(ClassNotFoundException e){
				System.out.println("ドライバーエラーです。");
				e.printStackTrace();
			}
			System.out.println("*** Succeed max page = " + pageNumber);
			return pageNumber;
		}

		public int pageSC(String searchName){
			System.out.println("*** Enter pageNum");
			double number = 0;
			int pageNumber = 0;

			try {
				System.out.println("** Connection to DB");
				Class.forName(driver);
				con = DriverManager.getConnection(DB_url, DB_user, DB_pass);

				ps = con.prepareStatement(pageSCQry);
				ps.setString(1, searchName);

				System.out.println("** Query SQL");
				rs = ps.executeQuery();

				System.out.println("** Making information list");
				while (rs.next()) {
					number = rs.getDouble("page");
					if(number - (int)number != 0) {
						pageNumber = ((int)number + 1);
					} else {
						pageNumber = (int)number;
					}
				}
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
				return 0;
			}catch(ClassNotFoundException e){
				System.out.println("ドライバーエラーです。");
				e.printStackTrace();
			}
			System.out.println("*** Succeed max page = " + pageNumber);
			return pageNumber;
		}

		public int pageVA(String searchName){
			System.out.println("*** Enter pageNum(String)");
			double number = 0;
			int pageNumber = 0;

			try {
				System.out.println("** Connection to DB");
				Class.forName(driver);
				con = DriverManager.getConnection(DB_url, DB_user, DB_pass);

				ps = con.prepareStatement(pageVAQry);
				ps.setString(1, searchName);

				System.out.println("** Query SQL");
				rs = ps.executeQuery();


				System.out.println("** Making information list");
				while (rs.next()) {
					number = rs.getDouble("page");
					if(number - (int)number != 0) {
						pageNumber = ((int)number + 1);
					} else {
						pageNumber = (int)number;
					}
				}
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
				return 0;
			}catch(ClassNotFoundException e){
				System.out.println("ドライバーエラーです。");
				e.printStackTrace();
			}
			System.out.println("*** Succeed max page = " + pageNumber);
			return pageNumber;
		}

		public int pageAV(String searchName){
			System.out.println("*** Enter pageNum");
			double number = 0;
			int pageNumber = 0;

			try {
				System.out.println("** Connection to DB");
				Class.forName(driver);
				con = DriverManager.getConnection(DB_url, DB_user, DB_pass);

				ps = con.prepareStatement(pageAVQry);
				ps.setString(1, searchName);

				System.out.println("** Query SQL");
				rs = ps.executeQuery();

				System.out.println("** Making information list");
				while (rs.next()) {
					number = rs.getDouble("page");
					if(number - (int)number != 0) {
						pageNumber = ((int)number + 1);
					} else {
						pageNumber = (int)number;
					}
				}
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
				return 0;
			}catch(ClassNotFoundException e){
				System.out.println("ドライバーエラーです。");
				e.printStackTrace();
			}
			System.out.println("*** Succeed max page = " + pageNumber);
			return pageNumber;
		}

		public int pageEngine(String searchName){
			System.out.println("*** Enter pageNum(String)");
			double number = 0;
			int pageNumber = 0;

			try {
				System.out.println("** Connection to DB");
				Class.forName(driver);
				con = DriverManager.getConnection(DB_url, DB_user, DB_pass);

				ps = con.prepareStatement(pageEngineQry);
				ps.setString(1, searchName);

				System.out.println("** Query SQL");
				rs = ps.executeQuery();


				System.out.println("** Making information list");
				while (rs.next()) {
					number = rs.getDouble("page");
					if(number - (int)number != 0) {
						pageNumber = ((int)number + 1);
					} else {
						pageNumber = (int)number;
					}
				}
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
				return 0;
			}catch(ClassNotFoundException e){
				System.out.println("ドライバーエラーです。");
				e.printStackTrace();
			}
			System.out.println("*** Succeed max page = " + pageNumber);
			return pageNumber;
		}


}
