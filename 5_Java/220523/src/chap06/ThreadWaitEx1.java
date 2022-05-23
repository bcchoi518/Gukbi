package chap06;

public class ThreadWaitEx1 {
	public static void main(String[] args) throws InterruptedException {
		Table table = new Table(); // 여러 쓰레드가 공유하는 객체

		new Thread(new Cook(table), "COOK1").start();
		new Thread(new Customer(table, "donut"), "CUST1").start();
		new Thread(new Customer(table, "burger"), "CUST2").start();

		Thread.sleep(100); // 0.1초(100 밀리 세컨드) 후에 강제 종료시킨다.
		System.exit(0); // 프로그램 전체를 종료.(모든 쓰레드가 종료됨)
	}// end main
}// end ThreadWaitEx1
