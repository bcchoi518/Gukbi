package chap01;

public class TvTest04 {

	public static void main(String[] args) {

		Tv[] tvArr = new Tv[3];

		for (int i = 0; i < tvArr.length; i++) {
			tvArr[i] = new Tv();
			tvArr[i].channel = i + 10; // tvArr[i]�� channel�� i+10�� ����
		} // end for

		for (int i = 0; i < tvArr.length; i++) {
			tvArr[i].channelUp(); // tvArr[i]�� �޼��带 ȣ��, ä���� 1����
			System.out.printf("tvArr[%d].channel = %d%n", i, tvArr[i].channel);
		} // end for
	}// end main

}// end TvTest04
