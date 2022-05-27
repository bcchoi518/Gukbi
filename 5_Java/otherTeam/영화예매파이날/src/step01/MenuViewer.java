package step01;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class MenuViewer {
	private static MenuViewer e;
	private MenuViewer() {
		fileSearch();
	}
	public static MenuViewer getInstance() {
		if(e == null) {
			e = new MenuViewer();
			return e;
		}return e;
	}
	static String movieName[] = new String[3];
    String fileName = "MenuViwer.ser";
	static void showMenu() {
		System.out.println("┌───────────┐┌───────────┐┌───────────┐");
		System.out.println(" 1. 영화예매　　  2. 예매확인　　  3. 예매취소　　 ");
		System.out.println("└───────────┘└───────────┘└───────────┘");
		System.out.println("┌───────────┐┌───────────┐┌───────────┐");
		System.out.println(" 4. 좌석조회　　  5. 로그아웃　　  6. 회원탈퇴　　 ");
		System.out.println("└───────────┘└───────────┘└───────────┘");
		System.out.print(">>> ");
	}

	static void showMovieMenu() {
		

		for(int i=0; i<movieName.length; i++)
			if(movieName[i]==null) {
				movieName[i] = "개설되지않은영화관";
			}
		System.out.println("=======================");
		System.out.println("1. " + movieName[0]);
		System.out.println("2. " + movieName[1]);
		System.out.println("3. " + movieName[2]);
		System.out.println("=======================");
		System.out.println("0. 취소");
		System.out.print(">>>>> ");
	}

	static void showUserManagement() {
		System.out.println(" ┌───────────────┐┌───────────────┐┌───────────────┐");
		System.out.println("   1. 로그인           2. 회원가입 	     3. 비회원예매	   ");
		System.out.println(" └───────────────┘└───────────────┘└───────────────┘");
		System.out.println(" ┌───────────────┐┌───────────────┐┌───────────────┐");
		System.out.println("  4. 비회원예매확인	   5. 비회원예매취소	    6. 영화좌석조회     ");
		System.out.println(" └───────────────┘└───────────────┘└───────────────┘");
		System.out.println("                  ┌───────────────┐");
		System.out.println("                   0. 취소    	   ");
		System.out.println("                  └───────────────┘");
		System.out.print(">>> ");
	}

	static void showAdminChoice() {
		System.out.println("┌───────────────┐┌───────────────┐┌───────────────┐");
		System.out.println(" 1. 회원관리     	  2. 영화관리   	    3. 테스트        ");
		System.out.println("└───────────────┘└───────────────┘└───────────────┘");
		System.out.println("┌───────────────┐┌───────────────┐");
		System.out.println(" 4. 회원목록     	  5. 로그아웃   	  ");
		System.out.println("└───────────────┘└───────────────┘");
		System.out.print(">>> ");
	}

	static void movieManagement() {
		System.out.println(" ┌──────────────┐┌───────────────┐");
		System.out.println("  1.상영영화이름	  2. 영화시간설정	 ");
		System.out.println(" └──────────────┘└───────────────┘");
		System.out.print(">>> ");
	}
	void objOutputData() {
		FileOutputStream fos = null;
		ObjectOutputStream out = null;
		try {

			fos = new FileOutputStream(fileName);
			out = new ObjectOutputStream(fos);

			out.writeObject(movieName);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (out != null) {
					out.close();
				}
				if (fos != null) {
					fos.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	@SuppressWarnings("unchecked")
	void objInputData() {
		FileInputStream fis = null;
		ObjectInputStream in = null;
		try {
			fis = new FileInputStream(fileName);
			in = new ObjectInputStream(fis);

			movieName = (String[]) in.readObject();
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
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	void fileSearch() {
		File f = new File("C:\\Users\\권문조\\eclipse-workspace\\TeamProject\\MenuViwer.ser");
		if (!f.exists()) {
		} else if (f.exists()) {
			objInputData();
		}
	}

}