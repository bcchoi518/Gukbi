package chap02;

public class TimeTest {

	public static void main(String[] args) {

		Time t = new Time();
		
//		t.hour = 50;
//		t.minute = 67;
//		t.second = 66;
		
		t.setHour(10);
		t.setMinute(46);
		t.setSecond(20);
		
		t.showTime();
	}//end main

}//end TimeTest
