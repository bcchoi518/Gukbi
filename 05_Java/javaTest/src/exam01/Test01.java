package exam01;

public class Test01 {
	public static void main(String[] args) {
		/*
		 * // 입력 // 출력 // 출력문 - 화면상 // 표준입력(키보드) / 표준출력(모니터)
		 * System.out.println("안녕하세요?"); System.out.println("안녕하세요?");
		 * System.out.print("안녕하세요?"); System.out.print("안녕하세요?");
		 * 
		 * System.out.println();
		 * 
		 * System.out.printf("%s %d%n", "홍길동", 19); System.out.printf("%s님은 %d세 입니다.%n",
		 * "홍길동", 19);
		 * 
		 * System.out.println();
		 * 
		 * // 리터럴 == 값 자체.. // 상수, 변수 == 그릇.. // 변수는 항상 선언부터 먼저하고, 값을 집어넣는다.
		 * 
		 * int a; // 선언 a = 5; // 값을 집어넣는다. --> 초기화..
		 * 
		 * int b = 5; // 선언 및 초기화.
		 * 
		 * String name = "홍길동"; name = "이성순"; name = "장천용";
		 * 
		 * System.out.println(name); System.out.printf("%s%n", name);
		 * 
		 * System.out.println("당신의 이름은 " + name + " 입니다.");// 문자열 + 문자열 ==> 나열, 결합..
		 * System.out.printf("당신의 이름은 %s 입니다.%n", name); System.out.println("당신의 이름은 " +
		 * name + " 입니다.");
		 * 
		 * String msg = "당신의 이름은 " + name + "입니다."; System.out.println(msg);
		 * 
		 * name = "이상대"; System.out.println(msg);
		 * 
		 * msg = ""; msg = msg + "당신의 이름은 "; msg = msg + name; msg = msg + "입니다.";
		 * System.out.println(msg);
		 */

		String name1 = "홍길동";
		int kor1 = 90;
		int eng1 = 90;
		int math1 = 90;
		int sci1 = 90;
		int his1 = 90;
		int total1 = kor1 + eng1 + math1 + sci1 + his1;
		int avg1 = total1 / 5;
		String student1 = name1 + "\t" + kor1 + "\t" + eng1 + "\t" + math1 + "\t" + sci1 + "\t" + his1 + "\t" + total1
				+ "\t" + avg1;

		String student2 = "";
		String name2 = "이성순";
		student2 += name2;
		int kor2 = 80;
		student2 += "\t" + kor2;
		int eng2 = 80;
		student2 += "\t" + eng2;
		int math2 = 80;
		student2 += "\t" + math2;
		int sci2 = 80;
		student2 += "\t" + sci2;
		int his2 = 80;
		student2 += "\t" + his2;
		int total2 = kor2 + eng2 + math2 + sci2 + his2;
		student2 += "\t" + total2;
		int avg2 = total2 / 5;
		student2 += "\t" + avg2;

		System.out.println("--------------------------------------------------------------");
		System.out.println("이름\t국어\t영어\t수학\t과학\t역사\t총점\t평균");
		System.out.println("--------------------------------------------------------------");
		System.out.println(student1);
		System.out.println(student2);
		System.out.println("--------------------------------------------------------------");
	}// end main
}// end Test01
