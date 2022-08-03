package homework;

public class ElevatorTest {

	public static void main(String[] args) {

		Elevator ev1 = new Elevator();

		System.out.println("현재 최대 높이는 " + ev1.getMaxFloor() + "층 입니다.");
		ev1.moveFloor(10);
		ev1.doorOpen();
		ev1.moveFloor(15);
		ev1.doorClose();
		ev1.moveFloor(3);
		ev1.moveFloor(100);
		ev1.setMaxFloor(100);
		ev1.moveFloor(100);
		ev1.doorStatus();

	}// end main

}// end ElevatorTest
