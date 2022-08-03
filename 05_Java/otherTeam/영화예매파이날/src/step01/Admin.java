package step01;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class Admin extends User implements Serializable {
	private static Admin s;
	MovieReservation mm = MovieReservation.getinstance();
	NewMember nm = NewMember.getInfo();
	ArrayList<User> users = NewMember.userInstance();
    private HashMap admin = new HashMap();
    private boolean access = false;
    private String id,pwd;
    
    private Admin() {
    		admin.put("#admin", "0462" );
	}

	public static Admin getInstance() {
		if (s == null) {
			s = new Admin();
			return s;
		}
		return s;
	}

	private boolean ad(String id, String pwd) {
		if (admin.containsKey(id)) {
			if (admin.get(id).equals(pwd)) {
				return true;
			}
		}
		return false;
	}
	private void showAllUser() {
		for (int i = 0; i < users.size(); i++) {
			users.get(i).showInfo();
			System.out.println(users.get(i));
		}
	}
	private void movieManagement() {
		while(true) {
			try {
				MenuViewer.movieManagement();
				int choice = Integer.parseInt(MovieReservation.sc.nextLine());
				switch (choice) {
				case 1:
					movieName();
					break;
				case 2:
					movieCount();
					break;
				}
			}catch (Exception e) {
				System.err.println("������ ���ڸ� �Է��ϼ���!");
				continue;
			}
			break;
		}//while
	}
	
	private void movieCount() throws ChoiceException {
		while(true) {
			try {
				System.out.println("�󿵰��� �������ּ���");
				System.out.printf("1. 1�� 2. 2�� 3. 3�� \n ==>");
				int moviechoice = Integer.parseInt(MovieReservation.sc.nextLine());
				System.out.print("���� ������ �Է��ϼ��� \n ==> ");
				int number = Integer.parseInt(MovieReservation.sc.nextLine());
				System.out.printf("%d �� �½��ϱ�? 1. Yes 2. No 3.���θ޴�\n==> ", number);
				int choice = Integer.parseInt(MovieReservation.sc.nextLine());
				if (choice ==3) { return;}
				if (choice < 1 || choice > 2) {
					throw new ChoiceException();
				}
				if (choice == 1) {
					movieSearch(moviechoice, number);
				} else if(choice==2){
					continue;
				} else {
					System.out.println("-----���-----");
					return;
				}
			} catch (NumberFormatException e) {
				System.err.println("���ڸ� �Է��ϼ���\n");
				continue;
			} //try
			break;
		}//while
	}


	private void movieSearch(int choice, int num) {
			try {
			MovieReservation.movie[choice-1] = new String[6][6][num];
			MovieReservation.movieTime[choice-1] = new String[num];
		for (int i = 0; i < num; i++) {
			while (true) {
				try {
					System.out.printf(choice + "�� %d��° ��ȭ�ð��� �����ּ��� ed)10��20�� : 1020\n ==> ", i+1);
					String time = MovieReservation.sc.nextLine();
					String hour = String.valueOf(time).substring(0, 2);
					String minute = String.valueOf(time).substring(2, 4);
					
					if(String.valueOf(time).length()!=4) {
						System.err.println("4�ڸ��� �Է����ּ���");
						continue;
					}
					boolean isNumeric=time.matches("[+-]?\\d*(\\.\\d+)?");//���ڿ��� �������� Ȯ��	 false�� ����(exception���� ó��)
					int timeRimit=Integer.parseInt(hour);//���ϱ����� int�� ����
					int minuteRimit=Integer.parseInt(minute);
					if(0>timeRimit || timeRimit>23) {//�ð�����
						System.out.println("�ð��� 0~23���� �Է�");						
						if(0>minuteRimit || minuteRimit>59) {//�ð��°� ��Ʋ������
							System.out.println("���� 0~59���� �Է�");
							continue;
						}
						continue;
					}
					if(0>minuteRimit || minuteRimit>59) {//�� ����
						System.out.print(",���� 0~59���� �Է�");
						continue;
					}
					System.out.printf("%s �� %s �� �½��ϱ�?\n 1.Yes 2.No 3.���θ޴�\n ==> ", hour, minute);
					int yn = Integer.parseInt(MovieReservation.sc.nextLine());
					if(yn==3) {
						 return;
					}
					if (yn < 1 || yn > 2) {
						System.err.println("�߸��Է��ϼ̽��ϴ�.�ٽ��Է����ּ���");
						continue;
					}
					if (yn == 1) {
							MovieReservation.movieTime[choice-1][i] = hour + "�� " + minute + "��";
							break;
					} else {
						System.err.println("�ٽ� �Է����ּ���");
						continue;
					}
				}catch (Exception e) {
					System.err.println("====��Ȯ�ϰ� �Է�!====");
					continue;
				}
			}
		}
		System.out.println(num + "�� �����Ϸ�");
		mm.movieSeat(choice);
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}

	}

	private void movieName() throws ChoiceException {
		while(true) {
			System.out.println("�������ּ���");
			System.out.print("1. 1��  2. 2�� 3. 3��\n ==> ");
			try {
				int choice = Integer.parseInt(MovieReservation.sc.nextLine());
				if (choice < 0 || choice > 3) {
					throw new ChoiceException();
				}
					System.out.print(choice + "�� ��ȭ�̸��� �����ּ���. \n==>");
					MenuViewer.movieName[choice-1] = MovieReservation.sc.nextLine();
				
			} catch (ChoiceException e) {
				e.showWrongChoice();
				continue;
			} catch (NumberFormatException e) {
				System.out.println("���ڸ� �Է��ϼ���.\n");
				continue;
			}
			return;
		}//while
	}
	int login() {
		System.out.print("ID�� �Է��ϼ��� ==> ");
		id = MovieReservation.sc.nextLine().trim();
		System.out.print("��й�ȣ�� �Է��ϼ��� ==> ");
		pwd = MovieReservation.sc.nextLine().trim();
		return check();
	}
	
	private int check() {
		if(ad(id,pwd))
		{
			System.out.println("-----������ �α���-----");
			access = true;
			return 3;
		}else if(nm.userLogin(id,pwd)) {
			System.out.println("----�α��� �Ϸ�----");
			NewMember.SIGN[0]=id;
					return 2;
		}else {
			return 1;
		}
	}
	void adminChoice() {
		while(true) {
		try {
		if(!access) {
			System.out.println("��WARNING��\n�߸��� ���ٹ���Դϴ�.");
			return;
		}
		mm.movieCheck();
		MenuViewer.showAdminChoice();
		int choice = Integer.parseInt(MovieReservation.sc.nextLine());
		switch(choice) {
		case 1:{
			System.out.println("----����x----");
			break;
		}
		case 2:{
			movieManagement();
			break;
		}
		case 3:{
			mm.showSeat();
			break;
		}
		case 4:
			if (nm.searchList()) {
				System.out.println("ȸ�� ����� �������� �ʽ��ϴ�.");
				break;
			} else {
				showAllUser();
				break;
			}
		case 5:{
			if(mm.signOut()) {
			access = false;
			return;
			}
			break;
		}
		
		}
		}catch(Exception e) {}
	}
	}
}
