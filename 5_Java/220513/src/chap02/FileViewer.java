package chap02;

import java.io.FileInputStream;
import java.io.IOException;

public class FileViewer {
	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\HKIT\\bcchoi\\5_Java\\220513\\src\\chap02\\FileViewer.java");
		int data = 0;

		while ((data = fis.read()) != -1) {
			char c = (char) data;
			System.out.print(c);
		} // end while
	}// end main
}// end FileViewer
