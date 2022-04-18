package chap04;

public class Exam02 {

	public static void main(String[] args) {

		char ch = 'A';
		int i = ch; // 자동형변환
		byte b = (byte) 500; // 형변환(다운캐스팅) : 값의 소실
		float f = 5.5f;
		double d = 10.9;
		boolean bo = false;

		System.out.println("ch = " + ch);
		System.out.println("i = " + i);
		System.out.println("(int)ch = " + (int) ch);
		System.out.println("b = " + b);
		System.out.println("f = " + f);
		System.out.println("d = " + d);
		System.out.println("bo = " + bo);

	}

}
