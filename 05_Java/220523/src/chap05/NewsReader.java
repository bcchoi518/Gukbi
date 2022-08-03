package chap05;

public class NewsReader extends Thread {
	NewsPaper paper;

	NewsReader(NewsPaper paper) {
		this.paper = paper;
	}

	@Override
	public void run() {
		System.out.println("오늘의 뉴스: " + paper.getTodayNews());
	}// end run
}// end NewsReader
