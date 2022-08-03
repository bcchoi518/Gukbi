package HorseRacing;

public class CustomerManager implements MenuViewer {

	public void choiceMenu(Person tmp) {
		while (true) {
			// INFO_CUSTOMER=1, MODIFY_PHONENUMBER=2,RETURN_CMN=3;
			try {
				MenuViewer.customerMenu();
				;
				int choice = Integer.parseInt(sc.nextLine());
				if (choice < INFO_CUSTOMER || choice > RETURN_CMN)
					throw new MenuChoiceException(choice);
				switch (choice) {
				case INFO_CUSTOMER: // 회원 정보 조회
					infoCustomer(tmp);
					break;
				case MODIFY_PHONENUMBER: // 핸드폰 뒷번호 수정
					modifyPassword(tmp);
					break;
				case RETURN_CMN: // 이전 메뉴로 돌아가기
					return;
				}
			} catch (NumberFormatException e) {
				System.out.println("  《 범위 내의 숫자를 올바른 형태로 입력해주세요 》");
				System.out.println();
			} catch (MenuChoiceException e) {
				e.showWrongChoice();
			}
		}
	}

	// 회원 정보 조회
	public void infoCustomer(Person tmp) {
		// 본인 확인을 위한 핸드폰 뒷번호 입력
		System.out.println("╚═══───────────────── • ─────────────────═══╝");
		System.out.println();
		System.out.println("╔═══───────────────── • ─────────────────═══╗");
		System.out.println("                【회원 정보 조회】");
		System.out.print("  [ 핸드폰 뒤의 네 자리 ] : ");
		String phoneNumber = sc.nextLine();

		// 입력받은 값이 핸드폰 뒷번호와 일치하지 않으면 메뉴로 돌아감
		if (!phoneNumber.equals(tmp.phoneNumber)) {
			System.out.println("  《 핸드폰 뒷번호가 일치하지 않습니다 》");
			return;
		}

		// 회원정보 출력
		System.out.println();
		System.out.println(tmp);
	}

	// 회원 정보 수정
	public void modifyPassword(Person tmp) {
		// 본인 확인을 위한 핸드폰 뒷번호 입력
		System.out.println("╚═══───────────────── • ─────────────────═══╝");
		System.out.println();
		System.out.println("╔═══───────────────── • ─────────────────═══╗");
		System.out.println("                【회원 정보 수정】");
		System.out.println("  《 핸드폰 뒷번호를 변경합니다 》");
		System.out.println("  《 기존의 핸드폰 뒷번호를 입력하세요 》");

		System.out.print("  [ 핸드폰 뒤의 네 자리 ] : ");
		String phoneNumber = sc.nextLine();

		// 입력받은 값이 핸드폰 뒷번호와 일치하지 않으면 메뉴로 돌아감
		if (!phoneNumber.equals(tmp.phoneNumber)) {
			System.out.println("  《 핸드폰 뒷번호가 일치하지 않습니다 》");
			return;
		}

		System.out.println("  《 본인 확인이 완료되었습니다 》");
		System.out.println("  《 변경할 핸드폰 뒷번호를 입력하세요 》");

		// 변경할 핸드폰 뒷번호 입력
		String phoneNumber1 = null;
		boolean isNumeric = false;

		do {
			System.out.println("  《 네 자리 숫자를 입력해주세요 》");
			System.out.print("  [ 핸드폰 뒤의 네 자리 ] : ");
			phoneNumber1 = sc.nextLine();
			isNumeric = phoneNumber1.chars().allMatch(Character::isDigit);
			// 네 자리 숫자만 입력가능하도록 설정
		} while (phoneNumber1.length() != 4 || isNumeric == false);

		// 확인을 위해 한번 더 입력
		System.out.println("  《 확인을 위해 한 번 더 입력하세요 》");
		System.out.print("  [ 핸드폰 뒤의 네 자리 ] : ");
		String phoneNumber2 = sc.nextLine();

		if (phoneNumber1.equals(phoneNumber2)) {
			System.out.println("  《 핸드폰 뒷번호 변경이 완료되었습니다 》");
			tmp.phoneNumber = phoneNumber1;
		} else if (!phoneNumber1.equals(phoneNumber2)) {
			System.out.println("  《 핸드폰 뒷번호가 일치하지 않습니다 》");
			return;
		}

	}

}
