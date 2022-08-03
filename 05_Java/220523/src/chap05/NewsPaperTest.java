package chap05;

public class NewsPaperTest {
	public static void main(String[] args) {
		NewsPaper paper = new NewsPaper();

		NewsReader r1 = new NewsReader(paper);
		NewsReader r2 = new NewsReader(paper);
		NewsReader r3 = new NewsReader(paper);
		NewsReader r4 = new NewsReader(paper);
		NewsReader r5 = new NewsReader(paper);
		NewsReader r6 = new NewsReader(paper);
		NewsReader r7 = new NewsReader(paper);
		NewsReader r8 = new NewsReader(paper);
		NewsReader r9 = new NewsReader(paper);
		NewsReader r10 = new NewsReader(paper);
		NewsReader r11 = new NewsReader(paper);
		NewsReader r12 = new NewsReader(paper);
		NewsReader r13 = new NewsReader(paper);
		NewsReader r14 = new NewsReader(paper);
		NewsReader r15 = new NewsReader(paper);
		NewsReader r16 = new NewsReader(paper);
		NewsReader r17 = new NewsReader(paper);

		NewsWritter w = new NewsWritter(paper);

		r1.start();
		r2.start();
		r3.start();
		r4.start();
		r5.start();
		r6.start();
		r7.start();
		r8.start();
		r9.start();
		r10.start();
		r11.start();
		r12.start();
		r13.start();
		r14.start();
		r15.start();
		r16.start();
		r17.start();
		w.start();
	}// end main
}// end NewsPaperTest
