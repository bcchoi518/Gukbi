package chap02;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy {
	public static void main(String[] args) {
		try {
			FileInputStream fis = new FileInputStream(
					"C:\\Users\\HKIT\\bcchoi\\5_Java\\220513\\src\\chap02\\FileCopy.java");
			FileOutputStream fos = new FileOutputStream("FileCopy.bak");

			int data = 0;
			while ((data = fis.read()) != -1) {
				fos.write(data);
			} // end while

			fis.close();
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		} // end try-catch
	}// end main
}// end FileCopy
