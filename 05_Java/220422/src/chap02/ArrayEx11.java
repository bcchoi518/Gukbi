package chap02;

import java.util.Arrays;

public class ArrayEx11 {

	public static void main(String[] args) {

		int[] code = { -4, -1, 3, 6, 11 };
		int[] arr = new int[10];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = code[(int) (Math.random() * 5)];
		} // end for
		
		System.out.println(Arrays.toString(arr));
		
	}// end main

}// end ArrayEx11
