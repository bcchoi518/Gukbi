package chap05;

public class MethodTest {

	public static void main(String[] args) {

		int[] arr = new int[10];

		initArr(arr);
		printArr(arr);
		
		System.out.println("Hello");
		
		initArr(arr);
		printArr(arr);
		
		System.out.println("world");
		
		method(arr);
		
	}// end main

	static void initArr(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * 10) + 1;
		} // end for
	}// end initArr

	static void printArr(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		} // end for
	}// end printArr

	
	static void method(int[] arr) {
		initArr(arr);
		printArr(arr);
	}//end method
}// end MethodTest
