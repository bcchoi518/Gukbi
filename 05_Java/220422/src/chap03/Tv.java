package chap03;

public class Tv {
	// Ư¡, �Ӽ� : �������
	String color;
	boolean power;
	int channel;

	// ���, �׼� : ����޼���
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
