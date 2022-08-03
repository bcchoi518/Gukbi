package chap02;

public class Sum {
	int num;

	public Sum() {
		num = 0;
	}

	public synchronized void addNum(int i) {
		num += i;
	}// end addNum

	public int getNum() {
		return num;
	}// end getNum
}// end Sum
