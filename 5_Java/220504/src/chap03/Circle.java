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
	protected Circle clone() {
		Object obj = null;
		try {
			obj = super.clone();
		} catch (CloneNotSupportedException e) {
		} // end try-catch
		Circle c = (Circle) obj;
		c.p = new Point(this.p.x, this.p.y);
		return c;
	}// end clone

	public String toString() {
		return "p: " + p + ", r: " + r;
	}// end toString
}// end Circle
