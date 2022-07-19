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
			SungjukDTO dto = list.get(i);
			int no = dto.getNo();
			String name = dto.getName();
			int kor = dto.getKor();
			int eng = dto.getEng();
			int mat = dto.getMat();
			int tot = dto.getTot();
			double avg = dto.getAvg();
			String grade = dto.getGrade();
			Date regiDate = dto.getRegiDate();
			
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
