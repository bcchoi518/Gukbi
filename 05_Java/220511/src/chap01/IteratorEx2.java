package chap01;

import java.util.ArrayList;
import java.util.Iterator;

public class IteratorEx2 {
	public static void main(String[] args) {
		final int ARRAYLIST_SIZE = 10;
		ArrayList original = new ArrayList(ARRAYLIST_SIZE);
		ArrayList copy1 = new ArrayList(ARRAYLIST_SIZE);
		ArrayList copy2 = new ArrayList(ARRAYLIST_SIZE);

		for (int i = 0; i < ARRAYLIST_SIZE; i++) {
			original.add(i + "");
		} // end for

		Iterator it = original.iterator();

		while (it.hasNext()) {
			copy1.add(it.next());
		} // end while

		System.out.println("= Original에서 Copy1로 복사(copy) =");
		System.out.println("original: " + original);
		System.out.println("copy1: " + copy1);
		System.out.println();

		it = original.iterator();

		while (it.hasNext()) {
			copy2.add(it.next());
			// next()를 하지 않고 바로 remove()를 하면 다음 요소를 가르키고 있지 않기 때문에 IllegalStateException에러
			it.remove(); // original의 요소를 삭제
		} // end while

		System.out.println("= Original에서 Copy2로 복사(move) =");
		System.out.println("original: " + original);
		System.out.println("copy2: " + copy2);

	}// end main
}// end IteratorEx2
