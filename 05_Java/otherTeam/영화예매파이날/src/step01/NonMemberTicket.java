package step01;

import java.io.Serializable;

public class NonMemberTicket extends Consumer implements Serializable{
	String seat;
	int movieChoice,movieTimeChoice;
	String reservNum;
	String movieTime;
	NonMemberTicket(String name,String tel,int moviechoice,String seat,String reserNum,String movieTime,int movieTimeChoice){
		super.name = name;
		super.phoneNumber = tel;
		this.movieChoice = moviechoice;
		this.seat = seat;
		this.reservNum = reserNum;
		this.movieTime = movieTime;
		this.movieTimeChoice = movieTimeChoice;
	}
	NonMemberTicket() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public int hashCode() {
		return phoneNumber.hashCode(); // �ּ��� �ؽ��ڵ嵵 ���ؾ��ؼ� �������̵�
	}

	@Override
	public boolean equals(Object obj) { // ���� �ٸ����� ��� �ִ� ��ü���̶� �� ���� ������ Ȯ���ϱ����� �������̵�
		if (obj instanceof NonMemberTicket) {
			NonMemberTicket tmp = (NonMemberTicket) obj;
			return phoneNumber.equals(tmp.phoneNumber);
		}
		return false;
	}
	public String toString() {
		return "��ȭ�� �� " + movieChoice + "�� " + seat + "�� " + "���Ź�ȣ : " +reservNum+ "\n"; 
	}
}
