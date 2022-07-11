package exam01;

public class Ex05 {
	public static void main(String[] args) {
//		연산자 : 대입, 산술, 비교, 논리
		int value1 = 23;
		String result = "홀수";
		if (value1 % 2 == 0) {
			result = "짝수";
		}
		System.out.println(value1 + " : " + result);

		int k = 4;
		String msg = (k == 3 || k == 1) ? "남자" : "여자";
		System.out.println(msg);
	}
}
