package step01;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class NewMember implements ChoiceName {
	private static NewMember member;
	final static String[] SIGN = new String[1];

	public static NewMember getInfo() {
		if (member == null) {
			member = new NewMember();
			return member;
		}
		return member;
	}

	private NewMember() {
		fileSearch();
	}

	private static ArrayList<User> users;
	MovieReservation mm = MovieReservation.getinstance();

	public static ArrayList<User> userInstance() {
		if (users == null) {
			users = new ArrayList<User>();
			return users;
		}
		return users;
	}

	String fileName = "NewMember.ser";
	MovieReservation reserInfo = MovieReservation.getinstance();

	void joinMember() {
		try {
			System.out.println("========================");
			System.out.println("�����ϽǷ��� 1�� ���θ޴��� �ƹ�Ű");
			System.out.println("========================");
			System.out.print("ȸ�������� �����Ͻðڽ��ϱ�? \n==>");
			int pick=Integer.parseInt(MovieReservation.sc.nextLine());
			if(pick==1) {
				User tmp = joinInfo();
				if (search(tmp.getId()) == null) {
					System.out.println("�����ڷν����ϰų� 2���� �̻��̾���մϴ�.");
					return;
				}
				for (int i = 0; i < users.size(); i++) {
					if (users.get(i).getId1(tmp.getId())) {
						System.out.println("�ߺ��� ID�Դϴ�.");
						return;
					}
				}
				users.add(tmp);
				System.out.println("---------���ԿϷ�----------");
			}else {
				return;
			}
		}catch (Exception e) {
			return;
		}
	}
	boolean userLogin(String id, String pwd) {
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getId1(id)) {
				if (users.get(i).getPwd1(pwd)) {
					NewMember.SIGN[0] = id;
					return true;
				}
			}
		}
		return false;
	}

	void memberDelete() {
		System.out.print("��й�ȣ�� �Է��ϼ��� ==> ");
		String pwd = MovieReservation.sc.nextLine().trim();
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getId1(SIGN[0])) {
				if (users.get(i).getPwd1(pwd)) {
					System.out.println("��ȸ������ ������ ������ ��� ��ҵ˴ϴ١�");
					System.out.print("���� Ż���Ͻðڽ��ϱ�? 1. Yes 2. No\n");
					System.out.print("==> ");
					int choice = Integer.parseInt(MovieReservation.sc.nextLine());
					if (choice == 1) {
						reserInfo.allCancel();
						users.remove(i);
						System.out.println("-----Ż��Ϸ�-----");
						SIGN[0] = null;
						return;

					} else {
						System.out.println("���");
						return;
					}
				} else {
					System.err.println("-----��й�ȣ�� Ʋ�Ƚ��ϴ�.-----");
					return;
				}
			}
		}
	}

	public boolean searchList() {
		if (users.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

	User joinInfo() {
		System.out.println("=======================");
		System.out.println("ID�� ���� 2�ڸ��̻� ����X");
		System.out.println("=======================");
		System.out.print("ID ==> ");
		String id = MovieReservation.sc.nextLine();
		System.out.print("PASSWORD ==> ");
		String pwd = MovieReservation.sc.nextLine();
		System.out.print("�̸� ==> ");
		String name = MovieReservation.sc.nextLine();
		System.out.print("��ȭ��ȣ (11�ڸ� -����) ==> ");
		String phoneNumber = MovieReservation.sc.nextLine();
		if(phoneNumber.length() != 11) {
			System.err.println("�޴��� ��ȣ�� �߸� �Է��ϼ̽��ϴ�.");
			return joinInfo();
		}
		boolean check;
		if((check=(id.contains(" ")||pwd.contains(" ")||name.contains(" ")||phoneNumber.contains(" ")))==true) {
			System.err.println("���鰪�� ����ֽ��ϴ�");
			return joinInfo();
		}else {
		return new User(id, pwd, name, phoneNumber);
		}
	}

	private String search(String id) {
		if (id.length() < 2) {
			System.err.println("���ڼ��� �����ϴ�.");
			return null;
		} else if (!(id.charAt(0) >= 'A' && id.charAt(0) <= 'Z')) {
			if (!(id.charAt(0) >= 'a' && id.charAt(0) <= 'z')) {
				return null;
			}
		}

		return id;
	}
	void userMenu() throws Exception {
		while (true) {
		try {
			MenuViewer.showMenu();
			int choice = Integer.parseInt(MovieReservation.sc.nextLine());
			if(choice < QUIT|| choice >7) {
				throw new ChoiceException();
			}
			switch (choice) {
			case MEMBER_RESERVATION:
				mm.seatChoice();
				break;
			case MEMBER_RESERVATION_CHECK:
				mm.reservationConfirm();
				break;
			case MEMBER_CANCEL:
				mm.reservationCancel();
				break;
			case SEARCH_SEAT:
				mm.showSeatStatus();
				break;
			case LOGOUT:
				if(mm.signOut()) {
				return;
				}break;
			case DELETE:
				memberDelete();
				break;
			case 7:
				mm.test();
				break;
			}
		} catch (Exception e) {
			continue;
		}
		}
	}

	void objOutputData() {
		FileOutputStream fos = null;
		ObjectOutputStream out = null;

		try {
			fos = new FileOutputStream(fileName);
			out = new ObjectOutputStream(fos);

			out.writeObject(users);
			System.out.println("���� �Ǿ����ϴ�..");
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

			users = (ArrayList<User>) in.readObject();
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
		File f = new File("C:\\Users\\WU\\eclipse-workspace\\TeamProject\\NewMember.ser");
		if (!f.exists()) {
			//System.out.println("Start");
		} else if (f.exists()) {
			objInputData();
			System.out.println("-----���� �ҷ����� �Ϸ�-----");
		}
	}
}