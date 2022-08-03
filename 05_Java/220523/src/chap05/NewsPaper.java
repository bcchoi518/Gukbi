package chap05;

public class NewsPaper {
	String todayNews;
	boolean isTodayNews = false;

	public String getTodayNews() {
		if (isTodayNews == false) {
			synchronized (this) {
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				} // end try-catch
			} // end synchronized
		} // end if
		return todayNews;
	}// end getTodayNews

	public void setTodayNews(String todayNews) {
		this.todayNews = todayNews;
		isTodayNews = true;

		synchronized (this) {
			notifyAll();
		} // end synchronized
	}// end setTodayNews
}// end NewsPaper