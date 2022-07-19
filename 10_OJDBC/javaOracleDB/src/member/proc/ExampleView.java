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
		MemberDTO dto = dao.getSelectOne(memberDto);
		
		System.out.println("memberNo: " + dto.getMemberNo());
		System.out.println("memberId: " + dto.getMemberId());
		System.out.println("memberName: " + dto.getMemberName());
		System.out.println("memberJumin: " + dto.getMemberJumin());
		System.out.println("memberPhone: " + dto.getMemberPhone());
		System.out.println("memberEmail: " + dto.getMemberEmail());
		System.out.println("memberPhone: " + dto.getMemberPhone());
		System.out.println("memberAddress: " + dto.getMemberAddress());
		System.out.println("regiDate: " + dto.getRegiDate());
	}//end main
}//end ExampleView
