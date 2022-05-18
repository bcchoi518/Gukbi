package chap02;

public class FruitBoxEx1 {
	public static void main(String[] args) {
		Box<Fruit> fruitBox = new Box<Fruit>();
		Box<Apple> appleBox = new Box<Apple>();
		Box<Toy> toyBox = new Box<Toy>();
//		Box<Grape> grapeBox = new Box<Apple>();	// 타입이 항상 일치해야한다
		Box<Grape> grapeBox = new Box<>(); // 뒤에는 생략이 가능하다
		FruitBox<Fruit> fb = new FruitBox<Fruit>();
//		FruitBox<Toy> fb2 = new FruitBox<Toy>();

		fruitBox.add(new Fruit());
		fruitBox.add(new Apple());
		fruitBox.add(new Grape());

		appleBox.add(new Apple());
		appleBox.add(new Apple());
//		appleBox.add(new Toy());	// Apple타입이 아니라서 탈락

		toyBox.add(new Toy());
//		toyBox.add(new Apple());	//	Toy타입이 아니라서 탈락

		System.out.println(fruitBox);
		System.out.println(appleBox);
		System.out.println(toyBox);
	}// end main
}// end FruitBoxEx1
