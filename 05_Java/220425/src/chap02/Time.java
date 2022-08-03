package chap02;

public class Time {

	private int hour;
	private int minute;
	private float second;

	public int getHour() {
		return hour;
	}// end getHour

	public void setHour(int hour) {
		if (hour < 0 || 23 < hour) {
			return;
		} // end if
		this.hour = hour;
	}// end setHour

	public int getMinute() {
		return minute;
	}// end getMinute

	public void setMinute(int minute) {
		if (minute < 0 || 59 < minute) {
			return;
		} // end if
			this.minute = minute;
	}// end setMinute

	public float getSecond() {
		return second;
	}//end getSecond

	public void setSecond(float second) {
		if (second < 0.0f || 60.0f <= second) {
			return;
		} // end if
		this.second = second;
	}//end setSecond
	
	public void showTime() {
		System.out.printf("%d : %d : %.2f%n", hour, minute, second);
	}

}// end Time
