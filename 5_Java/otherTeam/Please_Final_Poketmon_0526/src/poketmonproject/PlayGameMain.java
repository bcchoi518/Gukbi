package poketmonproject;

public class PlayGameMain {

    public static void main(String[] args) {
        GameManager gm = new GameManager(); 
        LoginManager lm = LoginManager.getLoginManager();
        BattleMewtwo mewtwo = new BattleMewtwo();

        int choice = 0; //0번메뉴가 실행되도록 값 셋팅
        boolean loginResult = false;

        loginResult=lm.loginStep(); //로그인메뉴
        lm.readPoketmonsFromFile(); //저장된 파일을 불러옴

        while (loginResult) { //로그인된 후 
        
        	switch (choice) {
                case 0: 
                    MenuViewer.showMainMenu(); //메인메뉴 출력
                    try {
                        String num = GameConst.sc.nextLine().trim();
                        if (num.length() == 1) {
                            choice = Integer.parseInt(num);
                        } else {
                            System.out.println("              잘못입력하셨습니다..");
                        } 
                        continue;

                    } catch (NumberFormatException e) { //문자입력시 예외처리
                        System.out.println("             숫자만 입력하세요..");
                    }
                    break;
                    
                case 1:
                	MenuViewer.showCatchMenu(); //지역메뉴 출력
                    try{
                        if(gm.getPoketmon(Integer.parseInt(GameConst.sc.nextLine()))){
                        	lm.savePoketmonsToFile(); //잡은 포켓몬을 파일에 저장한 후
                            choice = 3;      //가방으로 이동
                        }else{
                            System.out.println("           메인메뉴로 돌아갑니다..");
                            choice = 0;
                        }
                    } catch (NumberFormatException e) { //예외처리
                        System.out.println("              숫자만 입력하세요...");
                    } catch (NullPointerException e) {
                        System.out.println("              숫자만 입력하세요.....");
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("            없는 선택지입니다...");
                    }
                    break;
                    
                case 2:
                    MenuViewer.showPoketBook(); //도감 출력
                    GameConst.sc.nextLine(); //입력받으면 메인메뉴로 이동
                    choice = 0;
                    break;
                    
                case 3:
                	MenuViewer.showPoketBag(); //꾸며주는 메서드
                    gm.showBagInPokekmon(); //가방에 담긴 값 출력
                    MenuViewer.showPoketBag2(); //꾸며주는 메서드2
                    choice = 0; //초기메뉴로 이동
                    break;
                    
                case 4:
                	if(GameConst.poketmonBag.size() == 0) { //가방에 담긴 값이 없을때
                		System.out.println("              빈 가방입니다..");
                		choice = 0;
                		break;
                	}
                    MenuViewer.deleteMenu(); //담긴값이 있을 경우
                    try {
                    	gm.showBagInPokekmon();
                        MenuViewer.deleteMenu2();
                        gm.deletePoketmon(Integer.parseInt(GameConst.sc.nextLine())); //번호 입력받고 삭제
                        lm.savePoketmonsToFile(); //저장
                		System.out.println();
                    } catch (NumberFormatException e) { //예외처리
                        System.out.println("             숫자만 입력하세요..");
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("             없는 선택지입니다..");
                    }
                    choice = 0; 
                    break;
                    
                case 5:
                	if(GameConst.poketmonBag.size() < 3) { //가방에 3마리가 없을때
                		System.out.println("            입장하실 수 없습니다..    　");
                		System.out.println();
                		choice = 0;
                		break;
                	}
                		System.out.println("	   입장하시겠습니까? [Y/N]");
                		System.out.print("	입력 → ");
                		String select=GameConst.sc.nextLine().trim(); //y/n 입력받기
                			
                			if("Y".equalsIgnoreCase(select)) {
                			try {	
                				for(int i=0; i<3; i++) { //3마리가 될 때 동안
                					MenuViewer.vsMenu();
                					gm.showBagInPokekmon(); //가방 출력
                					MenuViewer.vsMenu2();
                					int poketmonChoice = Integer.parseInt(GameConst.sc.nextLine()); //입력받기
                					if(poketmonChoice <= 0 || poketmonChoice > GameConst.poketmonBag.size()) {
                						System.out.println("              잘못입력하셨습니다.."); //없는 번호 입력시
                						i--;
                						continue;
                					}
                					gm.selectVsMewtwo(poketmonChoice); //입력받은 값을 List에 담는다
                					
                					System.out.println();
                					System.out.println("	  선택한 포켓몬은..");
                					for(int j = 0 ; j < GameConst.vsList.size(); j++){ //고른 포켓몬 출력하기			
                						Poketmon p = GameConst.vsList.get(j);
                						System.out.println("          ["+(j+1)+"]"+" ["+ p.name +"] [ CP "+p.cp+"]");
                					}
                				}
                				mewtwo.showBattle(); //배틀메뉴 출력
                				lm.savePoketmonsToFile(); //저장
                			}catch(NumberFormatException e){ //예외처리
                				System.out.println("              숫자만 입력하세요..");
                			}
                			}else{
                				choice = 0;
                				break;
                			}
                	System.out.println("            메인메뉴로 돌아갑니다.."); // false일 경우
                	choice = 0;
                	break;
                	
                case 6:
                    System.out.println("            게임을 종료합니다..");
    				lm.savePoketmonsToFile(); //저장
    				return; // 프로그램 종료
    	        default:
    	            System.out.println("            없는 선택지입니다...");
    	            choice = 0;
    	            break;
            }		
        }
    }
}