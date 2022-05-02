package step6;

public class PhoneBookManager {
	private static PhoneBookManager pbm;
	final int MAX_CNT = 100;
	Person[] infoStorage = new Person[MAX_CNT];
	int curCnt = 0;

	private PhoneBookManager() { // Singleton
	}

	public static PhoneBookManager getInstance() {
		if (pbm == null) {
			pbm = new PhoneBookManager();
		} // end if
		return pbm;
	}// end getInstance

	private Person readNomalPerson() {
		System.out.print("이름==> ");
		String name = MenuViewer.scanner.nextLine();
		System.out.print("전번==> ");
		String phoneNumber = MenuViewer.scanner.nextLine();
		System.out.print("생일==> ");
		String birth = MenuViewer.scanner.nextLine();

		return new Person(name, phoneNumber, birth);
	}// end readNomalPerson

	private Person readUnivPerson() { // 부모타입 반환으로 통일감을 주고 유지보수할때도 유리
		System.out.print("이름==> ");
		String name = MenuViewer.scanner.nextLine();
		System.out.print("전번==> ");
		String phoneNumber = MenuViewer.scanner.nextLine();
		System.out.print("생일==> ");
		String birth = MenuViewer.scanner.nextLine();
		System.out.print("전공==> ");
		String major = MenuViewer.scanner.nextLine();
		System.out.print("학년==> ");
		int grade = Integer.parseInt(MenuViewer.scanner.nextLine());

		return new UnivPerson(name, phoneNumber, birth, major, grade);
	}// end readUnivPerson

	private Person readCompanyPerson() {
		System.out.print("이름==> ");
		String name = MenuViewer.scanner.nextLine();
		System.out.print("전번==> ");
		String phoneNumber = MenuViewer.scanner.nextLine();
		System.out.print("생일==> ");
		String birth = MenuViewer.scanner.nextLine();
		System.out.print("회사==> ");
		String companyName = MenuViewer.scanner.nextLine();

		return new CompanyPerson(name, phoneNumber, birth, companyName);
	}// end readCompanyPerson

	void inputData() throws MenuChoiceException {
		MenuViewer.showInputSubMenu();
		int choice = Integer.parseInt(MenuViewer.scanner.nextLine());
		Person tmp = null;

		if (choice < SubInputMenu.NOMAL || choice > SubInputMenu.COMPANY) {
			throw new MenuChoiceException(choice);
		} // end if

		switch (choice) {
		case SubInputMenu.NOMAL:
			tmp = readNomalPerson();
			break;
		case SubInputMenu.UNIV:
			tmp = readUnivPerson();
			break;
		case SubInputMenu.COMPANY:
			tmp = readCompanyPerson();
			break;
		default:
			System.out.println("잘못 입력하셨습니다.");
			System.out.println();
			return; // nullPointerException 방지
		}// end switch
		infoStorage[curCnt++] = tmp;
		System.out.println("입력완료");
		System.out.println();
	}// end inputData

	void allDisplay() {
		if (infoStorage[0] == null) {
			System.out.println("저장된 정보가 없습니다.");
			System.out.println();
			return;
		} // end if

		for (int i = 0; i < curCnt; i++) {
			System.out.println((i + 1) + ". " + infoStorage[i].showPhoneInfo());
		} // end for
		System.out.println();
	}// end allDisplay

	void searchData() {
		System.out.print("검색할 이름은?==> ");
		String name = MenuViewer.scanner.nextLine();
		int index = -1; // 배열의 인덱스 처음 시작값이 0이므로 -1로 초기화

		index = search(name);

		if (index > -1) {
			System.out.println(infoStorage[index].showPhoneInfo());
			System.out.println();
		} else {
			System.out.println("해당하는 정보가 존재하지 않음");
			System.out.println();
		} // end if
	}// end searchData

	void updateData() throws MenuChoiceException {
		System.out.print("수정할 이름은?==> ");
		String name = MenuViewer.scanner.nextLine();
		int index = -1; // 배열의 인덱스 처음 시작값이 0이므로 -1로 초기화
		int choice = 0;

		index = search(name);

		if (index > -1) { // Person 클래스의 인스턴스를 저장한 임시변수를 가지고 판단
			do {
				MenuViewer.showUpdateSubMenu(infoStorage[index]);
				choice = Integer.parseInt(MenuViewer.scanner.nextLine());

				if (choice < SubInputMenu.NOMAL || choice > SubInputMenu.COMPANY) {
					throw new MenuChoiceException(choice);
				} // end if

				switch (choice) {
				case 0:
					System.out.println();
					break;
				case 1:
					System.out.print("수정할 전번==> ");
					infoStorage[index].phoneNumber = MenuViewer.scanner.nextLine();
					break;
				case 2:
					System.out.print("수정할 생일==> ");
					infoStorage[index].birth = MenuViewer.scanner.nextLine();
					break;
				case 3:
					if (infoStorage[index] instanceof UnivPerson) {
						UnivPerson tmp = (UnivPerson) infoStorage[index];
						System.out.print("수정할 전공==> ");
						tmp.major = MenuViewer.scanner.nextLine();
					} else if (infoStorage[index] instanceof CompanyPerson) {
						CompanyPerson tmp = (CompanyPerson) infoStorage[index];
						System.out.print("수정할 회사==> ");
						tmp.companyName = MenuViewer.scanner.nextLine();
					} else {
						choice = -1;
					} // end if
					break;
				case 4:
					if (infoStorage[index] instanceof UnivPerson) {
						UnivPerson tmp = (UnivPerson) infoStorage[index];
						System.out.print("수정할 학년==> ");
						tmp.grade = Integer.parseInt(MenuViewer.scanner.nextLine());
					} else {
						choice = -1;
					} // end if
					break;
				default:
					choice = -1;
					break;
				}// end switch

				if (choice > 0) {
					System.out.println("수정 완료");
					System.out.println();
				} else if (choice == -1) {
					System.out.println("잘못 누르셨습니다.");
					System.out.println();
				} // end if
			} while (choice != 0);
		} else {
			System.out.println("수정할 정보가 존재하지 않음");
			System.out.println();
		} // end if
	}// end updateData

	void deleteData() {
		System.out.print("삭제할 이름은?==> ");
		String name = MenuViewer.scanner.nextLine();
		int index = -1; // 배열의 인덱스 처음 시작값이 0이므로 -1로 초기화

		index = search(name); // searchData, updateData, deleteData에 중복되는 코드를 메서드로 정의해서 사용

		if (index > -1) { // 찾은 index로 판단
			for (int i = index; i < curCnt; i++) {
				if (i == MAX_CNT - 1) {
					infoStorage[i] = null;
				} else {
					infoStorage[i] = infoStorage[i + 1];
				} // end if
			} // end for
			curCnt--;
			System.out.println("삭제 완료");
			System.out.println();
		} else {
			System.out.println("삭제할 정보가 존재하지 않음");
			System.out.println();
		} // end if
	}// end deleteData

	private int search(String name) {
		for (int i = 0; i < curCnt; i++) {
			if (name.equals(infoStorage[i].name)) {
				return i; // 찾은 위치를 index에 저장
			} // end if
		} // end for
		return -1;
	}// end search
}// end PhoneBookManager
