package chap01;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayListEx1 {
	public static void main(String[] args) {
		ArrayList list1 = new ArrayList(10); // ArrayList는 용량이 부족하면 자동으로 추가한다
		list1.add(new Integer(5));
		list1.add(4);
		list1.add(2);
		list1.add(0);
		list1.add(1);
		list1.add(3);

		ArrayList list2 = new ArrayList(list1.subList(1, 4)); // list1의 1~3번 인덱스에 해당하는 값을 가진 list2를 만든다
		print(list1, list2);

		Collections.sort(list1); // list1을 정렬
		Collections.sort(list2); // list2를 정렬
		print(list1, list2);

		// list1에 지정된 list2의 모든 요소가 포함되어 있으면 true반환
		System.out.println("list1.containsAll(list2): " + list1.containsAll(list2));
		System.out.println();

		list2.add("B"); // list2에 문자열 B를 추가
		list2.add("C"); // list2에 문자열 C를 추가
		list2.add(3, "A"); // list2의 3번 인덱스 위치에 문자열 A을 추가
		print(list1, list2);

		list2.set(3, "AA"); // set 메서드는 지정한 인덱스위치의 값을 덮어쓰기 함
		print(list1, list2);

		// list1에서 list2와 겹치는 부분만 남기고 나머지는 삭제한다.
		System.out.println("list1.retainAll(list2): " + list1.retainAll(list2));
		print(list1, list2);

		// list2에서 list1에 포함된 객체들을 삭제한다.
		// ArrayList의 앞에서 부터 삭제하면 앞 인덱스가 삭제된 후 재정렬 하기 때문에 의도대로 삭제되지 않는다.
		for (int i = list2.size() - 1; i >= 0; i--) {
			if (list1.contains(list2.get(i))) {
				list2.remove(i);
			} // end if
		} // end for
		print(list1, list2);

	}// end main

	static void print(ArrayList list1, ArrayList list2) {
		System.out.println("list1: " + list1);
		System.out.println("list2: " + list2);
		System.out.println();
	}// end print
}// end ArrayListEx1
