package sungjuk.proc;

import java.util.ArrayList;
import java.util.Scanner;

import sungjuk.model.SungjukDAO;
import sungjuk.model.SungjukDTO;

public class SungjukExample {
	public void sungjukExec() {
		Scanner scanner = new Scanner(System.in);
		SungjukDTO arguDto = new SungjukDTO(); 
		SungjukDTO resultDto = new SungjukDTO(); 
		SungjukDAO sungjukDao = new SungjukDAO();
		int result = 0;
		
		MENU:
		while (true) {
			System.out.print("성적관리메뉴선택(0:종료, 1:목록, 2:상세, 3:추가, 4:수정, 5:삭제) : ");
			String choice = scanner.nextLine();
			
			switch(choice) {
				case "1":
					ArrayList<SungjukDTO> list = sungjukDao.getSelectAll();
					System.out.println("─── List ─────────────────────────────────────────────────────────────────────────");
					for(int i = 0; i < list.size(); i++) {
						resultDto = list.get(i);
						resultDto.display();
					}//end for
					System.out.println("──────────────────────────────────────────────────────────────────────────────────");
					break;
				case "2":
					arguDto.input("view");
					resultDto = sungjukDao.getSelectOne(arguDto);
					if (resultDto.getRegiDate() != null) {
						System.out.println("─── View ─────────────────────────────────────────────────────────────────────────");
						resultDto.display();
						System.out.println("──────────────────────────────────────────────────────────────────────────────────");
					}//end if
					break;
				case "3":
					arguDto.input("chuga");
					arguDto.tot();
					arguDto.avg();
					arguDto.grade();
					result = sungjukDao.setInsert04(arguDto);
					break;
				case "4":
					arguDto.input("sujung");
					arguDto.tot();
					arguDto.avg();
					arguDto.grade();
					result = sungjukDao.setUpdate(arguDto);
					break;
				case "5":
					arguDto.input("sakje");
					result = sungjukDao.setDelete(arguDto);
					break;
				default:
					System.out.println("-- 성적관리 프로그램 종료 --");
					break MENU;
			}//end switch
		}//end while
	}//end main
}//end Example
