package member.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import common.DB;

public class MemberDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public ArrayList<MemberDTO> getSelectAll() {
		ArrayList<MemberDTO> list = new ArrayList<>();
		try {
			conn = DB.dbConn();
//			---------------------------------------------------
			String sql = "select memberNo, memberId, memberName, regiDate from member";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				MemberDTO dto = new MemberDTO();
				dto.setMemberNo(rs.getInt("memberNo"));
				dto.setMemberId(rs.getString("memberId"));
				dto.setMemberName(rs.getString("memberName"));
//				dto.setMemberJumin(rs.getString("memberJumin"));
//				dto.setMemberPhone(rs.getString("memberPhone"));
//				dto.setMemberEmail(rs.getString("memberEmail"));
//				dto.setMemberAddress(rs.getString("memberAddress"));
				dto.setRegiDate(rs.getDate("regiDate"));
				
				list.add(dto);
			}//end while
//			---------------------------------------------------
		} catch (Exception e) {
			System.out.println("-- DB 접속 실패 --");
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//end try-catch-finally
		return list;
	}//end getSelectAll
	
	public MemberDTO getSelectOne(MemberDTO paramDto) {
		MemberDTO dto = new MemberDTO();
		try {
			conn = DB.dbConn();
//			---------------------------------------------------
			String sql = "select * from member where memberNo = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, paramDto.getMemberNo());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				dto.setMemberNo(rs.getInt("memberNo"));
				dto.setMemberId(rs.getString("memberId"));
				dto.setMemberName(rs.getString("memberName"));
				dto.setMemberJumin(rs.getString("memberJumin"));
				dto.setMemberPhone(rs.getString("memberPhone"));
				dto.setMemberEmail(rs.getString("memberEmail"));
				dto.setMemberAddress(rs.getString("memberAddress"));
				dto.setRegiDate(rs.getDate("regiDate"));
			}//end if
//			---------------------------------------------------
		} catch (Exception e) {
			System.out.println("-- DB 접속 실패 --");
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//end try-catch-finally
		return dto;
	}//end getSelectOne
	
	public int setInsert(MemberDTO paramDto) {
		int result = 0;
		try {
			conn = DB.dbConn();
			//-------------------------------------------
			// 여기서는 ; 찍으면 안됨
			String sql = "insert into member values (seq_member.nextval, ?, ?, ?, ?, ?, ?, ?, sysdate)";
			pstmt = conn.prepareStatement(sql);
			// ? 자리의 값을 채움
			pstmt.setString(1, paramDto.getMemberId());
			pstmt.setString(2, paramDto.getMemberPasswd());
			pstmt.setString(3, paramDto.getMemberName());
			pstmt.setString(4, paramDto.getMemberJumin());
			pstmt.setString(5, paramDto.getMemberPhone());
			pstmt.setString(6, paramDto.getMemberEmail());
			pstmt.setString(7, paramDto.getMemberAddress());
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
	
	public int setUpdate(MemberDTO paramDto) {
		int result = 0;
		try {
			conn = DB.dbConn();
//			-------------------------------------
			String sql = "update member set memberId = ?, memberName = ? where memberNo = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, paramDto.getMemberId());
			pstmt.setString(2, paramDto.getMemberName());
			pstmt.setInt(3, paramDto.getMemberNo());
			result = pstmt.executeUpdate();
//			-------------------------------------
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//end try-catch-finally
		return result;
	}//end setUpdate
	
	public int setDelete(MemberDTO paramDto) {
		int result = 0;
		try {
			conn = DB.dbConn();
//			-------------------------------------
			String sql = "delete from member where memberNo = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, paramDto.getMemberNo());
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
