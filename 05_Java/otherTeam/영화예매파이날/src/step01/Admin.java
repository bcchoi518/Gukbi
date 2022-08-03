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
				System.err.println("정해진 숫자만 입력하세요!");
				continue;
			}
			break;
		}//while
	}
	
	private void movieCount() throws ChoiceException {
		while(true) {
			try {
				System.out.println("상영관을 선택해주세요");
				System.out.printf("1. 1관 2. 2관 3. 3관 \n ==>");
				int moviechoice = Integer.parseInt(MovieReservation.sc.nextLine());
				System.out.print("상영할 갯수를 입력하세요 \n ==> ");
				int number = Integer.parseInt(MovieReservation.sc.nextLine());
				System.out.printf("%d 개 맞습니까? 1. Yes 2. No 3.메인메뉴\n==> ", number);
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
					System.out.println("-----취소-----");
					return;
				}
			} catch (NumberFormatException e) {
				System.err.println("숫자만 입력하세요\n");
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
					System.out.printf(choice + "관 %d번째 영화시간을 적어주세요 ed)10시20분 : 1020\n ==> ", i+1);
					String time = MovieReservation.sc.nextLine();
					String hour = String.valueOf(time).substring(0, 2);
					String minute = String.valueOf(time).substring(2, 4);
					
					if(String.valueOf(time).length()!=4) {
						System.err.println("4자리만 입력해주세요");
						continue;
					}
					boolean isNumeric=time.matches("[+-]?\\d*(\\.\\d+)?");//문자열이 숫자인지 확인	 false면 리턴(exception에서 처리)
					int timeRimit=Integer.parseInt(hour);//비교하기위해 int에 담음
					int minuteRimit=Integer.parseInt(minute);
					if(0>timeRimit || timeRimit>23) {//시간제한
						System.out.println("시간은 0~23까지 입력");						
						if(0>minuteRimit || minuteRimit>59) {//시간맞고 분틀렷을때
							System.out.println("분은 0~59까지 입력");
							continue;
						}
						continue;
					}
					if(0>minuteRimit || minuteRimit>59) {//분 제한
						System.out.print(",분은 0~59까지 입력");
						continue;
					}
					System.out.printf("%s 시 %s 분 맞습니까?\n 1.Yes 2.No 3.메인메뉴\n ==> ", hour, minute);
					int yn = Integer.parseInt(MovieReservation.sc.nextLine());
					if(yn==3) {
						 return;
					}
					if (yn < 1 || yn > 2) {
						System.err.println("잘못입력하셨습니다.다시입력해주세요");
						continue;
					}
					if (yn == 1) {
							MovieReservation.movieTime[choice-1][i] = hour + "시 " + minute + "분";
							break;
					} else {
						System.err.println("다시 입력해주세요");
						continue;
					}
				}catch (Exception e) {
					System.err.println("====정확하게 입력!====");
					continue;
				}
			}
		}
		System.out.println(num + "개 생성완료");
		mm.movieSeat(choice);
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}

	}

	private void movieName() throws ChoiceException {
		while(true) {
			System.out.println("선택해주세요");
			System.out.print("1. 1관  2. 2관 3. 3관\n ==> ");
			try {
				int choice = Integer.parseInt(MovieReservation.sc.nextLine());
				if (choice < 0 || choice > 3) {
					throw new ChoiceException();
				}
					System.out.print(choice + "관 영화이름을 적어주세요. \n==>");
					MenuViewer.movieName[choice-1] = MovieReservation.sc.nextLine();
				
			} catch (ChoiceException e) {
				e.showWrongChoice();
				continue;
			} catch (NumberFormatException e) {
				System.out.println("숫자만 입력하세요.\n");
				continue;
			}
			return;
		}//while
	}
	int login() {
		System.out.print("ID를 입력하세요 ==> ");
		id = MovieReservation.sc.nextLine().trim();
		System.out.print("비밀번호를 입력하세요 ==> ");
		pwd = MovieReservation.sc.nextLine().trim();
		return check();
	}
	
	private int check() {
		if(ad(id,pwd))
		{
			System.out.println("-----관리자 로그인-----");
			access = true;
			return 3;
		}else if(nm.userLogin(id,pwd)) {
			System.out.println("----로그인 완료----");
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
			System.out.println("※WARNING※\n잘못된 접근방식입니다.");
			return;
		}
		mm.movieCheck();
		MenuViewer.showAdminChoice();
		int choice = Integer.parseInt(MovieReservation.sc.nextLine());
		switch(choice) {
		case 1:{
			System.out.println("----구현x----");
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
				System.out.println("회원 목록이 존재하지 않습니다.");
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
