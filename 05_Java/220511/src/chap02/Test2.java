package chap02;

import java.util.HashSet;
import java.util.Set;

public class Test2 {
	public static void main(String[] args) {
//		int[] arr = { 0, 0, 0, 1, 1, 2, 2, 3, 3, 3 };
		Object[] arr = { 0, 0, 0, 1, "1", 2, 2, 3, 3, 3 };
		Set set = new HashSet();

		for (int i = 0; i < arr.length; i++) {
			set.add(arr[i]);
		} // end for

		System.out.println(set);
	}// end main
}// end Test2
