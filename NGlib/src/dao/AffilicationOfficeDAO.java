package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.AffilicationOffice;

public class AffilicationOfficeDAO {
	//===***** Information for connect DB *****===//
		private final String DB_url  = "jdbc:mysql://localhost/novelgame?serverTimezone=JST&useSSL=false";
		private final String DB_user = "root";
		private final String DB_pass = "connectcrew";
		private final String driver  = "com.mysql.cj.jdbc.Driver";
		Connection con;
		Statement stmt;
		PreparedStatement ps;
		ResultSet rs;
		private final String aoInfoQry =
				("SELECT affilication_office.id AS ao_id, ao_name, animation_va.id AS av_id, av_name "
				+ "FROM affilication_office "
				+ "LEFT OUTER JOIN animation_va ON ao_id = affilication_office.id "
				+ "WHERE affilication_office.id = ?;");

		private final String aoListQry = ("SELECT affilication_office.id AS ao_id, ao_name, COUNT(ao_name) "
										+ "FROM affilication_office "
										+ "LEFT OUTER JOIN animation_va ON ao_id = affilication_office.id "
										+ "GROUP BY ao_name "
										+ "ORDER BY COUNT(ao_name) DESC;");

		private final String aoSelectListQry = ("SELECT id, ao_name "
										+ "FROM affilication_office "
										+ "ORDER BY id;");

		public List<AffilicationOffice> aoInfo(String searchId){
			System.out.println("*** Enter List<AffilicationOffice> aoInfo");
			List<AffilicationOffice> aoInfo = new ArrayList<>();

			try {
				System.out.println("** Connection to DB");
				Class.forName(driver);
				con = DriverManager.getConnection(DB_url, DB_user, DB_pass);

				System.out.println("** Prepare SQL / Received ID = " + searchId);
				ps = con.prepareStatement(aoInfoQry);
				ps.setString(1, searchId);

				System.out.println("** Query SQL");
				rs = ps.executeQuery();

				System.out.println("** Making information list");
				while (rs.next()) {
					String aoId = rs.getString("ao_id");
					String aoName = rs.getString("ao_name");
					String avId = rs.getString("av_id");
					String avName = rs.getString("av_name");

					AffilicationOffice ao = new AffilicationOffice(aoId, aoName, avId, avName);
					aoInfo.add(ao);
				}
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
				return null;
			}catch(ClassNotFoundException e){
				System.out.println("ドライバーエラーです。");
				e.printStackTrace();
			}
			System.out.println("*** Succeed making information list\n" + aoInfo);
			return aoInfo;
		}

		public List<AffilicationOffice> aoList() {
			System.out.println("*** Enter List<AffilicationOffice> aoList");
			List<AffilicationOffice> aoList = new ArrayList<>();


			try {
				// Start connection to DB
				System.out.println("*** Connection to DB");
				Class.forName(driver);
				con = DriverManager.getConnection(DB_url, DB_user, DB_pass);


				// Prepare SQL
				System.out.println("*** Prepare SQL");
				ps = con.prepareStatement(aoListQry);

				// Query SQL
				System.out.println("*** Query SQL");
				rs = ps.executeQuery();

				while (rs.next()) {
					String aoId = rs.getString("ao_id");
					String aoName = rs.getString("ao_name");
					String count = rs.getString("count(ao_name)");

					AffilicationOffice ao = new AffilicationOffice(aoId, aoName, count);
					aoList.add(ao);
				}
				con.close();
			} catch(final SQLException e) {
				e.printStackTrace();
				return null;
			} catch (final ClassNotFoundException e) {
				System.out.println("ドライバーエラーです。");
				e.printStackTrace();
			}
		System.out.println("*** Succeed making information list\n" + aoList);
		return aoList;
		}

		public List<AffilicationOffice> aoSelectList() {
			System.out.println("*** Enter List<AffilicationOffice> aoList");
			List<AffilicationOffice> aoList = new ArrayList<>();


			try {
				// Start connection to DB
				System.out.println("*** Connection to DB");
				Class.forName(driver);
				con = DriverManager.getConnection(DB_url, DB_user, DB_pass);


				// Prepare SQL
				System.out.println("*** Prepare SQL");
				ps = con.prepareStatement(aoSelectListQry);

				// Query SQL
				System.out.println("*** Query SQL");
				rs = ps.executeQuery();

				while (rs.next()) {
					String aoId = rs.getString("id");
					String aoName = rs.getString("ao_name");

					AffilicationOffice ao = new AffilicationOffice(aoId, aoName);
					aoList.add(ao);
				}
				con.close();
			} catch(final SQLException e) {
				e.printStackTrace();
				return null;
			} catch (final ClassNotFoundException e) {
				System.out.println("ドライバーエラーです。");
				e.printStackTrace();
			}
		System.out.println("*** Succeed making information list\n" + aoList);
		return aoList;
		}
}
