package homework;

public class Cafe {

	String[] menu;
	private int maxTable = 10;
	int curTable;

	Cafe() {
		menu = new String[] { "아메리카노", "카페라떼", "레몬에이드", "자몽에이드" };
		curTable = maxTable;
	}

	Cafe(String[] menu, int maxTable) {
		this.menu = menu;
		this.maxTable = maxTable;
		curTable = maxTable;
	}

	public int getMaxTable() {
		return maxTable;
	}// end getMaxTable

	public void setMaxTable(int maxTable) {
		this.maxTable = maxTable;
	}// end setMaxTable

	void checkTable() {
		System.out.println("현재 남은 테이블은 " + curTable + "개 입니다.");
	}// end checkTable

	void showMenu() {
		System.out.println("***** Menu *****");
		for (int i = 0; i < menu.length; i++) {
			System.out.println(" - " + menu[i]);
		} // end for
	}// end showMenu

	void order(String[] menu) {
		if (menu[0].equals("")) {
			System.out.println("주문 내역이 없습니다.");
			return;
		} else if (curTable == 0) {
			System.out.println("현재 남은 테이블이 없습니다. 잠시만 기다려 주십시오.");
			return;
		} // end if

		for (int i = 0; i < menu.length; i++) {
			System.out.print(menu[i]);
			if (i == menu.length - 1) {
				break;
			} else if (menu[i + 1].length() > 2) {
				System.out.print(", ");
			} else {
				break;
			} // end if
		} // end for

		System.out.println(" 주문이 완료되었습니다.");
		curTable--;

	}// end order

	void byebye() {
		System.out.println("안녕히 가세요. 다음에 또 이용해 주세요 ^^");
		if (curTable < maxTable) {
			curTable++;
		} // end if
	}// end byebye

}// end Cafe
