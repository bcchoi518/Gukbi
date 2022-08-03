package exam01;

import java.util.Scanner;

public class Test05 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] sungjukArray = new String[3];

		for (int i = 0; i < 3; i++) {
			System.out.print("이름을 입력하세요. : ");
			String name = sc.nextLine();

			System.out.print("국어 성적을 입력하세요. : ");
			int kor = Integer.parseInt(sc.nextLine());

			System.out.print("영어 성적을 입력하세요. : ");
			int eng = Integer.parseInt(sc.nextLine());

			System.out.print("수학 성적을 입력하세요. : ");
			int math = Integer.parseInt(sc.nextLine());

			String imsi = name + "|" + kor + "|" + eng + "|" + math;
			sungjukArray[i] = imsi;
		} // end for

		for (int i = 0; i < sungjukArray.length; i++) {
			String imsi = sungjukArray[i];
//			|로 스플릿 할때는 []로 감싸줘야 함
			String[] imsiArr = imsi.split("[|]");
			String name = imsiArr[0];
			int kor = Integer.parseInt(imsiArr[1]);
			int eng = Integer.parseInt(imsiArr[2]);
			int math = Integer.parseInt(imsiArr[3]);
			int total = kor + eng + math;
			sungjukArray[i] = name + "|" + kor + "|" + eng + "|" + math + "|" + total;
		}

		for (int i = 0; i < sungjukArray.length; i++) {
			System.out.println(sungjukArray[i]);
		}
	}
}
