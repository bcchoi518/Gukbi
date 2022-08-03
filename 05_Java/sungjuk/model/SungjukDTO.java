package sungjuk.model;

import java.util.Scanner;

public class SungjukDTO {
	private String name;
	private int kor;
	private int eng;
	private int math;
	private int total;
	private double avg;
	private String grade;
	
	public void inputData() {
		Scanner sc = new Scanner(System.in);
		System.out.print("이름: ");
		String name = sc.nextLine();
		System.out.print("국어: ");
		String kor_ = sc.nextLine();
		System.out.print("영어: ");
		String eng_ = sc.nextLine();
		System.out.print("수학: ");
		String math_ = sc.nextLine();
		
		int kor = Integer.parseInt(kor_);
		int eng = Integer.parseInt(eng_);
		int math = Integer.parseInt(math_);
		
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}//end inputData
	public void sumTotal() {
		total = kor + eng + math;
	}//end sumTotal
	public void display() {
		System.out.println(name + "\t" + kor + "\t" + eng + "\t" + math + "\t" + total);
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
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
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
	@Override
	public String toString() {
		return "SungjukDTO [name=" + name + ", kor=" + kor + ", eng=" + eng + ", math=" + math + ", total=" + total
				+ "]";
	}
	
}
