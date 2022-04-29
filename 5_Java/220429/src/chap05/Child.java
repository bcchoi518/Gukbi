package chap05;

public class Child extends Parent {
	int x = 200;

	@Override
	void method() {
		System.out.println("Child Method");
		System.out.println("x= " + x);
		System.out.println("super.x= " + super.x);
		System.out.println("this.x= " + this.x);
	}// end method
}// end Child
