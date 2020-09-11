package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Prefectures;

public class PrefecturesDAO {
	//===***** Information for connect DB *****===//
		private final String DB_url  = "jdbc:mysql://localhost/utility?serverTimezone=JST&useSSL=false";
		private final String DB_user = "root";
		private final String DB_pass = "connectcrew";
		private final String driver  = "com.mysql.cj.jdbc.Driver";
		Connection con;
		Statement stmt;
		PreparedStatement ps;
		ResultSet rs;
		private final String prefecturesQry = ("SELECT * FROM prefectures ORDER BY id;");


		public List<Prefectures> prefectures(){
			System.out.println("*** Enter PrefecturesDAO");
			List<Prefectures> prefecturesList = new ArrayList<>();
			int x = 0;
			try {
				System.out.println("** Connection to DB");
				Class.forName(driver);
				con = DriverManager.getConnection(DB_url, DB_user, DB_pass);

				System.out.println("** Prepare SQL");
				ps = con.prepareStatement(prefecturesQry);

				System.out.println("** Query SQL");
				rs = ps.executeQuery();

				System.out.println("** Making Prefecture List...");

				while (rs.next()) {
					String id = rs.getString("id");
					String prefecture = rs.getString("prefecture");

					Prefectures prefectures = new Prefectures(id, prefecture);
					prefecturesList.add(prefectures);
					x++;
				}
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
				return null;
			}catch(ClassNotFoundException e){
				System.out.println("ドライバーエラーです。");
				e.printStackTrace();
			}
			System.out.printf("*** Succeed! Loop %d times.\n", x);
			return prefecturesList;
		}
}
