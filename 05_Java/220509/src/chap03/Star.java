package chap03;

public class Star {
	public static void main(String[] args) {
		System.out.println("*");
		System.out.println("**");
		System.out.println("***");
		System.out.println("****");
		System.out.println("*****");

		for (int i = 0; i < 6; i++) {
			for (int k = 0; k < i; k++) {
				System.out.print("*");
			} // end for
			System.out.println();
		} // end for

		System.out.println();

		for (int i = 5; i > 0; i--) {
			for (int k = 0; k < i; k++) {
				System.out.print("*");
			} // end for
			System.out.println();
		} // end for

		System.out.println();

		for (int i = -10; i < 11; i++) {
			for (int k = 0; k <= Math.abs(i) - 1; k++) {
				System.out.print(" ");
			} // end for
			for (int k = 0; k <= (10 - Math.abs(i)) * 2; k++) {
				System.out.print("*");
			} // end for
			System.out.println();
		} // end for
	}// end main
}// Stars
