package chap03;

import java.util.HashSet;
import java.util.Set;

public class SetTest {
	public static void main(String[] args) {
		Set set = new HashSet();

		System.out.println(set.add(3)); // true
		set.add(2);
		set.add(24);
		set.add(1);
		set.add(12);
		set.add(9);
		set.add(5);
		set.add(11);
		set.add(7);
		set.add(15);
		set.add(4);
		set.add(6);
		set.add(20);
		set.add(8);
		set.add(0);
		set.add(33);
		set.add(30);
		set.add(31);
		set.add(32);
		set.add(34);
		set.add(28);
		set.add(44);
		set.add(13);
		set.add(18);
		set.add(14);
		System.out.println(set.add(3)); // false(중복된 데이터라서 add 실패)
		set.add(19);
		set.add(21);
		set.add(48);
		set.add(49);
		set.add(66);
		set.add(60);
		set.add(61);
		set.add(62);
		set.add(63);
		set.add(64);

		// 3, 2, 1 순서로 add 했지만 출력하면 1, 2, 3으로 나옴(저장 순서 상관 없음)
		System.out.println(set);

//		신기하네 어떤 특정한 조건이 만족되면 자동으로 정렬해서 출력을 해주는것같네?
	}// end main
}// end SetTest
