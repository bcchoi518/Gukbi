package sungjuk.proc;

import java.util.Scanner;

import sungjuk.model.SungjukDAO;
import sungjuk.model.SungjukDTO;

public class ExampleView {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		SungjukDTO sungjukDto = new SungjukDTO();

		System.out.print("상세보기할 No를 입력하세요: ");
		sungjukDto.setNo(Integer.parseInt(sc.nextLine()));
		
		SungjukDAO dao = new SungjukDAO();
		SungjukDTO resultDto = dao.getSelectOne(sungjukDto);
		
		System.out.println("no: " + resultDto.getNo());
		System.out.println("name: " + resultDto.getName());
		System.out.println("kor: " + resultDto.getKor());
		System.out.println("eng: " + resultDto.getEng());
		System.out.println("mat: " + resultDto.getMat());
		System.out.println("tot: " + resultDto.getTot());
		System.out.println("avg: " + resultDto.getAvg());
		System.out.println("grade: " + resultDto.getGrade());
		System.out.println("regiDate: " + resultDto.getRegiDate());
	}//end main
}//end ExampleView
