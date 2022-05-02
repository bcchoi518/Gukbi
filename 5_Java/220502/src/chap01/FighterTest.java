package chap01;

public class FighterTest {

	public static void main(String[] args) {
		Fighter f = new Fighter();

		if (f instanceof Unit) {
			System.out.println("f는 Unit의 자손");
		}
		if (f instanceof Fightable) {
			System.out.println("f는 Fightable인터페이스를 구현");
		}
		if (f instanceof Movable) {
			System.out.println("f는 Movable인터페이스를 구현");
		}
		if (f instanceof Attackable) {
			System.out.println("f는 Attackable인터페이스를 구현");
		}
		if (f instanceof Object) {
			System.out.println("f는 Object의 자손");
		}

	}// end main

}// end FighterTest
