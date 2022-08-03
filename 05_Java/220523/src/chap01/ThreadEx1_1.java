package chap01;

public class ThreadEx1_1 extends Thread {
	@Override
	public void run() {
		for (int i = 0; i < 500; i++) {
			System.out.println(getName()); // 조상인 Thread의 getName()을 호출
		} // end for
	}// end run
}// end ThreadEx1_1
