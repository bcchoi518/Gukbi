package memberBasic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import config.DB;

public class MemberBasicDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public ArrayList<MemberBasicDTO> getSelectAll() {
		ArrayList<MemberBasicDTO> list = new ArrayList<>();
		try {
			conn = DB.dbConn();
//			String sql = "SELECT ";
//			pstmt = conn.prepareStatement(sql);
//			rs = pstmt.executeQuery();
			while (rs.next()) {
				
			}//while
		} catch (Exception e) {
//			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//try-catch-finally
		return list;
	}//getSelectAll
	
	public void getSelectOne() {
		System.out.println("-- getSelectOne --");
	}//getSelectOne
	
	public int setInsert(MemberBasicDTO paramDto) {
		int result = 0;
		try {
			conn = DB.dbConn();
			String sql = "INSERT INTO memberBasic VALUES (seq_memberBasic.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, SYSDATE)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, paramDto.getId());
			pstmt.setString(2, paramDto.getPasswd());
			pstmt.setString(3, paramDto.getName());
			pstmt.setString(4, paramDto.getPhone());
			pstmt.setString(5, paramDto.getEmail());
			pstmt.setString(6, paramDto.getJumin());
			pstmt.setString(7, paramDto.getJuso1());
			pstmt.setString(8, paramDto.getJuso2());
			pstmt.setString(9, paramDto.getJuso3());
			pstmt.setString(10, paramDto.getJuso4());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
//			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//try-catch-finally
		return result;
	}//setInsert
	
	public int setUpdate(MemberBasicDTO paramDto) {
		int result = 0;
		try {
			conn = DB.dbConn();
//			String sql = "UPDATE memberBasic SET ? = ? WHERE id = ?";
//			pstmt = conn.prepareStatement(sql);
//			result = pstmt.executeUpdate();
		} catch (Exception e) {
//			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//try-catch-finally
		return result;
	}//setUpdate
	
	public int setDelete(MemberBasicDTO paramDto) {
		int result = 0;
		try {
			conn = DB.dbConn();
//			String sql = "DELETE FROM memberBasic WHERE id = ?";
//			pstmt = conn.prepareStatement(sql);
//			result = pstmt.executeUpdate();
		} catch (Exception e) {
//			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//try-catch-finally
		return result;
	}//setDelete
}//MemberBasicDAO
