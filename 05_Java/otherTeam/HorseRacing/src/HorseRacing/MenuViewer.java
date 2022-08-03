package HorseRacing;
import java.util.Scanner;

public interface MenuViewer {
	Scanner sc = new Scanner(System.in);
	
	// 시작 메뉴 분기점
	final int LOGIN = 1, SIGNUP = 2, EXIT = 3;
	static void showStartMenu() {
		System.out.println();
		System.out.println("╔═══───────────────── • ─────────────────═══╗");
		System.out.println("               【HORSE RACING】");
		System.out.println("  [1] 로그인            [2] 회원가입");
		System.out.println("  [3] 프로그램 종료");
		System.out.print("  [ 입력 ] : ");
	}
	
	// 고객 시점 메뉴 분기점
	final int HORSEINFO=1,BETT=2,MONEY=3,SEAT=4,RACE=5,INFO=6,LOGOUT=7;
	static void showCustomerMenu() {
		System.out.println("╚═══───────────────── • ─────────────────═══╝");
		System.out.println();
		System.out.println("╔═══───────────────── • ─────────────────═══╗");
		System.out.println("                  【회원 모드】");
		System.out.println("  [1] 경주마 정보     ");
		System.out.println("  [2] 마권 구입 및 배팅");
		System.out.println("  [3] 금액 충전 및 조회  ");
		System.out.println("  [4] 좌석 예매 및 조회(취소)");
		System.out.println("  [5] 경주 관람");
		System.out.println("  [6] 회원정보 조회");
		System.out.println("  [7] 로그아웃 LOGOUT");
		System.out.print("  [ 입력 ] : ");
	}
	
	// 관리자 시점 메뉴 분기점
	final int HORSEMANAGE=1,LOGOUT_M = 2;
	static void showManagerMenu() {
		System.out.println("╚═══───────────────── • ─────────────────═══╝");
		System.out.println();
		System.out.println("╔═══───────────────── • ─────────────────═══╗");
		System.out.println("                 【관리자 모드】");
		System.out.println("  [1] 경주마 관리");
		System.out.println("  [2] 로그아웃");
		System.out.print("  [ 입력 ] : ");
	}
	
	// 좌석 예매 및 조회 메뉴 분기점
	final int TICKET=1,CHECK=2,CANCEL=3,RETURN=4;
	static void showSeatMenu() {
		System.out.println("╚═══───────────────── • ─────────────────═══╝");
		System.out.println();
		System.out.println("╔═══───────────────── • ─────────────────═══╗");
		System.out.println("               【좌석 예매 및 조회】");
		System.out.println("  [1] 좌석 예매");
		System.out.println("  [2] 좌석 조회");
		System.out.println("  [3] 예매 좌석 취소");		
		System.out.println("  [4] 이전 메뉴로 돌아가기");
		System.out.print("  [ 입력 ] : ");
	}
	
	// 마권 구입 및 배팅 메뉴 분기점
	final int SAMBOK=1, SAMSSANG=2;
	static void showBet() { // 승식 선택
		System.out.println("╚═══───────────────── • ─────────────────═══╝");
		System.out.println();
		System.out.println("╔═══───────────────── • ─────────────────═══╗");
		System.out.println("               【마권 구입 및 배팅】");
		System.out.println("  [1] 삼복승(순위 상관 없이 3마리 선택)");
		System.out.println("  [2] 삼쌍승(순위를 고려하여 3마리 선택)");
		System.out.print("  [ 입력 ] : ");
	}
	
	// 경주마 정보 관리 메뉴
	final int /*HORSEINFO=1,*/NEWHORSE=2,RETIRE=3,RETURN_HM=4;
	static void horseManageMenu() {
		System.out.println("╚═══───────────────── • ─────────────────═══╝");
		System.out.println();
		System.out.println("╔═══───────────────── • ─────────────────═══╗");
		System.out.println("                 【경주마 관리】");
		System.out.println("  [1] 경주마 정보 출력");
		System.out.println("  [2] 경주마 영입");
		System.out.println("  [3] 경주마 은퇴");
		System.out.println("  [4] 메뉴 종료");
		System.out.print("  [ 입력 ] : ");
	}
	
	// 금액 충전 및 조회 메뉴
	final int ADD_MONEY=1, CHECK_MONEY=2,RETURN_MN=3;
	static void moneyMenu() {
		System.out.println("╚═══───────────────── • ─────────────────═══╝");
		System.out.println();
		System.out.println("╔═══───────────────── • ─────────────────═══╗");
		System.out.println("               【금액 충전 및 조회】");
		System.out.println("  [1] 금액 충전");
		System.out.println("  [2] 금액 조회");
		System.out.println("  [3] 이전 메뉴로 돌아가기");
		System.out.print("  [ 입력 ] : ");
	}
	
	// 회원정보 조회 및 수정
		final int INFO_CUSTOMER=1, MODIFY_PHONENUMBER=2,RETURN_CMN=3;
		static void customerMenu() {
			System.out.println("╚═══───────────────── • ─────────────────═══╝");
			System.out.println();
			System.out.println("╔═══───────────────── • ─────────────────═══╗");
			System.out.println("             【회원정보 조회 및 수정】");
			System.out.println("  [1] 회원 정보 조회");
			System.out.println("  [2] 회원 정보 수정");
			System.out.println("  [3] 메뉴 종료");
			System.out.print("  [ 입력 ] : ");
		}
}