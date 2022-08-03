package poketmonproject;

public class MenuViewer {


	static void showMainMenu() { //메인메뉴 출력
		System.out.println("        ┌───────────────────────┐");
		System.out.println("        │     메뉴를 선택하세요..  	│");
		System.out.println("        ├───────────────────────┤");
		System.out.println("        │     [1] 포켓몬 잡기   	│");
		System.out.println("        │     [2] 포켓몬 도감   	│");
		System.out.println("        │     [3] 포켓몬 가방   	│");
		System.out.println("        │     [4] 가 방 정 리   	│");
		System.out.println("        │     [5] 뮤츠와 대결   	│");
		System.out.println("        │     [6] 게 임 종 료   	│");
		System.out.println("        └───────────────────────┘");
		System.out.print("	입력 → ");

    }

    static void showCatchMenu() { //지역메뉴 출력 - 지역별로 출몰하는 포켓몬의 타입이 다름
		System.out.println("        ┌───────────────────────┐");
		System.out.println("        │     지역을 선택하세요..  	│");
		System.out.println("        ├───────────────────────┤");
		System.out.println("        │  [0] 이전메뉴로 돌아가기  	│");
		System.out.println("        │  [1] 저~~　푸른 초원   	│");
		System.out.println("        │  [2] 뜨거운　사막지대   	│");
		System.out.println("        │  [3] 제주도 푸른 바다   	│");
		System.out.println("        │  [4] 한국전력공사      	│");
		System.out.println("        └───────────────────────┘");
		System.out.print("	입력 → ");
    }
    
    static void appearPoketmon() {
		System.out.println("        ┌───────────────────────┐");

		System.out.println("        ├───────────────────────┤");
    	
    }
    
    static void appearPoketmon2() {
		System.out.println("        └───────────────────────┘");
		System.out.print("	입력 → ");
    }
    
    static void showPoketBag() {
		System.out.println("        ┌───────────────────────┐");
		System.out.println("        │      포 켓 몬  가 방  	│");
		System.out.println("        ├───────────────────────┤");
    }
    static void showPoketBag2() {
		System.out.println("        └───────────────────────┘");
    }

    static void deleteMenu() { //삭제하기
		System.out.println("        ┌───────────────────────┐");
		System.out.println("        │    내보낼 포켓몬을 고르세요	│");
		System.out.println("        ├───────────────────────┤");
		System.out.println("        │[0] 이전메뉴로 돌아가기  	│");
    }
    static void deleteMenu2() { //삭제하기2
		System.out.println("        └───────────────────────┘");
		System.out.print("	입력 → ");
    }
    
    static void loginMenu() {
        System.out.println("              _                            ");
        System.out.println(" _ __   ___  | | _____ _ __ ___   ___  _ __  ");
        System.out.println(" | '_ \\ / _ \\| |/ / _ \\ '_ ` _ \\ / _ \\| '_ \\ ");
        System.out.println(" | |_) | (_) |   <  __/ | | | | | (_) | | | |");
        System.out.println(" | .__/ \\___/|_|\\_\\___|_| |_| |_|\\___/|_| |_|");
        System.out.println(" |_|                                         ");
        System.out.println("");
		System.out.println("        ┌───────────────────────┐");
		System.out.println("        │     WELCOME WORLD !   │");
		System.out.println("        ├───────────────────────┤");
		System.out.println("        │     [1] 회 원 가 입   	│");
		System.out.println("        │     [2] 로  그  인   	│");
		System.out.println("        │     [3] 게 임 종 료   	│");
		System.out.println("        └───────────────────────┘");
		System.out.print("	입력 → ");
	}
    
    static void vsMenu() {
		System.out.println("        ┌───────────────────────┐");
		System.out.println("        │    대결할 포켓몬을 고르세요	│");
		System.out.println("        ├───────────────────────┤");
    }
    static void vsMenu2() {
		System.out.println("        └───────────────────────┘");
		System.out.print("	입력 → ");
    }

	static void showPoketBook() { //포켓몬 도감
		System.out.println("        ┌───────────────────────────────┐");
		System.out.println("        │         포  켓  몬  도  감    	│");
		System.out.println("        ├───────┬───────────────────────┤");
		System.out.println("        │   풀 	│      저~ 푸른 초원    	│");
		System.out.println("        ├───────┴───────────────────────┤");
		System.out.println("        │  [Lv1] 뚜벅초	[CP]  10 ~ 100	│");
		System.out.println("        │  [Lv2] 파라스	[CP]  80 ~ 200	│");
		System.out.println("        │  [Lv3] 이상해씨	[CP] 210 ~ 500	│");
		System.out.println("        ├───────┬───────────────────────┤");
		System.out.println("        │   불 	│      뜨거운 사막지대    	│");
		System.out.println("        ├───────┴───────────────────────┤");
		System.out.println("        │  [Lv1] 가디 	[CP]  10 ~ 100	│");
		System.out.println("        │  [Lv2] 식스테일	[CP]  80 ~ 200	│");
		System.out.println("        │  [Lv3] 파이리	[CP] 210 ~ 500	│");
		System.out.println("        ├───────┬───────────────────────┤");
		System.out.println("        │   물 	│      제주도 푸른 바다   	│");
		System.out.println("        ├───────┴───────────────────────┤");
		System.out.println("        │  [Lv1] 고라파덕	[CP]  10 ~ 100	│");
		System.out.println("        │  [Lv2] 발챙이	[CP]  80 ~ 200	│");
		System.out.println("        │  [Lv3] 꼬부기	[CP] 210 ~ 500	│");
		System.out.println("        ├───────┬───────────────────────┤");
		System.out.println("        │  전기 	│        한국전력공사    	│");
		System.out.println("        ├───────┴───────────────────────┤");
		System.out.println("        │  [Lv1] 찌리리공	[CP]  10 ~ 100	│");
		System.out.println("        │  [Lv2] 코일 	[CP]  80 ~ 200	│");
		System.out.println("        │  [Lv3] 이상해씨	[CP] 210 ~ 500	│");
		System.out.println("        └───────────────────────────────┘");
		System.out.println("         메뉴로 돌아가시려면 아무키나 누르세요..");
	}
}