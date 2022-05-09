package chap03;

import java.util.HashSet;
import java.util.Set;

public class HashSetEx1 {
	public static void main(String[] args) {
		Object[] objArr = { "1", new Integer(1), "2", "2", "3", "3", "4", "4", "4", };
		System.out.println(objArr.length);
		Set set = new HashSet();

		for (int i = 0; i < objArr.length; i++) {
			if (set.add(objArr[i])) {
				System.out.println("성공");
			} else {
				System.out.println("실패");
			} // end if
		} // end for
		System.out.println(set);
	}// end main
}// end HashSetEx1
