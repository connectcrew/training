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
import model.AnimationVA;


public class AnimationVADAO {
	//===***** Information for connect DB *****===//
	private final String DB_url  = "jdbc:mysql://localhost/novelgame?serverTimezone=JST&useSSL=false";
	private final String DB_user = "root";
	private final String DB_pass = "connectcrew";
	private final String driver  = "com.mysql.cj.jdbc.Driver";
	Connection con;
	Statement stmt;
	PreparedStatement ps;
	ResultSet rs;
	private final String avInfoQry = ("SELECT animation_va.id AS av_id, av_name, av_gender, av_place, av_birthday, av_blood, av_debut, "
									+ "affilication_office.id AS ao_id, ao_name, voice_actor.id AS va_id, va_name "
									+ "FROM animation_va "
									+ "LEFT OUTER JOIN affilication_office ON ao_id = affilication_office.id "
									+ "LEFT OUTER JOIN voice_actor ON voice_actor.av_id = animation_va.id "
									+ "WHERE animation_va.id = ?;");

	private final String avListQry = ("SELECT animation_va.id AS av_id, av_name, affilication_office.id AS ao_id, ao_name, COUNT(av_name) "
									+ "FROM animation_va "
									+ "LEFT JOIN affilication_office ON ao_id = affilication_office.id "
									+ "LEFT JOIN voice_actor ON voice_actor.av_id = animation_va.id "
									+ "JOIN product_va ON voice_actor.id=product_va.va_id "
									+ "LEFT JOIN product_info ON product_va.pi_id=product_info.id "
									+ "WHERE av_name LIKE ? "
									+ "GROUP BY av_name "
									+ "ORDER BY COUNT(av_name) DESC "
									+ "LIMIT 20 OFFSET ?;");

	private final String avSelectListQry = ("SELECT id AS av_id, av_name "
									+ "FROM animation_va "
									+ "ORDER BY id;");

	public List<AnimationVA> avInfo(String searchId) {
		System.out.println("*** Enter Class List<AnimationVA> avInfo");
		final List<AnimationVA> avInfo = new ArrayList<>();

		try {
			System.out.println("*** Connection to DB");
			Class.forName(driver);
			con = DriverManager.getConnection(DB_url, DB_user, DB_pass);

			System.out.println("*** Prepare SQL");
			ps = con.prepareStatement(avInfoQry);
			ps.setString(1, searchId);

			System.out.println("*** Query SQL");
			rs = ps.executeQuery();

			while (rs.next()) {
				String avId = rs.getString("av_id");
				String avName = rs.getString("av_name");
				String gender = rs.getString("av_gender");
				String place = rs.getString("av_place");
				String birthday = rs.getString("av_birthday");
				String blood = rs.getString("av_blood");
				String debut = rs.getString("av_debut");
				String aoId = rs.getString("ao_id");
				String aoName = rs.getString("ao_name");
				String vaId = rs.getString("va_id");
				String vaName = rs.getString("va_name");
				AnimationVA av = new AnimationVA(avId, avName, gender, place, birthday, blood, debut, aoId, aoName, vaId, vaName);
				avInfo.add(av);
			}
		} catch(final SQLException e) {
			e.printStackTrace();
			return null;
		} catch (final ClassNotFoundException e) {
			System.out.println("ドライバーエラーです。");
			e.printStackTrace();
		}
	System.out.println("*** Succeed making information list\n" + avInfo);
	return avInfo;
	}

	public List<AnimationVA> avList(String searchName, int searchPage) {
		System.out.println("*** Enter List<AnimationVA> avList");
		List<AnimationVA> avList = new ArrayList<>();


		try {
			// Start connection to DB
			System.out.println("*** Connection to DB");
			Class.forName(driver);
			con = DriverManager.getConnection(DB_url, DB_user, DB_pass);


			// Prepare SQL
			System.out.println("*** Prepare SQL");
			ps = con.prepareStatement(avListQry);
			ps.setString(1, searchName);
			ps.setInt(2, searchPage);

			// Query SQL
			System.out.println("*** Query SQL");
			rs = ps.executeQuery();

			while (rs.next()) {
				String avId = rs.getString("av_id");
				String avName = rs.getString("av_name");
				String aoId = rs.getString("ao_id");
				String aoName = rs.getString("ao_name");
				String count = rs.getString("count(av_name)");

				AnimationVA av = new AnimationVA(avId, avName, aoId, aoName, count);
				avList.add(av);
			}
			con.close();
		} catch(final SQLException e) {
			e.printStackTrace();
			return null;
		} catch (final ClassNotFoundException e) {
			System.out.println("ドライバーエラーです。");
			e.printStackTrace();
		}
	System.out.println("*** Succeed making information list\n" + avList);
	return avList;
	}


	public List<AnimationVA> avSelectList() {
		System.out.println("*** Enter avSelectList");
		List<AnimationVA> avList = new ArrayList<>();


		try {
			// Start connection to DB
			System.out.println("*** Connection to DB");
			Class.forName(driver);
			con = DriverManager.getConnection(DB_url, DB_user, DB_pass);


			// Prepare SQL
			System.out.println("*** Prepare SQL");
			ps = con.prepareStatement(avSelectListQry);

			// Query SQL
			System.out.println("*** Query SQL");
			rs = ps.executeQuery();

			while (rs.next()) {
				String avId = rs.getString("av_id");
				String avName = rs.getString("av_name");

				AnimationVA av = new AnimationVA(avId, avName);
				avList.add(av);
			}
			con.close();
		} catch(final SQLException e) {
			e.printStackTrace();
			return null;
		} catch (final ClassNotFoundException e) {
			System.out.println("ドライバーエラーです。");
			e.printStackTrace();
		}
	System.out.println("*** Succeed making information list\n" + avList);
	return avList;
	}
}
