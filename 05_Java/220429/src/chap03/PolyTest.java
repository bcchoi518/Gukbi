package chap03;

public class PolyTest {

	public static void main(String[] args) {
		Tv t = new Tv();
		CaptionTv ct = new CaptionTv();
		Tv t2 = new CaptionTv(); // 다형성(조상타입의 참조변수는 자손객체를 참조할 수 있다)
//		CaptionTv ct2 = new Tv(); // 에러. (자손타입의 참조변수는 조상객체를 참조할 수 없다)

		ct.caption = true;
		ct.displayCaption("안녕하세요");

//		t2.caption = true;	// 에러.
//		t2.displayCaption("Hello");	//에러.
//		조상클래스의 멤버변수만 접근가능하고 자손클래스의 변수에는 접근 불가하다

	}// end main
}// end PolyTest
