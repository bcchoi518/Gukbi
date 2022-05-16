/*
 * 시험일: 2022-05-16
 * 응시자: 최병철
 * 문제: 문항5-1번
 * encoding: UTF-8 
*/
package exam01;

public class Star {
	public static void main(String[] args) {
		for (int i = 0; i < 6; i++) {
			for (int k = 0; k <= i; k++) {
				System.out.print("*");
			} // end for
			System.out.println();
		} // end for
	}// end main
}// end Star
