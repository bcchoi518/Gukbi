package chap01;

public class ThreadEx1 {
	public static void main(String[] args) {
		ThreadEx1_1 t1 = new ThreadEx1_1();
		Thread t2 = new Thread(new ThreadEx1_2());

		// run으로 호출은 되지만 Thread 기능이 동작하려면 start로 해야함
		t1.start();
		t2.start();

		System.out.println("End");
	}// end main
}// end ThreadEx1
