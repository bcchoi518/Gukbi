package exam01;

public class Ex07 {
	public static void main(String[] args) {
//		반복문: for, while, do~while

//		int dan = 3;
//		구구단
		for (int dan = 2; dan < 10; dan++) {
			for (int i = 1; i < 10; i++) {
				System.out.printf("%d * %d = %d%n", dan, i, dan * i);
			} // end for
			System.out.println("--------------");
		} // end for
	}
}
