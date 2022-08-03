package homework;

public class Elevator {
	private int maxFloor;
	int floor;
	boolean door;

	Elevator() {
		maxFloor = 20;
	}

	Elevator(int maxFloor) {
		this.maxFloor = maxFloor;
	}

	public int getMaxFloor() {
		return maxFloor;
	}// end getMaxFloor

	public void setMaxFloor(int maxFloor) {
		this.maxFloor = maxFloor;
		System.out.println("최대 높이를 " + maxFloor + "층으로 설정");
	}// end setMaxFloor

	void moveFloor(int floor) {
		if (door) {
			System.out.println("문이 열려있어 운행할 수 없습니다. 문을 닫아주세요");
			return;
		} else if (floor > maxFloor) {
			System.out.println("해당층은 운행할 수 없습니다. 최대 높이는 " + maxFloor + "층 입니다.");
			return;
		} // end if

		if (floor == this.floor) {
			System.out.println("지금 있는 곳이 " + floor + "층 입니다.");
		} else if (floor > this.floor) {
			this.floor = floor;
			System.out.println(floor + "층으로 올라갑니다.");
		} else {
			this.floor = floor;
			System.out.println(floor + "층으로 내려갑니다.");
		} // end if
	}// end moveFloor

	void doorOpen() {
		door = true;
		System.out.println("door를 open합니다.");
	}// end doorOpen

	void doorClose() {
		door = false;
		System.out.println("door를 close합니다.");
	}// end doorClose

	void doorStatus() {
		if (door == true) {
			System.out.println("door가 열려 있습니다.");
		} else {
			System.out.println("door가 닫혀 있습니다.");
		}
	}// end doorStatus

}// end Elevator
