package bookInfo.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bookInfo.model.dto.BookInfoDTO;
import config.DB;

public class BookInfoDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	String tableName_1 = "bookInfo";
	String tableName_2 = "bookAuthor";
	String tableName_3 = "bookProfile";
	
	public ArrayList<BookInfoDTO> getSelectAll() {
		ArrayList<BookInfoDTO> list = new ArrayList<>();
		conn = DB.dbConn();
		try {
			String sql = "SELECT bi.infoNo, bi.subject, bi.created, ba.author, bp.profile, bi.regiDate, bi.authorNo, bi.profileNo "
						+ "FROM "+ tableName_1 +" bi, "+ tableName_2 +" ba, "+ tableName_3 +" bp "
						+ "WHERE bi.authorNo = ba.authorNo AND bi.profileNo = bp.profileNo "
						+ "ORDER BY bi.infoNo DESC";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				BookInfoDTO resultDto = new BookInfoDTO();
				resultDto.setInfoNo(rs.getInt("infoNo"));
				resultDto.setSubject(rs.getString("subject"));
				resultDto.setCreated(rs.getDate("created"));
				resultDto.setAuthor(rs.getString("author"));
				resultDto.setProfile(rs.getString("profile"));
				resultDto.setRegiDate(rs.getDate("regiDate"));
				resultDto.setAuthorNo(rs.getInt("authorNo"));
				resultDto.setProfileNo(rs.getInt("profileNo"));
				list.add(resultDto);
			}//while
		} catch (Exception e) {
//			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//try-catch-finally
		return list;
	}//getSelectAll
	
	public BookInfoDTO getSelectOne(BookInfoDTO paramDto) {
		BookInfoDTO resultDto = new BookInfoDTO();
		conn = DB.dbConn();
		try {
			String sql = "SELECT bi.infoNo, bi.subject, bi.created, ba.author, bp.profile, bi.regiDate, bi.authorNo, bi.profileNo "
					+ "FROM "+ tableName_1 +" bi, "+ tableName_2 +" ba, "+ tableName_3 +" bp "
					+ "WHERE bi.authorNo = ba.authorNo AND bi.profileNo = bp.profileNo AND bi.infoNo = ?"
					+ "ORDER BY bi.infoNo DESC";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, paramDto.getInfoNo());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				resultDto.setInfoNo(rs.getInt("infoNo"));
				resultDto.setSubject(rs.getString("subject"));
				resultDto.setCreated(rs.getDate("created"));
				resultDto.setAuthor(rs.getString("author"));
				resultDto.setProfile(rs.getString("profile"));
				resultDto.setRegiDate(rs.getDate("regiDate"));
				resultDto.setAuthorNo(rs.getInt("authorNo"));
				resultDto.setProfileNo(rs.getInt("profileNo"));
			}//if
		} catch (Exception e) {
//			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//try-catch-finally
		return resultDto;
	}//getSelectOne
	
	public int setInsert(BookInfoDTO paramDto) {
		int result = 0;
		conn = DB.dbConn();
		try {
			String sql = "INSERT INTO "+ tableName_1 +" VALUES (seq_bookInfo.NEXTVAL, ?, ?, ?, ?, SYSDATE)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, paramDto.getSubject());
			pstmt.setDate(2, paramDto.getCreated());
			pstmt.setInt(3, paramDto.getAuthorNo());
			pstmt.setInt(4, paramDto.getProfileNo());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
//			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//try-catch-finally
		return result;
	}//setInsert
	
	public int setUpdate(BookInfoDTO paramDto) {
		conn = DB.dbConn();
		int result = 0;
		try {
			String sql = "UPDATE " + tableName_1 + " SET subject = ?, created = ?, authorNo = ?, profileNo = ? WHERE infoNo = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, paramDto.getSubject());
			pstmt.setDate(2, paramDto.getCreated());
			pstmt.setInt(3, paramDto.getAuthorNo());
			pstmt.setInt(4, paramDto.getProfileNo());
			pstmt.setInt(5, paramDto.getInfoNo());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
//			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//try-catch-finally
		return result;
	}//setUpdate
	
	public int setDelete(BookInfoDTO paramDto) {
		conn = DB.dbConn();
		int result = 0;
		try {
			String sql = "DELETE FROM " + tableName_1 + " WHERE infoNo = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, paramDto.getInfoNo());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
//			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//try-catch-finally
		return result;
	}//setDelete
}//BookInfoDAO
