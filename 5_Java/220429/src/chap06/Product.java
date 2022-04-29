package chap06;

public abstract class Product {	// Product클래스를 생성하지 못하게 하기 위해 추상클래스로 만듬
	int price;
	int bonusPoint;
	
	Product(int price) {
		this.price = price;
		bonusPoint = (int)(price / 10.0);
	}

	@Override
	public String toString() {
		return "Tv";
	}//end toString
	
}//end Product
