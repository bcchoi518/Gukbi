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
		SungjukDTO dto = dao.getSelectOne(sungjukDto);
		
		System.out.println("productCode: " + dto.getNo());
		System.out.println("productName: " + dto.getName());
		System.out.println("productPrice: " + dto.getKor());
		System.out.println("productContent: " + dto.getEng());
		System.out.println("vender: " + dto.getMat());
		System.out.println("vender: " + dto.getTot());
		System.out.println("vender: " + dto.getAvg());
		System.out.println("vender: " + dto.getGrade());
		System.out.println("regiDate: " + dto.getRegiDate());
	}//end main
}//end ExampleView
