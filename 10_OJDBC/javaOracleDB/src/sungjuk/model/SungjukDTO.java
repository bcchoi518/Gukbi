package sungjuk.model;

import java.sql.Date;
import java.util.Scanner;

public class SungjukDTO {
	private int no;
	private String name;
	private int kor;
	private int eng;
	private int mat;
	private int tot;
	private double avg;
	private String grade;
	private Date regiDate;
	
	public void input(String gubun) {
		Scanner scanner = new Scanner(System.in);
		if (gubun.equals("view") || gubun.equals("sujung") || gubun.equals("sakje")) {
			String imsi = "상세보기";
			if (gubun.equals("sujung")) {
				imsi = "수정";
			} else if (gubun.equals("sakje")) {
				imsi = "삭제";
			}//end if
			System.out.print(imsi + "할 No: ");
			no = Integer.parseInt(scanner.nextLine());
			
			SungjukDAO sungjukDao = new SungjukDAO();
			int result = sungjukDao.dataCheck(no);
			if (result == 0) {
				System.out.println("─── Info ─────────────────────────────────────────────────────────────────────────");
				System.out.println("데이터가 없습니다.");
				System.out.println("──────────────────────────────────────────────────────────────────────────────────");
				return;
			}//end if
		}//end if
		if (gubun.equals("chuga") || gubun.equals("sujung")) {
			if (gubun.equals("chuga")) {
				System.out.print("이름: ");
				name = scanner.nextLine();
			}//end if
			System.out.print("국어: ");
			kor = Integer.parseInt(scanner.nextLine());
			System.out.print("영어: ");
			eng = Integer.parseInt(scanner.nextLine());
			System.out.print("수학: ");
			mat = Integer.parseInt(scanner.nextLine());
		}//end if
	}//end input
	
	public void tot() {
		tot = kor + eng + mat;
	}//end tot
	
	public void avg() {
		avg = tot / 3.0;
	}//end avg
	
	public void grade() {
		grade = "가";
		if (avg >= 90) {
			grade = "수";
		} else if (avg >= 80) {
			grade = "우";
		} else if (avg >= 70) {
			grade = "미";
		} else if (avg >= 60) {
			grade = "양";
		}//end if
	}//end grade

	public void display() {
		String msg = "";
		
		msg += no + "\t";
		msg += name + "\t";
		msg += kor + "\t";
		msg += eng + "\t";
		msg += mat + "\t";
		msg += tot + "\t";
		msg += avg + "\t";
		msg += grade + "\t";
		msg += regiDate;
		
		System.out.println(msg);
	}//end display
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMat() {
		return mat;
	}
	public void setMat(int mat) {
		this.mat = mat;
	}
	public int getTot() {
		return tot;
	}
	public void setTot(int tot) {
		this.tot = tot;
	}
	public double getAvg() {
		return avg;
	}
	public void setAvg(double avg) {
		this.avg = avg;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public Date getRegiDate() {
		return regiDate;
	}
	public void setRegiDate(Date regiDate) {
		this.regiDate = regiDate;
	}
}//end SungjukDTO
