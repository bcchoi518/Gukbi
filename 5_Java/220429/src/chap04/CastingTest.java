package chap04;

public class CastingTest {

	public static void main(String[] args) {
		Car car = new Car();
		Car car2 = null;
		FireEngine fe = null;
		
		car.drive();

//		fe = (FireEngine) car;	//에러. ClassCastexception
		//객체가 조상클래스의 객체인데 자손클래스로 형변환하려고 해서 에러!!!!!!!!!
		//ex) FireEngine fire = new Car(); // 에러!! 같은 맥락
		
		// 에러를 피해보자!
		if(car instanceof FireEngine) {
			fe = (FireEngine) car;
			fe.drive();
			car2 = fe;
		} else {
			car2 = car;
			car2.drive();
		}
		//위에서 instanceof 연산자를 통해 car 참조변수가 FireEngine로 형변환이 안되었기 때문에
		//fe 변수는 null 값을 가지고 있다. 그래서 NullPointerException이 발생
		//else{} 구문으로 구분지어서 에러 해결
		
	}// end main
}// end CastingTest
