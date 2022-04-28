package homework;

import java.util.Scanner;

public class BlackjackManager {
	Scanner sc = new Scanner(System.in);
	BlackjackDeck bd = new BlackjackDeck(); // 카드 한 벌(Deck)을 만든다.
	final int MAX_PLAYER = 2;
	BlackjackPlayer[] player = new BlackjackPlayer[MAX_PLAYER];
	int playerCnt;

	void joinPlayer(String name, String position) {
		player[playerCnt++] = new BlackjackPlayer(name, position);
	}// end joinPlayer

	void joinPlayer(String name) {
		player[playerCnt++] = new BlackjackPlayer(name);
	}// end joinPlayer

	void gameInit() {
		for (int i = 0; i < 2; i++) {
			for (int k = 0; k < playerCnt; k++) {
				player[k].selectedCard[i] = bd.pick();
				player[k].cardCnt++;
			} // end for
		} // end for

		for (int i = 0; i < playerCnt; i++) {
			player[i].cardOpen();
		} // end for
	}// end drawCard

}// end BlackjackManager
