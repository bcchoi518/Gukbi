package homework;

public class BlackjackTest {

	public static void main(String[] args) {
//		블랙잭 규칙
//		- 카드의 합이 21점 또는 21점에 가장 가까운 사람이 이기는 게임이다
//		- 사용하는 카드는 조커를 제외한 52장이다
//		- 에이스는 자신에게 유리하게 1점 또는 11점으로 계산할 수 있다
//		- K·Q·J·10은 10점으로 계산하며 그밖에 9 이하의 카드는 그 숫자대로 점수를 센다
//		- 처음 2장의 카드가 에이스와 10(J·Q·K를 포함)으로 21점이 된 것을 '블랙잭'이라고 하며, 보통 베팅액의 2배를 얻는다.
//		- 참가자들은 블랙잭이 아닌 경우, 합계가 21점에 가까워지도록 하기 위해 딜러로부터 카드를 추가로 받을 수 있다.
//		- 카드를 더 받지 않는 것이 유리하다고 판단되면 추가하지 않아도 된다.
//		- 딜러의 점수와 비교해서 동점이면 무승부, 딜러보다 높으면 이기고 낮으면 지게 된다.
//		- 합계가 21점을 초과하면 0점으로 간주되는데, 딜러가 21점을 초과한 경우도 0점이 되지만, 21점을 초과한 참가자의 베팅액을 딸 수 있다.

//		게임 방법
//		1. 먼저 딜러를 정하고, 딜러 이외의 사람은 카드를 받기 전에 걸고 싶은 액수의 돈을 건다
//		2. 딜러는 자기의 왼쪽부터 1장씩 돌리고, 두 번째로 또 1장씩 돌려 각자가 2장씩 갖게 한다
//		3. 딜러의 첫 번째 카드를 엎어 놓은 것 이외에는 모든 참가자의 카드가 공개된다
//		4. 참가자들은 블랙잭이 아닌 경우, 합계가 21점에 가까워지도록 하기 위해 딜러로부터 카드를 추가로 받을 수 있다

		BlackjackManager bm = new BlackjackManager();

		int choice = 0;

		do {
			BlackjackMenuViewer.showMenu();
			choice = Integer.parseInt(bm.sc.nextLine());

			switch (choice) {
			case 1:
				bm.bd.shuffle();
				break;
			case 2:
				bm.joinPlayer("딜러", "dealer");
				bm.joinPlayer("짱구");
				bm.gameInit();
				break;
			case 3:
				break;
			case 4:
				break;
			default:
				System.out.println("잘못 누르셨습니다.");
			}
		} while (choice != 4);
	}// end main

}// end BlackjackTest
