/* product_infoのページ用のDAO */
package dao;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import model.ProductInfo;
import model.VoiceActor;
import model.AnimationVA;
import model.Brand;
import model.Company;
import model.Creator;


public class InsertDAO {
	//===***** Information for connect DB *****===//
	private final String DB_url  = "jdbc:mysql://localhost/novelgame?serverTimezone=JST&useSSL=false";
	private final String DB_user = "root";
	private final String DB_pass = "connectcrew";
	private final String driver  = "com.mysql.cj.jdbc.Driver";
	Connection con;
	Statement stmt;
	PreparedStatement ps;
	ResultSet rs;
	private final String piInfoQry = ("INSERT INTO product_info(title, br_id, release_date, series, ENGINE, pi_comment, pi_text) "
									+ "VALUES(?, ?, ?, ?, ?, ?, ?);");

	private final String getLastPiId = ("SELECT id FROM a_test "
									+ "ORDER BY id DESC "
									+ "LIMIT 1;");

	private final String partPrQry = ("INSERT INTO product_pr(pi_id, pr_id) VALUES(?, ?);");

	private final String partSWQry = ("INSERT INTO product_sw(pi_id, sw_id) VALUES(?, ?);");

	private final String partIlQry = ("INSERT INTO product_il(pi_id, il_id) VALUES(?, ?);");

	private final String partGCQry = ("INSERT INTO product_gc(pi_id, gc_id) VALUES(?, ?);");

	private final String partSCQry = ("INSERT INTO product_sc(pi_id, sc_id) VALUES(?, ?);");

	private final String partVAQry = ("INSERT INTO product_va(pi_id, va_id) VALUES(?, ?);");

	private final String insertCoQry = ("INSERT INTO company(co_name, co_year, co_address) VALUES(?, ?, ?);");

	private final String insertBrQry = ("INSERT INTO brand(br_name, co_id) VALUES(?, ?)");

	private final String insertPrQry = ("INSERT INTO producer(pr_name, pr_gender, pr_place, pr_birthday, pr_blood, br_id) VALUES(?, ?, ?, ?, ?, ?, ?);");

	private final String insertSWQry = ("INSERT INTO scenario_writer(sw_name, sw_gender, sw_place, sw_birthday, sw_blood, br_id) VALUES(?, ?, ?, ?, ?, ?, ?);");

	private final String insertIlQry = ("INSERT INTO illustrator(il_name, il_gender, il_place, il_birthday, il_blood, br_id) VALUES(?, ?, ?, ?, ?, ?, ?);");

	private final String insertGCQry = ("INSERT INTO graphic_creator(gc_name, gc_gender, gc_place, gc_birthday, gc_blood, br_id) VALUES(?, ?, ?, ?, ?, ?, ?);");

	private final String insertSCQry = ("INSERT INTO sound_creator(sc_name, sc_gender, sc_place, sc_birthday, sc_blood, br_id) VALUES(?, ?, ?, ?, ?, ?, ?);");

	private final String insertVAQry = ("INSERT INTO voice_actor(va_name, va_namespell, va_gender, va_place, va_birthday, va_blood, va_debut, ao_id, av_id,) "
									+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");

	private final String insertAVQry = ("INSERT INTO animation_va(av_name, av_namespell, av_gender, av_place, av_birthday, av_blood, av_debut, ao_id) "
									+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?)");


	public int ProductInfo(ProductInfo productInfo) {
		System.out.println("*** insert product_info");
		int ErrorCode = 0;

		try {
			// Start connection to DB
			System.out.println("*** Connection to DB");
			Class.forName(driver);
			con = DriverManager.getConnection(DB_url, DB_user, DB_pass);
			con.setAutoCommit(false);

			try {
				// Prepare SQL
				System.out.println("*** Prepare SQL");
				ps = con.prepareStatement(piInfoQry);
				ps.setString(1, productInfo.getTitle());
				ps.setString(2, productInfo.getBrId());
				ps.setString(3, productInfo.getRelease());
				ps.setString(4, productInfo.getSeries());
				ps.setString(5, productInfo.getEngine());
				ps.setString(6, productInfo.getComment());
				ps.setString(7, productInfo.getText());

				// Query SQL
				System.out.println("*** Query SQL");

				int result = ps.executeUpdate();
				if(result == 0) {
					System.out.println("*** !Exception:Cord=1【データベース処理失敗】変更されたカラムが0件です。");
					System.out.println("rollbackしました");
					con.rollback();
					ErrorCode = 1;
					return ErrorCode;
				}
				con.commit();
				con.close();
			} catch(final SQLIntegrityConstraintViolationException e) {
				System.out.println("*** !Exception:Cord=2【整合性制約違反】NOT NULL属性のカラムに対してNULL、あるいはUNIQUE属性のカラムに対して重複している値があると思われます。");
				e.printStackTrace();
				System.out.println("rollbackしました");
				con.rollback();
				ErrorCode = 2;
				return ErrorCode;
			} catch(final SQLException e) {
				System.out.println("*** !Exception:Cord=3【SQLException】データベース処理に関して何らかのエラーが発生しています。");
				e.printStackTrace();
				System.out.println("rollbackしました");
				con.rollback();
				ErrorCode = 3;
				return ErrorCode;
			}
		} catch (final ClassNotFoundException e) {
			System.out.println("*** !Exception:Cord=4【ドライバーエラー】指定されたJDBCドライバーが使用できない状態です。");
			e.printStackTrace();
			ErrorCode = 4;
			return ErrorCode;
		} catch(Exception e) {
			System.out.println("*** !Exception:Cord=5【不明なエラー】予期せぬエラーが発生しました。");
			e.printStackTrace();
			ErrorCode = 5;
		}
		return ErrorCode;
		}



	public int partPr(List<Creator> pr) {
		System.out.println("*** insert product_pr");
		int ErrorCode = 0;

		try {
			// Start connection to DB
			System.out.println("*** Connection to DB");
			Class.forName(driver);
			con = DriverManager.getConnection(DB_url, DB_user, DB_pass);
			con.setAutoCommit(false);

			try {
				System.out.println("*** get Last PiId");
				ps = con.prepareStatement(getLastPiId);
				rs = ps.executeQuery();
				rs.next();
				String piId = rs.getString("id");
				System.out.println(piId);

				for (int i = 0; i < pr.size(); i++) {
					// Prepare SQL
					System.out.println("*** Prepare SQL");
					ps = con.prepareStatement(partPrQry);
					ps.setString(1, piId);
					ps.setString(2, pr.get(i).getCrId());


					// Query SQL
					System.out.println("*** Query SQL");

					int result = ps.executeUpdate();
					if(result == 0) {
						System.out.println("*** !Exception:Cord=1【データベース処理失敗】変更されたカラムが0件です。");
						ErrorCode = 1;
						return ErrorCode;
					}
				}

				con.commit();
				con.close();
			} catch(final SQLIntegrityConstraintViolationException e) {
				System.out.println("*** !Exception:Cord=2【整合性制約違反】NOT NULL属性のカラムに対してNULL、あるいはUNIQUE属性のカラムに対して重複している値があると思われます。");
				e.printStackTrace();
				con.rollback();
				ErrorCode = 2;
				return ErrorCode;
			} catch(final SQLException e) {
				System.out.println("*** !Exception:Cord=3【SQLException】データベース処理に関して何らかのエラーが発生しています。");
				e.printStackTrace();
				con.rollback();
				ErrorCode = 3;
				return ErrorCode;
			}
		} catch (final ClassNotFoundException e) {
			System.out.println("*** !Exception:Cord=4【ドライバーエラー】指定されたJDBCドライバーが使用できない状態です。");
			e.printStackTrace();
			ErrorCode = 4;
			return ErrorCode;
		} catch(Exception e) {
			System.out.println("*** !Exception:Cord=5【不明なエラー】予期せぬエラーが発生しました。");
			e.printStackTrace();
			ErrorCode = 5;
		}
		return ErrorCode;
		}



	public int partSW(List<Creator> sw) {
		System.out.println("*** insert product_sw");
		int ErrorCode = 0;

		try {
			// Start connection to DB
			System.out.println("*** Connection to DB");
			Class.forName(driver);
			con = DriverManager.getConnection(DB_url, DB_user, DB_pass);
			con.setAutoCommit(false);

			try {
				System.out.println("*** get Last PiId");
				ps = con.prepareStatement(getLastPiId);
				rs = ps.executeQuery();
				rs.next();
				String piId = rs.getString("id");
				System.out.println(piId);

				for (int i = 0; i < sw.size(); i++) {
					// Prepare SQL
					System.out.println("*** Prepare SQL");
					ps = con.prepareStatement(partSWQry);
					ps.setString(1, piId);
					ps.setString(2, sw.get(i).getCrId());


					// Query SQL
					System.out.println("*** Query SQL");

					int result = ps.executeUpdate();
					if(result == 0) {
						System.out.println("*** !Exception:Cord=1【データベース処理失敗】変更されたカラムが0件です。");
						ErrorCode = 1;
						return ErrorCode;
					}
				}

				con.commit();
				con.close();
			} catch(final SQLIntegrityConstraintViolationException e) {
				System.out.println("*** !Exception:Cord=2【整合性制約違反】NOT NULL属性のカラムに対してNULL、あるいはUNIQUE属性のカラムに対して重複している値があると思われます。");
				e.printStackTrace();
				con.rollback();
				ErrorCode = 2;
				return ErrorCode;
			} catch(final SQLException e) {
				System.out.println("*** !Exception:Cord=3【SQLException】データベース処理に関して何らかのエラーが発生しています。");
				e.printStackTrace();
				con.rollback();
				ErrorCode = 3;
				return ErrorCode;
			}
		} catch (final ClassNotFoundException e) {
			System.out.println("*** !Exception:Cord=4【ドライバーエラー】指定されたJDBCドライバーが使用できない状態です。");
			e.printStackTrace();
			ErrorCode = 4;
			return ErrorCode;
		} catch(Exception e) {
			System.out.println("*** !Exception:Cord=5【不明なエラー】予期せぬエラーが発生しました。");
			e.printStackTrace();
			ErrorCode = 5;
		}
		return ErrorCode;
		}



	public int partIl(List<Creator> il) {
		System.out.println("*** insert product_il");
		int ErrorCode = 0;

		try {
			// Start connection to DB
			System.out.println("*** Connection to DB");
			Class.forName(driver);
			con = DriverManager.getConnection(DB_url, DB_user, DB_pass);
			con.setAutoCommit(false);

			try {
				System.out.println("*** get Last PiId");
				ps = con.prepareStatement(getLastPiId);
				rs = ps.executeQuery();
				rs.next();
				String piId = rs.getString("id");
				System.out.println(piId);

				for (int i = 0; i < il.size(); i++) {
					// Prepare SQL
					System.out.println("*** Prepare SQL");
					ps = con.prepareStatement(partIlQry);
					ps.setString(1, piId);
					ps.setString(2, il.get(i).getCrId());


					// Query SQL
					System.out.println("*** Query SQL");

					int result = ps.executeUpdate();
					if(result == 0) {
						System.out.println("*** !Exception:Cord=1【データベース処理失敗】変更されたカラムが0件です。");
						ErrorCode = 1;
						return ErrorCode;
					}
				}


				con.commit();
				con.close();
			} catch(final SQLIntegrityConstraintViolationException e) {
				System.out.println("*** !Exception:Cord=2【整合性制約違反】NOT NULL属性のカラムに対してNULL、あるいはUNIQUE属性のカラムに対して重複している値があると思われます。");
				e.printStackTrace();
				con.rollback();
				ErrorCode = 2;
				return ErrorCode;
			} catch(final SQLException e) {
				System.out.println("*** !Exception:Cord=3【SQLException】データベース処理に関して何らかのエラーが発生しています。");
				e.printStackTrace();
				con.rollback();
				ErrorCode = 3;
				return ErrorCode;
			}
		} catch (final ClassNotFoundException e) {
			System.out.println("*** !Exception:Cord=4【ドライバーエラー】指定されたJDBCドライバーが使用できない状態です。");
			e.printStackTrace();
			ErrorCode = 4;
			return ErrorCode;
		} catch(Exception e) {
			System.out.println("*** !Exception:Cord=5【不明なエラー】予期せぬエラーが発生しました。");
			e.printStackTrace();
			ErrorCode = 5;
		}
		return ErrorCode;
		}

	public int partGC(List<Creator> gc) {
		System.out.println("*** insert product_gc");
		int ErrorCode = 0;

		try {
			// Start connection to DB
			System.out.println("*** Connection to DB");
			Class.forName(driver);
			con = DriverManager.getConnection(DB_url, DB_user, DB_pass);
			con.setAutoCommit(false);

			try {
				System.out.println("*** get Last PiId");
				ps = con.prepareStatement(getLastPiId);
				rs = ps.executeQuery();
				rs.next();
				String piId = rs.getString("id");
				System.out.println(piId);

				for (int i = 0; i < gc.size(); i++) {
					// Prepare SQL
					System.out.println("*** Prepare SQL");
					ps = con.prepareStatement(partGCQry);
					ps.setString(1, piId);
					ps.setString(2, gc.get(i).getCrId());


					// Query SQL
					System.out.println("*** Query SQL");

					int result = ps.executeUpdate();
					if(result == 0) {
						System.out.println("*** !Exception:Cord=1【データベース処理失敗】変更されたカラムが0件です。");
						ErrorCode = 1;
						return ErrorCode;
					}
				}


				con.commit();
				con.close();
			} catch(final SQLIntegrityConstraintViolationException e) {
				System.out.println("*** !Exception:Cord=2【整合性制約違反】NOT NULL属性のカラムに対してNULL、あるいはUNIQUE属性のカラムに対して重複している値があると思われます。");
				e.printStackTrace();
				con.rollback();
				ErrorCode = 2;
				return ErrorCode;
			} catch(final SQLException e) {
				System.out.println("*** !Exception:Cord=3【SQLException】データベース処理に関して何らかのエラーが発生しています。");
				e.printStackTrace();
				con.rollback();
				ErrorCode = 3;
				return ErrorCode;
			}
		} catch (final ClassNotFoundException e) {
			System.out.println("*** !Exception:Cord=4【ドライバーエラー】指定されたJDBCドライバーが使用できない状態です。");
			e.printStackTrace();
			ErrorCode = 4;
			return ErrorCode;
		} catch(Exception e) {
			System.out.println("*** !Exception:Cord=5【不明なエラー】予期せぬエラーが発生しました。");
			e.printStackTrace();
			ErrorCode = 5;
		}
		return ErrorCode;
		}

	public int partSC(List<Creator> sc) {
		System.out.println("*** insert product_sc");
		int ErrorCode = 0;

		try {
			// Start connection to DB
			System.out.println("*** Connection to DB");
			Class.forName(driver);
			con = DriverManager.getConnection(DB_url, DB_user, DB_pass);
			con.setAutoCommit(false);

			try {
				System.out.println("*** get Last PiId");
				ps = con.prepareStatement(getLastPiId);
				rs = ps.executeQuery();
				rs.next();
				String piId = rs.getString("id");
				System.out.println(piId);

				for (int i = 0; i < sc.size(); i++) {
					// Prepare SQL
					System.out.println("*** Prepare SQL");
					ps = con.prepareStatement(partSCQry);
					ps.setString(1, piId);
					ps.setString(2, sc.get(i).getCrId());


					// Query SQL
					System.out.println("*** Query SQL");

					int result = ps.executeUpdate();
					if(result == 0) {
						System.out.println("*** !Exception:Cord=1【データベース処理失敗】変更されたカラムが0件です。");
						ErrorCode = 1;
						return ErrorCode;
					}
				}


				con.commit();
				con.close();
			} catch(final SQLIntegrityConstraintViolationException e) {
				System.out.println("*** !Exception:Cord=2【整合性制約違反】NOT NULL属性のカラムに対してNULL、あるいはUNIQUE属性のカラムに対して重複している値があると思われます。");
				e.printStackTrace();
				con.rollback();
				ErrorCode = 2;
				return ErrorCode;
			} catch(final SQLException e) {
				System.out.println("*** !Exception:Cord=3【SQLException】データベース処理に関して何らかのエラーが発生しています。");
				e.printStackTrace();
				con.rollback();
				ErrorCode = 3;
				return ErrorCode;
			}
		} catch (final ClassNotFoundException e) {
			System.out.println("*** !Exception:Cord=4【ドライバーエラー】指定されたJDBCドライバーが使用できない状態です。");
			e.printStackTrace();
			ErrorCode = 4;
			return ErrorCode;
		} catch(Exception e) {
			System.out.println("*** !Exception:Cord=5【不明なエラー】予期せぬエラーが発生しました。");
			e.printStackTrace();
			ErrorCode = 5;
		}
		return ErrorCode;
		}

	public int partVA(List<Creator> va) {
		System.out.println("*** insert product_va");
		int ErrorCode = 0;

		try {
			// Start connection to DB
			System.out.println("*** Connection to DB");
			Class.forName(driver);
			con = DriverManager.getConnection(DB_url, DB_user, DB_pass);
			con.setAutoCommit(false);

			try {
				System.out.println("*** get Last PiId");
				ps = con.prepareStatement(getLastPiId);
				rs = ps.executeQuery();
				rs.next();
				String piId = rs.getString("id");
				System.out.println(piId);

				for (int i = 0; i < va.size(); i++) {
					// Prepare SQL
					System.out.println("*** Prepare SQL");
					ps = con.prepareStatement(partVAQry);
					ps.setString(1, piId);
					ps.setString(2, va.get(i).getCrId());


					// Query SQL
					System.out.println("*** Query SQL");

					int result = ps.executeUpdate();
					if(result == 0) {
						System.out.println("*** !Exception:Cord=1【データベース処理失敗】変更されたカラムが0件です。");
						ErrorCode = 1;
						return ErrorCode;
					}
				}


				con.commit();
				con.close();
			} catch(final SQLIntegrityConstraintViolationException e) {
				System.out.println("*** !Exception:Cord=2【整合性制約違反】NOT NULL属性のカラムに対してNULL、あるいはUNIQUE属性のカラムに対して重複している値があると思われます。");
				e.printStackTrace();
				con.rollback();
				ErrorCode = 2;
				return ErrorCode;
			} catch(final SQLException e) {
				System.out.println("*** !Exception:Cord=3【SQLException】データベース処理に関して何らかのエラーが発生しています。");
				e.printStackTrace();
				con.rollback();
				ErrorCode = 3;
				return ErrorCode;
			}
		} catch (final ClassNotFoundException e) {
			System.out.println("*** !Exception:Cord=4【ドライバーエラー】指定されたJDBCドライバーが使用できない状態です。");
			e.printStackTrace();
			ErrorCode = 4;
			return ErrorCode;
		} catch(Exception e) {
			System.out.println("*** !Exception:Cord=5【不明なエラー】予期せぬエラーが発生しました。");
			e.printStackTrace();
			ErrorCode = 5;
		}
		return ErrorCode;
		}



	public int insertCo(Company co) {
		System.out.println("*** insert company");
		int ErrorCode = 0;

		try {
			// Start connection to DB
			System.out.println("*** Connection to DB");
			Class.forName(driver);
			con = DriverManager.getConnection(DB_url, DB_user, DB_pass);
			con.setAutoCommit(false);

			try {
				// Prepare SQL
				System.out.println("*** Prepare SQL");
				ps = con.prepareStatement(insertCoQry);
				ps.setString(1, co.getCoName());
				ps.setString(2, co.getYear());
				ps.setString(3, co.getAddress());


				// Query SQL
				System.out.println("*** Query SQL");

				int result = ps.executeUpdate();
				if(result == 0) {
					System.out.println("*** !Exception:Cord=1【データベース処理失敗】変更されたカラムが0件です。");
					System.out.println("rollbackしました");
					con.rollback();
					ErrorCode = 1;
					return ErrorCode;
				}
				con.commit();
				con.close();
			} catch(final SQLIntegrityConstraintViolationException e) {
				System.out.println("*** !Exception:Cord=2【整合性制約違反】NOT NULL属性のカラムに対してNULL、あるいはUNIQUE属性のカラムに対して重複している値があると思われます。");
				e.printStackTrace();
				System.out.println("rollbackしました");
				con.rollback();
				ErrorCode = 2;
				return ErrorCode;
			} catch(final SQLException e) {
				System.out.println("*** !Exception:Cord=3【SQLException】データベース処理に関して何らかのエラーが発生しています。");
				e.printStackTrace();
				System.out.println("rollbackしました");
				con.rollback();
				ErrorCode = 3;
				return ErrorCode;
			}
		} catch (final ClassNotFoundException e) {
			System.out.println("*** !Exception:Cord=4【ドライバーエラー】指定されたJDBCドライバーが使用できない状態です。");
			e.printStackTrace();
			ErrorCode = 4;
			return ErrorCode;
		} catch(Exception e) {
			System.out.println("*** !Exception:Cord=5【不明なエラー】予期せぬエラーが発生しました。");
			e.printStackTrace();
			ErrorCode = 5;
		}
		return ErrorCode;
		}



	public int insertBr(Brand br) {
		System.out.println("*** insert brand");
		int ErrorCode = 0;

		try {
			// Start connection to DB
			System.out.println("*** Connection to DB");
			Class.forName(driver);
			con = DriverManager.getConnection(DB_url, DB_user, DB_pass);
			con.setAutoCommit(false);

			try {
				// Prepare SQL
				System.out.println("*** Prepare SQL");
				ps = con.prepareStatement(insertBrQry);
				ps.setString(1, br.getBrName());
				ps.setString(2, br.getCoId());


				// Query SQL
				System.out.println("*** Query SQL");

				int result = ps.executeUpdate();
				if(result == 0) {
					System.out.println("*** !Exception:Cord=1【データベース処理失敗】変更されたカラムが0件です。");
					System.out.println("rollbackしました");
					con.rollback();
					ErrorCode = 1;
					return ErrorCode;
				}
				con.commit();
				con.close();
			} catch(final SQLIntegrityConstraintViolationException e) {
				System.out.println("*** !Exception:Cord=2【整合性制約違反】NOT NULL属性のカラムに対してNULL、あるいはUNIQUE属性のカラムに対して重複している値があると思われます。");
				e.printStackTrace();
				System.out.println("rollbackしました");
				con.rollback();
				ErrorCode = 2;
				return ErrorCode;
			} catch(final SQLException e) {
				System.out.println("*** !Exception:Cord=3【SQLException】データベース処理に関して何らかのエラーが発生しています。");
				e.printStackTrace();
				System.out.println("rollbackしました");
				con.rollback();
				ErrorCode = 3;
				return ErrorCode;
			}
		} catch (final ClassNotFoundException e) {
			System.out.println("*** !Exception:Cord=4【ドライバーエラー】指定されたJDBCドライバーが使用できない状態です。");
			e.printStackTrace();
			ErrorCode = 4;
			return ErrorCode;
		} catch(Exception e) {
			System.out.println("*** !Exception:Cord=5【不明なエラー】予期せぬエラーが発生しました。");
			e.printStackTrace();
			ErrorCode = 5;
		}
		return ErrorCode;
		}



	public int insertPr(Creator cr) {
		System.out.println("*** insert producer");
		int ErrorCode = 0;

		try {
			// Start connection to DB
			System.out.println("*** Connection to DB");
			Class.forName(driver);
			con = DriverManager.getConnection(DB_url, DB_user, DB_pass);
			con.setAutoCommit(false);

			try {
				// Prepare SQL
				System.out.println("*** Prepare SQL");
				ps = con.prepareStatement(insertPrQry);
				ps.setString(1, cr.getName());
				ps.setString(2, cr.getGender());
				ps.setString(3, cr.getPlace());
				ps.setString(4, cr.getBirthday());
				ps.setString(5, cr.getBlood());
				ps.setString(6, cr.getBrId());

				// Query SQL
				System.out.println("*** Query SQL");

				int result = ps.executeUpdate();
				if(result == 0) {
					System.out.println("*** !Exception:Cord=1【データベース処理失敗】変更されたカラムが0件です。");
					System.out.println("rollbackしました");
					con.rollback();
					ErrorCode = 1;
					return ErrorCode;
				}
				con.commit();
				con.close();
			} catch(final SQLIntegrityConstraintViolationException e) {
				System.out.println("*** !Exception:Cord=2【整合性制約違反】NOT NULL属性のカラムに対してNULL、あるいはUNIQUE属性のカラムに対して重複している値があると思われます。");
				e.printStackTrace();
				System.out.println("rollbackしました");
				con.rollback();
				ErrorCode = 2;
				return ErrorCode;
			} catch(final SQLException e) {
				System.out.println("*** !Exception:Cord=3【SQLException】データベース処理に関して何らかのエラーが発生しています。");
				e.printStackTrace();
				System.out.println("rollbackしました");
				con.rollback();
				ErrorCode = 3;
				return ErrorCode;
			}
		} catch (final ClassNotFoundException e) {
			System.out.println("*** !Exception:Cord=4【ドライバーエラー】指定されたJDBCドライバーが使用できない状態です。");
			e.printStackTrace();
			ErrorCode = 4;
			return ErrorCode;
		} catch(Exception e) {
			System.out.println("*** !Exception:Cord=5【不明なエラー】予期せぬエラーが発生しました。");
			e.printStackTrace();
			ErrorCode = 5;
		}
		return ErrorCode;
		}


	public int insertSW(Creator cr) {
		System.out.println("*** insert scenario_writer");
		int ErrorCode = 0;

		try {
			// Start connection to DB
			System.out.println("*** Connection to DB");
			Class.forName(driver);
			con = DriverManager.getConnection(DB_url, DB_user, DB_pass);
			con.setAutoCommit(false);

			try {
				// Prepare SQL
				System.out.println("*** Prepare SQL");
				ps = con.prepareStatement(insertSWQry);
				ps.setString(1, cr.getName());
				ps.setString(2, cr.getGender());
				ps.setString(3, cr.getPlace());
				ps.setString(4, cr.getBirthday());
				ps.setString(5, cr.getBlood());
				ps.setString(6, cr.getBrId());

				// Query SQL
				System.out.println("*** Query SQL");

				int result = ps.executeUpdate();
				if(result == 0) {
					System.out.println("*** !Exception:Cord=1【データベース処理失敗】変更されたカラムが0件です。");
					System.out.println("rollbackしました");
					con.rollback();
					ErrorCode = 1;
					return ErrorCode;
				}
				con.commit();
				con.close();
			} catch(final SQLIntegrityConstraintViolationException e) {
				System.out.println("*** !Exception:Cord=2【整合性制約違反】NOT NULL属性のカラムに対してNULL、あるいはUNIQUE属性のカラムに対して重複している値があると思われます。");
				e.printStackTrace();
				System.out.println("rollbackしました");
				con.rollback();
				ErrorCode = 2;
				return ErrorCode;
			} catch(final SQLException e) {
				System.out.println("*** !Exception:Cord=3【SQLException】データベース処理に関して何らかのエラーが発生しています。");
				e.printStackTrace();
				System.out.println("rollbackしました");
				con.rollback();
				ErrorCode = 3;
				return ErrorCode;
			}
		} catch (final ClassNotFoundException e) {
			System.out.println("*** !Exception:Cord=4【ドライバーエラー】指定されたJDBCドライバーが使用できない状態です。");
			e.printStackTrace();
			ErrorCode = 4;
			return ErrorCode;
		} catch(Exception e) {
			System.out.println("*** !Exception:Cord=5【不明なエラー】予期せぬエラーが発生しました。");
			e.printStackTrace();
			ErrorCode = 5;
		}
		return ErrorCode;
		}


	public int insertIl(Creator cr) {
		System.out.println("*** insert illustrator");
		int ErrorCode = 0;

		try {
			// Start connection to DB
			System.out.println("*** Connection to DB");
			Class.forName(driver);
			con = DriverManager.getConnection(DB_url, DB_user, DB_pass);
			con.setAutoCommit(false);

			try {
				// Prepare SQL
				System.out.println("*** Prepare SQL");
				ps = con.prepareStatement(insertIlQry);
				ps.setString(1, cr.getName());
				ps.setString(2, cr.getGender());
				ps.setString(3, cr.getPlace());
				ps.setString(4, cr.getBirthday());
				ps.setString(5, cr.getBlood());
				ps.setString(6, cr.getBrId());

				// Query SQL
				System.out.println("*** Query SQL");

				int result = ps.executeUpdate();
				if(result == 0) {
					System.out.println("*** !Exception:Cord=1【データベース処理失敗】変更されたカラムが0件です。");
					System.out.println("rollbackしました");
					con.rollback();
					ErrorCode = 1;
					return ErrorCode;
				}
				con.commit();
				con.close();
			} catch(final SQLIntegrityConstraintViolationException e) {
				System.out.println("*** !Exception:Cord=2【整合性制約違反】NOT NULL属性のカラムに対してNULL、あるいはUNIQUE属性のカラムに対して重複している値があると思われます。");
				e.printStackTrace();
				System.out.println("rollbackしました");
				con.rollback();
				ErrorCode = 2;
				return ErrorCode;
			} catch(final SQLException e) {
				System.out.println("*** !Exception:Cord=3【SQLException】データベース処理に関して何らかのエラーが発生しています。");
				e.printStackTrace();
				System.out.println("rollbackしました");
				con.rollback();
				ErrorCode = 3;
				return ErrorCode;
			}
		} catch (final ClassNotFoundException e) {
			System.out.println("*** !Exception:Cord=4【ドライバーエラー】指定されたJDBCドライバーが使用できない状態です。");
			e.printStackTrace();
			ErrorCode = 4;
			return ErrorCode;
		} catch(Exception e) {
			System.out.println("*** !Exception:Cord=5【不明なエラー】予期せぬエラーが発生しました。");
			e.printStackTrace();
			ErrorCode = 5;
		}
		return ErrorCode;
		}


	public int insertGC(Creator cr) {
		System.out.println("*** insert graphic_creator");
		int ErrorCode = 0;

		try {
			// Start connection to DB
			System.out.println("*** Connection to DB");
			Class.forName(driver);
			con = DriverManager.getConnection(DB_url, DB_user, DB_pass);
			con.setAutoCommit(false);

			try {
				// Prepare SQL
				System.out.println("*** Prepare SQL");
				ps = con.prepareStatement(insertGCQry);
				ps.setString(1, cr.getName());
				ps.setString(2, cr.getGender());
				ps.setString(3, cr.getPlace());
				ps.setString(4, cr.getBirthday());
				ps.setString(5, cr.getBlood());
				ps.setString(6, cr.getBrId());

				// Query SQL
				System.out.println("*** Query SQL");

				int result = ps.executeUpdate();
				if(result == 0) {
					System.out.println("*** !Exception:Cord=1【データベース処理失敗】変更されたカラムが0件です。");
					System.out.println("rollbackしました");
					con.rollback();
					ErrorCode = 1;
					return ErrorCode;
				}
				con.commit();
				con.close();
			} catch(final SQLIntegrityConstraintViolationException e) {
				System.out.println("*** !Exception:Cord=2【整合性制約違反】NOT NULL属性のカラムに対してNULL、あるいはUNIQUE属性のカラムに対して重複している値があると思われます。");
				e.printStackTrace();
				System.out.println("rollbackしました");
				con.rollback();
				ErrorCode = 2;
				return ErrorCode;
			} catch(final SQLException e) {
				System.out.println("*** !Exception:Cord=3【SQLException】データベース処理に関して何らかのエラーが発生しています。");
				e.printStackTrace();
				System.out.println("rollbackしました");
				con.rollback();
				ErrorCode = 3;
				return ErrorCode;
			}
		} catch (final ClassNotFoundException e) {
			System.out.println("*** !Exception:Cord=4【ドライバーエラー】指定されたJDBCドライバーが使用できない状態です。");
			e.printStackTrace();
			ErrorCode = 4;
			return ErrorCode;
		} catch(Exception e) {
			System.out.println("*** !Exception:Cord=5【不明なエラー】予期せぬエラーが発生しました。");
			e.printStackTrace();
			ErrorCode = 5;
		}
		return ErrorCode;
		}


	public int insertSC(Creator cr) {
		System.out.println("*** insert sounc_creator");
		int ErrorCode = 0;

		try {
			// Start connection to DB
			System.out.println("*** Connection to DB");
			Class.forName(driver);
			con = DriverManager.getConnection(DB_url, DB_user, DB_pass);
			con.setAutoCommit(false);

			try {
				// Prepare SQL
				System.out.println("*** Prepare SQL");
				ps = con.prepareStatement(insertSCQry);
				ps.setString(1, cr.getName());
				ps.setString(2, cr.getGender());
				ps.setString(3, cr.getPlace());
				ps.setString(4, cr.getBirthday());
				ps.setString(5, cr.getBlood());
				ps.setString(6, cr.getBrId());

				// Query SQL
				System.out.println("*** Query SQL");

				int result = ps.executeUpdate();
				if(result == 0) {
					System.out.println("*** !Exception:Cord=1【データベース処理失敗】変更されたカラムが0件です。");
					System.out.println("rollbackしました");
					con.rollback();
					ErrorCode = 1;
					return ErrorCode;
				}
				con.commit();
				con.close();
			} catch(final SQLIntegrityConstraintViolationException e) {
				System.out.println("*** !Exception:Cord=2【整合性制約違反】NOT NULL属性のカラムに対してNULL、あるいはUNIQUE属性のカラムに対して重複している値があると思われます。");
				e.printStackTrace();
				System.out.println("rollbackしました");
				con.rollback();
				ErrorCode = 2;
				return ErrorCode;
			} catch(final SQLException e) {
				System.out.println("*** !Exception:Cord=3【SQLException】データベース処理に関して何らかのエラーが発生しています。");
				e.printStackTrace();
				System.out.println("rollbackしました");
				con.rollback();
				ErrorCode = 3;
				return ErrorCode;
			}
		} catch (final ClassNotFoundException e) {
			System.out.println("*** !Exception:Cord=4【ドライバーエラー】指定されたJDBCドライバーが使用できない状態です。");
			e.printStackTrace();
			ErrorCode = 4;
			return ErrorCode;
		} catch(Exception e) {
			System.out.println("*** !Exception:Cord=5【不明なエラー】予期せぬエラーが発生しました。");
			e.printStackTrace();
			ErrorCode = 5;
		}
		return ErrorCode;
		}

	public int insertVA(VoiceActor va) {
		System.out.println("*** insert sounc_creator");
		int ErrorCode = 0;

		try {
			// Start connection to DB
			System.out.println("*** Connection to DB");
			Class.forName(driver);
			con = DriverManager.getConnection(DB_url, DB_user, DB_pass);
			con.setAutoCommit(false);

			try {
				// Prepare SQL
				System.out.println("*** Prepare SQL");
				ps = con.prepareStatement(insertVAQry);
				ps.setString(1, va.getVaId());
				ps.setString(2, va.getVaName());
				ps.setString(3, va.getNameSpell());
				ps.setString(4, va.getGender());
				ps.setString(5, va.getPlace());
				ps.setString(6, va.getBirthday());
				ps.setString(7, va.getBlood());
				ps.setString(8, va.getAoId());
				ps.setString(9, va.getAvId());

				// Query SQL
				System.out.println("*** Query SQL");

				int result = ps.executeUpdate();
				if(result == 0) {
					System.out.println("*** !Exception:Cord=1【データベース処理失敗】変更されたカラムが0件です。");
					System.out.println("rollbackしました");
					con.rollback();
					ErrorCode = 1;
					return ErrorCode;
				}
				con.commit();
				con.close();
			} catch(final SQLIntegrityConstraintViolationException e) {
				System.out.println("*** !Exception:Cord=2【整合性制約違反】NOT NULL属性のカラムに対してNULL、あるいはUNIQUE属性のカラムに対して重複している値があると思われます。");
				e.printStackTrace();
				System.out.println("rollbackしました");
				con.rollback();
				ErrorCode = 2;
				return ErrorCode;
			} catch(final SQLException e) {
				System.out.println("*** !Exception:Cord=3【SQLException】データベース処理に関して何らかのエラーが発生しています。");
				e.printStackTrace();
				System.out.println("rollbackしました");
				con.rollback();
				ErrorCode = 3;
				return ErrorCode;
			}
		} catch (final ClassNotFoundException e) {
			System.out.println("*** !Exception:Cord=4【ドライバーエラー】指定されたJDBCドライバーが使用できない状態です。");
			e.printStackTrace();
			ErrorCode = 4;
			return ErrorCode;
		} catch(Exception e) {
			System.out.println("*** !Exception:Cord=5【不明なエラー】予期せぬエラーが発生しました。");
			e.printStackTrace();
			ErrorCode = 5;
		}
		return ErrorCode;
		}

	public int insertAV(AnimationVA av) {
		System.out.println("*** insert sounc_creator");
		int ErrorCode = 0;

		try {
			// Start connection to DB
			System.out.println("*** Connection to DB");
			Class.forName(driver);
			con = DriverManager.getConnection(DB_url, DB_user, DB_pass);
			con.setAutoCommit(false);

			try {
				// Prepare SQL
				System.out.println("*** Prepare SQL");
				ps = con.prepareStatement(insertAVQry);
				ps.setString(1, av.getVaId());
				ps.setString(2, av.getVaName());
				ps.setString(3, av.getNameSpell());
				ps.setString(4, av.getGender());
				ps.setString(5, av.getPlace());
				ps.setString(6, av.getBirthday());
				ps.setString(7, av.getBlood());
				ps.setString(8, av.getAoId());

				// Query SQL
				System.out.println("*** Query SQL");

				int result = ps.executeUpdate();
				if(result == 0) {
					System.out.println("*** !Exception:Cord=1【データベース処理失敗】変更されたカラムが0件です。");
					System.out.println("rollbackしました");
					con.rollback();
					ErrorCode = 1;
					return ErrorCode;
				}
				con.commit();
				con.close();
			} catch(final SQLIntegrityConstraintViolationException e) {
				System.out.println("*** !Exception:Cord=2【整合性制約違反】NOT NULL属性のカラムに対してNULL、あるいはUNIQUE属性のカラムに対して重複している値があると思われます。");
				e.printStackTrace();
				System.out.println("rollbackしました");
				con.rollback();
				ErrorCode = 2;
				return ErrorCode;
			} catch(final SQLException e) {
				System.out.println("*** !Exception:Cord=3【SQLException】データベース処理に関して何らかのエラーが発生しています。");
				e.printStackTrace();
				System.out.println("rollbackしました");
				con.rollback();
				ErrorCode = 3;
				return ErrorCode;
			}
		} catch (final ClassNotFoundException e) {
			System.out.println("*** !Exception:Cord=4【ドライバーエラー】指定されたJDBCドライバーが使用できない状態です。");
			e.printStackTrace();
			ErrorCode = 4;
			return ErrorCode;
		} catch(Exception e) {
			System.out.println("*** !Exception:Cord=5【不明なエラー】予期せぬエラーが発生しました。");
			e.printStackTrace();
			ErrorCode = 5;
		}
		return ErrorCode;
		}
}
