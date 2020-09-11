package test;

import java.util.List;
import model.Product_info;
import dao.Product_infoDAO;

public class SearchPI {
	public static void main(String[] args) {
//		int page;page.getSearchId()

		// product_infoからIDで検索をかけてレコードを取得
		Product_infoDAO piDAO = new Product_infoDAO();
		List<Product_info> piList = piDAO.findById(7);
		// 取得したレコードの内容を出力
		for (Product_info pi : piList) {
			System.out.println("ID:" + pi.getId());
			System.out.println("タイトル:" + pi.getTitle());
			System.out.println("ブランド:" + pi.getBr_name());
			System.out.println("発売日:" + pi.getRelease_date());
			System.out.println("シリーズ:" + pi.getSeries());
			System.out.println("エンジン:" + pi.getEngine());
			System.out.println("コメント:" + pi.getPi_comment());
			System.out.println("あらすじ:" + pi.getPi_text());
			System.out.println("piList:" + piList);
		}
	}
}