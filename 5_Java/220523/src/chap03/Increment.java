package chap03;

public class Increment {
	int num = 0;

	public void incre() {
		synchronized (this) {
			num++;
		}
	}

	public int getNum() {
		return num;
	}// end getNum
}// end Increment
