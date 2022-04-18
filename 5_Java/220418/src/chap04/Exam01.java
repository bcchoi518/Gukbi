package chap04;

public class Exam01 {

	public static void main(String[] args) {

		int x = 10;
		int y = 20;
		int tmp = 0;

		System.out.println("before");
		System.out.println("x = " + x);
		System.out.println("y = " + y);
		System.out.println();
		
		//x, y ġȯ
		tmp = x;
		x = y;
		y = tmp;
		
		System.out.println("after");
		System.out.println("x = " + x);
		System.out.println("y = " + y);
	}

}
