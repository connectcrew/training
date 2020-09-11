package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Series;

public class SeriesDAO {
	//===***** Information for connect DB *****===//
		private final String DB_url  = "jdbc:mysql://localhost/novelgame?serverTimezone=JST&useSSL=false";
		private final String DB_user = "root";
		private final String DB_pass = "connectcrew";
		private final String driver  = "com.mysql.cj.jdbc.Driver";
		Connection con;
		Statement stmt;
		PreparedStatement ps;
		ResultSet rs;
		private final String seriesInfoQry = ("SELECT id AS pi_id, title, release_date, series, pi_comment FROM product_info "
											+ "WHERE series = ? "
											+ "ORDER BY release_date;");

		private final String seriesListQry = ("SELECT series, COUNT(series) FROM product_info "
											+ "WHERE series IS NOT null "
											+ "AND series LIKE ? "
											+ "GROUP BY series "
											+ "ORDER BY release_date DESC "
											+ "LIMIT 20 OFFSET ?;");

		private final String seriesSelectListQry = ("SELECT series, COUNT(series) FROM product_info "
											+ "WHERE series IS NOT null "
											+ "GROUP BY series "
											+ "ORDER BY release_date DESC;");

		public List<Series> seriesInfo(String searchId) {
			System.out.println("*** Enter List<Series> seriesInfo");
			List<Series> seriesInfo = new ArrayList<>();

			try {
				System.out.println("** Connection to DB");
				Class.forName(driver);
				con = DriverManager.getConnection(DB_url, DB_user, DB_pass);

				System.out.println("** Prepare SQL / Received ID = " + searchId);
				ps = con.prepareStatement(seriesInfoQry);
				ps.setString(1, searchId);

				System.out.println("** Query SQL");
				rs = ps.executeQuery();

				System.out.println("** Making information list");
				while (rs.next()) {
					String piId = rs.getString("pi_id");
					String title = rs.getString("title");
					String release = rs.getString("release_date");
					String series = rs.getString("series");
					String comment = rs.getString("pi_comment");

					Series se = new Series(piId, title, release, series, comment);
					seriesInfo.add(se);
				}
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
				return null;
			}catch(ClassNotFoundException e){
				System.out.println("ドライバーエラーです。");
				e.printStackTrace();
			}
			System.out.println("*** Succeed making information list\n" + seriesInfo);
			return seriesInfo;
		}

		public List<Series> seriesList(String searchName, int searchPage) {
			System.out.println("*** Enter List<Series> seriesList");
			List<Series> seriesList = new ArrayList<>();


			try {
				// Start connection to DB
				System.out.println("*** Connection to DB");
				Class.forName(driver);
				con = DriverManager.getConnection(DB_url, DB_user, DB_pass);


				// Prepare SQL
				System.out.println("*** Prepare SQL");
				ps = con.prepareStatement(seriesListQry);
				ps.setString(1, searchName);
				ps.setInt(2, searchPage);

				// Query SQL
				System.out.println("*** Query SQL");
				rs = ps.executeQuery();

				while (rs.next()) {
					String series = rs.getString("series");
					String count = rs.getString("count(series)");

					Series se = new Series(series, count);
					seriesList.add(se);
				}
				con.close();
			} catch(final SQLException e) {
				e.printStackTrace();
				return null;
			} catch (final ClassNotFoundException e) {
				System.out.println("ドライバーエラーです。");
				e.printStackTrace();
			}
		System.out.println("*** Succeed making information list\n" + seriesList);
		return seriesList;
		}

		public List<Series> seriesSelectList() {
			System.out.println("*** Enter List<Series> seriesList");
			List<Series> seriesList = new ArrayList<>();


			try {
				// Start connection to DB
				System.out.println("*** Connection to DB");
				Class.forName(driver);
				con = DriverManager.getConnection(DB_url, DB_user, DB_pass);


				// Prepare SQL
				System.out.println("*** Prepare SQL");
				ps = con.prepareStatement(seriesSelectListQry);

				// Query SQL
				System.out.println("*** Query SQL");
				rs = ps.executeQuery();

				while (rs.next()) {
					String series = rs.getString("series");
					String count = rs.getString("count(series)");

					Series se = new Series(series, count);
					seriesList.add(se);
				}
				con.close();
			} catch(final SQLException e) {
				e.printStackTrace();
				return null;
			} catch (final ClassNotFoundException e) {
				System.out.println("ドライバーエラーです。");
				e.printStackTrace();
			}
		System.out.println("*** Succeed making information list\n" + seriesList);
		return seriesList;
		}
}
