package chap05;

public class StringBufferEx2 {
	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer("01");
		StringBuffer sb2 = sb.append(23);
		sb.append('4').append(56);	//반환타입이 자기자신이므로 메서드 chaining 기법으로 사용가능

		StringBuffer sb3 = sb.append(78);
		sb3.append(9.0);

		System.out.println("sb: " + sb);
		System.out.println("sb2: " + sb2); // new 연산자로 객체생성은 1번만 했기 때문에 각각의 변수가 가리키는 객체는 동일
		System.out.println("sb3: " + sb3); // new 연산자로 객체생성은 1번만 했기 때문에 각각의 변수가 가리키는 객체는 동일

		System.out.println("sb: " + sb.deleteCharAt(10));
		System.out.println("sb: " + sb.delete(3, 6));
		System.out.println("sb: " + sb.insert(3, "abc"));
		System.out.println("sb: " + sb.replace(6, sb.length(), "END"));

		// StringBuffer 생성할때 "01" 두자리문자열을 매개변수로 만들었으므로 18자리
		System.out.println("capacity: " + sb.capacity());
		System.out.println("length: " + sb.length());
	}// end main
}// end StringBufferEx2
