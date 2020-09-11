package test;

import java.util.List;

import dao.TopDAO;
import model.TopBox;

public class Test01 {
	public static void main(String[] args) {
		System.out.println("*** Enter class Tester");

		System.out.println("*** Connection to TopDAO and get information");
		TopDAO dao = new TopDAO();

		System.out.println("<company>");
		List<TopBox> coBox = dao.coBox();
		System.out.println("Print company list");
		for (TopBox tb : coBox) {
			System.out.printf("%d * %s * %s\n",tb.getId() ,tb.getName(), tb.getCount());
		}

		System.out.println("<brand>");		List<TopBox> brBox = dao.brBox();
		System.out.println("Print brand list");
		for (TopBox tb : brBox) {
			System.out.printf("%d * %s * %s\n",tb.getId() ,tb.getName(), tb.getCount());
		}

		System.out.println("<producer>");
		List<TopBox> prBox = dao.prBox();
		System.out.println("Print producer list");
		for (TopBox tb : prBox) {
			System.out.printf("%d * %s * %s\n",tb.getId() ,tb.getName(), tb.getCount());
		}

		System.out.println("<SW>");
		List<TopBox> swBox = dao.swBox();
		System.out.println("Print SW list");
		for (TopBox tb : swBox) {
			System.out.printf("%d * %s * %s\n",tb.getId() ,tb.getName(), tb.getCount());
		}

		System.out.println("<illustrator>");
		List<TopBox> ilBox = dao.ilBox();
		System.out.println("Print illustrator list");
		for (TopBox tb : ilBox) {
			System.out.printf("%d * %s * %s\n",tb.getId() ,tb.getName(), tb.getCount());
		}

		System.out.println("<GC>");
		List<TopBox> gcBox = dao.gcBox();
		System.out.println("Print GC list");
		for (TopBox tb : gcBox) {
			System.out.printf("%d * %s * %s\n",tb.getId() ,tb.getName(), tb.getCount());
		}

		System.out.println("<SC>");
		List<TopBox> scBox = dao.scBox();
		System.out.println("Print SC list");
		for (TopBox tb : scBox) {
			System.out.printf("%d * %s * %s\n",tb.getId() ,tb.getName(), tb.getCount());
		}

		System.out.println("<VA>");
		List<TopBox> vaBox = dao.vaBox();
		System.out.println("Print VA list");
		for (TopBox tb : vaBox) {
			System.out.printf("%d * %s * %s\n",tb.getId() ,tb.getName(), tb.getCount());
		}

		System.out.println("<AV>");
		List<TopBox> avBox = dao.avBox();
		System.out.println("Print AV list");
		for (TopBox tb : avBox) {
			System.out.printf("%d * %s * %s\n",tb.getId() ,tb.getName(), tb.getCount());
		}
	}
}
