package chap03;

public class IncThread extends Thread {
	Increment inc;

	public IncThread(Increment inc) {
		this.inc = inc;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10000; i++) {
			for (int k = 0; k < 10000; k++) {
				inc.incre();
			} // end for
		} // end for
	}// end run
}// end IncThread
