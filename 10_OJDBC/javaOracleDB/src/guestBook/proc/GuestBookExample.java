package guestBook.proc;

import java.util.ArrayList;
import java.util.Scanner;

import guestBook.model.GuestBookDAO;
import guestBook.model.GuestBookDTO;

public class GuestBookExample {
	public void guestBookExec() {
		Scanner scanner = new Scanner(System.in);
		GuestBookDTO arguDto = new GuestBookDTO();
		GuestBookDTO resultDto = new GuestBookDTO();
		GuestBookDAO guestBookDao = new GuestBookDAO();
		int result = 0;
		int dataCheckResult = 0;
		boolean pwChecker = false;
		
		MENU:
		while (true) {
			System.out.print("방명록관리메뉴(0:종료, 1:목록, 2:상세, 3:추가, 4:수정, 5:삭제) : ");
			String choice = scanner.nextLine();
			
			switch(choice) {
			case "1":
				ArrayList<GuestBookDTO> list = new ArrayList<>();
				list = guestBookDao.getSelectAll();
				System.out.println("─── List ─────────────────────────────────────────────────────────────────────────");
				for (int i = 0; i < list.size(); i++) {
					resultDto = list.get(i);
					resultDto.display("list");
				}//end for
				System.out.println("──────────────────────────────────────────────────────────────────────────────────");
				break;
			case "2":
				arguDto.inputNo("view");
				dataCheckResult = guestBookDao.dataCheck(arguDto);
				if (dataCheckResult != 0) {
					System.out.println("─── View ─────────────────────────────────────────────────────────────────────────");
					resultDto = guestBookDao.getSelectOne(arguDto);
					resultDto.display("view");
					System.out.println("──────────────────────────────────────────────────────────────────────────────────");
				}//end if
				break;
			case "3":
				arguDto.inputData("chuga");
				result = guestBookDao.setInsert(arguDto);
				break;
			case "4":
				arguDto.inputNo("sujung");
				dataCheckResult = guestBookDao.dataCheck(arguDto);
				if (dataCheckResult != 0) {
					arguDto.inputData("passwd");
					pwChecker = guestBookDao.checkPasswd(arguDto);
					if (pwChecker) {
						arguDto.inputData("sujung");
						result = guestBookDao.setUpdate(arguDto);
					}//end if
				}//end if
				break;
			case "5":
				arguDto.inputNo("sakje");
				dataCheckResult = guestBookDao.dataCheck(arguDto);
				if (dataCheckResult != 0) {
					arguDto.inputData("passwd");
					pwChecker = guestBookDao.checkPasswd(arguDto);
					if (pwChecker) {
						result = guestBookDao.setDelete(arguDto);
					}//end if
				}//end if
				break;
			default:
				System.out.println("-- 방명록관리 프로그램 종료 --");
				break MENU;
			}//end switch
		}//end while
	}//end main
}//end Example
