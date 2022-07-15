package member.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MemberDAO {
	public void setInsert(MemberDTO dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			// Driver 파일
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "javaOracle", "1234");
			System.out.println("-- DB 접속 성공 --");
			//-------------------------------------------
			// 여기서는 ; 찍으면 안됨
			String sql = "insert into member values (seq_member.nextval, ?, ?, ?, ?, ?, ?, ?, sysdate)";
			pstmt = conn.prepareStatement(sql);
			// ? 자리의 값을 채움
			pstmt.setString(1, dto.getMemberId());
			pstmt.setString(2, dto.getMemberPasswd());
			pstmt.setString(3, dto.getMemberName());
			pstmt.setString(4, dto.getMemberJumin());
			pstmt.setString(5, dto.getMemberPhone());
			pstmt.setString(6, dto.getMemberEmail());
			pstmt.setString(7, dto.getMemberAddress());
			pstmt.executeUpdate();
			//-------------------------------------------
		} catch (Exception e) {
//			e.printStackTrace();
			System.out.println("-- DB 접속 실패 --");
		} 
		
		try {
//			rs.close();
			pstmt.close();
			conn.close();
			System.out.println("-- DB 접속 끊기 성공 --");
		} catch (Exception e) {
//			e.printStackTrace();
			System.out.println("-- DB 접속 끊기 실패 --");
		}
	}//end setInsert
}//end MemberDAO
