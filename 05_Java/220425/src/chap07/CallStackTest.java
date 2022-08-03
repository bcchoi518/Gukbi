package chap07;

public class CallStackTest {

	public static void main(String[] args) {

		System.out.print("start -> ");
		System.out.print("main method -> ");
		firstMethod();
		System.out.print("main method -> ");
		System.out.println("end");

	}// end main

	static void firstMethod() {
		System.out.print("first method -> ");
		secondMethod();
		System.out.print("first method -> ");
	}

	static void secondMethod() {
		System.out.print("secondMethod() -> ");
	}

}// end CallStackTest
