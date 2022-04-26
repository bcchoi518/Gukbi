package homework;

public class Attendance {

	private String name;
	private int checkInTime;
	private int checkOutTime;

	Attendance() {
	}

	Attendance(String name, int checkInTime) {
		this.name = name;
		this.checkInTime = checkInTime;
	}

	public String getName() {
		return name;
	}// end getName

	public void setName(String name) {
		this.name = name;
	}// end setName

	public int getCheckInTime() {
		return checkInTime;
	}// end getCheckInTime

	public void setCheckInTime(int checkInTime) {
		if (checkInTime < 0 || checkInTime > 23) {
			return;
		}
		this.checkInTime = checkInTime;
	}// end setCheckInTime

	public int getCheckOutTime() {
		return checkOutTime;
	}// end getCheckOutTime

	public void setCheckOutTime(int checkOutTime) {
		if (checkInTime < 0 || checkInTime > 23) {
			return;
		}
		this.checkOutTime = checkOutTime;
	}// end setCheckOutTime

	void printInfo() {
		System.out.println("이름: " + name);
		System.out.println("입실: " + checkInTime);
		System.out.println("퇴실: " + checkOutTime);
		if (getCheckOutTime() == 0) {
			System.out.println("현재 입실 중");
		} else {
			System.out.println("총 이용시간: " + (getCheckOutTime() - getCheckInTime()));
		}
		System.out.println();
	}// end printInfo

}// end Attendance
