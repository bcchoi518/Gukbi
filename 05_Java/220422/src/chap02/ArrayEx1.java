package chap02;

public class ArrayEx1 {

	public static void main(String[] args) {

		// int[] a = new int[3];
		int[] a = { 1, 2, 3, 4, 5 };

		System.out.println(a[0]);
		System.out.println(a[1]);
		System.out.println(a[2]);

		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		} // end for
		
		
		int[] b = new int[10];
		
		for (int i = 0; i < b.length; i++) {
			b[i] = i*10;
		}//end for
		
		for (int i = 0; i < b.length; i++) {
			System.out.println(b[i]);
		} // end for

		
		System.out.println(a);
	}// end main

}// end ArrayEx1
