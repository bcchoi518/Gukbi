package HorseRacing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Bet implements MenuViewer {

	// 배팅종류
	int betType = 0;

	ArrayList sb = new ArrayList(); // 삼복승 말 저장
	ArrayList ss = new ArrayList(); // 삼쌍승 말 저장

	final static int RATE1 = 10; // 삼복승 배당률
	final static int RATE2 = 100; // 삼쌍승 배당률

	static int bettingMoney = 0; // 배팅금액
	static int returnMoney = 0; // 승리금

	static void inputMoney(Person tmp) {
		while (true) {
			System.out.println("╚═══───────────────── • ─────────────────═══╝");
			System.out.println();
			System.out.println("╔═══───────────────── • ─────────────────═══╗");
			System.out.println("                【배팅 금액 설정】");
			System.out.println("  [ 현재 보유한 잔액 ] : " + tmp.money + "원");
			System.out.print("  [ 배팅 금액(최소 100원, 최대 10만원) ] : ");
			bettingMoney = Integer.parseInt(sc.nextLine());

			if(tmp.money < 100) {
				System.out.println("  《 보유 잔액이 부족합니다 》");
				System.out.println("  《 금액을 다시 설정해주세요 》");
				System.out.println();
				return;
			}else if((tmp.money>=bettingMoney) && (bettingMoney>=100 && bettingMoney<=100000)) {
				System.out.println("  《 " + bettingMoney + "원을 배팅합니다 》");
			//	tmp.money = tmp.money - bettingMoney;
			//	System.out.printf("현재 잔액 : %d원", tmp.money);
				System.out.println();
				break;
			} else if (bettingMoney < 100) {
				System.out.println("  《 최소 100원을 베팅하셔야합니다 》");
				System.out.println("  《 금액을 다시 설정해주세요 》");
				continue;
			} else if (bettingMoney > 100000) {
				System.out.println("  《 1회 최대 베팅금액을 초과하셨습니다 》");
				System.out.println("  《 금액을 다시 설정해주세요 》");
				continue;
			} else if ((bettingMoney <= 100000) && (bettingMoney > tmp.money)) {
				System.out.println("  《 보유 잔액이 부족합니다 》");
				System.out.println("  《 금액을 다시 설정해주세요 》");
				System.out.println();
				continue;
			}
		}
	}

	void samBok() {// 1번부터 7번 말 중 선택, 그 외 숫자 입력불가, 중복 라인 입력불가
		Scanner sc = new Scanner(System.in);
		int input = 0; //말선택
		sb = new ArrayList();

		System.out.println("╚═══───────────────── • ─────────────────═══╝");
		System.out.println();
		System.out.println("╔═══───────────────── • ─────────────────═══╗");
		System.out.println("               【세 마리 말 선택】");
		System.out.printf("  《 1~7번 말 중 세 마리를 선택하세요(배당률 %d배) 》\n", RATE1);

		while (true) { // 사용자가 말번호 세개를 모두 입력할때까지 반복
			if (sb.size() == 3)
				break;
			System.out.print("  [ " + (sb.size() + 1) + "번째 말 번호 ] : ");
			input = Integer.parseInt(sc.nextLine());

			if (sb.contains(input)) { // 이미 선택한 말번호이면 문구출력, 아니면 추가
				System.out.println("  《 이미 선택한 말입니다 》");
			} else
				sb.add(input);
		}

		System.out.println("  《 선택하신 말 번호는 " + sb + "입니다 》"); // 선택한 세마리 말번호 출력
		System.out.println();

		betType = 1;
	}

	void samSsang() {// 1번부터 7번 말 중 선택, 그 외 숫자 입력불가, 중복 라인 입력불가
		Scanner sc = new Scanner(System.in);
		int input = 0; //말선택
		ss = new ArrayList();

		System.out.println("╚═══───────────────── • ─────────────────═══╝");
		System.out.println();
		System.out.println("╔═══───────────────── • ─────────────────═══╗");
		System.out.println("               【세 마리 말 선택】");
		System.out.printf("  《 1~7번 말 중 세 마리를 선택하세요(배당률 %d배) 》\n", RATE2);

		while (true) { // 사용자가 말번호 세개를 모두 입력할때까지 반복
			if (ss.size() == 3)
				break;
			System.out.print("  [ " + (ss.size() + 1) + "번째 말 번호 ] : ");
			input = Integer.parseInt(sc.nextLine());

			if (ss.contains(input)) { // 이미 선택한 말번호이면 문구출력, 아니면 추가
				System.out.println("  《 이미 선택한 말입니다 》");
			} else
				ss.add(input);
		}

		System.out.println("  《 선택하신 말 번호는 " + ss + "입니다 》"); // 선택한 세마리 말번호 출력
		System.out.println();

		betType = 2;

	}

	void expectSamBok(Person tmp) { // 삼복승
		tmp.money = tmp.money-bettingMoney;
		
		System.out.println("╚═══───────────────── • ─────────────────═══╝");
		System.out.println();
		System.out.println("╔═══───────────────── • ─────────────────═══╗");
		System.out.println("                  【예상 수익】");
		System.out.println("  [ 예상 배당률 ] : " + RATE1 + "배"); // 예상배당률
		System.out.println("  [ 배팅 금액 ] : " + bettingMoney + "원"); // 베팅금액
		System.out.println("  [ 예상 적중 금액 ] : " + (bettingMoney * RATE1) + "원"); // 예상적중금액
		System.out.println("  《 이전 메뉴로 돌아갑니다 》");
		System.out.println("  《 경주를 관람해주세요 》");
	}

	void expectSamSsang(Person tmp) { // 삼쌍승
		tmp.money = tmp.money-bettingMoney;
		
		System.out.println("╚═══───────────────── • ─────────────────═══╝");
		System.out.println();
		System.out.println("╔═══───────────────── • ─────────────────═══╗");
		System.out.println("                  【예상 수익】");
		System.out.println("  [ 예상 배당률 ] : " + RATE2 + "배"); // 예상배당률
		System.out.println("  [ 배팅 금액 ] : " + bettingMoney + "원"); // 베팅금액
		System.out.println("  [ 예상 적중 금액 ] : " + (bettingMoney * RATE2) + "원"); // 예상적중금액
		System.out.println("  《 이전 메뉴로 돌아갑니다 》");
		System.out.println("  《 경주를 관람해주세요 》");
	}

	void samBokReturnMoney(ArrayList grade, Person tmp) {

		// grade와 sb 같은 값만 가지면 됨.
		System.out.println("╚═══───────────────── • ─────────────────═══╝");
		System.out.println();
		System.out.println("╔═══───────────────── • ─────────────────═══╗");
		System.out.println("               【삼복승 결과 정산】");
		System.out.println("  [ 실제 경주 1~3위 말 ] : " + grade); 
		System.out.println("  [ 선택하신 세 마리 말 ] : " + sb); 
		
		Collections.sort(grade);
		Collections.sort(sb);
		
			if (grade.equals(sb)) {
				returnMoney = bettingMoney * RATE1;
				System.out.printf("  《 예상적중 》 %d원을 획득하셨습니다.\n", returnMoney);
				tmp.money = tmp.money + returnMoney;
				System.out.println("  [ 현재 잔액 ] : " + tmp.money + "원"); 
				// 3초후 이동 추가
			} else {
				System.out.println("  《 승부 예상 실패 》");
				System.out.println("  [ 현재 잔액 ] : " + tmp.money + "원");
				// 3초후 이동 추가
			}
		
		betType = 0;
	}

	private boolean equals(ArrayList grade, int[] sb2) {
		// TODO Auto-generated method stub
		return false;
	}

	void samSsangReturnMoney(ArrayList grade, Person tmp) {
		
		// grade와 ss 같은 값, 순서 모두 일치
		System.out.println("╚═══───────────────── • ─────────────────═══╝");
		System.out.println();
		System.out.println("╔═══───────────────── • ─────────────────═══╗");
		System.out.println("               【삼쌍승 결과 정산】");
		System.out.println("  [ 실제 경주 1~3위 말 ] : " + grade); 
		System.out.println("  [ 선택하신 세 마리 말 ] : " + ss); 
		boolean result = false;
		for (int i = 0; i < grade.size(); i++) {
			result = grade.get(i).equals(ss.get(i)) ? true : false;
		}
		if (result == true) {
			returnMoney = bettingMoney * RATE1;
			System.out.printf("  《 예상적중 》 %d원을 획득하셨습니다.\n", returnMoney);
			tmp.money = tmp.money + returnMoney;
			System.out.println("  [ 현재 잔액 ] : " + tmp.money + "원"); 
			System.out.println();
			// 3초후 이동
		} else {
			System.out.println("  《 승부 예상 실패 》");
			System.out.println("  [ 현재 잔액 ] : " + tmp.money + "원");
			System.out.println();
			// 3초후 이동
		}
		betType = 0;
	}

}