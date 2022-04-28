package version1;

public class BlackjackDeck {
	final int CARD_NUM = 52; // 카드의 개수
	BlackjackCard[] cardArr = new BlackjackCard[CARD_NUM]; // Card 객체 배열을 포함

	BlackjackDeck() {
		int i = 0;

		for (int k = BlackjackCard.KIND_MAX; k > 0; k--) {
			for (int n = 0; n < BlackjackCard.NUM_MAX; n++) {
				cardArr[i++] = new BlackjackCard(k, n + 1);
			} // end for
		} // end for
	}// end Deck()

	BlackjackCard pick(int index) { // 지정된 위치(index)에 있는 카드 하나를 꺼내서 반환
		return cardArr[index];
	}

	BlackjackCard pick() { // Deck에서 카드 하나를 선택한다.
		int index = (int) (Math.random() * CARD_NUM);
		return pick(index);
	}

	void shuffle() {
		for (int i = 0; i < cardArr.length; i++) {
			int r = (int) (Math.random() * CARD_NUM);

			BlackjackCard temp = cardArr[i];
			cardArr[i] = cardArr[r];
			cardArr[r] = temp;
		} // end for
		System.out.println("*** 카드 셔플 완료 ***");
	}// end shuffle

}// end BlackjackDeck
