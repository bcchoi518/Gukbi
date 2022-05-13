package chap04;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;

public class DataInputSteramEx2 {
	public static void main(String[] args) {
		int sum = 0;
		int score = 0;
		DataInputStream dis = null;

		try {
			FileInputStream fis = new FileInputStream("score.dat");
			dis = new DataInputStream(fis);

			while (true) {
				score = dis.readInt();
				System.out.println(score);
				sum += score;
			} // end while
				// DataInputStream의 readInt()와 같이 데이터를 읽는 메서드는 더 이상 읽을 데이터가 없으면 EOFException을
				// 발생시킨다.
				// 그래서 다른 입력스트림들과 달리 무한반복문과 EOFException을 처리하는 catch문을 이용해서 데이터를 읽는다.
		} catch (EOFException e) {
			System.out.println("점수의 총합은 " + sum + "입니다.");
		} catch (IOException ie) {
			ie.printStackTrace();
		} finally {
			try {
				if (dis != null) { // NullPointException을 예방하는 코드
					dis.close();
				} // end if
			} catch (IOException ie) {
				ie.printStackTrace();
			} // end try-catch
		} // end try-catch
	}// end main
}// end DataInputSteramEx2
