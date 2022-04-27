package step3;

public class PhoneBookManager {
	final int MAX_CNT = 100;
	Person[] infoStorage = new Person[MAX_CNT];
	int curCnt = 0;

	void inputData() {
		System.out.print("이름==> ");
		String name = MenuViewer.scanner.nextLine();
		System.out.print("전번==> ");
		String phoneNumber = MenuViewer.scanner.nextLine();
		System.out.print("생일==> ");
		String birth = MenuViewer.scanner.nextLine();

		infoStorage[curCnt++] = new Person(name, phoneNumber, birth);
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
			System.out.print((i + 1) + ". ");
			infoStorage[i].showPhoneInfo();
		} // end for
	}// end allDisplay

	void searchData() {
		System.out.print("검색할 이름은?==> ");
		String name = MenuViewer.scanner.nextLine();
		Person tmp = null; // Person 클래스의 인스턴스를 저장할 임시변수

		for (int i = 0; i < curCnt; i++) {
			if (name.equals(infoStorage[i].name)) {
				tmp = infoStorage[i]; // 검색한 인스턴스를 Person 클래스의 인스턴스를 저장할 임시변수에 저장
				break;
			} // end if
		} // end for

		if (tmp != null) { // Person 클래스의 인스턴스를 저장한 임시변수를 가지고 판단
			tmp.showPhoneInfo();
		} else {
			System.out.println("해당하는 정보가 존재하지 않음");
			System.out.println();
		} // end if
	}// end searchData

	void updateData() {
		System.out.print("수정할 이름은?==> ");
		String name = MenuViewer.scanner.nextLine();
//		searchData에서 Person 클래스의 인스턴스를 저장할 임시변수를 이용하였으니
//		updateData에서는 배열의 index를 이용하여 검색하는 기능으로 구현해봄 
		int index = -1; // 배열의 인덱스 처음 시작값이 0이므로 -1로 초기화

		for (int i = 0; i < curCnt; i++) {
			if (name.equals(infoStorage[i].name)) {
				index = i;
				break;
			} // end if
		} // end for

		if (index > -1) { // Person 클래스의 인스턴스를 저장한 임시변수를 가지고 판단
			System.out.print("수정할 전번==> ");
			infoStorage[index].phoneNumber = MenuViewer.scanner.nextLine();
			System.out.print("수정할 생일==> ");
			infoStorage[index].birth = MenuViewer.scanner.nextLine();
			System.out.println("수정 완료");
			System.out.println();
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
