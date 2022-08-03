package chap02;

import java.util.Arrays;

public class ArrayEx5 {

	public static void main(String[] args) {

		int[] arr = new int[5];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = i + 1;
		} // end for

		System.out.println("변경전 : " + arr.length);
		System.out.println(Arrays.toString(arr));
		System.out.println("arr : " + arr);
		
		int[] tmp = new int[arr.length*2];
		System.out.println("tmp : " + tmp);
		
		for (int i = 0; i < arr.length; i++) {
			tmp[i] = arr[i];
		}
		
		arr = tmp;	// 2배로 다시 만든 배열을 참조하고 있는 주소를 복사대상의 배열을 참조하고 있는 변수에 저장
		
		System.out.println("변경후 : " + arr.length);
		System.out.println(Arrays.toString(arr));
		System.out.println("arr : " + arr);
		
	}// end main

}// end ArrayEx5
