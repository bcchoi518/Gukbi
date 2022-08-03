package chap01;

public class Point3D extends Point {
	int z = 30;

	Point3D() {
		this(100, 200, 300);
	}

	Point3D(int x, int y, int z) {
		super(x, y);
		this.z = z;
	}

	@Override
	String getLocation() {
//		return "x: " + x + ", y: " + y + ", z: " + z;
		return super.getLocation() + ", z: " + z;
	}// end getLocation
}// end Point3D
