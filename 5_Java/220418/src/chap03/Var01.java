package chap03;

public class Var01 {

	public static void main(String[] args) {
		//변수선언
		int kor = 50, eng = 80, math = 30, sum = 0;
		double average = 0;
		String name = "최병철";

		//처리
		sum = kor + eng + math;
		average = sum / 3.0;

		//출력
		System.out.println("이름: " + name);
		System.out.println("총점: " + sum);
		System.out.println("평균: " + average);

	}
}
