package chap03;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class Bingo {
	public static void main(String[] args) {
//		Set set = new HashSet(); // 중복되지 않은 숫자를 저장
		Set set = new LinkedHashSet();
		int[][] board = new int[5][5];

		for (int i = 0; set.size() < 25; i++) {
			set.add((int) (Math.random() * 25) + 1 + "");
		} // end for

		Iterator it = set.iterator();

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				// it.next의 반환타입은 Object이므로 String으로 변환 후 Integer로 변환
				board[i][j] = Integer.parseInt((String) it.next());
//				System.out.print((board[i][j] < 10 ? "  " : " ") + board[i][j]);
				System.out.printf("%2d ", board[i][j]);
			} // end for
			System.out.println();
		} // end for
	}// end main
}// end Bingo
