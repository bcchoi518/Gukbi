package step01;

import java.io.Serializable;

public class User extends MemberTicket  implements Serializable{
	private String id;
	private String pwd;
	protected String getId() {
		return this.id;
	}
	public void setId(String id) {
		this.id = id;
	}
	protected String getPwd() {
		return this.pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	User(String id, String pwd, String name, String phoneNumber) {
		super(name, phoneNumber);
		this.id = id;
		this.pwd = pwd;
	}
	User() {
	}
	public String toString() {
		return Stringto();		
	}
	public boolean getPwd1(String pwd) {
		 if(this.pwd.equals(pwd)) {
			 return true;
		 }return false;
	}
	public boolean getId1(String id) {
		 if(this.id.equals(id)) {
			 return true;
		 }return false;
	}
	protected void showInfo() {
		System.out.printf(" %s : %s : %s : %s \n", id, pwd, name, phoneNumber);
	}

	@Override
	public int hashCode() {
		return id.hashCode(); // �ּ��� �ؽ��ڵ嵵 ���ؾ��ؼ� �������̵�
	}

	@Override
	public boolean equals(Object obj) { // ���� �ٸ����� ��� �ִ� ��ü���̶� �� ���� ������ Ȯ���ϱ����� �������̵�
		if (obj instanceof User) {
			User tmp = (User) obj;
			return id.equals(tmp.id);
		}
		return false;
	}
	
}
