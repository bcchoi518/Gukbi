package chap01;

public class Tv {
	// Tv�� �Ӽ�(�������)
	String color; // ����
	boolean power; // ��������(on/off)
	int channel; // ä��

	void power() { // Tv�� �Ѱų� ���� ����� �ϴ� �޼���
		power = !power;
	}// end power

	void channelUp() { // Tv�� ä���� ���̴� ����� �ϴ� �޼���
		channel++;
	}// end channelUp

	void channelDown() { // Tv�� ä���� ���ߴ� ����� �ϴ� �޼���
		channel--;
	}// end channelDown
}// end Tv
