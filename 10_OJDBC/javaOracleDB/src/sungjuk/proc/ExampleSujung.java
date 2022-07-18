package sungjuk.proc;

import java.util.Scanner;

import sungjuk.model.SungjukDAO;
import sungjuk.model.SungjukDTO;

public class ExampleSujung {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("수정할 No를 입력하세요: ");
		int no = Integer.parseInt(sc.nextLine());
		System.out.print("새로운 국어점수를 입력하세요: ");
		int kor = Integer.parseInt(sc.nextLine());
		System.out.print("새로운 영어점수를 입력하세요: ");
		int eng = Integer.parseInt(sc.nextLine());
		System.out.print("새로운 수학점수를 입력하세요: ");
		int mat = Integer.parseInt(sc.nextLine());
		
		int tot = kor + eng + mat;
		double avg = tot / 3.0;
		
		String grade = "가";
		if (avg >= 90) {
			grade = "수";
		} else if (avg >= 80) {
			grade = "우";
		} else if (avg >= 70) {
			grade = "미";
		} else if (avg >= 60) {
			grade = "양";
		}//end if
		
		SungjukDTO dto = new SungjukDTO();
		dto.setNo(no);
		dto.setKor(kor);
		dto.setEng(eng);
		dto.setMat(mat);
		dto.setTot(tot);
		dto.setAvg(avg);
		dto.setGrade(grade);
		
		SungjukDAO dao = new SungjukDAO();
		int result = dao.setUpdate(dto);
		
		if (result > 0) {
			System.out.println("-- success Update !! --");
		} else {
			System.out.println("-- fail Update !! --");
		}//end if
		
	}//end main
}//end ExampleUpdate
