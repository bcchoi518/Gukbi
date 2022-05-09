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

		for (int i = 0; i < 10; i++) {
			if (i % 2 == 1) {
				for (int j = (5 - i); j > 0; j--) {
					System.out.print(" ");
				} // end for
				for (int k = 0; k < i; k++) {
					System.out.print("*");
				} // end for
				System.out.println();
			} // end if
		} // end for
	}// end main
}// Stars
