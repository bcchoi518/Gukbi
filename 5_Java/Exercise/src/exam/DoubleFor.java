package exam;

public class DoubleFor {
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			System.out.println("(밖for) i = " + i);
			System.out.print("(안for) j = ");
			for (int j = 0; j < 10; j++) {
				System.out.print(j + " ");
			} // end for
			System.out.println();
			System.out.println();
		} // end for
	}// end main
}// end DoubleFor
