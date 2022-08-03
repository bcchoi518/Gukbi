/*
 * 시험일: 2022-05-16
 * 응시자: 최병철
 * 문제: 문항5-2번
 * encoding: UTF-8 
*/
package exam02;

public class PersonTest {
	public static void main(String[] args) {
		Person p = new Person();
		Customer c = new Customer();

		p.setName("김자바");
		p.setPhoneNumber("010-0101-0101");
		System.out.println(p.toString());

		c.setName("최자바");
		c.setPhoneNumber("010-0202-0202");
		c.setCustomerNumber(1);
		c.setMileage(100);
		System.out.println(c.toString());
	}// end main
}// end PersonTest
