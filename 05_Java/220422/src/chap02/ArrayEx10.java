package chap02;

import java.util.Arrays;

public class ArrayEx10 {

	public static void main(String[] args) {

		int[] lotto = new int[6];

		for (int i = 0; i < lotto.length; i++) {
			boolean isDup = false;
			int n = (int) (Math.random() * 45) + 1;

			for (int j = 0; j <= i; j++) {
				if (lotto[j] == n) {
					isDup = true;
					i--;
					break;
				} // end if
			} // end for

			if (!isDup) {
				lotto[i] = n;
			}
		} // end for
		System.out.println(Arrays.toString(lotto));
	}// end main

}// end ArrayEx10
