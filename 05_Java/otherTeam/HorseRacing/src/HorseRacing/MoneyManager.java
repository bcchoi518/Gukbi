package HorseRacing;

public class MoneyManager implements MenuViewer {

	public void choiceMenu(Person tmp) {
		while (true) {
			// ADD_MONEY=1, CHECK_MONEY=2,RETURN_MN=3;
			try {
				MenuViewer.moneyMenu();
				;
				int choice = Integer.parseInt(sc.nextLine());
				if (choice < ADD_MONEY || choice > RETURN_MN)
					throw new MenuChoiceException(choice);
				switch (choice) {
				case ADD_MONEY: // 금액 충전
					addMoney(tmp);
					break;
				case CHECK_MONEY: // 금액 조회
					checkMoney(tmp);
					break;
				case RETURN_MN: // 이전 메뉴로 돌아가기
					return;
				}
			} catch (NumberFormatException e) {
				System.out.println("  《 범위 내의 숫자를 올바른 형태로 입력하세요 》");
			} catch (MenuChoiceException e) {
				e.showWrongChoice();
			}
		}
	}

	//금액 충전
	void addMoney(Person tmp) {
		//본인 확인을 위한 핸드폰 뒷번호 입력
		System.out.println("╚═══───────────────── • ─────────────────═══╝");
		System.out.println();
		System.out.println("╔═══───────────────── • ─────────────────═══╗");
		System.out.println("                  【금액 충전】");
		System.out.print("  [ 핸드폰 뒤의 네 자리 ] : ");
		String phoneNumber = sc.nextLine();

		//금액 충전(숫자만 입력받을 수 있도록 함)
		if (phoneNumber.equals(tmp.phoneNumber)) {

			try {
				System.out.println("  [ 현재 보유 금액 ] : " + tmp.money + "원");
				System.out.print("  [ 충전 금액 ] (10000/50000/100000) : ");
				int money = Integer.parseInt(sc.nextLine());
				
				if(!(money == 10000 || money == 50000 || money == 100000)) {
					System.out.println("  《 범위 내의 숫자를 올바른 형태로 입력하세요 》");
					return;
				}

				tmp.money += money;

				System.out.println("  《 금액 충전이 완료되었습니다 》");
				System.out.println("  [ 현재 보유 금액 ] : " + tmp.money + "원");

			} catch (NumberFormatException e) {
				System.out.println("  《 범위 내의 숫자를 올바른 형태로 입력하세요 》");
			}
		} else if (!phoneNumber.equals(tmp.phoneNumber)) {
			System.out.println("  《 핸드폰 뒷번호가 일치하지 않습니다 》");
		}

	}

	//금액 조회
	void checkMoney(Person tmp) {
		
		//본인 확인을 위해 핸드폰 뒷번호 입력
		System.out.println("╚═══───────────────── • ─────────────────═══╝");
		System.out.println();
		System.out.println("╔═══───────────────── • ─────────────────═══╗");
		System.out.println("                  【금액 조회】");
		System.out.print("  [ 핸드폰 뒤의 네 자리 ] : ");
		String phoneNumber = sc.nextLine();

		if (phoneNumber.equals(tmp.phoneNumber)) {

			System.out.println("  [ 현재 보유 금액 ] : " + tmp.money + "원");

		} else if (!phoneNumber.equals(tmp.phoneNumber)) {
			System.out.println("  《 핸드폰 뒷번호가 일치하지 않습니다 》");
		}
	}

}