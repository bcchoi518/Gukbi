package HorseRacing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BetManager implements MenuViewer {

	// 배팅종류
	int betType = 0;

	ArrayList sb = new ArrayList(); // 삼복승 말(게이트) 저장
	ArrayList ss = new ArrayList(); // 삼쌍승 말(게이트) 저장

	final static int RATE1 = 10; // 삼복승 배당률
	final static int RATE2 = 100; // 삼쌍승 배당률

	static int bettingMoney = 0; // 배팅금액
	static int returnMoney = 0; // 승리금

	void inputMoney(Person tmp) {
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
				return;
			}else if((tmp.money>=bettingMoney) && (bettingMoney>=100 && bettingMoney<=100000)) {
				System.out.println("  《 " + bettingMoney + "원을 배팅합니다 》");
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
				continue;
			}
			
			try {
				MenuViewer.showBet();
				int choice = Integer.parseInt(sc.nextLine()); //2. 승식 선택
				if(choice<1 || choice>2) // SAMBOK=1, SAMSSANG=2;
					throw new MenuChoiceException(choice);
					switch(choice) {
						case SAMBOK: 
							samBok(); //3. 3라인 선택하기
							expectSamBok(tmp); //4. 예상적중금액
							return;
						
						case SAMSSANG: 
							samSsang();  //3. 3라인 선택하기
							expectSamSsang(tmp); //4. 예상적중금액
							return;
						
					}  //7. 영서씨 메인메뉴로 이동 - case3 : 메인메뉴로 나가기
				} catch (NumberFormatException e) {
					System.out.println("  《 숫자만 입력하세요 》");
				} catch (MenuChoiceException e) {
					e.showWrongChoice();
				}
			}
		}
	

	void samBok() {// 1번부터 7번 게이트 중 선택, 그 외 숫자 입력불가, 중복 라인 입력불가
		Scanner sc = new Scanner(System.in);
		sb = new ArrayList();

		System.out.println("╚═══───────────────── • ─────────────────═══╝");
		System.out.println();
		System.out.println("╔═══───────────────── • ─────────────────═══╗");
		System.out.println("               【세 군데 게이트 선택】");
		System.out.printf("  《 1~7번 게이트 중 세 곳을 선택하세요(배당률 %d배) 》\n", RATE1);
		
		while(true) {
			try {
				
				while (true) { // 사용자가 게이트 세 곳을 모두 입력할때까지 반복
					if (sb.size() == 3)
						break;
					System.out.print("  [ " + (sb.size() + 1) + "번째 게이트 번호 ] : ");
					int input = Integer.parseInt(sc.nextLine());
					
					if (input < 1 || input > 7)
						throw new MenuChoiceException(input);
		
					if (sb.contains(input)) { // 이미 선택한 게이트번호이면 문구출력, 아니면 추가
						System.out.println("  《 이미 선택한 게이트입니다 》");
					} else
						sb.add(input);
				}
		
				System.out.println("  《 선택하신 게이트 번호는 " + sb + "입니다 》"); // 선택한 게이트 세 곳 출력
				betType = 1;
				break;
			} catch (NumberFormatException e) {
				System.out.println("  《 숫자만 입력하세요 》");
				System.out.println("╚═══───────────────── • ─────────────────═══╝");
			} catch (MenuChoiceException e) {
				e.showWrongChoice();
			}
		}
	}

	void samSsang() {// 1번부터 7번 게이트 중 선택, 그 외 숫자 입력불가, 중복 라인 입력불가
		Scanner sc = new Scanner(System.in);
		ss = new ArrayList();

		System.out.println("╚═══───────────────── • ─────────────────═══╝");
		System.out.println();
		System.out.println("╔═══───────────────── • ─────────────────═══╗");
		System.out.println("               【세 군데 게이트 선택】");
		System.out.printf("  《 1~7번 게이트 중 세 곳을 선택하세요(배당률 %d배) 》\n", RATE2);
		
		while(true) {
			try {

				while (true) { // 사용자가 게이트번호 세개를 모두 입력할때까지 반복
					if (ss.size() == 3)
						break;
					System.out.print("  [ " + (ss.size() + 1) + "번째 게이트 번호(순위 순) ] : ");
					int input = Integer.parseInt(sc.nextLine());
					
					if (input < 1 || input > 7)
						throw new MenuChoiceException(input);
		
					if (ss.contains(input)) { // 이미 선택한 게이트번호이면 문구출력, 아니면 추가
						System.out.println("  《 이미 선택한 게이트입니다 》");
					} else
						ss.add(input);
				}
		
				System.out.println("  《 선택하신 게이트 번호는 " + ss + "입니다 》"); // 선택한 게이트 세 곳 출력
				betType = 2;
				break;
			} catch (NumberFormatException e) {
				System.out.println("  《 숫자만 입력하세요 》");
				System.out.println("╚═══───────────────── • ─────────────────═══╝");
			} catch (MenuChoiceException e) {
				e.showWrongChoice();
			}
		}

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
		System.out.println("  [ 실제 경주 1~3위 게이트 ] : " + grade); 
		System.out.println("  [ 선택하신 세 군데 게이트 ] : " + sb); 
		
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
		System.out.println("  [ 실제 경주 1~3위 게이트(순위 순) ] : " + grade); 
		System.out.println("  [ 선택하신 세 군데 게이트(순위 순) ] : " + ss); 
		
		boolean result1 = false;
	    boolean result2 = false;
	    boolean result3 = false;
	      
	    result1 = grade.get(0).equals(ss.get(0)) ? true : false;
	    result2 = grade.get(1).equals(ss.get(1)) ? true : false;
	    result3 = grade.get(2).equals(ss.get(2)) ? true : false;
	      
	    if (result1 == true && result2 == true && result3 == true) {
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