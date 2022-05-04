package chap02;

public class CloneEx1 {
	public static void main(String[] args) {
		Point original = new Point(3, 5);
		// 복사 대상 클래스에 Cloneable를 implements해야만 clone()메서드가 정상 동작한다.
//		Point copy = (Point)original.clone(); // clone()메서드의 반환 타입이 Object 타입이므로 형변환
		Point copy = original.clone(); // clone() 메서드 오버라이딩할때 반환 타입을 Point로 변경가능(공변 반환타입)

		System.out.println(original);
		System.out.println(copy);
		System.out.println(original.hashCode());
		System.out.println(copy.hashCode());

		original.x = 100;
		original.y = 100;

		System.out.println(original);
		System.out.println(copy);
	}// end main
}// end CloneEx1
