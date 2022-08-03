package HorseRacing;

import java.util.HashMap;

public class Main implements MenuViewer {

	public static void main(String[] args) {
		Management m = new Management();	
		
		// 프로그램시작시 로고 3초간 출력(테스트하면서 보기싫으면 주석처리해주세유)
		m.rm.startMovie();
		
		// 자동저장스레드
		Thread ds = new DataSafer();
		ds.setDaemon(true);
		ds.start();
		
		// 사용자가 EXIT값을 입력할때까지 반복
		while (true) {
			// 시작메뉴 출력
			MenuViewer.showStartMenu();

			// LOGIN = 1, SIGNUP = 2, EXIT = 3;
			try {
				int choice = Integer.parseInt(sc.nextLine());
				if (choice < LOGIN || choice > EXIT)
					throw new MenuChoiceException(choice);
				switch (choice) {
				case LOGIN:
					m.login();
					break;
				case SIGNUP:
					m.signUp();
					break;
				case EXIT:
					System.out.println("  《 프로그램을 종료합니다 》");
					System.out.println("╚═══───────────────── • ─────────────────═══╝");
					Saver.saveAccounts();
					Saver.saveHorse();
					Saver.saveSeat();
					return;
				}
			} catch (NumberFormatException e) {
				System.out.println("  《 범위 내의 숫자를 올바른 형태로 입력하세요 》");
				System.out.println("╚═══───────────────── • ─────────────────═══╝");
			} catch (MenuChoiceException e) {
				e.showWrongChoice();
				System.out.println("╚═══───────────────── • ─────────────────═══╝");

			}
		}
	}
}