package guestBook.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import config.DB;
import guestBook.model.dto.GuestBookDTO;

public class GuestBookDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String tableName = "guestBook";
	
	public String tableNameChecker(String tableName) {
		if (tableName == null) {
			return null;
		}//if
		
		tableName = tableName.replace(" ", "").replace(";", "");
		
		return tableName;
	}//tableNameChecker
	
	public ArrayList<GuestBookDTO> getSelectAll(String searchGubun, String searchData) {
		ArrayList<GuestBookDTO> guestBookList = new ArrayList<>();
		conn = DB.dbConn();
		try {
			String sql = "SELECT * FROM "+ tableNameChecker(tableName) +" WHERE 1 = 1";
			
			if (searchGubun.equals("name")) {
				sql += " AND name LIKE ? ";
			} else if (searchGubun.equals("content")) {
				sql += " AND content LIKE ? ";
			} else if (searchGubun.equals("name_content")) {
				// 연산자는 가까운거 혹은 좁은것이 우선시 된다
				sql += " AND (name LIKE ? OR content LIKE ?) ";
			}//if
			
			sql += "ORDER BY no DESC";
			
			pstmt = conn.prepareStatement(sql);
			
			if (searchGubun.equals("name")) {
				pstmt.setString(1, '%' + searchData + '%');
			} else if (searchGubun.equals("content")) {
				pstmt.setString(1, '%' + searchData + '%');
			} else if (searchGubun.equals("name_content")) {
				pstmt.setString(1, '%' + searchData + '%');
				pstmt.setString(2, '%' + searchData + '%');
			}//if
			
			rs = pstmt.executeQuery();
			while (rs.next()) {
				GuestBookDTO guestBookDto = new GuestBookDTO();
				guestBookDto.setNo(rs.getInt("no"));
				guestBookDto.setName(rs.getString("name"));
				guestBookDto.setEmail(rs.getString("email"));
				guestBookDto.setPasswd(rs.getString("passwd"));
				guestBookDto.setContent(rs.getString("content"));
				guestBookDto.setRegiDate(rs.getDate("regiDate"));
				guestBookDto.setMemberNo(rs.getInt("memberNo"));
				guestBookList.add(guestBookDto);
			}//while
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//try-catch-finally
		return guestBookList;
	}//getSelectAll
	
	public GuestBookDTO getSelectOne(GuestBookDTO paramDto) {
		GuestBookDTO guestBookDto = new GuestBookDTO();
		conn = DB.dbConn();
		try {
			String sql = "SELECT * FROM "+ tableNameChecker(tableName) +" WHERE no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, paramDto.getNo());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				guestBookDto.setNo(rs.getInt("no"));
				guestBookDto.setName(rs.getString("name"));
				guestBookDto.setEmail(rs.getString("email"));
				guestBookDto.setPasswd(rs.getString("passwd"));
				guestBookDto.setContent(rs.getString("content"));
				guestBookDto.setRegiDate(rs.getDate("regiDate"));
				guestBookDto.setMemberNo(rs.getInt("memberNo"));
			}//if
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//try-catch-finally
		return guestBookDto;
	}//getSelectOne
	
	public int setInsert(GuestBookDTO paramDto) {
		int result = 0;
		conn = DB.dbConn();
		try {
			String sql = "INSERT INTO "+ tableNameChecker(tableName) +" VALUES (seq_guestBook.NEXTVAL, ?, ?, ?, ?, SYSDATE, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, paramDto.getName());
			pstmt.setString(2, paramDto.getEmail());
			pstmt.setString(3, paramDto.getPasswd());
			pstmt.setString(4, paramDto.getContent());
			pstmt.setInt(5, paramDto.getMemberNo());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//try-catch-finally
		return result;
	}//setInsert
	
	public int setUpdate(GuestBookDTO paramDto) {
		int result = 0;
		conn = DB.dbConn();
		try {
			String sql = "UPDATE "+ tableNameChecker(tableName) +" SET email = ?, content = ? WHERE no = ? AND passwd = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, paramDto.getEmail());
			pstmt.setString(2, paramDto.getContent());
			pstmt.setInt(3, paramDto.getNo());
			pstmt.setString(4, paramDto.getPasswd());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//try-catch-finally
		return result;
	}//setUpdate
	
	public int setDelete(GuestBookDTO paramDto) {
		int result = 0;
		conn = DB.dbConn();
		try {
			String sql = "DELETE FROM "+ tableNameChecker(tableName) +" WHERE no = ? AND passwd = ?";
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
}//GuestBookDAO