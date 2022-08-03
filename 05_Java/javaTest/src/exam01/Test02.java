package exam01;

import java.util.Scanner;

public class Test02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String name;
		String jumin;
		String address;

		System.out.print("이름을 입력하세요: ");
		name = sc.nextLine();
		System.out.print("주민번호를 입력하세요(123456-1234567): ");
		jumin = sc.nextLine().trim();

		// 소거법 : 정상적인 값을 제거해서 비정상적인 값의 여부 확인
		String tmp = jumin;
		tmp = tmp.replace("0", "");
		tmp = tmp.replace("1", "");
		tmp = tmp.replace("2", "");
		tmp = tmp.replace("3", "");
		tmp = tmp.replace("4", "");
		tmp = tmp.replace("5", "");
		tmp = tmp.replace("6", "");
		tmp = tmp.replace("7", "");
		tmp = tmp.replace("8", "");
		tmp = tmp.replace("9", "");

		int errorCounter = 0;
		if (jumin.length() == 0) {
			errorCounter++;
		} else if (jumin.length() != 14 || jumin.indexOf("-") == -1) {
			errorCounter++;
		} else if (jumin.indexOf("-") != 6 && jumin.lastIndexOf("-") != 6) {
			errorCounter++;
		} else if (!tmp.equals("-")) {
			errorCounter++;
		} // end if

		if (errorCounter > 0) {
			String errMsg = "[Error] 정확한 주민번호를 입력하세요.";
			System.out.println(errMsg);
			System.out.println("-- 프로그램 종료 --");
			return;
		} // end if

		System.out.print("주소를 입력하세요: ");
		address = sc.nextLine();

		int intTmp = Integer.parseInt(jumin.substring(7, 8));
		String gender = "여자";
		if (intTmp == 1 || intTmp == 3) {
			gender = "남자";
		}

		int year = Integer.parseInt(jumin.substring(0, 2));
		if (intTmp == 1 || intTmp == 2) {
			year += 1900;
		} else {
			year += 2000;
		}

		int age = 2022 - year;

		System.out.println("당신의 이름은 " + name + "입니다.");
		System.out.println("당신의 나이는 " + age + "세입니다.");
		System.out.println("당신의 성별은 " + gender + "입니다.");
		System.out.println("당신의 주소는 " + address + "입니다.");
	}
}
