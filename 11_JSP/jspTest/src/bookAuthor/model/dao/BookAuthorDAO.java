package bookAuthor.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bookAuthor.model.dto.BookAuthorDTO;
import config.DB;

public class BookAuthorDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	String tableName_1 = "bookAuthor";
	
	public ArrayList<BookAuthorDTO> getSelectAll() {
		ArrayList<BookAuthorDTO> list = new ArrayList<>();
		conn = DB.dbConn();
		try {
			String sql = "SELECT * FROM " + tableName_1 + " ORDER BY authorNo DESC";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				BookAuthorDTO resultDto = new BookAuthorDTO();
				resultDto.setAuthorNo(rs.getInt("authorNo"));
				resultDto.setAuthor(rs.getString("author"));
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
	
	public BookAuthorDTO getSelectOne(BookAuthorDTO paramDto) {
		BookAuthorDTO resultDto = new BookAuthorDTO();
		conn = DB.dbConn();
		try {
			String sql = "SELECT * FROM " + tableName_1 + " WHERE authorNo = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, paramDto.getAuthorNo());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				resultDto.setAuthorNo(rs.getInt("authorNo"));
				resultDto.setAuthor(rs.getString("author"));
				resultDto.setRegiDate(rs.getDate("regiDate"));
			}//if
		} catch (Exception e) {
//			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//try-catch-finally
		return resultDto;
	}//getSelectOne
	
	public int setInsert(BookAuthorDTO paramDto) {
		int result = 0;
		conn = DB.dbConn();
		try {
			String sql = "INSERT INTO "+ tableName_1 +" VALUES (seq_bookAuthor.NEXTVAL, ?, SYSDATE)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, paramDto.getAuthor());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
//			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//try-catch-finally
		return result;
	}//setInsert
	
	public int setUpdate(BookAuthorDTO paramDto) {
		conn = DB.dbConn();
		int result = 0;
		try {
			String sql = "UPDATE " + tableName_1 + " SET author = ? WHERE authorNo = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, paramDto.getAuthor());
			pstmt.setInt(2, paramDto.getAuthorNo());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
//			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//try-catch-finally
		return result;
	}//setUpdate
	
	public int setDelete(BookAuthorDTO paramDto) {
		conn = DB.dbConn();
		int result = 0;
		try {
			String sql = "DELETE FROM " + tableName_1 + " WHERE authorNo = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, paramDto.getAuthorNo());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
//			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//try-catch-finally
		return result;
	}//setDelete
}//BookAuthorDAO
