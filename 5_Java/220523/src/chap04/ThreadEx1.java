package chap04;

public class ThreadEx1 {
	public static void main(String[] args) {
		Runnable r = new RunnableEx1();
		new Thread(r).start(); // ThreadGroup에 의해 참조되므로 gc대상이 아니다.
		new Thread(r).start(); // ThreadGroup에 의해 참조되므로 gc대상이 아니다.
	}// end main
}// end ThreadEx1
