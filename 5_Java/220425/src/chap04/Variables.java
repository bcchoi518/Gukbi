package chap04;

public class Variables {

	int iv;
	static int cv;

	void method1() {
		int lv = 0;
	}// end method1

	void method2() {
//		lv = 2; // 에러, method1의 지역변수이기 때문에 method1 밖에서 사용불가

	}// end method2
}// end Variables
