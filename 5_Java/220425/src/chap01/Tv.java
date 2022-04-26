package chap01;

public class Tv {
	// Tv의 속성(멤버변수)
	String color; // 색상
	boolean power; // 전원상태(on/off)
	int channel; // 채널

	void power() { // Tv를 켜거나 끄는 기능을 하는 메서드
		power = !power;
	}// end power

	void channelUp() { // Tv의 채널을 높이는 기능을 하는 메서드
		channel++;
	}// end channelUp

	void channelDown() { // Tv의 채널을 낮추는 기능을 하는 메서드
		channel--;
	}// end channelDown
}// end Tv
