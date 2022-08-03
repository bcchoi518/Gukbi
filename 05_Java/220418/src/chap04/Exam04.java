package chap04;

public class Exam04 {

	public static void main(String[] args) {

		int i = 5;

		i++; // i = i + 1;

		System.out.println("i = " + i);

		i--; // i = i - 1;
		System.out.println();
		System.out.println("i = " + i);
		System.out.println("i++ = " + i++);
		System.out.println("i-- = " + i--);
		System.out.println("i = " + i);

		System.out.println();
		System.out.println("i = " + i);
		System.out.println("++i = " + ++i);
		System.out.println("--i = " + --i);
		System.out.println("i = " + i);

		
		i = i++ - ++i;
		System.out.println(i);
	}

}
