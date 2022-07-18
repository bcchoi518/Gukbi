package sungjuk.proc;

import java.util.Scanner;

import sungjuk.model.SungjukDAO;
import sungjuk.model.SungjukDTO;

public class ExampleSakje {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("삭제할 No를 입력하세요: ");
		int no = Integer.parseInt(sc.nextLine());
		
		SungjukDTO dto = new SungjukDTO();
		dto.setNo(no);
		
		SungjukDAO dao = new SungjukDAO();
		int result = dao.setDelete(dto);
		
		if (result > 0) {
			System.out.println("-- success Delete --");
		} else {
			System.out.println("-- fail Delete --");
		}//end if
	}//end main
}//end ExampleSakje
