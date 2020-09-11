package test;

import java.util.List;

import model.GetPiPartVALogic;
import model.Product_staff;

public class test03 {

// カンマ区切りがうまく行ったので、ここに残しておきます。
	// リストの中から名前だけ取り出して配列を作成し、文字列変換してます。
	// 呼び出すときは単一の変数を呼び出すと、変換済みの文字列を表示できます。
	System.out.println(">>> Create partVA and setAttribute");
	GetPiPartVALogic getPartVA = new GetPiPartVALogic();
	List<Product_staff> partVA = getPartVA.execute();
	String[] arrayVA = new String[partVA.size()];
	int i = 0;
	for (Product_staff staff : partVA) {
		String name = staff.getName();
		arrayVA[i] = name;
		System.out.println("partVA[" + i + "] = " + arrayVA[i]);
		i = i+1;
	}
	String partVAc = String.join(", ", arrayVA);
	request.setAttribute("partVA", partVAc);



	// URL自動生成用
	<a href="<c:url value="/voice_actor_information" ><c:param name="searchId" value="${partVA.id}" /></c:url>">
	</a>
}
