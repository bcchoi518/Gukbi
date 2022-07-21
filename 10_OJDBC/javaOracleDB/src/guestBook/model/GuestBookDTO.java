package guestBook.model;

import java.sql.Date;
import java.util.Scanner;

public class GuestBookDTO {
	private int no;
	private String writer;
	private String subject;
	private String content;
	private String passwd;
	private Date regiDate;
	
	public int inputNo(String gubun) {
		Scanner scanner = new Scanner(System.in);
		String imsi = "상세조회";
		if (gubun.equals("sujung")) {
			imsi = "수정";
		} else if (gubun.equals("sakje")) {
			imsi = "삭제";
		}//end if
		System.out.print(imsi + "할 No: ");
		no = Integer.parseInt(scanner.nextLine());
		return no;
	}//end inputNo
	
	public void inputData(String gubun) {
		Scanner scanner = new Scanner(System.in);
		if (gubun.equals("chuga")) {
			System.out.print("작성자: ");
			writer = scanner.nextLine();
		}//end if
		if (gubun.equals("chuga") || gubun.equals("passwd")) {
			System.out.print("비밀번호: ");
			passwd = scanner.nextLine();
		}//end if
		if (gubun.equals("chuga") || gubun.equals("sujung")) {
			System.out.print("제목: ");
			subject = scanner.nextLine();
			System.out.print("내용: ");
			content = scanner.nextLine();
		}//end if
	}//end inputData
	
	public void display(String gubun) {
		if (gubun.equals("list")) {
			String msg = "";
			msg += no + "\t";
			msg += writer + "\t";
			msg += subject + "\t";
			msg += regiDate + "\t";
			System.out.println(msg);
		}//end if
		if (gubun.equals("view")) {
			System.out.println("순번: " + no);
			System.out.println("작성자: " + writer);
			System.out.println("제목: " + subject);
			System.out.println("내용: " + content);
			System.out.println("작성일: " + regiDate);
		}//end if
	}//end display
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public Date getRegiDate() {
		return regiDate;
	}
	public void setRegiDate(Date regiDate) {
		this.regiDate = regiDate;
	}
}//end GuestBookDTO