package chap03;

public class GuGuDan {

	public static void main(String[] args) {

		for (int dan = 2; dan < 10; dan++) {
			for (int num = 1; num < 10; num++) {
				System.out.printf("%d X %d = %d%n", dan, num, dan * num);
			} // end for
			System.out.println();
		} // end for

	}// end main

}// end GuGuDan
