package chap04;

import java.util.TreeSet;

public class TreeSetEx1 {
	public static void main(String[] args) {
		TreeSet set = new TreeSet();
		int[] score = { 80, 95, 50, 35, 45, 65, 10, 100 };

		for (int i = 0; i < score.length; i++) {
			set.add(score[i]); // set.add(new Integer(score[i])); 오토박싱
		} // end for

		System.out.println("50보다 작은 값: " + set.headSet(50)); // set.headSet(new Integer(50))
		System.out.println("50보다 큰 값: " + set.tailSet(50));

	}// end main
}// end TreeSetEx1
