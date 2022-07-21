package member.proc;

import java.util.ArrayList;
import java.util.Scanner;

import member.model.MemberDAO;
import member.model.MemberDTO;

public class MemberExample {
	public void memberExec() {
		Scanner scanner = new Scanner(System.in);
		MemberDTO arguDto = new MemberDTO();
		MemberDTO resultDto = new MemberDTO();
		MemberDAO memberDao = new MemberDAO();
		int result = 0;
		
		MENU:
		while (true) {
			System.out.print("회원관리메뉴선택(0:종료, 1:목록, 2:상세, 3:추가, 4:수정, 5:삭제) : ");
			String choice = scanner.nextLine();
			
			switch(choice) {
				case "1":
					ArrayList<MemberDTO> list = memberDao.getSelectAll();
					System.out.println("─── List ─────────────────────────────────────────────────────────────────────────");
					for (int i = 0; i < list.size(); i++) {
						resultDto = list.get(i);
						resultDto.display("list");
					}//end for
					System.out.println("──────────────────────────────────────────────────────────────────────────────────");
					break;
				case "2":
					arguDto.input("view");
					resultDto = memberDao.getSelectOne(arguDto);
					if (resultDto.getRegiDate() != null) {
						System.out.println("─── View ─────────────────────────────────────────────────────────────────────────");
						resultDto.display("view");
						System.out.println("──────────────────────────────────────────────────────────────────────────────────");
					}//end if
					break;
				case "3":
					arguDto.input("chuga");
					result = memberDao.setInsert(arguDto);
					break;
				case "4":
					arguDto.input("sujung");
					result = memberDao.setUpdate(arguDto);
					break;
				case "5":
					arguDto.input("sakje");
					result = memberDao.setDelete(arguDto);
					break;
				default:
					System.out.println("-- 회원관리 프로그램 종료 --");
					break MENU;
			}//end switch
		}//end while
	}//end main
}//end Example
