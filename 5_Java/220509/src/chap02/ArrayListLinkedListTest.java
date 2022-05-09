package chap02;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ArrayListLinkedListTest {
	public static void main(String[] args) {
		// 추가할 데이터의 개수를 고려하여 충분히 잡아야한다.
		ArrayList al = new ArrayList(2000000);
		LinkedList ll = new LinkedList();

		System.out.println("== 순차적으로 추가하기 ==");
		System.out.println("ArrayList: " + add1(al) + "ms");
		System.out.println("LinkedList: " + add1(ll) + "ms");
		System.out.println();
		System.out.println("== 중간에 추가하기 ==");
		System.out.println("ArrayList: " + add2(al) + "ms");
		System.out.println("LinkedList: " + add2(ll) + "ms");
		System.out.println();
		System.out.println("== 중간에 삭제하기 ==");
		System.out.println("ArrayList: " + remove2(al) + "ms");
		System.out.println("LinkedList: " + remove2(ll) + "ms");
		// 10만번 이상 작업을 하면 ArrayList가 LinkedList보다 더 빠르다
		System.out.println();
		System.out.println("== 순차적으로 삭제하기 ==");
		System.out.println("ArrayList: " + remove1(al) + "ms");
		System.out.println("LinkedList: " + remove1(ll) + "ms");
	}// end main

	static long add1(List list) {
		long start = System.currentTimeMillis();
		for (int i = 0; i < 1000000; i++) {
			list.add(i + "");
		} // end for
		long end = System.currentTimeMillis();
		return end - start;
	}// end add1

	static long add2(List list) {
		long start = System.currentTimeMillis();
		for (int i = 0; i < 200000; i++) {
			list.add(500, "X");
		} // end for
		long end = System.currentTimeMillis();
		return end - start;
	}// end add2

	static long remove1(List list) {
		long start = System.currentTimeMillis();
		for (int i = list.size() - 1; i >= 0; i--) {
			list.remove(i);
		} // end for
		long end = System.currentTimeMillis();
		return end - start;
	}// end remove1

	static long remove2(List list) {
		long start = System.currentTimeMillis();
		for (int i = 0; i < 200000; i++) {
			list.remove(i);
		} // end for
		long end = System.currentTimeMillis();
		return end - start;
	}// end remove2
}// end ArrayListLinkedListTest
