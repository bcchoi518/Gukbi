package sungjuk.proc;

import java.util.Scanner;

import sungjuk.model.SungjukDAO;
import sungjuk.model.SungjukDTO;

public class ExampleChuga2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		SungjukDTO dto = new SungjukDTO();
		
		System.out.print("이름을 입력하세요: ");
		dto.setName(sc.nextLine());
		System.out.print("국어점수를 입력하세요: ");
		dto.setKor(Integer.parseInt(sc.nextLine()));
		System.out.print("영어점수를 입력하세요: ");
		dto.setEng(Integer.parseInt(sc.nextLine()));
		System.out.print("수학점수를 입력하세요: ");
		dto.setMat(Integer.parseInt(sc.nextLine()));
		dto.calc();
		
		SungjukDAO dao = new SungjukDAO();
		int result = dao.setInsert04(dto);
		
		if (result > 0) {
			System.out.println("-- success insert !! --");
		} else {
			System.out.println("-- fail insert !! --");
		}//end if
	}//end main
}//end ExampleChuga
