package chap04;

public class CarTest {

	public static void main(String[] args) {
		Car car = null;
		FireEngine fe = new FireEngine();
		FireEngine fe2 = null;

		car = fe;

		fe.water();
//		car.water(); //에러. Car클래스에 water()메소드가 없음
		car.door = 2;
		System.out.println(fe.door);

		fe2 = (FireEngine) car; // 자식타입으로 다운캐스팅
		fe2.water();
		System.out.println(fe2.door);
	}// end main
}// end CarTest
