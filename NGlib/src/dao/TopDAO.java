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

import model.TopBox;


public class TopDAO {
	//===***** Information for connect DB *****===//
	private final String DB_url  = "jdbc:mysql://localhost/novelgame?serverTimezone=JST&useSSL=false";
	private final String DB_user = "root";
	private final String DB_pass = "connectcrew";
	private final String driver  = "com.mysql.cj.jdbc.Driver";
	Connection con;
	Statement stmt;
	PreparedStatement ps;
	ResultSet rs;
//	private final String newerBox = ("dammy"); // DBのカラムいじる必要あり

	private final String newerBoxQry = ("SELECT product_info.id, title, change_date "
									+ "FROM product_info "
									+ "ORDER BY change_date DESC "
									+ "LIMIT 5;");

	private final String coBoxQry = ("SELECT company.id, co_name, COUNT(co_name) "
								+ "FROM product_info "
								+ "JOIN brand ON product_info.br_id=brand.id "
								+ "JOIN company ON brand.co_id=company.id "
								+ "GROUP BY co_name "
								+ "ORDER BY COUNT(co_name) DESC "
								+ "LIMIT 5;");

	private final String brBoxQry = ("SELECT brand.id, br_name, COUNT(br_name) "
								+ "FROM product_info "
								+ "JOIN brand ON product_info.br_id=brand.id "
								+ "GROUP BY br_name "
								+ "ORDER BY COUNT(br_name) DESC "
								+ "LIMIT 5;");

	private final String prBoxQry = ("SELECT producer.id, pr_name, COUNT(pr_name) "
								+ "FROM product_info "
								+ "JOIN product_pr ON product_info.id=product_pr.pi_id "
								+ "JOIN producer ON producer.id=product_pr.pr_id "
								+ "GROUP BY pr_name "
								+ "ORDER BY COUNT(pr_name) DESC "
								+ "LIMIT 5;");

	private final String swBoxQry = ("SELECT scenario_writer.id, sw_name, COUNT(sw_name) "
								+ "FROM product_info "
								+ "JOIN product_sw ON product_info.id=product_sw.pi_id "
								+ "JOIN scenario_writer ON scenario_writer.id=product_sw.sw_id "
								+ "GROUP BY sw_name "
								+ "ORDER BY COUNT(sw_name) DESC "
								+ "LIMIT 5;");

	private final String ilBoxQry = ("SELECT illustrator.id, il_name, COUNT(il_name) "
								+ "FROM product_info "
								+ "JOIN product_il ON product_info.id=product_il.pi_id "
								+ "JOIN illustrator ON illustrator.id=product_il.il_id "
								+ "GROUP BY il_name "
								+ "ORDER BY COUNT(il_name) DESC "
								+ "LIMIT 5;");

	private final String gcBoxQry = ("SELECT graphic_creator.id, gc_name, COUNT(gc_name) "
								+ "FROM product_info "
								+ "JOIN product_gc ON product_info.id=product_gc.pi_id "
								+ "JOIN graphic_creator ON graphic_creator.id=product_gc.gc_id "
								+ "GROUP BY gc_name "
								+ "ORDER BY COUNT(gc_name) DESC "
								+ "LIMIT 5;");

	private final String scBoxQry = ("SELECT sound_creator.id, sc_name, COUNT(sc_name) "
								+ "FROM product_info "
								+ "JOIN product_sc ON product_info.id=product_sc.pi_id "
								+ "JOIN sound_creator ON sound_creator.id=product_sc.sc_id "
								+ "GROUP BY sc_name "
								+ "ORDER BY COUNT(sc_name) DESC "
								+ "LIMIT 5;");

	private final String vaBoxQry = ("SELECT voice_actor.id, va_name, COUNT(va_name) "
								+ "FROM product_info "
								+ "JOIN product_va ON product_info.id=product_va.pi_id "
								+ "JOIN voice_actor ON voice_actor.id=product_va.va_id "
								+ "GROUP BY va_name "
								+ "ORDER BY COUNT(va_name) DESC "
								+ "LIMIT 5;");

	private final String avBoxQry = ("SELECT animation_va.id, av_name, COUNT(av_name) "
								+ "FROM product_info "
								+ "JOIN product_va ON product_info.id=product_va.pi_id "
								+ "JOIN voice_actor ON voice_actor.id=product_va.va_id "
								+ "JOIN animation_va ON animation_va.id=voice_actor.av_id "
								+ "GROUP BY av_name "
								+ "ORDER BY COUNT(av_name) DESC "
								+ "LIMIT 5;");

	public List<TopBox> newerBox() {
		System.out.println("*** Enter List<TopBox> coBox");
		final List<TopBox> newerBox = new ArrayList<>();

		try {
			// Start connection to DB
			System.out.println("*** Connection to DB");
			Class.forName(driver);
			con = DriverManager.getConnection(DB_url, DB_user, DB_pass);

			// Prepare SQL
			System.out.println("*** Prepare SQL");
			ps = con.prepareStatement(newerBoxQry);

			// Query SQL
			System.out.println("*** Query SQL");
			rs = ps.executeQuery();

			// 結果をArrayListに格納
			System.out.println("*** RS into ArrayList");
			while (rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("title");
				String count = rs.getString("change_date");

				TopBox newer = new TopBox(id, name, count);
				newerBox.add(newer);
			}
			con.close();
		} catch(final SQLException e) {
			e.printStackTrace();
			return null;
		} catch (final ClassNotFoundException e) {
			System.out.println("ドライバーエラーです。");
			e.printStackTrace();
		}

	System.out.println("*** Succeed making information list\n>>" + newerBox);
	return newerBox;
	}

	public List<TopBox> coBox() {
		System.out.println("*** Enter List<TopBox> coBox");
		final List<TopBox> coBox = new ArrayList<>();

		try {
			// Start connection to DB
			System.out.println("*** Connection to DB");
			Class.forName(driver);
			con = DriverManager.getConnection(DB_url, DB_user, DB_pass);

			// Prepare SQL
			System.out.println("*** Prepare SQL");
			ps = con.prepareStatement(coBoxQry);

			// Query SQL
			System.out.println("*** Query SQL");
			rs = ps.executeQuery();

			// 結果をArrayListに格納
			System.out.println("*** RS into ArrayList");
			while (rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("co_name");
				String count = rs.getString("COUNT(co_name)");

				TopBox topBox = new TopBox(id, name, count);
				coBox.add(topBox);
			}
			con.close();
		} catch(final SQLException e) {
			e.printStackTrace();
			return null;
		} catch (final ClassNotFoundException e) {
			System.out.println("ドライバーエラーです。");
			e.printStackTrace();
		}

	System.out.println("*** Succeed making information list\n>>" + coBox);
	return coBox;
	}



	public List<TopBox> brBox() {
		System.out.println("*** Enter List<TopBox> brBox");
		final List<TopBox> brBox = new ArrayList<>();

		try {
			// Start connection to DB
			System.out.println("*** Connection to DB");
			Class.forName(driver);
			con = DriverManager.getConnection(DB_url, DB_user, DB_pass);

			// Prepare SQL
			System.out.println("*** Prepare SQL");
			ps = con.prepareStatement(brBoxQry);

			// Query SQL
			System.out.println("*** Query SQL");
			rs = ps.executeQuery();

			// 結果をArrayListに格納
			System.out.println("*** RS into ArrayList");
			while (rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("br_name");
				String count = rs.getString("COUNT(br_name)");

				TopBox topBox = new TopBox(id, name, count);
				brBox.add(topBox);
			}
			con.close();
		} catch(final SQLException e) {
			e.printStackTrace();
			return null;
		} catch (final ClassNotFoundException e) {
			System.out.println("ドライバーエラーです。");
			e.printStackTrace();
		}
	System.out.println("*** Succeed making information list\n>>" + brBox);
	return brBox;
	}

	public List<TopBox> prBox() {
		System.out.println("*** Enter List<TopBox> prBox");
		final List<TopBox> prBox = new ArrayList<>();

		try {
			// Start connection to DB
			System.out.println("*** Connection to DB");
			Class.forName(driver);
			con = DriverManager.getConnection(DB_url, DB_user, DB_pass);

			// Prepare SQL
			System.out.println("*** Prepare SQL");
			ps = con.prepareStatement(prBoxQry);

			// Query SQL
			System.out.println("*** Query SQL");
			rs = ps.executeQuery();

			// 結果をArrayListに格納
			System.out.println("*** RS into ArrayList");
			while (rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("pr_name");
				String count = rs.getString("COUNT(pr_name)");

				TopBox topBox = new TopBox(id, name, count);
				prBox.add(topBox);
			}
			con.close();
		} catch(final SQLException e) {
			e.printStackTrace();
			return null;
		} catch (final ClassNotFoundException e) {
			System.out.println("ドライバーエラーです。");
			e.printStackTrace();
		}
	System.out.println("*** Succeed making information list\n>>" + prBox);
	return prBox;
	}


	public List<TopBox> swBox() {
		System.out.println("*** Enter List<TopBox> swBox");
		final List<TopBox> swBox = new ArrayList<>();

		try {
			// Start connection to DB
			System.out.println("*** Connection to DB");
			Class.forName(driver);
			con = DriverManager.getConnection(DB_url, DB_user, DB_pass);

			// Prepare SQL
			System.out.println("*** Prepare SQL");
			ps = con.prepareStatement(swBoxQry);

			// Query SQL
			System.out.println("*** Query SQL");
			rs = ps.executeQuery();

			// 結果をArrayListに格納
			System.out.println("*** RS into ArrayList");
			while (rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("sw_name");
				String count = rs.getString("COUNT(sw_name)");

				TopBox topBox = new TopBox(id, name, count);
				swBox.add(topBox);
			}
			con.close();
		} catch(final SQLException e) {
			e.printStackTrace();
			return null;
		} catch (final ClassNotFoundException e) {
			System.out.println("ドライバーエラーです。");
			e.printStackTrace();
		}
	System.out.println("*** Succeed making information list\n>>" + swBox);
	return swBox;
	}

	public List<TopBox> ilBox() {
		System.out.println("*** Enter List<TopBox> ilBox");
		final List<TopBox> ilBox = new ArrayList<>();

		try {
			// Start connection to DB
			System.out.println("*** Connection to DB");
			Class.forName(driver);
			con = DriverManager.getConnection(DB_url, DB_user, DB_pass);

			// Prepare SQL
			System.out.println("*** Prepare SQL");
			ps = con.prepareStatement(ilBoxQry);

			// Query SQL
			System.out.println("*** Query SQL");
			rs = ps.executeQuery();

			// 結果をArrayListに格納
			System.out.println("*** RS into ArrayList");
			while (rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("il_name");
				String count = rs.getString("COUNT(il_name)");

				TopBox topBox = new TopBox(id, name, count);
				ilBox.add(topBox);
			}
			con.close();
		} catch(final SQLException e) {
			e.printStackTrace();
			return null;
		} catch (final ClassNotFoundException e) {
			System.out.println("ドライバーエラーです。");
			e.printStackTrace();
		}
	System.out.println("*** Succeed making information list\n>>" + ilBox);
	return ilBox;
	}

	public List<TopBox> gcBox() {
		System.out.println("*** Enter List<TopBox> gcBox");
		final List<TopBox> gcBox = new ArrayList<>();

		try {
			// Start connection to DB
			System.out.println("*** Connection to DB");
			Class.forName(driver);
			con = DriverManager.getConnection(DB_url, DB_user, DB_pass);

			// Prepare SQL
			System.out.println("*** Prepare SQL");
			ps = con.prepareStatement(gcBoxQry);

			// Query SQL
			System.out.println("*** Query SQL");
			rs = ps.executeQuery();

			// 結果をArrayListに格納
			System.out.println("*** RS into ArrayList");
			while (rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("gc_name");
				String count = rs.getString("COUNT(gc_name)");

				TopBox topBox = new TopBox(id, name, count);
				gcBox.add(topBox);
			}
			con.close();
		} catch(final SQLException e) {
			e.printStackTrace();
			return null;
		} catch (final ClassNotFoundException e) {
			System.out.println("ドライバーエラーです。");
			e.printStackTrace();
		}
	System.out.println("*** Succeed making information list\n>>" + gcBox);
	return gcBox;
	}

	public List<TopBox> scBox() {
		System.out.println("*** Enter List<TopBox> scBox");
		final List<TopBox> scBox = new ArrayList<>();

		try {
			// Start connection to DB
			System.out.println("*** Connection to DB");
			Class.forName(driver);
			con = DriverManager.getConnection(DB_url, DB_user, DB_pass);

			// Prepare SQL
			System.out.println("*** Prepare SQL");
			ps = con.prepareStatement(scBoxQry);

			// Query SQL
			System.out.println("*** Query SQL");
			rs = ps.executeQuery();

			// 結果をArrayListに格納
			System.out.println("*** RS into ArrayList");
			while (rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("sc_name");
				String count = rs.getString("COUNT(sc_name)");

				TopBox topBox = new TopBox(id, name, count);
				scBox.add(topBox);
			}
			con.close();
		} catch(final SQLException e) {
			e.printStackTrace();
			return null;
		} catch (final ClassNotFoundException e) {
			System.out.println("ドライバーエラーです。");
			e.printStackTrace();
		}
	System.out.println("*** Succeed making information list\n>>" + scBox);
	return scBox;
	}


	public List<TopBox> vaBox() {
		System.out.println("*** Enter List<TopBox> vaBox");
		final List<TopBox> vaBox = new ArrayList<>();

		try {
			// Start connection to DB
			System.out.println("*** Connection to DB");
			Class.forName(driver);
			con = DriverManager.getConnection(DB_url, DB_user, DB_pass);

			// Prepare SQL
			System.out.println("*** Prepare SQL");
			ps = con.prepareStatement(vaBoxQry);

			// Query SQL
			System.out.println("*** Query SQL");
			rs = ps.executeQuery();

			// 結果をArrayListに格納
			System.out.println("*** RS into ArrayList");
			while (rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("va_name");
				String count = rs.getString("COUNT(va_name)");

				TopBox topBox = new TopBox(id, name, count);
				vaBox.add(topBox);
			}
			con.close();
		} catch(final SQLException e) {
			e.printStackTrace();
			return null;
		} catch (final ClassNotFoundException e) {
			System.out.println("ドライバーエラーです。");
			e.printStackTrace();
		}
	System.out.println("*** Succeed making information list\n>>" + vaBox);
	return vaBox;
	}


	public List<TopBox> avBox() {
		System.out.println("*** Enter List<TopBox> avBox");
		final List<TopBox> avBox = new ArrayList<>();

		try {
			// Start connection to DB
			System.out.println("*** Connection to DB");
			Class.forName(driver);
			con = DriverManager.getConnection(DB_url, DB_user, DB_pass);

			// Prepare SQL
			System.out.println("*** Prepare SQL");
			ps = con.prepareStatement(avBoxQry);

			// Query SQL
			System.out.println("*** Query SQL");
			rs = ps.executeQuery();

			// 結果をArrayListに格納
			System.out.println("*** RS into ArrayList");
			while (rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("av_name");
				String count = rs.getString("COUNT(av_name)");

				TopBox topBox = new TopBox(id, name, count);
				avBox.add(topBox);
			}
			con.close();
		} catch(final SQLException e) {
			e.printStackTrace();
			return null;
		} catch (final ClassNotFoundException e) {
			System.out.println("ドライバーエラーです。");
			e.printStackTrace();
		}
	System.out.println("*** Succeed making information list\n>>" + avBox);
	return avBox;
	}
}
