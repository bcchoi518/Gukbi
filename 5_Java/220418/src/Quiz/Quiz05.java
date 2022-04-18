package Quiz;

import java.util.Scanner;

public class Quiz05 {

	public static void main(String[] args) {

//		마트에서 구입한 물건값과 구입 시간을 입력받아 실제 지불한 금액을 출력하는 프로그램을
//		작성하시오. 마트는 시간대별로 할인율을 다르게 적용한다.
//		오전 12시 이전 : 구입 금액의 5% 할인
//		오전 12시 이후(12시 포함) : 구입 금액의 2.5% 할인

		String purchaseTime = "";
		int purchasePrice = 0;
		int tmp = 0;
		double discountRate = 0.0;

		Scanner sc = new Scanner(System.in);

		System.out.print("구입 시간 : ");
		purchaseTime = sc.nextLine();
		System.out.print("총 구입금액 : ");
		purchasePrice = Integer.parseInt(sc.nextLine());

		tmp = Integer.parseInt(purchaseTime.replace("시", ""));
		
		if (tmp < 12) {
			discountRate = 5.0;
		} else {
			discountRate = 2.5;
		}

		purchasePrice -= (purchasePrice / 100 * discountRate);

		System.out.println("실제 지불 금액 : " + purchasePrice);

		sc.close();
	}

}
