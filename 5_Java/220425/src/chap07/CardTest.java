package chap07;

public class CardTest {

	public static void main(String[] args) {

		Card c1 = new Card("spade", 3);
		
		System.out.println(c1.kind);
		System.out.println(c1.number);
		System.out.println();
		
		Card c2 = new Card();
		c2.kind = "diamond";
		c2.number = 10;
		
		System.out.println(c2.kind);
		System.out.println(c2.number);
		System.out.println();
		
	}// end main

}// end CardTest
