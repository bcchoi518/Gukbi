package chap02;

import java.util.Arrays;

public class ArrayEx6 {

	public static void main(String[] args) {

		int[] arr1 = {1,2,3,4,5};
		int[] arr2 = new int[10];
		
		System.arraycopy(arr1, 0, arr2, 0, arr1.length);
		
		System.out.println(Arrays.toString(arr1));
		System.out.println(Arrays.toString(arr2));
	}//end main

}//end ArrayEx6
