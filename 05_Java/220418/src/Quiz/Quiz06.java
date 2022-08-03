package Quiz;

import java.util.Scanner;

public class Quiz06 {

	public static void main(String[] args) {

//		사원의 등급에 따라 시간당 급여가 다음과 같이 정의되어 있다.
//		1주일에 40시간이 기본 근무 시간이며, 이를 초과하는 경우 기본 시간당 급여의 1.5배가 지급된다.
//		사원의 등급과 1주일 동안의 근무 시간을 입력받아 주 급여를 출력하는 프로그램을 작성하시오.
//		단, 근무 시간이 40시간에 미달하는 경우에는 40시간으로 처리한다.
//		직급이 7급, 8급인 경우 : 15000/시간
//		직급이 5급, 6급인 경우 : 20000/시간

		final int WORKING_WEEK = 40;
		String rank = "";
		int overTime = 0, workingTotal = 0, salary = 0, hourlyWage = 0;
		double payRate = 0.0;

		Scanner sc = new Scanner(System.in);

		System.out.print("직급 : ");
		rank = sc.nextLine();
		System.out.print("근무 시간 : ");
		workingTotal = Integer.parseInt(sc.nextLine().replace("시간", ""));

		if (workingTotal > WORKING_WEEK) {
			overTime = workingTotal - WORKING_WEEK;
			payRate = 1.5;
		} // end if

		if (rank.equals("5급") || rank.equals("6급")) {
			hourlyWage = 20000;
		} else if (rank.equals("7급") || rank.equals("8급")) {
			hourlyWage = 15000;
		} // end if

		salary = (WORKING_WEEK * hourlyWage) + (int) (overTime * (payRate * hourlyWage));

		System.out.println("주 급여 : " + salary);

		sc.close();
	}// end main

}// end Quiz06
