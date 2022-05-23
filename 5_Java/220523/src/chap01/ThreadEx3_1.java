package chap01;

public class ThreadEx3_1 extends Thread {
	@Override
	public void run() {
		for (int i = 10; i > 0; i--) {
			System.out.println(i);
			try {
				Thread.sleep(1000); // 1초간 시간을 지연한다.
			} catch (Exception e) {
			} // end try-catch
		} // end for
	}// end run
}// end ThreadEx3_1
