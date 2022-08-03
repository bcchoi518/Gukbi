package HorseRacing;

import java.util.HashMap;
import java.util.ArrayList;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Saver {
	
	// 회원정보 저장
	public static synchronized void saveAccounts() {
		FileOutputStream fos=null;
		ObjectOutputStream oos=null;
		try {
			fos = new FileOutputStream("accounts.dat");
			oos = new ObjectOutputStream(fos);
			oos.writeObject(Management.accountStorage);
		} catch(Exception e) {	
			//e.printStackTrace();
		} finally {
			try {
				if(oos!=null) oos.close();
				if(fos!=null) fos.close();
			} catch (Exception e) { 
				//e.printStackTrace();
			}
		}
	}
	
	// 말 정보 저장
	public static synchronized void saveHorse() {
		FileOutputStream fos=null;
		ObjectOutputStream oos=null;
		try {       //말저장소 파일에 저장하기
			fos = new FileOutputStream("stable.dat");
		    oos = new ObjectOutputStream(fos);
			oos.writeObject(HorseManager.stable);
		} catch(Exception e) {	
			//e.printStackTrace();
		} finally {
			try {
				if(oos!=null) oos.close();
				if(fos!=null) fos.close();
			} catch (Exception e) {
				//e.printStackTrace();
			}
		}
	}
	
	// 좌석 정보 저장
	public static synchronized void saveSeat() {
		FileOutputStream fos=null;
		ObjectOutputStream oos=null;
		try {       // 좌석정보 파일에 저장하기
			fos = new FileOutputStream("seat.dat");
		    oos = new ObjectOutputStream(fos);
			oos.writeObject(SeatManager.seat);
		} catch(Exception e) {	
			//e.printStackTrace();
		} finally {
			try {
				if(oos!=null) oos.close();
				if(fos!=null) fos.close();
			} catch (Exception e) {
				//e.printStackTrace();
			}
		}
	}
}
