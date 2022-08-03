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
		return phoneNumber.hashCode(); // �ּ��� �ؽ��ڵ嵵 ���ؾ��ؼ� �������̵�
	}

	@Override
	public boolean equals(Object obj) { // ���� �ٸ����� ��� �ִ� ��ü���̶� �� ���� ������ Ȯ���ϱ����� �������̵�
		if (obj instanceof Consumer) {
			Consumer tmp = (Consumer) obj;
			return phoneNumber.equals(tmp.phoneNumber);
		}
		return false;
	}
	public String toString() {
		return "[ �̸� : " + name + " �ڵ��� ��ȣ : " + phoneNumber.substring(0, 3) + 
														"****" + phoneNumber.substring(7, 11)+ "\n"; 
	}
	
}
