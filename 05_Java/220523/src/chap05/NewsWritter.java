package chap05;

public class NewsWritter extends Thread {
	NewsPaper paper;

	NewsWritter(NewsPaper paper) {
		this.paper = paper;
	}

	@Override
	public void run() {
		paper.setTodayNews("오늘도 자바를 열심히 합시다!!");
	}// end run
}// end NewsWritter
