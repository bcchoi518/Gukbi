package chap07;

public class Car {
	String color;
	String gearType;
	int door;

	Car() {
		this("red", "auto", 3);
	}

	Car(String color) {
		this(color, "auto", 5);
	}

	Car(String color, String gearType, int door) {
		this.color = color;
		this.gearType = gearType;
		this.door = door;
	}

}// end Car
