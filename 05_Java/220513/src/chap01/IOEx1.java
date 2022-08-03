package chap01;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;

public class IOEx1 {
	public static void main(String[] args) {
		byte[] inSrc = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		byte[] outSrc = null;

		// byte배열에서 읽어오기 때문에 ByteArrayInputStream
		ByteArrayInputStream input = new ByteArrayInputStream(inSrc);
		ByteArrayOutputStream output = new ByteArrayOutputStream();

		int data = 0;
		// ByteArrayInputStream에서 요소를 하나씩 읽어와서 요소가 없을때까지 반복문 수행
		while ((data = input.read()) != -1) { // 요소가 없으면 -1 반환하므로 종료
			output.write(data); // 요소를 ByteArrayOutputStream에 write()함
		} // end while

		outSrc = output.toByteArray();

		System.out.println("inSrc: " + Arrays.toString(inSrc));
		System.out.println("outSrc: " + Arrays.toString(outSrc));
	}// end main
}// end IOEx1
