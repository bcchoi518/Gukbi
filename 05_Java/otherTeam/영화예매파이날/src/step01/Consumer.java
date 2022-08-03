package step01;

import java.io.Serializable;

public class Consumer implements Serializable {
  String name;
  String phoneNumber;
  
  Consumer(String name, String phoneNumber) {
    this.name = name;
    this.phoneNumber = phoneNumber;
  }
  
  Consumer(String name) {
    this.name = name;
  }
  
  Consumer() {}
  @Override
	public int hashCode() {
		return phoneNumber.hashCode(); // 주소의 해쉬코드도 비교해야해서 오버라이드
	}

	@Override
	public boolean equals(Object obj) { // 각기 다른곳에 담겨 있는 객체들이라 그 값이 같은지 확인하기위한 오버라이드
		if (obj instanceof Consumer) {
			Consumer tmp = (Consumer) obj;
			return phoneNumber.equals(tmp.phoneNumber);
		}
		return false;
	}
	public String toString() {
		return "[ 이름 : " + name + " 핸드폰 번호 : " + phoneNumber.substring(0, 3) + 
														"****" + phoneNumber.substring(7, 11)+ "\n"; 
	}
	
}
