package chap02;

public class ArrayEx9 {

	public static void main(String[] args) {

		int[] numArr = new int[10];

		for (int i = 0; i < numArr.length; i++) {
			numArr[i] = i;
			System.out.print(numArr[i]);
		} // end for
		System.out.println();

		for (int i = 0; i < 100; i++) {
			int n = (int) (Math.random() * 10);
			int tmp = numArr[i % 10];
			numArr[i % 10] = numArr[n];
			numArr[n] = tmp;
		} // end for

		for (int i : numArr) {
			System.out.print(numArr[i]);
		} // end for
	}// end main

}// end ArrayEx9
