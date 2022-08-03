package chap01;

public class Tv {
	boolean power;
	int channel;

	void power() {
		power = !power;
	}// end power

	void channelUp() {
		channel++;
	}// end channelUp

	void channelDown() {
		channel--;
	}// end channelDown
}// end Tv
