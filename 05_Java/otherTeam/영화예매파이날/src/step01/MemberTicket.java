package step01;

import java.io.Serializable;

public class MemberTicket extends Consumer implements Serializable {
	String id, seat;
	int movieChoice,movieTimeChoice;
	String reservNum;
	String movieTime;
	
	MemberTicket(String id, int moviechoice, String seat,String reserNum,String movieTime,int movieTimeChoice) {
		this.id = id;
		this.movieChoice = moviechoice;
		this.seat = seat;
		this.reservNum = reserNum;
		this.movieTime = movieTime;
		this.movieTimeChoice = movieTimeChoice;
	}
	MemberTicket(String name, String phoneNumber){
		super(name, phoneNumber);
	}
	public MemberTicket() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public int hashCode() {
		return id.hashCode(); // �ּ��� �ؽ��ڵ嵵 ���ؾ��ؼ� �������̵�
	}

	@Override
	public boolean equals(Object obj) { // ���� �ٸ����� ��� �ִ� ��ü���̶� �� ���� ������ Ȯ���ϱ����� �������̵�
		if (obj instanceof MemberTicket) {
			MemberTicket tmp = (MemberTicket) obj;
			return id.equals(tmp.id);
		}
		return false;
	}
	protected String Stringto() {
		return super.toString();
	}
	public String toString() {
		
		return "��ȭ�� �� " + movieChoice + "�� " + seat + "�� \n"
					+ "���Ź�ȣ : " +reservNum + "\n��ȭ�ð� : "+movieTime;
	}
}
