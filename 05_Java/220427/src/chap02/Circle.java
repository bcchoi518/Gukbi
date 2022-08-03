package chap02;

public class Circle extends Shape {
	Point center;
	int r;

	Circle() {
		// 한 생성자에서 다른 생성자를 호출할 때는 반드시 첫 줄에만 호출이 가능
		this(new Point(0, 0), 100); // new Point(0, 0) == Point center
	}

	Circle(Point center, int r) { // new Point(0, 0) == Point center
		this.center = center; // Point 클래스의 인스턴스를 참조하는 값을 Circle 클래스의 인스턴스 변수(Point 클래스 타입)인 center에 저장
		this.r = r;
	}

	@Override // 애노테이션
	void draw() {
		// 포함관계는 포함된 클래스 타입의 인스턴스 변수를 통해서 해당 클래스의 멤버변수에 접근
		// 상속관계는 접근하기 위한 인스턴스 변수가 없고 그냥 사용 가능
		System.out.printf("[center=(%d, %d), r=%d, color=%s]%n", center.x, center.y, r, color);
	}// end draw

}// end Circle
