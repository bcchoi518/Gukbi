package chap05;

public class StringBufferEx1 {
	public static void main(String[] args) {
		String s = "abc";
		StringBuffer sb = new StringBuffer("abc");
		StringBuffer sb2 = new StringBuffer("abc");

		System.out.println(s.length());
		System.out.println(sb.length());
		System.out.println(sb.capacity()); // 기본 공간 16자에 "abc"의 3자가 더해짐

		System.out.println(sb == sb2);
		System.out.println(sb.equals(sb2)); // StringBuffer클래스에서는 equals가 오버라이딩 안되어있음
		// StringBuffer클래스를 String클래스로 변환
		String s1 = sb.toString();
		String s2 = sb2.toString();
		System.out.println(s1.equals(s2));

		StringBuffer sss = new StringBuffer("0123456");
		StringBuffer sss2 = sss.delete(3, 6); // 3번 인덱스 부터 6번 인덱스 앞까지
		System.out.println(sss2);
		System.out.println(sss.reverse());

	}// end main
}// end StringBufferEx1
