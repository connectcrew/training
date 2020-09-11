package model;

import dao.ProductDAO;

public class GetPiInfoLogic {
	public ProductInfo execute(String searchId) {
		System.out.println("*** Enter GetPiInfoLogic");
		ProductDAO dao = new ProductDAO();
		return dao.piInfo(searchId); //servletにget作って()に入れる。
	}
}