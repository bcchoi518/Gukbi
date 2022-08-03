package chap04;

import java.util.HashMap;
import java.util.Scanner;

public class HashMapEx1 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		HashMap map = new HashMap();
		map.put("myId", "1234");
		map.put("asdf", "1111");
		map.put("asdf", "1234"); // key를 비교하여 존재하면 뒤에 들어오는 value로 덮어씀

		while (true) {
			System.out.println("ID와 password를 입력해 주세요");
			System.out.print("ID: ");
			String id = s.nextLine().trim();
			System.out.print("password: ");
			String password = s.nextLine().trim();

			if (!map.containsKey(id)) { // id가 포함되어있지 않으면 수행
				System.out.println("입력하신 ID는 존재하지 않습니다. 다시 입력해주세요.");
				System.out.println();
				continue;
			} // end if

			if (!map.get(id).equals(password)) { // map.get(key): key에 해당하는 value값을 가져옴
				System.out.println("비밀번호가 일치하지 않습니다. 다시 입력해주세요");
				System.out.println();
			} else {
				System.out.println("ID와 비밀번호가 일치합니다.");
				break;
			} // end if
		} // end while
	}// end main
}// end HashMapEx1
