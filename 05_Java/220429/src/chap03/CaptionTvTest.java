package chap03;

public class CaptionTvTest {

	public static void main(String[] args) {

		CaptionTv ctv = new CaptionTv();

		ctv.channel = 10;
		ctv.channelUp();
		System.out.println(ctv.channel);
		ctv.displayCaption("Hello, World!!");	// 캡션 기능이 꺼져있어서 출력불가
		ctv.caption = true;	// 캡션 기능을 켠다.
		ctv.displayCaption("Hello, World!!");

	}// end main

}// end CaptionTvTest
