package book.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import book.model.dto.BookDTO;
import config.DB;

public class BookDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public ArrayList<BookDTO> getSelectAll() {
		ArrayList<BookDTO> list = new ArrayList<>();
		conn = DB.dbConn();
		try {
			String sql = "SELECT * FROM book ORDER BY no DESC";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				BookDTO dto = new BookDTO();
				dto.setNo(rs.getInt("no"));
				dto.setSubject(rs.getString("subject"));
				dto.setAuthor(rs.getString("author"));
				dto.setCreated(rs.getDate("created"));
				dto.setProfile(rs.getString("profile"));
				dto.setRegiDate(rs.getDate("regiDate"));
				list.add(dto);
			}//while
		} catch (Exception e) {
//			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//try-catch-finally
		return list;
	}//getSelectAll
	
	public BookDTO getSelectOne(BookDTO paramDto) {
		BookDTO dto = new BookDTO();
		conn = DB.dbConn();
		try {
			String sql = "SELECT * FROM book WHERE no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, paramDto.getNo());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				dto.setNo(rs.getInt("no"));
				dto.setSubject(rs.getString("subject"));
				dto.setAuthor(rs.getString("author"));
				dto.setCreated(rs.getDate("created"));
				dto.setProfile(rs.getString("profile"));
				dto.setRegiDate(rs.getDate("regiDate"));
			}//if
		} catch (Exception e) {
//			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//try-catch-finally
		return dto;
	}//getSelectOne
	
	public int setInsert(BookDTO paramDto) {
		int result = 0;
		conn = DB.dbConn();
		try {
			String sql = "INSERT INTO book VALUES (seq_book.NEXTVAL, ?, ?, ?, ?, SYSDATE)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, paramDto.getSubject());
			pstmt.setString(2, paramDto.getAuthor());
			pstmt.setDate(3, paramDto.getCreated());
			pstmt.setString(4, paramDto.getProfile());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
//			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//try-catch-finally
		return result;
	}//setInsert
	
	public int setUpdate(BookDTO paramDto) {
		int result = 0;
		conn = DB.dbConn();
		try {
			String sql = "UPDATE book SET subject = ?, author = ?, created = ?, profile = ? WHERE no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, paramDto.getSubject());
			pstmt.setString(2, paramDto.getAuthor());
			pstmt.setDate(3, paramDto.getCreated());
			pstmt.setString(4, paramDto.getProfile());
			pstmt.setInt(5, paramDto.getNo());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
//			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//try-catch-finally
		return result;
	}//setUpdate
	
	public int setDelete(BookDTO paramDto) {
		int result = 0;
		conn = DB.dbConn();
		try {
			String sql = "DELETE FROM book WHERE no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, paramDto.getNo());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
//			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//try-catch-finally
		return result;
	}//setDelete
}//BookDAO
