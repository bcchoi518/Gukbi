package exam;

import java.util.Arrays;

public class ArrayDie {
	public static void main(String[] args) {
		int[] intArr1 = new int[5];
		int[] intArr2 = new int[5];
		for (int i = 0; i < 5; i++) {
			intArr1[i] = i;
		} // end for
		System.out.println(Arrays.toString(intArr1));
		for (int i = 4; i >= 0; i--) {
			intArr2[i] = i;
		} // end for
		System.out.println(Arrays.toString(intArr2));
	}// end main
}// end ArrayDie
