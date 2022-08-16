package bookProfile.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bookProfile.model.dto.BookProfileDTO;
import config.DB;

public class BookProfileDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	String tableName_1 = "bookProfile";
	
	public ArrayList<BookProfileDTO> getSelectAll() {
		ArrayList<BookProfileDTO> list = new ArrayList<>();
		conn = DB.dbConn();
		try {
			String sql = "SELECT * FROM " + tableName_1 + " ORDER BY profileNo DESC";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				BookProfileDTO resultDto = new BookProfileDTO();
				resultDto.setProfileNo(rs.getInt("profileNo"));
				resultDto.setProfile(rs.getString("profile"));
				resultDto.setRegiDate(rs.getDate("regiDate"));
				list.add(resultDto);
			}//while
		} catch (Exception e) {
//			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//try-catch-finally
		return list;
	}//getSelectAll
	
	public BookProfileDTO getSelectOne(BookProfileDTO paramDto) {
		BookProfileDTO resultDto = new BookProfileDTO();
		conn = DB.dbConn();
		try {
			String sql = "SELECT * FROM " + tableName_1 + " WHERE profileNo = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, paramDto.getProfileNo());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				resultDto.setProfileNo(rs.getInt("profileNo"));
				resultDto.setProfile(rs.getString("profile"));
				resultDto.setRegiDate(rs.getDate("regiDate"));
			}//if
		} catch (Exception e) {
//			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//try-catch-finally
		return resultDto;
	}//getSelectOne
	
	public int setInsert(BookProfileDTO paramDto) {
		int result = 0;
		conn = DB.dbConn();
		try {
			String sql = "INSERT INTO "+ tableName_1 +" VALUES (seq_bookProfile.NEXTVAL, ?, SYSDATE)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, paramDto.getProfile());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
//			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//try-catch-finally
		return result;
	}//setInsert
	
	public int setUpdate(BookProfileDTO paramDto) {
		conn = DB.dbConn();
		int result = 0;
		try {
			String sql = "UPDATE " + tableName_1 + " SET profile = ? WHERE profileNo = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, paramDto.getProfile());
			pstmt.setInt(2, paramDto.getProfileNo());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
//			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//try-catch-finally
		return result;
	}//setUpdate
	
	public int setDelete(BookProfileDTO paramDto) {
		conn = DB.dbConn();
		int result = 0;
		try {
			String sql = "DELETE FROM " + tableName_1 + " WHERE profileNo = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, paramDto.getProfileNo());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
//			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//try-catch-finally
		return result;
	}//setDelete
}//BookProfileDAO
