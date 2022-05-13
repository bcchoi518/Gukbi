package chap06;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class SerialEx1 {
	public static void main(String[] args) {
		FileOutputStream fos = null;
		ObjectOutputStream out = null;
		try {
			String fileName = "UserInfo.ser";
			fos = new FileOutputStream(fileName);
			out = new ObjectOutputStream(fos);

			UserInfo u1 = new UserInfo("Shin", "1234", 10);
			UserInfo u2 = new UserInfo("park", "0000", 20);

			ArrayList<UserInfo> list = new ArrayList<UserInfo>();
			list.add(u1);
			list.add(u2);

//			out.writeObject(u1);
//			out.writeObject(u2);
			out.writeObject(list);

			System.out.println(list);

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (out != null) {
					out.close();
				} // end if
				if (fos != null) {
					fos.close();
				} // end if
			} catch (Exception e2) {
				e2.printStackTrace();
			} // end try-catch
		} // end try-catch-finally
	}// end main
}// end SerialEx1
