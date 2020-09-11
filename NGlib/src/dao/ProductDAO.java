/* product_infoのページ用のDAO */
package dao;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.ProductInfo;
import model.ProductStaff;


public class ProductDAO {
	//===***** Information for connect DB *****===//
	private final String DB_url  = "jdbc:mysql://localhost/novelgame?serverTimezone=JST&useSSL=false";
	private final String DB_user = "root";
	private final String DB_pass = "connectcrew";
	private final String driver  = "com.mysql.cj.jdbc.Driver";
	Connection con;
	Statement stmt;
	PreparedStatement ps;
	ResultSet rs;
	private final String piInfoQry = ("SELECT product_info.id AS pi_id, title, brand.id AS br_id, br_name, release_date, series, engine, pi_comment, pi_text "
									  + "FROM product_info JOIN brand "
									  + "ON product_info.br_id=brand.id "
									  + "WHERE product_info.id = ?;");

	private final String partPrQry = ("SELECT producer.id, pr_name "
									+ "FROM product_info "
									+ "JOIN product_pr ON product_info.id=product_pr.pi_id "
									+ "JOIN producer ON producer.id=product_pr.pr_id "
									+ "WHERE product_info.id = ?;");

	private final String partSWQry = ("SELECT scenario_writer.id, sw_name "
									+ "FROM product_info "
									+ "JOIN product_sw ON product_info.id=product_sw.pi_id "
									+ "JOIN scenario_writer ON scenario_writer.id=product_sw.sw_id "
									+ "WHERE product_info.id = ?;");

	private final String partIlQry = ("SELECT illustrator.id, il_name "
									+ "FROM product_info "
									+ "JOIN product_il ON product_info.id=product_il.pi_id "
									+ "JOIN illustrator ON illustrator.id=product_il.il_id "
									+ "WHERE product_info.id = ?;");

	private final String partGCQry = ("SELECT graphic_creator.id, gc_name "
									+ "FROM product_info "
									+ "JOIN product_gc ON product_info.id=product_gc.pi_id "
									+ "JOIN graphic_creator ON graphic_creator.id=product_gc.gc_id "
									+ "WHERE product_info.id = ?;");

	private final String partSCQry = ("SELECT sound_creator.id, sc_name "
									+ "FROM product_info "
									+ "JOIN product_sc ON product_info.id=product_sc.pi_id "
									+ "JOIN sound_creator ON sound_creator.id=product_sc.sc_id "
									+ "WHERE product_info.id = ?;");

	private final String partVAQry = ("SELECT voice_actor.id, va_name "
									+ "FROM product_info "
									+ "JOIN product_va ON product_info.id=product_va.pi_id "
									+ "JOIN voice_actor ON voice_actor.id=product_va.va_id "
									+ "WHERE product_info.id = ?;");

	private final String piListQry = ("SELECT product_info.id AS pi_id, title, brand.id AS br_id, br_name, release_date, series, engine, pi_comment "
									  + "FROM product_info JOIN brand "
									  + "ON product_info.br_id=brand.id "
									  + "WHERE title LIKE ? "
									  + "AND br_name LIKE ? "
									  + "AND release_date LIKE ? "
									  + "ORDER BY release_date DESC "
									  + "LIMIT 20 OFFSET ?;");


	public ProductInfo piInfo(String searchId) {
		System.out.println("*** Enter piInfo");
		ProductInfo piInfo = null;


		try {
			// Start connection to DB
			System.out.println("Connection to DB");
			Class.forName(driver);
			con = DriverManager.getConnection(DB_url, DB_user, DB_pass);


			// Prepare SQL
			System.out.println("Prepare SQL / Received ID = " + searchId);
			ps = con.prepareStatement(piInfoQry);
			ps.setString(1,searchId);

			// Query SQL
			System.out.println("Query SQL");
			rs = ps.executeQuery();

			// 使用する値は回す必要がないので、このまま送ります。
			while (rs.next()) {
				String piId = rs.getString("pi_id");
				String title = rs.getString("title");
				String brId = rs.getString("br_id");
				String brand = rs.getString("br_name");
				String release = rs.getString("release_date");
				String series = rs.getString("series");
				String engine = rs.getString("engine");
				String comment = rs.getString("pi_comment");
				String text = rs.getString("pi_text");

				piInfo = new ProductInfo(piId, title, brId, brand, release, series, engine, comment, text);
			}
			con.close();
		} catch(final SQLException e) {
			e.printStackTrace();
			return null;
		} catch (final ClassNotFoundException e) {
			System.out.println("ドライバーエラーです。");
			e.printStackTrace();
		}
		System.out.println("*** Exit piInfo");
		return piInfo;
	}

	public List<ProductStaff> partPr(String searchId) {
		System.out.println("*** Enter List<Product_staff> partPr");
		final List<ProductStaff> partPr = new ArrayList<>();


		try {
			System.out.println("*** Connection to DB");
			Class.forName(driver);
			con = DriverManager.getConnection(DB_url, DB_user, DB_pass);

			System.out.println("*** Prepare SQL/ Received ID = " + searchId);
			ps = con.prepareStatement(partPrQry);
			ps.setString(1,searchId);

			System.out.println("*** Query SQL");
			rs = ps.executeQuery();

			System.out.println("*** RS into ArrayList");
			while (rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("pr_name");

				ProductStaff ps = new ProductStaff(id, name);
				partPr.add(ps);
			}
			con.close();
		} catch(final SQLException e) {
			e.printStackTrace();
			return null;
		} catch (final ClassNotFoundException e) {
			System.out.println("ドライバーエラーです。");
			e.printStackTrace();
		}
	System.out.println("*** Succeed making information list\n" + partPr);
	return partPr;
	}

	public List<ProductStaff> partSW(String searchId) {
		System.out.println("*** Enter List<Product_staff> partSW");
		final List<ProductStaff> partSW = new ArrayList<>();

		try {
			System.out.println("*** Connection to DB");
			Class.forName(driver);
			con = DriverManager.getConnection(DB_url, DB_user, DB_pass);

			System.out.println("*** Prepare SQL/ Received ID = " + searchId);
			ps = con.prepareStatement(partSWQry);
			ps.setString(1,searchId);

			System.out.println("*** Query SQL");
			rs = ps.executeQuery();

			System.out.println("*** RS into ArrayList");
			while (rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("sw_name");

				ProductStaff ps = new ProductStaff(id, name);
				partSW.add(ps);

			}
			con.close();
		}catch(final SQLException e) {
			e.printStackTrace();
			return null;
		}catch(final ClassNotFoundException e) {
			System.out.println("ドライバーエラーです。");
			e.printStackTrace();
		}
		System.out.println("*** Succeed making information list\n" + partSW);
		return partSW;
	}

	public List<ProductStaff> partIl(String searchId){
		System.out.println("*** Enter List<Product_staff> partIl");
		final List<ProductStaff> partIl = new ArrayList<>();

		try {
			System.out.println("*** Connection to DB");
			Class.forName(driver);
			con = DriverManager.getConnection(DB_url, DB_user, DB_pass);

			System.out.println("*** Prepare SQL / Received ID = " + searchId);
			ps = con.prepareStatement(partIlQry);
			ps.setString(1, searchId);

			System.out.println("*** Query SQL");
			rs = ps.executeQuery();

			System.out.println("*** RS into ArrayList");
			while (rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("il_name");

				ProductStaff ps = new ProductStaff(id, name);
				partIl.add(ps);
			}
			con.close();
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}catch(ClassNotFoundException e) {
			System.out.println("ドライバーエラーです。");
			e.printStackTrace();
		}
		System.out.println("*** Succeed making information list\n" + partIl);
		return partIl;
	}

	public List<ProductStaff> partGC(String searchId){
		System.out.println("*** Enter List<Product_staff> partGC");
		final List<ProductStaff> partGC = new ArrayList<>();

		try {
			System.out.println("*** Connection to DB");
			Class.forName(driver);
			con = DriverManager.getConnection(DB_url, DB_user, DB_pass);

			System.out.println("*** Prepare SQL / Received ID = " + searchId);
			ps = con.prepareStatement(partGCQry);
			ps.setString(1, searchId);

			System.out.println("*** Query SQL");
			rs = ps.executeQuery();

			System.out.println("*** RS into ArrayList");
			while(rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("gc_name");

				ProductStaff ps = new ProductStaff(id, name);
				partGC.add(ps);
			}
			con.close();
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}catch(ClassNotFoundException e) {
			System.out.println("ドライバーエラーです。");
			e.printStackTrace();
		}
		System.out.println("*** Succeed making information list\n" + partGC);
		return partGC;
	}

	public List<ProductStaff> partSC(String searchId){
		System.out.println("*** Enter List<Prodduct_staff> partSC");
		List<ProductStaff> partSC = new ArrayList<>();

		try {
			System.out.println("*** Connection to DB");
			Class.forName(driver);
			con = DriverManager.getConnection(DB_url, DB_user, DB_pass);

			System.out.println("*** Prepare SQL / Received ID = " + searchId);
			ps = con.prepareStatement(partSCQry);
			ps.setString(1, searchId);

			System.out.println("*** Query SQL");
			rs = ps.executeQuery();

			System.out.println("*** RS into ArrayList");
			while(rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("sc_name");

				ProductStaff ps = new ProductStaff(id, name);
				partSC.add(ps);
			}
			con.close();
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}catch(ClassNotFoundException e) {
			System.out.println("ドライバーエラーです。");
			e.printStackTrace();
		}
		System.out.println("*** Succeed making information list\n" + partSC);
		return partSC;
	}

	public List<ProductStaff> partVA(String searchId){
		System.out.println("*** Enter List<Product_staff> partVA");
		List<ProductStaff> partVA = new ArrayList<>();

		try {
			System.out.println("*** Connection to DB");
			Class.forName(driver);
			con = DriverManager.getConnection(DB_url, DB_user, DB_pass);

			System.out.println("*** Prepare SQL / Received ID = " + searchId);
			ps = con.prepareStatement(partVAQry);
			ps.setString(1, searchId);

			System.out.println("*** Query SQL");
			rs = ps.executeQuery();

			System.out.println("*** RS into ArrayList");
			while(rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("va_name");

				ProductStaff ps = new ProductStaff(id, name);
				partVA.add(ps);
			}
			con.close();
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}catch(ClassNotFoundException e) {
			System.out.println("ドライバーエラーです。");
			e.printStackTrace();
		}
		System.out.println("*** Succeed making information list\n" + partVA);
		return partVA;
	}

	public List<ProductInfo> piList(String searchName, String searchBrand, String searchDate, int searchPage) {
		System.out.println("*** Enter List<Product_info> piList");
		List<ProductInfo> piList = new ArrayList<>();


		try {
			// Start connection to DB
			System.out.println("*** Connection to DB");
			Class.forName(driver);
			con = DriverManager.getConnection(DB_url, DB_user, DB_pass);


			// Prepare SQL
			System.out.println("*** Prepare SQL");
			ps = con.prepareStatement(piListQry);
			ps.setString(1, searchName);
			ps.setString(2, searchBrand);
			ps.setString(3, searchDate);
			ps.setInt(4, searchPage);

			// Query SQL
			System.out.println("*** Query SQL");
			rs = ps.executeQuery();

			while (rs.next()) {
				String piId = rs.getString("pi_id");
				String title = rs.getString("title");
				String brId = rs.getString("br_id");
				String brand = rs.getString("br_name");
				String release = rs.getString("release_date");
				String series = rs.getString("series");
				String comment = rs.getString("pi_comment");

				ProductInfo pi = new ProductInfo(piId, title, brId, brand, release, series, comment);
				piList.add(pi);
			}
			con.close();
		} catch(final SQLException e) {
			e.printStackTrace();
			return null;
		} catch (final ClassNotFoundException e) {
			System.out.println("ドライバーエラーです。");
			e.printStackTrace();
		}
	System.out.println("*** Succeed making information list\n" + piList);
	return piList;
	}




}
