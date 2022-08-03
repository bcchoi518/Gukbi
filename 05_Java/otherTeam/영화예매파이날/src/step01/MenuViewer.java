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
		System.out.println("������������������������������������������������������������������������������");
		System.out.println(" 1. ��ȭ���š���  2. ����Ȯ�Ρ���  3. ������ҡ��� ");
		System.out.println("������������������������������������������������������������������������������");
		System.out.println("������������������������������������������������������������������������������");
		System.out.println(" 4. �¼���ȸ����  5. �α׾ƿ�����  6. ȸ��Ż�𡡡� ");
		System.out.println("������������������������������������������������������������������������������");
		System.out.print(">>> ");
	}

	static void showMovieMenu() {
		

		for(int i=0; i<movieName.length; i++)
			if(movieName[i]==null) {
				movieName[i] = "��������������ȭ��";
			}
		System.out.println("=======================");
		System.out.println("1. " + movieName[0]);
		System.out.println("2. " + movieName[1]);
		System.out.println("3. " + movieName[2]);
		System.out.println("=======================");
		System.out.println("0. ���");
		System.out.print(">>>>> ");
	}

	static void showUserManagement() {
		System.out.println(" ������������������������������������������������������������������������������������������������������");
		System.out.println("   1. �α���           2. ȸ������ 	     3. ��ȸ������	   ");
		System.out.println(" ������������������������������������������������������������������������������������������������������");
		System.out.println(" ������������������������������������������������������������������������������������������������������");
		System.out.println("  4. ��ȸ������Ȯ��	   5. ��ȸ���������	    6. ��ȭ�¼���ȸ     ");
		System.out.println(" ������������������������������������������������������������������������������������������������������");
		System.out.println("                  ����������������������������������");
		System.out.println("                   0. ���    	   ");
		System.out.println("                  ����������������������������������");
		System.out.print(">>> ");
	}

	static void showAdminChoice() {
		System.out.println("������������������������������������������������������������������������������������������������������");
		System.out.println(" 1. ȸ������     	  2. ��ȭ����   	    3. �׽�Ʈ        ");
		System.out.println("������������������������������������������������������������������������������������������������������");
		System.out.println("��������������������������������������������������������������������");
		System.out.println(" 4. ȸ�����     	  5. �α׾ƿ�   	  ");
		System.out.println("��������������������������������������������������������������������");
		System.out.print(">>> ");
	}

	static void movieManagement() {
		System.out.println(" ������������������������������������������������������������������");
		System.out.println("  1.�󿵿�ȭ�̸�	  2. ��ȭ�ð�����	 ");
		System.out.println(" ������������������������������������������������������������������");
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
		File f = new File("C:\\Users\\�ǹ���\\eclipse-workspace\\TeamProject\\MenuViwer.ser");
		if (!f.exists()) {
		} else if (f.exists()) {
			objInputData();
		}
	}

}