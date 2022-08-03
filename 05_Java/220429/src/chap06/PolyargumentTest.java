package chap06;

public class PolyargumentTest {
	public static void main(String[] args) {
		Buyer b = new Buyer();
		b.buy(new Tv());
		b.buy(new Audio());
		b.buy(new Computer());
		b.buy(new Piano());

		System.out.println("현재 잔액: " + b.money);
		System.out.println("현재 포인트: " + b.bonusPoint);
		b.summary();
	}// end main
}// end PolyargumentTest
