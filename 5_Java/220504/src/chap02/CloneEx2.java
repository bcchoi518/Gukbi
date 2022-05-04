package chap02;

import java.util.Arrays;

public class CloneEx2 {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5 };
		int[] arrClone = arr.clone();
		arrClone[0] = 6;

		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(arrClone));

		int[] arrCopy = new int[arr.length];
		System.arraycopy(arr, 0, arrCopy, 0, arr.length); // 배열복사
		arrCopy[0] = 9;
		System.out.println(Arrays.toString(arrCopy));

	}// end main

}
// end CloneEx2
