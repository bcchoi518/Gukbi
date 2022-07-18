package member.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import common.DB;

public class MemberDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public void getSelectAll() {
		try {
			conn = DB.dbConn();
//			---------------------------------------------------
			String sql = "select memberNo, memberId, memberName, regiDate from member";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			int k = 0;
			while (rs.next()) {
				int memberNo = rs.getInt("memberNo");
				String memberId = rs.getString("memberId");
				String memberName = rs.getString("memberName");
//				String memberJumin = rs.getString("memberJumin");
//				String memberPhone = rs.getString("memberPhone");
//				String memberEmail = rs.getString("memberEmail");
//				String memberAddress = rs.getString("memberAddress");
				Date regiDate = rs.getDate("regiDate");
				
				String imsi = "";
				imsi += memberNo + " / ";
				imsi += memberId + " / ";
				imsi += memberName + " / ";
//				imsi += memberJumin + " / ";
//				imsi += memberPhone + " / ";
//				imsi += memberEmail + " / ";
//				imsi += memberAddress + " / ";
				imsi += regiDate;
				
				System.out.println(++k + ". " + imsi);
			}//end while
//			---------------------------------------------------
		} catch (Exception e) {
			System.out.println("-- DB 접속 실패 --");
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//end try-catch-finally
	}//end getSelectAll
	
	public void getSelectOne(MemberDTO dto) {
		try {
			conn = DB.dbConn();
//			---------------------------------------------------
			String sql = "select * from member where memberNo = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getMemberNo());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				int memberNo = rs.getInt("memberNo");
				String memberId = rs.getString("memberId");
				String memberName = rs.getString("memberName");
				String memberJumin = rs.getString("memberJumin");
				String memberPhone = rs.getString("memberPhone");
				String memberEmail = rs.getString("memberEmail");
				String memberAddress = rs.getString("memberAddress");
				Date regiDate = rs.getDate("regiDate");
				
				String imsi = "";
				imsi += memberNo + " / ";
				imsi += memberId + " / ";
				imsi += memberName + " / ";
				imsi += memberJumin + " / ";
				imsi += memberPhone + " / ";
				imsi += memberEmail + " / ";
				imsi += memberAddress + " / ";
				imsi += regiDate;
				
				System.out.println(imsi);
			}//end if
//			---------------------------------------------------
		} catch (Exception e) {
			System.out.println("-- DB 접속 실패 --");
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//end try-catch-finally
	}//end getSelectOne
	
	public int setInsert(MemberDTO dto) {
		int result = 0;
		try {
			conn = DB.dbConn();
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
			result = pstmt.executeUpdate(); // 결과를 반환(결과값 개수가 추가되었다!)
			//-------------------------------------------
		} catch (Exception e) {
//			e.printStackTrace();
			System.out.println("-- DB 접속 실패 --");
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//end try-catch-finally
		return result;
	}//end setInsert
	
	public int setUpdate(MemberDTO dto) {
		int result = 0;
		try {
			conn = DB.dbConn();
//			-------------------------------------
			String sql = "update member set memberId = ?, memberName = ? where memberNo = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getMemberId());
			pstmt.setString(2, dto.getMemberName());
			pstmt.setInt(3, dto.getMemberNo());
			result = pstmt.executeUpdate();
//			-------------------------------------
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//end try-catch-finally
		return result;
	}//end setUpdate
	
	public int setDelete(MemberDTO dto) {
		int result = 0;
		try {
			conn = DB.dbConn();
//			-------------------------------------
			String sql = "delete from member where memberNo = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getMemberNo());
			result = pstmt.executeUpdate();
//			-------------------------------------
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//end try-catch-finally
		return result;
	}//end setDelete
}//end MemberDAO
