package exam01;

public class Ex01 {
	public static void main(String[] args) {
//		기본자료형 : 8
//		overflow / underflow
		int num1 = 300;
		System.out.println(num1);

		num1 = num1 + 10;
		num1 = num1 + 30;
		System.out.println(num1);

		int num2 = num1 + 50;
		System.out.println(num1 + " / " + num2);

		num1 = num1 + 50;
		System.out.println("num1: " + num1);

		num1 += 50;
		System.out.println("num1: " + num1);

		int num3 = 0;
		System.out.println(num3);

		num3 = num3 + 1;
		System.out.println(num3);

		num3 += 1;
		System.out.println(num3);

		num3++;
		System.out.println(num3);

		++num3;
		System.out.println(num3);

		System.out.println("-----------------------");

		int num4 = ++num3;
		System.out.println(num3 + " / " + num4);

		int num6 = num4++;
		System.out.println(num4 + " / " + num6);

		System.out.println("-----------------------");

		float f1 = 5.76F;
		double d1 = 5.76;

		System.out.println("-----------------------");

		char c1 = 'B';
		System.out.println(c1);

		char c2 = 65; // ascII
		System.out.println(c2);

		System.out.println("-----------------------");

		boolean b1 = true;
		boolean b2 = false;
		System.out.println(b1 + " / " + b2);
	}// end main
}// end Ex01
