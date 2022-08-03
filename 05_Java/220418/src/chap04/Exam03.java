package chap04;

public class Exam03 {

	public static void main(String[] args) {

		int x = 50;
		int y = 3;
		int z = 4;

		System.out.println(x + y);
		System.out.println(x - y);
		System.out.println(x * y);
		System.out.println(x / y);
		System.out.println(x % y);
		System.out.println(z >> 2);

		System.out.println(x >= y);
		System.out.println(x <= y);
		System.out.println(x == y);
		System.out.println(x != y);

		System.out.println((x > y) && (z > y));
		System.out.println((x > y) || (z < y));
	}
}
