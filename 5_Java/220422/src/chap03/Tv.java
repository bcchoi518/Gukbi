package chap03;

public class Tv {
	// 특징, 속성 : 멤버변수
	String color;
	boolean power;
	int channel;

	// 기능, 액션 : 멤버메서드
	void power() {
		power = !power; // toggle
	}

	void channelUp() {
		channel++;
	}

	void channelDown() {
		channel--;
	}
}// end Tv
