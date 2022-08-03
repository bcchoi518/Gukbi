package chap01;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class IteratorEx1 {
	public static void main(String[] args) {
		ArrayList list = new ArrayList(); // 기본 용량 10개
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		list.add("5");

		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i)); // 요소를 get매서드로 읽어옴
		} // end for
		System.out.println();

		Iterator it = list.iterator();

		while (it.hasNext()) {
			System.out.println(it.next());
		} // end while
		System.out.println();

		it = list.iterator(); // 한번 사용한 iterator은 hasNext()가 없기 때문에 다시 받아와야 함

		while (it.hasNext()) {
			Object obj = it.next(); // iterator의 next()가 반환타입이 Object임
			System.out.println(obj);
		} // end while
		System.out.println();

		ListIterator it2 = list.listIterator();

		while (it2.hasNext()) {
			System.out.println(it2.next());
		} // end while

		while (it2.hasPrevious()) {
			System.out.println(it2.previous());
		} // end while

		while (it2.hasNext()) {
			System.out.println(it2.next());
		} // end while

		while (it2.hasPrevious()) {
			System.out.println(it2.previous());
		} // end while

	}// end main
}// end IteratorEx1
