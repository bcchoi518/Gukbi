package chap01;

public class Point {
	int x = 10;
	int y = 20;

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	String getLocation() {
		return "x: " + x + ", y: " + y;
	}// end getLocation
}// end Point
