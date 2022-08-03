package chap03;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class HashSetLotto {
	public static void main(String[] args) {
		Set set = new HashSet();

		for (int i = 0; set.size() < 6; i++) { // add메서드가 성공할때만 set.size()가 늘어남
			int num = (int) (Math.random() * 45) + 1;
			if (set.add(new Integer(num))) {
				System.out.println("성공: " + set.size());
			} else {
				System.out.println("실패: " + set.size());
			} // end if
		} // end for
		System.out.println(set);

		List list = new LinkedList(set); // LinkedList (Collection c)
		Collections.sort(list); // Collections.sort(List list)
		System.out.println(list);
	}// end main
}// end HashSetLotto
