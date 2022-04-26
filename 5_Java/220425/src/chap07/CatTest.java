package chap07;

public class CatTest {

	public static void main(String[] args) {

		Car c1 = new Car();
		c1.color = "white";
		c1.gearType = "manual";
		c1.door = 2;

		Car c2 = new Car("black", "auto", 4);
		
		Car c3 = new Car();
		Car c4 = new Car("green");

		System.out.println("c1의 color = " + c1.color + ", geartype = " + c1.gearType + ", door = " + c1.door);
		System.out.println("c2의 color = " + c2.color + ", geartype = " + c2.gearType + ", door = " + c2.door);
		System.out.println("c2의 color = " + c3.color + ", geartype = " + c3.gearType + ", door = " + c3.door);
		System.out.println("c2의 color = " + c4.color + ", geartype = " + c4.gearType + ", door = " + c4.door);
	}// end main

}// end CatTest
