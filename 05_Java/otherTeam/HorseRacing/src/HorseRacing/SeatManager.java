package HorseRacing;

import java.time.*;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

public class SeatManager implements MenuViewer {
	public static int[][] seat;
	
	// 저장된 좌석정보가 있으면 로드, 없으면 생성
	SeatManager() {
		try{
			seat=Loader.loadSeat();
		}catch(Exception e){
			seat = new int[5][5];
		}
	}
	
	void choiceMenu(Person tmp) {
		while (true) {
			// TICKET=1,CHECK=2,CANCEL=3,RETURN=4;
			try {
				MenuViewer.showSeatMenu();
				int choice = Integer.parseInt(sc.nextLine());
				if (choice < TICKET || choice > RETURN)
					throw new MenuChoiceException(choice);
				switch (choice) {
				case TICKET: // 좌석 예매
					seatTicketing(tmp);
					break;
				case CHECK: // 좌석 조회
					seatCheck(tmp);
					break;
				case CANCEL: // 좌석 취소
					seatCancel(tmp);
					break;
				case RETURN: // 이전 메뉴로 돌아가기
					return;
				}
			} catch (NumberFormatException e) {
				System.out.println("  《 범위 내의 숫자를 올바른 형태로 입력하세요 》");
				System.out.println();
			} catch (MenuChoiceException e) {
				e.showWrongChoice();
			}
		}
	}
	
	// string이 비었는지 확인하는 메서드
	boolean isStringEmpty(String str) {
		return str == null || str.isBlank();
	}	

	// 좌석 예매
	void seatTicketing(Person tmp) {

		// 이미 예매한 좌석이 있는지 확인
		if (!isStringEmpty(tmp.seat)) {
			System.out.println("  《 이미 예매한 좌석이 존재합니다 》");
			return;
		}

		// 본인 확인을 위해 핸드폰 뒷번호 확인
		System.out.println("╚═══───────────────── • ─────────────────═══╝");
		System.out.println();
		System.out.println("╔═══───────────────── • ─────────────────═══╗");
		System.out.println("                  【좌석 예매】");
		System.out.print("  [ 핸드폰 뒤의 네 자리 ] : ");
		String phoneNumber = sc.nextLine();

		// 조건 : 핸드폰 번호 일치, 보유 금액 10000원 이상
		if (phoneNumber.equals(tmp.phoneNumber) && tmp.money >= 10000) {

			// 이름 및 잔여 금액 출력
			System.out.println("  [ 이름 ] : " + tmp.name);
			System.out.println("  [ 현재 보유 금액 ] : " + tmp.money + "원");

			// 좌석 배치도 출력
			seatViewer();

			// 경기 날짜 설정(한 주 뒤의 토요일)
			LocalDate day = LocalDate.now();
			DayOfWeek dow = day.getDayOfWeek();

			if (dow == DayOfWeek.SATURDAY) {

				day = day.with(TemporalAdjusters.next(DayOfWeek.SATURDAY));

			} else {
				day = day.with(TemporalAdjusters.next(DayOfWeek.SATURDAY));
				day = day.with(TemporalAdjusters.next(DayOfWeek.SATURDAY));
			}

			// 경기 날짜 및 좌석 가격 출력
			System.out.println("  [ 경기 날짜 ] : " + day + "(토)");
			System.out.println("  [ 좌석 가격 ] : 10000원");

			// 좌석 선택			
			// 행 선택(범위 내의 숫자가 입력될 때까지 반복문을 통해 입력받음)
			System.out.println("  [A]:1, [B]:2, [C]:3, [D]:4, [E]:5");
			String row = "";
			int i_row = 0;
			boolean isNumeric_row = false;

			do {
				System.out.print("  [ 행 선택 ] : ");
				row = sc.nextLine();
				isNumeric_row = row.chars().allMatch(Character::isDigit);

				if (isNumeric_row == true) {
					i_row = Integer.parseInt(row.substring(0, row.length()));
				}

				if (i_row < 1 || i_row > 5) {
					System.out.println("  《 범위 내의 숫자를 입력해주세요 》");
				}
			} while (i_row < 1 || i_row > 5);

			
			// 열 선택(범위 내의 숫자가 입력될 때까지 반복문을 통해 입력받음)

			String column = "";
			int i_column = 0;
			boolean isNumeric_column = false;

			do {
				System.out.print("  [ 열 선택 ] : ");
				column = sc.nextLine();
				isNumeric_column = column.chars().allMatch(Character::isDigit);

				if (isNumeric_column == true) {
					i_column = Integer.parseInt(column.substring(0, column.length()));
				}

				if (i_column < 1 || i_column > 5) {
					System.out.println("  《 범위 내의 숫자를 입력해주세요 》");
				}
			} while (i_column < 1 || i_column > 5);

			
			
			//이미 예매된 좌석이면 return
			if (seat[i_row - 1][i_column - 1] != 0) {
				System.out.println("  《 이미 예매된 좌석입니다 》");
				return;
			}			
			
			// 예매 결과 출력
			if (seat[i_row - 1][i_column - 1] == 0) {
				seat[i_row - 1][i_column - 1] = 1;

				tmp.seat = row + column;
				tmp.money -= 10000;

				switch (row) {
				case "1":
					System.out.println("  《 A" + column + " 좌석이 예매되었습니다 》");
					break;
				case "2":
					System.out.println("  《 B" + column + " 좌석이 예매되었습니다 》");
					break;
				case "3":
					System.out.println("  《 C" + column + " 좌석이 예매되었습니다 》");
					break;
				case "4":
					System.out.println("  《 D" + column + " 좌석이 예매되었습니다 》");
					break;
				case "5":
					System.out.println("  《 E" + column + " 좌석이 예매되었습니다 》");
					break;
				}
			}

		// 핸드폰 번호가 일치하지 않는 경우 
		} else if (!phoneNumber.equals(tmp.phoneNumber)) {
			System.out.println("  《 핸드폰 뒷번호가 일치하지 않습니다 》");
			
		// 잔액이 부족한 경우 	
		} else if (tmp.money < 10000) {
			System.out.println("  《 잔액이 부족합니다 》");
		}

	}

	// 좌석 조회
	void seatCheck(Person tmp) {
		
		// 좌석 예매 내역이 존재하는지 확인
		if (isStringEmpty(tmp.seat)) {
			System.out.println("  《 좌석 예매 내역이 존재하지 않습니다 》");
			return;
		}

		// 본인 확인을 위해 핸드폰 뒷번호 확인
		System.out.println("╚═══───────────────── • ─────────────────═══╝");
		System.out.println();
		System.out.println("╔═══───────────────── • ─────────────────═══╗");
		System.out.println("                  【좌석 조회】");
		System.out.print("  [ 핸드폰 뒤의 네 자리 ] : ");
		String phoneNumber = sc.nextLine();

		// 조건 : 핸드폰 뒷번호 일치
		if (phoneNumber.equals(tmp.phoneNumber)) {			

			// 경기 날짜 설정(한 주 뒤의 토요일)
			LocalDate day = LocalDate.now();
			DayOfWeek dow = day.getDayOfWeek();

			if (dow == DayOfWeek.SATURDAY) {

				day = day.with(TemporalAdjusters.next(DayOfWeek.SATURDAY));

			} else {
				day = day.with(TemporalAdjusters.next(DayOfWeek.SATURDAY));
				day = day.with(TemporalAdjusters.next(DayOfWeek.SATURDAY));
			}
			System.out.println("  [ 경기 날짜 ] : " + day + "(토)");

			// 좌석 번호 출력
			char r = tmp.seat.charAt(0);
			char c = tmp.seat.charAt(1);

			switch (r) {
			case '1':
				System.out.println("  《 " + tmp.name + "님의 좌석은 A" + c + "입니다 》");
				break;
			case '2':
				System.out.println("  《 " + tmp.name + "님의 좌석은 B" + c + "입니다 》");
				break;
			case '3':
				System.out.println("  《 " + tmp.name + "님의 좌석은 C" + c + "입니다 》");
				break;
			case '4':
				System.out.println("  《 " + tmp.name + "님의 좌석은 D" + c + "입니다 》");
				break;
			case '5':
				System.out.println("  《 " + tmp.name + "님의 좌석은 E" + c + "입니다 》");
				break;
			}
		
		// 핸드폰 번호가 일치하지 않는 경우
		} else if (!phoneNumber.equals(tmp.phoneNumber)) {
			System.out.println("  《 핸드폰 뒷번호가 일치하지 않습니다 》");
		}

	}

	// 좌석 취소
	void seatCancel(Person tmp) {
		
		// 예매 좌석이 존재하는지 확인
		if(isStringEmpty(tmp.seat)) {
			System.out.println("  《 좌석 예매 내역이 존재하지 않습니다 》");
			return;
		}
		
		// 본인 확인을 위해 핸드폰 뒷번호 입력
		System.out.println("╚═══───────────────── • ─────────────────═══╝");
		System.out.println();
		System.out.println("╔═══───────────────── • ─────────────────═══╗");
		System.out.println("                  【좌석 취소】");
		System.out.print("  [ 핸드폰 뒤의 네 자리 ] : ");
		String phoneNumber = sc.nextLine();

		// 조건 : 핸드폰 뒷번호 일치
		if (phoneNumber.equals(tmp.phoneNumber)) {

			// 취소 의사 다시 한 번 확인
			System.out.println("  《 예매된 좌석을 취소하시겠습니까 》");
			System.out.println("  [1] 예매 취소 [2] 메뉴로 돌아가기");
			System.out.print("  [ 입력 ] : ");
			int choice = Integer.parseInt(sc.nextLine());

			if (choice > 2) {
				System.out.println("  《 " + choice + "번에 해당하는 메뉴는 없습니다 》");
				return;
			}

			switch (choice) {

			// [1] 좌석 취소
			case 1:
				int tmpRow = Integer.parseInt(tmp.seat.substring(0, 1));
				int tmpColumn = Integer.parseInt(tmp.seat.substring(1, 2));

				seat[tmpRow - 1][tmpColumn - 1] = 0;

				tmp.seat = "";
				tmp.money += 10000;

				System.out.println("  《 예매 좌석 취소 및 환불이 완료되었습니다 》");

			// [2] 돌아가기
			case 2:
				return;
			}

		} else if (!phoneNumber.equals(tmp.phoneNumber)) {
			System.out.println("  《 핸드폰 뒷번호가 일치하지 않습니다 》");
		} 

	}

	// 좌석 배치도
	void seatViewer() {
		System.out.println();
		System.out.println("                ----경기장----");
		System.out.println("                [A] 1 2 3 4 5");
		System.out.println("                [B] 1 2 3 4 5");
		System.out.println("                [C] 1 2 3 4 5");
		System.out.println("                [D] 1 2 3 4 5");
		System.out.println("                [E] 1 2 3 4 5");
		System.out.println();
	}
	

}