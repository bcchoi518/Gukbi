package chap03;

public class Circle implements Cloneable {
	Point p;
	double r;

	Circle(Point p, double r) {
		this.p = p;
		this.r = r;
	}

//	public Circle shallowCopy() {
//		Object obj = null;
//		try {
//			obj = super.clone();
//		} catch (CloneNotSupportedException e) {
//			e.printStackTrace();
//		} // end try-catch
//		return (Circle) obj;
//	}
//
//	public Circle deepCopy() {
//		Object obj = null;
//		try {
//			obj = super.clone();
//		} catch (CloneNotSupportedException e) {
//			e.printStackTrace();
//		} // end try-catch
//		Circle c = (Circle) obj;
//		c.p = new Point(this.p.x, this.p.y);
//		return c;
//	}

	@Override
	protected Circle clone() {	//반환타입 Object를 복제하는 클래스로 변환가능
		Object obj = null;	//복제한 클래스를 참조할 변수 선언 후 null로 초기화
		try {	//CloneNotSupportedException을 처리하기 위한 try-catch문
			obj = super.clone();	//Object클래스의 clone()메서드로 Circle클래스를 복제하여 미리 만들어준 참조변수에 대입
		} catch (CloneNotSupportedException e) {
		} // end try-catch
		Circle c = (Circle) obj;	//복제한 클래스안에 포함되어 있는 참조클래스까지 복제하기 위해 형변환
		c.p = new Point(this.p.x, this.p.y);	//복제한 클래스안에 포함되어있는 클래스의 인스턴스를 생성
		return c;	//모든 작업이 끝난 후 해당 클래스를 반환
	}// end clone

	public String toString() {
		return "p: " + p + ", r: " + r;
	}// end toString
}// end Circle
