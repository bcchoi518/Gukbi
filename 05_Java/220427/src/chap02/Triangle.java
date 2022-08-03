package chap02;

public class Triangle extends Shape {
	Point[] p = new Point[3];

	Triangle(Point[] p) {
		this.p = p;
	}

	@Override // 애노테이션
	void draw() {
		// 포함관계는 포함된 클래스 타입의 인스턴스 변수를 통해서 해당 클래스의 멤버변수에 접근
		// 상속관계는 접근하기 위한 인스턴스 변수가 없고 그냥 사용 가능
		System.out.printf("[p1=%s, p2=%s, p3=%s, color=%s]%n", p[0].getXY(), p[1].getXY(), p[2].getXY(), color);
	}// end draw

}// end Triangle
