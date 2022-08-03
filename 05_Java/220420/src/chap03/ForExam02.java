package chap03;

public class ForExam02 {

	public static void main(String[] args) {
		int sum = 0;

		for (int i = 1; i <= 10; i++) {
			sum += (i);
			System.out.println("1부터 " + i + " 까지의 합: " + sum);
		} // end for

		System.out.println("-------------------------------");

		for (int i = 1; i <= 5; i++) {
			System.out.println(i);
		} // end for

		for (int i = 1; i <= 5; i++) {
			System.out.print(i);
		} // end for

		System.out.println();
		System.out.println("-------------------------------");

		for (int i = 1, j = 10; i <= 10; i++,j--) {
			System.out.println("i = " + i + " j = " + j);
		} // end for

	}// end main

}// end ForExam02
