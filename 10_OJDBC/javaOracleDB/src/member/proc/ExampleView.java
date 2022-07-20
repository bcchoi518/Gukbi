package member.proc;

import java.util.Scanner;

import member.model.MemberDAO;
import member.model.MemberDTO;

public class ExampleView {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("상세보기할 회원번호를 입력하세요: ");
		int memberNo = Integer.parseInt(sc.nextLine());
		
		MemberDTO memberDto = new MemberDTO();
		memberDto.setMemberNo(memberNo);
		
		MemberDAO dao = new MemberDAO();
		MemberDTO resultDto = dao.getSelectOne(memberDto);
		
		System.out.println("memberNo: " + resultDto.getMemberNo());
		System.out.println("memberId: " + resultDto.getMemberId());
		System.out.println("memberName: " + resultDto.getMemberName());
		System.out.println("memberJumin: " + resultDto.getMemberJumin());
		System.out.println("memberPhone: " + resultDto.getMemberPhone());
		System.out.println("memberEmail: " + resultDto.getMemberEmail());
		System.out.println("memberPhone: " + resultDto.getMemberPhone());
		System.out.println("memberAddress: " + resultDto.getMemberAddress());
		System.out.println("regiDate: " + resultDto.getRegiDate());
	}//end main
}//end ExampleView
