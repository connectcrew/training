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

import model.VoiceActor;


public class VoiceActorDAO {
	//===***** Information for connect DB *****===//
	private final String DB_url  = "jdbc:mysql://localhost/novelgame?serverTimezone=JST&useSSL=false";
	private final String DB_user = "root";
	private final String DB_pass = "connectcrew";
	private final String driver  = "com.mysql.cj.jdbc.Driver";
	Connection con;
	Statement stmt;
	PreparedStatement ps;
	ResultSet rs;
	private final String vaInfoQry = ("SELECT voice_actor.id AS va_id, va_name, animation_va.id AS av_id, av_name, va_gender, va_place, va_birthday, "
									+ "va_blood, va_debut, product_info.id AS pi_id, title "
									+ "FROM voice_actor "
									+ "left outer JOIN animation_va ON av_id = animation_va.id "
									+ "left outer JOIN product_va ON voice_actor.id = product_va.va_id "
									+ "left outer JOIN product_info ON product_va.pi_id = product_info.id "
									+ "WHERE voice_actor.id = ? "
									+ "ORDER BY release_date DESC "
									+ "LIMIT 3;");

	private final String vaListQry = ("SELECT voice_actor.id AS va_id, va_name, animation_va.id AS av_id, av_name, COUNT(va_name) "
									+ "FROM voice_actor "
									+ "LEFT OUTER JOIN animation_va ON av_id = animation_va.id "
									+ "JOIN product_va ON voice_actor.id = product_va.va_id "
									+ "LEFT OUTER JOIN product_info ON product_va.pi_id = product_info.id "
									+ "WHERE va_name LIKE ? "
									+ "GROUP BY va_name "
									+ "ORDER BY COUNT(va_name) DESC "
									+ "LIMIT 20 OFFSET ?;");

	private final String vaSelectListQry = ("SELECT voice_actor.id AS va_id, va_name, animation_va.id AS av_id, av_name, COUNT(va_name) "
									+ "FROM voice_actor "
									+ "LEFT OUTER JOIN animation_va ON av_id = animation_va.id "
									+ "JOIN product_va ON voice_actor.id = product_va.va_id "
									+ "LEFT OUTER JOIN product_info ON product_va.pi_id = product_info.id "
									+ "GROUP BY va_name "
									+ "ORDER BY COUNT(va_name) DESC;");


	public List<VoiceActor> vaInfo(String searchId) {
		System.out.println("*** Enter Class List<Creator> vaInfo");
		final List<VoiceActor> vaInfo = new ArrayList<>();

		try {
			System.out.println("*** Connection to DB");
			Class.forName(driver);
			con = DriverManager.getConnection(DB_url, DB_user, DB_pass);

			System.out.println("*** Prepare SQL");
			ps = con.prepareStatement(vaInfoQry);
			ps.setString(1, searchId);

			System.out.println("*** Query SQL");
			rs = ps.executeQuery();

			while (rs.next()) {
				String vaId = rs.getString("va_id");
				String vaName = rs.getString("va_name");
				String avId = rs.getString("av_id");
				String avName = rs.getString("av_name");
				String gender = rs.getString("va_gender");
				String place = rs.getString("va_place");
				String birthday = rs.getString("va_birthday");
				String blood = rs.getString("va_blood");
				String debut = rs.getString("va_debut");
				String piId = rs.getString("pi_id");
				String title = rs.getString("title");

				VoiceActor va = new VoiceActor(vaId, vaName, avId, avName, gender, place, birthday, blood, debut, piId, title);
				vaInfo.add(va);
			}
		} catch(final SQLException e) {
			e.printStackTrace();
			return null;
		} catch (final ClassNotFoundException e) {
			System.out.println("ドライバーエラーです。");
			e.printStackTrace();
		}
	System.out.println("*** Succeed making information list\n" + vaInfo);
	return vaInfo;
	}

	public List<VoiceActor> vaList(String searchName, int searchPage) {
		System.out.println("*** Enter List<VoiceActor> vaList");
		List<VoiceActor> vaList = new ArrayList<>();


		try {
			// Start connection to DB
			System.out.println("*** Connection to DB");
			Class.forName(driver);
			con = DriverManager.getConnection(DB_url, DB_user, DB_pass);


			// Prepare SQL
			System.out.println("*** Prepare SQL");
			ps = con.prepareStatement(vaListQry);
			ps.setString(1, searchName);
			ps.setInt(2, searchPage);

			// Query SQL
			System.out.println("*** Query SQL");
			rs = ps.executeQuery();

			while (rs.next()) {
				String vaId = rs.getString("va_id");
				String vaName = rs.getString("va_name");
				String avId = rs.getString("av_id");
				String avName = rs.getString("av_name");
				String count = rs.getString("count(va_name)");

				VoiceActor va = new VoiceActor(vaId, vaName, avId, avName, count);
				vaList.add(va);
			}
			con.close();
		} catch(final SQLException e) {
			e.printStackTrace();
			return null;
		} catch (final ClassNotFoundException e) {
			System.out.println("ドライバーエラーです。");
			e.printStackTrace();
		}
	System.out.println("*** Succeed making information list\n" + vaList);
	return vaList;
	}

	public List<VoiceActor> vaSelectList() {
		System.out.println("*** Enter List<VoiceActor> vaList");
		List<VoiceActor> vaList = new ArrayList<>();


		try {
			// Start connection to DB
			System.out.println("*** Connection to DB");
			Class.forName(driver);
			con = DriverManager.getConnection(DB_url, DB_user, DB_pass);


			// Prepare SQL
			System.out.println("*** Prepare SQL");
			ps = con.prepareStatement(vaSelectListQry);

			// Query SQL
			System.out.println("*** Query SQL");
			rs = ps.executeQuery();

			while (rs.next()) {
				String vaId = rs.getString("va_id");
				String vaName = rs.getString("va_name");
				String avId = rs.getString("av_id");
				String avName = rs.getString("av_name");
				String count = rs.getString("count(va_name)");

				VoiceActor va = new VoiceActor(vaId, vaName, avId, avName, count);
				vaList.add(va);
			}
			con.close();
		} catch(final SQLException e) {
			e.printStackTrace();
			return null;
		} catch (final ClassNotFoundException e) {
			System.out.println("ドライバーエラーです。");
			e.printStackTrace();
		}
	System.out.println("*** Succeed making information list\n" + vaList);
	return vaList;
	}
}
