package HorseRacing;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.HashMap;

public class Loader {

	//회원정보 로드(실패시 호출된곳으로 에러 반환)
	static synchronized HashMap loadAccounts() throws Exception{
		FileInputStream fis=null;
		ObjectInputStream ois=null;
		try {
			fis = new FileInputStream("accounts.dat");
			ois = new ObjectInputStream(fis);
			return (HashMap)ois.readObject();
		} catch(Exception e) {
			//e.printStackTrace();
			throw e;
		} finally {
			try {
				if(ois!=null) ois.close();
				if(fis!=null) fis.close();
			} catch (Exception e) { 
				//e.printStackTrace();
				throw e;
			}
		}
	}
	
	// 말 정보 로드(실패시 호출된곳으로 에러 반환)
	static synchronized ArrayList loadHorse() throws Exception{
		FileInputStream fis=null;
		ObjectInputStream ois=null;
		try {             //저장된 파일 불러오기
			fis = new FileInputStream("stable.dat");
			ois = new ObjectInputStream(fis);
			return (ArrayList)ois.readObject();
		} catch(Exception e) {	
			//e.printStackTrace();
			throw e;
		} finally {
			try {
				if(ois!=null) ois.close();
				if(fis!=null) fis.close();
			} catch (Exception e) {
				//e.printStackTrace();
				throw e;
			}
		}
	}
	
	// 좌석 정보 로드(실패시 호출된곳으로 에러 반환)
	static synchronized int[][] loadSeat() throws Exception{
		FileInputStream fis=null;
		ObjectInputStream ois=null;
		try {             //저장된 파일 불러오기
			fis = new FileInputStream("seat.dat");
			ois = new ObjectInputStream(fis);
			return (int[][])ois.readObject();
		} catch(Exception e) {	
			//e.printStackTrace();
			throw e;
		} finally {
			try {
				if(ois!=null) ois.close();
				if(fis!=null) fis.close();
			} catch (Exception e) {
				//e.printStackTrace();
				throw e;
			}
		}
	}
}
