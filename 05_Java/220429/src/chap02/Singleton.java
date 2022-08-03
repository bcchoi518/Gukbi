package chap02;

public class Singleton {
	//자기 자신을 참조하는 참조변수를 만들어서 static으로 인스턴스화를 하지 않고 접근할수 있도록 한다
	private static Singleton s;

	private Singleton() {	//아무나 생성하지 못하게 하기 위해 생성자를 private로 은닉한다
	}

	public static Singleton getInstance() {	//getInstance 메서드를 통해 클래스를 생성한다
		if (s == null) {	//클래스가 생성되었는지 참조변수안의 값으로 판단한다
			s = new Singleton();	//참조변수안의 값이 null이면 객체를 생성한적이 없기 때문에 객체를 생성해준다
		} // end if
		return s;	//Singleton 클래스를 참조하는 변수의 값을 리턴한다
	}//end getInstance
}// end Singleton
