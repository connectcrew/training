package test;

public class SQLforDAO {
	// プロデューサー関連の情報


	// シナリオライター関連の情報
	String swInfoQry = ("SELECT scenario_writer.id, sw_name, sw_gender, sw_place, sw_birthday, sw_blood, br_name, cl_name FROM product_info" +
					    "JOIN product_sw ON product_info.id=product_sw.pi_id" +
					    "JOIN scenario_writer ON product_sw.sw_id=scenario_writer.id" +
					    "LEFT OUTER JOIN brand ON scenario_writer.br_id=brand.id" +
					    "LEFT OUTER JOIN club ON scenario_writer.cl_id=club.id" +
					    "WHERE product_info.id=1;");

	// イラストレーター関連の情報



	// グラフィッククリエイター関連の情報



	// サウンドクリエイター関連の情報



	// 声優関連の情報



}