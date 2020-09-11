package test;

import dao.Product_infoDAO;
import model.Product_info;

public class test02 {
	public static void main(String[] args) {
		System.out.println("*** Enter Class GetPiInfoLogic");
		System.out.println("*** Execute Class Product_info");
		Product_infoDAO dao = new Product_infoDAO();
		System.out.println(dao.findById(4)); //servletにget作って()に入れる。
	}
}
