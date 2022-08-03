package chap02;

public class Point {
	int x;
	int y;

	Point() {
	}

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	String getXY() {
		return "(" + x + "," + y + ")";
	}// end getXY
}// end Point
