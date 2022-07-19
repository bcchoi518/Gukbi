package sungjuk.proc;

import java.util.Scanner;

import sungjuk.model.SungjukDAO;
import sungjuk.model.SungjukDTO;

public class ExampleSujung2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		SungjukDTO dto = new SungjukDTO();
		
		System.out.print("수정할 No를 입력하세요: ");
		dto.setNo(Integer.parseInt(sc.nextLine()));
		System.out.print("새로운 국어점수를 입력하세요: ");
		dto.setKor(Integer.parseInt(sc.nextLine()));
		System.out.print("새로운 영어점수를 입력하세요: ");
		dto.setEng(Integer.parseInt(sc.nextLine()));
		System.out.print("새로운 수학점수를 입력하세요: ");
		dto.setMat(Integer.parseInt(sc.nextLine()));
		dto.calc();
		
		SungjukDAO dao = new SungjukDAO();
		int result = dao.setUpdate(dto);
		
		if (result > 0) {
			System.out.println("-- success Update !! --");
		} else {
			System.out.println("-- fail Update !! --");
		}//end if
	}//end main
}//end ExampleUpdate
