package project.member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import project.common.DB;
import project.member.model.dto.MemberDTO;

public class MemberDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public ArrayList<MemberDTO> getSelectAll() {
		ArrayList<MemberDTO> memberList = new ArrayList<>();
		conn = DB.dbConn();
		try {
			String sql = "SELECT * FROM member ORDER BY no DESC";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				MemberDTO memberDto = new MemberDTO();
				memberDto.setNo(rs.getInt("no"));
				memberDto.setId(rs.getString("id"));
				memberDto.setPasswd(rs.getString("passwd"));
				memberDto.setName(rs.getString("name"));
				memberDto.setJumin1(rs.getString("jumin1"));
				memberDto.setJumin2(rs.getString("jumin2"));
				memberDto.setPhone1(rs.getString("phone1"));
				memberDto.setPhone2(rs.getString("phone2"));
				memberDto.setPhone3(rs.getString("phone3"));
				memberDto.setEmail1(rs.getString("email1"));
				memberDto.setEmail2(rs.getString("email2"));
				memberDto.setPostcode(rs.getString("postcode"));
				memberDto.setAddress(rs.getString("address"));
				memberDto.setDetailAddress(rs.getString("detailAddress"));
				memberDto.setExtraAddress(rs.getString("extraAddress"));
				memberDto.setRegiDate(rs.getDate("regiDate"));
				memberList.add(memberDto);
			}//while
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//try-catch-finally
		return memberList;
	}//getSelectAll
	
	public MemberDTO getSelectOne(MemberDTO paramDto) {
		MemberDTO memberDto = new MemberDTO();
		conn = DB.dbConn();
		try {
			String sql = "SELECT * FROM member WHERE no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, paramDto.getNo());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				memberDto.setNo(rs.getInt("no"));
				memberDto.setId(rs.getString("id"));
				memberDto.setPasswd(rs.getString("passwd"));
				memberDto.setName(rs.getString("name"));
				memberDto.setJumin1(rs.getString("jumin1"));
				memberDto.setJumin2(rs.getString("jumin2"));
				memberDto.setPhone1(rs.getString("phone1"));
				memberDto.setPhone2(rs.getString("phone2"));
				memberDto.setPhone3(rs.getString("phone3"));
				memberDto.setEmail1(rs.getString("email1"));
				memberDto.setEmail2(rs.getString("email2"));
				memberDto.setPostcode(rs.getString("postcode"));
				memberDto.setAddress(rs.getString("address"));
				memberDto.setDetailAddress(rs.getString("detailAddress"));
				memberDto.setExtraAddress(rs.getString("extraAddress"));
				memberDto.setRegiDate(rs.getDate("regiDate"));
			}//if
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//try-catch-finally
		return memberDto;
	}//getSelectOne
	
	public int setInsert(MemberDTO paramDto) {
		int result = 0;
		conn = DB.dbConn();
		try {
			String sql = "INSERT INTO member VALUES (seq_member.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, SYSDATE)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, paramDto.getId());
			pstmt.setString(2, paramDto.getPasswd());
			pstmt.setString(3, paramDto.getName());
			pstmt.setString(4, paramDto.getJumin1());
			pstmt.setString(5, paramDto.getJumin2());
			pstmt.setString(6, paramDto.getPhone1());
			pstmt.setString(7, paramDto.getPhone2());
			pstmt.setString(8, paramDto.getPhone3());
			pstmt.setString(9, paramDto.getEmail1());
			pstmt.setString(10, paramDto.getEmail2());
			pstmt.setString(11, paramDto.getPostcode());
			pstmt.setString(12, paramDto.getAddress());
			pstmt.setString(13, paramDto.getDetailAddress());
			pstmt.setString(14, paramDto.getExtraAddress());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//try-catch-finally
		return result;
	}//setInsert
	
	public int setUpdate(MemberDTO paramDto) {
		int result = 0;
		conn = DB.dbConn();
		try {
			String sql = "UPDATE member "
					+ "SET phone1 = ?, phone2 = ?, phone3 = ?, email1 = ?, email2 = ?, postcode = ?, address = ?, detailAddress = ?, extraAddress = ? "
					+ "WHERE no = ? AND passwd = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, paramDto.getPhone1());
			pstmt.setString(2, paramDto.getPhone2());
			pstmt.setString(3, paramDto.getPhone3());
			pstmt.setString(4, paramDto.getEmail1());
			pstmt.setString(5, paramDto.getEmail2());
			pstmt.setString(6, paramDto.getPostcode());
			pstmt.setString(7, paramDto.getAddress());
			pstmt.setString(8, paramDto.getDetailAddress());
			pstmt.setString(9, paramDto.getExtraAddress());
			pstmt.setInt(10, paramDto.getNo());
			pstmt.setString(11, paramDto.getPasswd());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//try-catch-finally
		return result;
	}//setUpdate
	
	public int setDelete(MemberDTO paramDto) {
		int result = 0;
		conn = DB.dbConn();
		try {
			String sql = "DELETE FROM member WHERE no = ? AND passwd = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, paramDto.getNo());
			pstmt.setString(2, paramDto.getPasswd());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//try-catch-finally
		return result;
	}//setDelete
}//MemberDAO
