package chap07;

class Data1 {
	int value;
}

class Data2 {
	int value;

	Data2() {
	}

	Data2(int x) { // 매개변수가 있는 생성자.
		value = x;
	}
}

public class ConstructorEx {

	public static void main(String[] args) {

		Data1 d1 = new Data1();
//		Data2 d2 = new Data2();	// compile error 발생, 기본 생성자가 없으므로 기본 생성자를 정의해 주어야 한다.
		Data2 d2 = new Data2(5);
	}

}
