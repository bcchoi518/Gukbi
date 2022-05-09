package chap02;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ArrayListLinkedListTest2 {
	public static void main(String[] args) {
		ArrayList al = new ArrayList(1000000);
		LinkedList ll = new LinkedList();

		add(al);
		add(ll);

		System.out.println("== 접근시간 테스트 ==");
		System.out.println("ArrayList: " + access(al));
		System.out.println("LinkedList: " + access(ll));

	}// end main

	public static void add(List list) {
		for (int i = 0; i < 100000; i++) {
			list.add(i + "");
		} // end for
	}// end add

	public static long access(List list) {
		long start = System.currentTimeMillis();
		for (int i = 0; i < 100000; i++) {
			list.get(i);
		} // end for
		long end = System.currentTimeMillis();
		return end - start;
	}// end access
}// end ArrayListLinkedListTest2
