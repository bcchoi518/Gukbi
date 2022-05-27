package HorseRacing;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class HorseManager implements MenuViewer {
	public static ArrayList stable = new ArrayList();
	ArrayList raceHorse;

	HorseManager() {
		// 저장된 말이 없으면 기본 말들 생성
		try{
			stable = Loader.loadHorse();
		}catch(Exception e){
			stable.add(new Horse("흰둥이",   1, "5살", "수컷",  "서러브레드",   "나쁨"));
			stable.add(new Horse("검둥이",   2, "4살", "수컷",  "아랍",        "나쁨"));
			stable.add(new Horse("날쌩마",   3, "6살", "암컷",  "서러브레드",   "나쁨"));
			stable.add(new Horse("텔레토비",  4, "2살", "수컷",  "앵글로아랍",   "나쁨"));
			stable.add(new Horse("볼봉",     5, "3살", "암컷",  "서러브레드",   "나쁨"));
			stable.add(new Horse("포르세",    6, "7살", "암컷",  "서러브레드",  "나쁨"));
			stable.add(new Horse("랑보르기니", 7, "3살", "수컷",  "앵글로아랍",  "나쁨"));
			stable.add(new Horse("보라돌이",   8, "4살", "수컷",  "서러브레드",  "나쁨"));
			stable.add(new Horse("페라린",    9, "2살", "암컷",  "아랍",       "나쁨"));
			//stable.add(new Horse("부가띠",    10, "4살", "수컷",  "서러브레드",  "나쁨"));	
		}
	}
	
	// 경기에 출전할 경주마 7마리 선출
	public void horseChoice() {
		
		// stable에 저장된 말들 중에서 랜덤하게 경주마 7마리를 고른다.
		raceHorse = new ArrayList();
		
		// 경주마가 7마리가 될때까지 랜덤으로 돌림.
		for(int i= 0; raceHorse.size() < 7 ; i++) {
			//정수타입 변환
			int num = (int)(Math.random()*stable.size());
			// 마굿간에서 말 한마리를 랜덤으로 선출, 해당말이 경주마로 출전중인지 확인
			if(!raceHorse.contains(stable.get(num))){
				// 없으면 해당번째 말을 인스턴스화
				Horse tmp =(Horse)(stable.get(num));
				// 해당번째 말의 게이트번호를 현재 경주마 사이즈(초기값0)+1 의 숫자를 부여
				tmp.gateNumber = raceHorse.size()+1;
				// 경주마에 해당말을 추가(경주마 사이즈+=1)
				raceHorse.add(tmp);
			}
		}
	}

	// 경주마들 게이트 번호 초기화
	public void horseOut() {
		for(int i= 0; i < 7 ; i++) {
			Horse tmp =(Horse)(raceHorse.get(i));
			tmp.gateNumber = 0;
		}
	}
	
	// 말 관리 메뉴
	public void managerChoice() {
		while(true) {
			// 관리자 메뉴 출력 및 선택값 입력대기
			MenuViewer.horseManageMenu();
			try {
				int choice=Integer.parseInt(sc.nextLine());
				if (choice < HORSEINFO || choice > RETURN_HM)
					throw new MenuChoiceException(choice);
				switch(choice) {
				
					//경주마 정보 출력
					case HORSEINFO : showInfo(stable);
						break;
						
					//새로운 말 영입
					case NEWHORSE :  
						System.out.println("╚═══───────────────── • ─────────────────═══╝");
						System.out.println();
						System.out.println("╔═══───────────────── • ─────────────────═══╗");
						System.out.println("                 【경주마 영입】");
						System.out.print("  [ 이름 ] : ");
						String name = sc.nextLine();
						System.out.print("  [ 마번 ] : ");
						int horsenumber = Integer.parseInt(sc.nextLine());
						System.out.print("  [ 나이 ] : ");
						String age = sc.nextLine();
						System.out.print("  [ 성별 ] : ");
						String gender = sc.nextLine();
						System.out.print("  [ 품종 ] : ");
						String kind = sc.nextLine();
						// String Condition = 랜덤(나쁨,보통,좋음);
						String[] condition = {"나쁨","보통","좋음"};
						int itmp = (int)(Math.random()*3);
						stable.add(new Horse(name,horsenumber,
								   age,gender,kind,condition[itmp]));
						
						System.out.println("  《 입력이 완료되었습니다  》");
						
						break;
						
					//은퇴할 말 선택
					case RETIRE : 
						System.out.println("╚═══───────────────── • ─────────────────═══╝");
						System.out.println();
						System.out.println("╔═══───────────────── • ─────────────────═══╗");
						System.out.println("                 【경주마 은퇴】");
						System.out.print("  [ 이름 ] : ");
						name = sc.nextLine();
						boolean btmp = false;
						for (int i =0; i<stable.size(); i++) {
							Horse tmp = (Horse)stable.get(i);
							if(tmp.name.equals(name)) {
								stable.remove(i);
								btmp = true;
								System.out.println("  《 확인되었습니다 》");
							}
						}
						if(btmp!=true){
							System.out.println("  《 말이 존재하지 않습니다 》");
						}
						break;

					//메뉴 종료	
					case RETURN_HM :
						System.out.println("  《 메뉴를 종료합니다 》");
						return;
				}
			} catch (NumberFormatException e) {
				System.out.println("  《 숫자만 입력하세요 》");
			} catch (MenuChoiceException e) {
				e.showWrongChoice();
			}
		}	
	}
	
	// 경주마 정보 출력 
	void showInfo(ArrayList list) {
		System.out.println("╚═══───────────────── • ─────────────────═══╝");
		System.out.println();
		System.out.println("╔═══───────────────── • ─────────────────═══╗");
		System.out.println("                 【경주마 정보】");
		
		for (int i =0; i<list.size(); i++) {
			Horse tmp = (Horse)list.get(i);
			System.out.println(tmp);
		}
		if(list.size()==0){
			System.out.println("  《 영입한 말이 없습니다. 》");
		}
	}
	
	// 고객메뉴(였던것)
//	void customerChoice() {
//		while(true) {
//			// 손님 메뉴 출력 및 선택값 입력대기
//			MenuViewer.horseCustomMenu();
//			try {
//				int choice=Integer.parseInt(sc.nextLine());
//				if (choice < HORSEINFO || choice > RETURN_HC)
//					throw new MenuChoiceException(choice);
//				switch(choice) { //경주마 정보 출력
//					case HORSEINFO : showInfo();
//						break;
//					case RETURN_HC : //메뉴 종료
//						System.out.print("메뉴가 종료되었습니다.");
//						return;
//				}
//			} catch (NumberFormatException e) {
//				System.out.println("숫자만 입력하세요.\n");
//			} catch (MenuChoiceException e) {
//				e.showWrongChoice();
//			}
//		}
//	}
	
}
