package chap06;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class SerialEx2 {
	public static void main(String[] args) {
		FileInputStream fis = null;
		ObjectInputStream in = null;

		try {
			String fileName = "UserInfo.ser";
			fis = new FileInputStream(fileName);
			in = new ObjectInputStream(fis);

			ArrayList<UserInfo> list = (ArrayList<UserInfo>) in.readObject();

			System.out.println(list);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (in != null) {
					in.close();
				}
				if (fis != null) {
					fis.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}// end main
}// end SerialEx2
