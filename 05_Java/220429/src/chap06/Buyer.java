package chap06;

public class Buyer {
	int money = 1000;
	int bonusPoint = 0;
	Product[] item = new Product[10];	//다형성. 각 제품별 클래스를 담을 수 있음
	int curCnt = 0;

	void buy(Product p) {
		if (money < p.price) {
			System.out.println("잔액이 부족하여 물건을 살 수 없습니다.");
			return;
		} // end if
		money -= p.price;
		bonusPoint += p.bonusPoint;
		item[curCnt++] = p;
		System.out.println(p + "을/를 구입하셨습니다.");
	}// end buy

	void summary() {
		int sum = 0;
		String itemList = "";

		for (int i = 0; i < item.length; i++) {
			if (item[i] == null) {
				break;
			} // end if
			sum += item[i].price;
			itemList += item[i] + ", ";
		} // end for
		System.out.println("구입하신 물품의 총금액은 " + sum + "만원입니다.");
		System.out.println("구입하신 제품은 " + itemList + "입니다.");
	}// end summary
}// end Buyer
