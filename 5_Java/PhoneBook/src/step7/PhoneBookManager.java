package step7;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public class PhoneBookManager {
	private static PhoneBookManager pbm;
	Collection infoStorage = new HashSet();

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
		Person pTemp = null;

		if (choice < SubInputMenu.NOMAL || choice > SubInputMenu.COMPANY) {
			throw new MenuChoiceException(choice);
		} // end if

		switch (choice) {
		case SubInputMenu.NOMAL:
			pTemp = readNomalPerson();
			break;
		case SubInputMenu.UNIV:
			pTemp = readUnivPerson();
			break;
		case SubInputMenu.COMPANY:
			pTemp = readCompanyPerson();
			break;
		default:
			System.out.println("잘못 입력하셨습니다.");
			System.out.println();
			return; // nullPointerException 방지
		}// end switch

		if (infoStorage.add(pTemp)) {
			System.out.println("입력완료");
			System.out.println();
		} else {
			System.out.println("입력실패: 중복자료");
			System.out.println();
		} // end if
	}// end inputData

	void allDisplay() {
		Iterator it = infoStorage.iterator();

		if (!infoStorageCheck()) {
			return;
		} // end if

		System.out.println("━━━━━━━━━━━━━━━━━━━ 연락처 리스트 ━━━━━━━━━━━━━━━━━━━");
		while (it.hasNext()) {
			Person pTemp = (Person) it.next();
			System.out.println(pTemp.showPhoneInfo());
		} // end while
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.println();
	}// end allDisplay

	void searchData() {
		if (!infoStorageCheck()) { // infoStorage가 비었는지 체크
			return;
		} // end if

		System.out.print("검색할 이름은?==> ");
		String name = MenuViewer.scanner.nextLine();

		Person pTemp = search(name);

		if (pTemp != null) {
			System.out.println(pTemp.showPhoneInfo());
			System.out.println();
		} else {
			System.out.println("해당하는 정보가 존재하지 않음");
			System.out.println();
		} // end if
	}// end searchData

	void updateData() throws MenuChoiceException {
		if (!infoStorageCheck()) { // infoStorage가 비었는지 체크
			return;
		} // end if

		System.out.print("수정할 이름은?==> ");
		String name = MenuViewer.scanner.nextLine();
		int choice = 0;

		Person pTemp = search(name);

		if (pTemp != null) { // Person 클래스의 인스턴스를 저장한 임시변수를 가지고 판단
			do {
				MenuViewer.showUpdateSubMenu(pTemp);
				choice = Integer.parseInt(MenuViewer.scanner.nextLine());

				if (choice < SubInputMenu.EXIT || choice > SubInputMenu.COMPANY) {
					throw new MenuChoiceException(choice);
				} // end if

				switch (choice) {
				case 0:
					System.out.println();
					break;
				case 1:
					System.out.print("수정할 전번==> ");
					pTemp.phoneNumber = MenuViewer.scanner.nextLine();
					break;
				case 2:
					System.out.print("수정할 생일==> ");
					pTemp.birth = MenuViewer.scanner.nextLine();
					break;
				case 3:
					if (pTemp instanceof UnivPerson) {
						UnivPerson univTemp = (UnivPerson) pTemp;
						System.out.print("수정할 전공==> ");
						univTemp.major = MenuViewer.scanner.nextLine();
					} else if (pTemp instanceof CompanyPerson) {
						CompanyPerson comTemp = (CompanyPerson) pTemp;
						System.out.print("수정할 회사==> ");
						comTemp.companyName = MenuViewer.scanner.nextLine();
					} else {
						choice = -1;
					} // end if
					break;
				case 4:
					if (pTemp instanceof UnivPerson) {
						UnivPerson univtmp = (UnivPerson) pTemp;
						System.out.print("수정할 학년==> ");
						univtmp.grade = Integer.parseInt(MenuViewer.scanner.nextLine());
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
		if (!infoStorageCheck()) { // infoStorage가 비었는지 체크
			return;
		} // end if

		allDisplay();

		System.out.print("삭제할 이름은?==> ");
		String name = MenuViewer.scanner.nextLine();

		Person pTemp = search(name);

		if (pTemp != null) {
			infoStorage.remove(pTemp);
			System.out.println("삭제 완료");
			System.out.println();
		} else {
			System.out.println("삭제할 정보가 존재하지 않음");
			System.out.println();
		} // end if
	}// end deleteData

	private Person search(String name) {
		Iterator it = infoStorage.iterator();
		Person pTemp = null;

		while (it.hasNext()) {
			pTemp = (Person) it.next();
			if (pTemp.name.equals(name)) {
				return pTemp;
			} // end if
		} // end while

		return null;
	}// end search

	private boolean infoStorageCheck() {
		if (infoStorage.isEmpty()) {
			System.out.println("저장된 정보가 없습니다.");
			System.out.println();
			return false;
		} // end if
		return true;
	}// end infoStorageCheck
}// end PhoneBookManager
