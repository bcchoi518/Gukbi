package chap01;

public class Exam01 {

	public static void main(String[] args) {

		int sum = 0;
		int i = 0;

		while (true) {
			if (sum > 100) {
				break;
			}
			i++;
			sum += i;
		}
		System.out.println("sum = " + sum);
		System.out.println("i = " + i);

	}// end main

}// end Exam01
