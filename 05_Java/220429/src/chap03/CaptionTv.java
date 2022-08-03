package chap03;

public class CaptionTv extends Tv {
	boolean caption;

	void displayCaption(String text) {
		if (caption) {
			System.out.println(text);
		} // end if
	}// end displayCaption
}// end CaptionTv
