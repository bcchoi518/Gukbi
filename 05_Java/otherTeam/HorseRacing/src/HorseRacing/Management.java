package HorseRacing;

import java.util.ArrayList;
import java.util.HashMap;

public class Management implements MenuViewer {
	// 각 메뉴별 관리 클래스
	SeatManager sm = new SeatManager();
	HorseManager hm = new HorseManager();
	MoneyManager mn = new MoneyManager();
	BetManager bm = new BetManager();
	RaceManager rm = new RaceManager();
	CustomerManager cm = new CustomerManager();

	// 계정목록
	static HashMap<String, Person> accountStorage = new HashMap();

	// 관리자 계정, 테스트계정 ID = PW
	final String MGRID = "sys";
	final String TESTID = "hr";

	// 생성시 계정 목록에 관리자 계정및 테스트계정을 추가
	Management() {
		// 기존에 저장된 계정리스트 파일이 있으면 불러오기, 아니면 기본 계정 두개 생성
		try {
			accountStorage = Loader.loadAccounts();
		} catch(Exception e){
			accountStorage.put(MGRID, new Person("관리자", MGRID, "1234", 1000000));
			accountStorage.put(TESTID, new Person("테스트회원", TESTID, "1234", 10000000));
			accountStorage.put("scott", new Person("경주안봐", "scott", "1234", 10000000));
		}
	}

	// 로그인
	public void login() {
		System.out.println("╚═══───────────────── • ─────────────────═══╝");
		System.out.println();
		System.out.println("╔═══───────────────── • ─────────────────═══╗");
		System.out.println("                【로그인 LOGIN】");
		System.out.print("  [ ID ] : ");
		String id = sc.nextLine();
		System.out.print("  [ 핸드폰 뒤의 네 자리 ] : ");
		String phoneNumber = sc.nextLine();
		// 사용자에게 입력받은 아이디 가 존재하는 회원의 아이디 인지 확인
		if (accountStorage.containsKey(id)) {
			// 존재하는 회원의 아이디 라면 비밀번호가 일치하는지 확인
			if (phoneNumber.equals(((Person) (accountStorage.get(id))).phoneNumber)) {
				// 관리자아이디인경우 관리자메뉴로 그게아니라면 회원메뉴로
				if (id.equals(MGRID))
					managerMenu();
				else
					customerMenu((Person) (accountStorage.get(id)));

				// 해킹방지를위해 회원정보가 존재하지않는경우와 비밀번호만 틀린 경우 모두 같은 문구를 출력
			} else
				System.out.print("  《 로그인에 실패하였습니다 》\n╚═══───────────────── • ─────────────────═══╝" );
		} else
			System.out.println("  《 로그인에 실패하였습니다 》\n╚═══───────────────── • ─────────────────═══╝");

	}

	// 회원가입
	public void signUp() {
		System.out.println("╚═══───────────────── • ─────────────────═══╝");
		System.out.println();
		System.out.println("╔═══───────────────── • ─────────────────═══╗");
		System.out.println("                【회원가입 JOIN】");

		// 이름 입력
		System.out.print("  [ 이름 ] : ");
		String name = sc.nextLine();
		
		if(name == null || name.isBlank()) {
			System.out.println("  《 이름을 입력해주세요 》");
			return;
		}

		// 아이디 입력
		String id = null;

		do {
			System.out.print("  [ ID ] : ");
			id = sc.nextLine();
			
			// 아이디가 입력되었는지 확인
			if(id == null || id.isBlank()) {
				System.out.println("  《 id를 입력해주세요 》");
			}

			// 존재하는 id인지 확인
			if (accountStorage.containsKey(id)) {
				System.out.println("  《 이미 존재하는 id 입니다 》");
			}

		} while (accountStorage.containsKey(id) || (id == null || id.isBlank()));
		
		

		// 핸드폰 뒷번호 입력
		String phoneNumber = null;
		boolean isNumeric = false;

		do {
			System.out.print("  [ 핸드폰 뒤의 네 자리 ] : ");
			phoneNumber = sc.nextLine();
			isNumeric = phoneNumber.chars().allMatch(Character::isDigit);

			if (phoneNumber.length() != 4 || isNumeric == false) {
				System.out.println("  《 네 자리 숫자를 입력해주세요 》");
			}
		} while (phoneNumber.length() != 4 || isNumeric == false);

		// 두 번 입력받은 핸드폰 뒷번호가 서로 일치하는지 확인
		System.out.println("  《 확인을 위해 한 번 더 입력해주세요 》");

		System.out.print("  [ 핸드폰 뒤의 네 자리 ] : ");
		String phoneNumber2 = sc.nextLine();

		if (!phoneNumber.equals(phoneNumber2)) {
			System.out.println("  《 핸드폰 뒷번호가 일치하지 않습니다 》");
			System.out.println("  《 회원가입을 다시 진행해주세요 》");
			System.out.println("╚═══───────────────── • ─────────────────═══╝");
			return;
		}

		// 충전할 금액 입력
		System.out.print("  [ 충전 금액 ] (10000/50000/100000) : ");
		int money = Integer.parseInt(sc.nextLine());
		
		if(!(money == 10000 || money == 50000 || money == 100000)) {
			System.out.println("  《 범위 내의 숫자를 올바른 형태로 입력하세요 》");
			System.out.println("  《 회원가입을 다시 진행해주세요 》");
			System.out.println("╚═══───────────────── • ─────────────────═══╝");
			return;
		}

		// 입력받은 정보로 회원계정을 만든 뒤 계정목록에 추가
		// id를 key로 사용
		accountStorage.put(id, new Person(name, id, phoneNumber, money));

		System.out.println("  《 회원가입이 완료되었습니다 》");
		System.out.println("╚═══───────────────── • ─────────────────═══╝");
	}

	// 고객 시점 메뉴
	private void customerMenu(Person person) {
		// 출전할 말 7마리를 랜덤으로 선출(날바뀜)
		hm.horseChoice();
		while (true) {
			// HORSEINFO=1,BETT=2,MONEY=3,SEAT=4,RACE=5,INFO=6,LOGOUT=7;
			MenuViewer.showCustomerMenu();
			try {
				int choice = Integer.parseInt(sc.nextLine().trim());
				if (choice < HORSEINFO || choice > LOGOUT)
					throw new MenuChoiceException(choice);
				switch (choice) {
				case HORSEINFO:
					hm.showInfo(hm.raceHorse);
					break;
				case BETT:
					bm.inputMoney(person);
					break;
				case MONEY:
					mn.choiceMenu(person);
					break;
				case SEAT:
					sm.choiceMenu(person);
					break;
				case RACE:
					ArrayList grade = new ArrayList();

					// scott 계정으로 들어온경우 결과를 신속하게 호출
					if (person.id.equals("scott"))
						grade = rm.testRace(hm.raceHorse);
					else
						grade = rm.race(hm.raceHorse);
					// 해당 경기에 출전했던 경주마들의 게이트번호 제거
					hm.horseOut();
					// 경기전 배팅여부에따라 알맞은 정산 메소드 호출 또는 패스
					switch (bm.betType) {
					// SAMBOK=1, SAMSSANG=2;
					case SAMBOK:
						bm.samBokReturnMoney(grade, person);
						break;
					case SAMSSANG:
						bm.samSsangReturnMoney(grade, person);
						break;
					default:
						System.out.println("              《 배팅을 하지 않았습니다 》");
						break;
					}
					// 출전할 말 7마리를 랜덤으로 선출(한경기 끝났으니까)
					hm.horseChoice();
					break;
				case INFO:
					cm.choiceMenu(person);
					break;
				case LOGOUT:
					System.out.println("  《 로그아웃 되었습니다 》");
					System.out.println("╚═══───────────────── • ─────────────────═══╝");
					return;
				}
			} catch (NumberFormatException e) {
				System.out.println("  《 숫자만 입력하세요 》");
			} catch (MenuChoiceException e) {
				e.showWrongChoice();
			}
		}
	}

	// 관리자 시점 메뉴 / 사용자가 LOGOUT값을 입력할때까지 반복
	private void managerMenu() {
		while (true) {
			// 메뉴 안내문구 출력후 선택값 입력 대기
			MenuViewer.showManagerMenu();
			// HORSEMANAGE=1,LOGOUT_M = 2;
			try {
				int choice = Integer.parseInt(sc.nextLine().trim());
				if (choice < HORSEMANAGE || choice > LOGOUT_M)
					throw new MenuChoiceException(choice);
				switch (choice) {
				case HORSEMANAGE:
					hm.managerChoice();
					break;
				case LOGOUT_M:
					System.out.println("  《 로그아웃 되었습니다 》");
					System.out.println("╚═══───────────────── • ─────────────────═══╝");
					return;
				}
			} catch (NumberFormatException e) {
				System.out.println("  《 숫자만 입력하세요 》");
			} catch (MenuChoiceException e) {
				e.showWrongChoice();
			}
		}
	}
}
