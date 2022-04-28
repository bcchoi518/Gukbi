package homework;

public class BlackjackPlayer {
	final int SUM_BUST_MAX = 12; // 가장 작은 수로 21을 넘어서 bust되는 카드 갯수 12장
	BlackjackCard[] selectedCard = new BlackjackCard[SUM_BUST_MAX];
	String name;
	long bet;
	boolean dealer;
	int cardCnt;

	BlackjackPlayer(String name) {
		this.name = name;
	}

	BlackjackPlayer(String name, String position) {
		this.name = name;
		if (position.equals("dealer")) {
			dealer = true;
		} // end if
	}

	void cardOpen() {
		int i = 0;
		System.out.println(name + "님 카드 현황");
		if (dealer) {
			i = 1;
			System.out.println("Card No.1 : ??");
		} // end if

		for (; i < cardCnt; i++) {
			System.out.println("Card No." + (i + 1) + " : " + selectedCard[i]);
		} // end for
		System.out.println();
	}// end cardOpen

}// end Player
