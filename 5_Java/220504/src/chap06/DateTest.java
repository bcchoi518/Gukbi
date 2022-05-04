package chap06;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {
	public static void main(String[] args) {
		Date today = new Date();

		System.out.println(today);

		SimpleDateFormat sf = new SimpleDateFormat("yyyy/MM/dd");
		String td = sf.format(today);
		System.out.println(td);
	}// end main
}// end DateTest
