package sungjuk.proc;

import java.sql.Date;
import java.util.ArrayList;

import sungjuk.model.SungjukDAO;
import sungjuk.model.SungjukDTO;

public class ExampleList {
	public static void main(String[] args) {
		SungjukDAO dao = new SungjukDAO();
		ArrayList<SungjukDTO> list = dao.getSelectAll();
		for (int i = 0; i < list.size(); i++) {
			SungjukDTO resultDto = list.get(i);
			int no = resultDto.getNo();
			String name = resultDto.getName();
			int kor = resultDto.getKor();
			int eng = resultDto.getEng();
			int mat = resultDto.getMat();
			int tot = resultDto.getTot();
			double avg = resultDto.getAvg();
			String grade = resultDto.getGrade();
			Date regiDate = resultDto.getRegiDate();
			
			System.out.println("no: " + no);
			System.out.println("name: " + name);
			System.out.println("kor: " + kor);
			System.out.println("eng: " + eng);
			System.out.println("mat: " + mat);
			System.out.println("tot: " + tot);
			System.out.println("avg: " + avg);
			System.out.println("grade: " + grade);
			System.out.println("regiDate: " + regiDate);
			System.out.println("------------------------------------");
		}//end for
	}//end main
}//end ExampleList
