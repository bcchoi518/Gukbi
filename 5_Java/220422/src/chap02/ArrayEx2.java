package chap02;

public class ArrayEx2 {

	public static void main(String[] args) {

		int[] score = { 20, 30, 100, 88, 90 };
		int sum = 0;
		double avg = 0;

		for (int i = 0; i < score.length; i++) {
			sum += score[i];
		}

		avg = sum / (double) score.length;

		System.out.println("�� �� : " + sum);
		System.out.println("�� �� : " + avg);

	}// end main

}// end ArrayEx2
