package chap06;

public class MyMath {

	public int add(int x, int y) {
		return x + y;
	}// end add

	public int add(int x, int y, int z) {
		return x + y + z;
	}// end add
	
	public double add(double x, double y) {
		return x + y;
	}// end add

	public int sub(int x, int y) {
		return x - y;
	}// end sub

	public int mul(int x, int y) {
		return x * y;
	}// end mul

	public double div(int x, int y) {
		return x / (double) y;
	}// end div

	public String showNum(int x, int y) {
		return "입력한 수는 " + x + ", " + y + "입니다.";
	}// end showNum

}// end MyMath
