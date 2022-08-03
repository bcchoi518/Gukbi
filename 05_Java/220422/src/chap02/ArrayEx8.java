package chap02;

public class ArrayEx8 {

	public static void main(String[] args) {

		int[] score = { 22, 55, 100, 87, 30, 48, 32, 96, 87 };
		int max = score[0];
		int min = score[0];

		for (int i = 0; i < score.length; i++) {
			if (max < score[i]) {
				max = score[i];
			} // end if
			if (min > score[i]) {
				min = score[i];
			} // end if
		} // end for

		System.out.println("최대값 : " + max);
		System.out.println("최소값 : " + min);

	}// end main

}// end ArrayEx8
