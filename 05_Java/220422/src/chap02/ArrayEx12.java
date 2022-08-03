package chap02;

import java.util.Arrays;

public class ArrayEx12 {

	public static void main(String[] args) {

		int[] numArr = new int[10];

		for (int i = 0; i < numArr.length; i++) {
			System.out.print(numArr[i] = (int) (Math.random() * 10));
		} // end for
		System.out.println();

		for (int i = 0; i < numArr.length - 1; i++) {
			boolean changed = false; // �ڸ��ٲ��� �߻��ߴ����� üũ�Ѵ�.

			for (int j = 0; j < numArr.length - 1 - i; j++) {
				if (numArr[j] < numArr[j + 1]) {
					int tmp = numArr[j];
					numArr[j] = numArr[j + 1];
					numArr[j + 1] = tmp;
					changed = true; // �ڸ��ٲ��� �߻������� changed�� true��;
				} // end if
			} // end for

			if (!changed) {
				break; // �ڸ��ٲ��� ������ �ݺ����� �����.
			} // end if

			System.out.println(Arrays.toString(numArr));

		} // end for

	}// end main

}// end ArrayEx12
