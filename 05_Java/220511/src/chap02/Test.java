package chap02;

import java.util.Arrays;

public class Test {
	public static void main(String[] args) {
		int[] arr = { 0, 1, 2, 3, 4 };
		int[] arr2 = { 0, 1, 2, 3, 4 };

		System.out.println(arr.equals(arr2)); // Object의 equals는 hashcode를 비교
		System.out.println(Arrays.equals(arr, arr2)); // Arrays.equals는 요소를 비교

		String[][] str = { { "aaa", "bbb" }, { "AAA", "BBB" } };
		String[][] str2 = { { "aaa", "bbb" }, { "AAA", "BBB" } };

		System.out.println(str.equals(str2)); // Object의 equals
		System.out.println(Arrays.equals(str, str2)); // 2차원 배열이기 때문에 각각의 안쪽 배열의 hashcode를 비교
		System.out.println(Arrays.deepEquals(str, str2)); // 2차원 배열의 요소까지 접근해서 비교
	}// end main
}// end Test
