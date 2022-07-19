package sungjuk.proc;

import java.util.Scanner;

import sungjuk.model.SungjukDAO;
import sungjuk.model.SungjukDTO;

public class ExampleSakje {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		SungjukDTO dto = new SungjukDTO();
		
		System.out.print("삭제할 No를 입력하세요: ");
		dto.setNo(Integer.parseInt(sc.nextLine()));
		
		SungjukDAO dao = new SungjukDAO();
		int result = dao.setDelete(dto);
		
		if (result > 0) {
			System.out.println("-- success Delete --");
		} else {
			System.out.println("-- fail Delete --");
		}//end if
	}//end main
}//end ExampleSakje
