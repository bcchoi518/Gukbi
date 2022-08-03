package chap01;

public class ThreadEx1_2 implements Runnable {
	@Override
	public void run() {
		for (int i = 0; i < 500; i++) {
			// Thread.currentThread() - 현재 실행중인 Thread를 반환한다.
			System.out.println(Thread.currentThread().getName());
		} // end for
	}// end run
}// end ThreadEx1_2
