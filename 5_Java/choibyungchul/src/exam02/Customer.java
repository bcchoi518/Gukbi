/*
 * 시험일: 2022-05-16
 * 응시자: 최병철
 * 문제: 문항5-2번
 * encoding: UTF-8 
*/
package exam02;

public class Customer extends Person {
	private int customerNumber;
	private int mileage;

	Customer() {
		this("자식클래스", "010-3333-4444", 1, 0);
	}

	Customer(String name, String phoneNumber, int customerNumber, int mileage) {
		super(name, phoneNumber);
		this.customerNumber = customerNumber;
		this.mileage = mileage;
	}

	public int getCustomerNumber() {
		return customerNumber;
	}// end getCustomerNumber

	public void setCustomerNumber(int customerNumber) {
		this.customerNumber = customerNumber;
	}// end setCustomerNumber

	public int getMileage() {
		return mileage;
	}// end getMileage

	public void setMileage(int mileage) {
		this.mileage = mileage;
	}// end setMileage

	@Override
	public String toString() {
		return super.toString() + ", 고객번호: " + customerNumber + ", 마일리지: " + mileage;
	}// end toString
}// end Customer
